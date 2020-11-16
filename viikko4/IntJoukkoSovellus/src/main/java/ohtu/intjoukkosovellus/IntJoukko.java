
package ohtu.intjoukkosovellus;

public class IntJoukko { 
    private int[] joukko;      
    private int alkioidenLkm;   

    public IntJoukko() {
        alustaTaulukko(1);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaTaulukko(kapasiteetti);
    }   
    
    public int[] alustaTaulukko(int kapasiteetti) {
        joukko = new int[kapasiteetti];
        for (int i = 0; i < joukko.length; i++) {
            joukko[i] = 0;
        }
        return joukko;
    }

    public void lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == joukko.length) {  
                int[] taulukkoNew = new int[alkioidenLkm + 1];
                kopioiTaulukko(joukko, taulukkoNew);
                joukko = taulukkoNew;
            }
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;

    }

    public void poista(int luku) {
        boolean loytyi = false;
        int poistettavanAlkionIndeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                loytyi = true;
                poistettavanAlkionIndeksi = i;
                joukko[i] = 0;
                break;
            }
        }
        if (loytyi) {
            for (int j = poistettavanAlkionIndeksi; j < alkioidenLkm - 1; j++) {
                poistettavanAlkionIndeksi = joukko[j];
                joukko[j] = joukko[j + 1];
                joukko[j + 1] = poistettavanAlkionIndeksi;
            }
            alkioidenLkm--;
        }

    }
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.alkioidenLkm; i++) {
            b.lisaa(a.joukko[i]);
        }   
        return b;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (a.joukko[i] != b.joukko[i]) {
                a.poista(i);
            }  
        }
        return a;

    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        for (int i = 0; i < b.alkioidenLkm; i++) {
            a.poista(b.joukko[i]);
        }
        return a;
    }
    

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int getLkm() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String tuloste = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuloste += joukko[i] + ", ";
            }       
            return tuloste += joukko[alkioidenLkm - 1] + "}";
        }
    }
        
}
