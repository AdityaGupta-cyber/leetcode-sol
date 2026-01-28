class Solution {
    public String minWindow(String s, String t) {
        //use two pointers; 
        //move right pointer till we find all the required target characters;
        //then we shrink the pointer from the left till we find the minimum window;

        Map<Character, Integer> targetFreq = new HashMap<>();

        //run loop to add frequency of characters
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        //calculate total number of required characters to be included in the window;
        int required = targetFreq.size();

        //since it is a sliding window,with continuous shrinking and expanding we need two pointers  ->
        int right = 0;
        int left = 0;

        //we also need to check all of the characters that satisfy the target frequency;
        int formed = 0;

        // Frequency map for the current window
        Map<Character, Integer> windowFreq = new HashMap<>();

        //calculate the minimum length of the window
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c,windowFreq.getOrDefault(c,0)+1);

            //if the char matches target frequency; formed++
            if(targetFreq.containsKey(c) && targetFreq.get(c).intValue() == windowFreq.get(c).intValue()){
                System.out.print(formed+" ");
                formed++;
            }

            while(formed == required && left <= right){
                if((right - left + 1) < minLen){
                    minLen = (right - left + 1);
                    minLeft = left; // window start;
                }

                //now remove the character count from the current window as it is shrinking
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if( targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)){
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}