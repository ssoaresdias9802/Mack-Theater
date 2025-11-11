public class EntradaMeia extends Entrada {

    public EntradaMeia(Espetaculo esp, int assento) {
        super(esp, assento);
    }

    @Override
    public double calcularPreco() {
        return getPrecoInteira() * 0.5;
    }

    @Override
    public String getTipo() {
        return "Meia";
    }
}
