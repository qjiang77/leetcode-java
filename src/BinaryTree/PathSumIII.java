package BinaryTree;

/*
统计路径和等于一个数的路径数量

437. Path Sum III (Easy)

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。
 */

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumStartWithRoot(root, sum)+pathSum(root.leftChild, sum)+pathSum(root.rightChild, sum);
    }

    public int pathSumStartWithRoot(TreeNode root, int sum) {
        if(root == null) return 0;
        int ret = 0;
        if(root.data == sum) ret++;
        ret = ret + pathSumStartWithRoot(root.leftChild, sum-root.data) + pathSumStartWithRoot(root.rightChild, sum - root.data);
        return ret;
    }
}
