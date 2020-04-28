/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.dao;

import java.io.IOException;

/**
 *
 * @author Rakesh
 */
public interface UsersDao {
    boolean CheckUser(String username,String password) throws IOException;
    
}
