#include<iostream>

#define MAX 1000

template<typename T>
class MyStack
{
private:
	T top;
public:
	MyStack()
	{
		top = -1;
	}
	T s[MAX];
	size_t size = 0;
	bool push(T value);
	T pop();
	bool isEmpty();
	void display();
};

template<typename T>
bool MyStack<T>::isEmpty()
{
	return size == 0 ? true : false;
}

template<typename T>
bool MyStack<T>::push(T val)
{
	if (top >= MAX)
	{
		std::cout << "Overflow!" << "\n";
		return false;
	}
	else
	{
		s[++top] = val;
		size++;
		return true;
	}
}

template<typename T>
T MyStack<T>::pop()
{
	if (top < 0)
	{
		std::cout << "Underflow!" << "\n";
		return 0;
	}
	else
	{
		size--;
		T temp = s[top--];
		return temp;
	}
}

template<typename T>
void MyStack<T>::display()
{
	for (int i = 0; i <= top;i++)
	{
		std::cout << s[i] << "\n";
	}
}
