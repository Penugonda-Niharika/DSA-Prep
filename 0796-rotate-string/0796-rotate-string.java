class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for(int i=0; i<s.length(); i++) {
            String a = s.substring(i)+s.substring(0,i);
            if(a.equals(goal)) return true;
        }
        return false;
    }
}