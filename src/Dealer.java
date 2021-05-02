public class Dealer {
    private Baraja baraja;

    public Dealer(Baraja baraja) {
        this.baraja = baraja;
    }

    public void mezclarBaraja(byte cantidad) {
        this.baraja.mezclar(cantidad);
    }

    public Carta entregarCarta() {
        return this.baraja.getCarta();
    }

    public String mostrarBaraja() {
        return this.baraja.toString();
    }

    public int getNumeroCartas() {
        return this.baraja.getNumeroCartas();
    }
}
