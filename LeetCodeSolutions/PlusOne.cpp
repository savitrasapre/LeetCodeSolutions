#include<iostream>
#include<vector>

using namespace std;

vector<int> plusOne(vector<int>& digits)
{
	for (int i = digits.size()-1; i>=0; i--)
	{
		if (digits[i] == 9)
		{
			digits[i] = 0;
		}
		else
		{
			digits[i]++;
			break;
		}
	}
	if (!digits[0])
	{
		digits[0] = 1;
		digits.push_back(0);
	}

	return digits;
}

int plusOneMain()
{
	vector<int> inputNumber = { 9,9};
	vector<int> outputNumber = plusOne(inputNumber);

	for (auto i : outputNumber)
	{
		cout << i;
	}
	cout << endl;

	return 0;
}