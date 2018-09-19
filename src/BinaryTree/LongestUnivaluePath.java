package BinaryTree;

/*
相同节点值的最大路径长度

687. Longest Univalue Path (Easy)

             1
            / \
           4   5
          / \   \
         4   4   5

Output : 2
 */
public class LongestUnivaluePath {
    private int path = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.leftChild);
        int right = dfs(root.rightChild);
        int leftPath = root.leftChild != null && root.leftChild.data == root.data ? left + 1 : 0;
        int rightPath = root.rightChild != null && root.rightChild.data == root.data ? right + 1 : 0;
        path = Math.max(path, leftPath+rightPath);
        return Math.max(leftPath, rightPath);
    }
}
