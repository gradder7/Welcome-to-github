package Trees.BinaryTree;

import javax.xml.transform.Source;

public class PrintSingleChildNodes {

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

    //print child having only one parent
    public void printSingleChildNodes(Node root, Node parent) {
        if (root == null){
            return;
        }
            if (parent != null && parent.left == root && parent.right == null) {
                System.out.println(root.data);
            } else if (parent != null && parent.right == root && parent.left == null) {
                System.out.println(root.data);
            }
        // root.left parent is node
        printSingleChildNodes(root.left, root);
        printSingleChildNodes(root.right, root);
    }

    //Print parents having only one child
    public void printSingleChildNodesonly(Node root){

        if(root==null){
            return;
        }
        if(root.left!=null && root.right==null || root.right!=null && root.left==null){
            System.out.print(root.data+ " ");
        }
        printSingleChildNodesonly(root.left);
        printSingleChildNodesonly(root.right);
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
        PrintSingleChildNodes tree = new PrintSingleChildNodes();
        int node[] = { 50, 25, 12, 13, -1, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, 14, -1, 15, -1, -1 };
        Node root = tree.buildTree(node);
        tree.display(root);
        System.out.println();

        // no parent of rrot thatys why pass null in parent
        tree.printSingleChildNodes(root, null);
        tree.printSingleChildNodesonly(root);
    }
}
