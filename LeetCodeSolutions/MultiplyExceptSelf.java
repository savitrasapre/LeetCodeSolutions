


class MultiplyExceptSelf
{
    // Really important question using prefix and suffix arrays. Makes it happen in O(n) of time.
    
    public static int[] multiplyExceptSelf(int[] input)
    {
                 // 10 15 3 7
        //prefix    1 10 150 450 
        //suffix    315   21    7    1

        int[] prefix = new int[input.length];
        int[] suffix = new int[input.length];
        int[] answer = new int[input.length];

        prefix[0] = 1;
        for (int i = 1; i < suffix.length; ++i) {
            prefix[i] = prefix[i - 1] * input[i - 1];
        }

        suffix[suffix.length - 1] = 1;
        for (int i = suffix.length - 2; i >= 0 ; --i) {
            suffix[i] = suffix[i+1] * input[i+1];
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }
}