package br.senac.sp.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.ItensVenda;
import br.senac.sp.entidade.Produto;
import br.senac.sp.entidade.Venda;
import br.senac.sp.servlet.ItensVendaServlet;
import br.senac.sp.servlet.ListarItensVenda;
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

    public static List<Venda> listarVendasCli(String F, String CPF, String datai, String dataf) {

        List<Venda> vendas = new ArrayList<>();
        boolean ok = false;
        Connection con;
        if (F.equals("=0")) {
            F = "is not null";
        }
        try {
            con = ConexaoDB.getConexao();
            String sql = "select * from venda where vnd_filial " + F + " and vnd_cli_cpf ='" + CPF + "' and vnd_data between '" + datai + "' and '" + dataf + "' order by vnd_data;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String filial = rs.getString("vnd_filial");
                int id = Integer.parseInt(rs.getString("vnd_id"));
                String usuario = rs.getString("vnd_usuario");
                String cpf = rs.getString("vnd_cli_cpf");
                float total = Float.parseFloat(rs.getString("vnd_total"));
                String data = rs.getString("vnd_data");
                float desconto = Float.parseFloat(rs.getString("vdn_desconto"));

                vendas.add(new Venda(id, filial, usuario, cpf, total, data, desconto));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static List<Venda> listarVendas(String F, String datai, String dataf) {

        List<Venda> vendas = new ArrayList<>();
        boolean ok = false;
        Connection con;
        if (F.equals("=0")) {
            F = "is not null";
        }
        try {
            con = ConexaoDB.getConexao();
            String sql = "select * from venda where vnd_filial " + F + " and vnd_data between '" + datai + "' and '" + dataf + "' order by vnd_filial, vnd_data;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String filial = rs.getString("vnd_filial");
                int id = Integer.parseInt(rs.getString("vnd_id"));
                String usuario = rs.getString("vnd_usuario");
                String cpf = rs.getString("vnd_cli_cpf");
                float total = Float.parseFloat(rs.getString("vnd_total"));
                String data = rs.getString("vnd_data");
                float desconto = Float.parseFloat(rs.getString("vdn_desconto"));

                vendas.add(new Venda(id, filial, usuario, cpf, total, data, desconto));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static void Concluir(Venda vnd) {

        boolean ok = false;
        Connection con;

        try {
            con = ConexaoDB.getConexao();

            String sql = " insert venda values (default,?,?,?,CURDATE(),?,?);";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, vnd.getFilial());
            ps.setString(2, vnd.getCpf());
            ps.setDouble(3, vnd.getTotal());
            ps.setDouble(4, vnd.getDesconto());
            ps.setString(5, vnd.getUsuario());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {

                int ID = Integer.parseInt(String.valueOf((rs.getLong(1))));
                BaixaItensVenda(ItensVendaServlet.getItem(), ID);
            }
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

public static void BaixaItensVenda(List<ItensVenda> itv, int ID) {

        boolean ok = false;
        Connection con;
        
        try {
            con = ConexaoDB.getConexao();

            for (int i = 0; i < (itv.size()); i++) {

                String sql = " insert ITENS_VENDA  values (default,'1','teste','10','1','1','10',CURDATE());";
                        //(default,'1','teste','10','1','1','10',CURDATE());";
                        //(default,?,?,?,?,'" + ID + "',?,CURDATE());";
                                              //
                PreparedStatement ps = con.prepareStatement(sql);

//                ps.setInt(1, itv.get(i).getProdutoID());
//                ps.setString(2, itv.get(i).getDescricao());
//                ps.setInt(3, itv.get(i).getQuantidade());
//                ps.setDouble(4, itv.get(i).getValorUnitario());
//                ps.setDouble(5, itv.get(i).getTotal());
                ps.executeUpdate();
                   }
                con.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
