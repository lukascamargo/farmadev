<%-- 
    Document   : listarClientesVendas
    Created on : 21/05/2020, 20:27:22
    Author     : diego
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <h1>Seleção de Cliente </h1><br><br>

    <body>
        <div align="center">
            <table border="3" cellpadding="5">

                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>Telefone</th>
                <th>Gênero</th>
                <th>Estado Civil</th>


                <c:forEach var="c" items="${clientes}">
                    <tr>

                        <td>${c.nome}</td>
                        <td>${c.email}</td>
                        <td>${c.cpf}</td>
                        <td>${c.endereco}</td>
                        <td>${c.telefone}</td>
                        <td>${c.genero}</td>
                        <td>${c.estadoCivil}</td>
                        <td> 
                            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
                            <form action="ListarClienteVenda" method="POST">
                                <input name="ID"  size=1 value="${c.id}">    
                                <input name="CPF"  size=1 value="${c.cpf}">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-outline-danger" type="submit">Selecionar</button>  
                            </form>   
                            
                            




                    </tr>
                </c:forEach>

                <tr></tr>
            </table>

            <param name="ID" value="${c.id}">
            <a href="index.html">Início</a>

    </body>
</html>
