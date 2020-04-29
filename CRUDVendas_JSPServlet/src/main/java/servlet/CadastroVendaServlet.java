/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.VendaDAO;
import entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rapha
 */
public class CadastroVendaServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Empty
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int IDVenda = request.getParameter("IDVenda");
        int IDProduto = request.getParameter("IDProduto");
        String descricao = request.getParameter("descricao");
        int quantidade = request.getParameter("quantidade");
        double valorUnitario = request.getParameter("valorUnitario");
        double total = request.getParameter("total");
        int dataVenda = request.getParameter("dataVenda");
        
        Venda venda = new Venda(IDVenda, IDProduto, descricao, quantidade, valorUnitario, total, dataVenda);
        boolean ok = VendaDAO.cadastrarVenda(venda);
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
