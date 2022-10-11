package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
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
        // -1 represents null
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public void MaxwidthTree(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int max = 0;
        int nodeLevel = 0;
        while (!qu.isEmpty()) {
            nodeLevel=qu.size();
            max= Math.max(max,nodeLevel);
            for(int i=0;i<nodeLevel;i++){
                Node curNode=qu.remove();
                if(curNode.left!=null){
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] nodes = { 50, 25, 12, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, -1 };
        MaxWidthOfBinaryTree tree = new MaxWidthOfBinaryTree();
        // build tree
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.MaxwidthTree(root);

    }
}
