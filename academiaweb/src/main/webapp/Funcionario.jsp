<%@page import="com.sistemaacademia.academiaweb.db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interface Dono</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link rel="icon" href="resources/imgs/icone.ico">
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
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
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
                                <c:forEach var="row" items="${result.rowsByIndex}">
                                    <tr>
                                    <c:forEach var="col" items="${row}">
                                        <td><c:out value="${col}"/></td>
                                    </c:forEach>
                                    <td><a href="#"  class="btn btn-outline-primary" role="button">Editar</a></td>
                                    <td><a href="#" class="btn btn-outline-danger" role="button">Excluir</a></td>
                                    </tr>
                                </c:forEach> 
                            </tbody>    
                        </table>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content">
                        <a href="CadastrarFuncionario.jsp" class="btn btn-primary" role="button" style="margin-top: 15px;">Cadastrar Novo</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
