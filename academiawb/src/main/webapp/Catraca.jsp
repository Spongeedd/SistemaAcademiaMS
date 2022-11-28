<%-- 
    Document   : Catraca
    Created on : 13 de nov de 2022, 19:53:29
    Author     : david
--%>
<%@page import="academiawb.model.db.DBConnector"%>
<%@page import="academiawb.model.service.CatracaService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Catraca</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <meta name="theme-color" content="#712cf9">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      td, th {
        padding: .7em;
        margin: 0;
        border: 1px solid #ccc;
        text-align: center;
      }

     td {
        font-weight:bold;
        background-color: #EEE;
      }
      table {
        margin: auto;
        width: 50%;
        table-layout: fixed;
        text-align: center;
      }
      table h1 {
        text-align: center;
      }

      #blocos ul li:hover,#blocos ul li:focus {
        text-decoration: none;
        background-color: #CEE5D0;
        font-size: 20px;
        transform: translateX(10px) scale(1.2);
      }
    
      #blocos ul li a{
        text-decoration: none;
        font-size: 20px;
        margin: 30px;
        color: #1C6758;         
      }
    
      #blocos ul li{
        display: inline-block;
        transition: transform 0.4s;
        transform: translateX(0) scale(0.8);
      }
    
      #blocos ul {
        list-style-type: none;
        background-color: #94B49F;
        text-align: center ;
        border: 0;
      }
      #blocos {
        border: 0;
        margin: 0;
      }
    </style>
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_aa28e844ee07386?autoReconnect=true&useSSL=false" user= "b918cc3160b707"  password= "16d9b4b7" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from acessoaluno
        </sql:query>
            <div class="container shadow-lg p-3 mb-5 rounded">
            <header class="d-flex flex-wrap justify-content-center mb-4 border-bottom p-3 text-bg-dark">
              <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-light text-decoration-none">
                <span class="fs-4">Sistema Academia</span>
              </a>
        
              <ul class="nav nav-pills">
                <li class="nav-item"><a href="index.jsp" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="Funcionario.jsp" class="nav-link">Funcionarios</a></li>
                <li class="nav-item"><a href="Exercicios.jsp" class="nav-link">Exercicios</a></li>
                <li class="nav-item"><a href="Matricula.jsp" class="nav-link">Matricula</a></li>
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
              </ul>
            </header>
        </div>
    <div class="container">
      <main>
        <div class="py-5 text-center">
          <h2>Aluno</h2>
          <h4>Plano</h3>
        </div>

        <div class="row g-5">
          <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">Dados</h4>
            <form class="needs-validation" action="CatracaServlet" method="POST" novalidate>
              <div class="row g-3">
                <div class="col-12">
                  <label for="loginID" class="form-label">Login</label>
                  <input type="text" name="login" class="form-control" id="loginID" placeholder="Seu Nome" value="" required>
                </div>

                <div class="col-12">
                  <label for="senha" class="form-label">Senha</label>
                  <input type="text" class="form-control" name="senha" id="senha" placeholder="Seu CPF">
                </div>

              <button class="w-100 btn btn-primary btn-lg" type="submit">Entrar</button>
            </form>
          </div>
        </div>
      </h1>
      <h3> Acessos do dia: 5</h3>
      <h4>Filtros de acesso:</h4>
      <div class="scrollable shadow-lg p-3 mb-5 rounded">
        <table class="table table-bordered text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Horário</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.idaluno}"/></td>
                        <td><c:out value="${row.nome}"/></td>
                        <td><c:out value="${row.data}"/></td> 
                    </tr>
                </c:forEach> 
            </tbody>    
        </table>
      </main>
    </div>
    <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
  </body>
</html>