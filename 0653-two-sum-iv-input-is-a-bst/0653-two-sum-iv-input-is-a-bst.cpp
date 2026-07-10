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
class BSTIterator {
    stack<TreeNode*>st;
    bool rev;
    void pushAll(TreeNode* node) {
        while(node) {
            st.push(node);
            if(rev) {
                node = node->right;
            } else {
                node = node->left;
            }
        }
    }
public:
    BSTIterator(TreeNode* root, bool isRev) {
        rev = isRev;
        pushAll(root);
    }
    int next() {
        TreeNode* node = st.top();
        st.pop();
        if(rev) {
            pushAll(node->left);
        } else {
            pushAll(node->right);
        }
        return node->val;
    }
};

class Solution {
public:
    bool findTarget(TreeNode* root, int k) {
        if(!root) return false;
        BSTIterator l(root, false);
        BSTIterator r(root, true);
        int i = l.next();
        int j = r.next();
        while(i < j) {
            int s = i+j;
            if(s==k) {
                return true;
            } else if(s>k) {
                j = r.next();
            } else {
                i = l.next();
            }
        }
        return false;
    }
};