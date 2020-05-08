import java.util.*;


class FindPathInGrid
{
    static int[][] memo;

    public static boolean findPath(boolean[][] grid) {
        memo = new int[grid.length][grid[0].length];
        return findPathHelper(grid, grid.length - 1, grid[0].length - 1);
    }

    public static boolean findPathHelper(boolean[][] grid,int i, int j)
    {
        if(i == 0 && j == 0)
            return true;
        
        if(i < 0 || j < 0)
            return false;

        boolean currentUpCellChosen = false;
        boolean currentLeftCellChosen = false;

        if(i-1 >= 0 && grid[i-1][j] != true)
        {
            if(memo[i-1][j])
            {
                currentUpCellChosen = true;
            }
            else
            {
                currentUpCellChosen = findPathHelper(grid, i-1, j);

                if(currentUpCellChosen)
                    memo[i-1][j] = true; 
            }
        }

        if(j-1 >= 0 && grid[i][j-1] != true)
        {
            if(memo[i][j-1])
            {
                currentLeftCellChosen = true;
            }
            else
            {
                currentLeftCellChosen = findPathHelper(grid, i, j-1);
            
                if(currentLeftCellChosen)
                    memo[i][j-1] = true;
            }
        }

        if(currentLeftCellChosen || currentUpCellChosen)
            return true;

        return false;
    }


    public static void main(String[] args) {
        boolean[][] grid = new boolean[3][3];

        grid[1][1] = true;
        grid[2][0] = true;
        //grid[7][5] = true;

        System.out.print(findPath(grid));

    }


}