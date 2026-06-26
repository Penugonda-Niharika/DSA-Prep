class StockSpanner {
public:
    stack<pair<int, int>> st;
    int idx = -1;
    StockSpanner() {
        idx = -1;
    }
    
    int next(int val) {
        idx += 1; 
        while(!st.empty() && st.top().first <= val) st.pop();
        int ans = idx - (st.empty() ? -1 : st.top().second);
        st.push({val, idx});
        return ans;
    }
 };

// // // // // // /**
// // // // //  * Your StockSpanner object will be instantiated and called as such:
// // //  * StockSpanner* obj = new StockSpanner();
// // // // //  * int param_1 = obj->next(price);
// // //  */