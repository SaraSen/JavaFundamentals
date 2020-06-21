package com.arithmos.modals;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DBinitModal {
	
	String dbNameTf;
	String portTf;
	String usernameTf;
	String passwordTf;
	
	public String getDbNameTf() {
		return dbNameTf;
	}
	
	@XmlElement
	public void setDbNameTf(String dbNameTf) {
		this.dbNameTf = dbNameTf;
	}
	
	
	public String getPortTf() {
		return portTf;
	}
	
	@XmlElement
	public void setPortTf(String portTf) {
		this.portTf = portTf;
	}
	
	
	public String getUsernameTf() {
		return usernameTf;
	}
	
	@XmlElement
	public void setUsernameTf(String usernameTf) {
		this.usernameTf = usernameTf;
	}
	
	
	public String getPasswordTf() {
		return passwordTf;
	}
	
	@XmlElement
	public void setPasswordTf(String passwordTf) {
		this.passwordTf = passwordTf;
	}

}
