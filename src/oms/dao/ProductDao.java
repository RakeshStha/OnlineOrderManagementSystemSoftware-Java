/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.dao;

import java.io.IOException;
import java.util.ArrayList;
import oms.bll.Products;

/**
 *
 * @author Rakesh
 */
public interface ProductDao {
    void submitProduct(Products p) throws IOException;
    void deleteProduct(String Productid) throws IOException;
    void listProduct(int Id);
    ArrayList<String> getAllProducts() throws IOException;
      
}
