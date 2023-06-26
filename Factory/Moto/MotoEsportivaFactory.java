package Factory.Moto;

import Veiculo.Moto;

public class MotoEsportivaFactory implements IMotoFactory{
    @Override
    public Moto montaMoto(String placa, String modelo, String marca, int ano, double precoBase) {
        return new Moto(placa, modelo, marca, ano, 1, false, Moto.Tipo.Esportiva, precoBase);
    }
}
