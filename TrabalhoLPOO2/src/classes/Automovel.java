/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Calendar;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;

/**
 *
 * @author paulo
 */
public class Automovel extends Veiculo {
    
    private final ModeloAutomovel modelo;
    
    public Automovel(Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano, ModeloAutomovel modelo) {
        super(marca, categoria, estado, valorDeCompra, placa, ano);
        this.modelo = modelo;
    };
    
    public ModeloAutomovel getModelo() {
        return this.modelo;
    };
    
    @Override
    public double getValorDiariaLocacao() {
        switch(this.getCategoria()) {
            case POPULAR -> {
                return 100;
            }
            case INTERMEDIÁRIO -> {
                return 300;
            }
            case LUXO -> {
                return 450;
            }
            default -> {
                 return 0;
            }
        }
    }
    
    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        throw new UnsupportedOperationException("Método locar não implementado em Automovel");
    }

}
