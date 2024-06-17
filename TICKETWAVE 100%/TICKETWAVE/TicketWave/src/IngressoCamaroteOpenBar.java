/**
 * Classe que representa um ingresso Camarote Open Bar.
 */
public class IngressoCamaroteOpenBar extends Ingresso {

    /**
     * Construtor da classe IngressoCamaroteOpenBar.
     * @param evento Evento relacionado ao ingresso.
     */
    public IngressoCamaroteOpenBar(Evento evento) {
        super(evento);
    }

    /**
     * Calcula o preço do ingresso.
     * @return Preço do ingresso.
     */
    @Override
    public double calcularPreco() {
        return getEvento().getPreco() * 1.70;
    }
}

