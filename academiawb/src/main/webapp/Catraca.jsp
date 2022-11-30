<%-- Document   : Dashboard
    JSP Created on : 29 de nov de 2022
    Author     : Israel D. --%>
<%@page import="com.academia.model.db.DBConnector"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard Funcionario</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/dashboard/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.2/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


    <style>

        .scrollable {
            height: 400px;
            width: fit-content;  
            overflow: scroll;
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

      h2 {
        margin-top: 12px;
      }

      section {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
  	  }

      .quadrado {
        border: inset 2px #8611FD;
        padding-top: 20px;
        margin-right: 30px;
        background-color: #eadef6;
        border-radius: 22px;
        margin-bottom: 12px;
        max-width: 250px;
        text-decoration: none;
        color: #000000;
      }

      .imagens {
        width: 55px;
        height: auto;
        margin: auto;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .quadrado p {
        margin-left: 6px;
        margin-right: 6px;
        text-align: center;
      }
      .quadrado h3 {
        font-size: 20px;
        margin-left: 65px;
        margin-right: 65px;
        margin-bottom: 2px;
        margin-top: 5px;
        text-align: center;
      }

      #expirados {
        visibility: hidden;
      }
</style>
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  </head>
<body>
    <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_aa28e844ee07386?autoReconnect=true&useSSL=false" user= "b918cc3160b707"  password= "16d9b4b7" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from acessoaluno
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
            <div class="row g-5">
                <div class="col-md-7 col-lg-8">
                  <h4 class="mb-3">Dados</h4>
                    <form class="needs-validation" action="CatracaServlet" method="POST" novalidate>
                        <div class="row g-3">
                            <div class="col-12">
                                <label for="loginID" class="form-label">Login</label>
                                <input type="text" name="login" class="form-control" id="loginID" value="" required>
                            </div>
                            <div class="col-12">
                                <label for="senha" class="form-label">Senha</label>
                                <input type="text" class="form-control" name="senha" id="senha">
                            </div>
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Entrar</button>
                        </div>
                    </form>                     
                </div>
            </div>
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
            </div>
     </main>
    </div>
</div>
    <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</body>
</html>