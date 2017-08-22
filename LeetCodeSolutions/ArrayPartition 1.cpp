#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int arrayPairSum(vector<int>& nums)
{
	int count = 0;
	sort(nums.begin(), nums.end());

	for (int i = 0; i < nums.size(); i=i+2)
	{
		count += nums[i];
	}
	return count;
}
 
int arrayPairSumMain()
{
	vector<int> numbers = { 1, 4, 5, 6, 9, 11, 44, 66 };
	cout << arrayPairSum(numbers);
	return 0;
}