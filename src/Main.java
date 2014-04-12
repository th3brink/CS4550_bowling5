import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in;
        boolean fetched = false;
        String filename = "bowling.dat";
        String inString;
        List<Integer> scores = new ArrayList<Integer>();
        Scanner reader = new Scanner(System.in);
        if (args.length > 0 && args[0] != null) {
            filename = args[0];

        } else {
            System.out.println("Enter the file you want to read - leave blank for default: ");
            filename = reader.next();
            System.out.println("File entered: " + filename);

        }
        try {
            in = new Scanner(new File(filename));
            inString = in.nextLine();
            String[] splitBowlingArray = inString.split("\\s+");
            for (String score : splitBowlingArray) {
                scores.add(Integer.parseInt(score));

            }

        } catch (Exception e) {
            System.out.println("Failed to open file with error: "+e);

        }
        BlackBoard blackboard = new BlackBoard(scores);
        while (!fetched) {
            fetched = blackboard.fetch();

        }
    }
}
