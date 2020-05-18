/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author rapha
 */
public class Venda {
    
    private int IDVenda;
    private int CPFCliente;
    private double desconto;
    private double total;
    private String dataVenda;
    private String usuario;

    public Venda(int IDVenda, int CPFCliente, double desconto, double total, String dataVenda,String usuario) {
        this.IDVenda = IDVenda;
        this.CPFCliente = CPFCliente;
        this.desconto = desconto;
        this.total = total;
        this.dataVenda = dataVenda;
        this.usuario = usuario;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public int getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(int CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
}
