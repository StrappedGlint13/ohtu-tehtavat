package ohtu.kivipaperisakset;

import java.util.Scanner;

public class HelppoYksinpeli extends KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);
    Tekoaly tekoaly = new Tekoaly();

    HelppoYksinpeli(Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}