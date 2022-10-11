package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class linearizeABinaryTree {
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

    public void displaysimple(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        displaysimple(root.left);
        displaysimple(root.right);
    }

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "--> ");
        if (root.left != null) {
            System.out.print(root.left.data + " ");
        }
        if (root.right != null) {
            System.out.print(root.right.data + " ");
        }
        System.out.println();
        display(root.left);
        display(root.right);
    }

    public void levelOrderDisplay(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curNode = qu.remove();
                System.out.print(curNode.data + " ");
                if (curNode.left != null) {

                    qu.add(curNode.left);
                }

                if (curNode.right != null) {

                    qu.add(curNode.right);
                }
            }
            System.out.println();
        }
    }

    static Node prev = null;

    public Node lBtNode(Node root) {
        if (root == null) {
            return null;
        }
        lBtNode(root.right);
        lBtNode(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
        return root;
    }

    public Node lBtNodeIteratively(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curNode = st.pop();
            if (curNode.right != null) {
                st.push(curNode.right);
            }
            if (curNode.left != null) {
                st.push(curNode.left);
            }
            if (!st.isEmpty()) {
                curNode.right = st.peek();
            }
            curNode.left = null;
        }
        return root;
    }

    public Node lbtNodeIterativNodeUsingQueue(Node root){
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            Node curNode= qu.remove();
            if (curNode.left != null) {
                qu.add(curNode.left);
            }
            if (curNode.right != null) {
                qu.add(curNode.right);
            }
        }
        return root;
    }

     //  5 3 4
     //1 2
    // ............................1
    // .........................../\
    // ..........................2 5
    // ........................./\ \
    // ........................3 4 6
    // .........................../
    // ..........................7
    // 1-2-3-4-5-6-7
    //
    // public Node LenearizeaGTree(Node root) {
    // for (Node child : root.children) {
    // LenearizeaGTree(child);
    // }
    // while (root.children.size() > 1) {
    // Node lastChild = root.children.remove(root.children.size() - 1);
    // Node secondLast = root.children.get(root.children.size() - 1);
    // Node secondlastTail = getTail(secondLast);
    // secondlastTail.children.add(lastChild);
    // }
    // return root;
    // }

    // private static Node getTail(Node secondLast) {
    // while (secondLast.children.size() == 1) {
    // secondLast = secondLast.children.get(0);
    // }
    // return secondLast;
    // }

    public static void main(String[] args) {
        linearizeABinaryTree tree = new linearizeABinaryTree();
        int node[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, 7, -1, -1, -1 };
        Node root = tree.buildTree(node);
        // System.out.println(root.data);
        // tree.display(root);
        tree.levelOrderDisplay(root);
        // tree.lBtNode(root);
        // tree.displaysimple(root);
        System.out.println();
        tree.lbtNodeIterativNodeUsingQueue(root);
        tree.displaysimple(root);
    }
}
