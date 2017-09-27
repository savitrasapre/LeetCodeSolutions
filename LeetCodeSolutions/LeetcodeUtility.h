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
}


