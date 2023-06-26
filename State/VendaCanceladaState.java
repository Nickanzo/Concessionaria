package State;

import Venda.Venda;

public class VendaCanceladaState extends VendaState{
    public VendaCanceladaState(Venda venda) {
        super(venda);
    }

    @Override
    public void processaPagamento() {
        System.err.println("Vendas canceladas nao podem ser reprocessadas !");
    }

    @Override
    public void cancelaVenda() {
        System.err.println("A venda ja esta cancelada !");
    }

    @Override
    public void finalizaVenda() {
        System.err.println("Vendas canceladas nao podem ser finalizadas !");
    }
}
