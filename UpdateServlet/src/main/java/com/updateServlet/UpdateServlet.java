package com.updateServlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/updateempdetails")
public class UpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {

			Connection con = DBConnection.DBConnectionEstablished();

			String sqlcode = "update Employee set Empname= ? , Address=?  where Empid=?";

			PreparedStatement st = con.prepareStatement(sqlcode);

			
			st.setString(1, request.getParameter("empname"));
			st.setString(2, request.getParameter("empaddress"));
			st.setInt(3, Integer.valueOf(request.getParameter("empid")));
			st.executeUpdate();
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println("Updated Employee Details successfully ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
