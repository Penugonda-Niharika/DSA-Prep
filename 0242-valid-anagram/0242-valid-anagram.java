class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        for(char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0)-1);
        }
        for(int c : mp.values()) {
            if(c != 0) return false;
        }
        return true;
    }
}