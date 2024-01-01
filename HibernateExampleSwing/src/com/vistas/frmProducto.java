package com.vistas;

import com.dao.DaoProducto;
import com.dao.DaoProveedor;
import com.model.Producto;
import com.model.Proveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JC
 */
public class frmProducto extends javax.swing.JFrame {

    /**
     * Creates new form frmProducto
     */
    
    Producto prod;
    DaoProveedor dp = new DaoProveedor();
    DaoProducto dprod = new DaoProducto();
    Proveedor proveedor = new Proveedor();
    
    public frmProducto() throws Exception {
        initComponents();
        //Llamada al método de llenar comboBox
        cargarCombo(cmbProv, dp.mostrarProveedor());
        tablaProducto();
    }
    
    public void tablaProducto(){
        String [] cols = {"Código","Nombre", "Categoría", "Precio", "Fabricación", "Vencimiento", "Proveedor"};
        Object[] obj = new Object[7];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        
        try {
            ls = dprod.mostrarProducto();
            for (int i = 0; i <ls.size(); i++) {
                prod = (Producto)ls.get(i);
                obj[0] = prod.getCodigoProducto();
                obj[1] = prod.getNombre();
                obj[2] = prod.getCategoria();
                obj[3] = prod.getPrecio();
                obj[4] = prod.getAnioFabricacion();
                obj[5] = prod.getAnioVencimiento();
                obj[6] = prod.getProveedor().getCodigoProveedor();
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos "+e.toString());
        }
            
    }
    
    public void insertar(){
        
        try {
            
            //insertar ID de proveedor
            ComboItem item = new ComboItem();
            String prov = cmbProv.getSelectedItem().toString();
           
        for (int i = 0; i < cmbProv.getItemCount(); i++) {
            if (prov.equals(cmbProv.getItemAt(i).toString())) {
                item = cmbProv.getModel().getElementAt(i);
                
            }
        }
        
            proveedor.setCodigoProveedor(item.getValue());
            prod.setProveedor(proveedor);
            
            prod.setCodigoProducto(Integer.parseInt(this.txtCode.getText()));
            prod.setNombre(this.txtName.getText());
            prod.setCategoria(this.cmbCat.getSelectedItem().toString());
            prod.setPrecio(Double.parseDouble(this.txtPrice.getText()));
            prod.setAnioFabricacion(Integer.parseInt(this.txtYearF.getText()));
            prod.setAnioVencimiento(Integer.parseInt(this.txtYearV.getText()));
            //dprod.insertarProducto(prod);
            
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void modificar(){
        
        try {
            
            ComboItem item = new ComboItem();
            String prov = cmbProv.getSelectedItem().toString();
           
        for (int i = 0; i < cmbProv.getItemCount(); i++) {
            if (prov.equals(cmbProv.getItemAt(i).toString())) {
                item = cmbProv.getModel().getElementAt(i);
                
            }
        }
        
            proveedor.setCodigoProveedor(item.getValue());
            prod.setProveedor(proveedor);
            
            prod.setCodigoProducto(Integer.parseInt(this.txtCode.getText()));
            prod.setNombre(this.txtName.getText());
            prod.setCategoria(this.cmbCat.getSelectedItem().toString());
            prod.setPrecio(Double.parseDouble(this.txtPrice.getText()));
            prod.setAnioFabricacion(Integer.parseInt(this.txtYearF.getText()));
            prod.setAnioVencimiento(Integer.parseInt(this.txtYearV.getText()));
            //dprod.modificarProducto(prod);
            
        JOptionPane.showMessageDialog(null, "Datos modificados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void eliminar(){
        
        prod.setCodigoProducto(Integer.parseInt(this.txtCode.getText()));
        
        //dprod.eliminarProducto(prod);
        
        
    }
    
    //Se cargan elementos en el comboBox
    private void cargarCombo(JComboBox combo,
            List<Proveedor> list) throws Exception {

        for (Proveedor item : list) {
            combo.addItem(new com.vistas.ComboItem(item.getCodigoProveedor(), 
                    item.getNombre()));
        }

    }
    
    public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtCode.setText(String.valueOf(this.jTable1.getValueAt(fila, 0))); 
        this.txtName.setText(String.valueOf(this.jTable1.getValueAt(fila, 1))); 
        this.cmbCat.setSelectedItem(String.valueOf(this.jTable1.getValueAt(fila, 2)));
        this.txtPrice.setText(String.valueOf(this.jTable1.getValueAt(fila, 3)));
        this.txtYearF.setText(String.valueOf(this.jTable1.getValueAt(fila, 4)));
        this.txtYearV.setText(String.valueOf(this.jTable1.getValueAt(fila, 5))); 
        String prov = String.valueOf(this.jTable1.getValueAt(fila, 6));
        this.cmbProv.getModel().setSelectedItem(prov);
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbCat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtYearF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtYearV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbProv = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Categoría");

        cmbCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimento", "Utensilio", "Mueble", "Aparato" }));

        jLabel4.setText("Precio");

        jLabel5.setText("A. Fabricación");

        jLabel6.setText("A. Vencimiento");

        jLabel7.setText("Proveedor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnSave.setText("Agregar");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnEdit.setText("Modificar");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnDel.setText("Eliminar");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYearF)))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYearV))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProv, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtYearF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtYearV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnSave)
                        .addGap(31, 31, 31)
                        .addComponent(btnEdit)
                        .addGap(29, 29, 29)
                        .addComponent(btnDel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        insertar();
        tablaProducto();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        modificar();
        tablaProducto();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        eliminar();
        tablaProducto();
    }//GEN-LAST:event_btnDelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmProducto().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCat;
    private javax.swing.JComboBox<ComboItem> cmbProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtYearF;
    private javax.swing.JTextField txtYearV;
    // End of variables declaration//GEN-END:variables
}
