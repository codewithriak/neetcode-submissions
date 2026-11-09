class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        
        String temp = filtered.toString();
        String rev = "";
        for (int i = temp.length() - 1; i >= 0; i--) {
            rev = rev + temp.charAt(i);
        }
        
        if (rev.equalsIgnoreCase(temp)) {
            return true;
        } else {
            return false;
        }
    }
}