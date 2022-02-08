/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.dao;

import br.com.supermarket.model.Produto;
import br.com.supermarket.model.Venda;
import br.com.supermarket.view.TelaEntrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class VendaProdutoDAO {
    
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dataVenda = df.format(new Date());        
    
    public void iniciaVenda(Venda venda) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        venda.setDataVenda(dataVenda);

        String sql_vender = "INSERT INTO tb_venda(valor_venda, data_venda, id_funcionario) VALUES (?,?,?)";
        String sql_venda = "SELECT id_venda FROM tb_venda";
        
        try {
            /* SQL_VENDER */            
            stmt = connection.prepareStatement(sql_vender);
            stmt.setDouble(1, venda.getValorVenda());
            stmt.setString(2, venda.getDataVenda());
            stmt.setInt(3, TelaEntrada.IDfuncLog);
            stmt.executeUpdate();
            
            /* SQL_SelecionarIDVENDA */
            stmt = connection.prepareStatement(sql_venda);
            rs = stmt.executeQuery();
            rs.last();
            venda.setIdVenda(rs.getInt(1));
            
            create(venda);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
    }
    
    public void create(Venda venda) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            /* SQL_ITENSVENDA */
            String sql_itensVenda = "INSERT INTO itens_venda_produto(id_venda, id_produto, quantidade_produto) VALUES (?,?,?)";
            for (Venda i : venda.v1) {
                int idProd = i.getId_produto(), qtdeProd = i.getQtdeVendaProduto(), estoque = 0;
                
                stmt = connection.prepareStatement(sql_itensVenda);
                stmt.setInt(1, venda.getIdVenda());
                stmt.setInt(2, idProd);
                stmt.setInt(3, qtdeProd);
                stmt.executeUpdate();
                
                /* DECREMENTA_ESTOQUE */                
                String sql_estoque = "SELECT qtde_produto FROM view_produto WHERE id_produto = " + idProd + "";
                stmt = connection.prepareStatement(sql_estoque);
                rs = stmt.executeQuery();
                rs.last();
                
                estoque = rs.getInt(1);                
                estoque -= qtdeProd;
                        
                String sql_itensEstoque = "UPDATE view_produto SET qtde_produto = ? WHERE id_produto = " + idProd + "";
                stmt = connection.prepareStatement(sql_itensEstoque);
                stmt.setInt(1, estoque);
                stmt.executeUpdate();            
            }
            
            JOptionPane.showMessageDialog(null, "Venda Concluída");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
    }
    
    public List<Produto> readForDesc(String desc) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> listProduto = new ArrayList<>();

        String sql = "SELECT * FROM view_produto WHERE codigoBarra_produto LIKE ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setCodigoBarra(rs.getString(3));
                produto.setMarca(rs.getString(4));
                /* --- Double --- */
                produto.setQuantidade(rs.getInt(5));
                produto.setQuantidadeMinimaEstoque(rs.getInt(6));
                produto.setValorCompra(rs.getDouble(7));
                produto.setValorVenda(rs.getDouble(8));
                produto.setLucro(rs.getDouble(9));
                produto.setValorTotalEstoque(rs.getDouble(10));
                produto.setValorTotalVenda(rs.getDouble(11));
                listProduto.add(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return listProduto;
    }
}
