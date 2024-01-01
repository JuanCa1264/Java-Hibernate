<%-- 
    Document   : Producto
    Created on : 22 sep. 2019, 12:48:38
    Author     : JC
--%>

<%@page import="com.dao.DaoProducto"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DaoProveedor"%>
<%@page import="com.model.Producto"%>
<%@page import="com.model.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <script lang="Javascript">
            function cargar(codigo, nombre, categoria, precio, fa, ve, prov){
                document.frmProducto.txtCode.value = codigo;
                document.frmProducto.txtName.value = nombre;
                document.frmProducto.txtCat.value = categoria;
                document.frmProducto.txtPrice.value = precio;
                document.frmProducto.txtFa.value = fa;
                document.frmProducto.txtVe.value = ve;
                documento.frmProducto.proveedor.value = prov;
            }
        </script>
    </head>
    <% Producto p = new Producto(); %>
    <% Proveedor pro = new Proveedor(); %>
    <% DaoProveedor dp = new DaoProveedor(); %>
    <% DaoProducto dpro = new DaoProducto(); %>
    <body>
        <h1>Producto</h1>
    <center>
        <table border="1">
            <form action="procesarProducto" method="POST" name="frmProducto">
                <tr>
                    <td>Código</td>
                    <td><input type="text" name="txtCode"></td>
                </tr>
                
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                
                <tr>
                    <td>Categoría</td>
                    <td><input type="text" name="txtCat"></td>
                </tr>
                
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="txtPrice"></td>
                </tr>
                
                <tr>
                    <td>Año Fabricación</td>
                    <td><input type="text" name="txtFa"></td>
                </tr>
                
                <tr>
                    <td>Año Vencimiento</td>
                    <td><input type="text" name="txtVe"></td>
                </tr>
                
                <tr>
                    <td>Proveedor</td>
                    <td>
                        <select name="proveedor">
                            <% List<Proveedor> lst = dp.mostrarProveedor();
                            for(Proveedor prov: lst){
                            %>
                            
                            <option value="<%= prov.getCodigoProveedor() %>"><%= prov.getNombre() %></option>
                            
                            <% } %>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td colspan='2'>
                        <input type="submit" name='btnSave' value="Guardar">
                        <input type="submit" name='btnEdit' value="Modificar" onclick="return confirm('¿Modificar?')">
                        <input type="submit" name='btnDel' value="Eliminar" onclick="return confirm('¿Eliminar?')">
                        <input type="reset" name='btnClear' value="Limpiar" onclick="return confirm('¿Limpiar? xD')">
                    </td>
                </tr>
                
            </form>
        </table>
                        <br>
                        <br>
                        <hr>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Nombre</th>
                                    <th>Categoría</th>
                                    <th>Precio</th>
                                    <th>Fabricación</th>
                                    <th>Vencimiento</th>
                                    <th>Proveedor</th>
                                    <th>Seleccionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% List<Producto> lstPro = dpro.mostrarProducto();
                                for(Producto prod: lstPro){
                                    
                                
                                %>
                                <tr>
                                    <td><%= prod.getCodigoProducto() %></td>
                                    <td><%= prod.getNombre() %></td>
                                    <td><%= prod.getCategoria() %></td>
                                    <td><%= prod.getPrecio() %></td>
                                    <td><%= prod.getAnioFabricacion() %></td>
                                    <td><%= prod.getAnioVencimiento() %></td>
                                    <td><%= prod.getProveedor().getCodigoProveedor() %></td>
                                    <td><a href="javascript:cargar(<%= prod.getCodigoProducto() %>,
                                           '<%= prod.getNombre() %>',
                                           '<%= prod.getCategoria() %>',
                                           '<%= prod.getPrecio() %>',
                                           '<%= prod.getAnioFabricacion() %>',
                                           '<%= prod.getAnioVencimiento() %>',
                                           <%= prod.getProveedor().getCodigoProveedor() %>)">Seleccionar</a></td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>

    </center>
    </body>
</html>
