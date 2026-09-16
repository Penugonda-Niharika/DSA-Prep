
class Solution {

    void ps(String s, int i, int j,
            List<String> ans, List<List<String>> res) {

        // All characters are completed
        if (i == s.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // No more substring possible
        if (j == s.length()) {
            return;
        }

        // TAKE
        if (isPal(s, i, j)) {
            ans.add(s.substring(i, j + 1));

            ps(s, j + 1, j + 1, ans, res);

            // BACKTRACK
            ans.remove(ans.size() - 1);
        }

        // TRY BIGGER SUBSTRING
        ps(s, i, j + 1, ans, res);
    }


    boolean isPal(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }


    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        ps(s, 0, 0, ans, res);

        return res;
    }
}
