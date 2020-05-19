/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.Venda;
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
 * @author diego
 */
public class VendasDAO {
    public static List<Venda> listarVendas(String F,String datai, String dataf) {
     
        List<Venda> vendas = new ArrayList<>();
        boolean ok = false;
        Connection con;
        if (F.equals("=0")){
        F="is not null";}
        try {
            con = ConexaoDB.getConexao();
            String sql = "select * from venda where vnd_filial "+F+" and vnd_data between '"+datai+"' and '"+dataf+"' order by vnd_filial, vnd_data;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String filial= rs.getString("vnd_filial");
                int id = Integer.parseInt(rs.getString("vnd_id"));
                String usuario = rs.getString("vnd_usuario");
                String cpf = rs.getString("vnd_cli_cpf");
                float total = Float.parseFloat(rs.getString("vnd_total"));
                String data = rs.getString("vnd_data");
                float desconto = Float.parseFloat(rs.getString("vdn_desconto"));

                
                      
                vendas.add(new Venda(id, filial , usuario,  cpf, total, data,desconto));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return vendas;
    }
    
}
