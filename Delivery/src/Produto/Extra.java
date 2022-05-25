package Produto;

public class Extra implements IAdiconal {
    private String nome;
    private double preco;

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return String.format("R$%.2f  %s", this.getPreco(), this.getNome());
    }

}
