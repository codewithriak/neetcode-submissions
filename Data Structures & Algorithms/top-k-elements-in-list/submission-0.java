class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each element
        Map<Integer , Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
        }
        //Create buckets where index= freq
        //The max possible freq i nums.length
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        //Gather thr top k element by traversing buckets backwards
        int[] result = new int[k];
        int index = 0;

        for(int pos = bucket.length - 1; pos >= 0 && index<k; pos--){
            if(bucket[pos] != null){
                for(int num : bucket[pos]){
                    result[index++] = num;
                    if(index == k){
                        return result;
                    }
                }
            }
        }
    return result;
    }
}
