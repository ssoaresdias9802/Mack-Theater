//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 


public class EntradaMeia extends Entrada {
    public EntradaMeia(Espetaculo esp, int numeroAssento) {
        super(esp, numeroAssento);
    }

    @Override
    public double calcularPreco() {
        return espetaculo.preco * 0.5;
    }

    @Override
    public String getTipo() {
        return "Meia";
    }
}
