<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<!--	Bootstrap	-->
	<%@ include file="header.jsp" %>
	<title>Health Track - Atualizar atividade</title>
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
				<form action="atividade" method="post">
				<input type="hidden" value="editar" name="acao">
				<input type="hidden" value="${atividade.cdAtiv }" name="cdAtiv">
				<div>
					<label for="nmAtiv" class="col-form-label">Atividade</label>                                
					<input type="text" class="col-12 form-control" name="nmAtiv" id="nmAtiv" value="${atividade.nmAtiv }">
				</div>
				<div>
					<input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
				</div>
   				<div class="col-12">
					<label for="dtAtiv" class="col-form-label">Data</label>
       				<input type="date" class="col-12 form-control" name="dtAtiv" id="dtAtiv"  value="${atividade.dtAtiv }">
				</div>
				<div class="col-12">
    				<label for="hrAtiv" class="col-form-label">Hora</label>
    				<input type="text" class="col-12 form-control" name="hrAtiv" id="hrAtiv"  value="${atividade.hrAtiv }">
				</div>
				<div class="col-12">
    				<label for="valCal" class="col-form-label">Caloria</label>
    				<input type="text" class="col-12 form-control" name="valCal" id="valCal"  value="${atividade.valCal }">
				</div>				
					<div class="d-flex justify-content-center p-3">
						<input type="submit"  value="Alterar!" class="btn btn-primary">
					<a href="atividade?acao=listar">
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