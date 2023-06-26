package Concessionaria;

import Veiculo.Carro;
import Veiculo.Moto;

import java.util.ArrayList;

public class Garagem {

    ArrayList<Carro> listaCarros;
    ArrayList<Moto> listaMotos;

    public Garagem(){
        this.listaCarros = new ArrayList<>();
        this.listaMotos = new ArrayList<>();
    }

    public Garagem(ArrayList<Carro> listaCarros, ArrayList<Moto> listaMotos) {
        this.listaCarros = listaCarros;
        this.listaMotos = listaMotos;
    }

    public Carro buscaCarro(String placa){
        for (Carro c : listaCarros){
            if (c.getPlaca().equals(placa)){
                return c;
            }
        }
        return null;
    }
    public Moto buscaMoto(String placa){
        for (Moto m : listaMotos){
            if (m.getPlaca().equals(placa)){
                return m;
            }
        }
        return null;
    }
    public void retiraCarro(String placa){
        listaCarros.remove(buscaCarro(placa));
    }
    public void recebeCarro(Carro c){
        listaCarros.add(c);
    }

    public void retiraMoto(String placa){
        listaMotos.remove(buscaMoto(placa));
    }

    public void recebeMoto(Moto m){
        listaMotos.add(m);
    }

    public void printaCarros() {
        if (!listaCarros.isEmpty()){
            System.out.println("--- CARROS ---");
            for (Carro c : listaCarros) {
                System.out.println(c.toString());
            }
            System.out.println("--- FIM DE CARROS ---");
        }else{
            System.err.println("Nao ha carros disponiveis !");
        }
    }
    public void printaMotos(){
        if (!listaCarros.isEmpty()){
            System.out.println("--- MOTOS ---");
            for (Moto m : listaMotos){
                System.out.println(m.toString());
            }
            System.out.println("--- FIM DE MOTOS ---");
        }else {
            System.err.println("Nao ha motos disponiveis !");
        }
    }
}
