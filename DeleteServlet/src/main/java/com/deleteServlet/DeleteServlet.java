package com.deleteServlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deletefromdb")
public class DeleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {

			Connection con = DBConnection.DBConnectionEstablished();

			String sqlcode = "delete from Employee where Empid=?";

			PreparedStatement st = con.prepareStatement(sqlcode);
			st.setInt(1, Integer.valueOf(request.getParameter("empid")));
			st.executeUpdate();
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
		
			out.println("Deleted Employee Details successfully ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
