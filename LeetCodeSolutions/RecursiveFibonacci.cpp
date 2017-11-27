#include<iostream>
#include<vector>
#include<map>

int fibo(int n)
{
	if (n <= 1)
		return 1;

	return fibo(n - 1) + fibo(n - 2);
}

int fib(int n)
{	
	if (n < 1)
		return 1;

	static std::map<int, int> hmap;

	if (hmap.find(n) != hmap.end())
	{
		std::cout << "n " << n << "->" << hmap[n] << "\n";
		return hmap[n];
	}
	int result = fib(n - 1) + fib(n - 2);
	hmap[n] = result;
	return result;

}


int mainFib()
{
	std::cout << fib(40);
	//std::cout << fibo(40);
	return 0;
}