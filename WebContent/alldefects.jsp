<%@page import="com.varun.data.UserDB"%>

<%@page import="com.varun.business.Service"%>

<%@page import="com.varun.data.RequestDB"%>
<%@page import="com.varun.business.User"%>
<%@page import="java.util.List"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>



 <%-- Code to add new study   --%>
<nav id="menu">
    <ul>
        <% if(session.getAttribute("theAdmin")!=null){
          User user = (User) session.getAttribute("theAdmin");
           
        %>
           <li><a href="<c:url value='/admin.jsp'/>"> Home</a></li>
        <li><a href="<c:url value='/alldefects.jsp'/>">All Defects</a></li>
        <li><a href="<c:url value='/pendingrequests.jsp'/>">Pending Requests</a></li>
        
        
        
    </ul>
</nav>
        <% } %>

 
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that study and  Edit button to display edit page and edit study details in it--%>
<section id="studies_section">


    <table id="your_studies_table" >
        <tr>
            <th id="Study">Defect Title</th>
            <th>Defect Model</th>		
            <th>Description</th>
            <th>Customer</th>
            <th>Status</th>
        </tr>
        
        <% 
            User user = (User) session.getAttribute("theAdmin");
            if(session.getAttribute("theAdmin")!=null){
               
            List<Service> serviceRecords = RequestDB.getAllRequests();
            for(Service serviceRecord : serviceRecords){ %>
            <%if(serviceRecord!=null){ 
            
            
            %>
       <td><%= serviceRecord.getRequestTitle()%></td>
       <td><%= serviceRecord.getBrand() %></td>
       <td><%= serviceRecord.getRequestDescription()%></td>
       <td><%= serviceRecord.getRequestedByName()%></td>
       <td><%= serviceRecord.getRequestStatus()%></td>
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