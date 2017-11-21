 <%@page import="com.varun.data.UserDB"%>
<%@page import="java.util.List"%>
<%@page import="com.varun.business.User"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Code to display items in List --%>
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

<%-- Section tag is used to write description  --%>
<section>
    <img src="<c:url value='/images/car-servicing2.jpg'/>" alt="Home" width="1000" height="500"/>
    
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>