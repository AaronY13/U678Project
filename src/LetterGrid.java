public class LetterGrid {
    private String[][] grid;

    public LetterGrid()
    {
        grid = new String[6][5];
    }

    public void printGrid()
    {
        for (String[] row : grid)
        {
            System.out.print("|");
            for (String col : row)
            {
                if (col == null)
                {
                    System.out.print(" |");
                }
                else
                {
                    System.out.print(col + "|");
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
