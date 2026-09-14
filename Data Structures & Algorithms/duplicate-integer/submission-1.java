class Solution {
    public boolean hasDuplicate(int[] nums) {
        int c=0;
        boolean res = false;
        Set<Integer> seen = new HashSet<>();

        for (int i=0;i< nums.length;i++){
            
            if(seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }
}