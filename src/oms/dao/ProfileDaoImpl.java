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
import oms.bll.Profile;
import javax.swing.JOptionPane;

public class ProfileDaoImpl implements ProfileDao {
  
    @Override
    public void submitProfile(Profile a) throws IOException {
        try{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Profile.txt", true))) {
            bw.write(a.getId() + "," + a.getName() + "," + a.getAddress() + "," + a.getPost() + "," +a.getEmail());
            bw.flush();
            bw.newLine();
            bw.close();
        }
    }
        catch (IOException ex){
            System.out.println(ex);
    }
    }
    

     

    @Override
    public void deleteProfile(String Id) throws IOException{
        String search;
        File oldfile = new File("ProfileTmp.txt");
        File newfile = new File("Profile.txt");
        
        BufferedWriter bw;
        try (BufferedReader br = new BufferedReader(new FileReader(newfile))){
            bw = new BufferedWriter(new FileWriter(oldfile));
            while ((search = br.readLine()) != null) {
            String split[] = search.split (",");
            if (split[0].contains(Id)) {
            continue;
            }
            bw.write(Id);
            bw.flush();
            bw.newLine();
            }
    }
        bw.close();
        
        if (newfile.delete()) {
        oldfile.renameTo(newfile);
        }
        else{
        JOptionPane.showMessageDialog(null,"Delete Profile Successful");
        }
        
        }

    @Override
    public void listProfile(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllProfiles() throws IOException {
        ArrayList<String> fileData = new ArrayList<>();
        FileReader fr = new FileReader("Profile.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            fileData.add(line);
        }
        return fileData;
    }



}
