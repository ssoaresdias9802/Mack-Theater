//Stephanie Julia Soares Dias 10223952  
//Priscilla Yewon Lee 

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

        // tempSelecionados evita que o mesmo assento seja escolhido duas vezes
        boolean[] tempSelecionados = new boolean[50];

        String continuar = "S";
        do {
            // mostramos assentos considerando os temporários (selecionados nesta compra)
            mostrarAssentosComTemp(espetaculoSelecionado, tempSelecionados);

            System.out.print("\nSelecione um assento: ");
            int assento = sc.nextInt();
            sc.nextLine();

            // validações: intervalo, ocupado no espetáculo, ou já selecionado na compra atual
            if (assento < 1 || assento > 50) {
                System.out.println("Assento inválido! Escolha entre 1 e 50.");
                continue;
            }
            if (espetaculoSelecionado.assentos[assento - 1]) {
                System.out.println("Assento já ocupado! Escolha outro.");
                continue;
            }
            if (tempSelecionados[assento - 1]) {
                System.out.println("Assento já selecionado nesta compra! Escolha outro.");
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

            // NÃO marcamos espetaculo.assentos aqui — apenas marcamos tempSelecionados
            tempSelecionados[assento - 1] = true;
            carrinho.adicionarEntrada(entrada);

            System.out.print("Deseja comprar outra entrada (S/N)? ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("S"));

        // Quando terminar de escolher entradas, pedimos o CPF
        System.out.print("Informe o CPF do Cliente Cadastrado: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarCliente(cpf, clientes);

        if (cliente == null) {
            // compra cancelada — não marcamos assentos reais. apenas informamos e retornamos.
            System.out.println("Cliente não encontrado! Retornando ao menu principal. As reservas não foram confirmadas.");
            return;
        }

        // cliente encontrado -> confirmamos carrinho e marcamos os assentos no espetáculo
        carrinho.cliente = cliente;
        for (Entrada e : carrinho.entradas) {
            // marca definitivamente no espetaculo
            int num = e.numeroAssento;
            if (!espetaculoSelecionado.assentos[num - 1]) {
                espetaculoSelecionado.assentos[num - 1] = true;
            } // else: já ocupado (não deve ocorrer por validação anterior)
        }

        System.out.printf("Valor Total: R$ %.2f%n", carrinho.calcularTotal());
        System.out.println(">>> Retornar ao menu principal <<<");
    }

    // Mostra os assentos levando em conta os já ocupados no espetáculo e os temporariamente selecionados
    private void mostrarAssentosComTemp(Espetaculo esp, boolean[] temp) {
        System.out.println("||| Assentos Disponíveis |||");
        for (int i = 0; i < esp.assentos.length; i++) {
            if (i % 10 == 0) System.out.println();
            if (esp.assentos[i] || temp[i]) System.out.print("XX ");
            else System.out.printf("%02d ", i + 1);
        }
        System.out.println();
    }

    private Cliente buscarCliente(String cpf, ArrayList<Cliente> clientes) {
        for (Cliente c : clientes)
            if (c.cpf.equals(cpf))
                return c;
        return null;
    }
}
