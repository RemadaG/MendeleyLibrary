//============================================================================
// Name        : main.cpp
// Author      : 
// Version     :
// Copyright   : Paweł Zagórski
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "graph.h"
#include "reader.h"

using namespace std;

int main(int argc, char* argv[]) {
	reader publicationReader;
	graph* publicationMap;
	string keyWord;
	string fileName;
	char freqInt[50];
	int frequency;


	publicationMap = new graph;
	
	//publicationMap->setName("Publications");
	//publicationMap->addNode("a", "red");
	//publicationMap->addNode("b", "blue");
	//publicationMap->addEdge("pierwsza", "a", "b");
	//publicationMap->print();

	//publicationReader.getDocs("correctDocs.txt", publicationMap);
	//publicationReader.getRelated("relatedDocs.txt", publicationMap);

	if(argc != 3)
		cout << "Incorrect number of command line arguments " << argc-1 << endl;
	else {
		publicationReader.getDocs(argv[1], publicationMap);
		publicationReader.getRelated(argv[2], publicationMap);		
	}

	publicationMap->saveToFile("out.dot");

	return 0;
}
