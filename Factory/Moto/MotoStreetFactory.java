package Factory.Moto;

import Veiculo.Moto;

public class MotoStreetFactory implements MotoFactory{
    @Override
    public Moto montaMoto(String placa, String modelo, String marca, int ano, double preco) {
        return new Moto(placa, modelo, marca, ano, 2, false, Moto.Tipos.Street, preco);
    }
}
