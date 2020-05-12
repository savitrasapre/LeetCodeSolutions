

import java.util.ArrayList;
import java.util.Stack;

class GenerateAllValidParens
{
    /**
     * Parens: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
        of n pairs of parentheses.

        ((()))  ()()()  ()(())
        1 = ()
        2 = (1)  ()1
        3 = (2) 2() ()2
            
     * @param args
     */

    public void printParens(String result, int leftRemaining, int rightRemaining) {
       
        if(leftRemaining == 0 && rightRemaining == 0)
        {
            System.out.println(result);
            return;
        }

        if(leftRemaining > rightRemaining)
        {
            return;
        }

        if(leftRemaining > 0)
        {
            printParens(result + "(", leftRemaining - 1, rightRemaining);
        }
        if(rightRemaining > 0)
        {
            printParens(result + ")", leftRemaining, rightRemaining - 1);
        }

    } 

    public static void main(String[] args) {
            
        GenerateAllValidParens p = new GenerateAllValidParens();
                   
         p.printParens("",1,1);
    }
}


 
    