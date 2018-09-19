package BinaryTree;

/*
归并两棵树

617. Merge Two Binary Trees (Easy)

Input:
       Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7

Output:
         3
        / \
       4   5
      / \   \
     5   4   7
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode root = new TreeNode(t1.data+t2.data);
        root.leftChild = mergeTrees(t1.leftChild,t2.leftChild);
        root.rightChild = mergeTrees(t1.rightChild, t2.rightChild);
        return root;
    }
}
