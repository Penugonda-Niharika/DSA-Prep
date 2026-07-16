class Solution {
public:
    void generateSubsets(int idx, vector<int>& nums,
                         vector<int>& curr,
                         vector<vector<int>>& ans) {
        // Write your recursive/backtracking code here
        if(idx == nums.size()) {
            ans.push_back(curr);
            return;
        }
        curr.push_back(nums[idx]);
        generateSubsets(idx+1, nums, curr, ans);
        curr.pop_back();
        int next = idx+1;
        while(next < nums.size() && nums[next] == nums[idx]) next++;
        generateSubsets(next, nums, curr, ans);
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> arr;
        generateSubsets(0, nums, arr, ans);
        return ans;
    }
};