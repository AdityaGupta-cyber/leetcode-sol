class Solution {
  public int subarraySum(int[] arr, int k) {

    //Approach - prefix sum + hashMap
    int n = arr.length;
    int count = 0;

    //Map to store frequency of prefix sums
    HashMap<Integer,Integer> prefixSumCount = new HashMap<Integer,Integer>();
    //initialise the map with 0:1 i.e prefixsum 0 has one occurence;
    prefixSumCount.put(0,1);
    int prefix = 0;
    for(int i = 0; i < n; i++){
        //calculate prefix sum till ith position
        prefix += arr[i];

        //calculate remove i.e x - k;
        int remove = prefix - k;

        if(prefixSumCount.containsKey(remove)){
            count+=prefixSumCount.get(remove);
        }

        prefixSumCount.put(prefix, prefixSumCount.getOrDefault(prefix,0)+1);
    }
    return count;
    }
}