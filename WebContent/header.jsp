

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
       
        <title>Nissan Car Defect Reporting</title>
        
        <%-- importing CSS stylesheet --%>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" >
        <link rel="stylesheet" href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'/>" >    
                                            
        
    </head>
    <body>
    
    
        <%-- Code to specify Header section of the page--%>
        <div id="header">
            <nav id="header_menu">
                <% if(session.getAttribute("theUser")!=null){ %>
                    <a href="<c:url value='/UserController?action=home'/>"><img src="<c:url value='/images/expert.jpg'/>" width="150" height="60" alt="Home" /></a>
                    <% } %>
                </ul>
                <ul class="right">
                   
                    <% if(session.getAttribute("theAdmin")==null && session.getAttribute("theUser")==null ) {%>
                    							<li><a href="<c:url value='/adminlogin.jsp'/>">Admin Login</a></li>
                                                <li><a href="<c:url value='/login.jsp'/>"> Customer Login</a></li>
                        <% } else {%>   
       
                       
                        
                        <% if(session.getAttribute("theAdmin")!=null) { %>
                         <li> Hello <c:out value="${theAdmin.getUsertype()}" /></li>
                         <% } else {%>
               
                         <li> Hello <c:out value="${theUser.getUsername()}" /></li>
                       <% } %>
                         <%} %>
                         <% if(session.getAttribute("theUser")!=null || session.getAttribute("theAdmin")!=null) { %>
                         <li><a href="<c:url value='/UserController?action=logout'/>">Logout</a></li>
                         <% } %>
                </ul>
            </nav>



        </div>
                <div id="bod"/>