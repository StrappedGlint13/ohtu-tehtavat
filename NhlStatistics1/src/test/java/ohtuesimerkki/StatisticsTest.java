/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author matibrax
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
 
    @Test
    public void listPlayersOfTheTeam() {
        List<Player> testTeam = new ArrayList<Player>();
        testTeam = stats.team("PIT");
        Player testPlayer = new Player(null, null, 0, 0);
        
        assertEquals(1, testTeam.size());
        
        for (Player player : testTeam) {
            if (player.getName().contains("Lemieux")) {
                testPlayer = player;
            }
        }
        
        assertEquals("Lemieux", testPlayer.getName());
          
    }
   
    @Test
    public void searchPlayerWorks() {
        Player searchedPlayer1 = stats.search("Kurri");
        assertEquals("Kurri", searchedPlayer1.getName());
 
        Player searchedPlayer2 = stats.search("Narri");
        assertEquals(null, searchedPlayer2);
       
    }
    
    @Test
    public void topScorersWorks() {
        List<Player> testList = new ArrayList<Player>();
        testList = stats.topScorers(2);
        
        assertEquals(3, testList.size());
        assertEquals("Gretzky", testList.get(0).getName());
        assertEquals("Lemieux", testList.get(1).getName());
        assertEquals("Yzerman", testList.get(2).getName());
    }
    
    
}