/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.controller;

import br.com.supermarket.dao.ConexaoDB;
import br.com.supermarket.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gustavo
 */
public class ControleVenda {
    
    public void adicionaItem(Venda venda) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
    }
    
}
