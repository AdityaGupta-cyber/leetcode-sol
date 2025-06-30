class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        //maintain a hashMap to store the used characters from the string;
        int count = 0; //set the count to one as a substring will be atleast one single character.
        // use sliding window approach to check the longest substring and as we get the repeating character move the left index to right and right index = left index and move right index to capture the characters again;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> map = new HashSet<>();
            int temp = 0;
            for (int j = i; j < s.length(); j++) {
                if (map.contains(s.charAt(j))) {
                    break;
                }
                map.add(s.charAt(j));
                temp += 1;
            }
            count = Math.max(count, temp);
        }
        return count;
    }
}