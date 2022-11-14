<%-- 
    Document   : Exercicios
    Created on : 13 de nov de 2022, 17:57:43
    Author     : david
--%>
<%@page import="academiawb.model.db.DBConnector"%>
<%@page import="academiawb.model.service.ExerciciosService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Exercícios</title>
    <style>
        h1 {
            text-align: center;
        }

        .table {
            text-align: center;
            border: 1px black solid;
            width: 90% !important; /*Importante manter o !important rs */
            margin: auto;



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
    <div class="container shadow-lg p-3 mb-5 rounded">
        <header class="d-flex flex-wrap justify-content-center mb-4 border-bottom p-3 text-bg-dark">
            <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-light text-decoration-none">
                <span class="fs-4">Sistema Academia</span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="index.jsp" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="Matricula.jsp" class="nav-link">Matricula</a></li>
                <li class="nav-item"><a href="Funcionario.jsp" class="nav-link">Funcionario</a></li>
                <li class="nav-item"><a href="Catraca.jsp" class="nav-link">Catraca</a></li>
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
            </ul>
        </header>
    </div>
    <h1>
        Cadastro de Exercícios
    </h1>
    <br>
    <div class="geral">
        <form action="ExerciciosServlet?op=a" method="POST">
            <div class="col-md-5">
                <label for="plano" class="form-label">Plano</label>
                <select class="form-select" name="plano" id="plano" required>
                  <option name="plano" value="Basico">Básico</option>
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
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>