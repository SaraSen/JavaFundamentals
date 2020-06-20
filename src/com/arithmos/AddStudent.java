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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtDob;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private Connection connection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		try {
			connection = DB.getMyConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 664, 410);
		contentPane.add(panel);
		
		JLabel label = new JLabel("First Name");
		label.setBounds(57, 79, 98, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Date of Birth");
		label_1.setBounds(57, 146, 98, 16);
		panel.add(label_1);
		
		txtFName = new JTextField();
		txtFName.setColumns(10);
		txtFName.setBounds(145, 76, 247, 22);
		panel.add(txtFName);
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(145, 108, 247, 22);
		panel.add(txtLName);
		
		txtDob = new JTextField();
		txtDob.setColumns(10);
		txtDob.setBounds(145, 143, 247, 22);
		panel.add(txtDob);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Statement stmt = connection.createStatement();
					stmt.executeUpdate("INSERT INTO tbl_student(FirstName,LastName,Bday,Email,Address,phone) VALUES('" + txtFName.getText() + "','" + txtLName.getText() + "','" + txtDob.getText() + "','"+txtEmail.getText()+"','"+txtAddress.getText()+"','"+txtPhone.getText()+"')"); 
					JOptionPane.showMessageDialog(null, "Sudent Successfully Registered");
					dispose();
					StudentDispaly studentDisplay = new StudentDispaly();
					studentDisplay.setVisible(true);
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		button.setBounds(321, 349, 97, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(443, 349, 97, 25);
		panel.add(button_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(57, 111, 98, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setBounds(57, 178, 98, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setBounds(57, 210, 98, 16);
		panel.add(label_4);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(145, 175, 247, 22);
		panel.add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(145, 210, 247, 22);
		panel.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(145, 248, 247, 22);
		panel.add(txtPhone);
		
		JLabel label_5 = new JLabel("phone");
		label_5.setBounds(57, 251, 98, 16);
		panel.add(label_5);
	}
}
