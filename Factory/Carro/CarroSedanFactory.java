package Factory.Carro;

import Veiculo.Carro;

public class CarroSedanFactory implements CarroFactory{
    @Override
    public Carro montaCarro(String placa, String modelo, String marca, int ano) {
        return new Carro(placa, modelo, marca, ano, 5, Carro.Tipos.Sedan, false);
    }
}
