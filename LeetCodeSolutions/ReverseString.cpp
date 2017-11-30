#include<iostream>
#include<string>

void swap(char& a, char& b)
{
	char tempChar = a;
	a = b;
	b = tempChar;
}

void reverse(std::string& str)
{
	for (int i = 0,j=str.length()-1; i < str.length()/2; i++,j--)
	{
		swap(str[i], str[j]);
	}
	std::cout << str<<"\n";
}

int mainReverseString()
{
	std::string str = "stri";
	reverse(str);
	return 0;
}