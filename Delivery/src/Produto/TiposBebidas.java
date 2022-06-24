package Produto;

public enum TiposBebidas {
    AGUA(2),
    SUCO(5),
    REFRIGERANTE(5),
    CERVEJA(8);

    public double preco;

    TiposBebidas(double preco) {
        this.preco = preco;
    }
}
