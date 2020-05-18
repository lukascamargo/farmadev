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
import java.sql.SQLException;
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
}
