/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varun.controller;



import com.varun.business.Service;
import com.varun.business.User;

import com.varun.data.RequestDB;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Varun
 */
public class DefectController extends HttpServlet {

  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String url="";
          String action = request.getParameter("action");
        if (action == null || action.isEmpty() ) {
              url = "/main.jsp";
        }
        else if(action.equals("Alldefects")){
            url = "/requests.jsp";  
        }else if(action.equals("AllUnSolvedDefects")){
            url = ""; 
        }else if(action.equals("myDefects")){
            url = "/requests.jsp"; 
        }
        
        else if(action.equals("deleteRequets")){
            
        }
        else if(action.equals("solveRequest")){
            
        }
        

        // perform action and set URL to appropriate page
      
        
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String url = "";
        String action = request.getParameter("action");
        if (requestURI.endsWith("/add")) {
            url = addRequest(request, response);
        }else if(requestURI.endsWith("/solved")){
             url = solved(request, response);
        }
       // forward to view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
   
   private String solved(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession();
      User userSession = (User) session.getAttribute("theAdmin");
      String message="";
      if(userSession==null){
         request.setAttribute("message", message);
         return "/login.jsp";
      } 
      
      else{
          
        String id= request.getParameter("requestupdate");
        System.out.print("in solved method is is"+id);
          if(id!=null){
               String status=request.getParameter("statusupdate");
               String date=request.getParameter("enterdate");
               Service service = (Service)RequestDB.getService(Long.parseLong(id));
               System.out.print("defect fetched is "+service+date);
               service.setRequestStatus(status);
               service.setUpdate(date);
               RequestDB.updateStatus(service);
              session.setAttribute("defectReported", service);
          return "/pendingrequests.jsp";
          }
          else{
          
          return "/admin.jsp";
          }
         
      }
      
     
  } 
   
   
   
    
 private String addRequest(HttpServletRequest request, HttpServletResponse response){
       HttpSession session = request.getSession();
       String url="/main.jsp";
      String requestname = request.getParameter("title");
       String desc = request.getParameter("description");
       String brand = request.getParameter("brand");
       String type=request.getParameter("type");
       User user = (User) session.getAttribute("theUser");
       		Service service=new Service();
           
          
       service.setDateRequested(System.currentTimeMillis());
       service.setRequestTitle(requestname);
       service.setRequestDescription(desc);
       service.setBrand(brand);
       service.setType(type);
       service.setRequestedByEmail(user.getEmail());
       service.setRequestedByName(user.getUsername());
       service.setRequestStatus("pending");
        String message;
        		RequestDB.addRequest(service);
           
            List<Service> studyCode = (List<Service>)RequestDB.getAllMyRequests(user.getEmail());
            session.setAttribute("studyCode", studyCode);
            request.setAttribute("studyCode", studyCode);
          
            message = "defect details added";
            request.setAttribute("message", message);
            url = "/requests.jsp";
          
      
        return url;
           
      
       
       
   }
    
     
        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  }
