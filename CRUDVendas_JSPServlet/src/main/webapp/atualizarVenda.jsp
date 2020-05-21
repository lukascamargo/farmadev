<%-- 
    Document   : AtualizarVenda
    Created on : 21/05/2020, 16:37:12
    Author     : rapha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Venda</title>
    </head>
    <body>
      
<form action="EditarVendaServlet"method="POST">
                <c:forEach var="c" items="${venda}">
                   <input name="IDVenda" type="hidden" size=1 value="${c.id}"> 
                    CPFCliente<input type="text" name="CPFCliente"value="${c.CPFCliente}"><br>   
                    desconto<input name="desconto"  value="${c.desconto}"><br>
                    total<input name="total"  value="${c.total}"><br>
                    dataVenda<input name="dataVenda"  value="${c.dataVenda}"><br>
                    usuario<input name="usuario"  value="${c.usuario}"><br>
                </c:forEach>

            
                                                             
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="submit">Atualizar</button>  
                            </form>   



<a href="index.html">Início</a>

</body>
</html>
