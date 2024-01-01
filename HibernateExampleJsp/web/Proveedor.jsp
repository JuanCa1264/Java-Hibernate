<%-- 
    Document   : Proveedor
    Created on : 22 sep. 2019, 11:33:37
    Author     : JC
--%>

<%@page import="com.dao.DaoProveedor"%>
<%@page import="com.model.Proveedor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedor</title>
        <script lang="Javascript">
            function cargar(codigo, nombre, direccion, telefono){
                document.frmProveedor.txtCode.value = codigo;
                document.frmProveedor.txtName.value = nombre;
                document.frmProveedor.txtAddress.value = direccion;
                document.frmProveedor.txtTel.value = telefono;
                
            }
        </script>
    </head>
 
    <% DaoProveedor dp = new DaoProveedor(); %>
    <body>
        <h1>Proveedor</h1>
    <center>
        <table border="1">
            <form action="procesarProveedor" method="POST" name="frmProveedor">
                <tr>
                    <td>Código</td>
                    <td><input type="text" name="txtCode"></td>
                </tr>
                
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                
                <tr>
                    <td>Dirección</td>
                    <td><input type="text" name="txtAddress"></td>
                </tr>
                
                <tr>
                    <td>Teléfono</td>
                    <td><input type="text" name="txtTel"></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="btnSave" value="Guardar">
                        <input type="submit" name="btnEdit" value="Modificar" onclick="return confirm('¿Editar?')">
                        <input type="submit" name="btnDel" value="Eliminar"  onclick="return confirm('¿Eliminar?')">
                        <input type="reset" name="btnClear" value="Limpiar"  onclick="return confirm('¿Limpiar? xD')">
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
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Seleccionar</th>
                </tr>
            </thead>
            <tbody>
                <% List<Proveedor> lst = dp.mostrarProveedor();
                for(Proveedor provL: lst){
                %>
                <tr>
                    <td><%= provL.getCodigoProveedor() %></td>
                    <td><%= provL.getNombre() %></td>
                    <td><%= provL.getDireccion() %></td>
                    <td><%= provL.getTelefono() %></td>
                    <td><a href="javascript:cargar(<%= provL.getCodigoProveedor()%>,
                           '<%= provL.getNombre() %>', '<%= provL.getDireccion() %>'
                           ,'<%= provL.getTelefono() %>')">Seleccionar</a></td>
                </tr>
              <% } %>
            </tbody>
        </table>

        
    </center>
    </body>
</html>
