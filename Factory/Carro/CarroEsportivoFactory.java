package Factory.Carro;

import Veiculo.Carro;

public class CarroEsportivoFactory implements CarroFactory{
    @Override
    public Carro montaCarro(String placa, String modelo, String marca, int ano, double preco) {
        return new Carro(placa, modelo, marca, ano, 2, Carro.Tipos.Esportivo,false, preco);
    }
}
