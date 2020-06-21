package com.arithmos;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.arithmos.modals.DBinitModal;

public class Initializer extends javax.swing.JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Initializer().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Initializer() {

		checkifinitialized();

	}

	private void checkifinitialized() {
		try {

			File file = new File(System.getProperty("user.home") + "\\dbinitfile.xml");
			if (file.exists()) {
				this.dispose();
				new StudentDispaly().setVisible(true);
			} else {
				initialize();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		dbNameTf = new javax.swing.JTextField();
		portTf = new javax.swing.JTextField();
		usernameTf = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		passwordTf = new javax.swing.JPasswordField();
		initDBbutton = new javax.swing.JButton();
		connectDBButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		jLabel1.setText("Database Connection Initializer");

		jLabel2.setText("Database Name");

		jLabel3.setText("Port");

		jLabel4.setText("Username");

		jLabel5.setText("Password");

		initDBbutton.setText("Initialize Database");
		initDBbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initDBbuttonActionPerformed(evt);
			}
		});

		connectDBButton.setText("Connect");
		connectDBButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				connectDBButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(250, 250, 250).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(52, 52, 52)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel3).addComponent(jLabel2).addComponent(jLabel4)
										.addComponent(jLabel5))
								.addGap(72, 72, 72)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(dbNameTf).addComponent(portTf).addComponent(usernameTf)
										.addComponent(passwordTf, javax.swing.GroupLayout.DEFAULT_SIZE, 485,
												Short.MAX_VALUE)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap().addComponent(initDBbutton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(connectDBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(52, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(19, 19, 19)
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(33, 33, 33)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(dbNameTf, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(29, 29, 29)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(portTf, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(29, 29, 29)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
						.addComponent(usernameTf, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(34, 34, 34)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5)
						.addComponent(passwordTf, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(27, 27, 27)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(initDBbutton).addComponent(connectDBButton))
				.addContainerGap(24, Short.MAX_VALUE)));

		pack();
	}

	private void initDBbuttonActionPerformed(java.awt.event.ActionEvent evt) {
//		JFileChooser chooser = new JFileChooser();
		if (!(dbNameTf.getText().equals("") || portTf.getText().equals("") || usernameTf.getText().equals(""))) {

			DBinitModal dBinitModal = new DBinitModal();
			dBinitModal.setDbNameTf(dbNameTf.getText());
			dBinitModal.setPortTf(portTf.getText());
			dBinitModal.setUsernameTf(usernameTf.getText());
			dBinitModal.setPasswordTf(passwordTf.getText());

			try {

				File file = new File(System.getProperty("user.home") + "\\dbinitfile.xml");
				file.createNewFile();
				JAXBContext jaxbContext = JAXBContext.newInstance(DBinitModal.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				jaxbMarshaller.marshal(dBinitModal, file);
				jaxbMarshaller.marshal(dBinitModal, System.out);
				
				this.dispose();
				new StudentDispaly().setVisible(true);

			} catch (JAXBException e) {
				JOptionPane.showMessageDialog(null, "could not read the file");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "could not find the file");
			}

			// i cannot test this here
//			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//				File selectedFile = chooser.getSelectedFile();
//				String path = selectedFile.getAbsolutePath().replace("\\","\\\\"); 
//				System.out.println(path);
//
//				try {
//
//					File file = new File(System.getProperty("user.home") + "\\dbinitfile.xml");
//					JAXBContext jaxbContext = JAXBContext.newInstance(DBinitModal.class);
//
//					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//					DBinitModal dbinitmodal = (DBinitModal) jaxbUnmarshaller.unmarshal(file);
//					String[] executeCmd = new String[] { "mysql", "--user=" + dbinitmodal.getUsernameTf(), "--password=" + dbinitmodal.getPasswordTf(),
//							dbinitmodal.getDbNameTf(), "-e", " source " + path };
//					Process runtimeProcess;
//					try {
//						runtimeProcess = Runtime.getRuntime().exec(executeCmd);
//						int processComplete = runtimeProcess.waitFor();
//						if (processComplete == 0) {
//							System.out.println("Backup restored successfully");
//
//						} else {
//							System.out.println("Could not restore the backup");
//						}
//					} catch (Exception ex) {
//						JOptionPane.showMessageDialog(null, "MySQL may not be installed");
//					}
//					System.out.println(dbinitmodal);
//
//				} catch (JAXBException e) {
//					JOptionPane.showMessageDialog(null, "cannot read the data file for database inforamtion");
//				}
//
//			} else {
//				System.exit(0);
//			}
		} else {
			JOptionPane.showMessageDialog(null, "please fill out nessasary fileds");
		}
	}

	private void connectDBButtonActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private javax.swing.JButton connectDBButton;
	private javax.swing.JTextField dbNameTf;
	private javax.swing.JButton initDBbutton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPasswordField passwordTf;
	private javax.swing.JTextField portTf;
	private javax.swing.JTextField usernameTf;

}
