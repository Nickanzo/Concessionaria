package State;

import Venda.Venda;
public abstract class VendaState {
    protected Venda venda;
    public VendaState(Venda venda) {
        this.venda = venda;
    }
    abstract void processaPagamento();
    abstract void cancelaVenda();
    abstract void finalizaVenda();
}
