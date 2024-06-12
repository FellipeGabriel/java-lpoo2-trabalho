/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Calendar;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloVan;

/**
 *
 * @author janai
 */
public class Van extends Veiculo {
    
    private final ModeloVan modelo;
    
    public Van(Marca marca, Categoria categoria, Estado estado, double valorDeCompra, String placa, int ano, ModeloVan modelo){
        super(marca, categoria, estado, valorDeCompra, placa, ano);
        this.modelo = modelo;
    };
    
    public ModeloVan getModelo(){
        return this.modelo;
    };
    
    @Override
    public double getValorDiariaLocacao(){
    switch(this.getCategoria()) {
            case POPULAR -> {
                return 200;
            }
            case INTERMEDIÁRIO -> {
                return 400;
            }
            case LUXO -> {
                return 600;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        throw new UnsupportedOperationException("Método locar não implementado em Van");
    }
}
