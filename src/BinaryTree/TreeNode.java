package BinaryTree;

public class TreeNode {
    private int index;
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    // getter
    public int getIndex() {
        return index;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    // setter

    public void setIndex(int index) {
        this.index = index;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
