class Solution {
public:
    void generate(vector<int>& cand, int tar, int i, vector<vector<int>>& ans, vector<int> arr) {
        if(tar==0) {
            ans.push_back(arr);
            return;
        }
        for(int id=i; id<cand.size(); id++) {
            if(id>i  && cand[id] == cand[id-1]) {
                continue;
            }
            if(cand[id]>tar) break;
            arr.push_back(cand[id]);
            generate(cand, tar-cand[id], id+1, ans, arr);
            arr.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> comb;
        generate(candidates, target, 0, ans, comb);
        return ans;
    }
};