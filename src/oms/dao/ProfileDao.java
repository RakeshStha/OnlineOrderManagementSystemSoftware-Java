/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oms.dao;

import java.io.IOException;
import java.util.ArrayList;
import oms.bll.Profile;

/**
 *
 * @author Rakesh
 */
public interface ProfileDao {
    void submitProfile(Profile ab) throws IOException;
    void deleteProfile(String Id) throws IOException;
    void listProfile(int Id);
    ArrayList<String> getAllProfiles() throws IOException;
    
}
