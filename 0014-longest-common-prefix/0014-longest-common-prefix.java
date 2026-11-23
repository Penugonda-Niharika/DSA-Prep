class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: no words at all
        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];              // reference word

        // Walk column by column along the first word
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);        // the character every word must have at column i

            // Check every other word at this column
            for (int j = 1; j < strs.length; j++) {
                // Stop if word j ran out OR its character differs
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);   // everything before column i
                }
            }
        }

        // No stop happened, so the whole first word is common to all
        return first;
    }
}