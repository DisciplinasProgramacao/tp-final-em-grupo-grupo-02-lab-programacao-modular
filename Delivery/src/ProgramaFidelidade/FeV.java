package ProgramaFidelidade;

public class FeV implements IFidelidade{
    private final static double PORCENTAGEM_DESCONTO=0.8;

    @Override
    public double getDesconto() {
        return PORCENTAGEM_DESCONTO;
    }

    @Override
    public String toString(){
        return "F&V";
    }
}
