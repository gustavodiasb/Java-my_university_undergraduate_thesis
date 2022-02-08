/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.com.supermarket.model.Funcionario;
import br.com.supermarket.view.TelaEntrada;

/**
 *
 * @author Gustavo
 */
public class FuncionarioDAO {
    
    public Funcionario validaLogin(Funcionario funcLog) throws SQLException {
        
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tb_funcionario WHERE login_funcionario = ? AND senha_funcionario = ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcLog.getLogin());
            stmt.setString(2, funcLog.getSenha());
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                funcLog.verificacao = true;
                funcLog.setId(rs.getInt(1));
                funcLog.setNome(rs.getString(2));
                funcLog.setAcesso(rs.getString(7));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Banco não encontrado... " + ex, "NADA!", JOptionPane.NO_OPTION);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return funcLog;
    }
    
    
    public void create(Funcionario funcionario) {
         
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO tb_funcionario(nome_funcionario, email_funcionario, "
                + "cargo_funcionario, login_funcionario, senha_funcionario, acesso_funcionario) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getLogin());
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getAcesso());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
    
    
    public List<Funcionario>read() {
        
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario>funcionarios = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement("SELECT * FROM tb_funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setCargo(rs.getString(4));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public List<Funcionario>readForDesc(String desc) {
        
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_funcionario WHERE nome_funcionario LIKE ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setEmail(rs.getString(3));
                funcionario.setCargo(rs.getString(4));
                funcionario.setLogin(rs.getString(5));
                funcionario.setSenha(rs.getString(6));
                funcionario.setAcesso(rs.getString(7));
                
                funcionarios.add(funcionario);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Banco não encontrado... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return funcionarios;
    }
    
    public void update(Funcionario funcionario) {
         
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "UPDATE tb_funcionario SET nome_funcionario = ?, email_funcionario = ?, "
                + "cargo_funcionario = ?, login_funcionario = ?, senha_funcionario = ?, acesso_funcionario = ? "
                + "WHERE id_funcionario = ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getLogin());
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getAcesso());
            stmt.setInt(7, funcionario.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }       
    }
    
    public void delete(Funcionario funcionario) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM tb_funcionario WHERE id_funcionario = ?";
        
        try {
            if (funcionario.getId() == TelaEntrada.IDfuncLog) {
                JOptionPane.showMessageDialog(null, "Não é possível excluir o usuário logado.", 
                        "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                stmt = connection.prepareStatement(sql);
                stmt.setInt(1, funcionario.getId());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Excluído com Sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
}