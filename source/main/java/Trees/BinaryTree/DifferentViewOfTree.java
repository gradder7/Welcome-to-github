package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;

public class DifferentViewOfTree {
    class Node {
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

    public Node buildTree(int node[]) {
        idx++;
        if (node[idx] == -1) {
            return null;
        }
        Node newNode = new Node(node[idx]);
        newNode.left = buildTree(node);
        newNode.right = buildTree(node);
        return newNode;
    }

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }

    public void leftView(Node root) {
        if (root == null) {
            return;
        }
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
                    System.out.print(curNode.data + " ");
                }
                if (curNode.left != null) {
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
        }
    }

    // doubt in static varaibles.
    static int lastLevel = 0;
    public void leftLevelRecuraive(Node root, int level) {
        if (root == null) {
            return;
        }
        if (lastLevel < level) {
            System.out.print(root.data + " ");
            lastLevel = level;
        }
        leftLevelRecuraive(root.left, level + 1);
        leftLevelRecuraive(root.right, level + 1);
    }
    // static int lastLevel1 = 0;
    public void rightViewRecusive(Node root, int level) {
        if (root == null) {
            return;
        }
        if (lastLevel < level) {
            System.out.print(root.data + " ");
            lastLevel = level;
        }
        rightViewRecusive(root.right, level + 1);
        rightViewRecusive(root.left, level + 1);
    }

    public void rightView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int count = qu.size();
            for (int i = 0; i < count; i++) {
                Node curNode = qu.remove();
                if (i == count - 1) {
                    System.out.print(curNode.data + " ");
                }
                if (curNode.left != null) {
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        DifferentViewOfTree tree = new DifferentViewOfTree();
        int node[] = { 50, 25, 12, 13, -1, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, 14, -1, 15, -1, -1 };
        Node root = tree.buildTree(node);
        // tree.display(root);
        // System.out.println();
        tree.leftView(root);
        System.out.println();
        tree.rightView(root);
        System.out.println();


        // tree.rightViewRecusive(root, 1);
        // lastLevel=0;
        // System.out.println();
        // tree.leftLevelRecuraive(root, 1);
    }
}
