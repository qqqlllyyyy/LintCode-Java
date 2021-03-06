public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return true;
        
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            
            while (front < s.length() && !isValid(s.charAt(front))) {
                front++;
            }
            
            if (front == s.length()) return true;
            
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (Character.toUpperCase(s.charAt(front)) != Character.toUpperCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }
        return end <= front;
    }
    
    public boolean isValid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

/*  2016-07-20
    这里终止循环的判别条件是第一次遇到首尾不等，就停止，然后 front++, end-- 看是否 end <= front.
*/

/*  2016-08-03
    函数返回'end<=front'有点tricky, 其实可以把第25行改成'return false;', 把31行改成'return true', 也能通过
*/
