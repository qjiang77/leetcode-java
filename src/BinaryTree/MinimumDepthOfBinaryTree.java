package BinaryTree;

/*
最小路径

111. Minimum Depth of Binary Tree (Easy)

树的根节点到叶子节点的最小路径长度


 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.leftChild);
        int right = minDepth(root.rightChild);
        if (left == 0 || right == 0) return left + right + 1;
        return Math.min(left, right)+1;
    }
}
