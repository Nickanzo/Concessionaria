package Factory.Carro;

import Veiculo.Carro;

public class CarroEsportivoFactory implements ICarroFactory{
    @Override
    public Carro montaCarro(String placa, String modelo, String marca, int ano, double precoBase) {
        return new Carro(placa, modelo, marca, ano, 2, Carro.Tipo.Esportivo,false, precoBase);
    }
}
