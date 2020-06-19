package com.arithmos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLname;
	private JTextField txtDob;
	private JTextField txtGrade;
	private JTextField txtEmail;
	private JTextField txtAddress;

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
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(57, 175, 98, 16);
		contentPane.add(lblGrade);
		
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
		btnSave.setBounds(308, 315, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(426, 315, 97, 25);
		contentPane.add(btnCancel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(57, 111, 98, 16);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(57, 210, 98, 16);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(57, 248, 98, 16);
		contentPane.add(lblAddress);
		
		txtGrade = new JTextField();
		txtGrade.setColumns(10);
		txtGrade.setBounds(145, 175, 247, 22);
		contentPane.add(txtGrade);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(145, 207, 247, 22);
		contentPane.add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(145, 245, 247, 22);
		contentPane.add(txtAddress);
	}
}
