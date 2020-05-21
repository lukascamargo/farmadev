/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConexaoDB;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago.bscarton
 */
public class VendaDAO {
    
    public static boolean cadastrarVenda(Venda venda) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into vendas values (default,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda.getIDVenda());
            ps.setInt(2, venda.getCPFCliente());
            ps.setDouble(3, venda.getDesconto());
            ps.setDouble(4, venda.getTotal());
            ps.setString(5, venda.getDataVenda());
            ps.setString(6, venda.getUsuario());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ok;
    }
    
    public static boolean update(Venda e) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
           
            String sql = "update vendas set CPFCliente=?,desconto=?,total=?,dataVenda=?,usuario=? where IDVenda=? ;";//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getCPFCliente());
            ps.setDouble(2, e.getDesconto());
            ps.setDouble(3, e.getTotal());
            ps.setString(4, e.getDataVenda());
            ps.setString(5, e.getUsuario());
            ps.setInt(6, e.getIDVenda());
           
            
           
            ps.executeUpdate();
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }
    
    public static boolean excluir(String id) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();

            String sql = "delete from vendas where IDVenda ='" + id + "';";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static List<Venda> BuscarVendas(int ID) {
        List<Venda> venda = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {

            con = ConexaoDB.getConexao();
            String sql = "select * from vendas where IDVenda= "+ID;//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("IDVenda"));
                int CPFCliente = rs.getInt("CPFCliente");
                double desconto = rs.getDouble("desconto");
                double total = rs.getDouble("total");
                String dataVenda = rs.getString("dataVenda");
                String usuario = rs.getString("usuario");
                venda.add(new Venda(id,CPFCliente, desconto, total, dataVenda, usuario));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }
    
    public static List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {

            con = ConexaoDB.getConexao();
            String sql = "select * from vendas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("IDVenda"));
                int CPFCliente = rs.getInt("CPFCliente");
                double desconto = rs.getDouble("desconto");
                double total = rs.getDouble("total");
                String dataVenda = rs.getString("dataVenda");
                String usuario = rs.getString("usuario");;
                vendas.add(new Venda(id,CPFCliente, desconto, total, dataVenda, usuario));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
}