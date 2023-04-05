package testAppJavaMaven;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet
@MultipartConfig
public class DataFileUpload extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        
        out.println("<HTML><BODY><p><b>Test Application</b></p>");
        

        
        // print form
        out.println("<p>Enter your credentials to log in</p>" 
        		+ "<FORM action='" + request.getContextPath() + "/datafileupload' method='POST'  enctype='multipart/form-data\'>"
        		+ "<TABLE><TR><TD>User id:</TD><TD><input name='userid'></TD></TR>"
        		+ "<TR><TD>Password:</TD><TD><input name='password'></TD></TR>"
        		+ "<TR><TD></TD><TD><input type='file' name='file' id='file'><input type='submit'></TD></TR></TABLE>"
        		+ "</BODY></HTML>"); 
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
		//String userid = request.getParameter("userid");
		//String password = request.getParameter("password");
		//String param1 = "CONSTANT1";
        String text = null;
	
       // String file = request.getParameter("file");
        //out.println("FILE: " + file);
        // https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-File-Upload-Servlet-Ajax-Example
        try{
        	Part filePart = request.getPart("file");

        	out.println("filepart1:" + filePart.getSize());
        	InputStream fileContent = filePart.getInputStream();
        	text = new String(fileContent.readAllBytes(), StandardCharsets.UTF_8);
        	out.println("fileContent: " + text);
        	//String fileName = filePart.getSubmittedFileName();
        	//out.println("filename: " + fileName);
        	//for (Part part : request.getParts()) {
        	//	part.write("C:\\dev\\AAAAAAAAA.txt");
        	//}
        	response.getWriter().print("The file uploaded sucessfully.");
        } catch(FileNotFoundException e) {
        	out.println(e);        	
        } catch(IOException e) {
        	out.println(e);
        } catch(ServletException e) {
        	out.println(e);
        } catch(Exception e) {
        	out.println(e);
        }
        
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password
			
        	out.println("<p><b>Results:</b></p>");

			String sql = "select * from users where userid = '" + text + "' AND password='" + text + "'";
			out.println("SQL: " + sql);
			PreparedStatement pstmt = connection.prepareStatement( sql.toString() ); 
            ResultSet rs = pstmt.executeQuery(sql.toString());  
            
             
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


	private String retrieve() {
		
		String returnStr = "CONSTANT";
		
		/*try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insecureapp","insecureapp","45EUlZOpL7");  // #7 Hardcoded password
			
			String sql = "select * from users where userid = 'aaa'";
			PreparedStatement pstmt = connection.prepareStatement( sql); 
            ResultSet rs = pstmt.executeQuery(sql);  
            
            while(rs.next()) {
            	System.out.println("<p>Name: " + rs.getString(3) + " " + rs.getString(2) + "<br>Address: " + rs.getString(4) + "<br>Phone no: " + rs.getString(5) + "</p>"); // #10 Stored XSS
            }
            returnStr = rs.getNString(3);
            connection.close();
        } 
		catch(Exception e){ 
			System.out.println(e);
		} */ 	
		
		return returnStr;
		
		
	}
}
