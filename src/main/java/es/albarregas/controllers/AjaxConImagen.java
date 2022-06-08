/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Usuario;
import es.albarregas.models.Utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jesus
 */
@WebServlet(name = "AjaxConImagen", urlPatterns = {"/AjaxConImagen"})
public class AjaxConImagen extends HttpServlet {

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
        String nombreAvatar;
        JSONObject objeto = new JSONObject();

        ServletContext sc = getServletContext();

        Usuario usuario = new Usuario();

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            System.out.println("Fallo al cargar los campos del formulario: " + ex.getMessage());
            Logger.getLogger(AjaxConImagen.class.getName()).log(Level.SEVERE, null, ex);

        }
        boolean error = false;
        String rutaImagen = null;
        File fichero = null;
        if (items != null) {
            Iterator<FileItem> it = items.iterator();
//            for (FileItem item : items) {
            while (it.hasNext() && !error) {
//                FileItem uploaded = item;
                FileItem uploaded = it.next();
                if (!uploaded.isFormField()) { // No es campo de formulario, guardamos el fichero en algún sitio
                    if (uploaded.getContentType().equals("image/png") || uploaded.getContentType().equals("image/jpeg")) {
                        if (uploaded.getSize() < 102400) {

                            if (uploaded.getContentType().equals("image/jpeg")) {
                                nombreAvatar = "AvatarN" + String.valueOf(usuario.getId()) + ".jpg";
                                fichero = new File(sc.getRealPath("/images/avatar/"), nombreAvatar);

                            } else {
                                nombreAvatar = "AvatarN" + String.valueOf(usuario.getId()) + ".png";
                                fichero = new File(sc.getRealPath("/images/avatar/"), nombreAvatar);
                                rutaImagen = sc.getRealPath("/images/avatar/");
                            }
                            try {
                                uploaded.write(fichero);

                                usuario.setAvatar(nombreAvatar);
                            } catch (Exception ex) {
                                objeto.put("tipo", "error");
                                objeto.put("mensaje", "No se ha podido subir el fichero");
                                error = true;

                            }
                        } else {
                            objeto.put("tipo", "error");
                            objeto.put("mensaje", "La imagen sobrepasa el tamaño permitido de 100 KB");
                            error = true;
                        }
                    } else {
                        objeto.put("tipo", "error");
                        objeto.put("mensaje", "El archivo introducido no es una imagen jpg o png");
                        error = true;
                    }
                } else {
                    String key = uploaded.getFieldName();
                    String valor = "";

                    if (!key.equals("ficheroAvatar")) {

                        valor = uploaded.getString("UTF-8");
                        if (valor.length() != 0) {
                            switch (key) {

                                case "nombre":
                                    usuario.setNombre(valor);
                                    break;
                                case "apellidos":
                                    usuario.setApellidos(valor);
                                    break;
                                case "fechaNacimiento":
                                    usuario.setFechaNacimiento(Utilidades.stringToDate(valor));

                            }
                        } else {
                            error = true;
                        }
                    }

                }
            }
            if (!error) {
                objeto.put("tipo", "ok");
                objeto.put("nombre", usuario.getNombre());
                objeto.put("apellidos", usuario.getApellidos());

                objeto.put("fecha", Utilidades.dateToString(usuario.getFechaNacimiento()));

            } else {
                objeto.put("tipo", "error");
                objeto.put("mensaje", "Todos los campos son obligatorios");
            }
        } else {
            objeto.put("tipo", "error");
            objeto.put("mensaje", "No se ha introducido ningún fichero");

        }

        response.setContentType("application/json");
        response.getWriter().print(objeto);
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
