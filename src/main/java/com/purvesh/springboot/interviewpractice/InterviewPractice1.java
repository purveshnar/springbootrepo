package com.purvesh.springboot.interviewpractice;


/**
 * Existing numbers:    0123456789
 * New Numbers:         9876543210
 *
 * Number range: 0 <= N <= 1000000
 *
 * Given Input 12345
 * Answer is   87654
 *
 */
public class InterviewPractice1 {

    private static int[] getNumericArray() {
        int [] arr = new int[10];
        for(int i = 0;i<10;i++){
            arr[i] = 9-i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numericArray = getNumericArray();

        int n = 1000;
        int ans = 0;
        int power=1;

        if(n > 1000000)
            return;

        while(n > 0){
            int remainder = n % 10;
            int replaceBy = numericArray[remainder];
            ans = ans + replaceBy*power;
            power*=10;
            n=n/10;
        }
        System.out.println("ans = " + ans);
    }
}
