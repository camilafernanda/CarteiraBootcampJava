<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de Transações</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center bg-info text-dark">Formulário de Transações</h1>
	<form action="<c:url value="/transacoes"/>" method="POST">
		<div class="form-group">
			<label for="ticker">Ticker</label>
			<input id="ticker" class="form-control" name="ticker">
		</div>
		<div class="form-group">
			<label for="preco">Preço</label>
			<input id="preco" class="form-control" name= "preco">
		</div>
		<div class="form-group">
			<label for="quantidade">Quantidade</label>
			<input id="quantidade" class="form-control" name="quantidade">
		</div>
		<div class="form-group">
			<label for="data">Data</label>
			<input id="data" class="form-control" name="data">
		</div>
		<div class="form-group">
			<label for="tipo">Tipo</label>
			<input id="tipo" class="form-control" name="tipo">
		</div>
		
		<input type="submit" value="Gravar" class="mt-3 mb-3 btn btn-outline-info">
	</form>
	<h1 class="text-center bg-info text-dark">Lista de Transações</h1>
	<table class="table table-hover table-dark table-bordered border-primary table-striped">
		<thead class="table-dark">
			<tr>
				<th>TICKER</th>
				<th>PREÇO</th>
				<th>QUANTIDADE</th>
				<th>DATA</th>
				<th>TIPO</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${transacoes}" var="t">
					<tr>
						<td>${t.ticker}</td>
						<td>${t.preco}</td>
						<td>${t.quantidade}</td>
						<td>${t.data}</td>
						<td>${t.tipo}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>