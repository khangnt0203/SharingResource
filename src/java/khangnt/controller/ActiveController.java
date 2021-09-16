/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
public class ActiveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String emailTo = request.getParameter("userid").trim();

	String host = "smtp.gmail.com";

	//create code confirm
	Random random = new Random();
	int code = random.nextInt(999999);
	System.out.println(code);

	// Get properties object
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.socketFactory.port", 465);
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.port", 587);

	HttpSession ses = request.getSession();
	ses.setAttribute("CODE", code);

	//load Email information from properties file
	InputStream in = getServletContext().getResourceAsStream("/WEB-INF/emailInfo.properties");
	Properties prop = new Properties();

	prop.load(in);

	String email = prop.getProperty("email");
	String password = prop.getProperty("password");

	// get Session
	Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(email, password);
	    }
	});

	// compose message
	try {
	    MimeMessage message = new MimeMessage(session);

	    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));

	    message.setSubject("Active your account");
	    message.setText("Your code is: " + code);

	    // send message
	    Transport.send(message);
	    System.out.println("Sent message successfully....");
	} catch (MessagingException ex) {
	    Logger.getLogger(ActiveController.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    request.getRequestDispatcher("confirm.jsp").forward(request, response);
	}
    }

}
