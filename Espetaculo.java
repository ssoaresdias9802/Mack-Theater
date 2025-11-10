
public class Espetaculo{
    private String nome;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];

    public Espetaculo(String nome, String hora, double preco, boolen assentos){
        this.nome = nome;
        this.hora = hora;
        this.preco = preco;
    }

      String[][] mapaAssentos = {
        {"50", "49", "48", "47", "46", "45", "44", "43", "42", "41"},
        {"40", "39", "38", "37", "36", "35", "34", "33", "32", "31"},
        {"30", "29", "28", "27", "26", "25", "24", "23", "22", "21"},
        {"20", "19", "18", "17", "16", "15", "14", "13", "12", "11"},
        {"10", "09", "08", "07", "06", "05", "04", "03", "02", "01"}
    };
    public void apresentaAssentos(String[][] assentos){
        System.out.print("|| Assentos Disponíveis ||");
        for (int i = 0; i < assentos.length; i++) {
        for (int j = 0; j < assentos[i].length; j++) {
        System.out.print(assentos[i][j] + " ");
        }
        System.out.println();
}
    }
    public void marcarAssento(int Assento){
        for (int i = 0; i < assentos.length; i++) {
        for (int j = 0; j < assentos[i].length; j++) {
                if (assento == Integer.parseInt(mapaAssentos[i][j])) {
                    mapaAssentos[i][j] = "XX"; 
                    ocupacaoAssentos[assento - 1] = true; 
                    System.out.println("Assento " + assento + " reservado com sucesso!");
                    return;
                }
    } 

};