/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.supermarket.model.CategoriaProduto;

/**
 *
 * @author Gustavo
 */
public class CategoriaProdutoDAO {
    
    public void create(CategoriaProduto categoriaProduto) {
         
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO tb_categoriaProduto(nome_categoria) VALUES (?)";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, categoriaProduto.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
    
    
    public List<CategoriaProduto>read() {
        
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CategoriaProduto> listCategoria = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_categoriaProduto";
        
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                CategoriaProduto categoriaProduto = new CategoriaProduto();
                categoriaProduto.setId(rs.getInt(1));
                categoriaProduto.setNome(rs.getString(2));
                
                listCategoria.add(categoriaProduto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        
        return listCategoria;
    }
    
    public List<CategoriaProduto>readForDesc(String desc) {
        
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CategoriaProduto> listCategoria = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_categoriaProduto WHERE nome_categoria LIKE ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                CategoriaProduto categoriaProduto = new CategoriaProduto();
                
                categoriaProduto.setId(rs.getInt(1));
                categoriaProduto.setNome(rs.getString(2));
                
                listCategoria.add(categoriaProduto);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Banco não encontrado... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return listCategoria;
    }
    
    public void update(CategoriaProduto categoriaProduto) {
         
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "UPDATE tb_categoriaProduto SET nome_categoria = ? WHERE id_categoria = ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, categoriaProduto.getNome());
            stmt.setInt(2, categoriaProduto.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }       
    }
    
    public void delete(CategoriaProduto categoriaProduto) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM tb_categoria WHERE id_categoria = ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, categoriaProduto.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir." + e);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
    
}
