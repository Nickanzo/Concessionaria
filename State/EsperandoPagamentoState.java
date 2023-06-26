package State;

import Venda.Venda;

public class EsperandoPagamentoState extends VendaState{
    public EsperandoPagamentoState(Venda venda) {
        super(venda);
    }
    @Override
    public void processaPagamento() {
        System.out.println("Processando Pagamento...");
        venda.setEstado(new ProcessandoPagamentoState(venda));
    }

    @Override
    public void cancelaVenda() {
        System.out.println("Cancelando Venda...");
        venda.setEstado(new VendaCanceladaState(venda));
    }

    @Override
    public void finalizaVenda() {
        System.err.println("Espere o pagamento ser processado...");
    }
}
