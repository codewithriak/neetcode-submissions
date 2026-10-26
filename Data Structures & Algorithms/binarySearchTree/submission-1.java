class TreeMap {

    private class Node {
        int key;
        int val;
        Node left;
        Node right;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public TreeMap() {
       root = null; 
    }

    public void insert(int key, int val) {
        root = insertHelper(root, key , val);
    }

    private Node insertHelper(Node node, int key, int val){
        if(node == null){
            return new Node(key, val);
        }
        if(key < node.key){
            node.left = insertHelper(node.left, key , val);
        }
        else if (key > node.key){
            node.right = insertHelper(node.right, key , val);
        }
        else{
            node.val = val ;
        }
        return node;
    }

    public int get(int key) {
        Node current = root ;
        while ( current !=  null){
            if(key == current.key){
                return current.val;
            }
            else if (key < current.key){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return -1;
    }

    public int getMin() {
        if(root == null) return -1;
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.val;
    }

    public int getMax() {
        if (root == null) return -1;
        Node current = root ;
        while(current.right != null){
            current = current.right ;
        }
        return current.val;
    }

    public void remove(int key) {
       root = removeHelper(root, key);
    }
    private Node removeHelper(Node node, int key){
        if(node == null ) return null;
        
        if(key < node.key) {
            node.left = removeHelper(node.left, key);
        }
        else if (key > node.key){
            node.right = removeHelper(node.right, key);
        }
        else {
            if(node.left == null){
                return node.right;
            }
            else if (node.right == null ){
                return node.left;
            }
            Node successor = getMinNode(node.right);
            node.key = successor.key;
            node.val = successor.val;
            node.right = removeHelper(node.right, successor.key);
        }
        return node;
    }
    private Node getMinNode(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<Integer>();
        inorderHelper(root, list );
        return list;
    }
    private void inorderHelper(Node node, List<Integer> list){
        if(node == null) return;
        inorderHelper(node.left, list);
        list.add(node.key);

        inorderHelper(node.right, list);
    }
}