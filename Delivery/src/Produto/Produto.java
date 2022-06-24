package Produto;

public abstract class Produto {

    protected double preco;
    
    Produto(double preco){
        this.preco=preco;
    }

    public double precoBase() {
        return this.preco;
    }
    public abstract double getPrecoTotal();
}
// public enum Produto {
// PIZZA(25, Ingredientes.values(), Extra.BORDA_RECHEADA),
// SANDUICHE(12, Ingredientes.values(), Extra.PAO_ARTESANAL),
// PRATO_FEITO(15, null, null),
// AGUA(2, null, null),
// SUCO(5, null, null),
// REFRI(5, null, null),
// CERVEJA(8, null, null);

// public double preco;
// public Ingredientes[] ingredienteAdicional;
// public Extra extra;

// Produto(double preco, Ingredientes[] adicional, Extra extra) {
// this.preco = preco;
// this.ingredienteAdicional = adicional;
// this.extra = extra;

// }

// }
