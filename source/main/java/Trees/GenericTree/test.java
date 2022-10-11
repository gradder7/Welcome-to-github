// package Trees.GenericTree;

// public class test {

// import java.io.*; // for handling input/output

// import java.util.*; // contains Collections framework

// class Trees {

//     Node root;

//     Trees(Node root) {

//         this.root = root;

//     }

// }

// class Node {

//     int data;

//     Node left;

//     Node right;

//     Node(int data) {

//         this.data = data;

//         this.left = null;

//         this.right = null;

//     }

// }

// class Pair {

//     int a;

//     int b;

//     Pair(int a, int b) {

//         this.a = a;

//         this.b = b;

//     }

// }

// // don't change the name of this class

// // you can add inner classes if needed

// class Main {

//     public static void main(String[] args) {

//         Scanner in = new Scanner(System.in);

//         int N = in.nextInt();

//         Pair arr[] = new Pair[N];

//         for (int i = 0; i < N; i++) {

//             int x = in.nextInt();

//             int y = in.nextInt();

//             arr[i] = new Pair(x, y);

//         }

//         // arr[] = {(2,4),(5,3),(-1,-1),(-1,7),(6,-1),(-1,-1),(-1,-1)}

//         Node root = new Node(1);

//         root.left = arr[0].a;

//         root.right = arr[0].b;

//         Node lefttemp = root.left;// 2

//         Node righttemp = root.right;// 4

//         boolean isLeft = true;

//         for (int i = 1; i < arr.length - 1; i++) {

//             if (isLeft) {

//                 lefttemp.left = arr[i].a;// 2-5

//                 lefttemp.right = arr[i].b;// 2-3

//                 isLeft = false;

//             }

//             else {

//                 righttemp.left = arr[i + 1].a;

//                 righttemp.right = arr[i + 1].b;

//                 isLeft = true;

//             }

//             lefttemp = lefttemp.left;// 5

//         }

//         root.left = lefttemp;

//         root.right = righttemp;

//         // Your code here

//     }

// }}
