class Solution {
public:
    TreeNode* first = NULL;
    TreeNode* middle = NULL;
    TreeNode* last = NULL;
    TreeNode* prev = NULL;

    void inorder(TreeNode* root) {
        if (root == NULL) {
            return;
        }

        inorder(root->left);

        // Violation found
        if (prev != NULL && prev->val > root->val) {

            // First violation
            if (first == NULL) {
                first = prev;
                middle = root;
            }

            // Second violation
            else {
                last = root;
            }
        }

        prev = root;

        inorder(root->right);
    }

    void recoverTree(TreeNode* root) {
        inorder(root);

        // Swapped nodes are not adjacent
        if (last != NULL) {
            swap(first->val, last->val);
        }

        // Swapped nodes are adjacent
        else {
            swap(first->val, middle->val);
        }
    }
};