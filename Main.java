import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            sc.nextLine(); // consome o Enter

            switch (opcao) {
                case 1:
                    limparTela();
                    teatro.cadastrarEspetaculo(sc);
                    pausar(sc);
                    break;

                case 2:
                    limparTela();
                    teatro.cadastrarCliente(sc);
                    pausar(sc);
                    break;

                case 3:
                    limparTela();
                    teatro.venderEntradas(sc);
                    pausar(sc);
                    break;

                case 4:
                    System.out.println("Saindo... Obrigado por usar o MackTheater!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    pausar(sc);
                    break;
            }

        } while (opcao != 4);

        sc.close();
    }

    // Simula limpar a tela no console
    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Faz o programa esperar o usuário apertar Enter antes de voltar ao menu
    private static void pausar(Scanner sc) {
        System.out.println("\nPressione ENTER para voltar ao menu...");
        sc.nextLine();
    }
}
