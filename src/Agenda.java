import java.util.Arrays;

public class Agenda extends Contato {

    private Contato[] contatos;

    public Agenda() {
        contatos = new Contato[5];
    }

    public void adicionaContato(Contato c) throws AgendaCheiaException {

        boolean cheia = true;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {
                contatos[i] = c;
                cheia = false;
                break; // terminando o for, achando uma posição que pode add o contato, para a execução do for
            }
        }
        if (cheia) {
            // lançar exception aqui
            throw new AgendaCheiaException();
        }
    }

    public int consultaContatoPorNome(String nome) throws ContatoNaoExisteException {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                    return i;
                }
            }
        }
        // Lançar uma exception contato não existe
        throw new ContatoNaoExisteException(nome);
    }

    @Override
    public String toString() { //9:40
        StringBuilder s = new StringBuilder();
        for (Contato c : contatos) {
            if (c != null) {
                s.append(c.toString()).append("\n");
            }
        }
        return s.toString();
    }
}

