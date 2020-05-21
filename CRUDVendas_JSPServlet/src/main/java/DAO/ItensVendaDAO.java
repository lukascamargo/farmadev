/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConexaoDB;
import entidade.ItensVenda;
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
public class ItensVendaDAO {
    
    public static boolean cadastrarItensVenda(ItensVenda item_venda) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into Itens_venda values (default,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item_venda.getItensVendaID());
            ps.setInt(2, item_venda.getProdutoID());
            ps.setString(3, item_venda.getDescricao());
            ps.setInt(4, item_venda.getQuantidade());
            ps.setDouble(5, item_venda.getValorUnitario());
            ps.setDouble(6, item_venda.getTotal());
            ps.setString(7,item_venda.getDataVenda());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ItensVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ok;
    }
    
    public static boolean update(ItensVenda e) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
           
            String sql = "update Itens_venda set ProdutoID=?,descricao=?,quantidade=?,valorUnitario=?,total=?,dataVenda=? where ItensVendaID=? ;";//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getProdutoID());
            ps.setString(2, e.getDescricao());
            ps.setInt(3, e.getQuantidade());
            ps.setDouble(4, e.getValorUnitario());
            ps.setDouble(5, e.getTotal());
            ps.setString(6,e.getDataVenda());
            ps.setInt(7, e.getItensVendaID());
           
            
           
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

            String sql = "delete from Itens_venda where ItensVendaID ='" + id + "';";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static List<ItensVenda> BuscarItensVenda(int ID) {
        List<ItensVenda> item_venda = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {

            con = ConexaoDB.getConexao();
            String sql = "select * from Itens_venda where IDVenda= "+ID;//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("ItensVendaID"));
                int produtoID = rs.getInt("produtoID");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double valorUnitario = rs.getDouble("valorUnitario");
                double total = rs.getDouble("total");
                String dataVenda = rs.getString("dataVenda");
                item_venda.add(new ItensVenda(id,produtoID, descricao, quantidade, valorUnitario, total, dataVenda));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItensVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item_venda;
    }
    
    public static List<ItensVenda> listarItensVenda() {
        List<ItensVenda> item_vendas = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {

            con = ConexaoDB.getConexao();
            String sql = "select * from Itens_venda";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("ItensVendaID"));
                int produtoID = rs.getInt("produtoID");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double valorUnitario = rs.getDouble("valorUnitario");
                double total = rs.getDouble("total");
                String dataVenda = rs.getString("dataVenda");
                item_vendas.add(new ItensVenda(id,produtoID, descricao, quantidade, valorUnitario, total, dataVenda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItensVendaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return item_vendas;
    }
}
