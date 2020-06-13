<%-- 
    Document   : cadastroCliente
    Created on : 22/05/2020, 21:13:06
    Author     : Caique
--%>

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
                <h1 class="display-5">Cadastro de Clientes</h1>


                <div class="form-group">
                    <form action="CadastroClienteServlet" method="POST">

                        <div class="form-row border">
                            <div class="form-group col-md-auto">
                                <label> Nome </label>
                                <input type="text" class="form-control"  onkeypress='return letras();' name= "nome" required>
                            </div>

                            <div class="form-group col-md-5px">
                                <label>Email</label>
                                <input type="text" class="form-control" name= "email" placeholder="digite seu e-mail aqui" required/>
                            </div>

                            <div class="form-group col-md-auto">
                                <label>CPF</label>
                                <input type="text" class="form-control" onkeypress='return numeros();' placeholder="digite apenas números" name= "cpf" required/>
                            </div>

                            <div class="form-group col-md-auto">
                                <label> Endereço </label>
                                <input type="text" class="form-control" name= "endereco" required>
                            </div>

                            <div class="form-group col-md-auto">
                                <label> Telefone </label>
                                <input type="text" class="form-control" onkeypress='return numeros();'  placeholder="digite apenas números" name= "telefone" required>
                            </div>

                            <div class="form-group col-md-auto">
                                <label> Gênero </label>
                                <input type="text" class="form-control" onkeypress='return letras();' name= "genero" required>
                            </div>

                            <div class="form-group col-md-auto">
                                <label> Estado Civil </label>
                                <input type="text" class="form-control" onkeypress='return letras();' name= "estadoCivil" required>
                            </div>

                        </div>  

                        <div class="container m-3">
                            <button class="btn btn-outline-success" type="submit" >Criar</button>
                            <button class="btn btn-outline-secondary" type="reset" >limpar</button> 
                        </div>
                    </form>
                </div>
                <div align="center">                     
                    <a href="../index.html">Início</a>   
                </div>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
                </body>
                </html>