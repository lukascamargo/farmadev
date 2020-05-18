/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ItensVendaDAO;
import entidade.ItensVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rapha
 */
public class CadastroItensVendaServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Empty
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int IDVenda = request.getIntHeader("IDVenda");
        int produtoID = request.getIntHeader("produtoID");
        String descricao = request.getParameter("descricao");
        int quantidade = request.getIntHeader("quantidade");
        double valorUnitario = Double.parseDouble(request.getParameter("valorUnitario"));
        double total = Double.parseDouble(request.getParameter("total"));
        String dataVenda = request.getParameter("dataVenda");
        
        ItensVenda item_venda = new ItensVenda(IDVenda,produtoID, descricao,quantidade, valorUnitario, total,dataVenda);
        boolean ok = ItensVendaDAO.cadastrarItensVenda(item_venda);
        PrintWriter out = response.getWriter();

        String url = "";
        if (ok) {
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
