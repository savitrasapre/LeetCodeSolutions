

class Coins 
{
    static int totalWays = 0;
    public static void waysToTotalN(int[] currency,int currencyChosen,int total) {
        
        int currentAmount = total - currencyChosen;
        if(currentAmount == 0)
        {
             totalWays++;
             return;
        } 
        
        for (int i = 0; i < currency.length; i++) {
            if(currency[i] <= currentAmount)
            {
                waysToTotalN(currency,  currency[i], currentAmount);
            }
        }

        
    }


    public static void main(String[] args) {
        int[] currency = {25,10,5,1};

        waysToTotalN(currency, 0, 3);
        System.out.println(totalWays);
    }
}