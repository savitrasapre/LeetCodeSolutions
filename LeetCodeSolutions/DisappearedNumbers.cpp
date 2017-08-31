#include<iostream>
#include<vector>
#include "LeetcodeUtility.h"
#include<algorithm>


std::vector<int> findDisappearedNumbers(std::vector<int>& nums)
{
	std::vector<int> result;

	//put every number on index
	for (int i = 0; i < nums.size(); i++)
	{
		int m = abs(nums[i]) - 1;
		nums[m] = nums[m] > 0 ? -nums[m] : nums[m];
	}

	for (int i = 0; i < nums.size(); i++)
	{
		//adding to result array
		if (nums[i] >0 )
			result.push_back(i + 1);
	}

	return result;
}

int FindDisappearedNumberMain()
{
	std::vector<int> input = { 4, 3, 2, 7, 8, 2, 3, 1 };
	std::vector<int> output = findDisappearedNumbers(input);
	utility::printArray(output);
	return 0;
}