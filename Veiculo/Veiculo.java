package Veiculo;

public abstract class Veiculo {

    String  placa,
            modelo,
            marca;
    int ano,
        lugares;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public int getLugares() {
        return lugares;
    }

    public Veiculo(String placa, String modelo, String marca, int ano, int lugares) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.lugares = lugares;
    }
}
