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
public class DataCases extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        
        out.println("<HTML><BODY><p><b>Test Application</b></p>");
        
        // print form
        out.println("<p>Enter your credentials to log in</p>" 
        		+ "<FORM action='" + request.getContextPath() + "/datacases' method='POST'>"
        		+ "<TABLE><TR><TD>User id:</TD><TD><input name='userid'></TD></TR>"
        		+ "<TR><TD>Password:</TD><TD><input name='password'></TD></TR>"
        		+ "<TR><TD></TD><TD><input type='submit'></TD></TR></TABLE>"
        		+ "</BODY></HTML>"); 
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		out.println("CASES1");
		out.println(retrieve());
		out.println(retrieve2());
		out.println(retrieve3());
		out.println(retrieve4());
		out.println(retrieve5());
		out.println("CASES2");
       
	}
	
	public String getTableName() {
		
		String dbvalue=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from users where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery(sql);  
            
             
            while(rs.next()) {
            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
            	dbvalue = rs.getNString(3);
            }
            connection.close();
    
            
        } 
		catch(Exception e){ 
			System.out.println(e);
		}  	 
		
		
		return dbvalue;
	}
	
	public String retrieve() {
		
		String dbvalue=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery(sql);  
            
             
            while(rs.next()) {
            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
            	dbvalue = rs.getString(3);
            }
            connection.close();
        	return dbvalue;
            
        } 
		catch(Exception e){ 
			System.out.println(e);
			return "error: " + e;
		}  	 
	}	
		
	public String retrieve2() {
			
			String dbvalue=null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

				String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
				PreparedStatement pstmt = connection.prepareStatement(sql); 
	            ResultSet rs = pstmt.executeQuery(sql);  
	            
	             
	            while(rs.next()) {
	            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
	            	dbvalue = rs.getString(3);
	            }
	            connection.close();
	        	return dbvalue;
	            
	        } 
			catch(Exception e){ 
				System.out.println(e);
				return "error: " + e;
			}  	 
		}
		
	public String retrieve3() {
				
				String dbvalue=null;
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

					String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
					PreparedStatement pstmt = connection.prepareStatement(sql); 
		            ResultSet rs = pstmt.executeQuery(sql);  
		            
		             
		            while(rs.next()) {
		            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
		            	dbvalue = rs.getString(3);
		            }
		            connection.close();
		        	return dbvalue;
		            
		        } 
				catch(Exception e){ 
					System.out.println(e);
					return "error: " + e;
				}  
		}
		
	public String retrieve4() {
					
					String dbvalue=null;
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");  
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

						String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
						PreparedStatement pstmt = connection.prepareStatement(sql); 
			            ResultSet rs = pstmt.executeQuery(sql);  
			            
			             
			            while(rs.next()) {
			            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
			            	dbvalue = rs.getString(3);
			            }
			            connection.close();
			        	return dbvalue;
			            
			        } 
					catch(Exception e){ 
						System.out.println(e);
						return "error: " + e;
					}  	 
	}
				
	public String retrieve5() {
					
					String dbvalue=null;
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");  
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

						String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
						PreparedStatement pstmt = connection.prepareStatement(sql); 
			            ResultSet rs = pstmt.executeQuery(sql);  
			            
			             
			            while(rs.next()) {
			            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
			            	dbvalue = rs.getString(3);
			            }
			            connection.close();
			        	return dbvalue;
			            
			        } 
					catch(Exception e){ 
						System.out.println(e);
						return "error: " + e;
					}  	 
	}
		
	public String retrieve6() {
						
		String dbvalue=null;
						
		try {
							
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(sql);  
				            
				             
			while(rs.next()) {
				 System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
				 dbvalue = rs.getString(3);
			}
			connection.close();
			return dbvalue;
				            
		} 
		catch(Exception e){ 
			System.out.println(e);
			return "error: " + e;
		}  
	}

	public String retrieve7() {
		
		String dbvalue=null;
						
		try {
							
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(sql);  
				            
				             
			while(rs.next()) {
				 System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
				 dbvalue = rs.getString(3);
			}
			connection.close();
			return dbvalue;
				            
		} 
		catch(Exception e){ 
			System.out.println(e);
			return "error: " + e;
		}  
	}

	public String retrieve8() {
		
		String dbvalue=null;
						
		try {
							
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(sql);  
				            
				             
			while(rs.next()) {
				 System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
				 dbvalue = rs.getString(3);
			}
			connection.close();
			return dbvalue;
				            
		} 
		catch(Exception e){ 
			System.out.println(e);
			return "error: " + e;
		}  
	}

	public String retrieve9() {
		
		String dbvalue=null;
						
		try {
							
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(sql);  
				            
				             
			while(rs.next()) {
				 System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
				 dbvalue = rs.getString(3);
			}
			connection.close();
			return dbvalue;
				            
		} 
		catch(Exception e){ 
			System.out.println(e);
			return "error: " + e;
		}  
	}
	
	public String retrieve10() {
		
		String dbvalue=null;
						
		try {
							
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password

			String sql = "select * from " + getTableName() + " where userid = '" + "user1" + "' AND password='" + "password1" + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(sql);  
				            
				             
			while(rs.next()) {
				 System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
				 dbvalue = rs.getString(3);
			}
			connection.close();
			return dbvalue;
				            
		} 
		catch(Exception e){ 
			System.out.println(e);
			return "error: " + e;
		}  
	}
	
}