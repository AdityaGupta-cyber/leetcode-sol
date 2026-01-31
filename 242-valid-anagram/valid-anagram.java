class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        //iterate through s and store the the count(freq) in the arr;
        if(s.length()!=t.length()) return false;
        //as we visit the character in t, arr[i]'s count--, and if the value is 0? it means
        // either the char was never present in 's' string or the freq is a mismatch
        for(int i = 0; i < s.length();i++){
            int index = s.charAt(i) - 97;
            arr[index] =  arr[index] + 1;
        }

        for(int j = 0;j < t.length();j++){
            int index = t.charAt(j) - 97;
            if(arr[index] == 0) return false;

            arr[index] = arr[index] - 1;

        }
return true;

    }
}