package model;

import enums.Categoria;
import enums.Estado;
import enums.Marca;

public class Veiculo{
    private int id;
    private final Marca marca;
    private Estado estado;
    private final Categoria categoria;
    private final String modelo;
    private double valorDeCompra;
    private final String placa;
    private final int ano;

    public Veiculo(int id, Marca marca, Estado estado, Categoria categoria, String modelo, double valorDeCompra, String placa, int ano) {
        this.id = id;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.modelo = modelo;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca.toString();
    }

    public String getEstado() {
        return estado.toString();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria.toString();
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }
}