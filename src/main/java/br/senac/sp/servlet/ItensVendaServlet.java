/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.ItensVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KIQ
 */
public class ItensVendaServlet extends HttpServlet {

    public static List<ItensVenda> item;

    public static List<ItensVenda> getItem() {
        return item;
    }

    public static void setItem(List<ItensVenda> item) {
        ItensVendaServlet.item = item;
    }

    List<ItensVenda> vnd = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //  int sid = Integer.parseInt(request.getParameter("ItensVendaID"));
            //  itens.add(ProdutosDAO.produtoSelecionado(sid));
            //  request.setAttribute("itens", itens);
            int produtoID = Integer.parseInt(request.getParameter("Produto"));
            String descricao = request.getParameter("Descricao");
            int quantidade = Integer.parseInt(request.getParameter("Quantidade"));
            double valorUnitario = Double.parseDouble(request.getParameter("ValorUnitario"));
            double total = Double.parseDouble(request.getParameter("Total"));
            String dataVenda = "";

            //   ItensVenda ivn = new ItensVenda(produtoID, descricao, quantidade, valorUnitario, total, dataVenda);
            request.setAttribute("vnd", vnd);
            vnd.add(new ItensVenda(produtoID, descricao, quantidade, valorUnitario, total, dataVenda));
            setItem(vnd);

            List<Cliente> cli = ClienteDAO.BuscarClientes(ListarClienteVenda.getIDC());
            request.setAttribute("cli", cli);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/preVenda.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
