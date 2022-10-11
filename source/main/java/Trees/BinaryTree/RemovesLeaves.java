package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.xml.transform.Source;

public class RemovesLeaves {
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

    public static class Pair {
        Node node;
        int state;

        Pair() {
        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public Node construct(int[] arr) {
        Node root = new Node(arr[0]);

        Stack<Pair> st = new Stack<>();
        Pair root_pair = new Pair(root, 1);

        st.push(root_pair);
        int idx = 1;

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                // waiting for left child
                top.state++;
                if (arr[idx] != -1) {
                    Node lc = new Node(arr[idx]);
                    top.node.left = lc;

                    Pair lcp = new Pair(lc, 1);
                    st.push(lcp);
                }
                idx++;
            } else if (top.state == 2) {
                // waiting for right child
                top.state++;
                if (arr[idx] != -1) {
                    Node rc = new Node(arr[idx]);
                    top.node.right = rc;

                    Pair rcp = new Pair(rc, 1);
                    st.push(rcp);
                }
                idx++;
            } else if (top.state == 3) {
                st.pop();
            }
        }
        return root;

    }
    // static int idx = -1;

    // public Node buildTree(int node[]) {
    // idx++;
    // if (node[idx] == -1) {
    // return null;
    // }
    // Node newNode = new Node(node[idx]);
    // newNode.left = buildTree(node);
    // newNode.right = buildTree(node);
    // return newNode;
    // }

    public Node removeLeafs(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        Node newleftnode = removeLeafs(root.left);
        Node newRightnode = removeLeafs(root.right);
        root.left = newleftnode;
        root.right = newRightnode;
        return root;
    }

    public void printLeafNodes(Node root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            System.out.print(root.data + " ");
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    public int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        } else
            return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public int countLeafNodesIterative(Node root) {
        Queue<Node> qu = new LinkedList<>();
        int count = 0;
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.peek();
            qu.poll();
            if (temp.left != null) {
                qu.add(temp.left);
            }
            if (temp.right != null) {
                qu.add(temp.right);
            }
            if (temp.left == null &&
                    temp.right == null) {
                count++;
            }
        }
        return count;
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
        RemovesLeaves tree = new RemovesLeaves();
        int node[] = { 50, 25, 12, 13, -1, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, 14, -1, 15, -1, -1 };
        // Node root = tree.buildTree(node);
        Node root = tree.construct(node);
        tree.display(root);
        System.out.println();
        tree.printLeafNodes(root);
        System.out.println();
        tree.removeLeafs(root);
        tree.display(root);
        System.out.println();
        System.out.println(tree.countLeafNodes(root));
    }
}
