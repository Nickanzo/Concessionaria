package Factory.Carro;

import Veiculo.Carro;

public interface ICarroFactory {
    public Carro montaCarro(String placa,
                            String modelo,
                            String marca,
                            int ano,
                            double precoBase);
}
