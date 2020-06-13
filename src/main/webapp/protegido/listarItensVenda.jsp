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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <title>'FarmaSis</title>
        <style>
            a{
                font-family: verdana;
                font-size:15px;
                color:#5298C7;
                text-decoration: none;	
            }
        </style> 

        <script type="text/javascript"></script>
    </head>
    <img src="logo_farmasis.jpg" height="80" width="180">
    <img src="logo_drogaria.jpg" height="80" width="180" align="right">

    <body>
        <h4 style="text-align: center;"> </h4>
        <div id="retangulo" style="text-align:center; width:100%; height:30px; background-color:#23EBA7">
            <a href="/protegido/admin/cadastroCliente.jsp">Cadastro de Cliente</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/ListarClientes">Listar Clientes</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/admin/relatorioFiliais.jsp">Relatorio por filial</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/admin/relatorioProduto.jsp">Relatorio por produto</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/admin/relatorioClientes.jsp">Relatorio por Cliente</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/admin/cadastroProduto.jsp">Cadastro de produto</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/listarProdutos.jsp">Listar Produtos</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/protegido/ListarClienteVenda">venda</a>
        </div>					<div class="jumbotron jumbotron-fluid p-1">
            <div class="container-fluid mr-5"> 
                <h1 class="display-5">Selecione o Produto:</h1>

                <body>
                    <div align="center">
                        <table class="table" width="10%" >
                            <thead class="table-dark" >

                            <th>ProdutoID</th>
                            <th>Filial</th>
                            <th>Descricao</th>
                            <th>QuantidadeEstoque</th>
                            <th>valorUnitario</th>
                            <th>categoria</th>
                            <th></th>
                            </thead>

                            <c:forEach var="c" items="${Produto}">
                                <tr>

                                    <td>${c.id}</td>
                                    <td>${c.filial}</td>
                                    <td>${c.descricao}</td>
                                    <td>${c.quantidade}</td>
                                    <td>${c.valor}</td>
                                    <td>${c.categoria}</td>
                                    <td> 
                                        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
                                        <form action="ListarItensVenda" method="POST">
                                            <input name="ItensVendaID"  type="hidden" value="${c.id}">                              
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <button class="badge badge-primary" type="submit">Selecionar</button>  
                                        </form> 
                                </tr>
                            </c:forEach>

                            <tr></tr>
                        </table>

                        <param name="ItensVendaID" value="${c.id}">
                        <a href="../index.html">Início</a>

                </body>
                </html>
