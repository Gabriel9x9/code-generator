package src.com.halo.acm;

import java.util.Scanner;

public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            // get length
            int n=scanner.nextInt();
            // read array
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }

            // logic
            int sum=0;
            for(int num:arr){
                sum+=num;
            }
            System.out.println(("Sum: " + sum));
        }

        scanner.close();
    }
}
