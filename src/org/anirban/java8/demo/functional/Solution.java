package org.anirban.java8.demo.functional;


import java.util.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Arrays.parallelSort(arr);
        long minsum=0,maxsum=0;
        int y=0;
        for(int k:arr)
        {
            minsum+=k;
            y=k;
        }
        maxsum=minsum-arr[0];
        minsum-=y;
        System.out.println(minsum + " " + maxsum);
    }

	/*
	 * static int[] sort(int input[]) { int temp=0; for (int
	 * i=0;i<input.length-1;i++) { for(int j=i+1;j<input.length;j++) {
	 * if(input[i]>input[j]) { temp=input[i]; input[i]=input[j]; input[j]=temp;} } }
	 * return input; }
	 */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
