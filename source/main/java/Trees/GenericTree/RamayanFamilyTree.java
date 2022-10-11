package Trees.GenericTree;

import java.util.ArrayList;
import java.util.Stack;


public class RamayanFamilyTree {
    class Node {
        String name;
        ArrayList<Node> children;

        Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
    }

    public Node buildTree(String node[]) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < node.length; i++) {
            // for(String name: node) {
            if (node[i] == "-1") {
                st.pop();
            } else {
                Node curNode = new Node(node[i]);
                // if stack is not empty
                // then peek node and add currnet node as children
                if (!st.isEmpty()) {
                    st.peek().children.add(curNode);
                    st.push(curNode);
                } else {
                    root = curNode;
                    st.push(curNode);
                }
            }
        }
        return root;
    }

    public void printFamilyTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.name + "-->");
        for (Node child : root.children) {
            System.out.print(child.name + " ");
        }
        System.out.println();
        for (Node child : root.children) {
            printFamilyTree(child);
        }
    }

    public Node findPerson(Node root, String s1) {
        if (root == null) {
            return null;
        }
        if (root.name.equals(s1)) {
            return root;
        } else {
            for (Node child : root.children) {
                 return findPerson(child, s1);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        RamayanFamilyTree tree = new RamayanFamilyTree();
        String[] node = { "10", "20", "50", "-1", "60", "-1", "-1", "30", "70", "-1", "80", "110",
                "-1", "120", "-1", "-1", "90", "-1", "-1", "40", "100", "-1", "-1", "-1" };
        Node root = tree.buildTree(node);
        tree.printFamilyTree(root);
        // System.out.println(tree.findPerson(root, "50"));
         System.out.println();
         tree.printFamilyTree(tree.findPerson(root, "40"));
    }
}
