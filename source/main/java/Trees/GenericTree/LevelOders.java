package Trees.GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOders {
    static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    public Node buildTree(int node[]) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < node.length; i++) {
            if (node[i] == -1) {
                st.pop();
            } else {
                Node curNode = new Node(node[i]);
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

    public void levelOrderTraversal(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node cuNode = qu.poll();
            System.out.print(cuNode.data + "-->");
            for (Node child : cuNode.children) {
                System.out.print(child.data + " ");
                qu.add(child);
            }
            System.out.println();
        }
    }

    public void levelOrderTraversalSpaceUsingSize(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int count = qu.size();
            for (int i = 0; i < count; i++) {
                Node cuNode = qu.poll();
                System.out.print(cuNode.data + " ");
                for (Node child : cuNode.children) {
                    qu.add(child);
                }
            }
            System.out.println();
        }
    }

    public void levelOrderTraversalSpacesNull(Node root) {
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
                for (Node child : curNode.children) {
                    qu.add(child);
                }
            }
        }
    }

    public void levelOrderTraversalUsingTwoQueue(Node root) {
        Queue<Node> mainq = new LinkedList<>();
        Queue<Node> childq = new LinkedList<>();
        mainq.add(root);
        while (!mainq.isEmpty()) {
            Node curNode = mainq.remove();
            System.out.print(curNode.data + " ");
            for (Node child : curNode.children) {
                childq.add(child);
            }
            if (mainq.isEmpty()) {
                mainq = childq;
                childq = new LinkedList<>();
                System.out.println();
            }
        }
    }

    class Pairs {
        Node node;
        int level;

        Pairs(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void levelOrderUsingPairs(Node root) {
        Queue<Pairs> qu = new LinkedList<>();
        qu.add(new Pairs(root, 1));
        int level = 1;
        while (!qu.isEmpty()) {
            Pairs pair = qu.remove();
            // if pair level is greater than do next line beacuse
            // for same level the level will be same..
            // (10-1),
            // (20-2),(30-2),(40-2)
            // (50-3),(60-3),(70-3),(80-3),(90-3),(100-3)
            // ......
            if (pair.level > level) {
                level = pair.level;
                System.out.println();
            }

            System.out.print(pair.node.data + " ");
            for (Node child : pair.node.children) {
                // add childrens of each level
                qu.add(new Pairs(child, pair.level + 1));
            }
        }

    }

    public void levelOrderTraversalZigzag(Node root) {
        Stack<Node> mainStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();

        mainStack.push(root);
        int level = 0;
        while (!mainStack.isEmpty()) {
            Node curNode = mainStack.pop();
            System.out.print(curNode.data + " ");
            // adding children by determining level
            // if odd its children will be in left to right in stack
            // if even than left to right in stack
            // beacuse when pop from stack it will be in opposite order
            if (level % 2 == 1) {
                for (int i = 0; i < curNode.children.size(); i++) {
                    // getting children at index
                    Node child = curNode.children.get(i);
                    childStack.push(child);
                }
            } else {
                for (int i = curNode.children.size() - 1; i >= 0; i--) {
                    Node child = curNode.children.get(i);
                    childStack.push(child);
                }
            }
            if (mainStack.isEmpty()) {
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        LevelOders tree = new LevelOders();
        int node[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = tree.buildTree(node);
        System.out.println(root.data);
        tree.levelOrderTraversal(root);
        System.out.println();
        tree.levelOrderTraversalSpaceUsingSize(root);
        System.out.println();
        tree.levelOrderTraversalZigzag(root);
        System.out.println();
        tree.levelOrderTraversalUsingTwoQueue(root);
        System.out.println();
        tree.levelOrderUsingPairs(root);
    }
}
