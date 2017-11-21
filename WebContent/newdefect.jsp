
<%@page import="com.varun.data.UserDB"%>
<%@page import="com.varun.business.User"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<br>
<h3 id="page_name">Adding a New Request</h3>
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

<section id="newstudy_form">
         
<form action="<c:url value='/DefectController/add'/>" method="post">
        <label id="labelalter">Service request Title *</label>
        <input type="text" name="title" required /><br>
        <label id="labelalter">Model *</label> 
        <select id="drop" name="brand" >
  <option value="Honda" id="drop">Honda</option>
  <option value="Jeep" id="drop">Jeep</option>
  <option value="Hyundai" id="drop">Hyundai</option>
  <option value="KIA" id="drop">KIA</option>
  <option value="BMW" id="drop">BMW</option>
        </select><br><br>
        <label id="labelalter">Priority *</label> 
        <select id="drop" name="type"  >
  <option value="High" id="drop">High</option>
  <option value="Medium" id="drop">Medium</option>
  <option value="Low" id="drop">Low</option>
        </select><br><br>
        <div id="my_div"></div><br>
        <label id="labelalter">Request Description *</label>  
        <textarea name="description" required></textarea><br>
        <button type="submit"  id="submit_button">Submit</button>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>