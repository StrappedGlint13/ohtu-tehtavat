package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
   
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> finnishplayers = new ArrayList<>();
        System.out.println("Players from FIN " + CurrentDate() + "\n");
        for (Player player : players) { 
            if (player.getNationality().equals("FIN")){
                finnishplayers.add(player);
            }
        }
        Collections.sort(finnishplayers);
        
        for (Player player : finnishplayers) { 
            System.out.println(player);
        }
       
    }
  
      
    public static Date CurrentDate () {
        Date date = new Date();
        return date;
    }


  
}