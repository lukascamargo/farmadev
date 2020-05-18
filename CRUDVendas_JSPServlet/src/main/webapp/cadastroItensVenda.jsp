<%-- 
    Document   : cadastroItensVenda
    Created on : 18/05/2020, 15:55:57
    Author     : rapha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Itens para a venda</title>
    </head>
    <body>
        <h1>Formulário de Cadastro</h1>
        <form action="CadastroItensVendaServlet" method="POST">
               ID item da venda:<input type="text" name="itensVendaID"/><br>
               ID produto:<input type="text" name="produtoID"/><br>
               descrição:<input type="text" name="descricao"/><br>
               quantidade:<input type="text" name="quantidade"/><br>
               valor unitário:<input type="text" name="valorUnitario"/><br>
               total:<input type="text" name="total"/><br>
               data da venda:<input type="text" name="dataVenda"/><br>
               <button type="submit" >Enviar</button>
        </form>
    </body>
</html>
