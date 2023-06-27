package State;

import Venda.Venda;
public abstract class VendaState {
    protected Venda venda;
    public VendaState(Venda venda) {
        this.venda = venda;
    }
    public abstract void processaPagamento();
    public abstract void cancelaVenda();
    public abstract void finalizaVenda();
}
