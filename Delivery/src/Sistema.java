import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import Produto.Produtos;

public class Sistema {
    public static LinkedList<Produtos> cardapio = new LinkedList<>();

    public static void lerProdutos() throws FileNotFoundException {
        final String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir + "/Delivery/src/Produto/produtos.txt");
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
            cardapio.add(new Produtos(line));
        }
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // lerProdutos();

        // System.out.println("\n\n\n           " + cardapio.isEmpty());

        Date d = new Date();

        System.out.println(d);
    }
}
