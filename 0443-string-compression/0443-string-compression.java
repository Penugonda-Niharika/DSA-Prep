class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int i = 0;
        int write = 0;

        while (i < n) {

            int cnt = 1;
            int j = i;

            // Count consecutive characters
            while (j + 1 < n && chars[j] == chars[j + 1]) {
                cnt++;
                j++;
            }

            // Write the character
            chars[write] = chars[i];
            write++;

            // Write the count if it is greater than 1
            if (cnt > 1) {

                String count = String.valueOf(cnt);

                for (int k = 0; k < count.length(); k++) {
                    chars[write] = count.charAt(k);
                    write++;
                }
            }

            // Move to the next group
            i = j + 1;
        }

        return write;
    }
}