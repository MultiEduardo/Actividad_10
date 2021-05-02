public class Carta {
    private final Palo palo;
    private final Numero numero;
    private final Color color;

    public Carta(Palo f, Numero n, Color c) {
        this.palo = f;
        this.numero = n;
       this.color = c;
    }

    public Numero getNumero() {
        return this.numero;
    }

    public  Color getColor(){
        return this.color;
    }

    public Palo getPalo() {
        return palo;
    }

    public String toString() {
        return "{" + this.palo.toString() + "," + this.color.toString()  + "," +this.numero.toString() + "}";
    }
}
