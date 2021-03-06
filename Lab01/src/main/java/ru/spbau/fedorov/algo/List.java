package ru.spbau.fedorov.algo;

/**
 * Forward linked list
 */
public class List {

    private Node head = null;

    private class Node {
        public Node next;
        String value;
        String key;

        public Node(String k, String v) {
            key = k;
            value = v;
            next = null;
        }
    }

    /**
     * Checks whether List is empty
     *
     * @return true if there are no elements in list and false otherwise
     */
    public boolean empty() {
        return head == null;
    }

    /**
     * Adds pair (Key, Value) to the head of the List
     *
     * @param key First String to be contained in Node
     * @param value Second String to be contained in Node
     */
    public void insert(String key, String value) {
        Node prev = head;
        head = new Node(key, value);
        head.next = prev;
    }

    /**
     * Searches for the pair with special first String
     *
     * @param key String to be searched for
     * @return Second String or null if there is no such String
     */
    public String find(String key) {
        Node cur = head;
        while (cur != null){
            if (cur.key.equals(key))
                return cur.value;
            cur = cur.next;
        }
        return null;
    }

    /**
     * Deletes pair with special first String
     *
     * @param key String to be searched for
     * @return Second String or null if there is no such String
     */
    public String erase(String key) {
        if (head == null)
            return null;

        if (head.key.equals(key)){
            String res = head.value;
            head = head.next;
            return res;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.next.key.equals(key)) {
                String res = cur.next.value;
                cur.next = cur.next.next;
                return res;
            }
            cur = cur.next;
        }

        return null;
    }

    /**
     * Deletes the pair (Key, Value) in the head of the List
     *
     * @return Array with exactly two Strings: Key, Value of the deleted pair
     */
    public String[] pop() {
        String[] res = {head.key, head.value};
        head = head.next;
        return res;
    }

    /**
     * Deletes all nodes in List
     */
    public void clear() {
        head = null;
    }
}

