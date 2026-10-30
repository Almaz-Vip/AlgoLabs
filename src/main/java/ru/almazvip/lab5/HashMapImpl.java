package ru.almazvip.lab5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HashMapImpl implements HashMap<String, String> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private final List<LinkedList<Node>> table;

    private long hashByString(String value) {
        long hash = 0;
        for (Character ch: value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    HashMapImpl() {
        table = new ArrayList<>();
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }

    @Override
    public void put(String key, String value) {
        long hash = hashByString(key);
        var bucket = table.get((int) hash);

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
            }
        }

        bucket.add(new Node(key, value));
    }

    @Override
    public String getValue(String key) {
        long hash = hashByString(key);
        var bucket = table.get((int) hash);

        for (Node node : bucket) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }

        return null;
    }

    @Override
    public String delete(String key) {
        long hash = hashByString(key);
        var bucket = table.get((int) hash);

        for (int i = 0; i < bucket.size(); i++) {
            var node = bucket.get(i);

            if (Objects.equals(node.key, key)) {
                LinkedList<Node> newBucket = new LinkedList<>();
                var value = node.value;

                for (Node node2 : bucket) {
                    if (node2.key.equals(key)) {
                        continue;
                    }

                    newBucket.add(node2);
                }

                table.set((int) hash, newBucket);
                return value;
            }
        }

        return null;
    }
}
