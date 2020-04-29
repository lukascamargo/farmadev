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
    private int IDProduto;
    private String descricao;
    private int quantidade;
    private double valorUnitario;
    private double total;
    private int dataVenda;

    public Venda(int IDVenda, int IDProduto, String descricao, int quantidade, double valorUnitario, double total, int dataVenda) {
        this.IDVenda = IDVenda;
        this.IDProduto = IDProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
        this.dataVenda = dataVenda;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public int getIDProduto() {
        return IDProduto;
    }

    public void setIDProduto(int IDProduto) {
        this.IDProduto = IDProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(int dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
    
    
    
}
