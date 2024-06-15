package dao;

import model.Veiculo;
import db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDaoSql implements DAO<Veiculo> {

    @Override
    public void insert(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO Veiculo (marca, estado, categoria, modelo, valor_de_compra, placa, ano) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca().toString());
            stmt.setString(2, veiculo.getEstado().toString());
            stmt.setString(3, veiculo.getCategoria().toString());
            stmt.setString(4, veiculo.getModelo().toString());
            stmt.setDouble(5, veiculo.getValorDeCompra());
            stmt.setString(6, veiculo.getPlaca());
            stmt.setInt(7, veiculo.getAno());
            stmt.executeUpdate();
        }
    }

    @Override
    public Veiculo get(int id) throws SQLException {
        String sql = "SELECT * FROM Veiculo WHERE id = ?";
        Veiculo veiculo = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("estado"),
                        rs.getString("categoria"),
                        rs.getString("modelo"),
                        rs.getDouble("valor_de_compra"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                );
            }
        }
        return veiculo;
    }

    @Override
    public List<Veiculo> getAll() throws SQLException {
        String sql = "SELECT * FROM Veiculo";
        List<Veiculo> veiculos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("estado"),
                        rs.getString("categoria"),
                        rs.getString("modelo"),
                        rs.getDouble("valor_de_compra"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                );
                veiculos.add(veiculo);
            }
        }
        return veiculos;
    }

    @Override
    public void update(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE Veiculo SET marca = ?, estado = ?, categoria = ?, modelo = ?, valor_de_compra = ?, placa = ?, ano = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca().toString());
            stmt.setString(2, veiculo.getEstado().toString());
            stmt.setString(3, veiculo.getCategoria().toString());
            stmt.setString(4, veiculo.getModelo().toString());
            stmt.setDouble(5, veiculo.getValorDeCompra());
            stmt.setString(6, veiculo.getPlaca());
            stmt.setInt(7, veiculo.getAno());
            stmt.setInt(8, veiculo.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Veiculo WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
