import Veiculo.Veiculo;

public class SeguroDecorator extends Veiculo{

    protected Veiculo veiculo;
    protected double valorSeguro;

    public SeguroDecorator(Veiculo veiculo){
        this.veiculo = veiculo;

    }

    public double calculaSeguro(){


        return 0.0;
    }

}
