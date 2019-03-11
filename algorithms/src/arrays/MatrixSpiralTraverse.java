package arrays;

public class MatrixSpiralTraverse {

    public static void main(String[] args) {

        int[][] a = {{1,   2, 3,   4,  5, 6},
                     {7,   8, 9,  10, 11, 12},
                     {13, 14, 15, 16, 17, 18}
        };
        traverse(a);
    }

    static void traverse(int[][] a){
        int row = 0;
        int col = 0;
        int rows = a.length  ;
        int cols = a[0].length;

        while (row < rows && col  < cols){

            for(int i = col; i < cols; i++){
                System.out.print(a[row][i] + " ");
            }
            row++;

            for(int i = row; i <rows; i++){
                System.out.print(a[i][cols-1] + " ");
            }
            cols--;

            if( row <= rows) {
                for (int i = cols -1; i >= col; i--) {
                    System.out.print(a[rows-1][i] + " ");
                }
                rows--;
            }
            if(col <= cols) {
                for (int i = rows-1 ; i >= row; i--) {
                    System.out.print(a[i][col] + " ");
                }
                col++;
            }

        }
    }
}
