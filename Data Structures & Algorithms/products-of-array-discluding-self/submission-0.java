class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int leftproduct = 1;
        int rightproduct = 1;
         int result[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            result[i] = leftproduct;
            leftproduct = leftproduct * nums[i];
        }

          for(int i = n - 1 ; i >= 0 ; i--){
            result[i] *= rightproduct;
            rightproduct = rightproduct * nums[i];
        }
       return result;
    }
}  