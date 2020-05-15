/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author italo
 */
public class Produto {
    private int Id;
    private String Nome;
    private String Descricao;
    private int Quantidade;
    private double Valor;

    public Produto(int id, String nome, String descricao, int quantidade, double valor) {
        this.Id = id;
        this.Nome = nome;
        this.Descricao = descricao;
        this.Quantidade = quantidade;
        this.Valor = valor;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }
    
    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }
    
    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        this.Valor = valor;
    }
}
