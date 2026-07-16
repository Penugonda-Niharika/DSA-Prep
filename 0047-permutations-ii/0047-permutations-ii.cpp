class Solution {
public:
    void recPermut(int idx,
                   vector<vector<int>>& ans,
                   vector<int>& nums) {

        if (idx == nums.size()) {
            ans.push_back(nums);
            return;
        }

        unordered_set<int> used;

        for (int i = idx; i < nums.size(); i++) {

            if (used.count(nums[i])) {
                continue;
            }

            used.insert(nums[i]);

            swap(nums[i], nums[idx]);

            recPermut(idx + 1, ans, nums);

            swap(nums[i], nums[idx]);
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> ans;

        recPermut(0, ans, nums);

        return ans;
    };
};