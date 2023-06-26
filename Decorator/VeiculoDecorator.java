package Decorator;

import Veiculo.Veiculo;

public class VeiculoDecorator extends Veiculo {

    protected Veiculo veiculo;

    public VeiculoDecorator(Veiculo veiculo){
        super(veiculo);
        this.veiculo = veiculo;
    }

    @Override
    public double calcularPrecoTotal() {
        return veiculo.calcularPrecoTotal();
    }

}
