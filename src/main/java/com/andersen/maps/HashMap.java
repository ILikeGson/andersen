package com.andersen.maps;

import java.util.Arrays;
import java.util.Objects;

public class HashMap<K, V> {
    private static final int DEFAULT_SIZE = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size;
    private int threshold;
    private int loadFactor;
    private Node<K, V> [] table;

    public HashMap() {
        table = new Node[DEFAULT_SIZE];
    }

    static class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;
        private Node<K, V> next;


        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public final int hashcode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Node) {
                Node<?, ?> node = (Node<?, ?>) o;
                if (Objects.equals(key, node.key) && Objects.equals(value, node.value)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void put(K key, V value) {
        if (Objects.isNull(key)) {
            throw new NullPointerException();
        }
        Node<K, V> entry = new Node<>(hash(key), key, value, null);
        int arrayIndex = (table.length - 1) & entry.hash;
        if (table[arrayIndex] == null) {
            table[arrayIndex] = entry;
            size++;
        } else {
            Node<K,V> previous = table[arrayIndex];
            Node<K,V> node = previous.next;
            boolean thereIsNoSuchKey = false;
            while (Objects.nonNull(node)) {
                if (node.hash == entry.hash && Objects.equals(node.key, entry.key)) {
                    node.value = entry.value;
                    thereIsNoSuchKey = true;
                    break;
                }
                previous = node;
                node = node.next;
            }
            if (!thereIsNoSuchKey) {
                previous.next = entry;
            }
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int arrayIndex = (table.length - 1) & hash;
        Node<K, V> node = table[arrayIndex];
        while (Objects.nonNull(node)) {
            if (node.key.equals(key)) {
                return table[arrayIndex].value;
            }
            node = node.next;
        }
        throw new IllegalArgumentException("Key is not found");
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int arrayIndex = (table.length - 1) & hash;
        Node<K, V> node = table[arrayIndex];
        while (Objects.nonNull(node)) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void remove(K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException();
        }
        int hash = hash(key);
        int arrayIndex = (table.length - 1) & hash;
        Node<K, V> node = table[arrayIndex];
        Node<K, V> previous = null;
        while (Objects.nonNull(node)) {
            if (node.key.equals(key)) {
                if (Objects.isNull(previous)) {
                    table[arrayIndex] = null;
                } else if (Objects.isNull(node.next)) {
                    previous.next = null;
                } else {
                    previous.next = node.next;
                }
            }
            previous = node;
            node = node.next;
        }
    }

    public int size() {
        return size;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
