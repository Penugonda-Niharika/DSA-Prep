class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') st.push(s.charAt(i));
            else if(s.charAt(i) == ']') {
                if(st.empty()) return false;
                char el = st.peek();
                if(el == '[') st.pop();
                else return false;
            } else if(s.charAt(i) == ')') {
                 if(st.empty()) return false;
                char el = st.peek();
                if(el == '(') st.pop();
                else return false;
            } else if(s.charAt(i) == '}') {
                 if(st.empty()) return false;
                char el = st.peek();
                if(el == '{') st.pop();
                else return false;
            }
        }
        if(!st.empty()) return false;
        return true;
    }
}