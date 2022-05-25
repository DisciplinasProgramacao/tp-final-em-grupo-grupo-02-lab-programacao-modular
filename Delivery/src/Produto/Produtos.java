package Produto;

public class Produtos {
    protected int id;
    protected String nome;
    protected double preco;

    public Produtos(String line) {
        String[] s = line.split(";");
        this.id = Integer.parseInt(s[0]);
        this.nome = s[1];
        this.preco = Double.parseDouble(s[2]);
    }

    public Produtos(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public double getPrecoTotal() {
        return this.preco;
    }

    @Override
    public String toString() {
        return String.format("%d - R$%2.2f  %s", this.id, getPrecoTotal(), this.nome);
    }

}
