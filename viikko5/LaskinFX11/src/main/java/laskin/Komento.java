/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author matibrax
 */
public abstract class Komento {
    TextField tuloskentta; 
    TextField syotekentta; 
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        
    }

    public abstract void suorita();

    public void peru() {
         int laskunTulos = sovellus.edellinenTulos();
         syotekentta.setText("");
         tuloskentta.setText("" + laskunTulos);   
        
        if (laskunTulos==0) {
            nollaa.disableProperty().set(true);
            undo.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
            undo.disableProperty().set(false);
        }
    }
    
}
