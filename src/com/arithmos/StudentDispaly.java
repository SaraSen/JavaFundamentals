package com.arithmos;

import java.awt.EventQueue;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class StudentDispaly extends javax.swing.JFrame {

	/**
	 * Launch the application.
	 */
	private DefaultTableModel model;
	Connection connection = null;
	int selectedId;
	String fName;
	String lName;
	String email;
	String address;
	String phone;
	String bday;
	
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
		try {
			connection = DB.getMyConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		initialize();
		displayAllStudents();
	}

	private void displayAllStudents() {
		try {
			String query = "select * from tbl_student";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			
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
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
				int selectedRowIndex = jTable1.getSelectedRow();
				selectedId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
				fName = model.getValueAt(selectedRowIndex, 1).toString();
				lName = model.getValueAt(selectedRowIndex, 2).toString();
				bday = model.getValueAt(selectedRowIndex, 3).toString();
				email = model.getValueAt(selectedRowIndex, 4).toString();
				address = model.getValueAt(selectedRowIndex, 5).toString();
				phone = model.getValueAt(selectedRowIndex, 6).toString();
				 
			}
		});
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
				try {
				Edit edit = new Edit();
				Edit.txtFName.setText(fName);
				Edit.txtLname.setText(lName);
				Edit.txtDob.setText(bday.toString());
				Edit.txtEmail.setText(email);
				Edit.txtAddress.setText(address);
				Edit.txtPhone.setText(phone);
				edit.setVisible(true);
				dispose();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Please Select a row before edit");
				}
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int deleteOK = JOptionPane.showConfirmDialog(null, "Are you sure?");
				if(deleteOK==0) {
					try {
						Statement statement = connection.createStatement();
						statement.executeUpdate("DELETE FROM tbl_student WHERE id=" + selectedId + "");  
						displayAllStudents();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(694)
							.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addGap(358)
							.addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup()
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
