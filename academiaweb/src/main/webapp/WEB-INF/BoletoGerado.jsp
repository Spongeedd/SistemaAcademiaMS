<%-- 
    Document   : BoletoGerado
    Created on : Oct 31, 2022, 7:51:15 AM
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

    td, th {
        padding: .7em;
        margin: 0;
        border: 1px solid #ccc;
        text-align: center;
    }

    td{
        font-weight:bold;
        background-color: #EEE;
    }
    table {
        margin: auto;
        width: 50%;
        table-layout: fixed;
        text-align: center;
     
    }

    h1 {
        text-align: center;
    }
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

    </style>
</head>
<body>
    <nav id="blocos">
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
    </nav>
    <h1>
        Sua fatura é: 
    </h1>
    <table border="1">
        <tr>
            <td>
                PLANO
            </td>   
            <td>
                VALOR
            </td>
            <td>
                FATURAS ATRASADAS
            </td>
        </tr>
        <tr>
            <td>
                Clássico
            </td>
            <td>
                R$100
            </td>
            <td>
                0
            </td>   
        </tr>

    </table>
</body>
</html>
