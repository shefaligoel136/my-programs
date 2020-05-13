package com.shefali.practice2020;

public class LambdaExpression {
    public static void main(String[] args) {

        Thread t1 = new Thread(() ->
        {
            for(int i=1; i<=5; i++)
            {
                System.out.println("hi" + Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                }
                catch(Exception e)
                { }
            }
        },"hi thread");
        Thread t2 = new Thread(() ->
        {
            for(int i=1; i<=5; i++)
            {
                System.out.println("hello");
                try{
                    Thread.sleep(500);
                }
                catch(Exception e)
                { }
            }
        },"hello thread");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t1.start();
        try{
            Thread.sleep(10);
        }
        catch(Exception e)
        { }
        t2.start();
    }
}
