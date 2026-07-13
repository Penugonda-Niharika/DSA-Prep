class Solution {
public:
    void generate(vector<int>& els, int t, int i, vector<vector<int>>& ans, vector<int> arr) {
        if(t == 0) {ans.push_back(arr); return;}
        if(i == els.size() || t<0) return;
        arr.push_back(els[i]);
        generate(els, t-els[i], i, ans, arr);
        arr.pop_back();
        generate(els, t, i+1, ans, arr);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> arr;
        generate(candidates, target, 0, ans, arr);
        return ans;
    }
};