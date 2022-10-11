package Trees.GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class userInputtree {
    static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    public void display(Node root) {
        System.out.print(root.data + "-->");
        for (Node child : root.children) {
            System.out.print(child.data + " ");
        }
        System.out.println();
        for (Node child : root.children) {
            display(child);
        }
    }

    public Node takeUserInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root ");
        int rootData = sc.nextInt();
        Queue<Node> qu = new LinkedList<>();
        Node root = new Node(rootData);
        qu.add(root);
        while (!qu.isEmpty()) {
            Node cNode = qu.poll();
            System.out.println("Enter number of children of -> " + cNode.data);
            int numChildren = sc.nextInt();
            for (int i = 0; i < numChildren; i++) {
                System.out.println("Enter " + (i + 1) + " child of " + cNode.data);
                int child = sc.nextInt();
                Node childNode= new Node(child);
                cNode.children.add(childNode);
                qu.add(childNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        userInputtree tree = new userInputtree();
        Node root = tree.takeUserInputLevelWise();
        tree.display(root);
    }
}
