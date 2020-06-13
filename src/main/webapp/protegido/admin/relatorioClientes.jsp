<%-- 
    Document   : relatorioClientes
    Created on : 20/05/2020, 23:39:24
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

        <script>
            function numeros(evt) {
                var theEvent = evt || window.event;
                var key = theEvent.keyCode || theEvent.which;
                key = String.fromCharCode(key);
                //var regex = /^[0-9.,]+$/;
                var regex = /^[0-9.]+$/;
                if (!regex.test(key)) {
                    theEvent.returnValue = false;
                    if (theEvent.preventDefault)
                        theEvent.preventDefault();
                    alert("Preencha o campo somente com números!");
                }
            }
        </script>

        <script type="text/javascript"></script>
    </head>
    <img src="/protegido/logo_farmasis.jpg" height="80" width="180">
    <img src="/protegido/logo_drogaria.jpg" height="80" width="180" align="right">

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
                <h1 class="display-5">Relatorio por cliente</h1>
                <label> Selecione Filial:</label>
                <form action="RelatorioClientes">
                    <div class="form-inline">

                        <select name="Filial" id="sfilial" class="form-control mx-sm-0 mb-2">
                            <option value="1">Filial 1</option>
                            <option value="2">Filial 2</option>
                            <option value="3">Filial 3</option>
                            <option value="0">Todas Filiais</option>
                        </select>
                    </div>
                    <div
                        <div class="form-group">
                            <div class="form-row border ">
                                <div class="form-group col-md-5px">
                                    <label> CPF: </label>
                                    <input type="text" class="form-control" onkeypress='return numeros();' name="relatorio_cpf" required/>
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> Data inicial: </label>
                                    <input type="date"  class="form-control"  name="dataini" placeholder="ano-mes-dia" required value="2020-05-01" />
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> Data fim: </label>
                                    <input type="date"  class="form-control"  name="datafim"  placeholder="ano-mes-dia" required  value="2020-06-01" />
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-primary" type="submit" >Consultar</button>
                </form>
                <br><br>

                <table class="table"  >
                    <thead class="table-dark" >

                    <th scope="col">IdVenda</th> 
                    <th scope="col">Filial</th>            
                    <th scope="col">CPF</th>
                    <th scope="col">Total</th>
                    <th scope="col">Data</th>
                    <th scope="col">Desconto</th>
                    <th scope="col">Usuario</th>
                    </thead>

                    <c:forEach var="c" items="${Vendas}">
                        <tr>


                            <td>${c.id}</td>                    
                            <td>${c.filial}</td>
                            <td>${c.cpf}</td>
                            <td>${c.total}</td>
                            <td>${c.data}</td>
                            <td>${c.desconto}</td>
                            <td>${c.usuario}</td>

                        </tr>   
                    </c:forEach>

                    <tr></tr>
                </table>
                <br>
                <center>
                    <a href="index.html">Início</a>
                </center>
                </body>
                </html>
