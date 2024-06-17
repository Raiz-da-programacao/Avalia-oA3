/**
 * Classe que representa um ingresso Frontstage.
 */
public class IngressoFrontstage extends Ingresso {

    /**
     * Construtor da classe IngressoFrontstage.
     * @param evento Evento relacionado ao ingresso.
     */
    public IngressoFrontstage(Evento evento) {
        super(evento);
    }

    /**
     * Calcula o preço do ingresso.
     * @return Preço do ingresso.
     */
    @Override
    public double calcularPreco() {
        return getEvento().getPreco() * 1.25;
    }
}
