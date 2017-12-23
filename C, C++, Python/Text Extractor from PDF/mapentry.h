#ifndef MAPENTRY
#define MAPENTRY

#include <iostream>

template <class K, class V>
class MapEntry {
    K key;
    V value;
public:
    MapEntry() = default;
    MapEntry(K key, V value);
    ~MapEntry() {}

    K get_key() const;
    V get_value() const;
    void set_key(K key);
    void set_value(V value);

    template <class Key, class Value>
    friend bool operator<(const MapEntry<Key, Value> &right, const MapEntry<Key, Value> &left);

    template <class Key, class Value>
    friend std::ostream &operator<<(std::ostream &os, const MapEntry<Key, Value> &entry);
};

template <class K, class V>
MapEntry<K, V>::MapEntry(K key, V value) {
    this->key = key;
    this->value = value;
}

template <class K, class V>
K MapEntry<K, V>::get_key() const {
    return key;
}

template <class K, class V>
V MapEntry<K, V>::get_value() const {
    return value;
}

template <class K, class V>
void MapEntry<K, V>::set_key(K key) {
    this->key = key;
}

template <class K, class V>
void MapEntry<K, V>::set_value(V value) {
    this->value = value;
}

template <class K, class V>
bool operator<(const MapEntry<K, V> &right, const MapEntry<K, V> &left) {
    return right.value < left.value;
}

template <class K, class V>
std::ostream &operator<<(std::ostream &os, const MapEntry<K, V> &entry) {
    os << "key: " << entry.key << ", value: " << entry.value;
    return os;
}

#endif
