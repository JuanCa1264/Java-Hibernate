package com.dao;

import com.model.Producto;
import com.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JC
 */
public class DaoProducto {
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
    
    public List<Producto> mostrarProducto(){
        List<Producto> lst = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "From Producto";
        try {
            lst = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
            JOptionPane.showMessageDialog(null, e.toString());
        }
       
        return lst;
        
    }
    
}
