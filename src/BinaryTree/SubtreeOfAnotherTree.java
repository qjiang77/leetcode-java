package BinaryTree;

/*
子树

572. Subtree of Another Tree (Easy)

Given tree s:
     3
    / \
   4   5
  / \
 1   2

Given tree t:
   4
  / \
 1   2

Return true, because t has the same structure and node values with a subtree of s.

Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given tree t:
   4
  / \
 1   2

Return false.
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return isSubtree(s.leftChild, t) || isSubtree(s.rightChild, t) || isSubtreeStartWithRoot(s, t);
    }

    public boolean isSubtreeStartWithRoot(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.data != t.data) return false;
        return isSubtreeStartWithRoot(s.leftChild, t.leftChild) && isSubtreeStartWithRoot(s.rightChild, t.rightChild);
    }
}
