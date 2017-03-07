package model;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;



public class Users {
	private Integer id;
	private String userName;
	private String password;

	public Users (String userName) {
		this.userName = userName;
	}

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/* Getters/Setters */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/* Methods */
	public void registerUser(Users aUser, String propFilePath) {
		Properties p = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void registerUser() {
		Database db = new Database();
		db.connect();
		db.addUser(this);
		db.close();
	}

	// validateUser
	public String validateUser(Users aUser, String propFilePath) {
		Properties p = new Properties();
		FileInputStream fis = null;
		String redirect = "Registration.jsp";

		try {
			fis = new FileInputStream(propFilePath);

			p.load(fis);

			// Check whether the username exists or not
			if(!p.containsKey(userName)) {			
				// Link-redirection
				redirect = "Registration.jsp";
			} else { // Check whether the password matches or not
				String pword = p.getProperty(userName);  
				if(!pword.equals(password)) {
					redirect = "Registration.jsp"; // Link-redirection
				} else {
					redirect = "CustomerHomePage.jsp"; // Link-redirection
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return redirect;
	}

	public String validateUser () {
		String redirect = "Registration.jsp";
		boolean exists = this.userExists();
		boolean passMatch = false;

		Database db = new Database();
		db.connect();

		if (!exists) {
			redirect = "Registration.jsp";
		} else {
			passMatch = db.userPassword(this.userName).equals(this.password);
			if (!passMatch) {
				redirect = "Registration.jsp";
			}
			else {
				redirect = "CustomerHomePage.jsp";
				this.id = db.getUserIdByUsername(this.userName);
			}
		}

		db.close();

		return redirect;
	}

	public boolean userExists(String username, String propFilePath, HttpServletResponse response) {
		Properties p = new Properties();
		FileInputStream fis = null;
		boolean result = false;

		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);

			// Check whether the username exists or not
			result = p.containsKey(userName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public boolean userExists () {
		boolean result = false;

		Database db = new Database();
		db.connect();
		result = db.userExists(this.userName);
		db.close();

		return result;
	}

	// removeUser


}
