<%-- 
    Document   : atualizarItensVenda
    Created on : 21/05/2020, 16:51:48
    Author     : rapha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar itens da venda</title>
    </head>
    <body>
      
<form action="EditarItensVendaServlet"method="POST">
                <c:forEach var="c" items="${venda}">
                   <input name="ItensVendaID" type="hidden" size=1 value="${c.id}"> 
                    ProdutoID<input type="text" name="ProdutoID"value="${c.ProdutoID}"><br>   
                    descricao<input name="desconto"  value="${c.descricao}"><br>
                    quantidade<input name="total"  value="${c.quantidade}"><br>
                    valorUnitario<input name="dataVenda"  value="${c.valorUnitario}"><br>
                    total<input name="usuario"  value="${c.total}"><br>
                    dataVenda<input name="usuario"  value="${c.dataVenda}"><br>
                </c:forEach>

            
                                                             
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="submit">Atualizar</button>  
                            </form>   



<a href="index.html">Início</a>

</body>
</html>
