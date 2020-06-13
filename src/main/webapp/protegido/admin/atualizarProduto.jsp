<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">        
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>

    <body>

        <img src="logo_farmasis.jpg" height="80" width="180">
        <img src="logo_drogaria.jpg" height="80" width="180" align="right">

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
        </div>                  
        <div class="jumbotron jumbotron-fluid p-1">
            <div class="container-fluid mr-5"> 
                <h1 class="display-5">Atualizar informação produto</h1>

                <form action="EditarProduto"method="POST">

                    <c:forEach var="c" items="${produto}">

                        <div class="form-group">    
                            <div class="form-row border">
                                <div class="form-group col-md-auto">
                                    <input name="PRD_ID" class="form-control" type="hidden" value="${c.id}"> 
                                </div>
                                <div class="form-group col-md-auto">
                                    <label> filial </label>
                                    <input type="text" class="form-control" name="PRD_FILIAL"value="${c.filial}">
                                </div>

                                <div class="form-group col-md-5px">
                                    <label>descrição</label>
                                    <input name="PRD_DESCRICAO" class="form-control" value="${c.descricao}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label>quantidade</label>
                                    <input name="PRD_QUANTIDADE" class="form-control" value="${c.quantidade}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label> Valor </label>
                                    <input name="PRD_VALOR_UNIT" class="form-control" value="${c.valor}">
                                </div>

                                <div class="form-group col-md-auto">
                                    <label> categoria </label>
                                    <input name="PRD_CATEGORIA" class="form-control" value="${c.categoria}">
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

    </body>
</html>
