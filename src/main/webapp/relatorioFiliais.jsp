<%-- 
    Document   : relatorioFiliais
    Created on : 16/05/2020, 22:30:46
    Author     : diego
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio por filiais</title>
    </head>
    <body><h1>Relatorio por filiais</h1>
        <hr>
       <br><br>
       <form action="RelatorioFiliais">
       <label for=sfilial>Filial: </label>
       <select name="Filial" id="sfilial">
           <option value=""> </option>
           <option value="1">Filial 1</option>
           <option value="2">Filial 2</option>
           <option value="3">Filial 3</option>
           <option value="0">Todas Filiais</option>
          
       </select><br> <br> 
      
               Data inicial <input type="text" name="dataini" placeholder="ano-mes-dia"/>
               Data fim <input type="text" name="datafim" placeholder="ano-mes-dia"/><br><br>
               
       <button type="submit">Consultar</button>
       </form>
       <br><br>
       
       
       <table border="1" style="border-spacing: 0;">
           <th>IdVenda</th> 
           <th>Filial</th>            
            <th>CPF</th>
            <th>Total</th>
            <th>Data</th>
            <th>Desconto</th>
            <th>Usuario</th>
            
            <c:forEach var="c" items="${Vendas}">
                <tr>
                    <td>${c.id}</td>                    
                    <td>${c.filial}</td>
                    <td>${c.cpf}</td>
                    <td>${c.total}</td>
                    <td>${c.data}</td>
                    <td>${c.desconto}</td>
                    <td>${c.usuario}</td>
                                     
                </tr>
            </c:forEach>
            
            <tr></tr>
             </table>
        <br>
          <a href="index.html">Início</a>
        </body>
</html>
