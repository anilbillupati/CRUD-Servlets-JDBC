package com.CreationServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insertiontoEmployee")
public class InsertionServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	  
    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
          
            Connection con = DBConnection.DBConnectionEstablished(); 
            
            String sqlcode="insert into Employee(Empid,Empname,Address,Salary) values(?,?,?,?)";
           
            PreparedStatement st = con.prepareStatement(sqlcode); 
  
            st.setInt(1, Integer.valueOf(request.getParameter("empid"))); 
            st.setString(2, request.getParameter("empname")); 
            st.setString(3, request.getParameter("empaddress")); 
            st.setInt(4, Integer.valueOf(request.getParameter("empsalary")));
            
            st.executeUpdate();
            st.close(); 
            con.close(); 
            PrintWriter out = response.getWriter(); 
            out.println("Added Employee Details "); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 

}
