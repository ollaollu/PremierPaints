/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.users.presentation;

import com.application.premierpaints.users.data.Users;
import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.util.PremierConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ollaollu
 */
public class UserDAO implements Serializable {
        private PremierConnection conman = null;
        //private UsersManagedBean bean;

        public List getSearchByUsername(String searchValue) throws SQLException{
            //bean = new UsersManagedBean();
            conman = new PremierConnection();
            String sql = "select * from users where username like ? or firstname like ? or lastname like ? or groupname like ?";
            //searchValue = bean.getSearchValue();
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, searchValue + "%");
                stm.setString(2, searchValue + "%");
                stm.setString(3, searchValue + "%");
                stm.setString(4, searchValue + "%");
                String output = MessageFormat.format("{0}", searchValue);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    Users us = new Users();
                    us.setFirstname(rs.getString("firstname"));
                    us.setLastname(rs.getString("lastname"));
                    us.setUsername(rs.getString("username"));
                    us.setGroupname(rs.getString("groupname"));
                    us.setId(rs.getInt("Id"));
                    result.add(us);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return result;
            
        }
        
        public List UserAccess(){
            conman = new PremierConnection();
            String sql = "select * from useraccesslike ?";
            Connection conn = null;
            PreparedStatement stm = null;           
            List userAccess = new ArrayList(); 
            
            conn = conman.getDBConnection();
           // stm = conn.prepareStatement(sql);
            
            return userAccess;
        }
        
    
}
