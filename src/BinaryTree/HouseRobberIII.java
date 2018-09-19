package BinaryTree;

/*
间隔遍历

337. House Robber III (Medium)

     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val1 = root.data;
        if(root.leftChild != null) val1 = val1 + rob(root.leftChild.leftChild) + rob(root.leftChild.rightChild);
        if(root.rightChild != null) val1 = val1 + rob(root.rightChild.leftChild) + rob(root.rightChild.rightChild);
        int val2 = rob(root.leftChild) + rob(root.rightChild);
        return Math.max(val1, val2);
    }
}
