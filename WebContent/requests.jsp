
<%@page import="com.varun.data.UserDB"%>

<%@page import="com.varun.business.Service"%>

<%@page import="com.varun.data.RequestDB"%>
<%@page import="com.varun.business.User"%>
<%@page import="java.util.List"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>



 
<nav id="menu">
    <ul>
        <% if(session.getAttribute("theUser")!=null){
          User user = (User) session.getAttribute("theUser");
            UserDB.getuserbyemail(user.getEmail());
          
        
        %>
           <li><a href="<c:url value='/main.jsp'/>"> Home</a></li>
        <li><a href="<c:url value='/requests.jsp'/>">Your Service Requests</a></li>
        <li><a href="<c:url value='/newdefect.jsp'/>">New Service Request</a></li>
        <li><a href="<c:url value='/about.jsp'/>">About</a></li>
        
    </ul>
</nav>
        <% } %>

 
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that study and  Edit button to display edit page and edit study details in it--%>
<section id="studies_section">


    <table id="#your_studies_table" >
        <tr>
            <th id="Study">Request Title</th>
            <th>Car Make</th>	
            <th>Priority</th>	
            <th>Description</th>
            <th>Status</th>
            <th>Date</th>
        </tr>
        
        <% 
            User user = (User) session.getAttribute("theUser");
            if(session.getAttribute("theUser")!=null){
            List<Service> serviceRecords = RequestDB.getAllMyRequests(user.getEmail());
            for(Service serviceRecord : serviceRecords){ %>
            <%if(serviceRecord!=null){ 
            
            
            %>
       <td><%= serviceRecord.getRequestTitle()%></td>
       <td><%= serviceRecord.getBrand() %></td>
       <td><%= serviceRecord.getType() %></td>
       <td><%= serviceRecord.getRequestDescription()%></td>
       <td><%= serviceRecord.getRequestStatus() %></td>
       <td><%= serviceRecord.getUpdate() %></td>
        </tr>
                
                
          <%  }
            
            }

            
        }  
else { %>

<p>not displaying</p>
<%

}        %>    
        <tr>
           

    
      
    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>