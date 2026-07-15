class Solution {
public:
    void gen(int i, vector<int> curr, vector<vector<int>>& ans, vector<int> arr) {
        if(i == arr.size()) {
            ans.push_back(curr);
            return;
        }
        curr.push_back(arr[i]);
        gen(i+1, curr, ans, arr);
        curr.pop_back();
        gen(i+1, curr, ans, arr);
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> curr;
        vector<vector<int>> ans;
        gen(0,curr, ans, nums);
        return ans;
    }
};