class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //Insert all elements into a hash set to remove duplicates 
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }

        int longestStreak = 0;

        for(int num : nums){
            if(!numSet.contains(num - 1)){
                 int currentNum = num;
                 int currentStreak = 1;
                while(numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;


                }
                longestStreak = Math.max(longestStreak , currentStreak);
                
            }
        }
        return longestStreak;
    }
}
