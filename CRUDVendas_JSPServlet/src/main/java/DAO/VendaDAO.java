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
import java.sql.SQLException;
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
            String sql = "insert into cliente values (default,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda.getIDVenda());
            ps.setInt(2, venda.getIDProduto());
            ps.setString(3, venda.getDescricao());
            ps.setInt(4, venda.getQuantidade());
            ps.setDouble(5, venda.getValorUnitario());
            ps.setDouble(6, venda.getTotal());
            ps.setString(7, venda.getDataVenda());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ok;
    }
}
