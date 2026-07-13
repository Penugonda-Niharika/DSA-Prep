class Solution {
public:
    void gen(int k, int n, int i, vector<vector<int>>& ans, vector<int> arr) {
        if(arr.size() == k) {
            if(n == 0) {
            ans.push_back(arr);
            }
            return;
        }
        for(int idx = i; idx<=9; idx++) {
            if(idx>n) break;
            arr.push_back(idx);
            gen(k, n-idx, idx+1, ans, arr);
            arr.pop_back();
        }
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans;
        vector<int> arr;
        gen(k,n,1,ans,arr);
        return ans;
    }
};