package Veiculo;

public class Carro extends Veiculo {

    public enum Tipo {
        Sedan, Esportivo, Picape
    }

    private Tipo tipo;
    private boolean CaixaAberta;

    public Carro(String placa, String modelo, String marca, int ano, int lugares, Tipo tipo, boolean caixaAberta,
            double precoBase) {
        super(placa, modelo, marca, ano, lugares, precoBase);
        this.tipo = tipo;
        CaixaAberta = caixaAberta;
    }

    @Override
    public double calcularPrecoTotal() {
        double porcentagemImposto = 0.20;
        return precoBase * (1 + porcentagemImposto);
    }

    public Tipo getTipo() {
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
                ", Preço Total=" + calcularPrecoTotal() +
                ", Lugares=" + lugares +
                ", Tipo=" + tipo +
                '}';
    }
}
