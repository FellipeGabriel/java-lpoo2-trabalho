package model;

import java.util.Calendar;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloVan;
import interfaces.VeiculoI;
import java.time.Year;

public abstract class Veiculo implements VeiculoI{
   private Marca marca;
    private Estado estado;
    private classes.Locacao locacao;
    private final Categoria categoria;
    private final double valorDeCompra;
    private String placa;
    private int ano;
    private int id;
    
    public Veiculo(int id,Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano) {
        this.locacao = null;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }
    
    public void locar(int dias, double valor, Calendar data, classes.Cliente cliente) {
        if (this.estado != Estado.VENDIDO) {
            this.estado = Estado.LOCADO;
            this.locacao = new classes.Locacao(dias,valor,data, cliente){
                
            };

            this.getValorDiariaLocacao();
        }
    }
    
    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    };
    
    @Override
    public void devolver() {
        this.estado = Estado.DISPONÍVEL;
        this.locacao = null;
    };
    
    @Override
    public Estado getEstado() {
        return this.estado;
    };
    
    @Override
    public Marca getMarca() {
        return this.marca;
    };
    
    @Override
    public Categoria getCategoria() {
        return this.categoria;
    };
    
    @Override
    public classes.Locacao getLocacao() {
        return this.locacao;
    };
    
    @Override
    public String getPlaca() {
        return this.placa;
    };
    
    @Override
    public int getAno() {
        return this.ano;
    };
    
    @Override
    public double getValorParaVenda() {
        int idadeVeiculoEmAnos = Year.now().getValue() - this.ano;
        double valorParaVenda = this.valorDeCompra - idadeVeiculoEmAnos * 0.15 * this.valorDeCompra;
        if (valorParaVenda < 0 || valorParaVenda < this.valorDeCompra * 0.1) {
            valorParaVenda = this.valorDeCompra * 0.1;
        }
        
        return valorParaVenda;
    };
    
    @Override
    public abstract double getValorDiariaLocacao();
    
}
