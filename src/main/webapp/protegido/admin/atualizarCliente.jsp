<%-- 
    Document   : atualizarCliente
    Created on : 22/05/2020, 21:13:06
    Author     : Caique
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
                <h1 class="display-5">Atualizar informação cliente</h1>

                <form action="EditarServlet"method="POST">

                    <c:forEach var="c" items="${cliente}">
                        <div class="form-group">    
                            <div class="form-row border">
                                <div class="form-group col-md-auto">
                                    <input name="ID" type="hidden" value="${c.id}"> 
                                </div>
                                <div class="form-group col-md-auto">
                                    <label> Nome </label>
                                    <input type="text" class="form-control" name="nome"value="${c.nome}">
                                </div>

                                <div class="form-group col-md-5px">
                                    <label>Email</label>
                                    <input  type="text" class="form-control" name="email"  value="${c.email}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label>CPF</label>
                                    <input type="text" class="form-control" name="cpf"  value="${c.cpf}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label> Endereço </label>
                                    <input type="text" class="form-control" name="endereco"  value="${c.endereco}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label> Telefone </label>
                                    <input type="text" class="form-control" name="telefone"  value="${c.telefone}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label> Gênero </label>
                                    <input type="text" class="form-control" name="genero"  value="${c.genero}">
                                </div>
                                <div class="form-group col-md-auto">
                                    &nbsp;&nbsp;
                                    <label> Estado Civil </label>                                
                                    <input type="text" class="form-control" name="estadoCivil"  value="${c.estadoCivil}">
                                </div>
                            </c:forEach>
                        </div>  

                        <div class="container m-3">
                            <button class="btn btn-outline-success" type="submit" >Atualizar</button>

                        </div>
                </form>
            </div>


            <center>
                <a href="index.html">Início</a>  
            </center>      
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>
