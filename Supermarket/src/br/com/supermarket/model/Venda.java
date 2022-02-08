/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.model;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Venda {
    private int idVenda;
    private String dataVenda;
    private double valorVenda;
    private int qtdeVendaProduto;
    private int id_produto;
    public ArrayList<Venda> v1 = new ArrayList<Venda>();

    /* teste conteudo */
    private String conteudo = "Supermarket\n\n\nCod. x         " + "      Produto:            x      " + ""
            + "   qtde.:      x   " + "   preço: (R$) " + "\n\n";
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo += conteudo;
    }
    /* fim teste */
    
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQtdeVendaProduto() {
        return qtdeVendaProduto;
    }

    public void setQtdeVendaProduto(int qtdeVendaProduto) {
        this.qtdeVendaProduto = qtdeVendaProduto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    /* PRODUTO */
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
        
}