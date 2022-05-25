package Produto;

import java.util.LinkedList;

public class ProdutoComAdicional extends Produtos {
    private LinkedList<IAdiconal> adicionais;

    ProdutoComAdicional(String line) {
        super(line);
        adicionais = new LinkedList<>();
    }

    ProdutoComAdicional(int id, String nome, double preco) {
        super(id, nome, preco);
        adicionais = new LinkedList<>();
    }

    @Override
    public double getPrecoTotal() {
        double total = this.preco;
        for (IAdiconal iAdiconal : this.adicionais) {
            total += iAdiconal.getPreco();
        }
        return total;

    }

    public void adidiconarIngrediente(IAdiconal Ingrediente) {
        this.adicionais.add(Ingrediente);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%d - R$%2.2f  %s", this.id, getPrecoTotal(), this.nome));
        for (IAdiconal iAdiconal : adicionais) {
            s.append("\n   -" + iAdiconal);
        }
        return s.toString();
    }
}
