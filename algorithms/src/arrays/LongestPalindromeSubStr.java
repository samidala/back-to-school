package arrays;

public class LongestPalindromeSubStr {

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        longestPalindromeSubStr(s);
    }

    static void longestPalindromeSubStr(String s){
        int n = s.length();
        int maxLen = 1;
        for(int i = 1; i < n; i++){

            int low = i- 1;
            int high = i;
            while (low >=0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLen){
                    maxLen = high - low + 1;
                }
                low --;
                high++;
            }

            low = i - 1;
            high = i + 1;

            while (low >=0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLen){
                    maxLen = high - low + 1;
                }
                low --;
                high++;
            }
        }
        System.out.println(s + " maxLen " + maxLen);
    }

}
