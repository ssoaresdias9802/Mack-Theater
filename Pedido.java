//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 

import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    Espetaculo espetaculo;
    ArrayList<Entrada> entradas = new ArrayList<>();

    public Pedido(Cliente cliente, Espetaculo espetaculo) {
        this.cliente = cliente;
        this.espetaculo = espetaculo;
    }

    public void adicionarEntrada(Entrada e) {
        entradas.add(e);
    }

    public double calcularTotal() {
        double total = 0;
        for (Entrada e : entradas) total += e.calcularPreco();
        return total;
    }
}
