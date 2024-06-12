package dao;

import model.Locacao;
import db.DatabaseConnection;
import java.util.Calendar;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO implements DAO<Locacao> {

    @Override
    public void insert(Locacao locacao) throws SQLException {
        String sql = "INSERT INTO Locacao (dias, valor, data, cliente_id, veiculo_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, locacao.getDias());
            stmt.setDouble(2, locacao.getValor());
            stmt.setDate(3, new Date(locacao.getData().getTimeInMillis()));
            stmt.setInt(4, locacao.getCliente().getId());
            stmt.setInt(5, locacao.getVeiculo().getId());
            stmt.executeUpdate();
        }
    }

    @Override
public Locacao get(int id) throws SQLException {
    String sql = "SELECT * FROM Locacao WHERE id = ?";
    Locacao locacao = null;
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(rs.getDate("data").getTime());
            locacao = new Locacao(
                    rs.getInt("id"),
                    rs.getInt("dias"),
                    rs.getDouble("valor"),
                    calendar,
                    new ClienteDAO().get(rs.getInt("cliente_id")),
                    new VeiculoDAO().get(rs.getInt("veiculo_id"))
            );
        }
    }
    return locacao;
}

    @Override
public List<Locacao> getAll() throws SQLException {
    String sql = "SELECT * FROM Locacao";
    List<Locacao> locacoes = new ArrayList<>();
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(rs.getDate("data").getTime());
            Locacao locacao = new Locacao(
                    rs.getInt("id"),
                    rs.getInt("dias"),
                    rs.getDouble("valor"),
                    calendar,
                    new ClienteDAO().get(rs.getInt("cliente_id")),
                    new VeiculoDAO().get(rs.getInt("veiculo_id"))
            );
            locacoes.add(locacao);
        }
    }
    return locacoes;
}

    @Override
    public void update(Locacao locacao) throws SQLException {
        String sql = "UPDATE Locacao SET dias = ?, valor = ?, data = ?, cliente_id = ?, veiculo_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, locacao.getDias());
            stmt.setDouble(2, locacao.getValor());
            stmt.setDate(3, new Date(locacao.getData().getTimeInMillis()));
            stmt.setInt(4, locacao.getCliente().getId());
            stmt.setInt(5, locacao.getVeiculo().getId());
            stmt.setInt(6, locacao.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Locacao WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
