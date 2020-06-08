/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

/**
 *
 * @author diego
 */
public class VendasProdutos {

    private String local;
    private String VID;
    private String produtoID;
    private String descricao;
    private String categoria;
    private String quantidade;
    private String valorUnitario;
    private String total;
    private String dataVenda;

    public VendasProdutos(String Filial, String VendaID, String produtoID, String descricao, String categoria, String quantidade, String valorUnitario, String total, String dataVenda) {
        this.local = Filial;
        this.VID = VendaID;
        this.produtoID = produtoID;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
        this.dataVenda = dataVenda;
    }

    public String getlocal() {
        return local;
    }

    public void setlocal(String Filial) {
        this.local = Filial;
    }

    public String getVID() {
        return VID;
    }

    public void setVID(String VendaID) {
        this.VID = VendaID;
    }

    public String getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(String produtoID) {
        this.produtoID = produtoID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
}
