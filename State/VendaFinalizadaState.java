package State;

import Venda.Venda;

public class VendaFinalizadaState extends VendaState{
    public VendaFinalizadaState(Venda venda) {
        super(venda);
    }
    @Override
    public void processaPagamento() {
        System.err.println("Vendas finalizadas nao podem ser reprocessadas !");
    }
    @Override
    public void cancelaVenda() {
        System.err.println("Vendas finalizadas nao podem ser canceladas !");
    }
    @Override
    public void finalizaVenda() {
        System.err.println("A venda ja foi finalizada !");
    }
}
