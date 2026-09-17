class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode t = st.pop();
            ans.add(t.val);

            if (t.right != null) {
                st.push(t.right);
            }

            if (t.left != null) {
                st.push(t.left);
            }
        }

        return ans;
    }
}