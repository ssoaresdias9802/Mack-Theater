//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 


public class EntradaProfessor extends Entrada {
    public EntradaProfessor(Espetaculo esp, int numeroAssento) {
        super(esp, numeroAssento);
    }

    @Override
    public double calcularPreco() {
        return espetaculo.preco * 0.6;
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}
