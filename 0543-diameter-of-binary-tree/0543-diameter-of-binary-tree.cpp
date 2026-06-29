class Solution {
public:
    int height(int& maxi, TreeNode* root) {
        if (root == NULL) return 0;

        int lh = height(maxi, root->left);
        int rh = height(maxi, root->right);
        maxi = max(maxi, lh+rh);
        return 1 + max(lh, rh);
    }

    int diameterOfBinaryTree(TreeNode* root) {
        int maxi = 0;
        height(maxi, root);
        return maxi;
    }
};