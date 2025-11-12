//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 10438338


public abstract class Entrada {
    int numeroAssento;
    Espetaculo espetaculo;

    public Entrada(Espetaculo espetaculo, int numeroAssento) {
        this.espetaculo = espetaculo;
        this.numeroAssento = numeroAssento;
    }

    public abstract double calcularPreco();
    public abstract String getTipo();
}
