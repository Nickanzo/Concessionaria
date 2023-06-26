package Veiculo;

public abstract class Veiculo {

    protected String placa,
		modelo,
		marca;
    protected int ano, 
		lugares;

    protected double precoBase;

    public Veiculo(String placa, String modelo, String marca, int ano, int lugares, double precoBase) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.lugares = lugares;
        this.precoBase = precoBase;
    }
	
	public Veiculo(Veiculo veiculo){
	    this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.lugares = veiculo.getLugares();
        this.precoBase = veiculo.getPrecoBase();
    }

    public abstract double calcularPrecoTotal();
	
	public double getPrecoBase() {
        return precoBase;
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
