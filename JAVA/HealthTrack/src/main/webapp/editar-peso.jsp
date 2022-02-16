<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<!--	Bootstrap	-->
	<%@ include file="header.jsp" %>
	<title>Health Track - Atualizar peso</title>
</head>
<body>
    <main class="container containerHistorico">        
    	<!-- 	Condicionais do POPPER	-->
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>			
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<!-- 	Formulário	-->
		<div class="modal-content mt-3">
			<div class="modal-header">
				<h5 class="modal-title">Editar atividade</h5>			
			</div>
			<div class="modal-body">
				<form action="peso" method="post">
				<input type="hidden" value="editar" name="acao">
				<input type="hidden" value="${peso.cdPeso }" name="cdPeso">
				<div>
					<label for="vlPeso" class="col-form-label">Pressão arterial</label>                                
					<input type="text" class="col-12 form-control" name="vlPeso" id="vlPeso" value="${peso.vlPeso }">
				</div>
				<div>
					<input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
				</div>
   				<div class="col-12">
					<label for="dtPeso" class="col-form-label">Data</label>
       				<input type="date" class="col-12 form-control" name="dtPeso" id="dtPeso"  value="${peso.dtPeso }">
				</div>
				<div class="col-12">
    				<label for="hrPeso" class="col-form-label">Hora</label>
    				<input type="text" class="col-12 form-control" name="hrPeso" id="hrPeso"  value="${peso.hrPeso }">
				</div>								
					<div class="d-flex justify-content-center p-3">
						<input type="submit"  value="Alterar!" class="btn btn-primary">
					<a href="peso?acao=listar">
							<img class="btnActn" data-bs-dismiss="modal" src="./resources/img/cancel.svg" alt="Cancela a atualização da atividade">
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