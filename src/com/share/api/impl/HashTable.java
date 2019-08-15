package com.share.api.impl;


import java.util.Map;
import java.util.TreeMap;

public class HashTable<K, V> {
    private static final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241, 786433, 1572869, 3145739,
            6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;

    private int capacityIndex = 0;
    private int size;
    private int M;
    private Map<K, V>[] data;


    public HashTable() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        this.data = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            data[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int getSize() {
        return size;
    }

    public void add(K key, V value) {
        int hash = hash(key);
        data[hash].put(key, value);
        if (!data[hash].containsKey(key)) {
            size++;
            if (size >= M * UPPER_TOL && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    public V remove(K key) {
        int hash = hash(key);

        if (!data[hash].containsKey(key)) {
            return null;
        }
        size--;
        V val = data[hash].remove(key);

        if (size < M * LOWER_TOL && capacityIndex > 0) {
            capacityIndex--;
            resize(capacity[capacityIndex]);
        }
        return val;
    }

    private void resize(int capacity) {
        Map<K, V>[] newData = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            newData[i] = new TreeMap<>();
        }

        int oldM = M;
        M = capacity;
        for (int i = 0; i < oldM; i++) {
            Map<K, V> eles = data[i];
            eles.keySet().forEach(key -> newData[hash(key)].put(key, eles.get(key)));
        }

        data = newData;

    }
}
