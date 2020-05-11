
class MagicIndex
{

    public static boolean hasMagicIndex(int[] inputArray,int start,int end) {
        
        if(start > end)
            return false;

        int mid = (start + end)/2;

        if(inputArray[mid] == mid)
            return true;
        else if(inputArray[mid] > mid)
            return hasMagicIndex(inputArray, start, mid - 1);
        else
            return hasMagicIndex(inputArray, mid + 1, end);

    }

    public static boolean hasMagicIndex(int[] inputArray)
    {
        int actualStartingIndex = inputArray[0];
        return hasMagicIndex(inputArray,actualStartingIndex,inputArray.length - 1);
    }

    public static void main(String[] args) {
        int[] inputArray = {5,5,6,6,6,6,6};

        System.out.println(hasMagicIndex(inputArray));

    }
}