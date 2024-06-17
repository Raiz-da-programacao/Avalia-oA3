/**
 * Classe que representa um ingresso para a pista.
 */
public class IngressoPista extends Ingresso {

    /**
     * Construtor da classe IngressoPista.
     * @param evento Evento relacionado ao ingresso.
     */
    public IngressoPista(Evento evento) {
        super(evento);
    }

    /**
     * Calcula o preço do ingresso.
     * @return Preço do ingresso.
     */
    @Override
    public double calcularPreco() {
        return getEvento().getPreco();
    }
}
