<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resource/css/style.css">
<link rel="stylesheet" href="resource/css/font-awesome.min.css">
<link href="resource/css/jquery.dataTables.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-sm-3">
				<h2>List User</h2>
			</div>
			<div class="col-sm-3 col-sm-offset-6">

				<div id="imaginary_container">
					<div class="input-group stylish-input-group">
						<input type="text" class="form-control" placeholder="Search" id="search">
						<span class="input-group-addon"> 
						<a id="btSearch">
								<button type="submit">Search</button>
						</a>
						</span>
					</div>
				</div>
			</div>
		</div>

		<br>

		<table id="example" class="display table-bordered" cellspacing="0"
			width="100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nama</th>
					<th>No HP</th>
					<th>E-Mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users }" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.nama}" /></td>
						<td><c:out value="${user.noHp}" /></td>
						<td><c:out value="${user.email}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div class="row">
			<div class="col-md-1 col-md-offset-11">
				<a href="UserController?action=add" type="button"
					class="btn btn-default">Add Data</a>
			</div>
		</div>
	</div>

	<script src="resource/jquery/jquery.min.js"></script>
	
	<script src="resource/jquery/jquery.dataTables.min.js"></script>
	<!--<script src="resource/bootstrap/js/dataTables.bootstrap.min.js"></script>-->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable({
				"paging" : false,
				"info" : false,
				"searching" : false
			});
			
			$('#search').change(function() {
				var text = $(this).val();
				$('#btSearch').attr("href","UserController?action=search&nama="+text);
			});
			
		});
	</script>
</body>
</html>