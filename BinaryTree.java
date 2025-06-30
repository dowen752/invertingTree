package invertingTree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node getRoot() {
        return root;
    }
}