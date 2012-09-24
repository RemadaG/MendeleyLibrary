/*
 * reader.h
 *
 *  Created on: Sep 07, 2012
 */

#ifndef READER_H_
#define READER_H_

#include <string.h>
#include <iostream>
#include <list>
#include "graph.h"

using namespace std;

class reader {

	public:
		reader();
		virtual ~reader();
		bool getRelated(string file, graph* parsedGraph);
		bool getAutors(string file, graph* parsedGraph);
		bool getDocs(string file, graph* parsedGraph);

	private:
		;
};

#endif /* GRAPH_H_ */
