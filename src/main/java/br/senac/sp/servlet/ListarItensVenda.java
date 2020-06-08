/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.dao.ProdutosDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.servlet.ListarClienteVenda;
import static br.senac.sp.servlet.ListarClienteVenda.getFILIAL;

/**
 *
 * @author diego
 */
public class ListarItensVenda extends HttpServlet {

    public static List<Produto> getItem() {
        return item;
    }

    public static void setItem(List<Produto> item) {
        ListarItensVenda.item = item;
    }

    public static List<Produto> item;

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
            
            List<Produto> Produto = ProdutosDAO.listarProdutos(ListarClienteVenda.getFILIAL());
            request.setAttribute("Produto", Produto);        
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listarItensVenda.jsp");
            dispatcher.forward(request, response);

        }

//                try (PrintWriter out = response.getWriter()) {
//            List<Produto> Produto = ProdutosDAO.listarProdutos();
//            request.setAttribute("Produto", Produto);
//            ListarItensVenda.setItem(itens);
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listarItensVenda.jsp");
//            dispatcher.forward(request, response);
//
//        }
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
        
        
        List<Produto> itens = new ArrayList<>();
        
        int sid = Integer.parseInt(request.getParameter("ItensVendaID"));
        itens.add(ProdutosDAO.produtoSelecionado(sid));
        request.setAttribute("itens", itens);

        List<Cliente> cli = ClienteDAO.BuscarClientes(ListarClienteVenda.getIDC());
        request.setAttribute("cli", cli);
        
         request.setAttribute("fil", getFILIAL());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/preVenda.jsp");
        dispatcher.forward(request, response);
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
