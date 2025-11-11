public abstract class Entrada extends Espetaculo {
    protected int assento;

    public Entrada(Espetaculo esp, int assento) {
        super(esp.getNome(), esp.getData(), esp.getHora(), esp.getPrecoInteira());
        this.assento = assento;
    }

    public int getAssento() { return assento; }

    public abstract double calcularPreco(); // método abstrato
    public abstract String getTipo();
}
