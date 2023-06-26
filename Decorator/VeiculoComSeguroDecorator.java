package Decorator;

import Veiculo.Carro;
import Veiculo.Moto;
import Veiculo.Veiculo;

public class VeiculoComSeguroDecorator extends VeiculoDecorator {

    public VeiculoComSeguroDecorator(Veiculo veiculo) {
        super(veiculo);
    }

    @Override
    public double calcularPrecoTotal() {
        double preco = super.calcularPrecoTotal();
        double valorSeguro = retornarValorSeguro();
        return preco + valorSeguro; 
    }

    private double retornarValorSeguro() {
        double valorSeguro = 0;
        double preco = super.calcularPrecoTotal();

        if(veiculo instanceof Carro) {
            valorSeguro = preco * 0.10;
        }
        else if(veiculo instanceof Moto) {
            valorSeguro = preco * 0.05;
        }

        return valorSeguro;
    }
}
