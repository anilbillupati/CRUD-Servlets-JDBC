package com.creationtiontable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateTable extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Initialize the database
			Connection con = DBConnection.DBConnectionEstablished();
			String sqlcode = "create table Employee(Empid int ,Empname varchar(100),Address varchar(100),Salary int )";
			PreparedStatement st = con.prepareStatement(sqlcode);
			st.executeUpdate();
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println("cool program Executed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
