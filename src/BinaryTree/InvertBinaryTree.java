package BinaryTree;

/*
翻转树

226. Invert Binary Tree (Easy)
Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class InvertBinaryTree {
    public TreeNode inverTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.getLeftChild();
        root.leftChild = inverTree(root.getRightChild());
        root.rightChild = inverTree(left);
        return root;
    }
}
