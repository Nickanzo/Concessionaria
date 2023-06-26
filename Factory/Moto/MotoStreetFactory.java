package Factory.Moto;

import Veiculo.Moto;

public class MotoStreetFactory implements IMotoFactory{
    @Override
    public Moto montaMoto(String placa, String modelo, String marca, int ano, double precoBase) {
        return new Moto(placa, modelo, marca, ano, 2, false, Moto.Tipo.Street, precoBase);
    }
}
