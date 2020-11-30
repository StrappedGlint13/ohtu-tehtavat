package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();
        Matcher m = query.playsIn("NYR")
                     .hasAtLeast(5, "goals")
                     .hasFewerThan(10, "goals").build();
        
        System.out.println(m);
 
        stats.matches(m).forEach((player) -> {
            System.out.println( player );
        });
    }

}
