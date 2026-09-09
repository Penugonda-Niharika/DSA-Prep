class Solution {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int st = 0, n = s.length();
        int end = n - 1;

        while (st < n && end >= 0) {

            while (st < n && !Character.isLetterOrDigit(s.charAt(st))) {
                st++;
            }

            while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (st > end) break;

            char left = s.charAt(st);
            char right = s.charAt(end);

            if (left != right) return false;

            st++;
            end--;
        }

        return true;
    }
}