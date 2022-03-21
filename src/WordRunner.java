import java.util.Scanner;

public class WordRunner {
    private LetterGrid grid;
    private Scanner scan;

    public WordRunner()
    {
        grid = new LetterGrid();
        scan = new Scanner(System.in);
    }

    public void Introduction()
    {
        System.out.println("Welcome to Wordle!\nYou have 6 guesses to find a word using actual words");

    }

    public void game()
    {
        boolean letterRequirement = true;
        String guess = "";
        while (letterRequirement)
        {
            System.out.print("Enter your first 5 letter guess: ");
            guess = scan.nextLine();
            if (guess.length() == 5)
            {
                letterRequirement = false;
            }
        }
        int rowIndex = 0;
        for (int i = 0; i < 5; i++)
        {
            grid.setGrid(rowIndex, i, guess.substring(i, i + 1));
        }
        grid.printGrid();
    }

}
