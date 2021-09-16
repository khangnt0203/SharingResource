/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class BookingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "DisplayFirstListController";
        try {
            HttpSession session = request.getSession();
            UserDTO dto = (UserDTO) session.getAttribute("INFO");
            int userId = dto.getId();
            int resourceId = Integer.parseInt(request.getParameter("txtResourceId"));
            int numberRentalDay = Integer.parseInt(request.getParameter("numberRental"));

            RentalDTO rDto = new RentalDTO(resourceId, userId, numberRentalDay, "new");
            RentalDAO dao = new RentalDAO();
            if (dao.createRent(rDto)) {
                request.setAttribute("NOTIFY", "Success to booking");
            } else {
                request.setAttribute("ERROR", "Fail to booking");
            }
        } catch (Exception e) {
            log("ERROR at BookingController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}
