/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoProducto;
import com.dao.DaoProveedor;
import com.model.Producto;
import com.model.Proveedor;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author JC
 */
@ManagedBean
@ViewScoped

public class ProcesarProducto {

    DaoProducto dp = new DaoProducto();
    DaoProveedor dprov = new DaoProveedor();
    private List<Producto> lst;
    private Producto prod;
    private List<SelectItem> lstProv;

   
    
    
    
    public ProcesarProducto() {
        prod = new Producto();
    }
    
     public List<SelectItem> getLstProv() {
        this.lstProv = new ArrayList<SelectItem>();
        List<Proveedor> lst = dprov.mostrarProveedor();
        lstProv.clear();
        
        for(Proveedor prov: lst){
            SelectItem provItem = new SelectItem(prov.getCodigoProveedor(), prov.getNombre());
            this.lstProv.add(provItem);
        }
        
        return lstProv;
    }
     
     public void cancel(){
         prod = new Producto();
     }

    public List<Producto> getLst() {
        
        lst = dp.mostrarProducto();
        return lst;
    }
    
    
    public void newProduct(){
        dp.insertarProducto(prod);
        prod = new Producto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Guardado", "Registro guardado con éxito"));
    }
    
    public void updateProduct(){
        dp.modificarProducto(prod);
        prod = new Producto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificado", "Registro modificado con éxito"));
    }
    
    public void deleteProduct(){
        dp.eliminarProducto(prod);
        prod = new Producto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Eliminado", "Registro eliminado con éxito"));
    }
    

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }
    
    
    
    
}
