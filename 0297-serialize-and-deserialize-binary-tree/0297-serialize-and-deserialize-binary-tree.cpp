class Codec {
public:
    string serialize(TreeNode* root) {
        if (!root) return "";

        string serial = "";
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();

            if (node == NULL) {
                serial += "#,";
                continue;
            }

            serial += to_string(node->val) + ",";

            q.push(node->left);
            q.push(node->right);
        }

        return serial;
    }

    TreeNode* deserialize(string data) {
        if (data.empty()) return NULL;

        stringstream ss(data);
        string str;

        getline(ss, str, ',');
        TreeNode* root = new TreeNode(stoi(str));

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();

            getline(ss, str, ',');
            if (str != "#") {
                TreeNode* leftNode = new TreeNode(stoi(str));
                node->left = leftNode;
                q.push(leftNode);
            }

            getline(ss, str, ',');
            if (str != "#") {
                TreeNode* rightNode = new TreeNode(stoi(str));
                node->right = rightNode;
                q.push(rightNode);
            }
        }

        return root;
    }
};