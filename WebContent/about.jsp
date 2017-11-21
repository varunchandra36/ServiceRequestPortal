<%@page import="com.varun.data.UserDB"%>
<%@page import="com.varun.business.User"%>

<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>
<%-- Section tag is used to write description  --%>
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
<section id="how">
    <h3>About us</h3>
    <p>Expert service portal is a platform for its customers to make service requests and make an appointment </p>
    <p>The Aim of our request portal is to reduce wait time for customers and pre plan there car service </p>
<%-- Include tag is used to import footer page --%>
</section>
<%@include file="footer.jsp" %>