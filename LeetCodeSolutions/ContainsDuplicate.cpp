#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

bool ContainsDuplicate(vector<int>& nums)
{
	if (nums.empty())
		return false;
	unordered_map<int, int> hmap;
	for (int i = 0; i < nums.size(); i++)
	{
		if (++hmap[nums[i]] > 1)
			return true;
	}
	return false;
}

int ContainsDuplicateMain()
{
	vector<int> input = { 1, 3, 55, 7, 99, 3, 6, 22};
	cout << ContainsDuplicate(input);
	return 0;
}