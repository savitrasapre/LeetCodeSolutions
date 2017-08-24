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

void rotateHelper(vector<int>& arr, int left, int right)
{
	int i = left, j = right;
	while (i<j)
	{
		swap(arr[i], arr[j]);
		i++;
		j--;
	}
}

void rotateArray(vector<int>& nums, int k)
{
	int n = nums.size();
	if (k == 0 || n <= 1)
		return;

	k = k%n;
	rotateHelper(nums, 0, n - 1);
	rotateHelper(nums, 0, k - 1);
	rotateHelper(nums, k, n - 1);

	for (auto& i : nums)
		cout << i << endl;
}

int RotateArrayMain()
{
	vector<int> input = { 1, 2, 3, 4, 5, 6, 7 };
	rotate(input,4);
	cout << "And:" << endl;
	rotateArray(input, 3);
	return 0;
}