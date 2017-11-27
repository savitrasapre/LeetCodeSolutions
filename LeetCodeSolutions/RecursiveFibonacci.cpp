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
	static std::map<int, int> hmap;
	if (n <= 1)
		return 1;

	if (hmap.find(n) != std::end(hmap))
	{
		std::cout << "Found in map" << n << "->" << hmap[n] << "\n";
		return hmap[n];
	}
	int res = fib(n - 1) + fib(n - 2);
	hmap[n] = res;
	return res;
}


int main()
{
	std::cout << fib(40);
	//std::cout << fibo(40);
	return 0;
}