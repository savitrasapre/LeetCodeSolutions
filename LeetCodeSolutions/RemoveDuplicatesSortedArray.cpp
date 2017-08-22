#include<iostream>
#include<vector>

using namespace std;

int removeDuplicates(vector<int>& nums)
{
	int count = 1;
	for (int i = 1; i < nums.size(); i++)
	{
		if (nums[i - 1] != nums[i])
			count++;
	}
	return count; 
}


int RemoveDuplicatesMain()
{
	vector<int> input = { 1, 2, 3, 3, 3, 4, 5, 5, 6, 7, 7, 8, 8, 8, 8 };
	cout << removeDuplicates(input);
	return 0;
}