<%-- 
    Document   : FichaTecnica
    Created on : Oct 31, 2022, 7:50:29 AM
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <style>
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
    #exercicios {
        display: block;
        margin: auto;
        background-color: #FCF8E8;
        width: 20cm;
        border-radius: 2mm;
    }

    #exercicios h2 {
        text-align: center;
        font-family: 'Crimson Text', serif;
        color: #1C6758
    }

    #exercicios table {
        margin: auto;
        background-color: #FCF8E8;
        width: 15cm;
        border-radius: 2mm;
        color: #1C6758;
    }

    #exercicios tr {
        text-align: center;
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
    <div id="exercicios">
        <h2>Exercícios</h2>
        <table class="bordered striped centered">
            <thead>
                <tr>
                    <th>Corpo</th>
                    <th>Exercício</th>
                    <th>Feito?</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>Braço</th>
                    <td>Triceps pulley</td>
                    <td>Sim</td>
                </tr>
                <tr>
                    <th>Perna</t>
                    <td>Leg press</td>
                    <td>Não</td>
                </tr>
            </tbody>
        </table>  
    </div>

</body>
</html>