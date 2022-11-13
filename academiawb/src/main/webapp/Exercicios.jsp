<%-- 
    Document   : Exercicios
    Created on : 13 de nov de 2022, 17:57:43
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <div class="container shadow-lg p-3 mb-5 rounded">
        <header class="d-flex flex-wrap justify-content-center mb-4 border-bottom p-3 text-bg-dark">
            <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-light text-decoration-none">
                <span class="fs-4">Sistema Academia</span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="index.jsp" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="Matricula.jsp" class="nav-link">Matricula</a></li>
                <li class="nav-item"><a href="Funcionario.jsp" class="nav-link">Funcionario</a></li>
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
                <li class="nav-item"><a href="#" class="nav-link">...</a></li>
            </ul>
        </header>
    </div>
    <h1>
        Cadastro de Exercícios
    </h1>
    <br>
    <div class="geral">
        <div class="form-floating mb-3">
            <input type="tel" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Matrícula</label>
        </div>
        <select class="form-select" aria-label="Default select example">
                <option selected>Tipo de Plano</option>
                <option value="1">SImples</option>
                <option value="2">Padrão</option>
                <option value="3">Elite</option>
        </select>
        <br>
        <select class="form-select" aria-label="Default select example">
            <option selected>Exercícios incluídos</option>
            <option value="1">Exemplo 1</option>
            <option value="2">Exemplo 2</option>
            <option value="3">Exemplo 3</option>
        </select>
        <br>
        <select class="form-select" aria-label="Default select example">
            <option selected>Exercícios a mais</option>
            <option value="1">Exemplo 1</option>
            <option value="2">Exemplo 2</option>
            <option value="3">Exemplo 3</option>
        </select>
    </div>
        <br>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <td>
                        Exercícios incluídos
                    </td>
                    <td>
                        Exercícios a mais 

                    </td>
                    <td>
                        Carga horária total
                    </td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ...
                    </td>
                    <td>
                        ...
                    </td>
                    <td>
                        ...
                    </td>
                </tr>
                <tr>
                    <td>
                        ...
                    </td>
                    <td>
                        ...
                    </td>
                    <td>
                        ...
                    </td>
                </tr>
                <tr>
                    <td>
                        ...
                    </td>
                    <td>
                        ...
                    </td>
                    <td>
                        ...
                    </td>
                </tr>
            </tbody>
          </table>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>