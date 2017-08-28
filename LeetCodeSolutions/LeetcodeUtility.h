#include<vector>

	template<typename T>
	 class LeetcodeUtility
	{
	public:
		static void printArray(std::vector<T>& arr)
		{
			std::cout << "Elements are :" << "\n";
			for (T i : arr)
				std::cout << i << "\n";
		}
	private:

	};



