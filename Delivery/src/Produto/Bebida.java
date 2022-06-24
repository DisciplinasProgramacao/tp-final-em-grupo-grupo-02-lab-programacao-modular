package Produto;

public class Bebida extends Produto {
    TiposBebidas tipo;

    public Bebida(TiposBebidas b) {
        super(b.preco);
        this.tipo = b;
    }

    @Override
    public String toString() {
        return tipo.name() + " R$" + String.format("%2.2f", tipo.preco) + "\n";
    }

    @Override
    public double getPrecoTotal() {
        return this.preco;
    }
}
