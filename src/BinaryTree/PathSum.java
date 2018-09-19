package BinaryTree;

/*
判断路径和是否等于一个数

Leetcdoe : 112. Path Sum (Easy)

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.leftChild == null && root.rightChild == null && root.data == sum) return true;
        return hasPathSum(root.leftChild, sum-root.data) || hasPathSum(root.rightChild, sum-root.data);
    }
}
