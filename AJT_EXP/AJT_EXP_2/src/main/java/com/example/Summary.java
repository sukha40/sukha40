package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/summ")
public class Summary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ; 
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter() ; 
		
		out.println("<br><br>  Personal Deatails <br><br> ");
		out.println("Name : "+session.getAttribute("Name"));
		out.println("<br><br>  Age : "+session.getAttribute("Age"));
		out.println("<br><br> Gender : "+session.getAttribute("Gender"));
		
		out.println("<br><br>  Contact  Deatails <br><br> ");
		out.println("email : "+session.getAttribute("Email"));
		out.println("<br><br>  number : "+session.getAttribute("Number"));
		out.println("<br><br>  Address : "+session.getAttribute("Address"));
		
		out.println("<br><br> Educational Deatails <br><br> ");
		out.println("Qualification : "+session.getAttribute("Qualification"));
		out.println("<br><br>  College : "+session.getAttribute("College"));
		out.println("<br><br>  Percentage : "+session.getAttribute("Percentage"));
		
		session.invalidate();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
