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
                        <a class="nav-link" aria-current="page" href="#">
                        <i class="bi bi-speedometer2"></i>
                          <span data-feather="home" class="align-text-bottom">
                            Dashboard
                          </span>
                        </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Catraca.jsp">
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
                <div class="container-tabela">
                    <div class="row">
                        <h2>Alunos Cadastrados</h2>
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
                                            <th scope="col">Plano</th>
                                            <th scope="col">Pacote</th>
                                        </tr>    
                                    </thead>
                                    <tbody>
                                        <c:forEach var="row" items="${result.rows}">
                                            <tr>
                                                <td><c:out value="${row.idmatricula}"/></td>
                                                <td><c:out value="${row.nome}"/></td>
                                                <td><c:out value="${row.cpf}"/></td>
                                                <td><c:out value="${row.nascimento}"/></td>
                                                <td><c:out value="${row.endereco}"/></td>
                                                <td><c:out value="${row.telefone}"/></td>
                                                <td><c:out value="${row.email}"/></td>
                                                <td><c:out value="${row.plano}"/></td>
                                                <td><c:out value="${row.pacote}"/></td>
                                                <td><button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modalEditar" data-id="<c:out value="${row.idmatricula}"/>">Editar</button></td>
                                                <td><a href="MatriculaFuncServlet?op=d&id=<c:out value="${row.idmatricula}"/>"  class="btn btn-outline-danger" name="exlcuir" role="button">Excluir</a></td>                                
                                            </tr>
                                        </c:forEach> 
                                    </tbody>   
                                </table>
                            </div>
                            <div class="d-grid gap-2 d-md-flex justify-content">
                                <a href="CadastrarMatriculaFunc.jsp" class="btn btn-primary" role="button">Cadastrar Novo</a>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="modalEditarTitle" aria-hidden="true">
                <form action="MatriculaFuncServlet?op=u" method="POST">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Editar Matricula</h5>
                                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="col-md-4">
                                    <label for="id" class="form-label">ID</label>
                                    <input type="text" class="form-control" name="id" id="id" placeholder="" value="" required>      
                                </div>
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
                                <div class="col-md-5">
                                    <label for="plano" class="form-label">Plano</label>
                                    <select class="form-select" name="plano" id="plano" required>
                                      <option name="plano" value="Basico">Básico</option>
                                      <option name="plano" value="Intermediario">Intermediário</option>
                                      <option name="plano" value="Premium">Premium</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="pacote" name="pacote" class="form-label">Pacote</label>
                                    <select class="form-select" id="pacote" required>
                                            <option name="pacote" value="Mensal">Mensal</option>
                                            <option name="pacote" value="Trimestral">Trimestral</option>
                                            <option name="pacote" value="Anual">Anual</option>
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
        </div>
    </div>
    <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        $('#modalEditar').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) 
        var recipient = button.data('id')
        var modal = $(this)
        modal.find('.modal-body .col-md-4 input').val(recipient)
        })
    </script>
</body>
</html>