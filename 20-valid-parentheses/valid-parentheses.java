class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else {
                if (st.isEmpty())
                {  return false;}
                char popped = st.pop();
                 if ((popped == '[' && c == ']') || (popped == '{' && c == '}') || (popped == '(' && c == ')'))
                    continue;
                else {
                    return false;
                }
            }
        }
         return st.isEmpty();
    }
}