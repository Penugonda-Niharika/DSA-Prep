class Solution {
public:
    class Info {
    public:
        bool isBST;
        int mini;
        int maxi;
        int sum;

        Info(bool isBST, int mini, int maxi, int sum) {
            this->isBST = isBST;
            this->mini = mini;
            this->maxi = maxi;
            this->sum = sum;
        }
    };

    int maxSum = 0;

    Info solve(TreeNode* root) {
        // Empty tree is a valid BST
        if (root == NULL) {
            return Info(true, INT_MAX, INT_MIN, 0);
        }

        // Get information from left and right subtrees
        Info left = solve(root->left);
        Info right = solve(root->right);

        // Check whether the current subtree is a BST
        if (left.isBST &&
            right.isBST &&
            left.maxi < root->val &&
            root->val < right.mini) {

            int currentSum = left.sum + right.sum + root->val;

            maxSum = max(maxSum, currentSum);

            int currentMin = min(root->val, left.mini);
            int currentMax = max(root->val, right.maxi);

            return Info(true, currentMin, currentMax, currentSum);
        }

        // Current subtree is not a BST
        return Info(false, INT_MIN, INT_MAX, 0);
    }

    int maxSumBST(TreeNode* root) {
        solve(root);
        return maxSum;
    }
};