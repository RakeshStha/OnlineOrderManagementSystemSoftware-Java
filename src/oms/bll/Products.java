/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.bll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oms.dao.ProfileDaoImpl;

/**
 *
 * @author Rakesh
 */
public class Products {
    private String productid;
    private String name;
    private String price;
    public String Cmb;

    public String getCmb() {
        return Cmb;
    }

    public void setCmb(String Cmb) {
        this.Cmb = Cmb;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    //For update process.
 public void Update(String productid, String name, String price, String Cmb)
        { 
          BufferedReader br = null;
            try {
            File newfile = new File("Product.txt");
            File oldfile = new File("ProductTmp.txt");
            br = new BufferedReader(new FileReader(newfile));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(oldfile))) {
                String search;
                while ((search = br.readLine()) != null) {
                    String split[] = search.split(" ");
                    if (split[0].contains(productid)) {

                        bw.write(productid + "  " + name + "  " + price  + "  " + Cmb + "");
                   
                    } else {
                        bw.write(search);
                    }

                    bw.flush();
                    bw.newLine();

                }

                br.close();
            }

            if (newfile.delete()) {
                oldfile.renameTo(newfile);
                 JOptionPane.showMessageDialog(null,"Account Update Successfull");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProfileDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ProfileDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
