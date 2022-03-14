public class WordRunner {
    private LetterGrid grid;
    private String guess;

    public WordRunner()
    {
        grid = new LetterGrid();
    }

    public void Introduction()
    {
        System.out.println("Welcome to Wordle!\nYou have 6 guesses to find a word using actual words");

    }
}
