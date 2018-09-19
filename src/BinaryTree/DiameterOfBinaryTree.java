package BinaryTree;

/*
543. Diameter of Binary Tree (Easy)

Input:

         1
        / \
       2  3
      / \
     4   5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.getLeftChild());
        int rightHeight = maxDepth(root.getRightChild());
        diameter = Math.max(leftHeight+rightHeight, diameter);
        return Math.max(leftHeight, rightHeight)+1;
    }
}
