package dao;

import model.Locacao;
import model.Cliente;
import model.Veiculo;
import db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LocacaoDaoSql implements DAO<Locacao> {
    @Override
    public void insert(Locacao locacao) throws SQLException {
        String sql = "INSERT INTO Locacao (dias, valor, data, cliente_id, veiculo_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, locacao.getDias());
            stmt.setDouble(2, locacao.getValor());
            stmt.setDate(3, new java.sql.Date(locacao.getDataInicio().getTimeInMillis()));
            stmt.setInt(4, locacao.getCliente().getId());
            stmt.setInt(5, locacao.getVeiculo().getId());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    locacao.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao inserir a locação, nenhum ID obtido.");
                }
            }
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
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));

                ClienteDaoSql clienteDao = new ClienteDaoSql();
                VeiculoDaoSql veiculoDao = new VeiculoDaoSql();
                Cliente cliente = clienteDao.get(rs.getInt("cliente_id"));
                Veiculo veiculo = veiculoDao.get(rs.getInt("veiculo_id"));

                locacao = new Locacao(
                        rs.getInt("id"),
                        rs.getInt("dias"),
                        rs.getDouble("valor"),
                        data,
                        cliente,
                        veiculo
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
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));

                ClienteDaoSql clienteDao = new ClienteDaoSql();
                VeiculoDaoSql veiculoDao = new VeiculoDaoSql();
                Cliente cliente = clienteDao.get(rs.getInt("cliente_id"));
                Veiculo veiculo = veiculoDao.get(rs.getInt("veiculo_id"));

                Locacao locacao = new Locacao(
                        rs.getInt("id"),
                        rs.getInt("dias"),
                        rs.getDouble("valor"),
                        data,
                        cliente,
                        veiculo
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
            stmt.setDate(3, new java.sql.Date(locacao.getDataInicio().getTimeInMillis()));
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

    @Override
    public void deleteAll() throws SQLException {
        String sql = "DELETE FROM Locacao";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
}
