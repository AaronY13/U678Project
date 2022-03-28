public class LetterGrid {
    private String[][] grid;
    private final String WHITE = "\u001B[37m";

    public LetterGrid()
    {
        grid = new String[6][5];
    }

    public void printGrid()
    {
        for (String[] row : grid)
        {
            System.out.print(WHITE + "|");
            for (String col : row)
            {
                if (col == null)
                {
                    System.out.print(WHITE + " |" + WHITE);
                }
                else
                {
                    System.out.print(col + "|" + WHITE);
                }
            }
            System.out.println();
        }
    }

    public void setGrid(int r, int c, String str)
    {
        grid[r][c] = str;
    }
}
