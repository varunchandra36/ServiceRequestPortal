
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <ul>
        
           <li><a href="<c:url value='/admin.jsp'/>"> Home</a></li>
        <li><a href="<c:url value='/alldefects.jsp'/>">All Defects</a></li>
        <li><a href="<c:url value='/pendingrequests.jsp'/>">Pending Requests</a></li>
       
    </ul>
</nav>
<section id="home_page">
    <%-- Img tag is used to import image --%>
    <img src="<c:url value='/images/car-servicing2.jpg'/>" alt="Home" height="500" width="1000" />
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>