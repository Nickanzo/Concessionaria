package Concessionaria;

import Decorator.VeiculoComSeguroDecorator;
import Factory.Carro.*;
import Factory.Moto.*;
import Veiculo.Carro;
import Veiculo.Moto;
import Venda.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static Garagem garagem = new Garagem();
    public static void main(String[] args) {

        System.out.println("Bem-vindo à Concessionaria.Concessionaria");

        Scanner s = new Scanner(System.in);

        System.out.println("O que deseja fazer?");
        System.out.println("----------------------");
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Comprar Moto");
        //System.out.println("2 - Comprar Veiculos");
        System.out.println("3 - Encomendar Pecas");
        System.out.println("4 - Ver Carros Disponíveis");
        System.out.println("5 - Ver Motos Disponíveis");
        System.out.println("6 - Sair");

        carregaClientes();
        carregaGaragem();

        Carro c1 = garagem.buscaCarro("PQR1234");
        Moto m1 = garagem.buscaMoto("TUV1234");

        VeiculoComSeguroDecorator v1 = new VeiculoComSeguroDecorator(c1);
        VeiculoComSeguroDecorator v2 = new VeiculoComSeguroDecorator(m1);

        System.out.println("Preco carro: " + c1.calcularPrecoTotal());
        System.out.println("Preco Seguro: " + v1.calcularPrecoTotal());
        System.out.println("Preco Seguro: " + v1.getPrecoBase());

        System.out.println("Preco carro: " + m1.calcularPrecoTotal());
        System.out.println("Preco Seguro: " + v2.calcularPrecoTotal());
        System.out.println("Preco Seguro: " + v2.getPrecoBase());


        switch (s.nextLine()) {
            case "1":
                System.out.println("Venda.Cliente possui cadastro? S/N");
                if (s.nextLine().equals("S")){
                    System.out.println("Digite o email do Venda.Cliente");
                    Cliente c = buscaCliente(s.nextLine());
                    if (c != null){


                    }
                }else{
                    System.out.println("Nome do Venda.Cliente:");
                    String nome = s.nextLine();
                    System.out.println("Endereco do Venda.Cliente");
                    String endereco = s.nextLine();
                    System.out.println("Telefone do Venda.Cliente");
                    String telefone = s.nextLine();
                    System.out.println("Email do Venda.Cliente");
                    String email = s.nextLine();
                    cadastraCliente(nome, endereco, telefone, email);
                }
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                if (garagem != null){
                    garagem.printaCarros();
                }
                break;
            case "5":
                if (garagem != null){
                    garagem.printaMotos();
                }
                break;
            case "6":
                System.out.println("Volte sempre !");
                break;
            default:
                System.err.println("Escolha um numero do menu !");
        }

//        Concessionaria.Garagem g = new Concessionaria.Garagem();

        s.next();

    }

    private static void carregaGaragem() {
        carregaCarros();
        carregaMotos();
    }

    private static void carregaMotos() {

        MotoStreetFactory mStreetFactory = new MotoStreetFactory();
        MotoScooterFactory mScooterFactory = new MotoScooterFactory();
        MotoEsportivaFactory mEsportivaFactory = new MotoEsportivaFactory();

        garagem.recebeMoto(mStreetFactory.montaMoto("BCD7890", "Ninja 300", "Kawasaki", 2020, 12000.0));
        garagem.recebeMoto(mScooterFactory.montaMoto("EFG1234", "CB 650R", "Honda", 2019, 18000.0));
        garagem.recebeMoto(mEsportivaFactory.montaMoto("HIJ5678", "YZF-R1", "Yamaha", 2018, 22000.0));
        garagem.recebeMoto(mStreetFactory.montaMoto("KLM9012", "MT-09", "Yamaha", 2017, 15000.0));
        garagem.recebeMoto(mScooterFactory.montaMoto("NOP3456", "GSX-R750", "Suzuki", 2016, 14000.0));
        garagem.recebeMoto(mEsportivaFactory.montaMoto("QRS7890", "Monster 821", "Ducati", 2015, 16000.0));
        garagem.recebeMoto(mStreetFactory.montaMoto("TUV1234", "Street Triple", "Triumph", 2021, 17000.0));
        garagem.recebeMoto(mScooterFactory.montaMoto("WXY5678", "CB 500X", "Honda", 2014, 10000.0));
        garagem.recebeMoto(mEsportivaFactory.montaMoto("ZAB9012", "V-Strom 650", "Suzuki", 2013, 8000.0));
        //System.out.println("Motos carregadas !");

    }

    private static void carregaCarros() {

        CarroSedanFactory cSedanFactory = new CarroSedanFactory();
        CarroPicapeFactory cPicapeFactory = new CarroPicapeFactory();
        CarroEsportivoFactory cEsportivoFactory = new CarroEsportivoFactory();

        garagem.recebeCarro(cSedanFactory.montaCarro("ABC1234", "Gol", "Volkswagen", 2018, 35000.0));
        garagem.recebeCarro(cPicapeFactory.montaCarro("DEF5678", "Onix", "Chevrolet", 2020, 45000.0));
        garagem.recebeCarro(cEsportivoFactory.montaCarro("GHI9012", "Corolla", "Toyota", 2019, 60000.0));
        garagem.recebeCarro(cSedanFactory.montaCarro("JKL3456", "Civic", "Honda", 2021, 70000.0));
        garagem.recebeCarro(cPicapeFactory.montaCarro("MNO7890", "HB20", "Hyundai", 2017, 30000.0));
        garagem.recebeCarro(cEsportivoFactory.montaCarro("PQR1234", "Ka", "Ford", 2016, 25000.0));
        garagem.recebeCarro(cSedanFactory.montaCarro("STU5678", "Uno", "Fiat", 2015, 20000.0));
        garagem.recebeCarro(cPicapeFactory.montaCarro("VWX9012", "C3", "Citroën", 2014, 18000.0));
        garagem.recebeCarro(cEsportivoFactory.montaCarro("YZA3456", "Up", "Volkswagen", 2018, 32000.0));
        //System.out.println("Carros carregados !");


        //garagem.recebeCarro(cEsportivoFactory.montaCarro("BCD7890", "Sandero", "Renault", 2019, 28000.0));
    }

    public static void carregaClientes(){
        Cliente cliente1 = new Cliente("João Silva", "Rua das Flores, 123", "(11) 1234-5678", "joao.silva@example.com");
        listaClientes.add(cliente1);
        Cliente cliente2 = new Cliente("Maria Santos", "Avenida Principal, 456", "(22) 9876-5432", "maria.santos@example.com");
        listaClientes.add(cliente2);
        Cliente cliente3 = new Cliente("Pedro Oliveira", "Travessa das Árvores, 789", "(33) 5555-1234", "pedro.oliveira@example.com");
        listaClientes.add(cliente3);
        Cliente cliente4 = new Cliente("Ana Rodrigues", "Rua dos Sonhos, 987", "(44) 1111-2222", "ana.rodrigues@example.com");
        listaClientes.add(cliente4);
        Cliente cliente5 = new Cliente("Carlos Almeida", "Avenida Central, 654", "(55) 3333-4444", "carlos.almeida@example.com");
        listaClientes.add(cliente5);
        Cliente cliente6 = new Cliente("Laura Mendes", "Praça da Liberdade, 321", "(66) 7777-8888", "laura.mendes@example.com");
        listaClientes.add(cliente6);
        Cliente cliente7 = new Cliente("Rafaela Lima", "Rua das Palmeiras, 555", "(77) 9999-0000", "rafaela.lima@example.com");
        listaClientes.add(cliente7);
        Cliente cliente8 = new Cliente("Fernando Costa", "Avenida dos Girassóis, 789", "(88) 2222-3333", "fernando.costa@example.com");
        listaClientes.add(cliente8);
        Cliente cliente9 = new Cliente("Mariana Ferreira", "Alameda das Águias, 456", "(99) 4444-5555", "mariana.ferreira@example.com");
        listaClientes.add(cliente9);
        Cliente cliente10 = new Cliente("Gustavo Pereira", "Travessa dos Ipês, 321", "(11) 6666-7777", "gustavo.pereira@example.com");
        listaClientes.add(cliente10);
        Cliente cliente11 = new Cliente("Isabela Gomes", "Rua das Rosas, 654", "(22) 8888-9999", "isabela.gomes@example.com");
        listaClientes.add(cliente11);
        Cliente cliente12 = new Cliente("Rodrigo Santos", "Avenida das Oliveiras, 987", "(33) 1111-2222", "rodrigo.santos@example.com");
        listaClientes.add(cliente12);
        Cliente cliente13 = new Cliente("Camila Souza", "Praça dos Girassóis, 456", "(44) 3333-4444", "camila.souza@example.com");
        listaClientes.add(cliente13);
        Cliente cliente14 = new Cliente("Luiz Oliveira", "Rua das Acácias, 321", "(55) 5555-6666", "luiz.oliveira@example.com");
        listaClientes.add(cliente14);
    }

    public static void cadastraCliente(String nome, String endereco, String telefone, String email){
        listaClientes.add(new Cliente(nome, endereco, telefone, email));
        System.out.println("Venda.Cliente cadastrado !");
    }

    public static Cliente buscaCliente(String email){
        //Realizada busca pelo email para facilitar
        for ( Cliente c : listaClientes){
            if (c.getEmail().equals(email)){
                return c;
            }
        }
        return null;
    }

}
