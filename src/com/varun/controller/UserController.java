/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varun.controller;

import com.varun.business.User;

import com.varun.data.UserDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {
 



   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
        if (action == null) {
            action = "home";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "";
        if (action.equals("home")) {
            url = home(request,response);
        }else if(action.equals("about")){
            url = about(request,response);
            
        }else if(action.equals("logout")){
            url = logout(request,response);
            
        }else if(action.equals("main")){
            url = main(request,response);
            
        }
        
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestURI = request.getRequestURI();
        String url = "";
        if (requestURI.endsWith("/signup")) {
            url = registerUser(request, response);
        }else if(requestURI.endsWith("/login")){
            url = login(request,response); 
        }
       // forward to view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
  
    // if URL ends with signup then registerUser method is called
  private String registerUser(HttpServletRequest request, HttpServletResponse response){
       
       String userName = request.getParameter("name");
       String email = request.getParameter("email");
       String password = request.getParameter("password");
      
            User user = new User();
        
        user.setEmail(email);
        user.setUsername(userName);
        user.setUserpassword(password);
        user.setUsertype("customer");
       
        HttpSession session = request.getSession();
        session.setAttribute("theUser", user);
        request.setAttribute("user", user);

        String url;
        String message;
        //check that email address doesn't already exist
        if (UserDB.emailExists(email)) {
            message = "This email address already exists. <br>"
                    + "Please enter another email address.";
            request.setAttribute("message", message);
            url = "/signup.jsp";
        } else {
            UserDB.insert(user);
            message = "";
            request.setAttribute("message", message);
            url = "/main.jsp";
        }
        return url;
           
      
       
       
   }

  // if action equals home then home method is called
  
  private String home(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession();
      User userSession = (User) session.getAttribute("theUser");
      String message="";
      if(userSession==null){
         request.setAttribute("message", message);
         return "/home.jsp";
      } else{
          request.setAttribute("message", message);
          return "/main.jsp";
      }
      
     
  }
   // if action equals about then about method is called
  private String about(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession();
      User userSession = (User) session.getAttribute("theUser");
      String message="";
      if(userSession==null){
         request.setAttribute("message", message);
         return "/about.jsp";
      } else{
          request.setAttribute("message", message); 
          return "/aboutl.jsp";
      }
      
     
  }
   
     // if action equals main then main method is called
  private String main(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession();
      User userSession = (User) session.getAttribute("theUser");
      String message="";
      if(userSession==null){
         request.setAttribute("message", message);
         return "/login.jsp";
      } else{
          request.setAttribute("message", message); 
          return "/main.jsp";
      }
      
     
  }
   // if action equals logout then logout method is called
  private String logout(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession();
      User userSession = (User) session.getAttribute("theUser");
      User adminSession = (User) session.getAttribute("theAdmin");
      String message="";
      if(userSession==null && adminSession==null ){
         request.setAttribute("message", message);
         return "/home.jsp";
      } else{
          request.setAttribute("message", message); 
          session.removeAttribute("theUser");
          session.removeAttribute("theAdmin");
          return "/home.jsp";
      }
      
     
  }
  private String login(HttpServletRequest request,HttpServletResponse response) throws IOException{
       
      PrintWriter writer = response.getWriter();
      String email = request.getParameter("email");
       String password = request.getParameter("password");
       String action = request.getParameter("action");
       // authentication
      
      HttpSession session = request.getSession();
         User result =   UserDB.authentication(email, password);
          
          
          
        	  if(result==null){
        		  session.setAttribute("wrong_uname_pass", "1");
        		  return "/login.jsp" ;
 
        	  }
        	  else 
        	  {
        		  String type = result.getUsertype();
        		  if(type.matches("admin")){
                 
        			  session.setAttribute("theAdmin", result);
        			  return "/admin.jsp";
             }
        		  else {      
        			  session.setAttribute("theUser", result);
        			  return "/main.jsp";
                 
             }
       
       
       
              }
  }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
    
}
