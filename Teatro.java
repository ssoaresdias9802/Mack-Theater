import java.util.ArrayList;
import java.util.Scanner;

public class Teatro {
    Pedido carrinho;
    Espetaculo espetaculoSelecionado;

    public void venderEntradas(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Espetaculo> espetaculos) {
        if (espetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado!");
            return;
        }

        System.out.println("*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
        for (int i = 0; i < espetaculos.size(); i++) {
            Espetaculo e = espetaculos.get(i);
            System.out.printf("%d) %s %s %s R$ %.2f%n", i + 1, e.nome, e.data, e.hora, e.preco);
        }

        System.out.print("Selecione um espetáculo: ");
        int escolha = sc.nextInt() - 1;
        sc.nextLine();

        if (escolha < 0 || escolha >= espetaculos.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        this.espetaculoSelecionado = espetaculos.get(escolha);
        this.carrinho = new Pedido(null, espetaculoSelecionado);

        String continuar = "S";
        do {
            espetaculoSelecionado.mostrarAssentos();

            System.out.print("\nSelecione um assento: ");
            int assento = sc.nextInt();
            sc.nextLine();

            if (!espetaculoSelecionado.ocuparAssento(assento)) {
                System.out.println("Assento inválido ou já ocupado!");
                continue;
            }

            System.out.println("||| Tipos de Entrada |||");
            System.out.println("1) Inteira");
            System.out.println("2) Meia 50% do valor da entrada");
            System.out.println("3) Professor 40% do valor da entrada");
            System.out.print("Selecione um tipo de entrada: ");
            int tipo = sc.nextInt();
            sc.nextLine();

            Entrada entrada;
            switch (tipo) {
                case 2:
                    entrada = new EntradaMeia(espetaculoSelecionado, assento);
                    break;
                case 3:
                    entrada = new EntradaProfessor(espetaculoSelecionado, assento);
                    break;
                default:
                    entrada = new EntradaInteira(espetaculoSelecionado, assento);
                    break;
            }

            carrinho.adicionarEntrada(entrada);

            System.out.print("Deseja comprar outra entrada (S/N)? ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("S"));

        System.out.print("Informe o CPF do Cliente Cadastrado: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarCliente(cpf, clientes);

        if (cliente == null) {
            System.out.println("Cliente não encontrado! Retorne ao menu e cadastre-o.");
            return;
        }

        carrinho.cliente = cliente;
        System.out.printf("Valor Total: R$ %.2f%n", carrinho.calcularTotal());
        System.out.println(">>> Retornar ao menu principal <<<");
    }

    private Cliente buscarCliente(String cpf, ArrayList<Cliente> clientes) {
        for (Cliente c : clientes)
            if (c.cpf.equals(cpf))
                return c;
        return null;
    }
}
