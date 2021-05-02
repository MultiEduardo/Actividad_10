import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Juego {
    static Scanner scanner = new Scanner(System.in);
    static int select = -1;
    private ArrayList<Jugador> jugadores;
    private Dealer dealer = new Dealer(new Baraja());

    public Juego() {
        this.dealer.mezclarBaraja((byte) 15);
        this.jugadores = new ArrayList();

    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void repartirCartas(byte numeroCartas) {
        Iterator var2 = this.jugadores.iterator();

        while(var2.hasNext()) {
            Jugador jugador = (Jugador)var2.next();

            for(byte i = 0; i < numeroCartas; i++) {
                jugador.adicionarCarta(this.dealer.entregarCarta());
            }
        }
    }

    public String mostrarBaraja() {
        return this.dealer.mostrarBaraja();
    }

    public int getNumeroCartasDealer() {
        return this.dealer.getNumeroCartas();
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        //Mientras la opción elegida sea 0, preguntamos al usuario o en dado caso que las cartas se terminen
        //se terminara el programa
        while(select != 0 && juego.getNumeroCartasDealer() > 0){
            //Try catch para evitar que el programa termine si hay un error
            try{
                System.out.println("Bienvenido a Poker!\n"+"Elige un opción:\n1.- Mezclar deck" +
                        "\n2.- Sacar una carta\n" +
                        "3.- Carta al azar\n" +
                        "4.- Generar una mano de 5 cartas\n" +
                        "0.- Salir");
                //Recoger una variable por consola
                select = Integer.parseInt(scanner.nextLine());
                switch(select){
                    case 1:
                        juego.dealer.mezclarBaraja((byte) 15);
                        System.out.println("Se mezcló el Deck.");
                        break;
                    case 2:
                        System.out.println(juego.dealer.entregarCarta());
                        System.out.println("Quedan: " + juego.getNumeroCartasDealer());
                        if (juego.getNumeroCartasDealer() <= 0){
                            System.out.println("Se han agotado las cartas\n");
                        }
                        break;
                    case 3:
                        System.out.println(juego.dealer.entregarCarta());
                        System.out.println("Quedan: " + juego.getNumeroCartasDealer());
                        if (juego.getNumeroCartasDealer() <= 0){
                            System.out.println("Se han agotado las cartas");
                        }
                        break;
                    case 4:
                        juego.addJugador(new Jugador(""));
                        juego.repartirCartas((byte) 5);
                        Iterator var2 = juego.getJugadores().iterator();

                        while (var2.hasNext()) {
                            Jugador j = (Jugador) var2.next();
                            System.out.println(j.toString());
                        }
                        System.out.println("Quedan: " + juego.getNumeroCartasDealer());
                        if (juego.getNumeroCartasDealer() <= 0){
                            System.out.println("Se han agotado las cartas");
                        }
                        break;
                    case 0:
                        System.out.println("Gracias por jugar");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

                System.out.println("\n");

            }catch(Exception e){
                if (juego.getNumeroCartasDealer() <= 0){
                    System.out.println("Se han agotado las cartas\n");
                }else {
                    System.out.println("Error\n");
                }
            }
        }
    }
}
