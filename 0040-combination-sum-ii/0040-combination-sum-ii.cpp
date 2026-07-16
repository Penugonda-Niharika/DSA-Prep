class Solution {
public:
    void generate(vector<int>& cand, int tar, int i, vector<vector<int>>& ans, vector<int> arr) {
        if(tar==0) {
            ans.push_back(arr);
            return;
        }
        if (i == cand.size() || tar < 0) {
            return;
        }
        arr.push_back(cand[i]);
        generate(cand, tar-cand[i], i+1, ans, arr);
        arr.pop_back();
        int n = i+1;
        while(n < cand.size() && cand[n] == cand[i]) n++;
        generate(cand, tar, n, ans, arr);
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> comb;
        generate(candidates, target, 0, ans, comb);
        return ans;
    }
};