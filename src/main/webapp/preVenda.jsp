<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Venda</title>
    </head>
    <h1>Venda</h1>

    <body>   

        <c:forEach var="c" items="${cli}">
            <input name="ID"  size=1 value="${c.id}">
            <input name="nome" value="${c.nome}"> 
            <input name="CPF" value="${c.cpf}">
            <br><br>

        </c:forEach>    

        <form action="ListarClienteVenda">

            <button type="submit">Buscar</button>  <br><br>
        </form>  

        <div align="center">


            <form action="ItensVendaServlet">     
                <d:forEach var="d" items="${itens}"> 
                    produtoID<input name="Produto"  size=1 value="${d.id}">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    descricao<input name="Descricao" value="${d.descricao}"> 
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    Quantidade<input name="Quantidade" value="10">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    valorUnitari<input name="ValorUnitario" value="${d.valor}">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    total<input name="Total" value="${d.valor}">
                    <button type="submit">AdicionarLista</button><br>
                </d:forEach>   
            </form> 
            
            <table border="3" cellpadding="5">
                <th>Produto </th>
                <th>Descrição</th>
                <th>Quantidade</th>
                <th>ValorUnitario</th>
                <th>Total</th>
                

                <e:forEach var="e" items="${vnd}">
                    <tr> 
                    <td>${e.produtoID}</td>
                    <td>${e.descricao}</td>
                    <td>${e.quantidade}</td>
                    <td>${e.valorUnitario}</td>
                    <td>${e.total}</td>
                    </tr>
                </e:forEach>
                    
                <tr></tr>
            </table>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

            <form action="ListarItensVenda">

                <button class="btn btn-outline-danger" type="submit">Adicionar</button>  <br>
                &nbsp;&nbsp;&nbsp;&nbsp;
            </form> <br><br>


            <form action="ConcluirVenda">

                <button class="btn btn-outline-danger" type="submit">Concluir</button>  <br>

                &nbsp;&nbsp;&nbsp;&nbsp;
            </form> 
            <a href="index.html">Início</a>
    </body>
</html>

