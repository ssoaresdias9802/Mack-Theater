//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 10438338


public class Espetaculo {
    String nome;
    String data;
    String hora;
    double preco;
    boolean[] assentos = new boolean[50];

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
    }

    public void mostrarAssentos() {
        System.out.println("||| Assentos Disponíveis |||");
        for (int i = 0; i < assentos.length; i++) {
            if (i % 10 == 0) System.out.println();
            if (assentos[i]) System.out.print("XX ");
            else System.out.printf("%02d ", i + 1);
        }
        System.out.println();
    }

    public boolean ocuparAssento(int numero) {
        if (numero < 1 || numero > 50) return false;
        if (assentos[numero - 1]) return false;
        assentos[numero - 1] = true;
        return true;
    }
}
