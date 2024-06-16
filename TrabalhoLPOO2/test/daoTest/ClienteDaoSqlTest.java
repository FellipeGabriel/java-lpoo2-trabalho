package daoTest;

import dao.ClienteDaoSql;
import dao.LocacaoDaoSql;
import model.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteDaoSqlTest {

    private ClienteDaoSql clienteDao;
    private LocacaoDaoSql locacaoDao;

    @Before
    public void setUp() throws SQLException {
        clienteDao = new ClienteDaoSql();
        locacaoDao = new LocacaoDaoSql();
        clearDatabase();
    }

    @After
    public void tearDown() throws SQLException {
        clearDatabase();
    }

    private void clearDatabase() throws SQLException {
        // Limpar a tabela de locações primeiro
        locacaoDao.deleteAll();
        // Limpar a tabela de clientes em seguida
        clienteDao.deleteAll();
    }

    @Test
    public void testInsert() throws SQLException {
        Cliente cliente = new Cliente(0, "Shrek", "Silva", "123456789", "123.456.789-10", "Rua Almir Nelson de Almeida, 281");
        clienteDao.insert(cliente);
        Cliente clienteInserido = clienteDao.get(cliente.getId());
        assertNotNull(clienteInserido);
        assertEquals(cliente.getNome(), clienteInserido.getNome());
    }

    @Test
    public void testGet() throws SQLException {
        Cliente cliente = new Cliente(0, "Nina", "Oliveira", "987654321", "987.654.321-00", "Rua da Nina, 456");
        clienteDao.insert(cliente);
        Cliente clienteObtido = clienteDao.get(cliente.getId());
        assertNotNull(clienteObtido);
        assertEquals(cliente.getNome(), clienteObtido.getNome());
    }

    @Test
    public void testGetAll() throws SQLException {
        Cliente cliente1 = new Cliente(0, "Luiz", "Snows", "111222333", "111.222.333-44", "Rua Snow, 789");
        Cliente cliente2 = new Cliente(0, "Thomas", "Turbando", "444555666", "444.555.666-77", "Rua Sus, 101");
        clienteDao.insert(cliente1);
        clienteDao.insert(cliente2);
        List<Cliente> clientes = clienteDao.getAll();
        assertEquals(2, clientes.size());
    }

    @Test
    public void testUpdate() throws SQLException {
        Cliente cliente = new Cliente(0, "Paulo", "Bayer", "777888999", "777.888.999-00", "Rua Do Nargas, 102");
        clienteDao.insert(cliente);
        cliente.setNome("Paulo Atualizado");
        clienteDao.update(cliente);
        Cliente clienteAtualizado = clienteDao.get(cliente.getId());
        assertNotNull(clienteAtualizado);
        assertEquals("Paulo Atualizado", clienteAtualizado.getNome());
    }

    @Test
    public void testDelete() throws SQLException {
        Cliente cliente = new Cliente(0, "Michael", "Jackson", "000111222", "000.111.222-33", "Rua Ariouki kkkkkkk, 203");
        clienteDao.insert(cliente);
        clienteDao.delete(cliente.getId());
        Cliente clienteDeletado = clienteDao.get(cliente.getId());
        assertNull(clienteDeletado);
    }
}
