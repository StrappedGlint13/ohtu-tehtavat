
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getName() {
        return name;
    }
    
    public int totalStats() {
        
        return goals + assists;
    } 
    
    
    @Override
    public int compareTo(Player player) {
        if (this.totalStats() < player.totalStats()) {
            return 1;
        } else if (this.totalStats() > player.totalStats()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String player = new String();
        return player+=String.format("%-20s%-5s%-2d%-2s%-2d%-2s%-2d", name , team, goals, " + ", assists, " = ", totalStats());
    }      
}
