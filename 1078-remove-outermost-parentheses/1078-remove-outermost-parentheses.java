class Solution {
    public String removeOuterParentheses(String s) {
          StringBuilder result = new StringBuilder();
        int level = 0; // nesting level

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (level > 0) {
                    result.append(c); // not outermost
                }
                level++; // going deeper
            } else if (c == ')') {
                level--; // coming back up
                if (level > 0) {
                    result.append(c); // not outermost
                }
            }
        }

        return result.toString();
    }

    }
