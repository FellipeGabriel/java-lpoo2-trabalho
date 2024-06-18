package model;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import enums.ModeloMotocicleta;
import enums.ModeloVan;
import java.time.Year;
import java.util.Calendar;

public class Veiculo {
    private final Marca marca;
    private Estado estado;
    private Locacao locacao;
    private final Categoria categoria;
    private final double valorDeCompra;
    private final String placa;
    private final int ano;
    private ModeloAutomovel modeloAutomovel;
    private ModeloMotocicleta modeloMotocicleta;
    private ModeloVan modeloVan;
    private int id;

    // Construtor para Automovel
    public Veiculo(int id, Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano, ModeloAutomovel modelo) {
        this(id, marca, categoria, estado, valorDeCompra, placa, ano);
        this.modeloAutomovel = modelo;
    }

    // Construtor para Motocicleta
    public Veiculo(int id, Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano, ModeloMotocicleta modelo) {
        this(id, marca, categoria, estado, valorDeCompra, placa, ano);
        this.modeloMotocicleta = modelo;
    }

    // Construtor para Van
    public Veiculo(int id, Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano, ModeloVan modelo) {
        this(id, marca, categoria, estado, valorDeCompra, placa, ano);
        this.modeloVan = modelo;
    }

    // Construtor comum
    private Veiculo(int id, Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano) {
        this.id =id;
        this.locacao = null;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    public void locar(int id, int dias, double valor, Calendar data, Cliente cliente) {
        if (this.estado != Estado.VENDIDO) {
            this.estado = Estado.LOCADO;
            this.locacao = new Locacao(id, dias, valor, data, cliente, this);
            this.getValorDiariaLocacao();
        }
    }

    public void vender() {
        this.estado = Estado.VENDIDO;
    }

    public void devolver() {
        this.estado = Estado.DISPONÍVEL;
        this.locacao = null;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public Marca getMarca() {
        return this.marca;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Locacao getLocacao() {
        return this.locacao;
    }

    public String getPlaca() {
        return this.placa;
    }

    public int getAno() {
        return this.ano;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public double getValorDeCompra() {
        return this.valorDeCompra;
    }

    public double getValorParaVenda() {
        int idadeVeiculoEmAnos = Year.now().getValue() - this.ano;
        double valorParaVenda = this.valorDeCompra - idadeVeiculoEmAnos * 0.15 * this.valorDeCompra;
        if (valorParaVenda < 0 || valorParaVenda < this.valorDeCompra * 0.1) {
            valorParaVenda = this.valorDeCompra * 0.1;
        }
        return valorParaVenda;
    }

    public double getValorDiariaLocacao() {
        switch (this.categoria) {
            case POPULAR -> {
                return this.modeloAutomovel != null ? 100 :
                       this.modeloMotocicleta != null ? 70 :
                       this.modeloVan != null ? 200 : 0;
            }
            case INTERMEDIÁRIO -> {
                return this.modeloAutomovel != null ? 300 :
                       this.modeloMotocicleta != null ? 200 :
                       this.modeloVan != null ? 400 : 0;
            }
            case LUXO -> {
                return this.modeloAutomovel != null ? 450 :
                       this.modeloMotocicleta != null ? 350 :
                       this.modeloVan != null ? 600 : 0;
            }
            default -> {
                return 0;
            }
        }
    }

    public ModeloAutomovel getModeloAutomovel() {
        return this.modeloAutomovel;
    }

    public ModeloMotocicleta getModeloMotocicleta() {
        return this.modeloMotocicleta;
    }

    public ModeloVan getModeloVan() {
        return this.modeloVan;
    }
}
