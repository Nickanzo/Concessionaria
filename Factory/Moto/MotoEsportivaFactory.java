package Factory.Moto;

import Veiculo.Moto;

public class MotoEsportivaFactory implements MotoFactory{
    @Override
    public Moto montaMoto(String placa, String modelo, String marca, int ano, double preco) {
        return new Moto(placa, modelo, marca, ano, 1, false, Moto.Tipos.Esportiva, preco);
    }
}
