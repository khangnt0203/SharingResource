/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khangnt.dao.UserDAO;
import khangnt.dto.UserDTO;
import khangnt.google.GoogleLoginUtils;
import khangnt.google.GooglePojo;

/**
 *
 * @author BlankSpace
 */
public class LoginGoogleServlet extends HttpServlet {

    private final String HOME_CONTROLLER = "DisplayFirstListController";
    private final String INVALID_PAGE = "index.jsp";
    private String url = INVALID_PAGE;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");

	//code return by google after user choose account
	String code = request.getParameter("code");
	try {
	    if (code != null && !code.isEmpty()) {
		String accessToken = GoogleLoginUtils.getToken(code);
		GooglePojo googlePojo = GoogleLoginUtils.getUserInfo(accessToken);

		String email = googlePojo.getEmail();
		UserDAO dao = new UserDAO();
		UserDTO result = dao.loginByGoogle(email);
                result.setUserId(email);
		if (result == null) {
		    String name = convertToFullname(googlePojo.getEmail());
		    dao.insertGoogleAccount(email, name);
		    result = dao.loginByGoogle(email);
		    HttpSession session = request.getSession();
		    session.setAttribute("INFO", result);
		} else {
		    HttpSession session = request.getSession();
		    session.setAttribute("INFO", result);
		}
		url = HOME_CONTROLLER;
	    }
	} catch (Exception e) {
	    log("LoginGoogleServlet _ Exception: " + e.getMessage());
	} finally {
	    request.getRequestDispatcher(url).forward(request, response);
	}
    }

    private String convertToFullname(String email) {
	return email.replace("@gmail.com", "");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
