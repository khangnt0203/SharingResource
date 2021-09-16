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

/**
 *
 * @author 
 */
public class PagingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "SearchController";
        try {
            String action = request.getParameter("btnAction");
            HttpSession session = request.getSession();
            int previous = Integer.parseInt(request.getParameter("offset"));
            int next = previous + 20;
            if (action.equals("previous")) {
                if (previous > 0) {
                    next = previous;
                    previous -= 20;
                }
            } else {
                previous = next;
                next += 20;
            }
            session.setAttribute("offsetPage", previous);
            session.setAttribute("nextPage", next);
        } catch (Exception e) {
            log("ERROR at PagingController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
