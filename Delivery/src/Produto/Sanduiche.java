package Produto;

public class Sanduiche extends ProdutoAdicionavel {

    private static final double PRECO_BASE = 12;
    private boolean pao_artesanal;

    public Sanduiche() {
        super(PRECO_BASE);
        this.pao_artesanal = false;
    }

    public void addPaoArtesanal() {
        this.pao_artesanal = true;
    }

    @Override
    public double getPrecoTotal() {
        double total = PRECO_BASE;
        for (Adicionais a : this.adicionais) {
            total += a.preco;
        }
        if (this.pao_artesanal) {
            total += 2;
        }
        return total;
    }

    @Override
    public double getPrecoExtra() {
        double total = 0;
        for (Adicionais a : this.adicionais) {
            total += a.preco;
        }
        if (this.pao_artesanal) {
            total += 2;
        }
        return total;
    }

    public String toString() {
        return "SANDUICHE " + "Adicionais: R$" + String.format("%2.2f", getPrecoExtra()) + " Total: R$"
                + String.format("%2.2f", getPrecoTotal()) + "\n";
    }

}
