#include<iostream>
#include<vector>
#include<algorithm>
#include<math.h>

using namespace std;

int maxProduct(vector<int>& nums)
{
	//only 2 things can happen. One is if everything is positive then max 3 positives are picked.
	//Second is if there are negatives then pick max 2 negatives and max positive.
	sort(nums.begin(), nums.end());

	int temp1 = nums[nums.size() - 1] * nums[nums.size() - 2] * nums[nums.size() - 3];
	int temp2 = nums[nums.size() - 1] * nums[0] * nums[1];

	return temp1 > temp2 ? temp1 : temp2;
}

int MaxProductMain()
{
	vector<int> input = { 3, 9, -7, 14, -22 };
	cout << maxProduct(input);
	return 0;
}