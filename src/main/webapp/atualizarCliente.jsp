<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Cliente</title>
    </head>

    <body>
      
<form action="EditarServlet"method="POST">
                <c:forEach var="c" items="${cliente}">
                   <input name="ID" type="hidden" size=1 value="${c.id}"> 
                             nome<input type="text" name="nome"value="${c.nome}"><br>   
                    email<input name="email"  value="${c.email}"><br>
                     cpf<input name="cpf"  value="${c.cpf}"><br>
                    endereco<input name="endereco"  value="${c.endereco}"><br>
                    telefone<input name="telefone"  value="${c.telefone}"><br>
                    genero<input name="genero"  value="${c.genero}"><br>
                    estadoCivil<input name="estadoCivil"  value="${c.estadoCivil}"><br>
                </c:forEach>

            
                                                             
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="submit">Atualizar</button>  
                            </form>   



<a href="index.html">Início</a>

</body>
</html>
