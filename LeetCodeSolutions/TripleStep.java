

class TripleStep
{

    /*
        n = 4
                   __   
                __|
             __|   
          __|
         |
    
4 = 1 2 3

                                    
            
            1                       2                           3
            
        1   2   3                 1  2                          1
    1  2    1                   1       
    1

    */

    static int possibleStepCount = 0;
    public static void printAllPossibleWaysUsingOneStep(int steps,int[] currency, int stairsRemaining) {

        int stairsLeftToClimb = stairsRemaining - steps;       
        if(stairsLeftToClimb == 0)
        {
            possibleStepCount++;
            return;
        }

        for (int i = 0; i < currency.length ; i++) {
            if(currency[i] <= stairsLeftToClimb)
                printAllPossibleWaysUsingOneStep(currency[i],currency,stairsLeftToClimb);
        }

    }


    public static void printNumOfWaysToStep(int[] stepsAtaTime,int total) {
        printAllPossibleWaysUsingOneStep(0, stepsAtaTime,total);            
    }

    public static void main(String[] args) {

        int[] currency = {1,2,3};
        printNumOfWaysToStep(currency,4);
        System.out.println(possibleStepCount);
    }
}