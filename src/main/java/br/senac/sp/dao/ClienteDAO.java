package br.senac.sp.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public static boolean cadastrarCliente(Cliente cliente) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into CLIENTE values (default,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getGenero());
            ps.setString(7, cliente.getEstadoCivil());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static boolean update(Cliente e) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();

            String sql = "update CLIENTE set nome=?,email=?,cpf=?,endereco=?,telefone=?,genero=?,estadoCivil=? where id=? ;";//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNome());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getCpf());
            ps.setString(4, e.getEndereco());
            ps.setString(5, e.getTelefone());
            ps.setString(6, e.getGenero());
            ps.setString(7, e.getEstadoCivil());
            ps.setInt(8, e.getId());

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

            String sql = "delete from CLIENTE where id ='" + id + "';";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static List<Cliente> BuscarClientes(int ID) {
        List<Cliente> cliente = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {

            con = ConexaoDB.getConexao();
            String sql = "select * from CLIENTE where id= " + ID;//+ID;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String genero = rs.getString("genero");
                String estadoCivil = rs.getString("estadoCivil");
                cliente.add(new Cliente(nome, email, cpf, endereco, telefone, genero, estadoCivil, id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "select * from CLIENTE";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String genero = rs.getString("genero");
                String estadoCivil = rs.getString("estadoCivil");
                clientes.add(new Cliente(nome, email, cpf, endereco, telefone, genero, estadoCivil, id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
