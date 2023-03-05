package LAB1;

import java.sql.Array;

public class ex2 {

    public static void main(String[] args) {
        int[][] first = {{2,3,1},{7,1,6},{9,2,4}};
        int[][] second = {{8,5,3},{3,9,2},{2,7,3}};
        int sum;
        int[][] third = new int[3][3];

        int[][] sum_array = new int[3][3];

        for (int i = 0 ; i < first.length ; i++)
            for (int j = 0; j < second.length ; j++) {
                sum_array[i][j] = first[i][j] + second[i][j];
            }

        for (int i = 0; i < first.length ; i++){
            for(int j = 0 ; j < first.length ; j++){
                sum = 0;
                for(int k = 0 ; k < first.length ; k++)
                    sum += first[i][k] * second[k][j];
                third[i][j] = sum;
            }
        }
        for(int i = 0; i<3 ; i++){
            for(int j = 0 ; j <3 ; j++)
                System.out.print(sum_array[i][j] + " ");
            System.out.println();
        }

        for(int i = 0; i< 3;i++){
            for(int j = 0 ; j <3 ; j++)
                System.out.print(third[i][j] + " ");
            System.out.println();
        }


    }

}
