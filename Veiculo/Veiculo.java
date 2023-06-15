package Veiculo;

public abstract class Veiculo {

    protected String  placa,
            modelo,
            marca;
    protected int ano,
              lugares;
    protected double preco;
    public Veiculo(){
    }
    public Veiculo(String placa, String modelo, String marca, int ano, int lugares, double preco) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.lugares = lugares;
        this.preco = preco;
    }
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


}
