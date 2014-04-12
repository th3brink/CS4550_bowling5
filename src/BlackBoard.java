import java.util.ArrayList;
import java.util.List;

public class BlackBoard {
    static private int scoreIndex = 0;
    static private int frame = 0;
    static private List<Integer> frames = new ArrayList<Integer>();
    static private int totalScore = 0;
    List<Integer> scores = new ArrayList<Integer>();
    public BlackBoard(List<Integer> list) {
        scores = list;

    }

    public void total() {
        for (int item : frames) {
            totalScore += item;

        }
        System.out.println(totalScore);

    }

    public boolean fetch() {
        if (scores.get(scoreIndex) == 10) {
            frames.add(scores.get(scoreIndex));
            frames.add(scores.get(scoreIndex + 1));
            frames.add(scores.get(scoreIndex + 2));
            scoreIndex++;
            frame++;

        } else if (scores.get(scoreIndex) + scores.get(scoreIndex + 1) == 10) {
            frames.add(scores.get(scoreIndex));
            frames.add(scores.get(scoreIndex + 1));
            frames.add(scores.get(scoreIndex + 2));
            scoreIndex += 2;
            frame++;

        } else {
            frames.add(scores.get(scoreIndex));
            frames.add(scores.get(scoreIndex + 1));
            scoreIndex += 2;
            frame++;

        }
        totalScore = 0;
        total();
        return frame == 10;

    }
}
