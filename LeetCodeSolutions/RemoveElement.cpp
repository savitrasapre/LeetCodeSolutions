#include<iostream>
#include<vector>

using namespace std;

int removeElement(vector<int>& nums, int val)
{
	if (nums.empty())
		return 0;
	
	int count = 0;

	for (int i = 0; i < nums.size(); i++)
	{
		if (nums[i] != val)
			nums[count++] = nums[i];
	}

	/*vector<int>::iterator it;
	for (it = nums.begin(); (it = find(nums.begin(), nums.end(), val)) != nums.end();++it)
	{
		nums.erase(it);
	}*/
	/* Using 2 pointers
	int first, second;

	for (int i = 0; i < nums.size(); i++)
	{
		first = nums[i];
		second = nums[i];
		if (first == val)
		{
			for (int j = i; j < nums.size(); j++)
			{
				second = nums[j + 1];
				if (second == val)
				{
					nums.erase(nums.begin()+j+1);
				}
				if (nums[j+1])
					second = nums[j + 1];
			}
			nums.erase(nums.begin() + i);
		}

	}*/

	for (auto& i : nums)
	{
		cout << i << endl;
	}
	return count;
}


int RemoveElementMain()
{
	vector<int> input = { 3, 4, 5, 6, 7, 8, 4, 5, 4 };
	//{ 3, 4, 5, 6, 7, 8, 4, 5, 4 };
	cout << removeElement(input, 4);
	return 0;
}