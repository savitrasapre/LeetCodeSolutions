#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

bool containsNearbyDuplicate(vector<int>& nums, int k)
{
	unordered_map<int, int> hmap;
	
	for (int i = 0; i < nums.size(); i++)
	{
		if (hmap.find(nums[i]) != hmap.end() && i - hmap[nums[i]] <= k)
			return true;
		hmap[nums[i]] = i;
		cout << hmap[nums[i]];
	}
	return false;
}

int ContainsNearbyDuplicateMain()
{
	vector<int> input = { 5, 9, 20, 5, 20, 5 };
	cout << "Answer:"<<containsNearbyDuplicate(input,5);

	return 0;
}