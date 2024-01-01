
package com.dao;

import com.model.Proveedor;
import com.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JC
 */
public class DaoProveedor {
    public void insertarProveedor(Proveedor prov){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(prov);
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
    
    public void modificarProveedor(Proveedor prov){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(prov);
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
    
    public void eliminarProveedor(Proveedor prov){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(prov);
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
    
    public List<Proveedor> mostrarProveedor(){
        List<Proveedor> lst = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "From Proveedor";
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
