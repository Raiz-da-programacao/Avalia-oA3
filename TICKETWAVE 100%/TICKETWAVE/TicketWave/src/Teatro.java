/**
 * Classe que representa uma peça de teatro.
 */
public class Teatro extends Evento {
    private String diretor;

    /**
     * Construtor da classe Teatro.
     * @param nome O nome da peça de teatro.
     * @param data A data da peça de teatro.
     * @param preco O preço do ingresso da peça de teatro.
     * @param diretor O diretor da peça de teatro.
     */
    public Teatro(String nome, String data, double preco, String diretor) {
        super(nome, data, preco);
        this.diretor = diretor;
    }

    /**
     * Obtém o nome do diretor da peça de teatro.
     * @return O nome do diretor.
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * Define o nome do diretor da peça de teatro.
     * @param diretor O novo nome do diretor.
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * Obtém os detalhes da peça de teatro.
     * @return Os detalhes da peça de teatro.
     */
    @Override
    public String getDetalhes() {
        return "Peça dirigida por " + diretor;
    }
}
