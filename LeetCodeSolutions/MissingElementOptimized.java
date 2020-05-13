

class MissingElementOptimized
{
    /**
     * Find the only number that is unique, when given array is sorted in O(logn) time and O(1) complexity.
     * 
     * As it is sorted, first thing that came to mind was Binary Search.
     */

    public static int onlyUniqueElement(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;


        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(mid > 0 && arr[mid] == arr[mid - 1])
            {
                if(mid%2 == 0)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else if(mid < arr.length - 1 && arr[mid] == arr[mid+1])
            {
                if(mid%2 == 0)
                {
                    end = mid - 1;
                }
                else
                    start = mid + 1;
            }
            else
                return arr[mid];
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] input = {1,1,2,2,3};
        
        System.out.println(onlyUniqueElement(input));
        
    }
}