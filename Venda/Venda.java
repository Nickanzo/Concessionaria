package Venda;

import State.EsperandoPagamentoState;
import State.VendaState;
import Veiculo.Veiculo;

import java.util.Date;

public class Venda {
    private static int numVenda = 0;
    private Date data;
    private Cliente cliente;
    private Veiculo veiculo;
    private VendaState estado;
    public Venda(Cliente cliente, Veiculo veiculo) {
        ++numVenda;
        this.data = new Date();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.estado = new EsperandoPagamentoState(this);
        System.out.println("Aguardando Pagamento...");
    }
    public VendaState getEstado() {
        return estado;
    }
    public void setEstado(VendaState estado) {
        this.estado = estado;
    }
    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        valorTotal += veiculo.calcularPrecoTotal();
        return valorTotal;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(data).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Veiculo:\n");
        sb.append(veiculo.getModelo()).append(" - ").append(veiculo.getPlaca()).append("\n");
        sb.append("Valor Total: ").append(calcularValorTotal()).append("\n");
        return sb.toString();
    }
}
