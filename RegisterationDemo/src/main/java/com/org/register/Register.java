package com.org.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			 System.out.println("test");
			 response.setContentType("text/html");
			 PrintWriter ou = response.getWriter();

			 String na=request.getParameter("userName");
			 
			 String co=request.getParameter("userCountry");
			 String em=request.getParameter("userEmail"); 
			 String pa=request.getParameter("userPass");


			  
			 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");

			 PreparedStatement ps=con.prepareStatement("insert into registeruser values(?,?,?,?)");

			 ps.setString(1,na);
			 ps.setString(2,pa);
			 ps.setString(3,em);
			 ps.setString(4,co);
			
			 

			 int i=ps.executeUpdate();
			 if(i>0)
			 ou.print("You are successfully registered...");

			 System.out.println("test");
			 }catch (Exception e2) {System.out.println(e2);}

			 ou.close();
		
	}

}
