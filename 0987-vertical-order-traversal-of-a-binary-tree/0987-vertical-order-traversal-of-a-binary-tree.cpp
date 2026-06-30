class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        
        map<int, map<int, multiset<int>>> nodes;
        queue<pair<TreeNode*, pair<int, int>>> q;

        q.push({root, {0, 0}});

        while(!q.empty()) {
            auto temp = q.front();
            q.pop();

            TreeNode* node = temp.first;
            int x = temp.second.first;
            int y = temp.second.second;

            nodes[x][y].insert(node->val);

            if(node->left)
                q.push({node->left, {x - 1, y + 1}});

            if(node->right)
                q.push({node->right, {x + 1, y + 1}});
        }

        vector<vector<int>> ans;

        for(auto col : nodes) {
            vector<int> vertical;

            for(auto level : col.second) {
                for(auto val : level.second) {
                    vertical.push_back(val);
                }
            }

            ans.push_back(vertical);
        }

        return ans;
    }
};