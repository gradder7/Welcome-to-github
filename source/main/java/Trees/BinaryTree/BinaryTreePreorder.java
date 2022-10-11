package Trees.BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePreorder {
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

    // TC -> O(n) why?-> one by one every node traversal
    public void preorder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void preorderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        //Queue<Node> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curNode = st.peek();
            System.out.print(curNode.data + " ");
            st.pop();
            // push right due to lifo
            if (curNode.right != null) {
                st.push(curNode.right);
            }

            if (curNode.left != null) {
                st.push(curNode.left);
            }
        }
    }

    public void preorderIterativeQu(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node curNode = qu.peek();
            System.out.print(curNode.data + " ");
            qu.remove();
        
            if (curNode.left != null) {
                qu.add(curNode.left);
            }
            if (curNode.right != null) {
                qu.add(curNode.right);
            }
        }
    }

    public void preorderPrintIterativr(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();

    }

    // TC -> O(n) why?-> one by one every node traversal
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // l Root R
    public void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Node curNode = root;
        while (!st.isEmpty()) {
            if (curNode != null) {
                st.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = st.pop();
                System.out.print(curNode.data);
                curNode = curNode.right;
            }
        }
    }
    // queue
    // deuque

    // TC -> O(n) why?-> one by one every node traversal
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderIteraiveUsing2stack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node curNode = st1.pop();
            st2.push(curNode);
            if (curNode.left != null) {
                st1.push(curNode.left);
            }

            if (curNode.right != null) {
                st1.push(curNode.right);
            }
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.peek().data + " ");
            st2.pop();
        }
    }

    // O(n)
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while (!qu.isEmpty()) {
            Node curNode = qu.remove();
            if (curNode == null) {
                System.out.println();
                if (qu.isEmpty()) {
                    break;
                } else {
                    qu.add(null);
                }
            } else {
                System.out.print(curNode.data + " ");
                if (curNode.left != null) {
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
        }
    }

    public void levelOrderTraversalusingSize(Node root) {
        //
        // 1
        // 2 3
        // 4 5 6
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(root);

        while (qu.size() > 0) {
            int count = qu.size();
            // loop till count and do rpa remove print add child
            for (int i = 0; i < count; i++) {
                root = qu.remove();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    qu.add(root.left);
                }
                if (root.right != null) {
                    qu.add(root.right);
                }
            }
            System.out.println();

        }
    }

    // count number of nodes in bt
    // TC O(n) every node one time call

    public int countNodeRecursivly(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodecount = countNodeRecursivly(root.left);
        int rightNodecount = countNodeRecursivly(root.right);

        return leftNodecount + rightNodecount + 1;
    }

    public int SumofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = SumofNodes(root.left);
        int rightSum = SumofNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // O(n)
    // if we return height in -1 means height wrt edges
    // return 0 height wrt Nodes
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftmax = max(root.left);
        int rightMax = max(root.right);
        int maxAllNode = Math.max(leftmax, Math.max(rightMax, root.data));
        return maxAllNode;
    }

    // O(n^2) because of height its O(n^2);
    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lstDiameter = diameter(root.left);
        int rstDiameter = diameter(root.right);
        int throughtRootDiameter = height(root.left) + height(root.right) + 1;
        return Math.max(lstDiameter, Math.max(rstDiameter, throughtRootDiameter));
    }

    // to calculate the diameter we sould create a class which have two attributes
    // height and diameter through which we will calulate the diam in O(n) by
    // passing height and diam through object of this class.

    class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        // info of left and right subtree
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);
        // calculate max height
        int myHeight = Math.max(left.ht, right.ht) + 1;
        // calculated the diameter
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = (left.ht + right.ht + 1);

        // maximum of diameter
        int myDiam = Math.max(diam1, Math.max(diam2, diam3));
        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        System.out.println("hello");
        BinaryTreePreorder tree = new BinaryTreePreorder();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println(tree.countNodeRecursivly(root));
        System.out.println(tree.SumofNodes(root));
        System.out.println(tree.height(root));
        System.out.println(tree.diameter(root));
        System.out.println(tree.diameter2(root).diam);
        System.out.println(tree.max(root));
        tree.levelOrderTraversalusingSize(root);
        tree.preorderIterative(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrderIteraiveUsing2stack(root);
        System.out.println();
        tree.preorderIterative(root);
        tree.preorderIterativeQu(root);
    }
}
