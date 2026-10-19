class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet(wordList);
        if(!st.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        Queue<Integer> ls = new LinkedList<>();
        q.add(beginWord);
        ls.add(1);
        st.remove(beginWord);
        while(!q.isEmpty()) {
            String w = q.poll();
            int l = ls.poll();
            if(w.equals(endWord)) {
                return l;
            }
            char chrs[] = w.toCharArray();
            for(int i=0; i<chrs.length; i++) {
                char org = chrs[i];
                for(char j='a'; j<='z'; j++) {
                    chrs[i] = j;
                    String nw = new String(chrs);
                    if(st.contains(nw)) {
                        st.remove(nw);
                        q.add(nw);
                        ls.add(l+1);
                    }
                }
                chrs[i] = org;
            }
        }
        return 0;
    }
}