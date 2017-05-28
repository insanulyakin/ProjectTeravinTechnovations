<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/style.css">
</head>
<body>
	<div class="container conn">
		<h2>CREATE USER</h2>
		<form class="form-horizontal" method="post" action="UserController" id="form">
			<div class="form-group">
				<label class="control-label col-sm-1">Nama</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" placeholder="Nama" name="nama" maxlength="50" data-error="Nama belum diisi" required>
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-1">No. HP</label>
				<div class="col-sm-5">
					<input type="text" pattern="^[_0-9]{1,}$" data-minlength="10" class="form-control" placeholder="ex. 0852xxx" name="noHp" data-error="Min 10 karakter dan hanya nomor" required>
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-1">E-Mail</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" placeholder="example@domain.com" name="email" data-error="Email Anda Salah" required>
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div id="textAlamat">
			<div class="form-group">
				<label class="control-label col-sm-1" for="email">Alamat</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" placeholder="Alamat 1" name="alamat1" data-error="Alamat belum diisi" required>
					<div class="help-block with-errors"></div>
				</div>
				<button type="button" class="btn btn-default" id="tambahAlamat">+</button>
				<button type="button" class="btn btn-default" id="hapusAlamat">-</button>
			</div></div>
			<div class="alamat"></div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<div class="help-block with-errors"></div>
					<button type="submit" class="btn btn-default">Create</button>
					<a type="UserController?action=list" class="btn btn-default" href="">Back</a>
				</div>
			</div>
		</form>
	</div>


	<script src="resource/jquery/jquery.min.js"></script>
	<script src="resource/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			var x = 2;
			
			$("#hapusAlamat").hide();
			$("#tambahAlamat").click(function() {
				$("#hapusAlamat").show();
				
				var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBox' + x);
				newTextBoxDiv.after().html('<div class="form-group"><label class="control-label col-sm-1"></label><div class="col-sm-5"><input type="text" class="form-control"  placeholder="Alamat ' + x + '" name="alamat' + x + '" required></div></div>');
				newTextBoxDiv.appendTo("#textAlamat");
				x++;
			});
			
			$("#hapusAlamat").click(function() {
				x--;
				$("#TextBox" + x).remove();
				
				if (x == 2) {
					$("#hapusAlamat").hide();
					return false;
				}
			});
			
			$('#form').validator();
		});
	</script>

</body>
</html>