#include<iostream>
#include "LinkedList.h"


int main()
{
	LinkedList<int> list1;
	list1.insert(15);
	list1.insert(14);
	list1.insert(13);
	list1.insert(12);
	list1.insert(12);
	LinkedList<char> list2;
	list2.insert('a');
	list2.insert('b');
	std::cout << list2.size;
	list2.display();
	std::cout << list1.size;
	list1.display();

	return 0;

}