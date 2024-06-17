/**
 * Classe abstrata que representa um evento.
 */
public abstract class Evento {
    private String nome;
    private String data;
    private double preco;

    /**
     * Construtor da classe Evento.
     * @param nome O nome do evento.
     * @param data A data do evento.
     * @param preco O preço base do evento.
     */
    public Evento(String nome, String data, double preco) {
        this.nome = nome;
        this.data = data;
        this.preco = preco;
    }

    /**
     * Obtém o nome do evento.
     * @return O nome do evento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do evento.
     * @param nome O novo nome do evento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a data do evento.
     * @return A data do evento.
     */
    public String getData() {
        return data;
    }

    /**
     * Define a data do evento.
     * @param data A nova data do evento.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Obtém o preço do evento.
     * @return O preço do evento.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do evento.
     * @param preco O novo preço do evento.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método abstrato para obter detalhes específicos do evento.
     * @return Detalhes específicos do evento.
     */
    public abstract String getDetalhes();
}
