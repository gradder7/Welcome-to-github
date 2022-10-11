package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class prePostInorder {
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

    class Pairs {
        int state;
        Node node;

        Pairs(Node node, int state) {
            this.node = node;
            this.state = state;
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

    public void prePostInorderPrintIteratively(Node root) {
        Stack<Pairs> st = new Stack<>();
        Pairs rootPair = new Pairs(root, 1);
        st.push(rootPair);
        String pre = "";
        String inorder = "";
        String post = "";
        while (!st.isEmpty()) {
            Pairs top = st.peek();
            // pre -> state ++ and got to left_> pre,s++,left
            if (top.state == 1) {
                pre += top.node.data + " ";
                top.state++;
                if (top.node.left != null) {
                    Pairs leftPairs = new Pairs(top.node.left, 1);
                    st.push(leftPairs);
                }
            }
            // in order-> state ++ goto right-> in,s++,right
            else if (top.state == 2) {
                inorder += top.node.data + " ";
                top.state++;
                if (top.node.right != null) {
                    Pairs rightPairs = new Pairs(top.node.right, 1);
                    st.push(rightPairs);
                }
            }
            // post-> pop; ->post,pop
            else {
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(inorder);
        System.out.println(post);
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
        int[] nodes = { 50, 25, 12, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, -1 };
        prePostInorder tree = new prePostInorder();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.prePostInorderPrintIteratively(root);
        // ArrayList<Integer> path= nodeToRootPath(root,62);
        // System.out.println(path);

    }
}
