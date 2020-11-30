/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import java.util.List;
import statistics.Player;

/**
 *
 * @author matibrax
 */
public class All implements Matcher {

    public All() {

    }

    @Override
    public boolean matches(Player p) {
        return true;
    }    
}
