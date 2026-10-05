class Solution {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mp = new HashMap<>();
        HashMap<Character, Character> mp2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (mp.containsKey(ch1)) {
                char ch = mp.get(ch1);
                if (ch != ch2) return false;
            }

            if (mp2.containsKey(ch2)) {
                char ch = mp2.get(ch2);
                if (ch != ch1) return false;
            }

            mp.put(ch1, ch2);
            mp2.put(ch2, ch1);
        }

        return true;
    }
}