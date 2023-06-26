package Veiculo;

public class Moto extends Veiculo {

    public enum Tipo {
        Street, Esportiva, Scooter
    }

    private boolean CaixaInterna;
    private Tipo tipo;

    public Moto(String placa, String modelo, String marca, int ano, int lugares, boolean caixaInterna, Tipo tipo,
            double precoBase) {
        super(placa, modelo, marca, ano, lugares, precoBase);
        CaixaInterna = caixaInterna;
        this.tipo = tipo;
    }

    @Override
    public double calcularPrecoTotal() {
        double porcentagemImposto = 0.10;
        return precoBase * (1 + porcentagemImposto);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public boolean isCaixaInterna() {
        return CaixaInterna;
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
