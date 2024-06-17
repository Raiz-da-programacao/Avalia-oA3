import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal que controla o fluxo do programa.
 */
public class Principal {
    private static ArrayList<Evento> eventos = new ArrayList<>();
    private static ArrayList<Ingresso> ingressos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia o programa.
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        exibirMensagemBoasVindas();
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    inserirEvento();
                    break;
                case 2:
                    comprarIngresso();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    listarIngressos();
                    break;
                case 5:
                    pesquisarEventoPorNome();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    /**
     * Exibe uma mensagem de boas-vindas.
     */
    private static void exibirMensagemBoasVindas() {
        System.out.println("************************************************");
        System.out.println("*                BEM-VINDO À                  *");
        System.out.println("*             TICKETWAVE INGRESSOS            *");
        System.out.println("************************************************");
        System.out.println("Estamos felizes em tê-lo conosco!");
        System.out.println("Aqui você pode inserir eventos e comprar ingressos.");
        System.out.println("Aproveite a experiência com a TicketWave!");
        System.out.println("************************************************\n");
    }

    /**
     * Exibe o menu de opções.
     */
    private static void exibirMenu() {
        System.out.println("\nMenu de Opções:");
        System.out.println("1. Crie Seu Evento Gratuitamente");
        System.out.println("2. Compre Seus Ingressos");
        System.out.println("3. Eventos Disponíveis");
        System.out.println("4. Ingressos Comprados");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Insere um novo evento no sistema.
     */
    private static void inserirEvento() {
        System.out.print("Tipo de Evento (1-Show, 2-Teatro): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Nome do Evento: ");
        String nome = scanner.nextLine();

        System.out.print("Data do Evento: ");
        String data = scanner.nextLine();

        System.out.print("Preço do Ingresso: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        switch (tipo) {
            case 1:
                System.out.print("Nome das atrações: ");
                String banda = scanner.nextLine();
                eventos.add(new Show(nome, data, preco, banda));
                break;
            case 2:
                System.out.print("Nome do Diretor: ");
                String diretor = scanner.nextLine();
                eventos.add(new Teatro(nome, data, preco, diretor));
                break;
            default:
                System.out.println("Tipo de evento inválido!");
        }
    }

    /**
     * Realiza a compra de um ingresso.
     */
    private static void comprarIngresso() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível.");
            return;
        }

        listarEventos();
        System.out.print("Escolha o evento pelo índice: ");
        int indiceEvento = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (indiceEvento < 0 || indiceEvento >= eventos.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Evento evento = eventos.get(indiceEvento);

        System.out.println("Preço do Ingresso Pista: R$" + evento.getPreco());
        System.out.println("Preço do Ingresso Frontstage: R$" + (evento.getPreco() * 1.25));
        System.out.println("Preço do Ingresso Camarote Open Bar: R$" + (evento.getPreco() * 1.70));

        System.out.print("Tipo de Ingresso (1-Pista, 2-Frontstage, 3-Camarote Open Bar): ");
        int tipoIngresso = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (tipoIngresso) {
            case 1:
                ingressos.add(new IngressoPista(evento));
                break;
            case 2:
                ingressos.add(new IngressoFrontstage(evento));
                break;
            case 3:
                ingressos.add(new IngressoCamaroteOpenBar(evento));
                break;
            default:
                System.out.println("Tipo de ingresso inválido!");
        }
    }

    /**
     * Lista todos os eventos cadastrados.
     */
    private static void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            System.out.println(i + ": " + evento.getNome() + " - " + evento.getData() + " - R$" + evento.getPreco() + " - " + evento.getDetalhes());
        }
    }

    /**
     * Lista todos os ingressos comprados.
     */
    private static void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso comprado.");
            return;
        }

        for (Ingresso ingresso : ingressos) {
            System.out.println(ingresso.getEvento().getNome() + " - R$" + ingresso.calcularPreco());
        }
    }

    /**
     * Pesquisa um evento por nome.
     */
    private static void pesquisarEventoPorNome() {
        System.out.println("Digite o nome do evento para pesquisar (pressione Enter para finalizar): ");
        StringBuilder nomeParcial = new StringBuilder();
        boolean pesquisaAtiva = true;

        while (pesquisaAtiva) {
            String entrada = scanner.nextLine();

            if (entrada.isEmpty()) {
                pesquisaAtiva = false;
            } else {
                nomeParcial.append(entrada);
                listarEventosComNomeParcial(nomeParcial.toString());
            }
        }
    }

    /**
     * Lista eventos que contêm a string parcial no nome.
     * @param nomeParcial String parcial do nome do evento.
     */
    private static void listarEventosComNomeParcial(String nomeParcial) {
        boolean encontrado = false;

        for (Evento evento : eventos) {
            if (evento.getNome().toLowerCase().contains(nomeParcial.toLowerCase())) {
                System.out.println("Evento encontrado: " + evento.getNome() + " - " + evento.getData() + " - R$" + evento.getPreco() + " - " + evento.getDetalhes());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum evento encontrado com o nome parcial: " + nomeParcial);
        }
    }
}
