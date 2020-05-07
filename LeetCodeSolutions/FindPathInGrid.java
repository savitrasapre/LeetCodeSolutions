import java.util.*;


class FindPathInGrid
{
    static List<Set<Integer>> map = new ArrayList<Set<Integer>>();

    public static boolean findPath(boolean[][] grid,int i, int j)
    {
        if(i == 0 && j == 0)
            return true;
        
        if(i < 0 || j < 0)
            return false;

        boolean currentUpCellChosen = false;
        boolean currentLeftCellChosen = false;

        if(i-1 >= 0 && grid[i-1][j] != true)
        {
            Set<Integer> tempSet = new HashSet<>();
            tempSet.add(i-1);
            tempSet.add(j);
            if(map.contains(tempSet))
            {
                currentUpCellChosen = true;
            }
            else
            {
                currentUpCellChosen = findPath(grid, i-1, j);
                Integer[] tempArr = {i-1,j};
                map.add(new HashSet<>(Arrays.asList(tempArr)));
                
            }
            
        }

        if(j-1 >= 0 && grid[i][j-1] != true)
        {
            Set<Integer> tempSet = new HashSet<>();
            tempSet.add(i);
            tempSet.add(j-1);
            if(map.contains(tempSet))
            {
                currentUpCellChosen = true;
            }
            else
            {
                currentUpCellChosen = findPath(grid, i, j-1);
                Integer[] tempArr = {i,j-1};
                map.add(new HashSet<>(Arrays.asList(tempArr)));
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

        System.out.print(findPath(grid,2,2));

    }


}