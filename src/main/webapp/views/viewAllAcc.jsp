<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<link href="./css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>	
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function deleteConfirm() {
		return confirm("Are you sure, you want to delete?");
	}
	function activateConfirm() {
		return confirm("Are you sure, you want to Activate User?");
	}
	
</script>
</head>
<body>

	<h3>Account Details</h3>

	<p>
		<font color='green'>${msg}</font>
	</p>
	
	<div  id="spd" >
	<table id="contactTbl" class="table" >
	
			<thead>
			<tr>
				<th scope="col">S.No</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accinfo}" var="c" varStatus="index">
				<tr>
					<th scope="row">${index.count}</th>
					<td>${c.firstName}&nbsp;${c.lastName}</td>
					<td>${c.email}</td>
					<td>${c.userRole}</td>
					<td><a href="editUser?uid=${c.userId}"> <img  src="imgs/edit_image.png"  width="35"  height="35"></a> |
					<c:choose>
                        <c:when test="${c.userActive}">
					    <a href="deleteUser?uid=${c.userId}" onclick="deleteConfirm()"><img  src="imgs/delete_image.jpg"  width="35"  height="35"></a>
					 	</c:when>
					 	<c:otherwise>
					 	<a href="activateUser?uid=${c.userId}" onclick="activateConfirm()"><font color="green">Activate</font></a>
					 	</c:otherwise>
					 	</c:choose>				
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>