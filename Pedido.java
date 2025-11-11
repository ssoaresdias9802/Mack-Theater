import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private Espetaculo espetaculo;
    private ArrayList<Entrada> entradas = new ArrayList<>();

    public Pedido(Cliente cliente, Espetaculo espetaculo) {
        this.cliente = cliente;
        this.espetaculo = espetaculo;
    }

    public void adicionarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public double calcularTotal() {
        double total = 0;
        for (Entrada e : entradas) {
            total += e.calcularPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Espetaculo getEspetaculo() {
        return espetaculo;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public void mostrarResumo() {
        System.out.println("\n--- Resumo do Pedido ---");
        System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        System.out.println("Espetáculo: " + espetaculo.getNome() + " - " + espetaculo.getData() + " " + espetaculo.getHora());
        System.out.println("Entradas compradas:");
        for (Entrada e : entradas) {
            System.out.printf("  Assento %02d - %s - R$ %.2f%n", e.getAssento(), e.getTipo(), e.calcularPreco());
        }
        System.out.printf("Valor Total: R$ %.2f%n", calcularTotal());
    }
}
