package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (player1Score==player2Score) {
            return evenPoints();
        } else if (player1Score >=4  || player2Score >= 4) {
            return advantageOrWin();     
        } else {
            return currentSitutation();
        }
    }
    
    private String currentSitutation() {
        String gameSituation= ""; 
        int player = player1Score;
        
        for (int i=1; i<3; i++) {
                if (i == 2) {
                    gameSituation+="-"; 
                    player = player2Score;
                }
                
                switch(player) {
                    case 0:
                        gameSituation+="Love";
                        break;
                    case 1:
                        gameSituation+="Fifteen";
                        break;
                    case 2:
                        gameSituation+="Thirty";
                        break;
                    case 3:
                        gameSituation+="Forty";
                        break;
                }
            }
         return gameSituation;
    }

    private String evenPoints() {
        switch (player1Score) {
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                case 3:
                    return "Forty-All";
                default:
                    return "Deuce";
            }
    }

    private String advantageOrWin() {
        int currentResult = player1Score-player2Score;
        
        if (currentResult==1) {
            return "Advantage player1";
        } else if (currentResult ==-1) {
            return "Advantage player2";
        } else if (currentResult>=2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    
}