package Produto;

public class PratoFeito extends Produto{

    public PratoFeito() {
        super(15);
    }

    @Override
    public double getPrecoTotal() {
        return this.preco;
    }
    
    @Override
    public String toString(){
        return "Prato Feito" + " R$" + String.format("%2.2f", this.preco) + "\n";
    }
}
