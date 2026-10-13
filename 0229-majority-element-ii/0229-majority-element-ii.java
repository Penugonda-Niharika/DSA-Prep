class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int el1 = 0, el2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (el1 == nums[i]) {
                cnt1++;
            } else if (el2 == nums[i]) {
                cnt2++;
            } else if (cnt1 == 0) {
                el1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                el2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }

        if (cnt1 > n / 3) ans.add(el1);
        if (cnt2 > n / 3 && el1 != el2) ans.add(el2);

        return ans;
    }
}