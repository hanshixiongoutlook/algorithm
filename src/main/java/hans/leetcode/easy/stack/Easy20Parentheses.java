package hans.leetcode.easy.stack;

import java.util.Stack;

import hans.algorithm.utils.Logger;
import org.junit.Test;

/**
 Subject:

 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.

 Example 1:

 Input: s = "()"
 Output: true
 Example 2:

 Input: s = "()[]{}"
 Output: true
 Example 3:

 Input: s = "(]"
 Output: false
 Example 4:

 Input: s = "([)]"
 Output: false
 Example 5:

 Input: s = "{[]}"
 Output: true
  

 Constraints:

 1 <= s.length <= 104
 s consists of parentheses only '()[]{}'.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Easy20Parentheses {

 
    @Test
    public void test() {
        String s = "()[]";
        Logger.log("result is {}", isValid(s));
    }
    public boolean isValid(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        Stack<Character> leftParentheseStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(' || c=='{'  || c=='[') {
                leftParentheseStack.push(c);
            } else if (leftParentheseStack.size()>0) {
                char left = leftParentheseStack.pop();
                if (c==')' && left!='(') {
                    return false;
                }
                if (c==']' && left!='[') {
                    return false;
                }
                if (c=='}' && left!='{') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return leftParentheseStack.size()==0;
    }
    
}
