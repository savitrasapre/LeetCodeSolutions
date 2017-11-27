#include<iostream>
#include<map>


int factorial(int num)
{
	if (num <= 1)
		return 1;

	static std::map<int, int> hmap;

	if (hmap.find(num) != hmap.end())
	{
		std::cout << "num" << num << "->" << hmap[num] << "\n";
		return hmap[num];
	}
	else
	{

		int res = num * factorial(num - 1);
		hmap[num] = res;
		return res;
	}
}

int fact(int num)
{
	if (num <= 1)
		return 1;

	return num * fact(num - 1);
}


int mainFact()
{
	std::cout << fact(50)<<"\n";
	std::cout << factorial(15);
	return 0;
}