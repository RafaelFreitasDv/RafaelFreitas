<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!--	Bootstrap	-->
    <%@ include file="header.jsp" %>
        <title>Health Track - Pressão Arterial</title>
</head>

<body>
    <main class="container containerConteudo">
        <header class="p-3 m-0 border-bottom border-dark">
            <h1 class="display-6 fs-3 text-center text-uppercase p-0 mb-0">Perfil</h1>
        </header>
        <div class="col-12 d-flex justify-content-center">
            <img class="ftPrfl" src="./resources/img/dfltPrfl.svg" alt="Foto de perfil do usuário">
        </div>        
            <input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
        <section class="row p-0 m-0 mb-3 text-center text-uppercase">
            <h2 class="col-12 display-6">
            	<label for="nmComida" class="col-form-label">${nmUser }</label>    			
			</h2>            
        </section>
        <section class="row p-0 m-0 mb-2">
            <h3 class="col-12 display-6 fs-4 text-uppercase">Conquistas</h3>
            <div class="col-12 rounded p-3 d-flex justify-content-center cardLinha">
                <img src="./resources/img/bdgDmnd.svg" alt="" class="bsBdg">
                <img src="./resources/img/bdgDlt.svg" alt="" class="bsBdg">
                <img src="./resources/img/bdgRds.svg" alt="" class="bsBdg">
            </div>
        </section>        
        <section class="row p-0 m-0 mb-3">
            <h3 class="col-12 display-6 fs-4 text-uppercase">BIO</h3>
            <div class="col-12 p-3 rounded cardLinha">${bioUser }
            </div>
        </section>
        
    </main>
	<!-- Menu de navegação -->
	<%@ include file="menu.jsp" %>
    <!-- Menu de navegação -->
    <%@ include file="menu.jsp" %>
    <!-- JS -->
    <%@ include file="footer.jsp" %>
</body>
</html>