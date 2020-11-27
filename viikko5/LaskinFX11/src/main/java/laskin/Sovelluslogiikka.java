package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    private int[] edellisetTulokset;
    private int pointteri;
    
    public Sovelluslogiikka() {
        this.tulos = tulos;
        this.edellisetTulokset = new int[100];
        this.pointteri = 0;
         
        // alusta edellisten tulosten taulukko
        for (int i = 0; i < this.edellisetTulokset.length-1; i++) {
            edellisetTulokset[i] = 0;
        }
    }
    
    public void plus(int luku) {
        edellisetTulokset[pointteri] = tulos;
        tulos += luku;
        pointteri++;
    }
     
    public void miinus(int luku) {
        edellisetTulokset[pointteri] = tulos;
        tulos -= luku;
        pointteri++;
    }
 
    public void nollaa() {
        edellisetTulokset[pointteri] = tulos;
        tulos = 0;
        pointteri++;
    }
 
    public int tulos() {
        return tulos;
    }
    
    public int edellinenTulos() {
        pointteri--;
        tulos = edellisetTulokset[pointteri];
        return edellisetTulokset[pointteri];
    }
}