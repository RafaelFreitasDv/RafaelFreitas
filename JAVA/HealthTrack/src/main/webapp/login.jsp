<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!--	Bootstrap	-->
    <%@ include file="header.jsp" %>
        <title>HEALTH TRACK</title>
</head>

<body>
    <main class="container">
        <header class="row d-flex justify-content-center">
            <img class="col-12 loginHeader" src="./resources/img/lgnHdr.svg" alt="Nome do aplicativo">
        </header>
        <section class="row p-0 mb-3">
            <form class="col-12 text-uppercase d-grid gap-2">
                <label for="lgnEml" class="form-label">Login</label>
                <input type="email" class="form-control" id="login" placeholder="seuemail@dominio.com">
                <label for="lgnPswrd" class="form-label">Senha</label>
                <input class="form-control mb-3" id="lgnPswrd" placeholder="Digite sua senha">
                <a href="index.jsp" class="btn btn-primary p-3">Login</a>
            </form>
        </section>
        <section class="row text-center">
            <p class="col-12">Quer se cadastrar? <a href="cadastro-usuario.jsp">Cliqui aqui!</a></p>
            <p class="col-12">Esqueceu a sua senha? <a href="#">Clique aqui!</a></p>
        </section>
    </main>
    <!-- JS -->
    <%@ include file="footer.jsp" %>
</body>

</html>