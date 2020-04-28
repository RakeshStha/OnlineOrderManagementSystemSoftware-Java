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
public class Profile {
    private String id;
    private String name;
     private String post;
    private String address;
       private String email;


    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
 
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
//For update process.
 public void Update(String id, String name, String address,
            String post, String Email)
        { 
          BufferedReader br = null;
            try {
            File newfile = new File("Profile.txt");
            File oldfile = new File("ProfileTmp.txt");
            br = new BufferedReader(new FileReader(newfile));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(oldfile))) {
                String search;
                while ((search = br.readLine()) != null) {
                    String split[] = search.split("  ");
                    if (split[0].contains(id)) {

                        bw.write(id + "  " + name + "  " + address  + "  " + post +" " + Email +" ");
                    
                    } else {
                        bw.write(search);
                    }

                    bw.flush();
                    bw.newLine();

                }

                br.close();
            }

            if (newfile.delete()) {
                JOptionPane.showMessageDialog(null, "Product Update succesfully");
                oldfile.renameTo(newfile);
            }
            else{
            JOptionPane.showMessageDialog(null,"Error");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
