package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KaksinPeli extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);
    
    public KaksinPeli() {
        
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = scanner.nextLine();
        return tokanSiirto;
    }
}