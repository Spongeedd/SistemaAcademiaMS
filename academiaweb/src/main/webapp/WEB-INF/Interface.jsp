<%-- 
    Document   : Interface
    Created on : Oct 31, 2022, 7:51:50 AM
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Crimson+Text&display=swap" rel="stylesheet">
    <title>Academia</title>
    
    <style>

    @import url('https://fonts.googleapis.com/css2?family=Crimson+Text&display=swap');

    body{
        padding: 0;
        margin: 0;
        background-color: #94B49F;        
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

    #perfil {
        display: block;
        margin: auto;
        box-sizing: border-box;
        width: 15em;
        background-color: #FCF8E8;
        border-radius: 1em;
    }

    #perfil p {
        margin-left: 5mm;
        font-family: 'Crimson Text', serif;
        color: #1C6758;
    }

    #perfil h2 {
        text-align: center;
        font-family: 'Crimson Text', serif;
        color: #1C6758;
    }

    #fotoperfil {
        width: 7em;
        height: 7em;
        border-radius: 50%;
        object-fit: cover;
        margin: auto;
        display: block;
    }

    </style>
</head>
<body>
    <nav id="blocos">
        <ul>
            <li>
                <a href="Interface.jsp">Perfil do aluno</a>
            </li>


            <li>
                <a href="BoletoGerado.jsp">Boleto Gerado</a>
            </li>
    
            <li>
                <a href="FichaTecnica.jsp">Ficha Técnica</a>
            </li>
        </ul>
    </nav>
    
    <div id="perfil">
        <h2>Perfil do aluno</h2>
        <img id="fotoperfil" src="images.jpeg">
        <p>Nome: </p>
        <p>Matrícula: </p>
        <p>Email: </p>
    </div>
</body>
</html>