package main;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class Testconnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Conexao estabelecida com sucesso!");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
