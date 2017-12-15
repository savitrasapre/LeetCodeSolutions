#include<vector>
namespace utility
{
	template<typename T>
		void printArray(std::vector<T>& arr)
		{
			std::cout << "Elements are :" << "\n";
			for (T i : arr)
				std::cout << i << "\n";
		}
	
	template<typename T>
	void printArray(T& arr,int size)
	{
		std::cout << "Elements are :" << "\n";
		int i = 0;
		while (i < size)
		{
			std::cout << arr[i] << "\n";
			i++;
		}
	}
}


