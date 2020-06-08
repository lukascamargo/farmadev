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
public class Venda {

    private String filial;


    private int id;
    private String usuario;
    private String cpf;    
    private Double total;
    private String data;
    private Double desconto;    
    
    public Venda(String filial, String usuario, String cpf, double total, String data, double desconto) {
        this.filial = filial;
        this.usuario = usuario;
        this.cpf = cpf;
        this.total = total;
        this.data = data;
        this.desconto = desconto;
    }

    public Venda(int id , String filial, String usuario, String cpf, double total,  String data, double desconto ) {
  
    this.filial = filial;
    this.id=id;
    this.usuario=usuario;
    this.cpf=cpf;
    this.total=total;
    this.data=data;
    this.desconto=desconto;
    
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String nome) {
        this.usuario = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
