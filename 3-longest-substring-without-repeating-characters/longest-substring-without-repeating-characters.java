class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character,Integer> position = new HashMap<Character,Integer>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (position.containsKey(c)) {
                left = Math.max(left, position.get(c) + 1);
            }

            position.put(c,i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
    return maxLength;
    }
}