package com.arithmos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Edit extends JFrame {

	private JPanel contentPane;
	public static JTextField txtFName;
	public static JTextField txtLname;
	public static JTextField txtDob;
	public static JTextField txtEmail;
	public static JTextField txtAddress;
	public static JTextField txtPhone;
	public static JTextField txtId;
	Connection connection;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Edit() {
	
		try {
			connection = DB.getMyConnection();
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 682, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(110, 172, 98, 16);
		contentPane.add(lblFName);
		
		JLabel lblBday = new JLabel("Date of Birth");
		lblBday.setBounds(110, 230, 98, 16);
		contentPane.add(lblBday);
		
		txtFName = new JTextField();
		txtFName.setBounds(227, 169, 247, 22);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBounds(227, 198, 247, 22);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setBounds(227, 227, 247, 22);
		contentPane.add(txtDob);
		txtDob.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int studentId = Integer.parseInt(txtId.getText());
		        try {
		        	Statement stmt = connection.createStatement();  
					stmt.execute("UPDATE tbl_student SET FirstName='" + txtFName.getText() + "',LastName='" + txtLname.getText() + "',Bday='" + txtDob.getText() + "',Email='"+txtEmail.getText()+"',Address='"+txtAddress.getText()+"',Phone='"+txtPhone.getText()+"' WHERE id=" + studentId + "");
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					dispose();
					StudentDispaly studentDisplay = new StudentDispaly();
					studentDisplay.setVisible(true);
		        } catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
		btnSave.setBounds(377, 360, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDispaly studentDisplay = new StudentDispaly();
				studentDisplay.setVisible(true);
				dispose();
			}
		});
		
		btnCancel.setBounds(479, 360, 97, 25);
		contentPane.add(btnCancel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(110, 201, 98, 16);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(110, 259, 98, 16);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(110, 288, 98, 16);
		contentPane.add(lblAddress);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(227, 256, 247, 22);
		contentPane.add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(227, 285, 247, 22);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(227, 314, 247, 22);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(110, 317, 98, 16);
		contentPane.add(lblPhone);
		
		JLabel lblId = new JLabel("Student ID");
		lblId.setBounds(110, 143, 84, 16);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(227, 140, 247, 22);
		contentPane.add(txtId);
		
		JLabel lblNewLabel = new JLabel("Edit Student ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(211, 42, 241, 56);
		contentPane.add(lblNewLabel);
	}
}
