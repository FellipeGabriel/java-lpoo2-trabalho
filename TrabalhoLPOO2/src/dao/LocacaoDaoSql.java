package dao;

import model.Locacao;
import model.Cliente;
import model.Veiculo;
import db.DatabaseConnection;
import enums.Categoria;
import enums.Estado;
import enums.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LocacaoDaoSql implements DAO<Locacao> {
    @Override
    public void insert(Locacao locacao) throws SQLException {
        String sql = "INSERT INTO Locacao (cliente_id, veiculo_id, data_inicio, data_fim, valor_total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, locacao.getCliente().getId());
            stmt.setInt(2, locacao.getVeiculo().getId());
            stmt.setDate(3, new java.sql.Date(locacao.getDataInicio().getTimeInMillis()));
            stmt.setDate(4, new java.sql.Date(locacao.getDataFim().getTimeInMillis()));
            stmt.setDouble(5, locacao.getValorTotal());
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
                Calendar dataInicio = Calendar.getInstance();
                dataInicio.setTime(rs.getDate("data_inicio"));
                Calendar dataFim = Calendar.getInstance();
                dataFim.setTime(rs.getDate("data_fim"));

                ClienteDaoSql clienteDao = new ClienteDaoSql();
                VeiculoDaoSql veiculoDao = new VeiculoDaoSql();
                Cliente cliente = clienteDao.get(rs.getInt("cliente_id"));
                Veiculo veiculo = veiculoDao.get(rs.getInt("veiculo_id"));

                locacao = new Locacao(
                        rs.getInt("id"),
                        (int) ((dataFim.getTimeInMillis() - dataInicio.getTimeInMillis()) / (1000 * 60 * 60 * 24)),
                        rs.getDouble("valor_total"),
                        dataInicio,
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
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Calendar dataInicio = Calendar.getInstance();
                dataInicio.setTime(rs.getDate("data_inicio"));
                Calendar dataFim = Calendar.getInstance();
                dataFim.setTime(rs.getDate("data_fim"));

                ClienteDaoSql clienteDao = new ClienteDaoSql();
                VeiculoDaoSql veiculoDao = new VeiculoDaoSql();
                Cliente cliente = clienteDao.get(rs.getInt("cliente_id"));
                Veiculo veiculo = veiculoDao.get(rs.getInt("veiculo_id"));

                Locacao locacao = new Locacao(
                        rs.getInt("id"),
                        (int) ((dataFim.getTimeInMillis() - dataInicio.getTimeInMillis()) / (1000 * 60 * 60 * 24)),
                        rs.getDouble("valor_total"),
                        dataInicio,
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
        String sql = "UPDATE Locacao SET cliente_id = ?, veiculo_id = ?, data_inicio = ?, data_fim = ?, valor_total = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, locacao.getCliente().getId());
            stmt.setInt(2, locacao.getVeiculo().getId());
            stmt.setDate(3, new java.sql.Date(locacao.getDataInicio().getTimeInMillis()));
            stmt.setDate(4, new java.sql.Date(locacao.getDataFim().getTimeInMillis()));
            stmt.setDouble(5, locacao.getValorTotal());
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

    public void deleteAll() throws SQLException {
        String sql = "DELETE FROM Locacao";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
}