/*
 * graph.h
 *
 *  Created on: Sep 22, 2011
 */

#ifndef GRAPH_H_
#define GRAPH_H_

#include <string.h>
#include <iostream>
#include <list>

using namespace std;

struct edge{
	string name;
	unsigned long  origin;
	unsigned long  destination;
};

struct node{
	unsigned long  hash;
	string name;
	int frequency;
	string color;
};

class graph {

	public:
		graph();
		virtual ~graph();
		string getName() const;
		void setName(string name);
		void addEdge(string name, string origin, string destination);
		void addNode(string name, int frequency, string color);
		void print();
		void saveToFile(string file);

		int minFrequency;
		int maxFrequency;

	private:
		string name;
		int edgesCount;
		list<edge> edges;
		int nodesCount;
		list<node> nodes;
		unsigned long hash(string str);
};

#endif /* GRAPH_H_ */
