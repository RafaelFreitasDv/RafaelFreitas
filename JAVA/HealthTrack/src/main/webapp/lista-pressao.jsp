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
    <main class="container containerHistorico">
        <header class="p-3 m-0 border-bottom border-dark">
            <h1 class="display-6 fs-3 text-uppercase text-center p-0 m-0">Pressão Arterial</h1>
        </header>
        <section class="row text-center text-uppercase p-3 align-self-center">
            <div class="col-2">Data</div>
            <div class="col-3">Pressao</div>
            <div class="col-2">Hora</div>            
            <div class="col-2"></div>
        </section>
        <c:forEach items="${pressao }" var="p">
            <input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
            <section class="row cardLinha shadow-sm p-2 m-0 mb-3 rounded text-center">
                <div class="col-3">${p.dtPress }</div>
                <div class="col-3">${p.vlPress }</div>
                <div class="col-3">${p.hrPress }</div>                
                <div class="col-3 justify-content-center">
                    <c:url value="pressao" var="link">
                        <c:param name="acao" value="abrir-form-edicao" />
                        <c:param name="cdPress" value="${p.cdPress }" />
                    </c:url>
                    <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
                    <button type="button" class="btn btn-danger btn-xs" data-bs-toggle="modal"
                        data-bs-target="#excluirModal" onclick="cdPressExcluir.value = ${p.cdPress}">X</button>
                </div>
            </section>
        </c:forEach>
        <div class="d-flex justify-content-center">
            <img class="btnActn" data-bs-toggle="modal" data-bs-target="#addAtvdd" src="./resources/img/addItm.svg" alt="Botão para adicionar uma nova atividade">
        </div>
        <!--	Modal CADASTRO pressão -->        
        <div class="modal fade" id="addAtvdd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">            
            <div class="modal-dialog text-uppercase" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Cadastrar pressão arterial</h5>
                    </div>
                    <div class="modal-body">
                        <form action="pressao" method="post">
                            <input type="hidden" value="cadastrar" name="acao">                            
                            <div>
                                <input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
                            </div>
                            <div class="col-12">
                                <label for="vlPress" class="col-form-label">Pressão arterial</label>
                                <input type="text" class="col-12 form-control" name="vlPress" id="vlPress" placeholder="000.00">
                            </div>
                            <div class="col-12">
                                <label for="dtPress" class="col-form-label">Data</label>
                                <input type="date" class="col-12 form-control" name="dtPress" id="dtPress" placeholder="DD/MM/AAAA">
                            </div>
                            <div class="col-12">
                                <label for="hrPress" class="col-form-label">Hora</label>
                                <input type="text" class="col-12 form-control" name="hrPress" id="hrPress" placeholder="00h00">
                            </div>                            
                            <div class="d-flex justify-content-center p-3">                            	
                                <input type="submit" value="Adicionar!" class="btn btn-primary" src="./resources/img/cancel.svg">
                                <a href="pressao?acao=listar">
                                    <img class="btnActn" data-bs-dismiss="modal" src="./resources/img/cancel.svg" alt="Cancela a atualização da atividade">
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal EXCLUIR atividade -->        
        <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
            aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>                        
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir a atividade?
                    </div>
                    <div class="modal-footer">
                        <form action="pressao" method="post">
                            <input type="hidden" name="acao" value="excluir">
                            <input type="hidden" name="cdPress" id="cdPressExcluir">                            
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-danger">Excluir</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Menu de navegação -->
    <%@ include file="menu.jsp" %>
    <!-- JS -->
    <%@ include file="footer.jsp" %>
</body>
</html>