package Factory.Carro;

import Veiculo.Carro;

public interface CarroFactory {
    public Carro montaCarro(String placa,
                            String modelo,
                            String marca,
                            int ano,
                            double preco);
}
