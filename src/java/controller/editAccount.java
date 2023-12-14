/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "editAccount", urlPatterns = {"/editAc"})
public class editAccount extends HttpServlet {

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
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Account acc = dao.getAccountById(id);
        request.setAttribute("accEdit", acc);
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String sID, xUser, xPass, sIsSell, sIsAdmin;
        sID = request.getParameter("id");
        xUser = request.getParameter("user");
        xPass = request.getParameter("pass");
        sIsSell = request.getParameter("isSell");
        sIsAdmin = request.getParameter("isAdmin");
        int xIsSell = Integer.parseInt(sIsSell);
        int xIsAdmin = Integer.parseInt(sIsAdmin);
        int xID = Integer.parseInt(sID);
        Account account = new Account(xID, xUser, xPass, xIsSell, xIsAdmin);
        DAO dao = new DAO();
        String mess = "";
        if (dao.checkAccountExist(xUser) == null) {
            dao.updateAccountById(account);
            response.sendRedirect("managerAc");
        } else {
            mess = "User " + xUser + " is exist!";
            request.setAttribute("mess", mess);
            Account acc = dao.getAccountById(sID);
            request.setAttribute("accEdit", acc);
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        }
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
