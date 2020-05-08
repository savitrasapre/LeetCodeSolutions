
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

    public static void main(String[] args) {
        int[] inputArray = {-1,0,2,2,3,5,9};


        System.out.println(hasMagicIndex(inputArray,0,inputArray.length - 1));

    }
}