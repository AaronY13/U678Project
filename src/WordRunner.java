import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class WordRunner {
    private LetterGrid grid;
    private Word wordClass;
    private String solution;
    private Scanner scan;
    private ArrayList realWords;
    private final String YELLOW = "\u001B[33m";
    private final String GREEN = "\u001B[32m";
    private final String WHITE = "\u001B[37m";

    public WordRunner()
    {
        grid = new LetterGrid();
        wordClass = new Word();
        solution = wordClass.getGameWord();
        scan = new Scanner(System.in);
        realWords = new ArrayList<>();
        loadWordsInto(realWords);
    }

    public void play()
    {
        introduction();
        game();
    }

    public void introduction()
    {
        System.out.println("Welcome to Wordle! You have 6 tries to guess the word");
    }

    public void game()
    {
        boolean winCondition = false;
        String guess = "";
        int rowIndex = 0;
        while (!winCondition && rowIndex != 6)
        {
            boolean letterRequirement = true;
            while (letterRequirement)
            {
                System.out.print("Enter your 5 letter guess: ");
                guess = scan.nextLine();
                if (guess.length() == 5 && isRealWord(guess))
                {
                    letterRequirement = false;
                }
                else
                {
                    System.out.println("That is not a valid guess");
                }
            }
            for (int i = 0; i < 5; i++)
            {
                grid.setGrid(rowIndex, i, (chooseColor(compareWithSolution(guess)[i]) + guess.substring(i, i + 1)));
            }
            grid.printGrid();
            if (guess.equals(solution))
            {
                winCondition = true;
            }
            rowIndex++;
            }
        if (winCondition)
        {
            System.out.println("You win!");
        }
        else
        {
            System.out.println(WHITE + "Sorry you didn't get the word");
            System.out.println("The word was: " + solution);
        }

    }

    public static void loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src\\dictionary.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isRealWord(String word)
    {
        return realWords.contains(word);
    }

    /**
     *
     * @param word The five letter guess
     * @return An array of ints that relates to the value of which color of the letter to use
     */
    public int[] compareWithSolution(String word)
    {
        int[] coloredStr = new int[5];
        ArrayList<String> guessList = new ArrayList<>();
        ArrayList<String> solutionList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            guessList.add(word.substring(i, i + 1));
        }
        for (int i = 0; i < 5; i++)
        {
            solutionList.add(solution.substring(i, i + 1));
        }
        for (int i = 0; i < 5; i++)
        {
            if (guessList.get(i).equals(solutionList.get(i)))
            {
                coloredStr[i] = 2;
            }
            else if (solutionList.indexOf(guessList.get(i)) != -1)
            {
                coloredStr[i] = 1;
            }
            else
            {
                coloredStr[i] = 0;
            }
        }
        return coloredStr;
    }

    /**
     *
     * @param num the num value using
     * @return The color of the final variable
     */
    public String chooseColor(int num)
    {
        if (num == 2)
        {
            return GREEN;
        }
        else if (num == 1)
        {
            return YELLOW;
        }
        else
        {
            return "";
        }
    }
}
