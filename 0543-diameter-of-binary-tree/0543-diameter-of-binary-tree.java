/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = -1;
    int mc = -1;
    int ht(TreeNode root) {
        if(root == null) return 0;
        int lh = ht(root.left);
        int rh = ht(root.right);
        int cnt = lh+rh;
        if(mc<cnt) {
            mc = cnt;
            ans = cnt;
        }
        return 1+Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        ht(root);
        return ans;
    }
}