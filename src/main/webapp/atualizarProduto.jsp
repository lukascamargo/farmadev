<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Produto</title>
    </head>

    <body>
      
<form action="EditarProduto"method="POST">
                <c:forEach var="c" items="${produto}">
                   <input name="PRD_ID" type="hidden" size=1 value="${c.id}"> 
                    filial<input type="text" name="PRD_FILIAL"value="${c.filial}"><br>   
                    descrição<input name="PRD_DESCRICAO"  value="${c.descricao}"><br>
                     quantidade<input name="PRD_QUANTIDADE"  value="${c.quantidade}"><br>
                    Valor<input name="PRD_VALOR_UNIT"  value="${c.valor}"><br>
                    categoria<input name="PRD_CATEGORIA"  value="${c.categoria}"><br>

                </c:forEach>

            
                                                             
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="submit">Atualizar</button>  
                            </form>   



<a href="index.html">Início</a>

</body>
</html>
