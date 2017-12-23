#include <iostream>
#include <vector>

#include <podofo/podofo.h>

#include "pdftextextractor.h"
#include "map.h"

using namespace std;
using namespace PoDoFo;

int main(int argc, char *argv[]){
	if (argc == 1)
		return 1;
	Map<string, int> *map = new Map<string, int>();
	vector<string> words = extract(argv[1]);
	map->set_descending_order(true);
	for (string word: words){
		int *value = map->find_value(word);
		if (value)
			map->remap_key(word, *value+1);
		else
			map->add_entry(word, 1);
		delete value;
	}
	cout << *map << endl;
	delete map;
		
    return 0;
}
