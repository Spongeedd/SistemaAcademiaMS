<%@page import="com.academia.model.db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@1,300;1,400&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <style>
        body {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        .row {
            background-color: white;
            border-radius: 30px;
            box-shadow: 12px 12px 22px;
        }

        .login img {
            border-top-left-radius: 30px;
            border-bottom-left-radius: 30px;
        }

        .login h1 {
            font-size: 4rem;
            font-weight: 600;
            font-family: 'Josefin Sans', sans-serif;
        }

        .inp {
            height: 50px;
            width: 70%;
            outline: none;
            border-radius: 60px;
        }

        .btn1 {
            height: 50px;
            width: 50%;
            border: none;
            outline: none;
            border-radius: 60px;
            background-color: rgb(88, 88, 238);
            color: white;
        }

        .btn1:hover {
            background-color: rgb(45, 45, 253);
            transition: 0.5s;
        }
    </style>

  </head>
  <body>
    
    <section class="login py-5 bg-light">
        <div class="container">
            <div class="row g-0">
                <div class="col-lg-5">
                    <img class="img-fluid" src="https://www.sospedro.com.br/wp-content/uploads/2022/01/Design-sem-nome-4.png" alt="">
                </div>
                <div class="col-lg-7 text-center py-5">
                    <h1>Bem-vindo</h1>
                    <form action="LoginAluno" method="POST">
                        <div class="form-row py-3 pt-5">
                            <div class="offset-1 col-lg-10">
                                <input class="inp px-3" name="login" type="text" placeholder="Nome de usuário">
                            </div>
                        </div>
                        <div class="form-row py-3">
                            <div class="offset-1 col-lg-10">
                                <input class="inp px-3" name="senha" type="password" placeholder="Senha">
                            </div>
                        </div>
                        <div class="form-row py-3">
                            <div class="offset-1 col-lg-10">
                                <button class="btn1">Entrar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>