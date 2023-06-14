package Veiculo;

public class Carro extends Veiculo{

    public enum Tipos {Sedan, Esportivo, Picape}
    private Tipos tipo;
    private boolean CaixaAberta;

    public Carro(String placa, String modelo, String marca, int ano, int lugares, Tipos tipo, boolean caixaAberta) {
        super(placa, modelo, marca, ano, lugares);
        this.tipo = tipo;
        CaixaAberta = caixaAberta;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public boolean isCaixaAberta() {
        return CaixaAberta;
    }
}
