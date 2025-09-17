

public class Solution8 {
    public static int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, result = 0;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println("Testing '42': " + myAtoi("42"));
        System.out.println("Testing '-042': " + myAtoi("-042"));
        System.out.println("Testing '   -042': " + myAtoi("    -042"));
        System.out.println("Testing '0-1: " + myAtoi("0-1"));
    }
}



/*
 * What I had: A working solution but terrible time efficiency. O(n^2)
 * I had everything in a while loop checking for if it is a char but u can do it in one for loop. 
 * Made it a pretty straight forward solution. 
 * Having trouble with the '0-1' testCase. 
 * Added a while loop in beginning to skip white spaces. 
 * ai....
 * Not time efficient enough. Have to eliminate the stringbuilder and arraylist. Now it is O(n)
 */






 /*
    boolean foundChar = false;
  * boolean neg = false; 
        ArrayList<String> arr = new ArrayList<>();
        while(foundChar == false) {
            for(int i = 0; i < s.length(); i++) {
                if(Character.isLetter(s.charAt(i))) {
                    foundChar = true;
                }
                if(Character.isDigit(s.charAt(i))) {
                    arr.add(String.valueOf(s.charAt(i)));
                }
                if(s.charAt(i) == '-') {
                    neg = true;
                }
            }
        }
        //turn into int
        StringBuilder sb = new StringBuilder();
        for (String digit : arr) {
            sb.append(digit);
        }
        int ans = Integer.parseInt(sb.toString());
        if(neg == true) { ans*= -1; }
        return ans;
  */