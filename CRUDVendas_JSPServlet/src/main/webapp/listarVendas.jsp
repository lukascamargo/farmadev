<%-- 
    Document   : ListarVendas
    Created on : 21/05/2020, 16:29:58
    Author     : rapha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Vendas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>
        <div align="center">
            <table border="3" cellpadding="5">

                <th>CPFCliente</th>
                <th>desconto</th>
                <th>total</th>
                <th>dataVenda</th>
                <th>usuario</th>


                <c:forEach var="c" items="${vendas}">
                    <tr>

                        <td>${c.CPFCliente}</td>
                        <td>${c.desconto}</td>
                        <td>${c.total}</td>
                        <td>${c.dataVenda}</td>
                        <td>${c.usuario}</td>
                        <td> 
                            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
                            <form action="DeletarVendaServlet">
                                <input name="IDVenda" type="hidden" size=1 value="${c.id}">                              
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-outline-danger" type="submit">deletar</button>  
                            </form>   
                            <form action="EditarVendaServlet">
                                <input name="IDVenda"  type="hidden"  value="${c.id}">                              
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="submit">Editar</button>  
                            </form>   




                    </tr>
                </c:forEach>

                <tr></tr>
            </table>

            <param name="IDVenda" value="${c.id}">
            <a href="index.html">Início</a>

    </body>
</html>
