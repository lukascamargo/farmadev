package br.senac.sp.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.ItensVenda;
import br.senac.sp.entidade.Produto;
import br.senac.sp.entidade.Venda;
import br.senac.sp.entidade.VendasProdutos;
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

    public static List<VendasProdutos> ListarItensVendaXProduto(String F, String P, String C, String Di, String Df) {

        List<VendasProdutos> vendas = new ArrayList<>();
        boolean ok = false;
        Connection con;
        if (F.equals("=0")) {
            F = "is not null";
        }
        if (P.equals("=''")) {
            P = "is not null";
        }
        if (C.equals("=''")) {
            C = "is not null";
        }
        try {
            con = ConexaoDB.getConexao();
            String sql
                    = "SELECT vnd_filial , IVND_ID_VENDA , IVND_PRD_ID, IVND_PRD_DESCRICAO ,B.PRD_CATEGORIA, IVND_QUANTIDADE , IVND_PRD_VALOR_UNIT , IVND_TOTAL , IVND_DATA_VENDA"
                    + " FROM ITENS_VENDA A, PRODUTO B , venda "
                    + " WHERE A. ivnd_prd_id = B.PRD_ID "
                    + " and vnd_id = IVND_ID_VENDA "
                    + " and vnd_filial " + F
                    + " AND (IVND_PRD_ID " + P + " OR IVND_PRD_DESCRICAO " + P + ")"
                    + " AND B.PRD_CATEGORIA " + C
                    + " AND IVND_DATA_VENDA BETWEEN '" + Di + "' and '" + Df + "'"
                    + "order by IVND_PRD_ID;";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String Filial = rs.getString("vnd_filial");
                String venda = rs.getString("IVND_ID_VENDA");
                String produto = rs.getString("IVND_PRD_ID");
                String descricao = rs.getString("IVND_PRD_DESCRICAO");
                String categoria = rs.getString("PRD_CATEGORIA");
                String quantidade = rs.getString("IVND_QUANTIDADE");
                String vunitario = rs.getString("IVND_PRD_VALOR_UNIT");
                String vtotal = rs.getString("IVND_TOTAL");
                String data = rs.getString("IVND_DATA_VENDA");

                vendas.add(new VendasProdutos(Filial, venda, produto, descricao, categoria, quantidade, vunitario, vtotal, data));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static int Concluir(Venda vnd) {

        boolean ok = false;
        Connection con;
         int ID=0;

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

                 ID = Integer.parseInt(String.valueOf((rs.getLong(1))));
                BaixaItensVenda(ItensVendaServlet.getItem(), ID);
            }
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ID;
    }

    public static void BaixaItensVenda(List<ItensVenda> itv, int ID) {

        boolean ok = false;
        Connection con;

        try {
            con = ConexaoDB.getConexao();

            for (int i = 0; i < (itv.size()); i++) {

                String sql = " insert ITENS_VENDA  values"
                        + "(default,?,?,?,?,'" + ID + "',?,CURDATE());";
                //
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, itv.get(i).getProdutoID());
                ps.setString(2, itv.get(i).getDescricao());
                ps.setInt(3, itv.get(i).getQuantidade());
                ps.setDouble(4, itv.get(i).getValorUnitario());
                ps.setDouble(5, itv.get(i).getTotal());
                ps.executeUpdate();
            }

            BaixaEstoque(itv);
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void BaixaEstoque(List<ItensVenda> itens) {
        List<Integer> estoque = ConsultaEstoque(itens);

        Connection con;

        try {
            con = ConexaoDB.getConexao();

            for (int i = 0; i < (itens.size()); i++) {

                int qtd = (estoque.get(i) - itens.get(i).getQuantidade());

                String sql = "UPDATE PRODUTO SET PRD_QUANTIDADE= '" + qtd + "' WHERE PRD_ID = '" + itens.get(i).getProdutoID() + "';";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.executeUpdate();
            }

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static List<Integer> ConsultaEstoque(List<ItensVenda> itens) {

        Connection con;
        List<Integer> estoque = new ArrayList<>();
        try {

            con = ConexaoDB.getConexao();
            for (int i = 0; i < (itens.size()); i++) {
                String sql = "select* from PRODUTO where PRD_ID = " + itens.get(i).getProdutoID();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int quantidade = Integer.parseInt(rs.getString("PRD_QUANTIDADE"));
                    estoque.add(quantidade);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return estoque;
    }

}
