/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.servlet.ItensVendaServlet;


/**
 *
 * @author diego
 */
public class ListarClienteVenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static int IDC;
    public static String CPF;

    public static String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public static int getIDC() {
        return IDC;
    }

    public void setIDC(int IDC) {
        this.IDC = IDC;
    }
    
    public static int FILIAL;

    public static int getFILIAL() {
        return FILIAL;
    }

    public void setFILIAL(int FILIAL) {
        this.FILIAL = FILIAL;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Cliente> clientes = ClienteDAO.listarClientes();
            request.setAttribute("clientes", clientes);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/protegido/listarClientesVendas.jsp");
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
        int sid = Integer.parseInt(request.getParameter("ID"));

        String cpf = request.getParameter("CPF");
        setCPF(cpf);
        setIDC(sid);
        setFILIAL(Integer.parseInt(request.getParameter("Filial")));   
         request.setAttribute("fil", getFILIAL());

        List<Cliente> cli = ClienteDAO.BuscarClientes(sid);
        request.setAttribute("cli", cli);
        
 ItensVendaServlet.limpar();
           
        out.close();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/protegido/preVenda.jsp");
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
