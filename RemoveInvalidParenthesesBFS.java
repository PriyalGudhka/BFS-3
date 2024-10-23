// Time Complexity : exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using BFS. We will use a set to store the unique child to avoid processing it again. Add the original string to the queue and check if the string is valid simply maintain a flag and set as true as well as add in the resulant list. If not, add it's child by removing 1 paranteses and add in the queue and set only if unique. To check if given string is valid maintain a counter and increment if discovered '(' and decrement if discovered ')' and if counter is negative or less than 0 return false.
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        boolean isValidFound = false;

        queue.add(s);
        set.add(s);

        while (!queue.isEmpty()) {

            String curr = queue.poll();

            if (isValid(curr)) {
                isValidFound = true;
                result.add(curr);
            } else if (isValidFound == false) {
                for (int i = 0; i < curr.length(); i++) {
                    char c = curr.charAt(i);

                    if (c >= 'a' && c <= 'z') {
                        continue;
                    }

                    String child = curr.substring(0, i) + curr.substring(i + 1);
                    if (!set.contains(child)) {
                        set.add(child);
                        queue.add(child);
                    }

                }
            }
        }

        return result;
    }

    private boolean isValid(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}