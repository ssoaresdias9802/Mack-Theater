import java.util.ArrayList;
import java.util.Scanner;

public class Teatro {
    private ArrayList<Espetaculo> espetaculos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void cadastrarEspetaculo(Scanner sc) {
        System.out.println("\n*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = sc.nextLine();
        System.out.print("Data: ");
        String data = sc.nextLine();
        System.out.print("Hora: ");
        String hora = sc.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        espetaculos.add(new Espetaculo(nome, data, hora, preco));
        System.out.println("\n>>> Espetáculo cadastrado com sucesso! <<<");
    }

    public void cadastrarCliente(Scanner sc) {
        System.out.println("\n*** CADASTRO DE CLIENTE ***");
        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        clientes.add(new Cliente(nome, cpf));
        System.out.println("\n>>> Cliente cadastrado com sucesso! <<<");
    }

    public void venderEntradas(Scanner sc) {
        if (espetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado!");
            return;
        }

        System.out.println("\n*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
        for (int i = 0; i < espetaculos.size(); i++) {
            Espetaculo e = espetaculos.get(i);
            System.out.printf("%d) %s %s %s R$ %.2f%n",
                    i + 1, e.getNome(), e.getData(), e.getHora(), e.getPrecoInteira());
        }

        System.out.print("Selecione um espetáculo: ");
        int escolha = sc.nextInt() - 1;
        sc.nextLine();
        if (escolha < 0 || escolha >= espetaculos.size()) return;

        Espetaculo esp = espetaculos.get(escolha);

        System.out.print("Informe o CPF do Cliente Cadastrado: ");
        String cpf = sc.nextLine();
        Cliente cli = buscarCliente(cpf);
        if (cli == null) {
            System.out.println("Cliente não encontrado! Venda cancelada.");
            return;
        }

        Pedido pedido = new Pedido(cli, esp);

        String continuar = "S";
        do {
            esp.mostrarAssentos();
            System.out.print("Selecione um assento: ");
            int assento = sc.nextInt();
            sc.nextLine();

            if (!esp.ocuparAssento(assento)) {
                System.out.println("Assento inválido ou já ocupado!");
                continue;
            }

            System.out.println("\n ||| Tipos de Entrada |||");
            System.out.println("1) Inteira");
            System.out.println("2) Meia (50%)");
            System.out.println("3) Professor (40%)");
            System.out.print("Selecione um tipo de entrada: ");
            int tipo = sc.nextInt();
            sc.nextLine();

            Entrada entrada;
            switch (tipo) {
                case 2 : entrada = new EntradaMeia(esp, assento);
                case 3 : entrada = new EntradaProfessor(esp, assento);
                default : entrada = new EntradaInteira(esp, assento);
            }

            pedido.adicionarEntrada(entrada);

            System.out.print("Deseja comprar outra entrada (S/N)? ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("S"));

        pedidos.add(pedido);

        pedido.mostrarResumo();
        System.out.println("\n>>> Retornar ao menu principal <<<");
    }

    private Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }
}

