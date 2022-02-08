/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.dao;

import br.com.supermarket.model.CategoriaProduto;
import br.com.supermarket.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ProdutoDAO {

    public void create(Produto produto) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO tb_produto(nome_produto, codigoBarra_produto, marca_produto, qtde_produto, qtdeMin_produto, "
                + "vlCompra_produto, vlVenda_produto, lucro_produto, vlTotalEstoque_produto, "
                + "vlTotalVenda_produto, idCategoria_produto) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigoBarra());
            stmt.setString(3, produto.getMarca());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getQuantidadeMinimaEstoque());
            stmt.setDouble(6, produto.getValorCompra());
            stmt.setDouble(7, produto.getValorVenda());
            stmt.setDouble(8, produto.getLucro());
            stmt.setDouble(9, produto.getValorTotalEstoque());
            stmt.setDouble(10, produto.getValorTotalVenda());
            stmt.setInt(11, produto.getCategoria().getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }

    public List<Produto> read() {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> listProduto = new ArrayList<>();

        String sql = "SELECT * FROM view_produto";

        try {
            stmt = connection.prepareStatement(sql);
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

                CategoriaProduto categoriaProduto = new CategoriaProduto();
                categoriaProduto.setId(rs.getInt(12));
                categoriaProduto.setNome(rs.getString(13));

                produto.setCategoria(categoriaProduto);

                listProduto.add(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }

        return listProduto;
    }

    public List<Produto> readForDesc(String desc) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> listProduto = new ArrayList<>();

        String sql = "SELECT * FROM view_produto WHERE nome_produto LIKE ?";

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

                CategoriaProduto categoriaProduto = new CategoriaProduto();
                categoriaProduto.setId(rs.getInt(12));
                categoriaProduto.setNome(rs.getString(13));

                produto.setCategoria(categoriaProduto);

                listProduto.add(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt, rs);
        }
        return listProduto;
    }

    public void update(Produto produto) {

        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE tb_produto SET nome_produto = ?, codigoBarra_produto = ?, marca_produto = ?, qtde_produto = ?"
                + ", qtdeMin_produto = ?, vlCompra_produto = ?, vlVenda_produto = ?, lucro_produto = ?, "
                + "vlTotalEstoque_produto = ?, vlTotalVenda_produto = ?, idCategoria_produto = ? WHERE id_produto = ?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigoBarra());
            stmt.setString(3, produto.getMarca());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getQuantidadeMinimaEstoque());
            stmt.setDouble(6, produto.getValorCompra());
            stmt.setDouble(7, produto.getValorVenda());
            stmt.setDouble(8, produto.getLucro());
            stmt.setDouble(9, produto.getValorTotalEstoque());
            stmt.setDouble(10, produto.getValorTotalVenda());
            stmt.setInt(11, produto.getCategoria().getId());
            stmt.setInt(12, produto.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar... " + ex);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }

    public void delete(Produto produto) {
        Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM tb_produto WHERE id_produto = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com Sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir." + e);
        } finally {
            ConexaoDB.closeConnection(connection, stmt);
        }
    }
}
