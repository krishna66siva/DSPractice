package com.sk.linkedLists;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suppalamethi on 10/23/2015.
 */
public class LRUCacheImpl<K, V> {

    private Map<K, DoubleLinkedList.Node> cacheMap;
    private DoubleLinkedList<KeyValueObject> keyValueObjectDLL;
    private int capacity = 0;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<K, DoubleLinkedList.Node>(capacity);
        this.keyValueObjectDLL = new DoubleLinkedList<KeyValueObject>();
    }

    public void add(K key, V value) {

        KeyValueObject keyValueObject = new KeyValueObject(key, value);

        if (cacheMap.size() < capacity) { // map not full
            System.out.println(String.format("Map is not full and is with size %s", cacheMap.size()));

            // if the key is present in the map
            if (cacheMap.containsKey(key)) {
                System.out.println(String.format("Key - %s is already added to map", key.toString()));
                // remove the node from DLL and
                // add to end of the DLL - done after this if loop
                // update the key with the new node value in Map - done after this if loop
                keyValueObjectDLL.remove(cacheMap.get(key));
                System.out.println("Now add the key-val to end of DLL and to map");
            }
        } else { //map is full

            System.out.println("Hash map is full with capacity - " + cacheMap.size());
            // Remove the first node
            DoubleLinkedList.Node removedNode = keyValueObjectDLL.removeFirst();

            if (removedNode != null) {
                KeyValueObject removedNodeKeyValueObj = (KeyValueObject) removedNode.getData();
                // remove the corresponding key from map
                System.out.println(String.format("Removing the key - %s from map", removedNodeKeyValueObj.getKey().toString()));
                cacheMap.remove(removedNodeKeyValueObj.getKey());
            }
            System.out.println("Now add the NEW key-val to DLL and map");
        }
        // add to the end
        System.out.println("Adding to end of DLL");

        DoubleLinkedList.Node keyValueObjectLastNode = keyValueObjectDLL.addLast(keyValueObject);
        cacheMap.put(key, keyValueObjectLastNode);
    }

    public V get(K key) {
        System.out.println("Fetching the value for key" + key.toString());

        V value = null;

        if (!cacheMap.isEmpty()) {
            if (cacheMap.containsKey(key)) {
                System.out.println(String.format("Key - %s is present in the map", key.toString()));
                // get the Node from map
                DoubleLinkedList.Node keyValueObjectNode = cacheMap.get(key);

                // get the value from node - to return
                value = (V) ((KeyValueObject) keyValueObjectNode.getData()).getValue();

                System.out.println(String.format("Got the value - %s for Key - %s", value.toString(), key.toString()));
                KeyValueObject keyValueObject = new KeyValueObject(key, value);

                // remove the node from DLL and add to last of DLL and update the map with new node reference - to mark it as LRU
                System.out.println("Remove the node from DLL and add to last of DLL and update" +
                        " the map with new node reference - to mark it as LRU");
                keyValueObjectDLL.remove(keyValueObjectNode);
                DoubleLinkedList.Node keyValueObjectLastNode = keyValueObjectDLL.addLast(keyValueObject);
                cacheMap.put(key, keyValueObjectLastNode);
            } else {
                System.out.println(String.format("Key - %s is NOT present in the map", key.toString()));
                return null;
            }
        } else {
            System.out.println("Map is empty");
            return null;
        }
        return value;
    }

    public Map<K, DoubleLinkedList.Node> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(Map<K, DoubleLinkedList.Node> cacheMap) {
        this.cacheMap = cacheMap;
    }

    @Override
    public String toString() {
        return "{" +
                "cacheMap:" + cacheMap.toString() +
                '}';
    }

    class KeyValueObject<K, V> {
        private K key;
        private V value;

        public KeyValueObject(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "key=" + key + ", value=" + value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
