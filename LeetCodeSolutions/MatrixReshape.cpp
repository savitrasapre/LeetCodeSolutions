#include<iostream>
#include<vector>

using namespace std;


vector<vector<int>> matrixReshape(vector<vector<int>> nums, int r, int c)
{
	vector <vector<int>> temp(r,vector<int>(c));
	int m = 0, n = 0;
	int area = nums[0].size() * nums.size();

	if (area != r*c) return nums;

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			temp[i][j] = nums[m][n];
			n++;
			if (n == nums[0].size()) n = 0, m++;
		}
	}
	return temp;
}

int MatrixReshapreMain()
{
	vector<vector<int>> input = {{1, 2}, {3, 4}};

	vector<vector<int>> output = matrixReshape(input, 1, 4);
	cout << "answer:";
	for (int i = 0; i < 1; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cout << output[i][j];
		}
		cout << endl;
	}

	return 0;
}