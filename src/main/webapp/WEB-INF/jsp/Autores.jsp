<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Todos os Autores</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
<body class="container" style="padding: 40px 50px 50px 40px; background-color: #20c997">
	
	<div class="panel panel-default">
	
		<div class="panel-heading" style="background-color: #e9ecef">
	  		<h1 class="text-center">Cadastro de Autores</h1>
	  	</div>
	  	
	  	<div class="panel-body">
			<form action="<c:url value="/autores"/>" method="POST" class="g3">
		
			<div class="form-group">
				<label for="ticker" class="form-label">Nome</label>
				<input type="text" id="nome" class="form-control" name="nome" required>
			</div>
			
			<div class="form-group">
				<label for="preco" class="form-label">Email</label>
				<input type="email" id="email" class="form-control" name="email" required>
			</div>
			
			<div class="form-group">
				<label for="data_nascimento" class="form-label">Data de Nascimento</label>
				<input type="date" id="data_nascimento" class="form-control" name="data_nascimento" required>
			</div>
	
			<div class="form-group">
				<label for="miniCurriculo" class="form-label">Mini Currículo</label>
				<textarea class="form-control" id="miniCurriculo" rows="3" name="mini_curriculo"></textarea>
			</div>
			<p/>
			<div style="text-align: center">
				<button class="btn btn-primary" type="submit">Cadastrar</button>
			</div>
		</form>
	  </div>
	</div>

	<hr style="margin: 40px"/>


	<div class="panel panel-default">
		<div class="panel-heading" style="background-color: #e9ecef">
			<h1 class="text-center">Lista de Autores</h1>
		</div>
	  <div class="panel-body">
	  	<table class="table table-hover table-striped">
			<thead class="table-dark">
				<tr>
					<th scope="col" class="text-center">NOME</th>
					<th scope="col" class="text-center">EMAIL</th>
					<th scope="col" class="text-center">DATA DE NASCIMENTO</th>			
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${autores}" var="aut">
					<tr>
						<td class="text-center">${aut.nome}</td>
						<td class="text-center">${aut.email}</td>
						<td class="text-center">${aut.dataNascimento}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	  </div>
	</div>
</body>
</html>