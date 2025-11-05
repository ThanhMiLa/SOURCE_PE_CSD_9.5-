package Tree.AVL_Tree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class AVLTree {
    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public int getHeight(Node root) {
        if (root == null)   return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalance(Node root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalance(root.left) && isBalance(root.right);
    }

    public boolean isBalanceTree() {
        return isBalance(root);
    }

    public Node leftRotation(Node root){
        if(root == null)    return null;
        Node returnNode = root.right;
        root.right = returnNode.left;
        returnNode.left = root;
        return returnNode;
    }

    public Node rightRotation(Node root){
        if(root == null)    return null;
        Node returnNode = root.left;
        root.left = returnNode.right;
        returnNode.right = root;
        return returnNode;
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node root, int value){
        if(root == null)
            return new Node(value);

        if(root.data > value){
            root.left = insert(root.left, value);
        }else if(root.data < value){
            root.right = insert(root.right, value);
        }else{
            return root;
        }

        if(getHeight(root.left) - getHeight(root.right) > 1){
            if(root.left.data > value){
                root.left = leftRotation(root.left);
            }
            return rightRotation(root);
        }
        else if(getHeight(root.left) - getHeight(root.right) < -1){
            if(root.right.data < value){
                root.right = rightRotation(root.right);
            }
            return leftRotation(root);
        }
        return root;
    }

    public void remove(int value){
        root = remove(root, value);
    }

    private Node remove(Node root, int value){
        if(root == null) return null;

        if(root.data > value){
            root.left = remove(root.left, value);
        }else if(root.data < value){
            root.right = remove(root.right, value);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.data = findMinValue(root.right);
            root.right = remove(root.right, root.data);
        }

        if(getHeight(root.left) - getHeight(root.right) > 1){
            if(getHeight(root.left.left) < getHeight(root.left.right)){
                root.left = leftRotation(root.left);
            }
            return rightRotation(root);
        }

        if(getHeight(root.left) - getHeight(root.right) < -1){
            if(getHeight(root.right.right) < getHeight(root.right.left)){
                root.right = rightRotation(root.right);
            }
            return leftRotation(root);
        }
        return root;
    }

    public int findMinValue(Node root){
        while(root.left != null)
        {
            root = root.left;
        }
        return root.data;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

}

public class Tree {
    public static void main(String[] args) {

    }
}
