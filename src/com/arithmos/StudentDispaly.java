package com.arithmos;

import java.awt.EventQueue;

import java.sql.*;
import java.util.Vector;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class StudentDispaly extends javax.swing.JFrame {

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new StudentDispaly().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDispaly() {
		initialize();
		displayAllStudents();
	}

	private void displayAllStudents() {
		String sql = "SELECT * FROM `student`";
		try {

            ResultSet studentSet = DB.search(sql);
            while (studentSet.next()) {
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                Vector <String> v = new Vector<String>();
                v.add(studentSet.getString(1));
                v.add(studentSet.getString(2));
                v.add(studentSet.getString(3));
                v.add(studentSet.getString(4));
                v.add(studentSet.getString(5));
                v.add(studentSet.getString(6));
                v.add(studentSet.getString(7));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();

		jLabel2.setText("jLabel2");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("View Students");

		jLabel1.setFont(new java.awt.Font("Dialog", 1, 36));
		jLabel1.setText("View All students");

		jLabel3.setText("Search student");

		jTable1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "First Name", "Last Name", "Date of Birth", "Email", "Address", "Phone"
			}
		));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("Search");

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Edit edit = new Edit();
				edit.setVisible(true);
			}
		});

		JButton btnDelete = new JButton("Delete");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGap(694)
							.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addGap(358)
							.addComponent(jLabel1))
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addGap(24)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 948, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
									.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))))
					.addGap(40))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(36)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton1))
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
}
