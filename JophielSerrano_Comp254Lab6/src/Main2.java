import java.util.ArrayList;
import java.util.Comparator;

class SortedTableMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();
    private Comparator<K> comparator;

    public SortedTableMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public boolean containsKey(K key) {
        int index = findIndex(key);
        return index >= 0 && index < table.size() && comparator.compare(key, table.get(index).getKey()) == 0;
    }

    // Other methods of SortedTableMap class...

    private int findIndex(K key) {
        // Binary search for the key
        int low = 0;
        int high = table.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = comparator.compare(key, table.get(mid).getKey());
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1); // Return a negative index to indicate not found
    }

    private static class MapEntry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
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
}

public class TestSortedTableMap {
    public static void main(String[] args) {
        testSortedTableMap();
    }

    public static void testSortedTableMap() {
        SortedTableMap<Integer, String> map = new SortedTableMap(Comparator.naturalOrder());

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("Contains key 2: " + map.containsKey(2)); // Should return true
        System.out.println("Contains key 4: " + map.containsKey(4)); // Should return false
    }
}
