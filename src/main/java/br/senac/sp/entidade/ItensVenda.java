
package br.senac.sp.entidade;

/**
 *
 * @author rapha
 */
public class ItensVenda {
    
    private int itensVendaID;
    private int produtoID;
    private String descricao;
    private int quantidade;
    private double valorUnitario;
    private double total;
    private String dataVenda;

    public ItensVenda(int produtoID, String descricao, int quantidade, double valorUnitario, double total, String dataVenda) {
        this.produtoID = produtoID;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
        this.dataVenda = dataVenda;
    }
    
    
    
    public ItensVenda(int itensVendaID, int produtoID, String descricao, int quantidade, double valorUnitario, double total, String dataVenda) {
        this.itensVendaID = itensVendaID;
        this.produtoID = produtoID;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
        this.dataVenda = dataVenda;
    }

    public int getItensVendaID() {
        return itensVendaID;
    }

    public void setItensVendaID(int itensVendaID) {
        this.itensVendaID = itensVendaID;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
    
    
}
