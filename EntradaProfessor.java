public class EntradaProfessor extends Entrada {

    public EntradaProfessor(Espetaculo esp, int assento) {
        super(esp, assento);
    }

    @Override
    public double calcularPreco() {
        return getPrecoInteira() * 0.6;
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}
