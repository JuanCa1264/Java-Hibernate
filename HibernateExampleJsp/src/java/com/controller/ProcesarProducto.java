/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.DaoProducto;
import com.model.Producto;
import com.model.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JC
 */
public class ProcesarProducto extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        DaoProducto dpro = new DaoProducto();
        Producto pro = new Producto();
        Proveedor prov = new Proveedor();
        String msj = null;
        try {
            pro.setCodigoProducto(Integer.parseInt(request.getParameter("txtCode")));
            pro.setNombre(request.getParameter("txtName"));
            pro.setCategoria(request.getParameter("txtCat"));
            pro.setPrecio(Double.parseDouble(request.getParameter("txtPrice")));
            pro.setAnioFabricacion(Integer.parseInt(request.getParameter("txtFa")));
            pro.setAnioVencimiento(Integer.parseInt(request.getParameter("txtVe")));
            prov.setCodigoProveedor(Integer.parseInt(request.getParameter("proveedor")));
            pro.setProveedor(prov);
            
            if (request.getParameter("btnSave")!=null) {
                dpro.insertarProducto(pro);
                msj = "Insertado";
            }
            else if(request.getParameter("btnEdit")!=null){
                dpro.modificarProducto(pro);
                msj = "Modificado";
            }
            else{
                dpro.eliminarProducto(pro);
                msj = "Eliminado";
            }
            response.sendRedirect("Producto.jsp");
            request.getSession().setAttribute("msj", msj);
            
        } catch (Exception e) {
            request.getSession().setAttribute("error", e.toString());
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
