	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> intStack = new Stack<Integer>();
		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<nums2.length;i++)
		{
		    while(!intStack.empty() && intStack.peek() < nums2[i])
		    {
			map.put(intStack.pop(), nums2[i]);
		    }
		    intStack.push(nums2[i]);
		}

		for (int i = 0; i < nums1.length; i++) {
		    nums1[i] = map.getOrDefault(nums1[i], -1);
		}
        
		return nums1;  
        }
