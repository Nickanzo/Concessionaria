import Veiculo.Veiculo;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private static int numVenda = 0;
    private Date data;
    private Cliente cliente;
    private ArrayList<Veiculo> veiculos;


    public Venda(Cliente cliente, ArrayList<Veiculo> veiculos) {
        ++numVenda;
        this.data = new Date();
        this.cliente = cliente;
        this.veiculos = veiculos;

    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Veiculo veiculo : veiculos) {
            valorTotal += veiculo.getPreco();
        }
        return valorTotal;
    }

    public NotaFiscal gerarNotaFiscal(int numero) {
        double valorTotal = calcularValorTotal();
        return new NotaFiscal(numero, data, cliente, veiculos, valorTotal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(data).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Carros:\n");
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo.getModelo()).append(" - ").append(veiculo.getPlaca()).append("\n");
        }
        sb.append("Valor Total: ").append(calcularValorTotal()).append("\n");

        return sb.toString();
    }
}
