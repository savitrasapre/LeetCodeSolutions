#include<iostream>
#include<string>
#include<algorithm>

/* The problem states that Uppercase, whitespaces and anything other than alphanumeric chars are to be ignored.*/
bool isPalindrome(std::string s)
{
	if (s.empty()) return true;

	int j = s.length()-1;
	int i = 0;

	while (i > j)
	{
		if (!isalnum(s[i]))
			i++;
		else if (!isalnum(s[j]))
			j--;
		else
		{
			if (toupper(s[i++]) != toupper(s[j--]))
				return false;
		}
		
	}

	return true;
}

int IsPalindromeMain()
{
	std::string inputStr = "A man, a plan, a canal: Panama";
	std::cout << isPalindrome(inputStr);
	return 0;
}