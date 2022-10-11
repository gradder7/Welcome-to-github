package Trees.GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class genericTreeImplimentation {

    // doing this static we can creaate node in main class
    static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    // left build
    public Node buildTree(int node[]) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < node.length; i++) {
            if (node[i] == -1) {
                st.pop();
            } else {
                Node curNode = new Node(node[i]);
                // if stack is not empty
                // then peek node and add current node as children
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

    // display(10) will print and also print its family
    // fath-> children will print its family also.
    // pre order
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

    // level order traversal
    public void displayIterativly(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            System.out.print(curNode.data + "-->");
            for (Node child : root.children) {
                System.out.print(child.data + " ");
                qu.add(child);
            }
            System.out.println();
        }
    }

    public void displayLevelorder(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {

            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curNode = qu.poll();
                System.out.print(curNode.data + " ");
                for (Node child : curNode.children) {
                    qu.add(child);
                }
            }
            System.out.println();
        }
    }

    public void postOrderDisplay(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postOrderDisplay(child);
        }
        System.out.print(root.data + " ");
    }

    // public int diameter(Node root) {
    // if (root == null) {
    // return 0;
    // }
    // int D=0;
    // for(Node child:root.children){
    // int subtreeDiameter=diameter(child);
    // int throughtRootDiameter=height(child)+1;
    // D = Math.max(subtreeDiameter, Math.max(D,throughtRootDiameter));
    // }

    // return D;
    // }

    public int sizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int size = 0;
        for (Node child : root.children) {
            int count = sizeOfTree(child);
            size += count;
        }
        return size + 1;

    }

    public int sizeOfTreeUsingIterativeMethod(Node root) {
        int size = 0;
        Queue<Node> qu = new LinkedList<>();
        if (root == null) {
            return size;
        }
        qu.add(root);
        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            size++;
            for (Node child : curNode.children) {
                qu.add(child);
            }
        }
        return size;
    }

    // height in nodes = n;
    // height in edges = n-1;
    public int height(Node root) {
        int currentHeght = 0;
        for (Node child : root.children) {
            int heightSubtree = height(child);
            currentHeght = Math.max(currentHeght, heightSubtree);
        }
        return currentHeght + 1;
    }

    public int heightIteratively(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int height = 0;
        while (!qu.isEmpty()) {
            height++;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curNode = qu.poll();
                for (Node child : curNode.children) {
                    qu.add(child);
                }
            }
        }
        return height;
    }

    public int heightIteratively2(Node root) {
        int height = 0;
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            if (curNode == null) {
                height++;
                if (qu.isEmpty()) {
                    break;
                } else {
                    qu.add(null);
                }

            } else {
                for (Node child : curNode.children) {
                    qu.add(child);
                }
            }
        }
        return height;
    }

    public int findMax(Node root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }
        // faith to find max of all subtree or childrens
        for (Node child : root.children) {
            int currMax = findMax(child);
            // if (currMax > max) {
            // max = currMax;
            // }
            max = Math.max(max, currMax);
        }

        // if (root.data > max) {
        // max = root.data;
        // }
        max = Math.max(max, root.data);
        return max;
    }

    public int findMaxIteratively(Node root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            max = Math.max(curNode.data, max);
            for (Node child : curNode.children) {
                qu.add(child);
            }
        }
        return max;
    }

    public int findSumOfAllNodes(Node root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        // faith tofind sum of all nodes
        for (Node child : root.children) {
            sum += findSumOfAllNodes(child);
        }
        return root.data + sum;
    }

    public int findSumOfAllNodesIteratively(Node root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            sum += curNode.data;
            for (Node child : curNode.children) {
                qu.add(child);
            }
        }
        return sum;
    }

    public int findSumOfAllNodesIteratively2(Node root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curNode = qu.poll();
                sum += curNode.data;
                for (Node child : curNode.children) {
                    qu.add(child);
                }
            }
        }
        return sum;
    }

    public boolean findNode(Node root, int val) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node cNode = qu.remove();
            if (val == cNode.data) {
                return true;
            }
            for (Node child : cNode.children) {
                qu.add(child);
            }
        }
        return false;
    }

    public boolean findNodeRecursive(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }
        for (Node child : root.children) {
            boolean findInChildren = findNodeRecursive(child, val);
            if (findInChildren) {
                return true;
            }
        }
        return false;
    }

    static ArrayList<Integer> pathnew;

    public boolean findNodeAndPathToNode(Node root, int val) {
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            pathnew.add(root.data);
            return true;
        }

        for (Node child : root.children) {
            boolean findInChildren = findNodeRecursive(child, val);
            if (findInChildren) {
                pathnew.add(root.data);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> findNodeAndPathToNode2(Node root, int val) {
        if (root.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }

        for (Node child : root.children) {
            ArrayList<Integer> pathTillChild = findNodeAndPathToNode2(child, val);
            if (pathTillChild.size() > 0) {
                pathTillChild.add(root.data);
                return pathTillChild;
            }
        }

        return new ArrayList<>();

    }

    public void printKthLevel(Node root, int k) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int level = 0;
        while (!qu.isEmpty()) {
            level++;
            if (level == k) {
                System.out.printf("The Nodes on Level %d are--> ", level);
                while (!qu.isEmpty()) {
                    Node curNodedata = qu.poll();
                    System.out.print(curNodedata.data + " ");
                }
            }
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curNode = qu.poll();
                for (Node child : curNode.children) {
                    qu.add(child);
                }
            }
        }
    }

    public void printKLevelSoFar1(Node root, int k) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int level = 0;
        while (!qu.isEmpty()) {
            level++;
            if (level <= k) {
                int size = qu.size();
                for (int i = 0; i < size; i++) {
                    Node curNode = qu.poll();
                    System.out.print(curNode.data + " ");
                    for (Node child : curNode.children) {
                        qu.add(child);
                    }
                }
                System.out.println();
            }

        }
    }

    public void printkLeveldownRecusive(Node root, int level) {
        if (root == null || level <= 0) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        for (Node child : root.children) {
            printkLeveldownRecusive(child, level - 1);
        }
    }

    /// ------------------
    // removal of leafs

    // 1st try
    // public Node removeLeafNode(Node root) {
    // if (root == null) {
    // return null;
    // }
    // for (Node child : root.children) {
    // removeLeafNode(child);
    // }
    // // 1 st error
    // // this will give me ConcurrentModificationException
    // // beacuse we cannot remove beacuse you are iterating arraylist and in same
    // // araylist removing so this throws exception
    // // for (Node child : root.children) {
    // // if (child.children.size() == 0) {
    // // root.children.remove(child);
    // // }
    // // }
    // /////////// -------------------------------------------------------
    // // second way error shilfting of array list
    // // this code has logical error beacuse in ietration
    // // it will remove but shift the elements leftwards and some elemnts index
    // will
    // // laps
    // // ex-> if we have array 2 10 8 6 4 5
    // // 2 10 8 6 4 5 -> i is at 0 remove 0 index
    // // i
    // // 10 8 6 4 5 -> i is increased to i++ and the elements are shifted
    // // i
    // // 10 6 4 5 i=2
    // // i
    // // 10 6 5
    // // this is the problem so to overcome this problem we do reverse iteration

    // // for (int i = 0; i < root.children.size(); i++) {
    // // Node child = root.children.get(i);
    // // if (child.children.size() == 0) {
    // // root.children.remove(child);
    // // }
    // // }

    // return root;
    // }

    public Node removeLeaf(Node root) {
        // we will not use post order recusion to deleted leaf as it will bring some
        // prblms
        // for(Node child:root.children){
        // removeLeaf(child);
        // }

        for (int i = 0; i < root.children.size(); i++) {
            Node child = root.children.get(i);
            if (child.children.size() == 0) {
                root.children.remove(child);
            }
        }
        // we will use pre order
        for (Node child : root.children) {
            removeLeaf(child);
        }
        return root;
    }

    public static void main(String[] args) {
        genericTreeImplimentation tree = new genericTreeImplimentation();
        int[] node = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = tree.buildTree(node);
        // System.out.println(tree.height(root));
        // System.out.println(tree.heightIteratively2(root));
        // System.out.println(tree.findMax(root));
        // System.out.println(tree.findSumOfAllNodesIteratively2(root));
        // System.out.println(tree.findMaxIteratively(root));
        // System.out.println(tree.findSumOfAllNodes(root));
        // tree.postOrderDisplay(root);
        // System.out.println();
        // System.out.println();
        // tree.displayLevelorder(root);
        // tree.display(root);
        // System.out.println();
        // tree.removeLeaf(root);
        // tree.display(root);

        // tree.display(root);
        // System.out.println();
        // tree.postOrderDisplay(root);

        System.out.println(tree.findNode(root, 100));
        System.out.println(tree.findNodeRecursive(root, 101));
        System.out.println();

        pathnew = new ArrayList<>();
        System.out.println(tree.findNodeAndPathToNode(root, 100));
        System.out.println(pathnew);

        ArrayList<Integer> path = tree.findNodeAndPathToNode2(root, 100);
        System.out.println(path);
        System.out.println();

        tree.printKthLevel(root, 2);
        System.out.println();
        tree.printkLeveldownRecusive(root, 2);
        System.out.println();
        System.out.println("------------------------------------------");
        tree.printKLevelSoFar1(root, 1);

        // System.out.println(tree.diameter(root));
        // raw implementaion of tree
        /**
         * to use this make node class static.
         * // root
         * Node node = new Node(10);
         * 
         * // root children
         * Node nodeC1 = new Node(20);
         * Node nodeC2 = new Node(30);
         * Node nodeC3 = new Node(40);
         * 
         * // adding root children
         * node.children.add(nodeC1);
         * node.children.add(nodeC2);
         * node.children.add(nodeC3);
         * 
         * // childrens of node c1
         * Node nodeC1C1 = new Node(50);
         * Node nodeC1C2 = new Node(60);
         * 
         * // adding childrens of node c1
         * nodeC1.children.add(nodeC1C1);
         * nodeC1.children.add(nodeC1C2);
         * 
         * // childrens of node c2;
         * Node nodeC2C1 = new Node(70);
         * Node nodeC2C2 = new Node(80);
         * Node nodeC2C3 = new Node(90);
         * 
         * // adding childrens to c2
         * nodeC2.children.add(nodeC2C1);
         * nodeC2.children.add(nodeC2C2);
         * nodeC2.children.add(nodeC2C3);
         * 
         * // creating childrens of c2c2
         * Node nodeC2C2C1 = new Node(110);
         * Node nodeC2C2C2 = new Node(120);
         * // adding
         * nodeC2C2.children.add(nodeC2C2C1);
         * nodeC2C2.children.add(nodeC2C2C2);
         * 
         * // adding child
         * Node nodeC3C1 = new Node(100);
         * nodeC3.children.add(nodeC3C1);
         * tree.display2(node);
         */

    }
}
