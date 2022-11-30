<%@page import="com.academia.model.db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard Dono</title>

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
      .container-tabela {
        margin-left: 25px;
      }
      .container-tabela h2 {
        margin-top: 20px;
        margin-bottom: 10px;
      }
      .scrollable {
        height: 400px;
        width: fit-content;  
        overflow: scroll;
      }
</style>
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  </head>
  <body>

    <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_aa28e844ee07386?autoReconnect=true&useSSL=false" user= "b918cc3160b707"  password= "16d9b4b7" />
    <sql:query dataSource="${conexao}" var="result" >
        select * from funcionario
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
                        <a class="nav-link" aria-current="page" href="DashboardDono.jsp">
                        <i class="bi bi-speedometer2"></i>
                          <span data-feather="home" class="align-text-bottom">
                            Dashboard
                          </span>
                        </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Funcionario.jsp">
                                <i class="bi bi-building"></i>
                                <span data-feather="file" class="align-text-bottom">
                                Funcionários
                                </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="MatriculaDono.jsp">
                                <i class="bi bi-people-fill"></i>
                                <span data-feather="shopping-cart" class="align-text-bottom">
                                  Matrícula
                                </span>
                            </a>
                        </li>
                    </ul>          
                </div>
            </nav>
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
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
                                                <td><button type="button" class="btn btn-outline-primary" name="editar" data-bs-toggle="modal" data-bs-target="#modalEditar" data-id="<c:out value="${row.idfuncionario}"/>" role="button">Editar</button></td>
                                                <td><a href="FuncionarioServlet?op=d&id=<c:out value="${row.idfuncionario}"/>"  class="btn btn-outline-danger" name="exlcuir" role="button">Excluir</a></td>                            
                                            </tr>
                                        </c:forEach> 
                                    </tbody>    
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content">
                        <a href="CadastrarFuncionario.jsp" class="btn btn-primary" role="button" style="margin-top: 15px;">Cadastrar Novo</a>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="modalEditarTitle" aria-hidden="true">
        <form action="FuncionarioServlet?op=u" method="POST">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Editar Funcionario</h5>
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