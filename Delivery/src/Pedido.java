import java.util.Date;
import java.util.LinkedList;

import Produto.Produtos;

public class Pedido {
    private static int count = 1;

    private int id;
    private Date data;
    private Cliente cliente;
    private LinkedList<Produtos> itensPedido;

    Pedido(Cliente cliente, LinkedList<Produtos> itensPedido) {
        this.setId();
        this.cliente = cliente;
        this.data = new Date();
        if (itensPedido.size() >= 1 && itensPedido.size() <= 10) {
            this.itensPedido = itensPedido;
        }
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

    public LinkedList<Produtos> getItensPedido() {
        return this.itensPedido;
    }

    public double getTotalPedido(){
        double total=0;
        for (Produtos produtos : itensPedido) {
            total+=produtos.getPrecoTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ID: " + this.id + "  Nome Cliente: " + this.cliente.getNome() + "  Data: " + this.data.toString());
        for (Produtos produtos : itensPedido) {
            s.append("\n" + produtos);
        }

        s.append(String.format("Valor Total: R$%.2f", this.getTotalPedido()));

        return s.toString();
    }

}
