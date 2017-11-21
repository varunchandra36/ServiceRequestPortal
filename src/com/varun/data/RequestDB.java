package com.varun.data;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.varun.business.Service;




public class RequestDB {
	 public static void addRequest(Service service){
         Connection connection = DBUtility.getConnection();
         PreparedStatement ps = null;
		String query = "INSERT INTO request(title, byname, byemail, brand,daterequested, description, requeststatus, type ) VALUES (?,?,?,?,?,?,?,?)";
		
		try
		{
			ps = connection.prepareStatement(query);
			ps.setString(1,service.getRequestTitle());
                     ps.setString(2, service.getRequestedByName());
                     ps.setString(3,service.getRequestedByEmail());
                     ps.setString(4,service.getBrand());
                     ps.setLong(5,service.getDateRequested());
                     ps.setString(6,service.getRequestDescription());
                     ps.setString(7, service.getRequestStatus());
                     ps.setString(8, service.getType());
                     
			ps.executeUpdate();
                    /* EmailDB.emailRecommendTrigger(service.getRequestedByEmail());*/
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			
		}
		finally
		{
			DBUtil.closePreparedStatement(ps);
                 DBUtility.closeConnection(connection);
		}
   
   
}
  public static Service getService(long id){
      	Service service=null;
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from request where id=?";

     try
     {
     	  ps = connection.prepareStatement(query);
               ps.setLong(1,id);
           ResultSet rs = ps.executeQuery();
           if(rs.next())
           {
       		   service= new Service();
       		service.setId(rs.getLong("id"));
       		service.setRequestTitle(rs.getString("title"));
       		service.setRequestedByEmail(rs.getString("byemail"));
                       service.setRequestedByName(rs.getString("byname"));
                       service.setDateRequested(rs.getLong("daterequested"));
                       service.setRequestDescription(rs.getString("description"));
                       service.setRequestStatus(rs.getString("requeststatus"));
                       service.setBrand(rs.getString("brand")); 
                       service.setType(rs.getString("type"));
                       service.setUpdate(rs.getString("uptodate"));
                       
                       
           }
     }
     catch(SQLException  e)
     {
     	System.out.println(e);
     }
     finally
		{
			DBUtil.closePreparedStatement(ps);
                 DBUtility.closeConnection(connection);

		}
	    return service;	
	
  }
  public static ArrayList<Service> getAllRequests(){
      	ArrayList<Service> services = new ArrayList<Service>();
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from request";

     try
     {
     	  ps = connection.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           while(rs.next())
           {
        	   Service service = new Service();
        	   service.setId(rs.getLong("id"));
        	   service.setRequestTitle(rs.getString("title"));
        	   service.setRequestedByEmail(rs.getString("byemail"));
        	   service.setRequestedByName(rs.getString("byname"));
        	   service.setDateRequested(rs.getLong("daterequested"));
        	   service.setRequestDescription(rs.getString("description"));
        	   service.setRequestStatus(rs.getString("requeststatus"));
                       service.setBrand(rs.getString("brand")); 
                       service.setType(rs.getString("type"));
                       service.setUpdate(rs.getString("uptodate"));
                       services.add(service);
           }
     }
     catch(SQLException  e)
     {
     	System.out.println(e);
     }
     finally
		{
			DBUtil.closePreparedStatement(ps);
                 DBUtility.closeConnection(connection);

		}
     System.out.println("defects returned "+services);
	    return services;	
	
  }
  public static ArrayList<Service> getAllPendingRequests(){
      	ArrayList<Service> services = new ArrayList<Service>();
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from request where requeststatus=?";

     try
     {
     	  ps = connection.prepareStatement(query);
               ps.setString(1,"pending");
           ResultSet rs = ps.executeQuery();
           while(rs.next())
           {
       		  Service service = new Service();
       		service.setId(rs.getLong("id"));
       		service.setRequestTitle(rs.getString("title"));
       		service.setRequestedByEmail(rs.getString("byemail"));
       		service.setRequestedByName(rs.getString("byname"));
       		service.setDateRequested(rs.getLong("daterequested"));
       		service.setRequestDescription(rs.getString("description"));
       		service.setRequestStatus(rs.getString("requeststatus"));
       		service.setBrand(rs.getString("brand"));
       		service.setType(rs.getString("type"));
       	 service.setUpdate(rs.getString("uptodate"));
       		services.add(service);
           }
     }
     catch(SQLException  e)
     {
     	System.out.println(e);
     }
     finally
		{
			DBUtil.closePreparedStatement(ps);
                 DBUtility.closeConnection(connection);

		}
	    return services;	
	
  }
  public static ArrayList<Service> getAllMyRequests(String email){
      	ArrayList<Service> services = new ArrayList<Service>();
		System.out.println("OK");
		Connection connection = DBUtility.getConnection();
		PreparedStatement ps = null;
		
		String query = "SELECT * from request where byemail=?";

     try
     {
     	  ps = connection.prepareStatement(query);
               ps.setString(1,email);
           ResultSet rs = ps.executeQuery();
           while(rs.next())
           {
        	   Service service = new Service();
        	   service.setId(rs.getLong("id"));
        	   service.setRequestTitle(rs.getString("title"));
        	   service.setRequestedByEmail(rs.getString("byemail"));
        	   service.setRequestedByName(rs.getString("byname"));
        	   service.setDateRequested(rs.getLong("daterequested"));
        	   service.setRequestDescription(rs.getString("description"));
        	   service.setRequestStatus(rs.getString("requeststatus"));
                       service.setBrand(rs.getString("brand")); 
                       service.setType(rs.getString("type"));
                       System.out.println(rs.getString("uptodate")+ "varun");
                       service.setUpdate(rs.getString("uptodate"));
                       services.add(service);
           }
     }
     catch(SQLException  e)
     {
     	e.printStackTrace();
     }
     finally
		{
			DBUtil.closePreparedStatement(ps);
                 DBUtility.closeConnection(connection);

		}
	    return services;	
	
  }

public static void updateStatus(Service service){
   
    Connection connection = DBUtility.getConnection();
		PreparedStatement ps = null;
		
     String query = "UPDATE request set requeststatus=?, uptodate=? WHERE id=?";
		
		try
		{
			ps = connection.prepareStatement(query);
			ps.setString(1,service.getRequestStatus());
			ps.setString(2,service.getUpdate());
			ps.setLong(3,service.getId());
                     ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			
		}
		finally
		{
			DBUtil.closePreparedStatement(ps);
                 DBUtility.closeConnection(connection);

		}
   
   
}




}
