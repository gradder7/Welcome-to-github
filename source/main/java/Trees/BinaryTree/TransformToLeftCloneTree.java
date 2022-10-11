package Trees.BinaryTree;


public class TransformToLeftCloneTree {
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

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }

    public Node createLeftNodeClone(Node root) {
        if (root == null) {
            return null;
        }
        Node leftCloneroot = createLeftNodeClone(root.left);
        Node rightCloneroot = createLeftNodeClone(root.right);

        Node newNode = new Node(root.data);
        newNode.left = leftCloneroot;
        newNode.right = null;

        root.left = newNode;
        root.right = rightCloneroot;
        return root;
    }

    public Node removeLeftNodeClone(Node root) {
        if(root==null){
            return null;
        }

        Node leftNodeTransform = removeLeftNodeClone(root.left.left);
        Node rightNodeTransform = removeLeftNodeClone(root.right);
        root.left=leftNodeTransform;
        root.right=rightNodeTransform;

        return root;
    }

    public static void main(String[] args) {
        TransformToLeftCloneTree tree = new TransformToLeftCloneTree();
        int node[] = { 50, 25, 12, -1, -1, 37, -1, -1, 75, 62, -1, -1, 18, -1, -1 };
        Node root = tree.buildTree(node);
        tree.display(root);
        System.out.println();
        tree.createLeftNodeClone(root);
        tree.display(root);
        tree.removeLeftNodeClone(root);
        System.out.println();
        tree.display(root);
    }
}
