class Solution {
public:
    void generateSubsets(int idx, vector<int>& nums,
                         vector<int>& curr,
                         vector<vector<int>>& ans) {
        // Write your recursive/backtracking code here

            ans.push_back(curr);

        
        for(int i=idx; i<nums.size(); i++) {
            if(i>idx && nums[i] == nums[i-1]) continue;
        curr.push_back(nums[i]);
        generateSubsets(i+1, nums, curr, ans);
        curr.pop_back();
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> arr;
        generateSubsets(0, nums, arr, ans);
        return ans;
    }
};