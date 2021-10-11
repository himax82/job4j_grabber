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
        V value = cache.getOrDefault(key, new SoftReference<V>(null)).get();
        if (cache.get(key) == null || cache.get(key).get() == null) {
            V valueR = load(key);
            SoftReference<V> softReference = new SoftReference<>(valueR);
            cache.put(key, softReference);
            value = valueR;
        }
        return value;
    }

    protected abstract V load(K key);

}