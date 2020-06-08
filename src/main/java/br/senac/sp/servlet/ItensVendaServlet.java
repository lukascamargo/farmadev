/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.ItensVenda;
import static br.senac.sp.servlet.ListarClienteVenda.getFILIAL;
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

    public static List<ItensVenda> item = new ArrayList<>();

    public static List<ItensVenda> getItem() {
        return item;
    }
    
    public static void limpar (){
    item = new ArrayList<>();
   
    }

 
    private double totalVenda ;

    public double getTotalVenda() {
        return totalVenda;
    }

  //  List<ItensVenda> vnd = new ArrayList<>();
    
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

       
            int produtoID = Integer.parseInt(request.getParameter("Produto"));
            String descricao = request.getParameter("Descricao");
            int quantidade = Integer.parseInt(request.getParameter("Quantidade"));
            double valorUnitario = Double.parseDouble(request.getParameter("ValorUnitario"));
            double total = Double.parseDouble(request.getParameter("Total"));
            String dataVenda = "";
            
           ItensVenda Itens = new ItensVenda(produtoID, descricao, quantidade, valorUnitario, total, dataVenda);
           
           this.item.add(Itens);
                   
            request.setAttribute("item", this.item);
            
            List<Cliente> cli = ClienteDAO.BuscarClientes(ListarClienteVenda.getIDC());
            request.setAttribute("cli", cli);
   
            totalVenda= total+getTotalVenda();
            request.setAttribute("tvenda", totalVenda);
            
             request.setAttribute("fil", getFILIAL());

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
        
            //item=null;
        
             List<Cliente> cli = ClienteDAO.BuscarClientes(ListarClienteVenda.getIDC());
            request.setAttribute("cli", cli);
            item=new ArrayList<>();
            totalVenda= 0;
            request.setAttribute("tvenda", totalVenda);

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
