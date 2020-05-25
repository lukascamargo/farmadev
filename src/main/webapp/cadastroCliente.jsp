<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>
        <h1>Formulário de Cadastro</h1>
        <form action="CadastroClienteServlet" method="POST">
               Nome:<input type="text" name="nome"/><br>
               Email:<input type="text" name="email"/><br>
               Cpf:<input type="text" name="cpf"/><br>
               Endereco:<input type="text" name="endereco"/><br>
               Telefone:<input type="text" name="telefone"/><br>
               Genero:<input type="text" name="genero"/><br>
               EstadoCivil:<input type="text" name="estadoCivil"/><br>            
               <button type="submit" >Enviar</button><br><br>
               
        </form>
        
         <a href="index.html">Início</a>
        
    </body>
</html>
