#include<iostream>
#include<vector>
#include "LeetcodeUtility.h"


/* The idea here is to check for non-zero elements and append them in front of the last non-zero element we have found. In the end,
	we append 0s to the number of times we found
	Very intersting approach of Array Transformation.   
*/

void moveZeroes(std::vector<int>& nums)
{
	int count = 0;
	for (int i = 0; i < nums.size(); i++)
	{
		if (nums[i] != 0)
		{
			nums[count] = nums[i];
			count++;
			utility::printArray(nums);
		}
	}

	for (int i = count; i < nums.size();i++)
		nums[i] = 0;
	
	utility::printArray(nums);
}

int MoveZeroesMain()
{
	std::vector<int> input = {0,1,0,3,12};
	moveZeroes(input);
	return 0;
}