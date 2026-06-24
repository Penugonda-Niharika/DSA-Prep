class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> a = asteroids;
        int n = asteroids.size();
        for(int i=0; i<n; i++) {
            if(a[i] > 0) continue;
            int x = abs(a[i]);
            for(int j=i-1; j>=0; j--) {
                if(a[j] == 0) continue;
                if(a[j]<0) break;
                if(a[j] == x) {
                    a[j] = 0;
                    a[i] = 0;
                    break;
                } else if(a[j] < x) {
                    a[j] = 0;
                } else {
                    a[i] = 0;
                    break;
                }
            }
        }
        vector<int> ans;
        for(int i=0; i<n; i++) {
            if(a[i] != 0) ans.push_back(a[i]);
        }
        return ans;
    }
};