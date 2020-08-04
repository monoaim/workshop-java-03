import java.util.Map;
import java.util.HashMap;

public class TennisGame2 {

    private int player1Point, player2Point;
    private final String player1Name, player2Name;
    private final Map<Integer, String> EQUAL_SCORES =
            new HashMap<Integer, String>() {
                {
                    put(0, "Love-All");
                    put(1, "Fifteen-All");
                    put(2, "Thirty-All");
                }
            };
    private final Map<Integer, String> SCORES =
            new HashMap<Integer, String>() {
                {
                    put(0, "Love");
                    put(1, "Fifteen");
                    put(2, "Thirty");
                    put(3, "Forty");
                }
            };

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (player1Point == player2Point) {
            return EQUAL_SCORES.getOrDefault(player1Point, "Deuce");
        } else if (player1Point >= 4 || player2Point >= 4) {
            int diffPoint = player1Point - player2Point;
            String prefixScore = Math.abs(diffPoint) == 1 ? "Advantage" : "Win for";
            String leadPlayerName = diffPoint > 0 ? this.player1Name : this.player2Name;
            return String.format("%s %s", prefixScore, leadPlayerName);
        }
        return String.format("%s-%s", SCORES.get(player1Point), SCORES.get(player2Point));
    }

    public void p1Score() {
        player1Point++;
    }

    public void p2Score() {
        player2Point++;
    }

    public void wonPoint(String player) {
        // Null Safety
        if ("player1".equals(player)) {
            p1Score();
        } else {
            p2Score();
        }
    }
}
