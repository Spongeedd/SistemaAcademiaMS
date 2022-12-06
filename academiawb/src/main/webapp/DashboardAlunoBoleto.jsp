<%-- 
    Document   : DashboardAlunoBoleto
    Created on : 29 de nov. de 2022, 17:47:39
    Author     : david
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="sidebars.css" rel="stylesheet">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sidebars/">
    <title>Dashboard Aluno</title>
    <style>

    td, tr {
        align-items: center;
        text-align: center;
    }

    tr {
        padding-right: 20px;
    }

    h1 {
      font-size: 20px;
    }
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
    .wrap-center{
      display: flex;
      width: 100%;
      justify-content: center;
      align-items: center;
    }
    h2{
      font-size: 16px;
    }

  </style>
</head>
<body>
  
  <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_aa28e844ee07386?autoReconnect=true&useSSL=false" user= "b918cc3160b707"  password= "16d9b4b7" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from matricula  WHERE idmatricula = ${param.id}
        </sql:query>
        <sql:query dataSource="${conexao}" var="boletos" >
           SELECT * FROM boletos WHERE idaluno = ${param.id}
        </sql:query>

  <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">

    <symbol id="home" viewBox="0 0 16 16">
      <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
    </symbol>
    <symbol id="table" viewBox="0 0 16 16">
      <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
    </symbol>

  </svg>
    <c:forEach var="row" items="${result.rows}">
  <main class="d-flex flex-nowrap">
  <h1 class="visually-hidden">Sidebars examples</h1>

  <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <svg class="bi pe-none me-2" width="40" height="32"><use xlink:href="logoAcademiaEliteFIT.png"/></svg>
      <span class="fs-4">Academia EliteFIT</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="DashboardAluno.jsp?id=<c:out value="${row.idmatricula}"/>" class="nav-link text-white">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
          Informações
        </a>
      </li>
      <li>
        <a href="#" class="nav-link active" aria-current="page">
        <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
      Boleto
      </a>
      </li>
    </ul>
    <hr>
    <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
        <img src="https://www.cambe.pr.leg.br/anonimo.jpg/image_preview" alt="" width="32" height="32" class="rounded-circle me-2">
        <strong><c:out value="${row.nome}"/></strong>
      </a>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
        <li><a class="dropdown-item" href="index.jsp">Sair</a></li>
    </ul>
    </div>
  </div>
  </c:forEach>
  <div class="b-example-divider b-example-vr"></div>
  <div class="wrap-center">
    
    <div class="col-md-8">
        <h1>Boletos</h1>
        <div class="scrollable shadow-lg p-3 mb-5 rounded">
            <table class="table table-bordered text-center">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Vencimento</th>
                        <th scope="col">Valor</th>
                        <th scope="col">ID</th>                      
                    </tr>    
                </thead>
                <tbody>
                    <c:forEach var="row" items="${boletos.rows}">
                        <tr>             
                            <td><c:out value="${row.vencimento}"/></td>
                            <td>R$ <c:out value="${row.valor}"/></td>
                            <td><c:out value="${row.idboletos}"/></td>                             
                            <td><a href="BoletoServlet?idboleto=<c:out value="${row.idboletos}"/>"  class="btn btn-outline-primary" name="pagar" role="button">Pagar</a></td>                          
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>