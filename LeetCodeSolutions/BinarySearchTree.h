#include<iostream>
#include<algorithm>

enum BinarySearchTreePrintOrder
{
	PreOrder,
	InOrder,
	PostOrder
};

struct BinarySearchTreeManipulator
{
	BinarySearchTreePrintOrder o;
};

static BinarySearchTreeManipulator m;

BinarySearchTreePrintOrder getPrintOrder()
{
	return m.o;
}

BinarySearchTreeManipulator setPrintOrder(BinarySearchTreePrintOrder o)
{
	m.o = o;
	return m;
}

std::ostream& operator<<(std::ostream& out, BinarySearchTreeManipulator)
{
	return out;
}

template<typename T>
class BinarySearchTree
{
private:
	struct Node
	{
		T data;
		Node* left;
		Node* right;
		~Node()
		{
			delete left;
			delete right;
		}
		Node(const T& value)
			: data(value), left(nullptr), right(nullptr){}
	};
public:
	BinarySearchTree() : root(nullptr){}
	~BinarySearchTree()
	{
		delete root;
	}
	
	bool insert(const T& value)
	{
		//value already there, then don't insert it.
		if (find(root, value) != nullptr)
			return false;

		Node* node = new Node(value);
		Node* temp;
		node->left = nullptr;
		node->right = nullptr;

		if (isBSTEmpty())
		{
			root = node;
			return false;
		}
		else
		{
			Node* current = root;
			while (current)
			{
				temp = current;
				if (node->data < current->data)
					current = current->left;
				else
					current = current->right;
			}

			if (node->data < temp->data)
				temp->left = node;
			else
				temp->right = node;
		}
		return true;
	}

	Node* find(Node* root,const T& value)
	{
		if (root == nullptr || value == root->data)
			return root;

		if (value < root->data)
			find(root->left, value);
		else
			find(root->right, value);
	}

	friend std::ostream& operator<<(std::ostream& out, BinarySearchTree const& tree)
	{
		if (getPrintOrder() == InOrder)
			tree.inOrder(tree.root, out);
		else if (getPrintOrder() == PostOrder)
			tree.postOrder(tree.root, out);
		else
			tree.preOrder(tree.root, out);

		return out;
	}

	void inOrder(Node* node, std::ostream& out) const
	{
		if (node != nullptr)
		{
			if(node->left)
				inOrder(node->left, out);
			out << " " << node->data;
			if(node->right)
				inOrder(node->right, out);
		}
	}
	void preOrder(Node* node, std::ostream& out) const
	{
		if (node!= nullptr)
		{
			out << " " << node->data;
			if(node->left)
				preOrder(node->left, out);
			if(node->right)
				preOrder(node->right, out);
		}
	}

	void postOrder(Node* node, std::ostream& out) const
	{
		if (node!= nullptr)
		{
			out << " " << node->data;
			if(node->right)
				postOrder(node->right, out);
			if(node->left)
				postOrder(node->left, out);
		}
	}

	bool isBSTEmpty()
	{
		return root == nullptr;
	}

	Node* root;

	
};




