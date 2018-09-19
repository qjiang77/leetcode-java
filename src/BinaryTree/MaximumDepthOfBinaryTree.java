package BinaryTree;

/*
104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.getLeftChild());
        int rightHeight = maxDepth(root.getRightChild());
        return leftHeight > rightHeight ? (leftHeight+1) : (rightHeight+1);
    }
}
