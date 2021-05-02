import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baraja {
    private List<Carta> baraja;

    public Baraja() {
        this.construir();
    }

    private void construir() {
        this.baraja = new ArrayList();

        Palo[] var1 = Palo.values();

        for(int var3 = 0; var3 < var1.length; ++var3) {
            Palo f = var1[var3];
            Color[] var5 = Color.values();

            for (int var7 = 0; var7 < var5.length; ++var7) {
                Color c = var5[var7];
                Numero[] var9 = Numero.values();

                for (int var11 = 0; var11 < var9.length; ++var11) {
                    Numero n = var9[var11];
                    this.baraja.add(new Carta(f, n, c));
                }
            }
        }
        
    }

    public void mezclar(byte cantidad) {
        int Veces = cantidad * this.baraja.size();
        Random random = new Random();
        for(int i = 0; i < Veces; i++) {
            int index = random.nextInt(this.baraja.size());
            Carta carta = this.baraja.remove(index);
            index = random.nextInt(this.baraja.size());
            this.baraja.add(index, carta);
        }
        for(int i = 0; 53 <= baraja.size(); i++){
                baraja.remove(1);
        }
    }


    public int getNumeroCartas() {
        return this.baraja.size();
    }

    public Carta getCarta() {
        return this.baraja.remove(0);
    }

    public boolean estaVacia() {
        return this.baraja.isEmpty();
    }

    public String toString() {
        return this.baraja.toString();
    }
}
