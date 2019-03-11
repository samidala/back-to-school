package arrays;

public class PrintNos {

    public static void main(String[] args) {

        int n = 21;
        int lastValue = 1;
        for(int i = 1; lastValue <= n;i++){
            int k = lastValue;
            for(int j=1; j<=i && k<=n;j++,k++){
                System.out.print(k+" ");
            }
            lastValue = k;
            System.out.println();
        }
    }
}
