package Produto;

public class Pizza extends ProdutoAdicionavel {

    private static final double PRECO_BASE = 25;
    private static final int MULTIPLICADOR_ADICIONAL = 2;
    private boolean borda;

    public Pizza() {
        super(PRECO_BASE);
        this.borda = false;
    }

    public void addBorda() {
        this.borda = true;
    }

    @Override
    public double getPrecoTotal() {
        double total = PRECO_BASE;
        for (Adicionais a : this.adicionais) {
            total += (MULTIPLICADOR_ADICIONAL * a.preco);
        }
        if (this.borda) {
            total += 8;
        }
        return total;
    }

    @Override
    public double getPrecoExtra() {
        double total = 0;
        for (Adicionais a : this.adicionais) {
            total += (MULTIPLICADOR_ADICIONAL * a.preco);
        }
        if (this.borda) {
            total += 8;
        }
        return total;
    }

    @Override
    public String toString() {
        return "PIZZA " + "Adicionais: R$" + String.format("%2.2f", getPrecoExtra()) + " Total: R$"
                + String.format("%2.2f", getPrecoTotal()) + "\n";
    }

}
