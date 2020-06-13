<%-- 
    Document   : cadastroProduto
    Created on : 22/05/2020, 21:13:06
    Author     : Renato
--%>

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

        <script>
            function letras(evt) {
                var theEvent = evt || window.event;
                var key = theEvent.keyCode || theEvent.which;
                key = String.fromCharCode(key);
                //var regex = /^[0-9.,]+$/;
                var regex = /[a-zA-Z\u00C0-\u00FF ]+/i;
                if (!regex.test(key)) {
                    theEvent.returnValue = false;
                    if (theEvent.preventDefault)
                        theEvent.preventDefault();
                    alert("Preencha o campo somente com letras!");
                }
            }

        </script>

        <script type="text/javascript"></script>
    </head>
    <body>
        <img src="/protegido/logo_farmasis.jpg" height="80" width="180">
        <img src="/protegido/logo_drogaria.jpg" height="80" width="180" align="right">
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
                <h1 class="display-5">Cadastro de produtos</h1>

                <div class="form-group">
                    <form action="CadastroProduto" method="POST">


                        <div class="form-row border">
                            <div class="form-group col-md-auto">
                                <label>Filial :</label>
                                <select name="PRD_FILIAL" id="sfilial" class="form-control mx-sm-0 mb-2">
                                    <option value="1">Filial 1</option>
                                    <option value="2">Filial 2</option>
                                    <option value="3">Filial 3</option>
                                </select> 
                            </div>


                            <div class="form-group col-md-5px">
                                <label>Descrição:</label>
                                <input type="text" class="form-control" onkeypress='return letras();' required name= "PRD_DESCRICAO"/>
                            </div>

                            <div class="form-group col-md-auto">
                                <label>Quantidade:</label>
                                <input type="text" class="form-control" onkeypress='return numeros();' required name= "PRD_QUANTIDADE"/>
                            </div>

                            <div class="form-group col-md-auto">
                                <label> Valor unitario: </label>
                                <input type="text" class="form-control" onkeypress='return numeros();' required name= "PRD_VALOR_UNIT">
                            </div>

                            <div class="form-group col-md-auto">
                                <label> Categoria: </label>
                                <select name="PRD_CATEGORIA" class="form-control mx-sm-0 mb-2">
                                    <option value="BELEZA">BELEZA</option>
                                    <option value="EQUIPAMENTOS">EQUIPAMENTOS</option>
                                    <option value="SAUDE">SAUDE</option>
                                </select
                            </div>
                        </div>
                </div>  

                <div class="container m-3">
                    <button class="btn btn-outline-success" type="submit" >Criar</button>
                    <button class="btn btn-outline-secondary" type="reset" >limpar</button> 
                </div>
                </form>
            </div>
            <center>
                <a href="../index.html">Início</a>
            </center>
    </body>
</html>
