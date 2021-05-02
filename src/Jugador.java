import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private List<Carta> mano;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList();
    }

    public void adicionarCarta(Carta carta) {
        this.mano.add(carta);
    }

    public Carta botarCarta(int index) {
        return this.mano.remove(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador: ").append(this.nombre).append("\n").append(this.mano.toString());
        return sb.toString();
    }

}
