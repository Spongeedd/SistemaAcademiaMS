<%-- 
    Document   : Exercicios
    Created on : 13 de nov de 2022, 17:57:43
    Author     : david
--%>
<%@page import="com.academia.model.db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Exercícios</title>
    <style>
        h1 {
            text-align: center;
        }
        .geral {
            width: 90% !important; /*Importante manter o !important rs */
            margin: auto;
        }
    </style>

</head>
<body>
    <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_aa28e844ee07386?autoReconnect=true&useSSL=false" user= "b918cc3160b707"  password= "16d9b4b7" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from exercicios
        </sql:query>
        <sql:query dataSource="${conexao}" var="matricula" >
            select * from matricula
        </sql:query>
    <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Academia EliteFit</a>
        <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-nav">
            <div class="nav-item text-nowrap">
                <a class="nav-link px-3" href="index.jsp">Sair</a>
            </div>
        </div>
    </header>       
    <div class="container-fluid">
        <div class="row">
            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="position-sticky pt-3 sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="DashboardFunc.jsp">
                        <i class="bi bi-speedometer2"></i>
                          <span data-feather="home" class="align-text-bottom">
                            Dashboard
                          </span>
                        </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i class="bi bi-building"></i>
                                <span data-feather="file" class="align-text-bottom">
                                Catraca
                                </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Exercicios.jsp">
                                <i class="bi bi-journal"></i>
                                <span data-feather="file" class="align-text-bottom">
                                 Exercícios
                                </span>
                            </a>
                        </li>
                    </ul>          
                </div>
            </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">    
            <h1>
                Cadastro de Exercícios
            </h1>
            <br>
            <form action="ExerciciosServlet?op=a" method="POST">
                <div class="col-md-5">
                    <label for="plano" class="form-label">Plano</label>
                    <select class="form-select" name="plano" id="plano" required>
                      <option name="plano" value="Intermediario">Intermediário</option>
                      <option name="plano" value="Premium">Premium</option>
                    </select>
                </div>
                <div class="col-10">
                    <label for="Descrição">Descrição</label>
                    <textarea class="form-control" name="descricao" id="Descrição" rows="3"></textarea>                                                      
                </div>
                <div class="col-10">
                    <label for="serie" class="form-label">Série</label>
                    <input type="text" class="form-control" name="serie" id="serie" placeholder="" value="" required>
                    <label for="repeticoes" class="form-label">Repetições</label>
                    <input type="text" class="form-control" name="repeticoes" id="repeticoes" placeholder="" value="" required>         
                </div>
                <br>
                <div class="col-md-5">
                    <button class="w-100 btn btn-primary btn-lg" style="margin-bottom: 20px;" type="submit">Cadastrar</button>
                </div>
            </form>
            <br>
            <div class="container-tabela">
                <div class="row">
                    <h2>Exercícios Cadastrados</h2>
                    <div class="col-md-12">
                        <div class="scrollable shadow-lg p-3 mb-5 rounded">
                            <table class="table table-bordered text-center">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Plano</th>
                                        <th scope="col">Descrição</th>
                                        <th scope="col">Série</th>
                                        <th scope="col">Repetições</th>
                                    </tr>    
                                </thead>
                                <tbody>
                                    <c:forEach var="row" items="${result.rows}">
                                        <tr>
                                            <td><c:out value="${row.idexercicios}"/></td>
                                            <td><c:out value="${row.plano}"/></td>
                                            <td><c:out value="${row.descricao}"/></td>
                                            <td><c:out value="${row.serie}"/></td>
                                            <td><c:out value="${row.repeticoes}"/></td>  
                                            <td><a href="ExerciciosServlet?op=d&id=<c:out value="${row.idexercicios}"/>"  class="btn btn-outline-danger" name="exlcuir" role="button">Excluir</a></td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>    
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <h2>Alunos Cadastrados</h2>
            <div class="col-md-8">
                <div class="scrollable shadow-lg p-3 mb-5 rounded">
                    <table class="table table-bordered text-center">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nome</th>
                                <th scope="col">CPF</th>
                                <th scope="col">Plano</th>
                                <th scope="col">Ficha</th>
                            </tr>    
                        </thead>
                        <tbody>
                            <c:forEach var="row" items="${matricula.rows}">
                                <tr>
                                    <c:if test = "${row.plano != 'Basico'}">
                                        <td><c:out value="${row.idmatricula}"/></td>
                                        <td><c:out value="${row.nome}"/></td>
                                        <td><c:out value="${row.cpf}"/></td>
                                        <td><c:out value="${row.plano}"/></td>
                                        <td><c:out value="${row.ficha}"/></td>
                                        <td><button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modalAtribuir" data-id="<c:out value="${row.idmatricula}"/>">Atribuir</button></td>
                                        <td><a href="ExerciciosServlet?op=dt&idficha=<c:out value="${row.ficha}"/>"  class="btn btn-outline-danger" name="exlcuir" role="button">Excluir</a></td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
        </div>
    </div>
    <div class="modal fade" id="modalAtribuir" tabindex="-1" role="dialog" aria-labelledby="modalAtribuirTitle" aria-hidden="true">
        <form action="ExerciciosServlet?op=at" method="POST">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Atribuir Ficha</h5>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-4">
                            <div class="col-10">
                                <label for="id" class="form-label">ID</label>
                                <input type="text" class="form-control" name="id" id="id" placeholder="" value="">                                                       
                            </div>
                            <label for="at-exercicio" name="at-exercicio" class="form-label">ID-Ficha</label>
                            <select name="ficha" class="form-select" id="ficha" required>
                                <c:forEach var="row" items="${result.rows}">
                                    <option name="ficha" value="<c:out value="${row.idexercicios}"/>"><c:out value="${row.idexercicios}"/></option> 
                                 </c:forEach>                                                                                                                   
                            </select>
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
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        $('#modalAtribuir').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) 
        var recipient = button.data('id')
        var modal = $(this)
        modal.find('.modal-body .col-10 input').val(recipient)
        })
    </script>
    </body>
</html>