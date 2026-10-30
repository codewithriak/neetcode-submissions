class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        int maxLength = 0;
        int left = 0;
        //the right pointer moves across the character from left to right
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            //checks for duplicates
            if(lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            lastIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;
    }
}