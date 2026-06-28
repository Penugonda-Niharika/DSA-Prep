/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // void preorder(vector<int>& ans, TreeNode* root) {
    //     if(root == NULL) return;
    //     ans.push_back(root->val);
    //     preorder(ans, root->left);
    //     preorder(ans, root->right);
    // }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;
        // inorder(ans, root);
        // return ans;
        if(root == NULL) return ans;
        stack<TreeNode* >st;
        st.push(root);
        while(!st.empty()) {
            TreeNode* node = st.top();
            st.pop();
            if(node->right != NULL) st.push(node->right);
            if(node->left != NULL) st.push(node->left);
            ans.push_back(node->val);
        }
        return ans;
    }
};