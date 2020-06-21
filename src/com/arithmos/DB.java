package com.arithmos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.arithmos.modals.DBinitModal;

public class DB {
	private static Connection c;
	private static DBinitModal dbinitmodal;

	private static void unwrap() {
		try {

			File file = new File(System.getProperty("user.home") + "\\dbinitfile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(DBinitModal.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 dbinitmodal = (DBinitModal) jaxbUnmarshaller.unmarshal(file);
			System.out.println(dbinitmodal);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void createMyConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		unwrap();
		c = DriverManager.getConnection("jdbc:mysql://localhost:" + dbinitmodal.getPortTf() + "/" 
		+ dbinitmodal.getDbNameTf(), dbinitmodal.getUsernameTf(), dbinitmodal.getPasswordTf());
	}

	public static void iud(String sql) throws Exception {
		if (c == null) {
			createMyConnection();
		}
		c.createStatement().executeUpdate(sql);
	}

	public static ResultSet search(String sql) throws Exception {
		if (c == null) {
			createMyConnection();
		}
		return c.createStatement().executeQuery(sql);

	}

	public static Connection getMyConnection() throws Exception {
		if (c == null) {
			createMyConnection();
		}
		return c;
	}

	public static void main(String[] args) {

	}
}
