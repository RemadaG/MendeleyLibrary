/*
 * graph.cpp
 *
 *  Created on: Sep 22, 2011
 *      Author: Paweł Zagórski
 */

#include "graph.h"
#include <fstream>
#include <iostream>

graph::graph()
{
	minFrequency = 1;
	maxFrequency = 1;
}

graph::~graph()
{
}

unsigned long  graph::hash(string text)
{
	unsigned long hash = 5381;
	int c;
	for (int i = 0; i < text.length(); i++){
		c = tolower(text.at(i));
		if ((char)c == '\n' or (char)c == '\r') break;
			hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
	}
	return hash;
}

string graph::getName() const
{
    return name;
}

void graph::setName(string name)
{
    this->name = name;
}

void graph::addEdge(string name, string origin, string destination)
{
	edge newEdge;
	newEdge.name = name;
	newEdge.origin = hash(origin);
	newEdge.destination = hash(destination);
	edges.push_back(newEdge);
}

void graph::addNode(string name, int frequency, string color)
{
	node newNode;
	newNode.hash = hash(name);
	newNode.name = name;
	newNode.color = color;
	newNode.frequency = frequency;
    if(this->maxFrequency < frequency)
		this->maxFrequency = frequency;
	nodes.push_back(newNode);
}

void graph::print()
{
	list<edge>::iterator	eIter;
	list<node>::iterator	nIter;

	// Open DOT graph
	cout << "digraph " << name << " {\n";

	// B [label="The boss"]      // node B
	for (nIter = nodes.begin(); nIter != nodes.end(); nIter++){
                cout << "\t" << (*nIter).hash << " [label=\"" << (*nIter).name << "\", color=\""<< (*nIter).color << "\"]\n";
        }

	// a -> b [label="100 times"];
	for (eIter = edges.begin(); eIter != edges.end(); eIter++){
                cout << "\t" << (*eIter).origin << " -> " << (*eIter).destination << " [label=\"" << (*eIter).name << "\"]\n";
        }
	// Close DOT graph
	cout << "}\n";
}

void graph::saveToFile(string file)
{
	bool originOK;
	bool destinationOK;
	unsigned long originHash;
	unsigned long destinationHash;
	ofstream myfile;
	list<edge>::iterator	eIter;
	list<node>::iterator	nIter;

	myfile.open(file.c_str());	
	if (!myfile.is_open())
		cout << "Nie udało się otworzyć pliku: "<< file << endl;
	else {
		// Open DOT graph
		myfile << "digraph " << name << " {\n\trankdir=LR;\n";

		for (int i = minFrequency; i <= maxFrequency; i++){
			myfile << "\t" << i << " [label=\"" << i << "\",fontcolor=blue, fontsize=24, color=blue, shape=circle, style=bold]\n";
		}

		// B [label="The boss"]      // node B
		for (nIter = nodes.begin(); nIter != nodes.end(); nIter++){
			if ((*nIter).frequency >= this->minFrequency)
				myfile << "\t" << (*nIter).hash << " [label=\"" << (*nIter).name << "\", color=\""<< (*nIter).color << "\"fontsize=" << 10 + 2 * (*nIter).frequency << ", shape=box, style=bold]\n";
		}

		// frequency -> b [label="The boss"]      // node B
		for (nIter = nodes.begin(); nIter != nodes.end(); nIter++){
			myfile << "\t" << (*nIter).frequency  << " -> " << (*nIter).hash << " [label=\"" << "frequency" << "\", color=blue, style=dashed]\n";
		}

		// a -> b [label="100 times"];
		for (eIter = edges.begin(); eIter != edges.end(); eIter++){
			originOK = false;
			destinationOK = false;
			originHash = (*eIter).origin;
			destinationHash = (*eIter).destination;
			//cout << "Checking edge: " << originHash << " -> " << destinationHash << endl;
			for (nIter = nodes.begin(); nIter != nodes.end(); nIter++){
				//cout << "\t>" << (*nIter).hash << " frequency = " << (*nIter).frequency << "(" << this->minFrequency << ")" << endl;
				if ((*nIter).hash == originHash && (*nIter).frequency >= this->minFrequency){
					//cout << "zupa\n";
					originOK = true;
					//break;
				}
			}
			for (nIter = nodes.begin(); nIter != nodes.end(); nIter++){
				//cout << "\t>" << (*nIter).hash << " frequency = " << (*nIter).frequency << "(" << this->minFrequency << ")" << endl;
				if ((*nIter).hash == destinationHash && (*nIter).frequency >= this->minFrequency){
					//cout << "kotlet(" << (*nIter).hash << " == " << destinationHash << endl;
					destinationOK = true;
					//break;
				}
			}
			if (originOK && destinationOK)
				myfile << "\t" << (*eIter).origin << " -> " << (*eIter).destination << " [label=\"" << (*eIter).name << "\"]\n";
		}
		// Close DOT graph
		myfile << "}\n";
	}
	myfile.close();
}
