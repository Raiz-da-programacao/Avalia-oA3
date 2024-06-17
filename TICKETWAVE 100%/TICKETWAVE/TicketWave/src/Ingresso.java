/**
 * Classe abstrata que representa um ingresso.
 */
public abstract class Ingresso {
    protected Evento evento;

    /**
     * Construtor da classe Ingresso.
     * @param evento O evento associado ao ingresso.
     */
    public Ingresso(Evento evento) {
        this.evento = evento;
    }

    /**
     * Obtém o evento associado ao ingresso.
     * @return O evento associado.
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Define o evento associado ao ingresso.
     * @param evento O novo evento associado.
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * Método abstrato para calcular o preço do ingresso.
     * @return O preço do ingresso.
     */
    public abstract double calcularPreco();
}
