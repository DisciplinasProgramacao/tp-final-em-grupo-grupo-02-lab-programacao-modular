import java.util.Date;
import java.util.LinkedList;

import Produto.Produto;

public class Pedido {
    private static int count = 1;

    private int id;
    private Date data;
    private Cliente cliente;
    private LinkedList<Produto> itensPedido = new LinkedList<>();

    double desconto;

    Pedido(Cliente cliente, LinkedList<Produto> itensPedido, double desconto) {
        this.setId();
        this.cliente = cliente;
        this.data = new Date();
        this.itensPedido.addAll(itensPedido);
        this.desconto = desconto;

    }

    private void setId() {
        this.id = count;
        count++;
    }

    public int getId() {
        return this.id;
    }

    public Date getData() {
        return this.data;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LinkedList<Produto> getItensPedido() {
        return this.itensPedido;
    }

    public double getTotalPedido() {
        double total = 0;
        for (Produto produto : itensPedido) {
            // TODO
            try {
                total += produto.getPrecoTotal();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ID: " + this.id + "  Nome Cliente: " + this.cliente.getNome() + "  Data: " + this.data.toString());
        for (Produto produtos : itensPedido) {
            s.append("\n" + produtos);
        }

        s.append(String.format("Valor Total: R$%.2f - R$.2f (Desconto Fidelidade)", this.getTotalPedido(),
                this.desconto));

        return s.toString();
    }

}
