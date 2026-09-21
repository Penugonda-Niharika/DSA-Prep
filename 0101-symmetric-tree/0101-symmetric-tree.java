class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        TreeNode p = root.left;
        TreeNode q = root.right;

        if (p == null && q == null) return true;
        if (p == null && q != null || q == null && p != null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if (n1 == null && n2 != null || 
                n2 == null && n1 != null || 
                n1.val != n2.val) {
                return false;
            }

            // n1.left ↔ n2.right
            if (n1.left != null && n2.right == null || 
                n1.left == null && n2.right != null) {
                return false;
            }

            // n1.right ↔ n2.left
            if (n1.right != null && n2.left == null || 
                n1.right == null && n2.left != null) {
                return false;
            }

            if (n1.left != null && n2.right != null) {
                q1.add(n1.left);
                q2.add(n2.right);
            }

            if (n1.right != null && n2.left != null) {
                q1.add(n1.right);
                q2.add(n2.left);
            }
        }

        return true;
    }
}