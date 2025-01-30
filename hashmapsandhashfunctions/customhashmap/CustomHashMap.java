package hashmapsandhashfunctions.customhashmap;
import java.util.HashSet;
import java.util.LinkedList;

class CustomHashMap<K, V> {
    // Define the bucket size
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    // Constructor to initialize the table
    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to get index based on key
    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if the key already exists in the list and update it
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If key doesn't exist, add a new entry
        bucket.add(new Entry<>(key, value));
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for the key in the list
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // Return null if the key doesn't exist
        return null;
    }

    // Remove key-value pair by key
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for the key and remove the entry
        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Print the custom hash map for debugging
    public void print() {
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Create a Custom Hash Map
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Insert some key-value pairs
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);

        // Print the map
        map.print();

        // Retrieve a value by key
        System.out.println("Value for key 'Two': " + map.get("Two"));

        // Remove a key-value pair
        map.remove("Three");

        // Print the map again
        map.print();
    }
}
