<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<!--	Bootstrap	-->
	<%@ include file="header.jsp" %>
		<title>Health Track - Cadastra usuario</title>
</head>

<body>
	<main class="container">
		<header class="row d-flex justify-content-center">
			<img class="col-12 loginHeader" src="./resources/img/cdstrHdr.svg" alt="Bem vindo!">
		</header>
		<!-- 	Formulário  de cadastro	-->
		<section class="row p-0 mb-3">
			<form class="col-12 text-uppercase d-grid gap-2" action="usuario" method="post">
				<input type="hidden" value="cadastrar" name="acao">
				
				<label for="nmUsuario" class="col-12 form-label">Nome</label>
				<input type="text" class="col-12 form-control" name="nmUsuario" id="nmUsuario" placeholder="João da Silva Sauro">
				
				<label for="dtNasc" class="col-4 form-label">Data de Nascimento</label>
				<input type="date" class="col-4 form-control" name="dtNasc" id="dtNasc" placeholder="DD/MM/AAAA">
				
				<label for="dsEmail" class="form-label">E-mail</label>
				<input type="email" class="form-control" name="dsEmail" id="dsEmail" placeholder="seuemail@dominio.com">
				
				<label for="dsSenha" class="form-label">Senha</label>
				<input type="text" class="form-control" name="dsSenha" id="dsSenha" placeholder="Digite uma senha">
				
				<label for="dsBio" class="form-label">Bio</label>
				<textarea class="form-control" name="dsBio" id="dsBio" placeholder="Fale um pouco sobre você! :D"></textarea>
				
				<button type="submit" class="text-uppercase btn btn-primary p-3 mb-3">Me cadastrar!</button>
			</form>
		</section>
	</main>	
	<!-- JS -->
	<%@ include file="footer.jsp" %>
</body>

</html>