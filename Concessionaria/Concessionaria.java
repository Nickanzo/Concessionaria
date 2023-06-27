package Concessionaria;

import Decorator.VeiculoComSeguroDecorator;
import Factory.Carro.*;
import Factory.Moto.*;
import State.ProcessandoPagamentoState;
import State.VendaCanceladaState;
import State.VendaFinalizadaState;
import Veiculo.Veiculo;
import Venda.Cliente;
import Venda.Venda;

import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static Garagem garagem = new Garagem();
    static Scanner s;

    public static void main(String[] args) {

        System.out.println("Bem-vindo à Concessionaria !");

        s = new Scanner(System.in);

        carregaClientes();
        carregaGaragem();

        menuPrincipal();


//        Carro c1 = garagem.buscaCarro("PQR1234");
//        Moto m1 = garagem.buscaMoto("TUV1234");
//
//        VeiculoComSeguroDecorator v1 = new VeiculoComSeguroDecorator(c1);
//        VeiculoComSeguroDecorator v2 = new VeiculoComSeguroDecorator(m1);
//
//        System.out.println("Preco carro: " + c1.calcularPrecoTotal());
//        System.out.println("Preco Seguro: " + v1.calcularPrecoTotal());
//        System.out.println("Preco Seguro: " + v1.getPrecoBase());
//
//        System.out.println("Preco carro: " + m1.calcularPrecoTotal());
//        System.out.println("Preco Seguro: " + v2.calcularPrecoTotal());
//        System.out.println("Preco Seguro: " + v2.getPrecoBase());

    }

    private static void menuPrincipal() {
        System.out.println("""
                ----------------------
                O que deseja fazer?
                ----------------------
                1 - Comprar
                2 - Ver Veiculos Disponiveis
                3 - Sair
                """);
        String answer = s.nextLine();
        if (answer.equals("1")){
            menuCliente();
        } else if (answer.equals("2")) {
            menuGaragem();
        } else if (answer.equals("3")) {
            System.out.println("Obrigado, volte sempre !");
        }else {
            System.err.println("Escolha uma das opcoes do menu !");
            menuPrincipal();
        }
    }

    private static void menuGaragem() {
        System.out.println("""
                ----------------------
                Quais veiculos deseja visualizar?
                ----------------------
                1 - Carros
                2 - Motos
                3 - Todos
                4 - Voltar
                """);
        String answer = s.nextLine();
        if (answer.equals("1")){
            if (garagem!=null){
                garagem.printaCarros();
            }else {
                System.err.println("Garagem indisponivel para consulta !");
            }
        } else if (answer.equals("2")) {
            if (garagem!=null){
                garagem.printaMotos();
            }else {
                System.err.println("Garagem indisponivel para consulta !");
            }
        } else if (answer.equals("3")) {
            if (garagem!=null){
                garagem.printaCarros();
                garagem.printaMotos();
            }else {
                System.err.println("Garagem indisponivel para consulta !");
            }
        }else if(answer.equals("4")){

        }else {
            System.err.println("Escolha uma das opcoes do menu !");
            menuGaragem();
        }
        menuPrincipal();
    }

    private static void menuCliente() {
        System.out.println("""
                ----------------------
                Cliente ja possui cadastro?
                ----------------------
                1 - Sim
                2 - Nao
                """);
        String answer = s.nextLine();
        if (answer.equals("1")){
            System.out.println("Digite o nome completo do Cliente");
            answer = s.nextLine();
            if (answer.contains("ã")){
                System.err.println("Favor nao usar caracteres especiais !");
                menuCliente();
            }else{
                Cliente c = buscaCliente(answer);
                if (c!=null){
                    menuCompra(c);
                }
            }
        }else if (answer.equals("2")){
            menuCadastro();
        }else {
            System.err.println("Escolha uma das opcoes do menu !");
        }
    }

    private static void menuCadastro() {

        String  nome,
                endereco,
                telefone,
                email;

        System.out.println("Digite o nome completo do cliente");
        nome = s.nextLine();

        System.out.println("Digite o endereco do cliente");
        endereco = s.nextLine();

        System.out.println("Digite o telefone do cliente");
        telefone = s.nextLine();

        System.out.println("Digite o email do cliente");
        email = s.nextLine();

        cadastraCliente(nome, endereco, telefone, email);
        System.out.println("Cliente cadastrado com sucesso !");
        menuCompra(new Cliente(nome, endereco, telefone, email));
    }

    private static void menuCompra(Cliente c) {
        System.out.println("""
                        ----------------------
                        Qual veiculo gostaria de comprar?
                        ----------------------
                        1 - Carro
                        2 - Moto
                        3 - Voltar para Menu Principal
                        """);
        String answer = s.nextLine();
        if (answer.equals("1")){
            garagem.printaCarros();
            System.out.println("Digite a placa do carro que deseja comprar");
            answer = s.nextLine();
            Veiculo v = garagem.buscaCarro(answer);
            if (v!=null){
                garagem.retiraCarro(v.getPlaca());
                menuVenda(c,v,"Carro");
            }else {
                System.err.println("Placa nao encontrada !");
                menuCompra(c);
            }
        }else if (answer.equals("2")){
            garagem.printaMotos();
            System.out.println("Digite a placa da moto que deseja comprar");
            answer = s.nextLine();
            Veiculo v = garagem.buscaMoto(answer);
            if (v!=null){
                garagem.retiraMoto(v.getPlaca());
                menuVenda(c,v,"Moto");
            }else {
                System.err.println("Placa nao encontrada !");
                menuCompra(c);
            }
        }else if (answer.equals("3")){
            menuPrincipal();
        }else {
            System.out.println("");
        }
    }

    private static void menuVenda(Cliente c, Veiculo v, String tipo) {
        System.out.println("""
                ----------------------
                Deseja que o veiculo seja Segurado?
                ----------------------
                1 - Sim
                2 - Nao
                3 - Voltar para Menu Principal 
                """);
        String answer = s.nextLine();
        if (answer.equals("1")){
            VeiculoComSeguroDecorator vSeguro = new VeiculoComSeguroDecorator(v);
            Venda vendaSeguro = new Venda(c,vSeguro);
            menuPagamento(vendaSeguro,tipo);
        }else if (answer.equals("2")){
            Venda vendaSemSeguro = new Venda(c,v);
            menuPagamento(vendaSemSeguro,tipo);
        }else if (answer.equals("3")){
            menuPrincipal();
        }else {
            System.out.println("Escolha uma das opcoes do menu");
        }
    }

    private static void menuPagamento(Venda venda, String tipo) {
        System.out.printf("""
                Valor total: %s                 
                ----------------------
                Confirma pagamento ?
                ----------------------
                1 - Ok
                2 - Cancelar 
                """, venda.calcularValorTotal());
        String answer = s.nextLine();
        if (answer.equals("1")){
            if (tipo.equalsIgnoreCase("Carro")){
                garagem.retiraCarro(venda.getVeiculo().getPlaca());
            } else if (tipo.equalsIgnoreCase("Moto")) {
                garagem.retiraMoto(venda.getVeiculo().getPlaca());
            }
            venda.processaPagamento();
            imprimeVenda(venda, tipo);
        }else if (answer.equals("2")){
            venda.cancelaVenda();
            System.err.println("Venda cancelada !");
        }else {
            System.out.println("Escolha uma das opcoes do menu");
            menuPagamento(venda, tipo);
        }
        menuPrincipal();
    }

    private static void imprimeVenda(Venda venda, String tipo) {
        System.out.printf("""
                Venda de %s
                %s                
                """,tipo,venda.toString());
        venda.finalizaVenda();
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
    }

    public static void carregaClientes(){
        Cliente cliente1 = new Cliente("Joao Silva", "Rua das Flores, 123", "(11) 1234-5678", "joao.silva@example.com");
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
        System.out.println("Cliente cadastrado !");
    }
    public static Cliente buscaCliente(String nome){
        for ( Cliente c : listaClientes){
            if (c.getNome().equalsIgnoreCase(nome)){
                return c;
            }
        }
        return null;
    }

}
