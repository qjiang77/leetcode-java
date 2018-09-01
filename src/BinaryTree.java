package BinaryTree;

import java.util.Stack;
import java.util.*;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        this.root = new TreeNode(1, 1);
    }

    public void createBinaryTree() {
        TreeNode nodeB = new TreeNode(2, 2);
        TreeNode nodeC = new TreeNode(3, 3);
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
    }

    public int getHeight() {
        return getHeight(root);
    }
    public int getHeight(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = getHeight(node.getLeftChild());
        int rightHeight = getHeight(node.getRightChild());
        return leftHeight > rightHeight ? (leftHeight+1) : (rightHeight+1);
    }

    public int getSize() {
        return getSize(root);
    }
    public int getSize(TreeNode node) {
        if(node == null) return 0;

        int leftSize = getSize(node.getLeftChild());
        int rightSize = getSize(node.getRightChild());
        return leftSize+rightSize+1;
    }

    // recursion method
    public void beforeOrder(TreeNode node) {
        if(node == null) return;

        System.out.print(node.getData() + "");
        beforeOrder(node.getLeftChild());
        beforeOrder(node.getRightChild());
    }

    public void midOrder(TreeNode node) {
        if(node == null) return;

        System.out.println("MidOrder");
        midOrder(node.getLeftChild());
        System.out.print(node.getData() + "");
        midOrder(node.getRightChild());
    }

    public void afterOrder(TreeNode node) {
        if(node == null) return;

        System.out.println("AfterOrder");
        afterOrder(node.getLeftChild());
        afterOrder(node.getRightChild());
        System.out.print(node.getData() + "");
    }

    // non-recursion
    public void beforeOrderNon(TreeNode node) {
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        TreeNode tmp = null;

        while(stack.size() > 0) {
            tmp = stack.pop();
            System.out.print(tmp.getData()+"");
            if(tmp.getRightChild() != null) {
                stack.push(tmp.getRightChild());
            }
            if(tmp.getLeftChild() != null) {
                stack.push(tmp.getLeftChild());
            }
        }
    }

    public void midOrderNon(TreeNode node) {
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tmp = node;

        while(tmp != null || stack.size() >0) {
            // push all the left child
            while(tmp != null) {
                stack.push(node);
                tmp = tmp.getLeftChild();
            }
            tmp = stack.pop();

        }
    }

    // level traversal: BFS
    public void traversalByLevel(TreeNode node) {
        if(node == null) return;
    }

    private class Node {
        private Node left;
        private  Node right;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    // construction of binary search tree
    // left < node && right > node
    //      node
    //       |
    //      / \
    //   left  right
    private Node nodeRoot;
    public Node getRoot() {
        return nodeRoot;
    }
    public void buildBinarySearchTree(Node node, int data) {
        if(nodeRoot == null) {
            nodeRoot = new Node(data);
        }else {
            if(data < node.getData()) {
                if(node.getLeft() == null) {
                    node.setLeft(new Node(data));
                }else {
                    buildBinarySearchTree(node.getLeft(), data);
                }
            }else {
                if(node.getRight() == null) {
                    node.setRight(new Node(data));
                }else {
                    buildBinarySearchTree(node.getRight(), data);
                }
            }
        }
    }
    public static BinaryTree createBiTree(int[] datas) {
        BinaryTree binaryTree = new BinaryTree();
        for(int i = 0; i < datas.length; i++) {
            binaryTree.buildBinarySearchTree(binaryTree.getRoot(), datas[i]);
        }
        return binaryTree;
    }


    // already know the traversal order, need to construct the tree
    // preorder and inorder
    private Map<Integer, Integer> indexForInOrders = new HashMap<Integer, Integer>();
    public Node reConstructBinaryTree(int[] pre, int[] in) {
        for(int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i],i);
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }
    public Node reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if(preL > preR) return null;
        Node root = new Node(pre[preL]);
        int inIndex = indexForInOrders.get(root.data);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL+1, preL+leftTreeSize,inL);
        root.right = reConstructBinaryTree(pre, preL+1+leftTreeSize,preR,inL+leftTreeSize+1);
        return root;
    }

    // the height of binary tree
    public int height(Node root) {
        if(root == null) return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        return 1 + (left_height > right_height ? left_height : right_height);
    }
    // judge whether the binary tree is balanced
    public boolean isBalance(Node root) {
        if(root == null) return true;
        int left_height = height(root.left);
        int right_height = height(root.right);
        if(Math.abs(left_height - right_height) > 1)
            return false;
        else
            return isBalance(root.left) && isBalance(root.right);
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.empty()) {
            Node node = stack.pop();
            Node leftChild = node.left;
            Node rightChild = node.right;
            node.left = null;
            node.right = null;
            if(rightChild != null) {
                stack.push(rightChild);
            }
            stack.push(node);
            if(leftChild != null) {
                stack.push(leftChild);
            }
            if(leftChild == null && rightChild == null) {
                res.add(node.data);
                stack.pop();
            }
        }
        return res;
    }

    // main function to test the code
    public static void main(String[] arg) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        int height = binaryTree.getHeight();
        System.out.println("Height is: "+height);
        int size = binaryTree.getSize();
        System.out.println("Size is: "+size);
        System.out.println("BeforeOrder");
        binaryTree.beforeOrderNon(binaryTree.root);
        System.out.println("MidOrder");
        binaryTree.midOrder(binaryTree.root);
        System.out.println("AfterOrder");
        binaryTree.afterOrder(binaryTree.root);
    }
}
