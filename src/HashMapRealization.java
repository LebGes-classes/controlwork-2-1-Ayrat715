public class HashMapRealization<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked") // тк не подлежит проверке
    public HashMapRealization() {
        table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
    }

    public void put(K key, V value) {
        int index = key.hashCode() % DEFAULT_CAPACITY;

        if (table[index] == null) {
            table[index] = new Node<>(key, value);
        } else {
            Node<K, V> current = table[index];

            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            current.next = new Node<>(key, value);
        }
    }

    public V get(K key) {
        int index = key.hashCode() % DEFAULT_CAPACITY;

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public boolean containsKey(K key) {
        int index = key.hashCode() % DEFAULT_CAPACITY;

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> node : table) {
            Node<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    public void remove(K key) {
        int index = key.hashCode() % DEFAULT_CAPACITY;

        if (table[index] == null) {
            return;
        }

        Node<K, V> current = table[index];
        if (current.key.equals(key)) {
            table[index] = current.next;
            return;
        }

        Node<K, V> prev = current;
        current = current.next;

        while (current != null) {
            if (current.key.equals(key)) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public int size() {
        int count = 0;

        for (Node<K, V> node : table) {
            Node<K, V> current = node;
            while (current != null) {
                count++;
                current = current.next;
            }
        }

        return count;
    }
}

