#include<iostream>

template<typename T>
class LinkedList
{
public:
	LinkedList();
	~LinkedList();
	void insert(T val);
	void display();
	void reverse();
	void deleteNode(T val);
	void deleteDuplicates();
	bool isPalindrome();
	int size = 0;
private:
	struct node
	{
		T data;
		node* next;
	};
	struct node* head = nullptr;
};

template<typename T>
LinkedList<T>::LinkedList()
{

}

template<typename T>
LinkedList<T>::~LinkedList()
{

}

template<typename T>
void LinkedList<T>::insert(T value)
{
	node* temp = new node;
	temp->data = value;
	temp->next = NULL;

	if (head == NULL)
	{
		head = temp;
	}
	else
	{
		node* tempp = new node;
		tempp = head;
		while (tempp->next != NULL)
		{
			tempp = tempp->next;
		}
		tempp->next = temp;
	}
	LinkedList::size++;
}

template<typename T>
void LinkedList<T>::display()
{
	node* temp = head;
	std::cout << "Elements of LinkedList are: " << "\n";
	while (temp != nullptr)
	{
		std::cout << temp->data<<"\n";
		temp = temp->next;
	}
}

template<typename T>
void LinkedList<T>::reverse()
{	
	/* The idea here is to def another prev pointer which acts as a lazy pointer which stores the address of the previous node
		We also want to move the current pointer to the next node. But, we have already changed the link to point to the previous node
		and cannot go ahead untill we store the value in another pointer temp.
	*/

	node* current = head;
	node* prev = nullptr;
	node* temp;

	while (current != nullptr)
	{
		temp = current->next;
		current->next = prev;
		prev = current;
		current = temp;
	}
	head = prev;
	
}
template<typename T>
void LinkedList<T>::deleteNode(T value)
{
	// 1->2->3->4->5->null
	node* current = new node;
	node* previous = new node;
	previous = head;
    current = head;
	if (current->data == value)
	{
		if (current->next != nullptr)
		{
			current = current->next;
			head = current;
			return;
		}
		else
			std::cerr << "Only one element in the list, cannot delete it.";
	}
	while (current!=nullptr)
	{
		if (current->data == value)
		{
			previous->next = current->next;
			delete current;
			return;
		}
		else
		{
			previous = current;
			current = current->next;
		}
	}

}

template<typename T>
void LinkedList<T>::deleteDuplicates()
{
	node* current = head;
	while (current->next!=nullptr && current!=nullptr)
	{
		if (current->data == current->next->data)
		{
			current->next = current->next->next;
		}
		else
			current = current->next;
	}

}

template<typename T>
bool LinkedList<T>::isPalindrome()
{

	/*
	The idea is to make a fast pointer that jumps ahead and the slow pointer reverses the list. Then we compare the slow and previous pointers to see if they have the same value or not.
	*/
	node* fast = head;
	node* slow = head;
	node* prev = NULL;

	while (fast && fast->next)
	{
		fast = fast->next->next;
		node* temp = slow->next;
		slow->next = prev;
		prev = slow;
		slow = temp;
	}
	if (fast)
		slow = slow->next;
	while (slow && prev)
	{
		if (slow->data == prev->data)
			continue;
		else
			return false;
		slow = slow->next;
		prev = prev->next;
	}

	return true;
}

