package Logica;

import java.util.ArrayList;

/**
 *
 * @author Grupo 01
 *
 */
public class Jugador {

    private Carta carta1;
    private Carta carta2;
    private int peso;
    private double victorias;
    private int kicker;
    private ArrayList<Carta> mejorMano;

    public Carta getCarta(int i) {
        Carta carta;

        if (i == 1) {
            carta = carta1;
        } else {
            carta = carta2;
        }

        return carta;
    }

    public Jugador(Carta carta1, Carta carta2) {
        this.carta1 = carta1;
        this.carta2 = carta2;
        this.victorias = 0;

        if (carta1.getValor() > carta2.getValor()) {
            this.kicker = carta1.getValor();
        } else {
            this.kicker = carta2.getValor();
        }
    }

    public void setPeso(int peso) {
        this.peso = peso;

    }

    public void setCartas(ArrayList<Carta> listaCarta) {
        this.mejorMano = listaCarta;

    }

    public int getPeso() {
        return this.peso;
    }

    public ArrayList<Carta> getCartas() {
        return this.mejorMano;
    }

    public double getVictorias() {
        return this.victorias;
    }

    public void setVictorias(double d) {
        this.victorias = d;
    }

    public void setKicker(int kiker) {
        this.kicker = kiker;
    }

    public int getKicker() {
        return kicker;
    }
}
