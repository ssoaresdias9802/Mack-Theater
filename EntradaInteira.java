public class EntradaInteira extends Entrada {

    public EntradaInteira(Espetaculo esp, int assento) {
        super(esp, assento);
    }

    @Override
    public double calcularPreco() {
        return getPrecoInteira();
    }

    @Override
    public String getTipo() {
        return "Inteira";
    }
}
