package Trees.BinaryTree;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicTreeUI;

public class KlevelsDown {
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

    public Node buildTree(int root[]) {
        idx++;
        if (root[idx] == -1) {
            return null;
        }
        Node newNode = new Node(root[idx]);
        newNode.left = buildTree(root);
        newNode.right = buildTree(root);
        return newNode;
    }

    public void KlevelsDownPrint(Node root, int k) {
        if (root == null && k <= 0) {
            return;
        }
        if (k == 1) {
            System.out.print(root.data + " ");
        }
        KlevelsDownPrint(root.left, k - 1);
        KlevelsDownPrint(root.right, k - 1);
    }

    //////-------//////
    // to achive k level so far by distance we shold find the
    //1_>Path to route
    //2-printkLeveldown
    //
    public void printKlevelsSofar(Node root, int data, int k) {
        //finding nodde to root path by function calling
        path = new ArrayList<>();
        pathToRoot(root, data);
        // this loop will tell us how much level of the path that we should have to go
        //k-i means how much level we have to go down to complete the k level
        // i == 0?null:path.get(i-1) to make the last node blocker where we do'not have to travel.
        for (int i = 0; i < path.size(); i++) {
            printKlevelsDown(path.get(i), k - i, i == 0?null:path.get(i-1));
        }
    }

    static ArrayList<Node> path;
    public boolean pathToRoot(Node root, int data) {
        if (root == null) {
            return false;
        }
        
        if (root.data == data) {
            path.add(root);
            return true;
        }

        boolean leftFind = pathToRoot(root.left, data);
        if (leftFind) {
            path.add(root);
            return true;
        }

        boolean rightFind = pathToRoot(root.right, data);
        if (rightFind) {
            path.add(root);
            return true;
        }
        return false;
    }

    public void printKlevelsDown(Node root, int k, Node blocker) {
        if (root == null || k < 0 || root == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
        }
        printKlevelsDown(root.left, k - 1, blocker);
        printKlevelsDown(root.right, k - 1, blocker);
    }

    public void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int nodes[] = { 50, 25, 12, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, -1 };
        KlevelsDown tree = new KlevelsDown();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.display(root);
        //print k level down
        tree.KlevelsDownPrint(root, 3);
        System.out.println();
        //print k level down so far
        tree.printKlevelsSofar(root, 25, 1);
    }
}
