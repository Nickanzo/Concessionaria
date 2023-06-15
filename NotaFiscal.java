import Veiculo.Carro;
import Veiculo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;

public class NotaFiscal {
    private int numero;
    private LocalDate data;
    private Cliente cliente;
    private ArrayList<Veiculo> veiculos;
    private double valorTotal;

    public NotaFiscal(int numero, LocalDate data, Cliente cliente, ArrayList<Veiculo> veiculos, double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.veiculos = veiculos;
        this.valorTotal = valorTotal;
    }

    public int getNumero() {
        return numero;
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

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Número: ").append(numero).append("\n");
        sb.append("Data: ").append(data).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Carros:\n");
        for (Veiculo v : veiculos) {
            sb.append(v.getModelo()).append(" - ").append(v.getPlaca()).append("\n");
        }
        sb.append("Valor Total: ").append(valorTotal).append("\n");

        return sb.toString();
    }
}
