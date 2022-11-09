import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcao = 1;

        while (opcao != 3) {
            opcao = obterOpcaoMenu(sc);
            if (opcao == 1) { // Consultar contato
                consultarContato(sc, agenda);
            } else if (opcao == 2) { // Adicionar contato
                adicionarContato(sc, agenda);
            }
        }
    }

    public static void adicionarContato(Scanner sc, Agenda agenda) {
        try {
            System.out.println("==Criando um contato, entre com as informações==");
            String nome = lerInformacaoString(sc, "Entre com o nome do contato: ");
            String telefone = lerInformacaoString(sc, "Entre com o telefone do contato: ");
            String email = lerInformacaoString(sc, "Entre com o e-mail do contato: ");

            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setEmail(email);

            System.out.println("Contato a ser criado: ");
            System.out.println(contato);


            agenda.adicionaContato(contato);
        } catch (AgendaCheiaException e) {
            System.out.println(e.getMessage());

            System.out.println("==Contatos da agenda==");
            System.out.println(agenda);
        }
    }

    public static void consultarContato(Scanner sc, Agenda agenda) {
        String nomeContato = lerInformacaoString(sc, "Entre com o nome do contato a ser pesquisado: ");
        try {
            if (agenda.consultaContatoPorNome(nomeContato) >= 0) {
                System.out.println("O Contato já existe");
            }
        } catch (ContatoNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String lerInformacaoString(Scanner sc, String msg) {
        System.out.println(msg);
        String entrada = sc.nextLine();
        return entrada;
    }

    public static int obterOpcaoMenu(Scanner sc) {
        boolean entradaValida = false;
        int opcao = 3;

        while (!entradaValida) {
            System.out.println("Digite a  opção desejada: ");
            System.out.println("1: Consultar contato");
            System.out.println("2: Adicionar contato");
            System.out.println("3: Sair");
            try {
                String entrada = sc.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao == 1 || opcao == 2 || opcao == 3) {
                    entradaValida = true;

                } else {
                    throw new Exception("Entrada inválida");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, digite novamente.\n");
            }
        }
        return opcao;
    }
}
