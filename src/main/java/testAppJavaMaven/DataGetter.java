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
public class DataGetter extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String getset;
	
	public String getString() {
		return getset;		
	}
	
	public void setString(String getset) {
		this.getset = getset;
	}
	
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        
        out.println("<HTML><BODY><p><b>Test Application</b></p>");
        
        // print form
        out.println("<p>Enter your credentials to log in</p>" 
        		+ "<FORM action='" + request.getContextPath() + "/datagetter' method='POST'>"
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
		
		setString(userid);
		out.println("<br>userid: " + userid);
		String userid2;
		userid2 = DataGetter2.getString();
		out.println("<br>userid2: " + userid2);
  
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password
			
        	out.println("<p><b>Results:</b></p>");

			String sql = "select * from users where userid = '" + userid2 + "'"; //AND password='" + password + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery(sql);  
            
             
            while(rs.next()) {
            	out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS

            }
            connection.close();
            
     		
        	out.println("<br><br><p align='left'><font color='red'><b><i>SQL:</b> " + sql + "<i></font></p>");
            out.println("</BODY></HTML>");
            
        } 
		catch(Exception e){ 
			out.println(e); 
			System.out.println(e);
		}  	        
	}
}