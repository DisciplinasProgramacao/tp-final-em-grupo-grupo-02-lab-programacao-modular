import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import ProgramaFidelidade.Branco;
import ProgramaFidelidade.FeV;
import ProgramaFidelidade.IFidelidade;
import ProgramaFidelidade.Prata;
import ProgramaFidelidade.Preto;

public class Cliente {
    private static int count = 1;

    private int id;
    private String nome;
    private String cpf;
    private IFidelidade fidelidade;

    Cliente(String nome, String cpf) throws Exception {
        this.setId();
        this.setNome(nome);
        this.setCpf(cpf);
        this.fidelidade = new Branco();
    }

    public int getId() {
        return this.id;
    }

    private void setId() {
        this.id = count;
        Cliente.count++;
    }

    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    private void setCpf(String cpf) throws Exception {
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            throw new Exception("cpf invalido");
        }
    }

    public String getFidelidade() {
        return this.fidelidade.toString();
    }

    private LinkedList<Pedido> getHistoricoCliente(LinkedList<Pedido> pedidos) {
        LinkedList<Pedido> pedidosDoCliente = new LinkedList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente() == this) {
                pedidosDoCliente.add(pedido);
            }
        }
        return pedidosDoCliente;
    }

    private double totalDosUltimosPedidosEmUmPeriodo(LinkedList<Pedido> list, int meses) {
        Date d = new Date();
        d.setTime(d.getTime() - TimeUnit.DAYS.toMillis(meses * 30));

        double total = 0;
        for (Pedido pedido : list) {
            if (pedido.getData().after(d)) {
                total += pedido.getTotalPedido();
            }
        }
        return total;
    }

    public void setFidelidade(LinkedList<Pedido> pedidos) {
        LinkedList<Pedido> pedidosDoCliente = getHistoricoCliente(pedidos);
        if (pedidos.size() >= 50 || this.totalDosUltimosPedidosEmUmPeriodo(pedidosDoCliente, 6) >= 600) {
            this.fidelidade = new FeV();
        } else if (pedidos.size() >= 10 || this.totalDosUltimosPedidosEmUmPeriodo(pedidosDoCliente, 2) >= 250) {
            this.fidelidade = new Preto();
        } else if (pedidos.size() >= 4 || this.totalDosUltimosPedidosEmUmPeriodo(pedidosDoCliente, 1) >= 100) {
            this.fidelidade = new Prata();
        } else {
            this.fidelidade = new Branco();
        }

    }

    public double getDesconto() {
        return this.fidelidade.getDesconto();
    }

}
