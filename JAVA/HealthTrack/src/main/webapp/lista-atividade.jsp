<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!--	Bootstrap	-->
    <%@ include file="header.jsp" %>
        <title>Health Track - Histórico de Atividades</title>
</head>

<body>
    <main class="container containerHistorico">
        <header class="p-3 m-0 border-bottom border-dark">
            <h1 class="display-6 fs-3 text-uppercase text-center p-0 m-0">Histórico de atividades</h1>
        </header>
        <section class="row text-center text-uppercase p-3 align-self-center">
            <div class="col-2">Data</div>
            <div class="col-3">Atividade</div>
            <div class="col-2">Hora</div>
            <div class="col-3">Calorias gastas</div>
            <div class="col-2"></div>
        </section>
        <c:forEach items="${atividades }" var="a">
            <input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
            <section class="row cardLinha shadow-sm p-2 m-0 mb-3 rounded text-center">
                <div class="col-2">${a.dtAtiv }</div>
                <div class="col-3">${a.nmAtiv }</div>
                <div class="col-2">${a.hrAtiv }</div>
                <div class="col-3">${a.valCal }</div>
                <div class="col-2 justify-content-center">
                    <c:url value="atividade" var="link">
                        <c:param name="acao" value="abrir-form-edicao" />
                        <c:param name="cdAtiv" value="${a.cdAtiv }" />
                    </c:url>
                    <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
                    <button type="button" class="btn btn-danger btn-xs" data-bs-toggle="modal"
                        data-bs-target="#excluirModal" onclick="cdAtivExcluir.value = ${a.cdAtiv}">X</button>
                </div>
            </section>
        </c:forEach>
        <div class="d-flex justify-content-center">
            <img class="btnActn" data-bs-toggle="modal" data-bs-target="#addAtvdd" src="./resources/img/addItm.svg" alt="Botão para adicionar uma nova atividade">
        </div>
        <!--	Modal CADASTRO atividades -->        
        <div class="modal fade" id="addAtvdd" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog text-uppercase">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Cadastrar atividade</h5>
                    </div>
                    <div class="modal-body">
                        <form action="atividade" method="post">
                            <input type="hidden" value="cadastrar" name="acao">
                            <div class="col-12">                            
                                <label for="n-atividade" class="col-form-label">Atividade</label>
                                <input type="text" class="col-12 form-control" name="nmAtiv" id="n-atividade"
                                    placeholder="Alongamento, corrida e etc...">
                            </div>                            
                            <div>
                                <input type="hidden" value="4" name="cdUsuario" id="cdUsuario">
                            </div>                            
                            <div class="col-12">
                                <label for="d-atividade" class="col-form-label">Data</label>
                                <input type="date" class="col-12 form-control" name="dtAtiv"
                                    id="d-atividade" placeholder="DD/MM/AAAA">
                            </div>
                            <div class="col-12">
                                <label for="h-atividade" class="col-form-label">Hora</label>
                                <input type="text" class="col-12 form-control" name="hrAtiv" id="h-atividade"
                                    placeholder="00h00">
                            </div>
                            <div class="col-12">
                                <label for="v-caloria" class="col-form-label">Caloria</label>
                                <input type="text" class="col-12 form-control" name="valCal" id="v-caloria"
                                    placeholder="0 Kcal">
                            </div>
                            <div class="d-flex justify-content-center p-3">                            	
                                <input type="submit" value="Adicionar!" class="btn btn-primary"
                                    src="./resources/img/cancel.svg">
                                <a href="atividade?acao=listar">
                                    <img class="btnActn" data-bs-dismiss="modal"
                                        src="./resources/img/cancel.svg"
                                        alt="Cancela a atualização da atividade">
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
                        <form action="atividade" method="post">
                            <input type="hidden" name="acao" value="excluir">
                            <input type="hidden" name="cdAtiv" id="cdAtivExcluir">                            
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