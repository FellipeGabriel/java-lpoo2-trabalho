package daoTest;

import model.Cliente;
import model.Veiculo;
import model.Locacao;
import model.dao.ClienteDaoSql;
import model.dao.VeiculoDaoSql;
import model.dao.LocacaoDaoSql;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        // Inserir Cliente e Veículo primeiro
        Cliente cliente = new Cliente("Michael", "Jackson", "123456789", "123.456.789-10", "Rua Almir Nelson de Almeida, 69");
        clienteDao.insert(cliente);
        Veiculo veiculo = new Veiculo(0, Marca.FIAT, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.0, "ABC-1234", 2020, ModeloAutomovel.Celta);
        veiculoDao.insert(veiculo);

        // Criar e inserir Locacao
        Calendar dataInicio = Calendar.getInstance();
        Locacao locacao = new Locacao(0, 7, 500.0, dataInicio, cliente, veiculo);
        locacaoDao.insert(locacao);

        Locacao locacaoInserida = locacaoDao.get(locacao.getId());
        assertNotNull("Locação inserida não deve ser nula", locacaoInserida);
        assertEquals("Dias da locação devem ser iguais", locacao.getDias(), locacaoInserida.getDias());
        assertEquals("Valor da locação deve ser igual", locacao.getValor(), locacaoInserida.getValor(), 0.001);  
        assertEquals("Cliente da locação deve ser igual", locacao.getCliente().getId(), locacaoInserida.getCliente().getId());
        assertEquals("Veículo da locação deve ser igual", locacao.getVeiculo().getId(), locacaoInserida.getVeiculo().getId());
    }


    @Test
    public void testGet() throws SQLException {
        // Inserir Cliente e Veículo primeiro
        Cliente cliente = new Cliente("Sokome", "Kudemasho", "987654321", "987.654.321-00", "Rua da Miyazaki, 200");
        clienteDao.insert(cliente);
        Veiculo veiculo = new Veiculo(0, Marca.HONDA, Categoria.POPULAR, Estado.DISPONÍVEL, 15000.0, "XYZ-9876", 2018, ModeloAutomovel.Gol);
        veiculoDao.insert(veiculo);

        // Criar e inserir Locacao
        Calendar dataInicio = Calendar.getInstance();
        Locacao locacao = new Locacao(0, 10, 800.0, dataInicio, cliente, veiculo);
        locacaoDao.insert(locacao);

        Locacao locacaoObtida = locacaoDao.get(locacao.getId());
        assertNotNull("Locação obtida não deve ser nula", locacaoObtida);
        assertEquals("Cliente da locação deve ser igual", locacao.getCliente().getId(), locacaoObtida.getCliente().getId());
        assertEquals("Veículo da locação deve ser igual", locacao.getVeiculo().getId(), locacaoObtida.getVeiculo().getId());
    }

    @Test
    public void testGetAll() throws SQLException {
        // Inserir Cliente e Veículo primeiro
        Cliente cliente1 = new Cliente("Luiz", "Snows", "111222333", "111.222.333-44", "Rua Snow, 789");
        Cliente cliente2 = new Cliente("Thomas", "Turbando", "444555666", "444.555.666-77", "Rua Sus, 101");
        clienteDao.insert(cliente1);
        clienteDao.insert(cliente2);
        Veiculo veiculo1 = new Veiculo(0, Marca.FIAT, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.0, "ABC-1234", 2020, ModeloAutomovel.Celta);
        Veiculo veiculo2 = new Veiculo(0, Marca.HONDA, Categoria.POPULAR, Estado.DISPONÍVEL, 15000.0, "XYZ-9876", 2018, ModeloAutomovel.Palio);
        veiculoDao.insert(veiculo1);
        veiculoDao.insert(veiculo2);

        // Criar e inserir Locacoes
        Calendar dataInicio1 = Calendar.getInstance();
        Calendar dataInicio2 = Calendar.getInstance();
        Locacao locacao1 = new Locacao(0, 7, 500.0, dataInicio1, cliente1, veiculo1);
        Locacao locacao2 = new Locacao(0, 10, 800.0, dataInicio2, cliente2, veiculo2);
        locacaoDao.insert(locacao1);
        locacaoDao.insert(locacao2);

        List<Locacao> locacoes = locacaoDao.getAll();
        assertEquals("Número de locações obtidas deve ser 2", 2, locacoes.size());
    }

    @Test
    public void testUpdate() throws SQLException {
        // Inserir Cliente e Veículo primeiro
        Cliente cliente = new Cliente("Iago", "Nobre", "777888999", "777.888.999-00", "Rua Coca Ína, 102");
        clienteDao.insert(cliente);
        Veiculo veiculo = new Veiculo(0, Marca.VW, Categoria.LUXO, Estado.DISPONÍVEL, 50000.0, "LMN-4567", 2021, ModeloAutomovel.Gol);
        veiculoDao.insert(veiculo);

        // Criar e inserir Locacao
        Calendar dataInicio = Calendar.getInstance();
        Locacao locacao = new Locacao(0, 15, 1200.0, dataInicio, cliente, veiculo);
        locacaoDao.insert(locacao);

        locacao = locacaoDao.get(locacao.getId());
        locacao.setDias(20);
        locacao.setValor(1500.0);
        locacaoDao.update(locacao);

        Locacao locacaoAtualizada = locacaoDao.get(locacao.getId());
        assertNotNull("Locação atualizada não deve ser nula", locacaoAtualizada);
        assertEquals("Dias da locação atualizada devem ser 20", 20, locacaoAtualizada.getDias());
        assertEquals("Valor da locação atualizada deve ser 1500.0", 1500.0, locacaoAtualizada.getValor(), 0.001);
    }

    @Test
    public void testDelete() throws SQLException {
        // Inserir Cliente e Veículo primeiro
        Cliente cliente = new Cliente("Ana", "Tel", "000111222", "000.111.222-33", "Rua do AMD, 203");
        clienteDao.insert(cliente);
        Veiculo veiculo = new Veiculo(0, Marca.FIAT, Categoria.POPULAR, Estado.DISPONÍVEL, 60000.0, "QWE-5678", 2022, ModeloAutomovel.Palio);
        veiculoDao.insert(veiculo);

        // Criar e inserir Locacao
        Calendar dataInicio = Calendar.getInstance();
        Locacao locacao = new Locacao(0, 5, 1000.0, dataInicio, cliente, veiculo);
        locacaoDao.insert(locacao);

        locacaoDao.delete(locacao.getId());

        Locacao locacaoDeletada = locacaoDao.get(locacao.getId());
        assertNull("Locação deletada deve ser nula", locacaoDeletada);
    }
}
