<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<!--	Bootstrap	-->
	<%@ include file="header.jsp" %>
	<title>Health Track - Atualizar alimento</title>
</head>
<body>
    <main class="container containerHistorico">
		<!-- 	Formulário	-->
		<div class="modal-content mt-3">
			<div class="modal-header">
				<h5 class="modal-title">Editar alimento</h5>			
			</div>
			<div class="modal-body">
				<form action="comida" method="post">
				<input type="hidden" value="editar" name="acao">
				<input type="hidden" value="${comida.cdComida }" name="cdComida">
				<div>
					<label for="nmComida" class="col-form-label">Alimento</label>                                
					<input type="text" class="col-12 form-control" name="nmComida" id="nmComida" value="${comida.nmComida }">
				</div>
				<div>
					<input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
				</div>
   				<div class="col-12">
					<label for="dtComida" class="col-form-label">Data</label>
       				<input type="date" class="col-12 form-control" name="dtComida" id="dtComida"  value="${comida.dtComida }">
				</div>
				<div class="col-12">
    				<label for="hrComida" class="col-form-label">Hora</label>
    				<input type="text" class="col-12 form-control" name="hrComida" id="hrComida"  value="${comida.hrComida }">
				</div>								
					<div class="d-flex justify-content-center p-3">
						<input type="submit"  value="Alterar!" class="btn btn-primary">
					<a href="comida?acao=listar">
							<img class="btnActn" data-bs-dismiss="modal" src="./resources/img/cancel.svg" alt="Cancela a atualização do alimento">
						</a>
					</div>
				</form>
			</div>
		</div>    
</main>    
<!-- Menu de navegação -->
<%@ include file="menu.jsp" %>
<!-- JS -->
<%@ include file="footer.jsp" %>
</body>
</html>