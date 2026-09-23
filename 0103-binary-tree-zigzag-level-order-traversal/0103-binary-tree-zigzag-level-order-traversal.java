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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ltor = true;
        while(!q.isEmpty()) {
            int m = q.size();
            List<Integer> lvl = new ArrayList<>();
            for(int i=0; i<m; i++) {
                TreeNode n = q.poll();
                if(ltor) {
                    lvl.add(n.val);
                } else {
                    lvl.add(0, n.val);
                }

                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            ans.add(lvl);
            ltor = !ltor;
        }
        return ans;
    }
}