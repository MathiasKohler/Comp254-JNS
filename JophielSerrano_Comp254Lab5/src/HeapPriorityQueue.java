import java.util.ArrayList;

public class HeapPriorityQueue<K extends Comparable<K>, V> {

    private ArrayList<Entry<K, V>> data;

    public HeapPriorityQueue() {
        data = new ArrayList<>();
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void upheap(int j) {
        if (j > 0) {
            int parent = (j - 1) / 2;
            if (data.get(j).key.compareTo(data.get(parent).key) < 0) {
                // Swap elements
                Entry<K, V> temp = data.get(j);
                data.set(j, data.get(parent));
                data.set(parent, temp);

                // Recur
                upheap(parent);
            }
        }
    }

    // Other methods of HeapPriorityQueue...

    public void add(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        data.add(newEntry);
        upheap(data.size() - 1);
    }

    public static void main(String[] args) {
        HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue<>();
        heap.add(5, "apple");
        heap.add(3, "banana");
        heap.add(7, "orange");
        heap.add(1, "grape");

        for (Entry<Integer, String> entry : heap.data) {
            System.out.println(entry.key + ": " + entry.value);
        }
    }
}
