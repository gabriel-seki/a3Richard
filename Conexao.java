/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstoqueCrypto;

/**
 *
 * @author ryano
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/estoquecrypto?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root"; // altere se necessário
    private static final String SENHA = "Sonho2013";       // altere se necessário

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

