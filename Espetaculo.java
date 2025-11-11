public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double precoInteira;
    private boolean[] assentos = new boolean[50]; // false = livre, true = ocupado

    public Espetaculo(String nome, String data, String hora, double precoInteira) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.precoInteira = precoInteira;
    }

    public String getNome() { return nome; }
    public String getData() { return data; }
    public String getHora() { return hora; }
    public double getPrecoInteira() { return precoInteira; }

    public void mostrarAssentos() {
        System.out.println("\n ||| Assentos Disponíveis |||");
        for (int i = 0; i < assentos.length; i++) {
            if (i % 10 == 0) System.out.println();
            if (assentos[i])
                System.out.print("XX ");
            else
                System.out.printf("%02d ", i + 1);
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
