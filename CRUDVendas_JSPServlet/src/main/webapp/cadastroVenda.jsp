<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Venda</title>
    </head>
    <body>
        <h1>Formulário de Cadastro</h1>
        <form action="CadastroClienteServlet" method="POST">
               ID venda:<input type="text" name="IDVenda"/><br>
               ID produto:<input type="text" name="IDProduto"/><br>
               descrição:<input type="text" name="descicao"/><br>
               quantidade:<input type="text" name="quantidade"/><br>
               valor unitário:<input type="text" name="valorUnitario"/><br>
               total:<input type="text" name="total"/><br>
               data venda:<input type="text" name="dataVenda"/><br>
               <button type="submit" >Enviar</button>
        </form>
    </body>
</html>
