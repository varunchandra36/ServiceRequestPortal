/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varun.data;

import com.varun.business.User;
import com.varun.data.DBUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author varun
 */
public class UserDB {
   // getting single result from the user table in userdb database 
   public static User getuserbyemail(String email){
       
        Connection connection = DBUtility.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user "
                + "WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setEmail(email);
                user.setUserpassword(rs.getString("userpassword"));
                user.setUsertype(rs.getString("usertype"));
                user.setUsername(rs.getString("username"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtility.closeConnection(connection);
        }
       
      
 
    
    
}
   //"SELECT u.email, u.userpassword FROM User u " +
    //               "WHERE u.email= :email and u.userpassword = :password";

public static User authentication(String email,String password){
       Connection connection = DBUtility.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
       // String p1=null;
        String pass=PasswordUtil.hashPassword(password);
        System.out.println(pass);
        String query=" select * from user where email=? and userpassword=?";
         try {
            
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setEmail(email);
                
                user.setUserpassword(rs.getString("userpassword"));
                user.setUsertype(rs.getString("usertype"));
                user.setUsername(rs.getString("username"));
                return user;
            }
            return null;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtility.closeConnection(connection);
        }
}


 public static List<User> getusers(){
      Connection connection = DBUtility.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
       // String p1=null;
        ArrayList<User> users=new ArrayList<User>();
        String query="select * from user";
         try {
            
            ps = connection.prepareStatement(query);
           
            rs=ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setUserpassword(rs.getString("userpassword"));
                user.setUsertype(rs.getString("usertype"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
            return users;
        }
        catch (SQLException e) {
            System.out.println(e);
            return users;
        } finally {
            DBUtil.closePreparedStatement(ps);
           DBUtility.closeConnection(connection);
        }
      
 
    
    
}

   
   
  public static void insert(User user){
     Connection connection = DBUtility.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query=" insert into user values(?,?,?,?,?)";
        try {
            /*ps1=connection.prepareStatement(increment);
            rs=ps1.executeQuery();
            System.out.println("result set is"+rs);
            //i=rs.getInt(0);*/
            ps = connection.prepareStatement(query);
            //ps.setInt(1, i);
            ps.setString(1, user.getEmail());
            String pass=PasswordUtil.hashPassword(user.getUserpassword());
            ps.setString(2, pass);
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getUsertype());
            ps.setString(5,"Car");
            
            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtility.closeConnection(connection);
        }
      
  }
    
  
  
  
  
    public static boolean emailExists(String email) {
        User u = getuserbyemail(email);   
        return u != null;
    }  
}
