package Tree.BST_Tree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }    
}

class BST{
    Node root;

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int value){
        root = insert(root, value);
    }

    public Node insert(Node r, int value) {
        if(r == null){
            return new Node(value);
        }else if(r.data > value){
            r.left = insert(r.left, value);
        }else if(r.data < value){
            r.right = insert(r.right, value);
        }
        return r;
    }

    public void inOrder(){
        inOrderRed(root);
    }

    public void inOrderRed(Node r) {
        if(r != null){
            inOrderRed(r.left);
            System.out.println(r.data);
            inOrderRed(r.right);
        }
    }

    public void preOrder(){
        preOrderRed(root);
    }

    public void preOrderRed(Node r){
        if(r != null){
            System.out.print(r.data + " ");
            preOrderRed(r.left);
            preOrderRed(r.right);
        }
    }

    public void postOrder(){
        postOrderRed(root);
    }

    public void postOrderRed(Node r){
        if(r != null){
            postOrderRed(r.left);
            postOrderRed(r.right);
            System.out.print(r.data + " ");
        }
    }   

    public void BFS(){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node curNode = queue.poll();
            System.out.println(curNode.data);

            if(curNode.left != null) queue.add(curNode.left);
            
            if(curNode.right != null) queue.add(curNode.right);
        }
    }

    public boolean search(int value){
        return search(root, value);
    }

    public boolean search(Node root, int value){
        if(root == null)
            return false;
        
        if(root.data == value)
            return true;
        else if(root.data < value)
            return search(root.right, value);
        else if(root.data > value)
            return search(root.left, value);
        
        return false;
    }

    public void remove(int value){
        remove(root, value);
    }
    
    public Node remove(Node root, int value){
        if(root == null)
            return null;

        if(root.data > value){
            root.left = remove(root.left, value);
        }else if(root.data < value){
            root.right = remove(root.right, value);
        }else{
            if(root.left == null && root.right == null)
                root = null;
            else if(root.left == null)
                root = root.right;
            else if(root.right == null)
                root = root.left;

            root.data = findMinNode(root.right);
            root.right = remove(root.right, root.data);
        }
        return root;
    }

    public int findMinNode(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public int countNode(){
        return countNode(root);
    }

    public int countNode(Node root){
        if(root == null)
            return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public int countLeafNodes(){
        return countLeafNodes(root);
    }

    public int countLeafNodes(Node root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

}

public class Tree {
    public static void main(String[] args) {
        
    }

}
