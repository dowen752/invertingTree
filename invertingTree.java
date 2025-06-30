package invertingTree;

import java.util.Random;

class invertingTree{

    public static void invert(Node root){
        if (root == null) return;

        // Swap left and right
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursive for both sides
        invert(root.left);
        invert(root.right);
    }

    public static Node invertVertically(Node root) {
        // Base case: if root is null or leaf, return it
        if (root == null || root.left == null)
            return root;

        // Recursively invert the left subtree
        Node newRoot = invertVertically(root.left);

        // Flip the structure
        root.left.left = root.right; // original right becomes new left
        root.left.right = root;      // original root becomes new right

        // Cut old links
        root.left = null;
        root.right = null;

        return newRoot;
    }

    public static void main(String[] args){
        // Initializing tree

        BinaryTree tree = new BinaryTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(4);
        tree.insert(2);
        tree.insert(50);
        tree.insert(51);
        tree.insert(3);
        tree.insert(9);
        tree.insert(15);

        invert(tree.getRoot());


        // Random random = new Random();
        //int size = random.nextInt(1,20);
        // for(int i = 0; i < size; i++){
        //     int appending = random.nextInt(1, 100);
        //     tree.insert(appending);
        // }

        
    }
}