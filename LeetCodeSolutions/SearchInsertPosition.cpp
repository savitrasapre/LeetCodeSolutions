#include<iostream>
#include<string>
#include<vector>

using namespace std;


int searchInsert(vector<int>& nums, int target)
{
	int left = 0, right = nums.size()-1;

	while (left <= right)
	{
		if (nums[left] == target)
			return left;
		if (nums[right] == target)
			return right;
		if (target > nums[left])
			left++;
		else
			right--;
	}
	return left;
}

int searchBinaryInsert(vector<int>& nums, int target, string type)
{
	int left = 0, right = nums.size() - 1;
	while (left<=right)
	{
		int mid = left + (right - left) / 2;

		if (nums[mid] == target)
			return mid;
		if (target > mid)
		{
			left = mid + 1;
		}
		else
		{
			right = mid - 1;
		}

	}
	cout << type;
	return left;
}
int SearchInsertMain()
{
	vector<int> input = { 1,2,3 };
	cout << searchInsert(input, 0);
	cout << searchBinaryInsert(input, 4, "BinarySearch");
	return 0;
}