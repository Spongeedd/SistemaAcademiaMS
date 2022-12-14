<%@page import="com.academia.model.db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard Dono</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link rel="icon" href="resources/imgs/icone.ico">
        <style>
            .container-tabela{
                margin-left: 20px;
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
                                    Funcion??rios
                                    </span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="MatriculaDono.jsp">
                                    <i class="bi bi-people-fill"></i>
                                    <span data-feather="shopping-cart" class="align-text-bottom">
                                      Matr??cula
                                    </span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Log.jsp">
                                     <i class="bi bi-list"></i>
                                    <span data-feather="shopping-cart" class="align-text-bottom">
                                      Logs
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
                                    <th scope="col">Endere??o</th>
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
                                        <td><a href="MatriculaServlet?op=d&id=<c:out value="${row.idmatricula}"/>"  class="btn btn-outline-danger" name="exlcuir" role="button">Excluir</a></td>                                
                                    </tr>
                                </c:forEach> 
                            </tbody>   
                        </table>               
                </div>
                <div class="d-grid gap-2 d-md-flex justify-content">
                    <a href="CadastrarMatricula.jsp" class="btn btn-primary" role="button">Cadastrar Novo</a>
                </div>   
            </main>
        </div>
    </div>
                    
    <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="modalEditarTitle" aria-hidden="true">
        <form action="MatriculaServlet?op=u" method="POST">
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
                            <label for="endereco" class="form-label">Endere??o</label>
                            <input type="text" class="form-control" name="endereco" id="endereco" placeholder="Rua... N?? Bairro..." required>
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
                              <option name="plano" value="Basico">B??sico</option>
                              <option name="plano" value="Intermediario">Intermedi??rio</option>
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
