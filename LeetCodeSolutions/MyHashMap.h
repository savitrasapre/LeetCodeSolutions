#include<iostream>

template<typename K,typename V>
class HashNode
{
public:
	K key;
	V val;
	HashNode(K key,V val)
	{
		this->key = key;
		this->val = val;
	}
};

template<typename K,typename V>
class MyHashMap
{
public:
	MyHashMap()
	{
		capacity = 20;
		size = 0;
		hmap = new HashNode<K, V>*[capacity];
		for (unsigned int i = 0; i < capacity; i++)
		{
			hmap[i] = NULL;
		}
		dummy = new HashNode<K, V>(-1, -1);
	}

	int hashFunction(K key)
	{
		return key % capacity;
	}

	void insert(K key,V value)
	{
		HashNode<K, V> * temp = new HashNode<K, V>(key, value);
		int hashIndex = hashFunction(key);

		while (hmap[hashIndex]!=NULL && hmap[hashIndex]->key!=key && hmap[hashIndex]->key!=-1)
		{
			hashIndex++;
			hashIndex %= capacity;
		}

		if (hmap[hashIndex] == NULL || hmap[hashIndex]->key == -1)
			size++;

		hmap[hashIndex] = temp;
	}

	V getValue(K key)
	{
		int hashIndex = hashFunction(key);
		while (hmap[hashIndex]!=NULL)
		{
			if (hmap[hashIndex]->key == key)
			{
				return hmap[hashIndex]->val;
			}
			hashIndex++;
			hashIndex %= capacity;
		}
		return NULL;
	}


	void display()
	{
		for (unsigned int i = 0; i < capacity; i++)
		{
			if (hmap[i] != NULL && hmap[i]->key != -1)
				std::cout << hmap[i]->key << " " << hmap[i]->val << "\n";
		}
	}

	unsigned int sizeOfMap()
	{
		return size;
	}

private:
	HashNode<K, V> **hmap;
	unsigned int size;
	unsigned int capacity;
	HashNode<K, V> *dummy;
};
