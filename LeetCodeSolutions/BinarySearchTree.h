#include<iostream>
#include<algorithm>

template<typename T>
class BinarySearchTree
{
public:
	BinarySearchTree() : root(nullptr){}
	~BinarySearchTree();
	void breadthFirst();
	void depthFirst();
	bool insert(const T& value);
	bool remove(const T& value);
	bool find(const T& value);
private:
	struct node
	{
		T data;
		node* left, right;
		~node();
		node(const T& value, node* left = nullptr, node* right = nullptr)
			: data(value), left(left), right(right){}
		//copy constructor deep implementation
		node(const node<T> &other)
		{
			data = other.data;
			left = new node(other.left->data, other.left->left, other.left->right);
			right = new node(other.right->data, other.right->left, other.right->right);
		}
		node& operator=(node<T> &other)
		{
			swap(other);
			return *this;
		}
		void swap(node<T> &other)
		{
			std::swap(data, other.data);
			std::swap(left, other.left);
			std::swap(right, other.right);
		}
	};
	struct node* root;
};



