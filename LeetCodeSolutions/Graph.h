#include<iostream>
#include<vector>
#include<map>
#include<stack>
#include<queue>
#include<algorithm>

template<typename dataType, typename weightType = size_t>
class Graph
{
private:
	struct edge
	{	
		edge(dataType vertex, weightType weight)
		: vertex(vertex), weight(weight){}
		dataType vertex;
		weightType weight;
	};

	std::vector<std::vector<edge>> vertices;
	std::map<dataType, weightType> indexMap;
	bool isWeighted;
	bool hasNegWeights;
	size_t capacity;
	size_t size;

public:
	Graph();
	Graph(const Graph& other);
	~Graph();
	Graph& operator=(Graph other);
	bool insertEdge(const dataType& src,const dataType& dest);
	bool insertEdge(const dataType& src,const dataType& dest,const weightType& weight);
	bool insertVertex(const dataType& newVertex);
	bool BreadthFirstSearch(const dataType& from);
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
	vertices.push_back(std::vector<edge>());
	return true;
}

template<typename dataType, typename weightType>
bool Graph<dataType, weightType>::insertEdge(const dataType& src, const dataType& dest)
{
	//if unweighted then add default edge as 1.
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

template<typename dataType,typename weightType>
bool Graph<dataType, weightType>::BreadthFirstSearch(const dataType& from)
{
	std::queue<std::pair<dataType, weightType>> bfsQueue;
	std::vector<bool> visited(size, false);

	//pushing the from vertex
	bfsQueue.push(std::pair<dataType, weightType>(from, 0));

	visited[indexMap[from]] = true;


	while (!bfsQueue.empty())
	{
		dataType vertex = bfsQueue.front().first;
		weightType pathWt = bfsQueue.front().second;
		int index = indexMap[vertex];
		std::cout << vertex << "\n";
		bfsQueue.pop();
		for (std::vector<edge>::iterator it = vertices[index].begin(); it!=vertices[index].end(); ++it)
		{
			if (!visited[indexMap[it->vertex]])
			{
				bfsQueue.push(std::pair<dataType, weightType>(it->vertex, 1 + pathWt));
				visited[indexMap[it->vertex]] = true;
			}
		}

	}
	return true;
}

