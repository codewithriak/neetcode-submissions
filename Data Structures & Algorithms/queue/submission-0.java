class Deque {
    private static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }

    private Node head, tail;

    public Deque() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public void append(int value) {
        Node node = new Node(value);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int pop() {
        if (isEmpty()) return -1;
        Node last = tail.prev;
        int val = last.val;
        tail.prev = last.prev;
        last.prev.next = tail;
        return val;
    }

    public int popleft() {
        if (isEmpty()) return -1;
        Node first = head.next;
        int val = first.val;
        head.next = first.next;
        first.next.prev = head;
        return val;
    }
}