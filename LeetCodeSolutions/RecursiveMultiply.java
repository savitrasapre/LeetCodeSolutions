import java.util.Currency;

class RecursiveMultiply
{

    /**
     * Recursive Multiply: Write a recursive function to multiply two positive integers without using the *
     * operator.You can use addition, subtraction, and bit shifting, but you should minimize the number
       of those operations.
     * 
     * @param a
     * @param b
     * @return
     */
    
    public static int multiply(int a,int b,int currentSum)
    {
        if(b == 0)
            return currentSum;
            
        b--;
        currentSum = multiply(a, b, currentSum + a) ;
               
        return currentSum;
    } 

    public static int multiplication(int a, int b) {        

        if(a == 1)
            return b;

        if(a % 2 == 0)
        {
            int currentSum = multiplication(a >> 1, b);
            return currentSum << 1;
        }
        else
        {                                                   
            int currentSum = multiplication(a - 1 , b);
            currentSum = currentSum + b;
            return currentSum;
        }

    }

    public static void main(String[] args) {
        int a = 7;
        int b = 9;

        System.out.println(multiplication(Math.min(a, b),Math.max(a, b)));
    }
}