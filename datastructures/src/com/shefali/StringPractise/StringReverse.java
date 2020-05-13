package com.shefali.StringPractise;
import java.util.Scanner;
public class StringReverse {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        String s= "Enter your name" , s1 = " ", s2 = " ";
        int i,k;
        //System.out.println("Enter a string");
        //s = sc.nextLine();
        for(i=0;i<s.length();)
        {
            k = i;
                while (k<s.length() && s.charAt(k) != ' ') {
                    s1 = s1 + s.charAt(k);
                    k++;
                }
            i = k+1;
            k = k+1;

            s2 = s1+s2;
            s1 = " ";
        }
        System.out.println("string is" + s2);
    }

}
