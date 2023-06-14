package Veiculo;

public class Moto extends Veiculo{

    public enum Tipos {Street, Esportiva, Scooter}
    private boolean CaixaInterna;
    private Tipos tipo;

    public Moto(String placa, String modelo, String marca, int ano, int lugares, boolean caixaInterna, Tipos tipo) {
        super(placa, modelo, marca, ano, lugares);
        CaixaInterna = caixaInterna;
        this.tipo = tipo;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public boolean isCaixaInterna() {
        return CaixaInterna;
    }
}
