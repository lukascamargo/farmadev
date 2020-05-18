<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Venda</title>
    </head>
    <body>
        <h1>Formulário de Cadastro</h1>
        <form action="CadastroVendaServlet" method="POST">
               ID venda:<input type="text" name="IDVenda"/><br>
               CPF cliente:<input type="text" name="CPFCliente"/><br>
               desconto:<input type="text" name="desconto"/><br>
               total:<input type="text" name="total"/><br>
               data venda:<input type="text" name="dataVenda"/><br>
               usuario:<input type="text" name="usuario"/><br>
               <button type="submit" >Enviar</button>
        </form>
    </body>
</html>
