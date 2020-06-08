package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutosDAO;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastroProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Empty
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filial = request.getParameter("Filial");
        String descriçao = request.getParameter("PRD_DESCRICAO");
        int quantidade = Integer.parseInt(request.getParameter("PRD_QUANTIDADE"));        
       // Integer.parseInt(request.getParameter("PRD_QUANTIDADE"));
        double valor = Double.parseDouble(request.getParameter("PRD_VALOR_UNIT"));
        String categoria = request.getParameter("PRD_CATEGORIA");
        Produto produto = new Produto(filial, descriçao, quantidade, valor, categoria);
        boolean ok = ProdutosDAO.cadastrarProduto(produto);
        PrintWriter out = response.getWriter();        
        
        String url = "";
        if (ok) {
            request.setAttribute("cadastroOK", true);
            url = "/sucesso.jsp";
        } else {
            url = "/erro.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}