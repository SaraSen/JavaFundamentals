package com.arithmos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Edit extends JFrame {

	private JPanel contentPane;
	public static JTextField txtFName;
	public static JTextField txtLname;
	public static JTextField txtDob;
	public static JTextField txtEmail;
	public static JTextField txtAddress;
	public static JTextField txtPhone;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(57, 79, 98, 16);
		contentPane.add(lblFName);
		
		JLabel lblBday = new JLabel("Date of Birth");
		lblBday.setBounds(57, 146, 98, 16);
		contentPane.add(lblBday);
		
		txtFName = new JTextField();
		txtFName.setBounds(145, 76, 247, 22);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBounds(145, 108, 247, 22);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setBounds(145, 143, 247, 22);
		contentPane.add(txtDob);
		txtDob.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(321, 349, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(443, 349, 97, 25);
		contentPane.add(btnCancel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(57, 111, 98, 16);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(57, 178, 98, 16);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(57, 210, 98, 16);
		contentPane.add(lblAddress);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(145, 175, 247, 22);
		contentPane.add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(145, 210, 247, 22);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(145, 248, 247, 22);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(57, 251, 98, 16);
		contentPane.add(lblPhone);
	}
}
