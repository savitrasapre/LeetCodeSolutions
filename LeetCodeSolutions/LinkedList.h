#include<iostream>

class LinkedList
{
public:
	LinkedList();
	~LinkedList();
	void insert(int val);
	void display();
	int size = 0;
private:
	struct node
	{
		int data;
		node* next;
	};
	struct node* head = NULL;
};

LinkedList::LinkedList()
{

}

LinkedList::~LinkedList()
{

}

void LinkedList::insert(int value)
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

void LinkedList::display()
{
	node* temp = head;
	std::cout << "Elements of LinkedList are: " << "\n";
	while (temp != NULL)
	{
		std::cout << temp->data<<"\n";
		temp = temp->next;
	}
}
