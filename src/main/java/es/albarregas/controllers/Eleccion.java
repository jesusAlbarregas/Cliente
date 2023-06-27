/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesus
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

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
        String opcion = request.getParameter("opcion");
        StringBuilder url = new StringBuilder();
        
        switch(opcion) {
            case "Ejer1":
                url.append("Ejercicio1.jsp");
                break;
            case "Ejer2":
                url.append("Ejercicio2.jsp");
                break;
            case "Ejer3":
                url.append("Ejercicio3.jsp");
                break; 
            case "Ejer4":
                url.append("Ejercicio4.jsp");
                break;
            case "Ejer5":
                url.append("Ejercicio5.jsp");
                break;
            case "Ejer6":
                url.append("Ejercicio6.jsp");
                break;
            case "Ejer7":
                url.append("Ejercicio7.jsp");
                break;
            case "Ejer8":
                url.append("Ejercicio8.jsp");
                break;
            case "Ejer9":
                url.append("Ejercicio9.jsp");
                break;
            case "EjerA":
                url.append("EjercicioA.jsp");
                break;
        }
        url.insert(0, "/JSP/");
        request.getRequestDispatcher(url.toString()).forward(request, response);
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
