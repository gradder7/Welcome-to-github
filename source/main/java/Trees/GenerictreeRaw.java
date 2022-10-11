package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerictreeRaw {
    Node root;

    public GenerictreeRaw() {
        root = null;
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    // pre order
    public void display(Node root) {
        // print tree with initializin array list of chlidren in main mehtod
        // String str = root.val + " -> ";
        // if(root.children!=null){
        // for (Node child : root.children) {
        // str += child.val + ", ";
        // }
        // str += ".";
        // System.out.println(str);

        // for (Node child : root.children) {
        // display(child);
        // }
        // }

        // print tree with initializin array list of chlidren in main mehtod
        // System.out.print(root.val+"->");
        // //System.out.println();
        // if(root.children!=null){
        // for (Node child : root.children) {
        // System.out.print(child.val + " ");
        // }
        // System.out.println();
        // for (Node child : root.children) {
        // display(child);
        // }
        // }

        // using array list operations
        // System.out.print(root.val + "=>");
        // if(root.children!=null){
        // for (int i = 0; i < root.children.size(); i++) {
        // System.out.print(root.children.get(i).val + ",");
        // }
        // System.out.println("END");
        // for (int i = 0; i < root.children.size(); i++) {
        // this.display(root.children.get(i));
        // }
        // }
        // if we do not create an array list for each children in main method
        // use children = new ArrayList<>();

        System.out.print(root.val + "->");
        // System.out.println();
        for (Node child : root.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();
        for (Node child : root.children) {
            display(child);
        }
    }

    public int findSize(Node root) {
        if (root == null) {
            return 0;
        }
        int size = 0;
        for (Node child : root.children) {
            int count = findSize(child);
            size += count;
        }
        return size + 1;
    }

    static int currentHeght = 0;

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        for (Node child : root.children) {
            int hightSubtree = height(child);
            currentHeght = Math.max(currentHeght, hightSubtree);
        }
        return currentHeght + 1;
    } 

    public void displayIterative(Node root) {
        Queue<Node> qu = new LinkedList<>();
        // root to queue
        if (root != null) {
            qu.add(root);
        }

        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            // printself
            System.out.print(curNode.val + "-->");
            // printing childrens
            for (Node child : curNode.children) {
                System.out.print(child.val + " ");
                // pushing childrens to queue
                qu.add(child);
            }
            System.out.println();

        }
    }

    // main kaam ->
    // tree -> Print
    // tree -> Add node
    // tree -> Find node
    // tree -> delete Node
    // tree -> Add at position
    // tree -> Find size
    // tree -> isEmpty
    // tree -> Depth
    // tree -> equals
    // tree -> Remove at position
    // tree -> NodeWithMaxChildren
    // tree -> Number of leaves
    // tree -> Level of a node
    // tree -> IsNodeLeaf
    // tree -> Ancestor of Node
    // tree -> Path of node
    // tree -> check parent/are Siblings (Do 2 nodes have same parents)
    // tree -> Swap Nodes
    // tree -> population at a level

    // Agenda-> iterative as well as recursive

    public static void main(String[] args) {
        Node node = new Node(10);

        // Node children:
        Node nodec1 = new Node(20);
        Node nodec2 = new Node(30);
        Node nodec3 = new Node(40);

        // node.children = new ArrayList<>();
        node.children.add(nodec1);
        node.children.add(nodec2);
        node.children.add(nodec3);

        // node c1 ke child
        Node nodec1c1 = new Node(5);
        Node nodec1c2 = new Node(50);

        // node c2 ke child
        Node nodec2c1 = new Node(60);
        Node nodec2c2 = new Node(100);

        // Add nodec1 ke child
        // nodec1.children = new ArrayList<>();
        nodec1.children.add(nodec1c1);
        nodec1.children.add(nodec1c2);

        // Node c2 ke child addition yojna
        // nodec2.children = new ArrayList<>();
        nodec2.children.add(nodec2c1);
        nodec2.children.add(nodec2c2);
        GenerictreeRaw tree = new GenerictreeRaw();
        tree.display(node);
        System.out.println();
        tree.displayIterative(node);

    }
}
