class MinStack {
    Stack<Long> st = new Stack<>();
    long mini = Long.MAX_VALUE;

    public MinStack() {
    }

    public void push(int value) {
        long val = value;

        if (st.isEmpty()) {
            st.push(val);
            mini = val;
        } 
        else if (val >= mini) {
            st.push(val);
        } 
        else {
            st.push(2 * val - mini);
            mini = val;
        }
    }

    public void pop() {
        long x = st.pop();

        if (x < mini) {
            mini = 2 * mini - x;
        }
    }

    public int top() {
        long x = st.peek();

        if (x < mini) {
            return (int) mini;
        }

        return (int) x;
    }

    public int getMin() {
        return (int) mini;
    }
}