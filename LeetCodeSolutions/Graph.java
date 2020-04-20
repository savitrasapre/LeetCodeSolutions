import java.util.Queue;

class Graph {
    private int adjMatrix[][];
    private int visitedNode[][];
    int numVertices;


    Graph(int[][] adj)
    {
        this.adjMatrix = adj;
        this.visitedNode = new int[this.adjMatrix.length][this.adjMatrix[0].length];
    }


    public void DFS(int i,int j)
    {           
        if(i < 0 || j < 0 || i > adjMatrix.length - 1 || j > adjMatrix[0].length - 1)
        {
            return;
        }
        if(adjMatrix[i][j] == '1' && visitedNode[i][j] == 0)
        {
            visitedNode[i][j] = 1;
            DFS(i-1,j);     //up
            DFS(i+1,j);     //down
            DFS(i,j-1);     //left
            DFS(i,j+1);     //right
        }
    }

   

    public int countIslands()
    {
        int islandCount = 0;

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if(adjMatrix[i][j] == '1' && visitedNode[i][j] == 0)
                {
                    islandCount++;
                    //call recursion.
                    DFS(i,j);
                }
            }
        }

        return islandCount;

    }



    public static void main(String[] args) {
        
        // char[][] adj =  {  {'1','1','0','0','0'},
        //                    {'1','1','0','0','0'},
        //                    {'0','0','1','0','0'},
        //                    {'0','0','0','1','1'}};
                           
        int[][] adj = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
          };
        Graph g = new Graph(adj);
        

        System.out.println(g.);

        // g.addEdge(0, 1);
        // g.addEdge(0, 2);
        // g.addEdge(1, 2);
        // g.addEdge(2, 0);
        // g.addEdge(2, 3);

    }


}