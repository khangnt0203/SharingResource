/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khangnt.dao.RentalDAO;
import khangnt.dto.RentalDTO;
import khangnt.dto.UserDTO;

/**
 *
 * @author ACER
 */
public class SearchRequestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "request.jsp";
        try {
            String action = request.getParameter("btnAction");

            String name = request.getParameter("name");
            String rentDate = request.getParameter("rentDate");
            String status = request.getParameter("status");
            if (status == null) {
                status = "";
            }
            HttpSession session = request.getSession();
            int offsetPage = (int) session.getAttribute("offsetPage");
            int nextPage = (int) session.getAttribute("nextPage");
            UserDTO user = (UserDTO) session.getAttribute("INFO");
            String userId = user.getUserId();
            if (user.getRole().equals("manager")) {
                userId = "";
            }
            if (action.equals("searchRequest")) {
                offsetPage = 0;
                nextPage = 21;
            }
            String day = "";
            try {
                day = Date.valueOf(rentDate).toString();

            } catch (Exception e) {
                day = "";
            }
            RentalDAO dao = new RentalDAO();
            List<RentalDTO> listRental = dao.searchRentHistory(userId, name, day, status, offsetPage, nextPage);

            request.setAttribute("REQUESTS", listRental);
            request.setAttribute("NAME_SEARCH", name);
            request.setAttribute("RENT_DATE", dao);
            request.setAttribute("STATUS", status);
        } catch (Exception e) {
            log("Error at SearchRequestController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}
