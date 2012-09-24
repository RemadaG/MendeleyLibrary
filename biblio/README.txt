
====================================================================

Instrukcja użytkowania modułu:

1) kompilacja:

	g++ reader.cpp graph.h reader.h graph.cpp main.cpp -o biblio

2) Uruchamianie

	./biblio correctDocs.txt relatedDocs.txt

3) Generowanie grafu:

dot out.dot -Tsvg -o out.svg
dot out.dot -Tpng -o out.png

gdzie:

"biblio" - nazwa pliku wykonywalnego, można skompilować z dowolną"
"correctDocs.txt - plik zawierający tytuł artykułów spełniające warunki
"relatedDocs.txt" - plik zawierający relacje pomiądzy artykułami
"out.dot" - domyślna nazwa pliku zawierającego opis grafu w języku dot
"-Tsvg" - flaga generująca graf w formacie wektorowym svg
"-Tpng" - flaga generująca graf w formacie png

=====================================================================
