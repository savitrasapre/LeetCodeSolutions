#include<iostream>
#include<vector>
#include "LeetcodeUtility.h"

int maxSubArray(std::vector<int>& nums)
{
	int sum = nums[0], contSum = 0;
	for (int i = 0; i < nums.size(); i++)
	{
		contSum += nums[i];
		if (contSum > sum)
			sum = contSum;
		if (contSum < 0)
			contSum = 0;
	}
	return sum;
}

int MaxSubArrayMain()
{
	std::vector<int> input = { -2, 1, -3, 4, -1, 2, 1,1, -5, 4 };
	std::cout << maxSubArray(input);
	return 0;
}