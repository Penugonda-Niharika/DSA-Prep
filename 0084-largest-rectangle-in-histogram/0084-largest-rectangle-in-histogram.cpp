class Solution {
public:
    void nse(vector<int> arr, vector<int>& nse) {
        int n = arr.size();
        stack<int> st;
        for(int i=n-1; i>=0; i--) {
            while(!st.empty() && arr[st.top()] >= arr[i]) st.pop();
            nse[i] = st.empty() ? n : st.top();
            st.push(i); 
        }
    }
    void pse(vector<int> arr, vector<int>& pse) {
        int n = arr.size();
        stack<int> st;
        for(int i=0; i<n; i++) {
            while(!st.empty() && arr[st.top()] >= arr[i]) st.pop();
            pse[i] = st.empty() ? -1 : st.top();
            st.push(i); 
        }
    }

    int largestRectangleArea(vector<int>& h) {
        int ma = 0;
        int n = h.size();
        vector<int> nsee(n);
        vector<int> psee(n);
        nse(h, nsee);
        pse(h, psee);
        for (int i = 0; i < n; i++) {
            ma = max(ma, h[i]*(nsee[i]-psee[i]-1));
        }
        return ma;
    }
};
