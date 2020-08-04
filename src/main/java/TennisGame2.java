import java.util.Map;
import java.util.HashMap;

public class TennisGame2 {

    private int player1Point, player2Point;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String player1Result = "";
        String player2Result = "";
        String score = "";
        //        if (player1Point == player2Point && player1Point < 4) {
        //            if (player1Point == 0) score = "Love";
        //            if (player1Point == 1) score = "Fifteen";
        //            if (player1Point == 2) score = "Thirty";
        //            score += "-All";
        //        }
        //        if (player1Point == player2Point && player1Point >= 3) score = "Deuce";
        //
        //        if (player1Point > 0 && player2Point == 0) {
        //            if (player1Point == 1) player1Result = "Fifteen";
        //            if (player1Point == 2) player1Result = "Thirty";
        //            if (player1Point == 3) player1Result = "Forty";
        //
        //            player2Result = "Love";
        //            score = player1Result + "-" + player2Result;
        //        }
        //        if (player2Point > 0 && player1Point == 0) {
        //            if (player2Point == 1) player2Result = "Fifteen";
        //            if (player2Point == 2) player2Result = "Thirty";
        //            if (player2Point == 3) player2Result = "Forty";
        //
        //            player1Result = "Love";
        //            score = player1Result + "-" + player2Result;
        //        }
        //
        //        if (player1Point > player2Point && player1Point < 4) {
        //            if (player1Point == 2) player1Result = "Thirty";
        //            if (player1Point == 3) player1Result = "Forty";
        //            if (player2Point == 1) player2Result = "Fifteen";
        //            if (player2Point == 2) player2Result = "Thirty";
        //            score = player1Result + "-" + player2Result;
        //        }
        //        if (player2Point > player1Point && player2Point < 4) {
        //            if (player2Point == 2) player2Result = "Thirty";
        //            if (player2Point == 3) player2Result = "Forty";
        //            if (player1Point == 1) player1Result = "Fifteen";
        //            if (player1Point == 2) player1Result = "Thirty";
        //            score = player1Result + "-" + player2Result;
        //        }
        //
        //        if (player1Point > player2Point && player2Point >= 3) {
        //            score = "Advantage player1";
        //        }
        //
        //        if (player2Point > player1Point && player1Point >= 3) {
        //            score = "Advantage player2";
        //        }
        //
        //        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2)
        // {
        //            score = "Win for player1";
        //        }
        //        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2)
        // {
        //            score = "Win for player2";
        //        }
        //        return score;

        Map<Integer, String> EQUAL_SCORES =
                new HashMap<Integer, String>() {
                    {
                        put(0, "Love-All");
                        put(1, "Fifteen-All");
                        put(2, "Thirty-All");
                    }
                };

        Map<Integer, String> SCORES =
                new HashMap<Integer, String>() {
                    {
                        put(0, "Love");
                        put(1, "Fifteen");
                        put(2, "Thirty");
                        put(3, "Forty");
                    }
                };

        if (player1Point == player2Point) {
            score = EQUAL_SCORES.getOrDefault(player1Point, "Deuce");
        } else if (player1Point >= 4 || player2Point >= 4) {
            int diffPoint = player1Point - player2Point;
            String wording = ((Math.abs(diffPoint) == 1) ? "Advantage" : "Win for");
            String currentLeader = diffPoint > 0 ? this.player1Name : this.player2Name;
            score = String.format("%s %s", wording, currentLeader);
        } else {
            score = String.format("%s-%s", SCORES.get(player1Point), SCORES.get(player2Point));
        }
        return score;
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
