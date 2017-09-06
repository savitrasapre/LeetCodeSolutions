#include<iostream>
#include "LinkedList.h"


int main()
{
	LinkedList list;
	list.insert(15);
	list.insert(14);
	list.insert(13);
	list.insert(12);
	std::cout << list.size;
	list.display();

	return 0;

}