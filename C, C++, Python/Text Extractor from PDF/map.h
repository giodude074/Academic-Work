#ifndef MAP
#define MAP

#include <algorithm>
#include <vector>

#include "mapentry.h"

template <class K, class V>
class Map {
    std::vector<MapEntry<K, V>> pairs;
	bool descending;
public:
    Map() = default;
    ~Map() {}

    void add_entry(K key, V value);
    void add_entry(MapEntry<K, V> entry);
    void delete_entry(K key);
    V *find_value(K key);
    void remap_key(K key, V value);
	void set_descending_order(bool descending);
    template <class Key, class Value>
    friend std::ostream &operator<<(std::ostream &os, const Map<Key, Value> &map);
};

template <class K, class V>
void Map<K, V>::add_entry(K key, V value) {
    add_entry(MapEntry<K, V>(key, value));
}

template <class K, class V>
void Map<K, V>::add_entry(MapEntry<K, V> entry) {
    V *found_value = find_value(entry.get_key());

    if (!(found_value)) {
        pairs.push_back(entry);
        delete found_value;
    }
	if(descending)
		std::sort(pairs.rbegin(), pairs.rend());
	else
		std::sort(pairs.begin(), pairs.end());
}

template <class K, class V>
void Map<K, V>::delete_entry(K key) {
    std::vector<int> matches;

    for (int i = 0; i < pairs.size(); i++)
        if (pairs[i].get_key() == key)
            matches.push_back(i);

    for (int i = 0; i < matches.size(); i++)
        pairs.erase(matches[i]);
}

template <class K, class V>
V *Map<K, V>::find_value(K key) {
    for (MapEntry<K, V> pair : pairs) {
        if (pair.get_key() == key) {
            V *value = new V;
            *value = pair.get_value();

            return value;
        }
    }

    return nullptr;
}

template <class K, class V>
void Map<K, V>::remap_key(K key, V value) {
    for (MapEntry<K, V> &pair : pairs) {
        if (pair.get_key() == key) {
            pair.set_value(value);
            break;
        }
    }
}

template <class K, class V>
void Map<K, V>::set_descending_order(bool descending){
	this->descending = descending;
}

template <class K, class V>
std::ostream &operator<<(std::ostream &os, const Map<K, V> &map) {
    for (MapEntry<K, V> pair : map.pairs)
        os << pair << std::endl;
    return os;
}

#endif
