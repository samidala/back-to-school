package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithKVowels {
    static Set<Character> set = new HashSet<>();

    static {
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }
    public static void main(String[] args) {
        String s = "tHeracEBetwEEntheTwo";
        int k = 5;
        System.out.println(longest(s,k));

        s = "aeiouaeiou";
         k = 2;
        System.out.println(longest(s,k));

        s = "sdfghjklqwrty";
        k = 0;
        System.out.println(longest(s,k));

        s = "sdfghjkaqwrty";
        k = 1;
        System.out.println(longest(s,k));

        //----------------

        System.out.println("--------------------");
         s = "tHerccEBetwEEntheTwo";
         k = 5;
        System.out.println(longest2(s,k));

        s = "aeiouaeiou";
        k = 2;
        System.out.println(longest2(s,k));

        s = "sdfghjklqwrty";
        k = 0;
        System.out.println(longest2(s,k));

        s = "sdfghjkaqwrty";
        k = 1;
        System.out.println(longest2(s,k));
    }

    static int longest(String str, int k){

        char[] s = str.toCharArray();

        int n = s.length;

        int[] count = new int[128];

        int res = 0 ;

        int finali =  0;
        int finalJ = 0;


        for(int i = 0, j = -1; i < n; i++){
            char ch = s[i];

            if(isVowel(ch)){
                if(++count[ch] == 1){
                    k--;
                }
            }

           // System.out.println("k "+k);

            while (k < 0){

                ch = s[++j];
                if(isVowel(ch)){
                    if(--count[ch] == 0) {
                        k++;
                    }
                }

            }

            if(k == 0){
                if(res < i - j){
                    finali = i ;
                    finalJ = j;
                    res = i - j;
                }

            }

        }
        System.out.println("finalI "+finali + " finalJ "+finalJ);

        if(finalJ == -1 ){ finalJ = 0;}
        System.out.println(str.substring(finalJ, finali + 1));

        return res;


    }

    static int longest2(String str, int k){

        char[] s = str.toCharArray();
        int n = s.length;
        int res = 0 ;
        int finali =  0;
        int finalJ = 0;

        for(int i = 0, j = -1; i < n; i++){
            char ch = s[i];

            if(isVowel(ch)){
                    k--;
            }

            while (k < 0){

                ch = s[++j];
                if(isVowel(ch)){
                        k++;
                }

            }

            if(k == 0){

                if(res < i - j){
                    finali = i ;
                    finalJ = j;
                    res = i - j;
                }
            }

        }
        if(finalJ == -1 ){ finalJ = 0;}
        System.out.println(str.substring(finalJ, finali + 1));
        return res;
    }

    static boolean isVowel(char ch){
        return set.contains(ch);
    }
}
