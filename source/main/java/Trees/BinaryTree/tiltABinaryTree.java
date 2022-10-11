package Trees.BinaryTree;

import javax.swing.SpringLayout;

public class tiltABinaryTree {
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

    public Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    static int tilt = 0;
    public int tiltBinaryTree(Node root) {
        if(root==null){
            return 0;
        }
        int leftsum = tiltBinaryTree(root.left);
        int rightsum = tiltBinaryTree(root.right);
        // absolute value of the subtree
        int subtreeTilt = Math.abs(leftsum - rightsum);
        // add it to the tilt where all sub tree tilt will be added
        tilt += subtreeTilt;
        int totalSum = leftsum+rightsum+root.data;

        return totalSum;

    }

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = { 1,2,-1,-1,3,-1,-1 };
        tiltABinaryTree tree = new tiltABinaryTree();
        Node root = tree.buildTree(nodes);
        tree.display(root);
        System.out.println(tree.tiltBinaryTree(root));
        System.out.println(tiltABinaryTree.tilt);
    }
}
