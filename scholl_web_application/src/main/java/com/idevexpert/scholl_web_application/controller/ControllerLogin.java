/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.idevexpert.scholl_web_application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet(name = "ControllerLogin")
public class ControllerLogin extends HttpServlet {

    public Connection ConnectionC;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    private static final String URL = "jdbc:mysql://localhost:3306/school_proyect_web_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void init()
            throws ServletException {

        try {
            ConnectionC = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            ConnectionC = null;
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("loginService")) {
            request.getSession().setAttribute("dashboard", "login");
            response.sendRedirect("index.jsp");
        }

        if (action.equalsIgnoreCase("loginService")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            boolean result = ConnectionC.createStatement().execute(""
                    + "SELECT * FROM school_proyect_web_db.accounts WHERE "
                    + " username = '" + username + "'  AND password = '" + password + "'");
            if (result) {
                response.sendRedirect(request.getContextPath() + "/admin");
            
            } else { 
                RequestDispatcher dispatchersShowEmployee = request.getRequestDispatcher("index.jsp");
                dispatchersShowEmployee.forward(request, response);
             
            }

        }
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

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerStudent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

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
