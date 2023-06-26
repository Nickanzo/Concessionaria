package Factory.Carro;

import Veiculo.Carro;

public class CarroSedanFactory implements ICarroFactory{
    @Override
    public Carro montaCarro(String placa, String modelo, String marca, int ano, double precoBase) {
        return new Carro(placa, modelo, marca, ano, 5, Carro.Tipo.Sedan, false, precoBase);
    }
}
