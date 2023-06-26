package State;

import Venda.Venda;

public class ProcessandoPagamentoState extends VendaState{

    public ProcessandoPagamentoState(Venda venda) {
        super(venda);
    }

    @Override
    public void processaPagamento() {
        System.err.println("Pagamento ja esta em processamento !");
    }

    @Override
    public void cancelaVenda() {
        System.out.println("Cancelando Venda");
        venda.setEstado(new VendaCanceladaState(venda));
    }

    @Override
    public void finalizaVenda() {
        System.out.println("Venda finalizada !");
        venda.setEstado(new VendaFinalizadaState(venda));
    }
}
