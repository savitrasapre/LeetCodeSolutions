

class AllPermutationsString
{
    
    public static void swapChars(char[] input, int a, int b)
    {
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }


    /**
     *                                                                    abcd
     *                                                       abcd  |  bacd  |  cbad  |  dbca
     *              abcd   acbd   adcb  |           bacd bcad bdca          |       cbad cabd cdab          |       dbca dcba dacb
     *      abcd  abdc    acbd acdb    adcb adbc |  bacd badc bcad bcda bdca bdac | cbad cbda cabd cadb cdab cdba | dbca dbac dcba dcab dacb dabc
     *      abcd  abdc    acbd acdb    adcb adbc |  bacd badc bcad bcda bdca bdac | cbad cbda cabd cadb cdab cdba | dbca dbac dcba dcab dacb dabc
     * @param inputString
     * @param index
     */

    public static void printAllPermutations(char[] inputString, int index) {
        
        if(index >= inputString.length - 1)
        {
            System.out.println(inputString);
            return;
        }

        for (int i = index ; i < inputString.length; i++) {
            swapChars(inputString, index, i);
            printAllPermutations(inputString, index + 1);
        }

    }


    public static void main(String[] args) {
        String input = "abcd";

        printAllPermutations(input.toCharArray(),0);
    }
}