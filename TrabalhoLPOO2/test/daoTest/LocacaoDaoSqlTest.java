package daoTest;

import model.Cliente;
import model.Locacao;
import model.Veiculo;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.dao.ClienteDaoSql;
import model.dao.LocacaoDaoSql;
import model.dao.VeiculoDaoSql;

import java.sql.SQLException;
import java.util.Calendar;

import static org.junit.Assert.*;

public class LocacaoDaoSqlTest {
    private LocacaoDaoSql locacaoDao;
    private ClienteDaoSql clienteDao;
    private VeiculoDaoSql veiculoDao;
    private Cliente cliente;
    private Veiculo veiculo;
    private Locacao locacao;

    @Before
    public void setUp() throws SQLException {
        locacaoDao = new LocacaoDaoSql();
        clienteDao = new ClienteDaoSql();
        veiculoDao = new VeiculoDaoSql();
        
        // Inserindo Cliente
        cliente = new Cliente("João", "Silva", "123456", "987.654.321-00", "Rua Exemplo, 123");
        clienteDao.insert(cliente);

        // Inserindo Veículo
        veiculo = new Veiculo(1, Marca.FORD, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.0, "ABC-1234", 2020, ModeloAutomovel.GOL);
        veiculoDao.insert(veiculo);

        // Criando Locação
        Calendar data = Calendar.getInstance();
        locacao = new Locacao(7, 100.0, data, cliente, veiculo);
        locacaoDao.insert(locacao);
    }

    @After
    public void tearDown() throws SQLException {
        locacaoDao.deleteAll();
        clienteDao.deleteAll();
        veiculoDao.deleteAll();
    }

    @Test
    public void testInsert() throws SQLException {
        Locacao locacaoInserida = locacaoDao.get(locacao.getId());
        assertNotNull(locacaoInserida);
        assertEquals(locacao.getDias(), locacaoInserida.getDias());
        assertEquals(locacao.getValor(), locacaoInserida.getValor(), 0.01);
        assertEquals(locacao.getCliente().getId(), locacaoInserida.getCliente().getId());
        assertEquals(locacao.getVeiculo().getId(), locacaoInserida.getVeiculo().getId());
    }

    @Test
    public void testGet() throws SQLException {
        Locacao locacaoObtida = locacaoDao.get(locacao.getId());
        assertNotNull(locacaoObtida);
        assertEquals(locacao.getId(), locacaoObtida.getId());
    }

    @Test
    public void testGetAll() throws SQLException {
        assertTrue(locacaoDao.getAll().size() > 0);
    }

    @Test
    public void testUpdate() throws SQLException {
        locacao.setDias(10);
        locacao.setValor(150.0);
        locacaoDao.update(locacao);
        
        Locacao locacaoAtualizada = locacaoDao.get(locacao.getId());
        assertNotNull(locacaoAtualizada);
        assertEquals(10, locacaoAtualizada.getDias());
        assertEquals(150.0, locacaoAtualizada.getValor(), 0.01);
    }

    @Test
    public void testDelete() throws SQLException {
        locacaoDao.delete(locacao.getId());
        Locacao locacaoDeletada = locacaoDao.get(locacao.getId());
        assertNull(locacaoDeletada);
    }
}
