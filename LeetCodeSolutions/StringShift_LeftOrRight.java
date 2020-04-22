

class StringShift {
    private static String leftShift(String s,int times)
    {
        //abcd d + abc
        //cdab
        int normalizedTimes = times % s.length();

        if(normalizedTimes > 0)
        {                                   
            normalizedTimes = Math.abs(normalizedTimes);
        }
        else
        {
            normalizedTimes = s.length() + normalizedTimes;
        }

        return s.substring(normalizedTimes) + s.substring(0,normalizedTimes);
    }


    //abcde >> 6 
    //eabcd >> 1 || << 5
    
     
    private static String rightShift(String s,int times)
    {
        return leftShift(s, times);
    }

    public static String stringShift(String s, int[][] shift)
    {
        int leftCount = 0;
        int rightCount = 0;
        
        //0 2
        //1 50
        // ===> 0 2

        for (int i = 0; i < shift.length; i++) {
        
            if(shift[i][0] == 0)
            {
               leftCount += shift[i][1];
            }
            else
            {
               rightCount += shift[i][1];
            }
        }
    
        int normalizedShift = leftCount - rightCount;

        if(normalizedShift > 0)
        {
            //left bigger
            return leftShift(s, normalizedShift);
        }
        else
        {
            //right bigger
            return rightShift(s, normalizedShift);
        }
        
    }
}