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
        </div>
        <div class="jumbotron jumbotron-fluid p-1">
            <div class="container-fluid mr-5"> 
                <h1 class="display-5"></h1>


                <div class="form-group">
                    <label> Selecione Filial: </label>     
                    <form action="ListarClienteVenda" method="POST">
                        <div class="form-inline"> 

                            <select name="Filial" id="sfilial" class="form-control mx-sm-0 mb-1">
                                <option value="1">Filial 1</option>
                                <option value="2">Filial 2</option>
                                <option value="3">Filial 3</option>
                            </select> 
                        </div>
                        <div class="form-group">
                            <div class="form-row border ">
                                <div class="form-group col-md-5px">
                                    <label> ID: </label>
                                    <input name="ID" class="form-control" value="${ID}" readonly>
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> nome: </label>
                                    <input name="nome" class="form-control" value="${NOME}" readonly>
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> CPF: </label>
                                    <input name="CPF" class="form-control" value="${CPF}" readonly>
                                </div>
                            </div>
                            <button class="btn btn-primary" type="submit">Selecionar</button>
                        </div>


                    </form> 




                    </body>
                    </body>
                    </html>
