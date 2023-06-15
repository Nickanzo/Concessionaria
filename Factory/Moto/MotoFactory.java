package Factory.Moto;

import Veiculo.Moto;

public interface MotoFactory {
    public Moto montaMoto(String placa,
                          String modelo,
                          String marca,
                          int ano,
                          double preco);
}
