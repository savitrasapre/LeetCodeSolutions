#include<iostream>
#include<vector>

bool binarySearch(std::vector<int> inpArray, int val)
{
	int left = 0, right = inpArray.size() - 1;
	
	while (left < right)
	{
		int mid = (left+right) / 2;
		
		if (val > inpArray[mid])
			left = mid + 1;
		else
			right = mid - 1;
		
		if (inpArray[mid] == val)
		{
			std::cout << val << " found at position " << mid+1 << "\n";
			return true;
		}
	}

	return false;
}

