class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map to store the frequency of elements.
        //list to use a bucket and store elements.

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        // Explanation of nums.length + 1
        // The bucket array is an array of lists where each index represents a possible frequency count of the elements in nums. 
        // Since the maximum frequency of any number can be at most nums.length (if all elements in nums are the same), 
        // the bucket array needs to have a size of nums.length + 1 to account for indices from 0 to nums.length. 
        // This way, each frequency count can map to a unique index in bucket.
        for(int num : nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0) + 1);
        }

        for(int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int res[] = new int[k];
        int counter = 0;
        // You are starting from nums.length - 1 and moving downwards. 
        // This is fine in theory, but:
        // Since bucket has nums.length + 1 indices, you should ideally start from
        // nums.length to ensure that all possible frequencies are considered.
        for( int i = nums.length ; i >=0 &&  counter < k ;i--){
            //k >=0 and counter < k because we need to make sure that the k does not exceed array index bound and 
            //we will use counter to get top k elements and exit;
            if(bucket[i] != null){
                for(Integer n : bucket[i]){
                    res[counter++] = n;
                }
            }
        }
        return res;
    }

}
