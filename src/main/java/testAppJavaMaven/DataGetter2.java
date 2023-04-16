package testAppJavaMaven;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class DataGetter2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String getset;
	
	public static String getString() {

		String returnStr = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password
			

			String sql = "select * from users where userid = 'user2'"; //AND password='" + password + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery(sql);  
            
             
            while(rs.next()) {
            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
            	returnStr = rs.getString(3);
            }
            connection.close();
   
            
        } 
		catch(Exception e){ 
			System.out.println(e);
		}  	
		
		return returnStr;
		
	}
	
	public void setString(String getset) {
		this.getset = getset;
	}
	
	

}