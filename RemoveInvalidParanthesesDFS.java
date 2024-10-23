// Time Complexity : exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using DFS. We will check if string is valid. If yes then check if less than max empty the resultant list and update new max and add the new string. If max is equal to the string length then simply add in the resultant list. Then iterate over the string and calculate new child and if not present in the set, do dfs and pass the child string. To check if given string is valid maintain a counter and increment if discovered '(' and decrement if discovered ')' and if counter is negative or less than 0 return false.
 */
class Solution {
    List<String> result;
    Set<String> set;
    int max = 0;
    public List<String> removeInvalidParentheses(String s) {

        result = new ArrayList<>();
        set = new HashSet<>();

        dfs(s);

        return result;

    }

    private void dfs(String str){

        //base
        if(str.length() < max){
            return;
        }

        //logic
        if(isValid(str)){
            if(max < str.length()){
                max = str.length();
                result = new ArrayList<>(); //emptying previously added strings which has length less than max
                result.add(str);
            }
            else if(max == str.length()){
                result.add(str);
            }
        }

        for(int i =0; i < str.length(); i++){

            char c = str.charAt(i);

            if(c >= 'a' && c <= 'z'){
                continue;
            }

            String child = str.substring(0, i) + str.substring(i+1);
            if(!set.contains(child)){
                set.add(child);
                dfs(child);
            }
        }
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