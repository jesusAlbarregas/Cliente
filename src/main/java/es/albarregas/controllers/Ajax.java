/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Persona;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jesus
 */
@WebServlet(name = "Ajax", urlPatterns = {"/Ajax"})
public class Ajax extends HttpServlet {

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
        String accion = request.getParameter("accion");
        JSONObject objeto = null;
        JSONArray arrayJSON = null;
        List retorno = new ArrayList();
        String[] lista = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        String[] siglas = {"L", "M", "X", "J", "V", "S", "D"};

        switch (accion) {
            case "mensaje":
                objeto = new JSONObject();
                objeto.put("mensaje", "Mensaje enviado desde el servidor");
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
            case "lista":

                for (String dia : lista) {
                    objeto = new JSONObject();
                    objeto.put("diaSemana", dia);
                    retorno.add(objeto);
                }
                arrayJSON = new JSONArray(retorno);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "tabla":

                for (int i = 0; i < lista.length; i++) {
                    objeto = new JSONObject();
                    objeto.put("diaSemana", lista[i]);
                    objeto.put("sigla", siglas[i]);

                    retorno.add(objeto);
                }
                arrayJSON = new JSONArray(retorno);
                response.setContentType("application/json");
                response.getWriter().print(arrayJSON);
                break;
            case "objetoJSON":
                Gson g = new Gson();
                Persona persona = g.fromJson(request.getParameter("arreglo"), Persona.class);
                
                objeto = new JSONObject();
                objeto.put("nombre", persona.getNombre());
                objeto.put("apellidos", persona.getApellidos());
                objeto.put("dni", persona.getDni());
                objeto.put("numHer", persona.getNumHer());
                objeto.put("fecha", persona.getFecha());

                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
                
            case "dni":
                
                int numero = Integer.parseInt(request.getParameter("dni"));
                String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
                objeto = new JSONObject();
                if(numero != 0) {
                    int indice = numero % 23;
                    objeto.put("tipo", "success");
                    objeto.put("letra", letras.substring(indice, indice + 1));
                } else {
                    objeto.put("tipo", "error");
                    objeto.put("letra", "El DNI no puede ser 0");
                }
                response.setContentType("application/json");
                response.getWriter().print(objeto);
                break;
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
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
