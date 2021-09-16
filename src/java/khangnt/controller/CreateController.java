/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khangnt.dao.UserDAO;
import khangnt.dto.UserDTO;

/**
 *
 * @author ACER
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "ActiveController";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        String url = ERROR;
        try {
            String userID = request.getParameter("userid");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String name = request.getParameter("name");
	    
	    //default value of new account
            String role = "2";
            String status = "new";

            UserDTO dto = new UserDTO(userID, password, name, phone, address, status, role);
            UserDAO dao = new UserDAO();

            HttpSession session = request.getSession();
            boolean check = dao.checkUserId(userID);

            if (check) {
                request.setAttribute("ERROR", "Has exited");
            } else {
                boolean checkCreate = dao.createAccount(dto);
                
                if (checkCreate) {
                    dto.setId(dao.getID(userID));
                    request.setAttribute("NOTIFY", "Create successful");
                    session.setAttribute("INFO", dto);
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

}
