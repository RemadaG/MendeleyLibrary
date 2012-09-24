/*
 * graph.cpp
 *
 *  Created on: Sep 07, 2012
 */

#include "graph.h"
#include "reader.h"
#include <iostream>
#include <fstream>

reader::reader()
{
}

reader::~reader()
{
}

bool reader::getRelated(string file, graph* parsedGraph)
{
	ifstream myfile;
	bool result = true;
	char value[512];
	string from;
	string to;

	myfile.open(file.c_str());	
	if (!myfile.is_open()){
		cout << "Nie udało się otworzyć pliku: "<< file << endl;
		result = false;
	} else {
		while (1){
			myfile.getline(value,512);
			//cout << value << "\n";
		 	if (myfile.eof()){
				break;
			}
			if(value[0] == '>'){
				to = (value + 2);
				//cout << "TO:\t" << to << endl;
				parsedGraph->addEdge("", from, to);
			}
			else if (value[0] != '\n'){
				from = value;
				//cout <<"FROM:\t" << from << endl;
			}
		}
	}
	myfile.close();
	return result;
}

bool reader::getDocs(string file, graph* parsedGraph)
{
	bool result = true;
	string value;
	string title;
	string author;
	char letter;
	ifstream myfile;
	int countBooks;
	int countAuthors;
    int reading;
	int frequency;

	myfile.open(file.c_str());	
	if (!myfile.is_open()){
		cout << "Nie udało się otworzyć pliku: "<< file << endl;
		result = false;
	} else {
		//skipping book preample
		for(int i = 1;i<=3;i++){ 
			myfile >> value;
		}
		//reading number of books
		myfile >> countBooks;
		cout << "Liczba książek:" << "\t"<< countBooks << endl;
		//skipping titles preample
		//for(int i = 1;i<=6;i++){ 
		//	myfile >> value;
		//}
		//read books
		reading = 1;
		for(int i = 1;i <= countBooks;i++){ 
			title = "";
			while (1){
				myfile >> value;
			    if (myfile.eof()){
					reading = 0;
					break;
				}
				if (value == "|") {
					cout << i << ": "<< title << endl;
					break;
				}
				if (title != "")
					title = title + " ";
				title = title + value;	
			}
			if (reading){
				while (1){
					myfile >> value;
					if (value == "Autor:"){
						letter = letter = myfile.get();
						author = "";
						while (letter != ','){
							author = author + letter;
							letter = myfile.get();
						}
						cout << "\t\t"<< author << endl;
						parsedGraph->addNode(author, -1, "blue");
						parsedGraph->addEdge("", author, title);
					}
					else
						break;
				}
				//reading frequency info
				myfile >> frequency;	
				parsedGraph->addNode(title, frequency, "red");	
			}
		}
		//for(int i = 1;i<15;i++){ 
		//	myfile >> value;
		//	cout << i << "\t"<< value << endl;
		//}
	}
	myfile.close();
	return result;
}

bool reader::getAutors(string file, graph* parsedGraph)
{
	bool result = true;
	string value;
	string title;
	string author;
	char letter;
	ifstream myfile;
	int countBooks;
	int countAuthors;
    int reading;

	myfile.open(file.c_str());	
	if (!myfile.is_open()){
		cout << "Nie udało się otworzyć pliku: "<< file << endl;
		result = false;
	} else {
		//skipping book preample
		//for(int i = 1;i<=3;i++){ 
		//	myfile >> value;
		//}
		//reading number of books
		//myfile >> countBooks;
		//cout << "Liczba książek:" << "\t"<< countBooks << endl;
		//skipping titles preample
		//for(int i = 1;i<=6;i++){ 
		//	myfile >> value;
		//}
		//read books
		reading = 1;
		for(int i = 1;reading;i++){ 
			title = "";
			while (1){
				myfile >> value;
			    if (myfile.eof()){
					reading = 0;
					break;
				}
				if (value == "|") {
					cout << i << ": "<< title << endl;
					break;
				}
				if (title != "")
					title = title + " ";
				title = title + value;	
			}
			if (reading){
				parsedGraph->addNode(title, 0, "red");
				while (1){
					myfile >> value;
					if (value == "Autor:"){
						letter = letter = myfile.get();
						author = "";
						while (letter != ','){
							author = author + letter;
							letter = myfile.get();
						}
						cout << "\t\t"<< author << endl;
						parsedGraph->addNode(author, -1, "blue");
						parsedGraph->addEdge("", author, title);
					}
					else
						break;
				}
				//skipping frequency info
				for(int i = 1;i<3;i++)
					myfile >> value;		
			}
		}
		//for(int i = 1;i<15;i++){ 
		//	myfile >> value;
		//	cout << i << "\t"<< value << endl;
		//}
	}
	myfile.close();
	return result;
}

