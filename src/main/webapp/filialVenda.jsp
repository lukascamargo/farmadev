<%-- 
    Document   : filialVenda
    Created on : 06/06/2020, 03:56:52
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="jumbotron jumbotron-fluid p-1">
            <div class="container-fluid mr-5"> 
                <h1 class="display-5"> Selecione a filial da venda </h1>

                <body> 

                    


                        <div class="form-group">
                            <div class="form-row border ">
                           <form action="ListarClienteVenda" method="POST">
                                <select name="Filial" id="sfilial" class="form-control mx-sm-0 mb-2">
                                    <option >Selecione Filial</option>
                                    <option value="1">Filial 1</option>
                                    <option value="2">Filial 2</option>
                                    <option value="3">Filial 3</option>

                                </select> 
                                <div class="form-group col-md-5px">
                                    <label> ID: </label>
                                    <input name="ID" class="form-control" size=1 value="${ID}">
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> nome: </label>
                                    <input name="nome" class="form-control" value="${NOME}">
                                </div>
                                <div class="form-group col-md-5px">
                                    <label> CPF: </label>
                                    <input name="CPF" class="form-control" value="${CPF}">
                                </div>
                            </div>
                                 <button class="btn btn-outline-danger" type="submit">Selecionar</button>
                        </div>

                         
                    </form> 




                </body>
                </body>
                </html>
