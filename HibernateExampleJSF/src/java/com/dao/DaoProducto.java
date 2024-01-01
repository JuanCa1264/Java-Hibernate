
package com.dao;

import com.model.Producto;
import com.model.Proveedor;
import com.util.HibernateUtil;
import java.util.*;
import javax.swing.JOptionPane;
import org.hibernate.*;

/**
 *
 * @author JC
 */
public class DaoProducto {
    
    public List<Producto> mostrarProducto(){
        List<Producto> lst = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto p inner join fetch p.proveedor";
        try {
            lst = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
            throw e;
        }
        
        return lst;
    }
    
    public void insertarProducto(Producto prod){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(prod);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }
        finally{
            if (session!=null) {
                session.close();
            }
        }
    }
    
    public void modificarProducto(Producto prod){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(prod);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally{
            if (session!=null) {
                session.close();
            }
        }
    }
    
    public void eliminarProducto(Producto prod){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(prod);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally{
            if (session!=null) {
                session.close();
            }
        }
    }
    
    
    
}
