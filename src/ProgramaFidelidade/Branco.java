package src.ProgramaFidelidade;

public class Branco implements IFidelidade{
    private final static double PORCENTAGEM_DESCONTO=1;
    
    @Override
    public double getDesconto() {
        return PORCENTAGEM_DESCONTO;
    }
}
