package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class distanceBetweenLeftMostRightMost {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int root[]) {
        idx++;
        if (root[idx] == -1) {
            return null;
        }
        Node newNode = new Node(root[idx]);
        newNode.left = buildTree(root);
        newNode.right = buildTree(root);
        return newNode;
    }


     public static int leftMost(Node root) {
        if (root == null) {
            return 0;
        }
        int val =0;
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int count = qu.size();
            // use this
            // System.out.print(qu.peek().data + " ");
            for (int i = 0; i < count; i++) {
                Node curNode = qu.remove();
                // use this
                if (i == 0) {
                    //System.out.print(curNode.data + " ");
                    val=curNode.data;
                }
                if (curNode.left != null) {
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
        }
        return val;
    }

    public static int rightMost(Node root) {
        if (root == null) {
            return 0;
        }
        int val =0;
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int count = qu.size();
            // use this
            // System.out.print(qu.peek().data + " ");
            for (int i = 0; i < count; i++) {
                Node curNode = qu.remove();
                // use this
                if (i == count -1) {
                    //System.out.print(curNode.data + " ");
                    val=curNode.data;
                }
                if (curNode.left != null) {
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
        }
        return val;
    }

    public static int distance(Node root){
        return Math.abs(leftMost(root)-rightMost(root));
    }

    public static void main(String[] args) {
        int node[]={ 50, 25, 12,13, -1, -1,-1, 37,-1,-1, 75, 62, -1, -1, 18,-1,14, -1,15,-1,-1};
   
        Node root= buildTree(node);
        System.out.println(leftMost(root));
        System.out.println(rightMost(root));
        System.out.println(distance(root));
    }
   
}
