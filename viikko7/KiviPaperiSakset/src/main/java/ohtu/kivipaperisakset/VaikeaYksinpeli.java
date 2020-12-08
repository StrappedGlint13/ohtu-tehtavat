package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class VaikeaYksinpeli extends KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);
    TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    
    public VaikeaYksinpeli(TekoalyParannettu tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
