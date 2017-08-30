#include<iostream>
#include<vector>
#include<algorithm>
#include "LeetcodeUtility.h"


int findMaxConsecutiveOnes(std::vector<int>& nums)
{
	int max = 0;
	int count = 0;
	for (int i = 0; i < nums.size(); i++)
	{
		if (nums[i] == 1)
		{
			count++;
			if (count>max)
				max = count;
		}
		else
		{
			count = 0;
		}
	}

	return max;	
}

int MaxConsecutiveOnesMain()
{
	std::vector<int> input = { 1, 1, 1, 0, 1, 1,1,1, 0, 1, 1, 1};
	std::cout <<"Answer:"<< findMaxConsecutiveOnes(input);
	return 0;
}