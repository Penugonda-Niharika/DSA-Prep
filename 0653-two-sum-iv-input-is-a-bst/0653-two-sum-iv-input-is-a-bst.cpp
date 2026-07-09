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
    bool twoPointer(int k, vector<int> ans) {
        int st = 0, end = ans.size()-1;
        while(st < end) {
            int sum = ans[st] + ans[end];
            if(sum == k) {
                return true;
            } else if(sum > k) {
                end--;
            } else {
                st++;
            }
        }
        return false;
    }

    void inorder(TreeNode* root, int k, vector<int>& ans) {
        if(root == NULL) return;
        inorder(root->left, k, ans);
        ans.push_back(root->val);
        inorder(root->right, k, ans);
    }

    bool findTarget(TreeNode* root, int k) {
        vector<int> ans;
        inorder(root, k, ans);
        return twoPointer(k, ans);
    }
};