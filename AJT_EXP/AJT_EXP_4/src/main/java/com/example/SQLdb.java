
package com.example;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SQLdb")
public class SQLdb extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
    	
        String action = request.getParameter("action");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

            if ("insert".equals(action)) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO students(name,email,course) VALUES(?,?,?)");
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("email"));
                ps.setString(3, request.getParameter("course"));
                int result = ps.executeUpdate();
                request.getSession().setAttribute("msg",result > 0 ? "Record Inserted Successfully!" : "Insert Failed!");
                ps.close();
            }

            else if ("update".equals(action)) {
                PreparedStatement ps = con.prepareStatement("UPDATE students SET name=?,email=?,course=? WHERE id=?");
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("email"));
                ps.setString(3, request.getParameter("course"));
                ps.setInt(4, Integer.parseInt(request.getParameter("id")));
                int result = ps.executeUpdate();
                request.getSession().setAttribute("msg",result > 0 ? "Record Updated Successfully!" : "Record Not Found!");
                ps.close();
            }

            else if ("delete".equals(action)) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                int result = ps.executeUpdate();
                request.getSession().setAttribute("msg",result > 0 ? "Record Deleted Successfully!" : "Record Not Found!");
                ps.close();
            }
            con.close();
            response.sendRedirect("Register.jsp");
        } catch (Exception e) {
            response.setContentType("text/html");
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
