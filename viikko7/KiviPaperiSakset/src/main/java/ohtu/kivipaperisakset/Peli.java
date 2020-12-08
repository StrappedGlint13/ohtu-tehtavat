/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author matibrax
 */
public class Peli {
    
    
    public static KiviPaperiSakset luoVaikeaYksinPeli() {
        return new VaikeaYksinpeli(new TekoalyParannettu(20));
    }
    
    public static KiviPaperiSakset luoHelppoYksinPeli() {
        return new HelppoYksinpeli(new Tekoaly());
    }
    
    public static KiviPaperiSakset luoKaksinPeli() {
        return new KaksinPeli();
    }
    
    
}
