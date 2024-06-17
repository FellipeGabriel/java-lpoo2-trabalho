package daoTest;

import dao.ClienteDaoSql;
import dao.LocacaoDaoSql;
import dao.VeiculoDaoSql;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import model.Cliente;
import model.Locacao;
import model.Veiculo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import enums.ModeloMotocicleta;
import enums.ModeloVan;


import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class LocacaoDaoSqlTest {

    private LocacaoDaoSql locacaoDao;
    private ClienteDaoSql clienteDao;
    private VeiculoDaoSql veiculoDao;

    @Before
    public void setUp() throws SQLException {
        locacaoDao = new LocacaoDaoSql();
        clienteDao = new ClienteDaoSql();
        veiculoDao = new VeiculoDaoSql();
        clearDatabase();
    }

    @After
    public void tearDown() throws SQLException {
        clearDatabase();
    }

    private void clearDatabase() throws SQLException {
        locacaoDao.deleteAll();
        clienteDao.deleteAll();
        veiculoDao.deleteAll();
    }

    @Test
    public void testInsert() throws SQLException {
        Cliente cliente = new Cliente("Goku", "Son", "123456789", "123.456.789-10", "Rua Kamehameha, 281");
        clienteDao.insert(cliente);

        Veiculo veiculo = new Veiculo(1, Marca.VW, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.00, "ABC-1234", 2020, ModeloAutomovel.Gol);
        veiculoDao.insert(veiculo);

        Calendar data = Calendar.getInstance();
        Locacao locacao = new Locacao(7, 100.0, data, cliente, veiculo);
        locacaoDao.insert(locacao);

        Locacao locacaoInserida = locacaoDao.get(locacao.getId());
        assertNotNull(locacaoInserida);
        assertEquals(locacao.getDias(), locacaoInserida.getDias());
    }

    @Test
    public void testGet() throws SQLException {
        Cliente cliente = new Cliente("Vegeta", "Prince", "987654321", "987.654.321-00", "Rua Galick Gun, 456");
        clienteDao.insert(cliente);

        Veiculo veiculo = new Veiculo(2, Marca.GM, Categoria.INTERMEDIÁRIO, Estado.DISPONÍVEL, 50000.00, "DEF-5678", 2021, ModeloAutomovel.Celta);
        veiculoDao.insert(veiculo);

        Calendar data = Calendar.getInstance();
        Locacao locacao = new Locacao(5, 150.0, data, cliente, veiculo);
        locacaoDao.insert(locacao);

        Locacao locacaoObtida = locacaoDao.get(locacao.getId());
        assertNotNull(locacaoObtida);
        assertEquals(locacao.getDias(), locacaoObtida.getDias());
    }

    @Test
    public void testGetAll() throws SQLException {
        Cliente cliente1 = new Cliente("Gohan", "Son", "111222333", "111.222.333-44", "Rua Masenko, 789");
        Cliente cliente2 = new Cliente("Trunks", "Briefs", "444555666", "444.555.666-77", "Rua Espada, 101");
        clienteDao.insert(cliente1);
        clienteDao.insert(cliente2);

        Veiculo veiculo1 = new Veiculo(3, Marca.FIAT, Categoria.LUXO, Estado.DISPONÍVEL, 80000.00, "GHI-9101", 2022, ModeloAutomovel.Palio);
        Veiculo veiculo2 = new Veiculo(4, Marca.HONDA, Categoria.POPULAR, Estado.DISPONÍVEL, 25000.00, "JKL-1121", 2019, ModeloMotocicleta.CG125);
        veiculoDao.insert(veiculo1);
        veiculoDao.insert(veiculo2);

        Calendar data = Calendar.getInstance();
        Locacao locacao1 = new Locacao(3, 200.0, data, cliente1, veiculo1);
        Locacao locacao2 = new Locacao(4, 80.0, data, cliente2, veiculo2);
        locacaoDao.insert(locacao1);
        locacaoDao.insert(locacao2);

        List<Locacao> locacoes = locacaoDao.getAll();
        assertEquals(2, locacoes.size());
    }

    @Test
    public void testUpdate() throws SQLException {
        Cliente cliente = new Cliente("Piccolo", "Daimaoh", "777888999", "777.888.999-00", "Rua Makankosappo, 102");
        clienteDao.insert(cliente);

        Veiculo veiculo = new Veiculo(5, Marca.MERCEDES, Categoria.LUXO, Estado.DISPONÍVEL, 100000.00, "MNO-2232", 2023, ModeloVan.SPRINTER);
        veiculoDao.insert(veiculo);

        Calendar data = Calendar.getInstance();
        Locacao locacao = new Locacao(10, 300.0, data, cliente, veiculo);
        locacaoDao.insert(locacao);

        locacao.setDias(15);
        locacao.setValor(350.0);
        locacaoDao.update(locacao);

        Locacao locacaoAtualizada = locacaoDao.get(locacao.getId());
        assertNotNull(locacaoAtualizada);
        assertEquals(15, locacaoAtualizada.getDias());
        assertEquals(350.0, locacaoAtualizada.getValor(), 0.0);
    }

    @Test
    public void testDelete() throws SQLException {
        Cliente cliente = new Cliente("Frieza", "Cold", "000111222", "000.111.222-33", "Rua Death Beam, 203");
        clienteDao.insert(cliente);

        Veiculo veiculo = new Veiculo(6, Marca.VW, Categoria.POPULAR, Estado.DISPONÍVEL, 35000.00, "PQR-3343", 2018, ModeloAutomovel.Gol);
        veiculoDao.insert(veiculo);

        Calendar data = Calendar.getInstance();
        Locacao locacao = new Locacao(6, 90.0, data, cliente, veiculo);
        locacaoDao.insert(locacao);

        locacaoDao.delete(locacao.getId());
        Locacao locacaoDeletada = locacaoDao.get(locacao.getId());
        assertNull(locacaoDeletada);
    }
}
