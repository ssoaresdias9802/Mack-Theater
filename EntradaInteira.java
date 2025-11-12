//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 


public class EntradaInteira extends Entrada {
    public EntradaInteira(Espetaculo esp, int numeroAssento) {
        super(esp, numeroAssento);
    }

    @Override
    public double calcularPreco() {
        return espetaculo.preco;
    }

    @Override
    public String getTipo() {
        return "Inteira";
    }
}
