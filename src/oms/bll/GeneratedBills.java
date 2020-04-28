package oms.bll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oms.form.CustomerCart;

public final class GeneratedBills extends javax.swing.JFrame {


  
//    public void ViewBills()
//    {
//        
//    }
    
    public GeneratedBills() {

        initComponents();
        showproducttable();
    }

    public void showproducttable()
    {
        String filePath = "Bill.txt";
        File file = new File(filePath);
        
        DefaultTableModel model = (DefaultTableModel) BillTable.getModel();
                try{
            BufferedReader br = new BufferedReader(new FileReader(file));            
            Object[] tableLines = br.lines().toArray();
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");

                model.addRow(dataRow);
            }
        }catch (IOException ex){
            Logger.getLogger(GeneratedBills.class.getName()).log(Level.SEVERE, null,ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
       
        BillTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       
        setTitle("Display bills");

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "Total bill amount."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(BillTable);


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
     
                )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        CustomerCart CC = new CustomerCart();
        CC.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {     

        java.awt.EventQueue.invokeLater(() -> {
            new GeneratedBills().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2; //logout
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable BillTable;
    // End of variables declaration//GEN-END:variables
}
