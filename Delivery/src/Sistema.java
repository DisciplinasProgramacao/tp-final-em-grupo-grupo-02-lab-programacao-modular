import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Produto.Adicionais;
import Produto.Bebida;
import Produto.Pizza;
import Produto.PratoFeito;
import Produto.Produto;
import Produto.Sanduiche;
import Produto.TiposBebidas;

public class Sistema {
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public static Produto escolherProduto(int i) {
        switch (i) {
            case 1:
                Pizza pizza = new Pizza();
                int a;
                do {
                    mostrarAdicionais();
                    System.out.println("--digite o id do adicional ou 0 para sair");
                    a = teclado.nextInt();
                    teclado.nextLine();
                    if (a >= 1 && a <= 7) {
                        pizza.addAdcional(escolherAdicional(a));
                    } else if (a == 8) {
                        pizza.addBorda();
                    }
                } while (a != 0);
                return pizza;
            case 2:
                Sanduiche sanduiche = new Sanduiche();
                int b;
                do {
                    mostrarAdicionais();
                    System.out.println("--digite o id do adicional ou 0 para sair");
                    b = teclado.nextInt();
                    teclado.nextLine();
                    if (b != 0) {
                        sanduiche.addAdcional(escolherAdicional(b));
                    } else if (b == 9) {
                        sanduiche.addPaoArtesanal();
                    }
                } while (b != 0);
                return sanduiche;
            case 3:
                return new PratoFeito();
            case 4:
                return new Bebida(TiposBebidas.AGUA);
            case 5:
                return new Bebida(TiposBebidas.SUCO);

            case 6:
                return new Bebida(TiposBebidas.REFRIGERANTE);

            case 7:
                return new Bebida(TiposBebidas.CERVEJA);
            default:
                return null;

        }
    }

    public static void mostrarCardapio() {
        System.out.println("Produtos:");
        System.out.println("1- Pizza         R$25.00");
        System.out.println("2- Sanduiche     R$12.00");
        System.out.println("3- Prato Feito   R$15.00");
        System.out.println("4- Água          R$2.00");
        System.out.println("5- Suco          R$5.00");
        System.out.println("6- Refrigerante  R$5.00");
        System.out.println("7- Cerveja       R$8.00");
    }

    public static Adicionais escolherAdicional(int i) {
        Adicionais a = null;
        switch (i) {
            case 1:
                a = Adicionais.PEPERONI;
                break;
            case 2:
                a = Adicionais.BACON;
                break;
            case 3:
                a = Adicionais.PALMITO;
                break;
            case 4:
                a = Adicionais.QUEIJO;
                break;
            case 5:
                a = Adicionais.PICLES;
                break;
            case 6:
                a = Adicionais.OVO;
                break;
            case 7:
                a = Adicionais.BATATA_PALAHA;
                break;
        }
        return a;
    }

    public static void mostrarAdicionais() {

        System.out.println("Adicionais:");
        int i = 1;
        for (Adicionais a : Adicionais.values()) {

            System.out.println(i + "- " + a.name() + "    R$" + String.format("%2.2f", a.preco));
            i++;
        }

        System.out.println((i) + "- Borda Recheada  R$8.00 (Pizza)");
        System.out.println((i + 1) + "- Pao Artesanal   R$2.00 (Sanduiche)");

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitForUserEnter() {
        System.out.println("\n-Pressione Enter para continuar");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public static void menu() {
        System.out.println("1 - Mostrar Cardapio");
        System.out.println("2 - Cadastrar Cliente");
        System.out.println("3 - Consultar Cliente");
        System.out.println("4 - Novo Pedido");
        System.out.println("5 - Listar Todos Pedidos");

        System.out.println("0 - SAIR");

    }

    public static void salvarDados() {

        try {
            FileOutputStream fos = new FileOutputStream("employeeData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void salvarBinario() {
        String arq = "dados.txt";
        ObjectOutputStream saida = null;
        try {
            saida = new ObjectOutputStream(new FileOutputStream(arq));
            saida.writeObject(clientes);
            saida.close();
        } catch (FileNotFoundException fe) {
            System.out.println("Arquivo não encontrado, ou permissão negada. Contacte o suporte");
            waitForUserEnter();
        } catch (IOException ex) {
            System.out.println("Problemas na operação de E/S. Contacte o suporte");
            System.out.println(ex.getMessage());
            waitForUserEnter();
        }
    }

    public static void carregarBinario() {
        String arq = "dados.txt";
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arq));
            clientes = (ArrayList<Cliente>) entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException fe) {
            clientes = new ArrayList<>();
        } catch (ClassNotFoundException ce) {
            System.out.println("Problema na conversão dos dados: classe inválida. Contacte o suporte.");
            waitForUserEnter();
        } catch (IOException ie) {
            System.out.println("Problemas na operação de E/S. Contacte o suporte");
            System.out.println(ie.getMessage());
            waitForUserEnter();
        }
    }

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        carregarBinario();
        int k;
        do {
            clearScreen();
            menu();
            k = teclado.nextInt();
            teclado.nextLine();
            switch (k) {
                case 1:
                    clearScreen();
                    mostrarCardapio();
                    mostrarAdicionais();
                    waitForUserEnter();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Nome: ");
                    String nome = teclado.nextLine();

                    System.out.println("CPF: ");
                    String cpf = teclado.nextLine();

                    try {
                        Cliente c = new Cliente(nome, cpf);
                        clientes.add(c);
                    } catch (Exception e) {
                        System.out.println(e + "\n por favor tente novamente");
                    }
                    waitForUserEnter();
                    break;
                case 3:
                    clearScreen();
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                    waitForUserEnter();
                    break;
                case 4:
                    System.out.println("ID do Cliente:");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    if (clientes.get(id - 1) != null) {
                        LinkedList<Produto> pedido = new LinkedList<>();
                        int idProduto;
                        do {
                            clearScreen();
                            mostrarCardapio();
                            System.out.println("\nDigite o Id de um item do cardapio ou 0 para sair");

                            idProduto = teclado.nextInt();
                            teclado.nextLine();
                            pedido.add(escolherProduto(idProduto));
                        } while (idProduto != 0 && pedido.size() < 10);

                        Cliente c = clientes.get(id - 1);
                        Pedido p = new Pedido(c, pedido, c.getDesconto());
                        c.addPedido(p);
                        System.out.println(p);
                    }

                    waitForUserEnter();
                    break;
                case 5:
                    clearScreen();
                    for (Cliente c : clientes) {
                        for (Pedido p : c.getPedidos()) {
                            System.out.println(p);
                        }
                    }
                    waitForUserEnter();
                    break;
                default:
                    break;
            }
        } while (k != 0);

        // lerProdutos();
        salvarBinario();
        // System.out.println("\n\n\n " + cardapio.isEmpty());
    }

}
