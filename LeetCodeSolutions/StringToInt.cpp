#include<iostream>
#include<vector>
#include "LeetcodeUtility.h"
#include<math.h>

/*25
2-0    50-48 = 2
5-0    53-48 = 5
*/

int stringToInt(std::string inp)
{
	int size = inp.length();
	int result = 0;
	//pow(x,y) works for double. So, to use it for int we need to add 0.5 and then cast to (int).
	for (int i = 0,j=size-1; i < size,j>0; i++,j--)
	{
		result += (int)(pow(10, j)+0.5) * (inp[i]-'0');
	}
	return result;
}


