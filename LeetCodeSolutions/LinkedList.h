#include<iostream>

template<typename T>
class LinkedList
{
public:
	LinkedList();
	~LinkedList();
	void insert(T val);
	void display();
	int size = 0;
private:
	struct node
	{
		T data;
		node* next;
	};
	struct node* head = NULL;
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
	while (temp != NULL)
	{
		std::cout << temp->data<<"\n";
		temp = temp->next;
	}
}
