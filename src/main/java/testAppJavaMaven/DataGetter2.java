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
		return "user3";		
	}
	
	public void setString(String getset) {
		this.getset = getset;
	}
	
	

}