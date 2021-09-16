/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khangnt.dao.ResourceDAO;
import khangnt.dto.ResourceDTO;

/**
 *
 * @author ACER
 */
public class DisplayFirstListController extends HttpServlet {

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
	
	try {
            String name = "";
            String category = "";
            int usingDate = 0;
            HttpSession session = request.getSession();
            session.setAttribute("offsetPage", 0);
            session.setAttribute("nextPage", 21);

            ResourceDAO dao = new ResourceDAO();
            List<ResourceDTO> listResource = dao.searchResource(category, name, usingDate, 0, 21);
            List<String> listCategory = dao.getListCategory();

            request.setAttribute("RESOURCES", listResource);
            request.setAttribute("CATEGORYS", listCategory);
        } catch (Exception e) {
            log("Error at DisplayFirstController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
