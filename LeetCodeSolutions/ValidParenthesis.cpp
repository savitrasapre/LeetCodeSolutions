#include<iostream>
#include<string>
#include<stack>
#include "LeetcodeUtility.h"


bool isValidString(std::string s)
{
	std::stack<char> checker;

	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == '(' || s[i] == '{' || s[i] == '[')
			checker.push(s[i]);
		else
		{
			if (checker.empty()) return false;
			if (s[i] == ')' && checker.top() != '(') return false;
			if (s[i] == '}' && checker.top() != '{') return false;
			if (s[i] == ']' && checker.top() != '[') return false;
			checker.pop();	//this is when the matching parenthesis is found
		}
	}

	return checker.empty();

}


int IsValidParenthesisMain()
{
	std::string inputStr = "(){}{}[]";
	std::cout << isValidString(inputStr);
	return 0;
}