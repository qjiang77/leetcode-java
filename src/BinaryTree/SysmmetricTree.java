package BinaryTree;

/*
树的对称

101. Symmetric Tree (Easy)

    1
   / \
  2   2
 / \ / \
3  4 4  3
 */
public class SysmmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.leftChild, root.rightChild);
    }

    public boolean isSymmetric(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        if(s.data != t.data) return false;
        if(s.leftChild == null && s.rightChild == null && t.rightChild == null && t.leftChild == null) return true;
        return isSymmetric(s.leftChild, t.rightChild) && isSymmetric(s.rightChild, t.leftChild);
    }
}
