package com.sargissargsyan.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class MapBuilder<K, V> {

    private Map<K, V> map;
    private boolean acceptNull;

    public MapBuilder(boolean acceptNull) {
        this.acceptNull = acceptNull;
        this.map = new HashMap<>();
    }

    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        if (!acceptNull) {
            map.values().removeAll(Collections.singleton(null));
            map.keySet().removeAll(Collections.singleton(null));
        }
        return map;
    }
}
