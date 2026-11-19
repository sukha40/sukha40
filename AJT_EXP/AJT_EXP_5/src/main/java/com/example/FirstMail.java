package com.example;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.mail.*; 
import javax.mail.internet.*;


@WebServlet("/FirstMail")
public class FirstMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String reciveremail = request.getParameter("email"); 
		String subject = request.getParameter("subject");
		String message = request.getParameter("message") ; 
		
		
		
		final String senderemail  = "shreyashk9006@gmail.com" ; 
		final String senderpass = "alqhjgeysnnaekqw"; 
		
		
		Properties p = new Properties() ; 
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.starttls.required", "true");
		
        Session s = Session.getInstance(p, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderemail, senderpass);
            }
        });
		
		try {
			
			 MimeMessage m = new MimeMessage(s);
	         m.setFrom(new InternetAddress(senderemail));
	         m.setRecipient(Message.RecipientType.TO, new InternetAddress(reciveremail));
	         m.setSubject(subject);
	         m.setText(message);
	         Transport.send(m);
	         
	         
	         response.getWriter().println("Email Sent Successfully!");
			
	         
		}catch (Exception e ){
			response.getWriter().println("Email Failed !") ; 
			 e.printStackTrace(response.getWriter());
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
