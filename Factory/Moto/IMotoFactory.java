package Factory.Moto;

import Veiculo.Moto;

public interface IMotoFactory {
    public Moto montaMoto(String placa,
                          String modelo,
                          String marca,
                          int ano,
                          double precoBase);
}
