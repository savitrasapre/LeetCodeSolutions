#include<iostream>
#include<vector>

using namespace std;


//time limit exceeding
void rotate(vector<int>& nums, int k)
{
	if (nums.size() > 1)
	{
		for (int i = 0; i < k; i++)
		{
			int temp = nums.back();
			for (int j = nums.size() - 2; j >= 0; j--)
			{
				nums[j + 1] = nums[j];
			}
			nums[0] = temp;
		}
	}
}

int main()
{
	vector<int> input = { 1, 2, 3, 4, 5, 6, 7 };
	rotate(input,4);
	return 0;
}