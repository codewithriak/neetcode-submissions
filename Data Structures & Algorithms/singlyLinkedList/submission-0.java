class LinkedList {


   private static class Node {
        int val;
        Node prev;
        Node next; 
        Node(int val){
            this.val = val;
        }
    }
    private final Node head;
    private final Node tail;
    private int size;

    public LinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
        
    }

    private Node getNode(int index) {
        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        return getNode(index).val;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        Node curr = head.next;
        while (curr != tail) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}