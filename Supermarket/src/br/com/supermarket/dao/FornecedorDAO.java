/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.dao;

import br.com.supermarket.model.Fornecedor;
import br.com.supermarket.model.Produto;
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
public class FornecedorDAO {
    public void create(Fornecedor fornecedor) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO tb_fornecedor(nome_fornecedor, descricao_fornecedor) VALUES (?,?)";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getDescricao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
    
    public List<Fornecedor> read() {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> listFornecedor = new ArrayList<>();

        String sql = "SELECT * FROM tb_fornecedor";

        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt(1));
                fornecedor.setNome(rs.getString(2));
                fornecedor.setDescricao(rs.getString(3));

                listFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return listFornecedor;
    }
    
    public List<Fornecedor> readForDesc(String desc) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> listFornecedor = new ArrayList<>();

        String sql = "SELECT * FROM tb_fornecedor WHERE nome_fornecedor LIKE ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt(1));
                fornecedor.setNome(rs.getString(2));
                fornecedor.setDescricao(rs.getString(3));

                listFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return listFornecedor;
    }
            
    
    public void update(Fornecedor fornecedor) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE tb_fornecedor SET nome_fornecedor = ?, descricao_fornecedor = ? "
                + "WHERE id_fornecedor = ?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getDescricao());
            stmt.setInt(3, fornecedor.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }

    public void delete(Fornecedor fornecedor) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM tb_fornecedor WHERE id_fornecedor = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir... " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
    
    /* REPOSIÇÃO DE PRODUTOS EM ESTOQUE */
    
    // DEFINIR DATA
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dataRepor = df.format(new Date());
    String data = dataRepor;
    
    public void reporProduto(Produto produto) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int estoqueAtual = 0, reporEstoque = produto.getQuantidade(), id_prod = produto.getId();

        String sql_tbAssoc = "INSERT INTO itens_fornecedor_produto"
                + "(id_fornecedor, id_produto, quantidade_produto, data_repor) VALUES (?,?,?,?)";

        try {
            stmt = connection.prepareStatement(sql_tbAssoc);

            stmt.setInt(1, produto.getFornecedor().getId());
            stmt.setInt(2, produto.getId());
            stmt.setInt(3, reporEstoque);
            stmt.setString(4, data);

            stmt.executeUpdate();
            
            String sql_estoque = "SELECT qtde_produto FROM view_produto WHERE id_produto = " + id_prod;
            stmt = connection.prepareStatement(sql_estoque);
            rs = stmt.executeQuery();
            rs.last();
            
            
            estoqueAtual = rs.getInt(1);
            estoqueAtual += reporEstoque;
            
            String sql_qtdeProd = "UPDATE tb_produto SET qtde_produto = ? WHERE id_produto = " + id_prod;
            stmt = connection.prepareStatement(sql_qtdeProd);
            stmt.setInt(1, estoqueAtual);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Fornecedor irá repor o Produto", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao solicitar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
    }
}
