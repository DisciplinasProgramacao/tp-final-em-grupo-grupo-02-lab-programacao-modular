package Produto;

import java.util.LinkedList;

public abstract class ProdutoAdicionavel extends Produto {

    LinkedList<Adicionais> adicionais;

    ProdutoAdicionavel(double preco) {
        super(preco);
        adicionais = new LinkedList<>();
    }

    public abstract double getPrecoExtra();

    public void addAdcional(Adicionais a) {
        this.adicionais.add(a);
    }

}
