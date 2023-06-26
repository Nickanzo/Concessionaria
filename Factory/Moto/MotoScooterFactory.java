package Factory.Moto;

import Veiculo.Moto;

public class MotoScooterFactory implements IMotoFactory{
    @Override
    public Moto montaMoto(String placa, String modelo, String marca, int ano, double precoBase) {
        return new Moto(placa, modelo, marca, ano, 2, true, Moto.Tipo.Scooter, precoBase);
    }
}
