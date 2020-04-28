/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rakesh
 */
public class UsersDaoImpl implements UsersDao {

    @Override
    public boolean CheckUser(String username, String password) throws IOException {
        boolean found=false;
        
        try{
            FileReader fr=new FileReader("Users.txt");
            try (BufferedReader br = new BufferedReader(fr)) {
                String line=null;
                String []splt=null;
                
                while((line=br.readLine())!=null){
                    splt=line.split(",");
                    if(splt[0].equals(username) && splt[1].equals(password)){
                        found=true;
                        break;
                    }
                }
            }
        }
        catch(IOException ex){}
        return found;
    }
  
}
