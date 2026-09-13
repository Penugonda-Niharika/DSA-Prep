class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            sb.append(ch);
            if(sb.length() >= part.length()) {
                int st = sb.length()-part.length();
                boolean match = true;
                for(int i=0; i<part.length(); i++) {
                    if(sb.charAt(st+i) != part.charAt(i)){
                        match = false;
                        break;
                    }
                }
                if(match) {
                    sb.delete(st, sb.length());
                }
            }
        }
        return sb.toString();
    }
}