import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Word {
    private String gameWord;
    private ArrayList<String> wordleWords;

    public Word()
    {
        wordleWords = new ArrayList<String>();
        loadWordsInto(wordleWords);
        gameWord = wordleWords.get((int) (Math.random() * wordleWords.size())).toLowerCase();
    }

    public static void loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src\\wordleList"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public String getGameWord()
    {
        return gameWord;
    }

    public void printWord()
    {
        System.out.println(gameWord);
    }
}
