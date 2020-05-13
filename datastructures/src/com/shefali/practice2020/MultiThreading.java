package com.shefali.practice2020;

class hi implements Runnable {
    public void run()
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println("hi");
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            { }
        }
    }
}

class hello implements Runnable {
    public void run()
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
    }
}
public class MultiThreading {
    public static void main(String[] args)throws Exception {
        Runnable ob1 = new hi();
        hello ob2 = new hello();

        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);

        t1.setName("hi thread");
        t2.setName("hello thread");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        System.out.println(t1.isAlive());

        t1.start();
        try{
            Thread.sleep(10);
        }
        catch(Exception e)
        { }
        t2.start();

        System.out.println(t1.isAlive());

        t1.join();
        t2.join();
        System.out.println("Bye");
    }
}
