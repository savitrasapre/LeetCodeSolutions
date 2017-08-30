#include<iostream>
#include<vector>
#include "LeetcodeUtility.h"

/*
The idea being that XOR of number with itself is 0 and XOR with 0 is the same number.
 0 2 3 4 5
 0 1 2 3 4            5
*/

int missingNumber(std::vector<int>& nums)
{
	int count = 0;
	for (int i = 0; i < nums.size(); i++)
		count ^= i ^ nums[i];
	return count ^ nums.size();
}

int MissingNumberMain()
{
	std::vector<int> input { 0, 2, 3, 4, 5 };
	std::cout << missingNumber(input);
	return 0;
}


