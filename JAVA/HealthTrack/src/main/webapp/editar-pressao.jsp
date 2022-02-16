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
				<form action="pressao" method="post">
				<input type="hidden" value="editar" name="acao">
				<input type="hidden" value="${pressao.cdPress }" name="cdPress">
				<div>
					<label for="vlPress" class="col-form-label">Pressão arterial</label>                                
					<input type="text" class="col-12 form-control" name="vlPress" id="vlPress" value="${pressao.vlPress }">
				</div>
				<div>
					<input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
				</div>
   				<div class="col-12">
					<label for="dtPress" class="col-form-label">Data</label>
       				<input type="date" class="col-12 form-control" name="dtPress" id="dtPress"  value="${pressao.dtPress }">
				</div>
				<div class="col-12">
    				<label for="hrPress" class="col-form-label">Hora</label>
    				<input type="text" class="col-12 form-control" name="hrPress" id="hrPress"  value="${pressao.hrPress }">
				</div>								
					<div class="d-flex justify-content-center p-3">
						<input type="submit"  value="Alterar!" class="btn btn-primary">
					<a href="pressao?acao=listar">
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