package edu.uic.ids.model;
import java.sql.Connection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.sql.DriverManager;
import java.sql.SQLException;

@ManagedBean(name="connect")
@SessionScoped
public class Connect {
	String error;
	String username;
	String password;
	static Connection con;
	String closeerror;

	
	public String setupcon()
	{
		error ="outside try";
	try{  
		Class.forName("com.mysql.jdbc.Driver");  ;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world",username,password);
//		con=DriverManager.getConnection(  
//				"jdbc:mysql://131.193.209.68/world",username,password);
		error = "Succes";
		
	}
	catch(Exception e)
	{
		System.out.println(e);
		error = "error";
	}
	return error;
	}

		
	
	public String closecon()
	{
		
		try {
            con.close();
            closeerror="Logged out";
        } catch (SQLException e) {closeerror="Connection not closed";}
		return closeerror;
		
	}
	public String getCloseerror() {
		return closeerror;
	}
	public void setCloseerror(String closeconnection) {
		this.closeerror = closeconnection;
	}

	
	
	public String getUsername() {
		return username;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
