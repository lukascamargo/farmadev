package DAO;

import ConexaoDB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italo
 */
public class Produto {
    //Método Incluir Produto
    public static boolean incluiProduto(Model.Produto produto) {
        boolean sucesso = false;
        Connection con;
        try {
            con = Conexao.getConexao();
            String sql = "INSERT INTO Produto VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getValor());         
          
            ps.execute();
            sucesso = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
       return sucesso;
    }
    
    //Método Exclui Produto
    public static boolean excluiProduto(int id) {
        boolean sucesso = false;
        Connection con;
        try {
            con = Conexao.getConexao();
            String sql = "DELETE FROM Produto WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.execute();
            sucesso = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
       return sucesso;
    }
    
    //Método Atualiza Produtos
    public static boolean atualizaProduto(Model.Produto produto) {
        boolean sucesso = false;
        Connection con;
        try {
            con = Conexao.getConexao();
            String sql = "UPDATE Produto SET (?,?,?,?) WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getValor());         
            ps.setInt(5, produto.getId());
            
            ps.execute();
            sucesso = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
       return sucesso;
    }
    
   //Método Pesquisa Produtos
    public static ArrayList<Model.Produto> pesquisaProduto(Model.Produto produto) {
        ArrayList<Model.Produto> proutos = null;
        Connection con;
        ResultSet rs;
        try {
            con = Conexao.getConexao();
            Statement comando = null;
//            String sql = "";
//            PreparedStatement ps = con.prepareStatement(sql);
            rs = comando.executeQuery("SELECT * FROM Produto");
            while (rs.next()) {
                Model.Produto temp = null;
                // pega todos os atributos do produto
                temp.setId(rs.getInt("id"));
                temp.setNome(rs.getString("nome"));
                temp.setDescricao(rs.getString("descrição"));
                temp.setQuantidade(rs.getInt("quantidade"));
                temp.setValor(rs.getDouble("valor"));
                proutos.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
       return proutos;
    }
}
