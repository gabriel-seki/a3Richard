package EstoqueCrypto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutoDAO {

    public void listarProdutosComCategoria() {
        String sql = """
            SELECT 
                p.nome AS produto,
                p.preco_unitario,
                p.quantidade_estoque,
                c.nome AS categoria,
                c.tamanho,
                c.embalagem
            FROM produtos p
            JOIN categorias c ON p.categoria_id = c.id
        """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Produtos com Categoria ===");
            while (rs.next()) {
                System.out.println("Produto: " + rs.getString("produto"));
                System.out.println("Preço: R$ " + rs.getBigDecimal("preco_unitario"));
                System.out.println("Estoque: " + rs.getInt("quantidade_estoque"));
                System.out.println("Categoria: " + rs.getString("categoria"));
                System.out.println("Tamanho: " + rs.getString("tamanho"));
                System.out.println("Embalagem: " + rs.getString("embalagem"));
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar produtos: " + e.getMessage());
        }
    }

    public void listarMovimentacoes() {
        String sql = """
            SELECT 
                m.id,
                p.nome AS produto,
                m.tipo,
                m.quantidade,
                m.data_movimentacao,
                m.observacao
            FROM movimentacoes_estoque m
            JOIN produtos p ON m.produto_id = p.id
            ORDER BY m.data_movimentacao DESC
        """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Histórico de Movimentações ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Produto: " + rs.getString("produto"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Quantidade: " + rs.getInt("quantidade"));
                System.out.println("Data: " + rs.getTimestamp("data_movimentacao"));
                System.out.println("Observação: " + rs.getString("observacao"));
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar movimentações: " + e.getMessage());
        }
    }
}
