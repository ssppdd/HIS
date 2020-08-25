<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<link href="./css/style.css" rel="stylesheet">
<title>Create Account</title>

</head>
  <body>

  	<p>
		<font color='green'>${msg}</font>
	</p>
	
<div class="container" id="wrap">
	  <div class="row">
        <div class="col-md-6 col-md-offset-3">	
	<form:form action="handlecreatebtn" modelAttribute="createacc" method="POST" class="form" role="form"> <legend>Create Account</legend>
		<form:hidden path="userId"/>
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
				<form:input type="text" path="firstName" name="firstname" class="form-control input-lg" placeholder="First Name"  />
				</div>
			<div class="col-xs-6 col-md-6">
                            <form:input type="text" path="lastName" name="lastname" class="form-control input-lg" placeholder="Last Name"  />
                             </div>
                    </div>
                    
			<form:input type="text" path="email" name="email" class="form-control input-lg" placeholder="Your Email"  />
						<font color='red'><div id="dupEmail"> </div></font>	
													
 <label>Gender : </label>                    <label class="radio-inline">
                        <form:radiobutton name="gender" path="gender" value="Male" id="gender" />                        Male
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton name="gender" path="gender" value="Fe-male" id="gender" />                        Female
                    </label>
                    <br />
			
				<div class="row">		
			<div class="col-xs-4 col-md-4">
				<label>Role</label>
				<form:select path="userRole" class = "form-control input-lg">
						<form:option value="">-Select-</form:option>
						<form:option value="Admin">Admin</form:option>
						<form:option value="Case Worker">Case Worker</form:option>
					</form:select>
			 </div>
            			
				<br />
              <span class="help-block">By clicking Create my account, you agree to our Terms and that you have read our Data Use Policy, including our Cookie Use.</span>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
                        Create</button>
                        <button class="btn btn-lg btn-secondary btn-block signup-btn" type="reset">
                        Reset</button>
                   
          </div>
           </form:form>  
</div>            
</div>
</div>
	
  </body>
</html>