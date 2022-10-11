package Trees.BinaryTree;

import java.nio.file.Path;

public class PathOfLeafOfNodeSumBWLowHigh {
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

    public void PathOfLeafOfNodeSumOfBtwLowHigh(Node root, String path, int sum, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += root.data;
            if (sum >= low && sum <= high) {
                System.out.println(path + root.data);
            }
            return;
        }
        //root.data will have data of previous 1call
        PathOfLeafOfNodeSumOfBtwLowHigh(root.left, path + root.data + " ", sum + root.data, low, high);
        PathOfLeafOfNodeSumOfBtwLowHigh(root.right, path + root.data + " ", sum + root.data, low, high);
    }

    public static void main(String[] args) {
        PathOfLeafOfNodeSumBWLowHigh tree = new PathOfLeafOfNodeSumBWLowHigh();
        int node[] = { 50, 25, 12, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, -1 };
        Node root = tree.buildTree(node);
        System.out.println(root.data);
        tree.display(root);
        System.out.println();
        tree.PathOfLeafOfNodeSumOfBtwLowHigh(root, "", 0, 0, 10000);
    }
}
