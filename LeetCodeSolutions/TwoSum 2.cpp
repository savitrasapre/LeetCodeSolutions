#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target)
{
	/*vector<int> result;
	int start = 0, end = nums.size() - 1;*/

	/*while (start < end)
	{
		if (nums[start] + nums[end] == target)
		{
			return { start + 1, end + 1 };
			break;
		}
		else if (nums[start] + nums[end] > target)
			end--;
		else
			start++;
	}*/
	
	//takes 3ms time with no extra space.
	for (int i = 0, j = nums.size() - 1; i < j;)
	{
		if (nums[i] + nums[j] == target)
		{
			return { i + 1, j + 1 };
			break;
		}
		else if (nums[i] + nums[j] > target)
			j--;
		else
			i++;
	}


	//return result;
}

int TwoSumMain()
{
	vector<int> input = { -1, 0 };
	//{ 2, 6, 7, 9, 11, 14, 15 };
	vector<int> output = twoSum(input,-1);

	for (auto& i : output)
	{
		cout << i << endl;
	}

	return 0;
}