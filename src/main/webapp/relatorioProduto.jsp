<%-- 
    Document   : relatorioProduto
    Created on : 03/06/2020, 20:53:14
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
                font-size:18px;
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
            <a href="cadastroCliente.jsp">Cadastro de Cliente</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="ListarClientes">Listar Clientes</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="relatorioFiliais.jsp">Relatorio por filial</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="relatorioProduto.jsp">Relatorio por produto</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="relatorioClientes.jsp">Relatorio por Cliente</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="cadastroProduto.jsp">Cadastro de produto</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="listarProdutos.jsp">Listar Produtos</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="ListarClienteVenda">venda</a>
        </div>					<div class="jumbotron jumbotron-fluid p-1">
            <div class="container-fluid mr-5"> 
                <h1 class="display-5">Relatorio de vendas por produto</h1>


                <form action="RelatorioProdutos">
                    <div class="form-inline" style="float:right;">
                        <select name="filial" id="sfilial" class="form-control mx-sm-0 mb-2">
                            <option value="">Selecione Filial</option>
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
                                    <label> Data inicial: </label>
                                    <input type="text" class="form-control" name="dataini" placeholder="ano-mes-dia"/>
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> Data fim: </label>
                                    <input type="text"  class="form-control" name="datafim" placeholder="ano-mes-dia"/>
                                </div>
                            </div>
                            <div class="form-row border ">
                                <div class="form-group col-md-5px">
                                    <label> Produto: </label>
                                    <input type="text"  class="form-control" name="produto" placeholder="desc/ID ou em branco para todos "/>
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> Categoria: </label>
                                         <select name="categoria" class="form-control mx-sm-0 mb-2">
                                    <option ></option>
                                    <option value="BELEZA">BELEZA</option>
                                    <option value="EQUIPAMENTOS">EQUIPAMENTOS</option>
                                    <option value="SAUDE">SAUDE</option>
                                </select> 
                                   </div>
                            </div>
                        </div>
                        <button class="btn btn-primary" type="submit" >Consultar</button>
                </form>
                <br><br>
                <center>
                    <table class="table"  >
                        <thead class="table-dark" >


                        <th scope="col">filial</th>
                        <th scope="col">IdVenda</th>
                        <th scope="col">CodProduto</th>
                        <th scope="col">Descricao</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Quantidade</th>
                        <th scope="col">ValorUni</th>
                         <th scope="col">ValorTotal</th>
                          <th scope="col">DataVenda</th>



                        </thead>
                        <c:forEach var="c" items="${VendasProdutos}">

                            <tr>
                                
                                <td>${c.local}</td>                    
                                <td>${c.VID}</td>                                
                                <td>${c.produtoID}</td>
                                <td>${c.descricao}</td>
                                <td>${c.categoria}</td>
                                <td>${c.quantidade}</td>
                                <td>${c.valorUnitario}</td>
                                <td>${c.total}</td>
                                <td>${c.dataVenda}</td>

                            </tr>
                        </c:forEach>

                        <tr></tr>
                    </table>
                </center>
                <br>
                <center>
                    <a href="index.html">Início</a>
                </center>
                </body>
                </html>
