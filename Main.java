//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Espetaculo> espetaculos = new ArrayList<>();
        Teatro teatro = new Teatro();

        int opcao;

        do {
            limparTela();
            System.out.println("*** MACK THEATHER ***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.print("Opção inválida. Digite um número: ");
                sc.next();
            }

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    limparTela();
                    cadastrarEspetaculo(sc, espetaculos);
                    pausar(sc);
                    break;
                case 2:
                    limparTela();
                    cadastrarCliente(sc, clientes);
                    pausar(sc);
                    break;
                case 3:
                    limparTela();
                    teatro.venderEntradas(sc, clientes, espetaculos);
                    pausar(sc);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    pausar(sc);
                    break;
            }

        } while (opcao != 4);

        sc.close();
    }


    public static void cadastrarEspetaculo(Scanner sc, ArrayList<Espetaculo> lista) {
        System.out.println("*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = sc.nextLine();
        System.out.print("Data: ");
        String data = sc.nextLine();
        System.out.print("Hora: ");
        String hora = sc.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        lista.add(new Espetaculo(nome, data, hora, preco));
        System.out.println(">>> Retornar ao menu principal <<<");
    }

    public static void cadastrarCliente(Scanner sc, ArrayList<Cliente> lista) {
        System.out.println("*** CADASTRO DE CLIENTE ***");
        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        lista.add(new Cliente(nome, cpf));
        System.out.println(">>> Retornar ao menu principal <<<");
    }
    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void pausar(Scanner sc) {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}
