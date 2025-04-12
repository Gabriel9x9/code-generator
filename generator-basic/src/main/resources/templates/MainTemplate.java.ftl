package src.com.gabriel.acm;

import java.util.Scanner;


/**
 * ACM 输入模板（多个数之和）
 * @author ${author!''}
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
<#if loop>
        while(scanner.hasNext()){
</#if>
            // get length
            int n=scanner.nextInt();
            // read array
            int[] arr=new int[n];
            for(int i=0;i < n;i++){
                arr[i]=scanner.nextInt();
            }

            // logic
            int sum=0;
            for(int num:arr){
                sum+=num;
            }
            System.out.println("${outputText}" + sum);
            }

<#if loop>
        }
</#if>
        scanner.close();
    }
}

