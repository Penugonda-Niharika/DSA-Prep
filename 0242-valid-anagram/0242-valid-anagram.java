class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int mp[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            mp[s.charAt(i) - 'a']++;
            mp[t.charAt(i) - 'a']--;
        }
        for(int c : mp) {
            if(c != 0) return false;
        }
        return true;
    }
}