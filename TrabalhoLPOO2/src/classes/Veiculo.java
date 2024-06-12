/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import enums.Categoria;
import enums.Marca;
import enums.Estado;
import interfaces.VeiculoI;
import java.time.Year;
import java.util.Calendar;

/**
 * 
 * @author paulo
 */
public abstract class Veiculo implements VeiculoI {
    
    private Marca marca;
    private Estado estado;
    private Locacao locacao;
    private final Categoria categoria;
    private final double valorDeCompra;
    private String placa;
    private int ano;
    
    public Veiculo(Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano) {
        this.locacao = null;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }
    
    public void locar(int dias, double valor, Calendar data, Cliente cliente) {
        if (this.estado != Estado.VENDIDO) {
            this.estado = Estado.LOCADO;
            this.locacao = new Locacao(dias,valor,data, cliente){
                
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
    public Locacao getLocacao() {
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
