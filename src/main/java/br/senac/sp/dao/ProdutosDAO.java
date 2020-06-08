package br.senac.sp.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {

    public static boolean cadastrarProduto(Produto produto) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into PRODUTO values (default,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getFilial());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getValor());
            ps.setString(5, produto.getCategoria());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static boolean update(Produto e) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
           
            String sql = "update  PRODUTO set PRD_FILIAL =?,PRD_DESCRICAO=?,PRD_QUANTIDADE=?,PRD_VALOR_UNIT=?, PRD_CATEGORIA=? where PRD_ID=? ;";//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getFilial());
            ps.setString(2, e.getDescricao());
            ps.setInt(3, e.getQuantidade());
            ps.setDouble(4, e.getValor());
            ps.setString(5, e.getCategoria());
            ps.setInt(6, e.getId());
           
            
           
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

            String sql = "delete from PRODUTO where PRD_ID ='" + id + "';";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    public static List<Produto> BuscarProdutos(int ID) {
        List<Produto> produto = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {

            con = ConexaoDB.getConexao();
            String sql = "select * from PRODUTO where PRD_ID= "+ID;//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("PRD_ID"));
                String filial = rs.getString("PRD_FILIAL");
                String descricao = rs.getString("PRD_DESCRICAO");
                int quantidade = rs.getInt("PRD_QUANTIDADE");
                double valor = rs.getDouble("PRD_VALOR_UNIT");
                String categoria = rs.getString("PRD_CATEGORIA");
                produto.add(new Produto(filial, descricao, quantidade, valor, categoria,id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public static List<Produto> listarProdutos( int Filial) {
        List<Produto> produtos = new ArrayList<>();
        boolean ok = false;
        Connection con;
        String a = null;
        if (Filial==0) {a= "is not null";}
        else a= "= "+Filial;
        
        try {
            con = ConexaoDB.getConexao();
            String sql = "select * from PRODUTO where PRD_FILIAL "+a;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("PRD_ID"));
                String filial = rs.getString("PRD_FILIAL");
                String descricao = rs.getString("PRD_DESCRICAO");
                int quantidade = rs.getInt("PRD_QUANTIDADE");
                double valor = rs.getDouble("PRD_VALOR_UNIT");
                String categoria = rs.getString("PRD_CATEGORIA");
                produtos.add(new Produto(filial, descricao, quantidade, valor, categoria, id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
     public static Produto produtoSelecionado(int ID) {
        Produto p = new Produto('2', "", "", '2', '2', "");
        boolean ok = false;
        Connection con;
        try { con = ConexaoDB.getConexao();
            String sql = "select * from PRODUTO where PRD_ID = " + ID;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
            int id = Integer.parseInt(rs.getString("PRD_ID"));
            String filial = rs.getString("PRD_FILIAL");
            String descricao = rs.getString("PRD_DESCRICAO");
            int quantidade = Integer.parseInt(rs.getString("PRD_QUANTIDADE"));
            float valor = Float.parseFloat(rs.getString("PRD_VALOR_UNIT"));
            String categoria = rs.getString("PRD_CATEGORIA");

            Produto produtos = new Produto(id, filial, descricao, quantidade, valor, categoria);
            
            return produtos;
        }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }
    
}




