package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<>(value);
        cache.put(key, softReference);
    }

    public V get(K key) {
        V value = load(key);
        if (cache.get(key) == null || cache.get(key).get() == null) {
            SoftReference<V> softReference = new SoftReference<>(value);
            cache.put(key, softReference);
        }
        return value;
    }

    protected abstract V load(K key);

}