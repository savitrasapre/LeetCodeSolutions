#include<iostream>
#include<vector>
#include "LeetcodeUtility.h"


void merge(std::vector<int>& nums1,int m,std::vector<int>& nums2, int n)
{
	int i = m - 1, j = n-1;
	int k = m + n - 1;

	while (i >= 0 && j >=0 )
	{
		if (nums1[i] > nums2[j])
			nums1[k--] = nums1[i--];
		else
			nums1[k--] = nums2[j--];
	}
	utility::printArray(nums1);

	while (j >= 0) nums1[k--] = nums2[j--];

	utility::printArray(nums1);
}


int MergeSortedArray()
{
	std::vector<int> input1 = { 1, 2,4,8 };
	std::vector<int> input2 = { 3,5 ,6};
	merge(input1, input1.size(), input2, input2.size());
	return 0;
}