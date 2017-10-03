#include<iostream>
#include<vector>
#include<map>
#include<algorithm>

template<typename dataType, typename weightType = int>
class Graph
{
private:
	struct edge
	{
		dataType vertex;
		weightType weight;
		edge(dataType& vertex, weightType& weight)
		: vertex(vertex), weight(weight){}
	};

	std::vector<vector<edge>> vertices;
	std::map<dataType, int> indexMap;
	bool isWeighted;
	bool hasNegWeights;
	int capacity;
	int size;

public:
	Graph();
	Graph(const Graph& other);
	~Graph();
	Graph& operator=(Graph other);
	bool insertEdge(const dataType& src,const dataType& dest);
	bool insertEdge(const dataType& src,const dataType& dest,const weightType& weight);
	bool insertVertex(const dataType& newVertex);
};

template<typename datatype,typename weightType>
Graph<datatype,weightType>::Graph()
: size(0), isWeighted(false), hasNegWeights(false)
{
	capacity = vertices.capacity();
}

template<typename datatype, typename weightType>
Graph<datatype,weightType>::~Graph()
{
}

template<typename dataType,typename weightType>
Graph<dataType, weightType>::Graph(const Graph& other)
: vertices(other.vertices), indexMap(other.indexMap)
{
	size = vertices.size();
	capacity = vertices.capacity();
}

template<typename dataType,typename weightType>
Graph<dataType, weightType>& Graph<dataType, weightType>::operator=(Graph other)
{
	std::swap(vertices, other.vertices);
	std::swap(indexMap, other.indexMap);
	size = vertices.size();
	capacity = vertices.capacity();
}

template<typename dataType, typename weightType>
bool Graph<dataType, weightType>::insertVertex(const dataType& vertex)
{
	indexMap[vertex] = size++;
	vertices.push_back(vector<edge>());
	return true;
}

template<typename dataType, typename weightType>
bool Graph<dataType, weightType>::insertEdge(const dataType& src, const dataType& dest)
{
	return insertEdge(src, dest, 1);
}

template<typename dataType, typename weightType>
bool Graph<dataType, weightType>::insertEdge(const dataType& src, const dataType& dest, const weightType& weight)
{
	if (weight != 1)
		isWeighted = true;
	if (weight < 0)
		hasNegWeights = true;

	if (!indexMap.count(src))
		insertVertex(src);
	if (!indexMap.count(dest))
		insertVertex(dest);

	vertices[indexMap[src]].push_back(edge(dest, weight));
	return true;
}



