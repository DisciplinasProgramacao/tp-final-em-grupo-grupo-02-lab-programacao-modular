package ProgramaFidelidade;

public class Preto implements IFidelidade{
    private final static double PORCENTAGEM_DESCONTO=0.9;

    @Override
    public double getDesconto() {
        return PORCENTAGEM_DESCONTO;
    }
}
