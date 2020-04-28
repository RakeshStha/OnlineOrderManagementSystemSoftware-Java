/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oms.bll.Products;


/**
 *
 * @author Rakesh
 */
public class ProductDaoImpl implements ProductDao{
   
    @Override
    public void submitProduct(Products p) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Product.txt", true))) {
            bw.write(p.getProductid() + "," + p.getName() + "," + p.getPrice() + "," + p.getCmb());
            bw.flush();
            bw.newLine();
            bw.close();
        }
                catch (IOException ex){
            System.out.println(ex);
    }

    }


    @Override
   public void deleteProduct(String Productid) throws IOException{
        String search;
        File oldfile = new File("ProductTmp.txt");
        File newfile = new File("Product.txt");
        
        BufferedWriter bw;
        try (BufferedReader br = new BufferedReader(new FileReader(newfile))){
            bw = new BufferedWriter(new FileWriter(oldfile));
            while ((search = br.readLine()) != null) {
            String split[] = search.split (",");
            if (split[0].contains(Productid)) {
            continue;
            }
            bw.write(Productid);
            bw.flush();
            bw.newLine();
            }
    }
        bw.close();
        
        if (newfile.delete()) {
        oldfile.renameTo(newfile);
        }
        else{
        JOptionPane.showMessageDialog(null,"Product delete successfull");
        }
        
        }
    @Override
    public void listProduct(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllProducts() throws IOException {
        ArrayList<String> fileData = new ArrayList<>();
        FileReader fr = new FileReader("Product.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            fileData.add(line);
        }
        return fileData;
    } 
}
