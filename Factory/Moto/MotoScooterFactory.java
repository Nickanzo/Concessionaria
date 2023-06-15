package Factory.Moto;

import Veiculo.Moto;

public class MotoScooterFactory implements MotoFactory{
    @Override
    public Moto montaMoto(String placa, String modelo, String marca, int ano, double preco) {
        return new Moto(placa, modelo, marca, ano, 2, true, Moto.Tipos.Scooter, preco);
    }
}
