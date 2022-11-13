<%@page import="academiawb.model.db.DBConnector"%>
<%@page import="academiawb.model.service.FuncionariosService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interface Dono</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

        <style>
            .container-tabela {
                margin-left: 165px;
            }
            .scrollable {
                height: 400px;
                width: fit-content;  
                overflow: scroll;
            }
        </style>
    </head>
    <body>
        <%
            Integer id;
        %>
        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_aa28e844ee07386?autoReconnect=true&useSSL=false" user= "b918cc3160b707"  password= "16d9b4b7" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from funcionario
        </sql:query>
        <div class="container shadow-lg p-3 mb-5 rounded">
            <header class="d-flex flex-wrap justify-content-center mb-4 border-bottom p-3 text-bg-dark">
              <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-light text-decoration-none">
                <span class="fs-4">Sistema Academia</span>
              </a>
        
              <ul class="nav nav-pills">
                <li class="nav-item"><a href="index.jsp" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="Matricula.jsp" class="nav-link">Matriculas</a></li>
                <li class="nav-item"><a href="Exercicios.jsp" class="nav-link">Exercicio</a></li>
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
              </ul>
            </header>
        </div>
        
            
        <div class="container-tabela">
            <div class="row">
                <h2>Funcionários Cadastrados</h2>
                <div class="col-md-8">
                    <div class="scrollable shadow-lg p-3 mb-5 rounded">
                        <table class="table table-bordered text-center">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">CPF</th>
                                    <th scope="col">D.Nascimento</th>
                                    <th scope="col">Endereço</th>
                                    <th scope="col">Telefone</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Jornada</th>
                                    <th scope="col">P/Hora</th>
                                    <th scope="col">Salário</th>
                                </tr>    
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${result.rows}">
                                    <tr>
                                        <td><c:out value="${row.idfuncionario}"/></td>
                                        <td><c:out value="${row.nome}"/></td>
                                        <td><c:out value="${row.cpf}"/></td>
                                        <td><c:out value="${row.nascimento}"/></td>
                                        <td><c:out value="${row.endereco}"/></td>
                                        <td><c:out value="${row.telefone}"/></td>
                                        <td><c:out value="${row.email}"/></td>
                                        <td><c:out value="${row.jornada}"/></td>
                                        <td><c:out value="${row.phora}"/></td>
                                        <td><c:out value="${row.salario}"/></td>
                                        <td><button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modalEditar">Editar</button></td>
                                        <td><a href="FuncionarioServlet?op=d&id=<c:out value="${row.idfuncionario}"/>"  class="btn btn-outline-danger" name="exlcuir" role="button">Excluir</a></td>
                                        
                                        <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="modalEditarTitle" aria-hidden="true">
                                            <form action="FuncionarioServlet?op=u&id=<c:out value="${row.idfuncionario}"/>" method="POST">
                                                <div class="modal-dialog modal-dialog-centered" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLongTitle">Editar Funcionario</h5>
                                                            <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="col-10">
                                                                <label for="nome" class="form-label">Nome</label>
                                                                <input type="text" class="form-control" name="nome" id="nome" placeholder="" value="" required>                                                       
                                                            </div>
                                                            <div class="col-sm-8">
                                                                <label for="cpf" class="form-label">CPF</label>
                                                                <input type="text" class="form-control" name="cpf" id="cpf" placeholder="CPF" required>
                                                                <label for="nascimento" class="form-label">Data Nascimento</label>
                                                                <input type="date" class="form-control" name="nascimento" placeholder="yyyy-mm-dd" id="nascimento" required>
                                                              </div>

                                                            <div class="col-12">
                                                                <label for="email" class="form-label">Email</label>
                                                                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>                                                        
                                                                <label for="endereco" class="form-label">Endereço</label>
                                                                <input type="text" class="form-control" name="endereco" id="endereco" placeholder="Rua... Nº Bairro..." required>
                                                            </div>

                                                            <div class="col-sm-8">
                                                                <label for="telefone" class="form-label">Telefone</label>
                                                                <input type="text" class="form-control" name="telefone" id="telefone" placeholder="(DDD)9XXXX-XXXX" required>
                                                            </div>

                                                            <hr class="my-4">
                                                            <h4 class="mb-">Pagamento</h4>
                                                            <div class="col-10">
                                                                <div class="col-md-6">
                                                                  <label for="jornada" class="form-label">Jornada</label>
                                                                  <input type="text" class="form-control" name="jornada" id="jornada" placeholder="" required>
                                                                  <label for="phora" class="form-label">Pagamento p/hora</label>
                                                                  <input type="text" class="form-control" name="phora" id="phora" placeholder="" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                          <button class="btn btn-primary" type="submit">Confirmar</button>
                                                        </div>
                                                  </div>
                                                </div>
                                            </form>
                                        </div>   
                                    </tr>
                                </c:forEach> 
                            </tbody>    
                        </table>
                    </div
                    <div class="d-grid gap-2 d-md-flex justify-content">
                        <a href="CadastrarFuncionario.jsp" class="btn btn-primary" role="button" style="margin-top: 15px;">Cadastrar Novo</a>
                    </div>
                </div>
            </div>
        </div>
            
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
