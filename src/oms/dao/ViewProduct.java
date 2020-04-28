package oms.dao;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import oms.form.Admin;
import oms.form.LoginPage;

public final class ViewProduct extends javax.swing.JFrame {

  
//    public void ViewProduct()
//    {
//        
//    }
    
    public ViewProduct() {
        initComponents();
        loadData();
    }

    private void loadData() {
        try {
            ArrayList<String> dataList;
            ProductDaoImpl sdi = new ProductDaoImpl();
            dataList = sdi.getAllProducts();
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"Product ID", "Name", "Price", "Type"}, 0);
            Object[] tableLines = dataList.toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String lines = tableLines[i].toString();
                String[] row = lines.split(",");
                dtm.addRow(row);

            }
            ProductTable.setModel(dtm);

        } catch (Exception ex) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Products Details");

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name",  "Price", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        jButton1.setText("Logout");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Back");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(644, 1012, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.setVisible(false);
        LoginPage l = new LoginPage();
        l.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        Admin a = new Admin();
        a.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {     

        java.awt.EventQueue.invokeLater(() -> {
            new ViewProduct().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1; //login 
    private javax.swing.JButton jButton2; //logout
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ProductTable;
    // End of variables declaration//GEN-END:variables
}
