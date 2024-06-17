/**
 * Classe que representa um show.
 */
public class Show extends Evento {
    private String atrações;

    /**
     * Construtor da classe Show.
     * @param nome O nome do show.
     * @param data A data do show.
     * @param preco O preço do ingresso do show.
     * @param atrações As atrações que se apresentará no show.
     */
    public Show(String nome, String data, double preco, String atrações) {
        super(nome, data, preco);
        this.atrações = atrações;
    }

    /**
     * Obtém o nome da atrações que se apresentará no show.
     * @return O nome da atrações.
     */
    public String getBanda() {
        return atrações;
    }

    /**
     * Define o nome da atrações que se apresentará no show.
     * @param atrações O novo nome da atrações.
     */
    public void setBanda(String atrações) {
        this.atrações = atrações;
    }

    /**
     * Obtém os detalhes do show.
     * @return Os detalhes do show.
     */
    @Override
    public String getDetalhes() {
        return "Atrações " + atrações;
    }
}
