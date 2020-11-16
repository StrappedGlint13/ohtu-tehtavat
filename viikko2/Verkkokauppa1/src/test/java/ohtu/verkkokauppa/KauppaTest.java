
package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    // luodaan ensin mock-oliot
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        k = new Kauppa(varasto, pankki, viite); 
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {      
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);
        
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
       
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoParametritTarkistetaan() {      

        when(viite.uusi()).thenReturn(33);

        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 10));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);  
        k.tilimaksu("pekka", "66666");

        verify(pankki).tilisiirto("pekka", 33, "66666", "33333-44455", 10);   
    }
    @Test
    public void ostoskoriinLisataanKaksiEriTuotettaJaTarkistetaanTiedot() {      
        when(viite.uusi()).thenReturn(6);
        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "voi", 5));
       

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "66666");


        verify(pankki).tilisiirto("pekka", 6, "66666", "33333-44455", 10);   

    }
    
    @Test
    public void ostoskoriinLisataanKaksiSamaaTuotettaJaTarkistetaanTiedot() {      
        when(viite.uusi()).thenReturn(6);
        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "voi", 10));
       

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "66666");


        verify(pankki).tilisiirto("pekka", 6, "66666", "33333-44455", 10);   

    }
    
    @Test
    public void ostoskoriinLisataanMaitoTuoteJotaOnTarpeeksiJaVoiTuoteJokaOnLoppu() {      
        when(viite.uusi()).thenReturn(6);  
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(0); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "voi", 10));
       

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "66666");


        verify(pankki).tilisiirto("pekka", 6, "66666", "33333-44455", 5);   

    }
}


