public class Solution {
    // Function to find the minimum window substring
    public String minWindow(String s, String t) {
        // Frequency map for characters in t
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // Number of unique characters required to match
        int required = targetFreq.size();

        // Left and right window pointers
        int left = 0, right = 0;

        // Tracks how many characters in current window match required frequency
        int formed = 0;

        // Frequency map for the current window
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Minimum window length and starting index
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        // Expand the window
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // If character matches target frequency
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }

            // Try shrinking the window if all target characters matched
            while (left <= right && formed == required) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}// Driver clas