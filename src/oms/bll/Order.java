/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.bll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rakesh
 */
public class Order {
        private String ProductID;
        private String Pname;
        private String Cname;
        private String Q;

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    public String getQ() {
        return Q;
    }

    public void setQ(String Q) {
        this.Q = Q;
    }


    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }
        
        
       public void Add(String ProductID,String Pname, String Cname, String Q )
    { 
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Order.txt", true))) {
                bw.write(ProductID + ","+ Pname + ","+Cname + ","+ Q + ","); 
                
                bw.flush();
                bw.newLine();

                bw.close();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    } 
         public void deleteProduct(String ProductID) throws IOException{
        String search;
        File oldfile = new File("OrderTmp.txt");
        File newfile = new File("Order.txt");
        
        BufferedWriter bw;
        try (BufferedReader br = new BufferedReader(new FileReader(newfile))){
            bw = new BufferedWriter(new FileWriter(oldfile));
            while ((search = br.readLine()) != null) {
            String split[] = search.split (",");
            if (split[0].contains(ProductID)) {
            continue;
            }
            bw.write(ProductID);
            bw.flush();
            bw.newLine();
            }
    }
        bw.close();
        
        if (newfile.delete()) {
        oldfile.renameTo(newfile);
        }
        else{
        JOptionPane.showMessageDialog(null,"Order delete successfull");
        }
        
        }
}
