<jsp:include page="/header.jsp" />


<section>
    
<h1>Thanks for joining our email list</h1>
<p>Here is the information that you entered:</p>

<label  class="no_pad_top">Email</label>
<span>${user.email}</span><br>
<label class="no_pad_top">First Name</label>
<span>${user.userName}</span><br>

</section>


<jsp:include page="/footer.jsp" />