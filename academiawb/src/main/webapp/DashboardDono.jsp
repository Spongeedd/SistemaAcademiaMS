<%-- Document   : Dashboard
    JSP Created on : 29 de nov de 2022
    Author     : Israel D. --%>
<%@page import="academiawb.model.db.DBConnector"%>
<%@page import="academiawb.model.service.CatracaService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard Dono</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/dashboard/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.2/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
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
    
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Academia EliteFit</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="navbar-nav">
    <div class="nav-item text-nowrap">
      <a class="nav-link px-3" href="#">Sair</a>
    </div>
  </div>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3 sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#">
              <span data-feather="home" class="align-text-bottom">
                Dashboard
              </span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Funcionario.jsp">
              <span data-feather="file" class="align-text-bottom">
                Funcionários
              </span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Matricula.jsp">
              <span data-feather="shopping-cart" class="align-text-bottom">
                Matrícula
              </span>
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
          <span>Gráfico</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle" class="align-text-bottom"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom"></span>
              Mês Atual
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom"></span>
              Mês Anterior
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom"></span>
              Prévios 5 Meses
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
    <div id="ativos">
    <h2>Vendas do mês</h2>
      <div class="table-responsive">
         <section>
          <div class="quadrado"> 
            <img class="imagens" src="https://imgur.com/qLGAraf.png" width=210 height=210>
            <h3>NÚMERO</h3>
            <p>Vendas</p>
          </div>

          <div class="quadrado">
            <img class="imagens" src="https://imgur.com/12nmrDn.png" width=210 height=210>
            <h3>NÚMERO</h3>
            <p>Faturamento</p>
          </div>

          <div class="quadrado">
            <img class="imagens" src="https://imgur.com/dsP9UXo.png" width=210 height=210>
            <h3>NÚMERO</h3>
            <p>Ticket Médio</p>
          </div>
      </div>
    </section>
    </div>

   <div id="expirados">
    <h2>Teste do dia</h2>
          <div class="quadrado" id="CS"> 
            <img class="imagens" src="Cart.png" width=210 height=210>
            <h3>NÚMERO</h3>
            <p>Vendas</p>
          </div>
   </div>
   </div>
  </main>
</div>


  <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script>
  <script src="dashboard.js"> </script>
  </body>
</html>