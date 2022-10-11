package Trees.GenericTree;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LenearizeaGenerictree {
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

    public void display1(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (Node child : root.children) {
            display1(child);
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

    public void display2(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (Node child : root.children) {
            display2(child);
        }
    }

    // TC-> on^2

    public Node LenearizeaGTree(Node root) {
        for (Node child : root.children) {
            LenearizeaGTree(child);
        }
        while (root.children.size() > 1) {
            Node lastChild = root.children.remove(root.children.size() - 1);
            Node secondLast = root.children.get(root.children.size() - 1);
            Node secondlastTail = getTail(secondLast);
            secondlastTail.children.add(lastChild);
        }
        return root;
    }

    private static Node getTail(Node secondLast) {
        while (secondLast.children.size() == 1) {
            secondLast = secondLast.children.get(0);
        }
        return secondLast;
    }

    //2nd wat in On
    public Node linearrizeMethod2(Node root){
        if(root.children.size()==0){
            return root;
        }

       Node lastNodeTail=LenearizeaGTree(root.children.get(root.children.size()-1)); 
       while(root.children.size()>1){
        Node lastNode= root.children.remove(root.children.size()-1);
        Node secondLastNode=root.children.get(root.children.size()-1);
        Node secondLastTail= LenearizeaGTree(secondLastNode);
        secondLastTail.children.add(lastNode);
       }
       return lastNodeTail;
    }

    public static void main(String[] args) {
        LenearizeaGenerictree tree = new LenearizeaGenerictree();
        int node[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, 90, -1, -1 };
        Node root = tree.buildTree(node);

        // tree.display(root);
        // System.out.println();
        // tree.displayIterativly(root);
        // tree.LenearizeaGTree(root);
        tree.linearrizeMethod2(root);
        tree.display1(root);
    }
}
