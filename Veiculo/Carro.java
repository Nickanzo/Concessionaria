package Veiculo;

public class Carro extends Veiculo{

    public enum Tipos {Sedan, Esportivo, Picape}
    private Tipos tipo;
    private boolean CaixaAberta;

    public Carro(String placa, String modelo, String marca, int ano, int lugares, Tipos tipo, boolean caixaAberta, double preco) {
        super(placa, modelo, marca, ano, lugares, preco);
        this.tipo = tipo;
        CaixaAberta = caixaAberta;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public boolean isCaixaAberta() {
        return CaixaAberta;
    }

    @Override
    public String toString() {
        return "Placa='" + placa + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Marca='" + marca + '\'' +
                ", Ano=" + ano +
                ", Preco=" + preco +
                ", Lugares=" + lugares +
                ", Tipo=" + tipo +
                '}';
    }
}
