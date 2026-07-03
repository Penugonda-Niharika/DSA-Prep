/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void mapParents(TreeNode* root, unordered_map<TreeNode*, TreeNode*>& mp, TreeNode* target) {
        queue<TreeNode* >q;
        q.push(root);
        while(!q.empty()) {
            TreeNode* node = q.front();
            q.pop();
            if(node->left) {
                mp[node->left] = node;
                q.push(node->left);
            }
            if(node->right) {
                mp[node->right] = node;
                q.push(node->right);
            }
        }
    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        unordered_map<TreeNode*, TreeNode*>mp;
        mapParents(root, mp, target);
        unordered_map<TreeNode*, bool> vis;
        queue<TreeNode* >q;
        q.push(target);
        vis[target] = true;
        int lvl = 0;
        while(!q.empty()) {
            if(lvl++ == k) break;
            int n = q.size();
            for(int i=0; i<n; i++) {
                TreeNode* curr = q.front();
                q.pop();
                if(curr->left && !vis[curr->left]) {
                    q.push(curr->left);
                    vis[curr->left] = true;
                }
                if(curr->right && !vis[curr->right]) {
                    q.push(curr->right);
                    vis[curr->right] = true;
                }
                if(mp[curr] && !vis[mp[curr]]) {
                    q.push(mp[curr]);
                    vis[mp[curr]] = true;
                }
            }
        }
        vector<int> res;
        while(!q.empty()) {
            TreeNode* node = q.front();
            q.pop();
            res.push_back(node->val);
        }
        return res;
    }
};