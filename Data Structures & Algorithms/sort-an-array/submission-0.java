class Solution {

public int[] sortArray(int[] nums){
    if(nums == null || nums.length == 0){
        return nums;
    }
    int []temp = new int[nums.length];
    mergeSort(nums, temp, 0, nums.length - 1);
    return nums;
}
public void mergeSort(int[] nums, int[] temp, int left, int right){
    if(left >= right){
        return ;
    }
int mid = left + (right - left) / 2;
mergeSort(nums,temp,left,mid);
mergeSort(nums,temp,mid+1, right);
merge(nums,temp,left,mid,right);

}
private void merge(int[] nums, int[] temp, int left, int mid, int right){

for(int i = left; i <= right; i++){
    temp[i] = nums[i];
}
int i = left;
int j = mid + 1;
int k = left;
while(i <= mid && j <= right){
    if(temp[i] <= temp[j]){
        nums[k++] = temp[i++];
    }
    else{
        nums[k++] = temp[j++];
    }

}
while(i<=mid){
nums[k++] = temp[i++];
}
}
}