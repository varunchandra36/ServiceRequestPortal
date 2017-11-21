<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>
<%-- Section to input login details --%>

  <img src="<c:url value='/images/expert.jpg'/>" alt="Home" width="200" height="50"/>
<h3 id="login_ame">ADMIN LOGIN</h3>

<section id="login_form">
    <%-- Code to create login form--%>
    <form action="<c:url value='/UserController/login'/>" method="post">
        <input type="hidden" name="action" value="adminlogin">
        <label >Email Address *</label>
        <input type="email" name="email" required/> <br><br>
        <label> Password *</label>
        <input type="password" name="password" required/><br>
        <%
if(session.getAttribute("wrong_uname_pass") != null){
%>
<script>

<p id="logindetails" style="color:red">*****Wrong Email or password*****</p>
</script>

<%
session.removeAttribute("wrong_uname_pass");
}

%>
        <label>&nbsp;</label>
        <input type="submit" value="Login" id="login_button" name="login" >
        <br>
    </form>
    <%-- Code to go to Sign up for a new account  --%>
    <p>Any problem with the login contact Manager</p>

</section>
    <%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp" %>