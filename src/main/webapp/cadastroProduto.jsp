<%-- 
    Document   : cadastroProduto
    Created on : 22/05/2020, 21:13:06
    Author     : Renato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <h1>Formulário de Cadastro</h1>
        <form action="CadastroProduto" method="POST">
               Filial:<input type="text" name="PRD_FILIAL"/><br>
               Descrição:<input type="text" name="PRD_DESCRICAO"/><br>
               Quantidade:<input type="text" name="PRD_QUANTIDADE"/><br>
               Valor unitario:<input type="text" name="PRD_VALOR_UNIT"/><br>
               Categoria:<input type="text" name="PRD_CATEGORIA"/><br>            
               <button type="submit" >Enviar</button><br><br>
               
        </form>
        
         <a href="index.html">Início</a>
        
    </body>
</html>
