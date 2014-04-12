import java.util.ArrayList;
import java.util.List;

public class BlackBoard {
    static private int scoreIndex = 0;
    static private int frame = 0;
    static private List<List<Integer>> frames = new ArrayList<List<Integer>>();
    static private int totalScore = 0;
    List<Integer> scores = new ArrayList<Integer>();

    static private int playerCount = 1;
    static private int playerTurn = 1;

    public BlackBoard(List<Integer> list, int p_count) {
        scores = list;
        playerCount = p_count;
        for (int i = 0; i < playerCount; i++) {
            frames.add(new ArrayList<Integer>());
            System.out.println("player " + (i+1) + " created.");
        }
    }

    public void total() {
        frame = frame - playerCount+1;
        System.out.print("Frame " + frame + ": ");
        int i = 0;
        for (List<Integer> playerFrame : frames) {
            i++;
            totalScore = 0;
            for (int item : playerFrame) {
                totalScore += item;

            }
            System.out.print("Player "+i+": "+totalScore + " | ");
        }
        System.out.println("");
    }

    public boolean fetch() {
        if (scores.get(scoreIndex) == 10) {
            frames.get(playerTurn - 1).add(scores.get(scoreIndex));
            frames.get(playerTurn-1).add(scores.get(scoreIndex + 1));
            frames.get(playerTurn-1).add(scores.get(scoreIndex + 2));
            scoreIndex++;
            frame++;

        } else if (scores.get(scoreIndex) + scores.get(scoreIndex + 1) == 10) {
            frames.get(playerTurn-1).add(scores.get(scoreIndex));
            frames.get(playerTurn-1).add(scores.get(scoreIndex + 1));
            frames.get(playerTurn-1).add(scores.get(scoreIndex + 2));
            scoreIndex += 2;
            frame++;

        } else {
            frames.get(playerTurn-1).add(scores.get(scoreIndex));
            frames.get(playerTurn-1).add(scores.get(scoreIndex + 1));
            scoreIndex += 2;
            frame++;

        }

        if (playerTurn < playerCount) {
            playerTurn++;
            fetch();

        } else {
            total();
            playerTurn = 1;

        }

        return frame == 10;
    }
}
