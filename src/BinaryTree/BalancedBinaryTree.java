package BinaryTree;

/*
110. Balanced Binary Tree
 */
public class BalancedBinaryTree {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.getLeftChild());
        int rightHeight = maxDepth(root.getRightChild());
        if(Math.abs(leftHeight-rightHeight) > 1) result = false;
        return 1+Math.max(leftHeight, rightHeight);
    }
}
