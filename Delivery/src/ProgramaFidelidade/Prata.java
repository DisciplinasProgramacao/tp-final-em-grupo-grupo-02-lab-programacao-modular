package ProgramaFidelidade;

public class Prata implements IFidelidade{
    private final static double PORCENTAGEM_DESCONTO=0.95;

    @Override
    public double getDesconto() {
        return PORCENTAGEM_DESCONTO;
    }

    @Override
    public String toString(){
        return "Prata";
    }
}
