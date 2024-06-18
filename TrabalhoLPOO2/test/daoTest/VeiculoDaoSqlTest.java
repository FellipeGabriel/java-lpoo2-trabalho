package daoTest;

import model.Veiculo;
import model.dao.VeiculoDaoSql;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import enums.ModeloMotocicleta;
import enums.ModeloVan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class VeiculoDaoSqlTest {

    private VeiculoDaoSql veiculoDao;

    @Before
    public void setUp() throws SQLException {
        veiculoDao = new VeiculoDaoSql();
        clearDatabase();
    }

    @After
    public void tearDown() throws SQLException {
        clearDatabase();
    }

    private void clearDatabase() throws SQLException {
        veiculoDao.deleteAll();
    }

    @Test
    public void testInsertAutomovel() throws SQLException {
        Veiculo veiculo = new Veiculo(0, Marca.FIAT, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.0, "ABC-1234", 2020, ModeloAutomovel.Celta);
        veiculoDao.insert(veiculo);

        Veiculo retrievedVeiculo = veiculoDao.get(veiculo.getId());
        assertNotNull("Veículo inserido deve ser não nulo", retrievedVeiculo);
        assertEquals("Marca do veículo inserido deve ser igual", veiculo.getMarca(), retrievedVeiculo.getMarca());
        assertEquals("Estado do veículo inserido deve ser igual", veiculo.getEstado(), retrievedVeiculo.getEstado());
        assertEquals("Categoria do veículo inserido deve ser igual", veiculo.getCategoria(), retrievedVeiculo.getCategoria());
        assertEquals("Modelo do veículo inserido deve ser igual", veiculo.getModeloAutomovel(), retrievedVeiculo.getModeloAutomovel());
    }

    @Test
    public void testInsertMotocicleta() throws SQLException {
        Veiculo veiculo = new Veiculo(0, Marca.HONDA, Categoria.POPULAR, Estado.DISPONÍVEL, 15000.0, "XYZ-9876", 2018, ModeloMotocicleta.CBR500);
        veiculoDao.insert(veiculo);

        Veiculo retrievedVeiculo = veiculoDao.get(veiculo.getId());
        assertNotNull("Veículo inserido deve ser não nulo", retrievedVeiculo);
        assertEquals("Marca do veículo inserido deve ser igual", veiculo.getMarca(), retrievedVeiculo.getMarca());
        assertEquals("Modelo do veículo inserido deve ser igual", veiculo.getModeloMotocicleta(), retrievedVeiculo.getModeloMotocicleta());
    }

    @Test
    public void testInsertVan() throws SQLException {
        Veiculo veiculo = new Veiculo(0, Marca.VW, Categoria.LUXO, Estado.DISPONÍVEL, 50000.0, "LMN-4567", 2021, ModeloVan.KOMBI);
        veiculoDao.insert(veiculo);

        Veiculo retrievedVeiculo = veiculoDao.get(veiculo.getId());
        assertNotNull("Veículo inserido deve ser não nulo", retrievedVeiculo);
        assertEquals("Marca do veículo inserido deve ser igual", veiculo.getMarca(), retrievedVeiculo.getMarca());
        assertEquals("Modelo do veículo inserido deve ser igual", veiculo.getModeloVan(), retrievedVeiculo.getModeloVan());
    }

    @Test
    public void testGet() throws SQLException {
        Veiculo veiculo = new Veiculo(0, Marca.HONDA, Categoria.POPULAR, Estado.DISPONÍVEL, 15000.0, "XYZ-9876", 2018, ModeloMotocicleta.CBR500);
        veiculoDao.insert(veiculo);

        Veiculo retrievedVeiculo = veiculoDao.get(veiculo.getId());
        assertNotNull("Veículo obtido deve ser não nulo", retrievedVeiculo);
        assertEquals("Marca do veículo obtido deve ser igual", veiculo.getMarca(), retrievedVeiculo.getMarca());
        assertEquals("Modelo do veículo obtido deve ser igual", veiculo.getModeloMotocicleta(), retrievedVeiculo.getModeloMotocicleta());
    }

    @Test
    public void testUpdate() throws SQLException {
        Veiculo veiculo = new Veiculo(0, Marca.FIAT, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.0, "ABC-1234", 2020, ModeloAutomovel.Celta);
        veiculoDao.insert(veiculo);

        veiculo = veiculoDao.get(veiculo.getId());
        veiculo.vender();
        veiculoDao.update(veiculo);

        Veiculo updatedVeiculo = veiculoDao.get(veiculo.getId());
        assertNotNull("Veículo atualizado deve ser não nulo", updatedVeiculo);
        assertEquals("Estado do veículo atualizado deve ser VENDIDO", Estado.VENDIDO, updatedVeiculo.getEstado());
    }

    @Test
    public void testDelete() throws SQLException {
        Veiculo veiculo = new Veiculo(0, Marca.VW, Categoria.LUXO, Estado.DISPONÍVEL, 50000.0, "LMN-4567", 2021, ModeloVan.KOMBI);
        veiculoDao.insert(veiculo);

        veiculoDao.delete(veiculo.getId());

        Veiculo deletedVeiculo = veiculoDao.get(veiculo.getId());
        assertNull("Veículo deletado deve ser nulo", deletedVeiculo);
    }

    @Test
    public void testGetAll() throws SQLException {
        Veiculo veiculo1 = new Veiculo(0, Marca.FIAT, Categoria.POPULAR, Estado.DISPONÍVEL, 30000.0, "ABC-1234", 2020, ModeloAutomovel.Celta);
        Veiculo veiculo2 = new Veiculo(0, Marca.HONDA, Categoria.POPULAR, Estado.DISPONÍVEL, 15000.0, "XYZ-9876", 2018, ModeloMotocicleta.CBR500);
        Veiculo veiculo3 = new Veiculo(0, Marca.VW, Categoria.LUXO, Estado.DISPONÍVEL, 50000.0, "LMN-4567", 2021, ModeloVan.KOMBI);

        veiculoDao.insert(veiculo1);
        veiculoDao.insert(veiculo2);
        veiculoDao.insert(veiculo3);

        List<Veiculo> veiculos = veiculoDao.getAll();
        assertEquals("Número de veículos obtidos deve ser 3", 3, veiculos.size());
    }
}