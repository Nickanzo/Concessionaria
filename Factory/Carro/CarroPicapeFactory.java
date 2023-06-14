package Factory.Carro;

import Veiculo.Carro;

public class CarroPicapeFactory implements CarroFactory{
    @Override
    public Carro montaCarro(String placa, String modelo, String marca, int ano) {
        return new Carro(placa, modelo, marca, ano, 2, Carro.Tipos.Picape, true);
    }
}
