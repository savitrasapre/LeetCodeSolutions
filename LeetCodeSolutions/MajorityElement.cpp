#include<iostream>
#include<vector>
#include<math.h>
#include<unordered_map>

using namespace std;

int majorityElement(vector<int>& nums)
{
	unordered_map<int, int> hmap;
	for (int i = 0; i < nums.size(); i++)
	{
		if (++hmap[nums[i]] > (nums.size() / 2))
			return nums[i];
	}
}


int majorityElement(vector<int>& nums,int size)
{
	/* Moore's Voting Algorithm - if there is no majority element then this algo will spit out some element.
	*  Considering the fact that the question states that there is a majority element, this will work.
	*/
	int maj_index = 0;
	int count = 1;

	for (int i = 1; i < nums.size(); i++)
	{
		if (nums[maj_index] == nums[i])
			count++;
		else if (count == 0)
		{
			maj_index = i;
			count = 1;
		}
		else
			count--;
	}

	return nums[maj_index];
}

int MajorityElementMain()
{
	vector<int> input = { 2,2,3,5,2,2,6 };
	cout <<"STL: "<< majorityElement(input);
	cout <<"Index based: " << majorityElement(input, input.size());
	return 0;
}