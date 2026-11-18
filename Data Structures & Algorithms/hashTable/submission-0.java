class HashTable {
    private static class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        this.size = 0;
    }

    public void insert(int key, int value) {
        int idx = (key % capacity + capacity) % capacity;
        Node curr = table[idx];
        while (curr != null) {
            if (curr.key == key) {
                curr.val = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = table[idx];
        table[idx] = newNode;
        size++;

        if ((double) size / capacity >= 0.5) {
            resize();
        }
    }

    public int get(int key) {
        int idx = (key % capacity + capacity) % capacity;
        Node curr = table[idx];
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int idx = (key % capacity + capacity) % capacity;
        Node curr = table[idx];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    table[idx] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        int newCap = capacity * 2;
        Node[] oldTable = table;
        table = new Node[newCap];
        capacity = newCap;
        size = 0;

        for (Node head : oldTable) {
            Node curr = head;
            while (curr != null) {
                insert(curr.key, curr.val);
                curr = curr.next;
            }
        }
    }
}