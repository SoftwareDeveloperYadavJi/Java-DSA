package GFGPRACTICE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class HashTable<K, V> {
    private int size;
    private List<List<KeyValuePair<K, V>>> table;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.table.add(new LinkedList<>());  // Initialize each bucket as a linked list
        }
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % size);  // Simple hash function using modulus
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        List<KeyValuePair<K, V>> bucket = table.get(index);
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);  // Update value if key already exists
                return;
            }
        }
        bucket.add(new KeyValuePair<>(key, value));  // Insert new key-value pair
    }

    public V get(K key) {
        int index = hashFunction(key);
        List<KeyValuePair<K, V>> bucket = table.get(index);
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();  // Return value if key is found
            }
        }
        return null;  // Key not found
    }

    public void remove(K key) {
        int index = hashFunction(key);
        List<KeyValuePair<K, V>> bucket = table.get(index);
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                bucket.remove(pair);  // Remove key-value pair if key is found
                return;
            }
        }
    }
}

public class HashFunctionPractice {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Insert key-value pairs
        hashTable.put("apple", 10);
        hashTable.put("banana", 20);
        hashTable.put("orange", 30);

        // Retrieve values by key
        System.out.println("Value for 'apple': " + hashTable.get("apple"));  // Output: 10
        System.out.println("Value for 'banana': " + hashTable.get("banana"));  // Output: 20
        System.out.println("Value for 'orange': " + hashTable.get("orange"));  // Output: 30

        // Update value for existing key
        hashTable.put("banana", 25);
        System.out.println("Updated value for 'banana': " + hashTable.get("banana"));  // Output: 25

        // Try to retrieve value for non-existing key
        System.out.println("Value for 'grape': " + hashTable.get("grape"));  // Output: null

        // Remove a key-value pair
        hashTable.remove("orange");
        System.out.println("Value for 'orange' after removal: " + hashTable.get("orange"));  // Output: null
    }
}
