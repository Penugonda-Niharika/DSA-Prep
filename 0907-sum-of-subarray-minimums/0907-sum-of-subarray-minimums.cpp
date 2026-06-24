class Solution {
public:
    void findNSE(vector<int>& nse, int n, vector<int> arr) {
        stack<int> st;
        for(int i=n-1; i>=0; i--) {
            while(!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.empty() ? n : st.top();
            st.push(i);
        }
    }
    void findPSE(vector<int>& pse, int n, vector<int> arr) {
        stack<int> st;
        for(int i=0; i<n; i++) {
            while(!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
    }

    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        vector<int> nse(n);
        vector<int> pse(n);
        findNSE(nse, n, arr);
        findPSE(pse, n, arr);
        long long sum = 0;
        const int mod = 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long long left = nse[i]-i;
            long long right = i-pse[i];
            sum = (sum + left * right % mod * arr[i]) % mod;
        }

        return (int)sum;
    }
};