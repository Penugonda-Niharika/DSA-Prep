class Solution {
public:
    int minBitFlips(int start, int goal) {
        int n = start^goal, cnt = 0;
        while(n) {
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
};