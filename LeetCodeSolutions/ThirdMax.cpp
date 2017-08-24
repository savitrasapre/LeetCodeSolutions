#include<iostream>
#include<vector>

using namespace std;

int thirdMax(vector<int>& nums)
{
	long first = nums[0], second = LONG_MIN, third = LONG_MIN;
	
	for (int i : nums)
	{
		if (i == first || i == second || i == third) continue;
		if (i > first)
		{
			third = second;
			second = first;
			first = i;
		}
		else if (i > second && first > i)
		{
			third = second;
			second = i;
		}
		else if (i > third && second > i)
		{
			third = i;
		}
	}
	return third == LONG_MIN ? first : third;
}


int ThirdMaxMain()
{
	vector<int> input = { 1,2,-11111 };
	cout << "Third max number: " << thirdMax(input);
	return 0;
}