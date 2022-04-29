package joshuagrant;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class JGHashMap<K, V> implements Map<K, V> {
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    private static final int INITIAL_CAPACITY = 31;
    private static final double LOAD_FACTOR = 0.8;
    private final Entry<K, V> deletedEntry = new Entry<>(null, null);
    private Entry[] entries;
    private int numKeys;
    private int numDeleted;

    public JGHashMap() {
        entries = new Entry[INITIAL_CAPACITY];
        numKeys = 0;
        numDeleted = 0;
    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        //1. hash the key, mod it
        //2. check the index
        //3. check further ones
        //4. if we find it, return true
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        //Iterate through everything and check the value
        return false;
    }

    @Override
    public V get(Object key) {
        //1. hash the key, mod it
        //2. check the index
        //3. check further ones
        //4. if the key matches, return the value
        return null;
    }

    @Override
    public V put(K key, V value) {
        //1. crete new entry with K & V
        //2. hash the key, mod it
        //3. check the index
        //4. check further ones
        //5. if the index is empty, add the value
        //6. increment numKeys
        //7. check threshold
        return null;
    }

    @Override
    public V remove(Object key) {
        //2. hash the key, mod it
        //3. check the index
        //4. check further ones
        //5. if the key matches, replace entry with dummy entry
        //6. decrement numKeys
        //7. increment numDeleted
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    private void rehash() {
        Entry<K, V>[] oldEntries = entries;
        entries = new Entry[entries.length*2];
        numKeys = 0;
        numDeleted = 0;
        for (Entry<K, V> e : oldEntries) {
            if (e != null && e.key != null) {
                put(e.key, e.value);
            }
        }
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }
}
