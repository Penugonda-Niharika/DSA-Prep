class Solution {

    int ans = Integer.MIN_VALUE;

    int height(TreeNode root, int maxSum) {
        if (root == null) return 0;

        int lh = height(root.left, maxSum + root.val);
        int rh = height(root.right, maxSum + root.val);

        // Don't take a negative subtree
        lh = Math.max(0, lh);
        rh = Math.max(0, rh);

        // Complete path through current node
        int cs = lh + root.val + rh;

        ans = Math.max(ans, cs);

        // Return only one side to parent
        return root.val + Math.max(lh, rh);
    }

    public int maxPathSum(TreeNode root) {
        int maxSum = 0;
        height(root, maxSum);
        return ans;
    }
}