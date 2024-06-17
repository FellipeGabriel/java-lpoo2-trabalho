package dao;

import model.Veiculo;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import enums.ModeloMotocicleta;
import enums.ModeloVan;
import db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDaoSql implements DAO<Veiculo> {

    @Override
    public void insert(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO Veiculo (marca, estado, categoria, modelo, valor_de_compra, placa, ano) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, veiculo.getMarca().name());
            stmt.setString(2, veiculo.getEstado().name());
            stmt.setString(3, veiculo.getCategoria().name());
            if (veiculo.getModeloAutomovel() != null) {
                stmt.setString(4, veiculo.getModeloAutomovel().name());
            } else if (veiculo.getModeloMotocicleta() != null) {
                stmt.setString(4, veiculo.getModeloMotocicleta().name());
            } else if (veiculo.getModeloVan() != null) {
                stmt.setString(4, veiculo.getModeloVan().name());
            }
            stmt.setDouble(5, veiculo.getValorDeCompra());
            stmt.setString(6, veiculo.getPlaca());
            stmt.setInt(7, veiculo.getAno());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("Inserted ID: " + generatedId);
                }
            }
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
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                if (categoria == Categoria.POPULAR || categoria == Categoria.INTERMEDIÁRIO || categoria == Categoria.LUXO) {
                    try {
                        veiculo = new Veiculo(
                                rs.getInt("id"),
                                Marca.valueOf(rs.getString("marca")),
                                categoria,
                                Estado.valueOf(rs.getString("estado")),
                                rs.getDouble("valor_de_compra"),
                                rs.getString("placa"),
                                rs.getInt("ano"),
                                ModeloAutomovel.valueOf(rs.getString("modelo"))
                        );
                    } catch (IllegalArgumentException e1) {
                        try {
                            veiculo = new Veiculo(
                                    rs.getInt("id"),
                                    Marca.valueOf(rs.getString("marca")),
                                    categoria,
                                    Estado.valueOf(rs.getString("estado")),
                                    rs.getDouble("valor_de_compra"),
                                    rs.getString("placa"),
                                    rs.getInt("ano"),
                                    ModeloMotocicleta.valueOf(rs.getString("modelo"))
                            );
                        } catch (IllegalArgumentException e2) {
                            veiculo = new Veiculo(
                                    rs.getInt("id"),
                                    Marca.valueOf(rs.getString("marca")),
                                    categoria,
                                    Estado.valueOf(rs.getString("estado")),
                                    rs.getDouble("valor_de_compra"),
                                    rs.getString("placa"),
                                    rs.getInt("ano"),
                                    ModeloVan.valueOf(rs.getString("modelo"))
                            );
                        }
                    }
                }
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
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                Veiculo veiculo = null;
                try {
                    veiculo = new Veiculo(
                            rs.getInt("id"),
                            Marca.valueOf(rs.getString("marca")),
                            categoria,
                            Estado.valueOf(rs.getString("estado")),
                            rs.getDouble("valor_de_compra"),
                            rs.getString("placa"),
                            rs.getInt("ano"),
                            ModeloAutomovel.valueOf(rs.getString("modelo"))
                    );
                } catch (IllegalArgumentException e1) {
                    try {
                        veiculo = new Veiculo(
                                rs.getInt("id"),
                                Marca.valueOf(rs.getString("marca")),
                                categoria,
                                Estado.valueOf(rs.getString("estado")),
                                rs.getDouble("valor_de_compra"),
                                rs.getString("placa"),
                                rs.getInt("ano"),
                                ModeloMotocicleta.valueOf(rs.getString("modelo"))
                        );
                    } catch (IllegalArgumentException e2) {
                        veiculo = new Veiculo(
                                rs.getInt("id"),
                                Marca.valueOf(rs.getString("marca")),
                                categoria,
                                Estado.valueOf(rs.getString("estado")),
                                rs.getDouble("valor_de_compra"),
                                rs.getString("placa"),
                                rs.getInt("ano"),
                                ModeloVan.valueOf(rs.getString("modelo"))
                        );
                    }
                }
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
            stmt.setString(1, veiculo.getMarca().name());
            stmt.setString(2, veiculo.getEstado().name());
            stmt.setString(3, veiculo.getCategoria().name());
            if (veiculo.getModeloAutomovel() != null) {
                stmt.setString(4, veiculo.getModeloAutomovel().name());
            } else if (veiculo.getModeloMotocicleta() != null) {
                stmt.setString(4, veiculo.getModeloMotocicleta().name());
            } else if (veiculo.getModeloVan() != null) {
                stmt.setString(4, veiculo.getModeloVan().name());
            }
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
    
    @Override
    public void deleteAll() throws SQLException {
        String sql = "DELETE FROM Veiculo";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
    }
}

}
