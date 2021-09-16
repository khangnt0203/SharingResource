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
public class LoginController extends HttpServlet {

    private static final String SUCCESS = "DisplayFirstListController";
    private static final String FAIL = "index.jsp";
    private static final String ACTIVE = "ActiveController";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        String url = FAIL;
        boolean flag = true;
        String errorMessage = "";

        try {

            String action = req.getParameter("btnAction");
            HttpSession session = req.getSession();

            UserDAO dao = new UserDAO();

            if (action.equals("Continue to login")) {
                String email = req.getParameter("email").trim();
                UserDTO user = dao.loginByGoogle(email);
                user.setUserId(email);

                if (user.getRole() == null) {
                    flag = false;
                    errorMessage = "User is not found";
                } else if (user.getStatus().equals("deactive")) {
                    flag = false;
                    errorMessage = "Your account is not available";
                }

                if (!flag) {
                    req.setAttribute("ERROR", errorMessage);
                } else {
                    session.setAttribute("INFO", user);
                    if (user.getStatus().equals("new")) {
                        url = ACTIVE;
                    } else {
                        switch (user.getRole().trim()) {
                            case "manager":
                                url = SUCCESS;
                                break;
                            case "employee":
                                url = SUCCESS;
                                break;
                            default:
                                break;
                        }
                    }
                }
            } else {
                String userID = req.getParameter("txtUserID");
                String password = req.getParameter("txtPassword");
                UserDTO user = dao.loginByUserIdAndPassword(userID, password);

                user.setUserId(userID);

                if (user.getRole() == null) {
                    flag = false;
                    errorMessage = "User is not found";
                } else if (user.getStatus().equals("deactive")) {
                    flag = false;
                    errorMessage = "Your account is not availble";
                }

                if (!flag) {
                    req.setAttribute("ERROR", errorMessage);
                } else {
                    session.setAttribute("INFO", user);
                    if (user.getStatus().equals("new")) {
                        url = ACTIVE;
                    } else {
                        switch (user.getRole().trim()) {
                            case "manager":
                                url = SUCCESS;
                                break;
                            case "employee":
                                url = SUCCESS;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RequestDispatcher rd = req.getRequestDispatcher(url);
            rd.forward(req, resp);
        }
    }

}
