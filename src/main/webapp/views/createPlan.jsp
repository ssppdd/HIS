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
<title>Create Plan</title>

</head>
  <body>

  	<p>
		<font color='green'>${msg}</font>
	</p>
	
<div class="container" id="wrap">
	  <div class="row">
        <div class="col-md-6 col-md-offset-3">	
	<form:form action="handlecreateplan" modelAttribute="plans" method="POST" class="form" role="form"> <legend>Create Plan</legend>
		<form:hidden path="planId"/>
                    
                        <div>
                        <label>Plan Name</label>
				<form:input type="text" path="planName" name="firstName" class="form-control input-lg" placeholder="Plan Name"  />
				</div>
			<div>
			<label>Plan Description</label>
                            <form:input type="text" path="planDesc" class="form-control input-lg" placeholder="Write some description here"  />
                             </div>
                    
           <div>
                        <label>Plan Start Date</label>
				<form:input type="date" path="startDate" class="form-control input-lg" placeholder="Start Date"  />
				</div>
			<div>
			<label>Plan End Date</label>
                            <form:input type="date" path="endDate" class="form-control input-lg" placeholder="End Date"  />
                             </div>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
                        Create</button>
                        <button class="btn btn-lg btn-secondary btn-block signup-btn" type="reset">
                        Reset</button>
                   
          </div>
          </div>
           </form:form>  
</div>            


	
  </body>
</html>