package model;

import java.util.Calendar;

public class Locacao {
    private int id;
    private int dias;
    private double valor;
    private Calendar data;
    private Cliente cliente;
    private Veiculo veiculo;

    public Locacao(int id, int dias, double valor, Calendar data, Cliente cliente, Veiculo veiculo) {
        this.id = id;
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
