package Produto;

public enum Adicionais {
    PEPERONI(4),
    BACON(3),
    PALMITO(3),
    QUEIJO(2),
    PICLES(2),
    OVO(2),
    BATATA_PALAHA(2);

    public double preco;
    Adicionais(double preco){
        this.preco=preco;
    }
}
