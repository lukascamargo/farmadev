/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

/**
 *
 * @author Renato
 */
public class Produto {

    private String filial;
    private String descricao;
    private int quantidade;
    private double valor;
    private String categoria;
    private int id;

    public Produto(int id, String filial, String descricao, int quantidade, float valor, String categoria) {
        this.id = id;
        this.filial = filial;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Produto(String filial, String descricao, int quantidade, double valor, String categoria) {
        this.filial = filial;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Produto(String filial, String descricao, int quantidade, double valor, String categoria, int id) {

        this.filial = filial;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.categoria = categoria;
        this.id = id;

    }

    public Produto() {
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
