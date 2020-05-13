package com.shefali.practice2020;

class hii extends Thread
{
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println("hii");
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
        }
    }

}
class helloo extends Thread
{
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println("helloo");
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
    hii obj1 = new hii();
    helloo obj2 = new helloo();

    obj1.start();
        try{
            Thread.sleep(10);
        }
        catch(Exception e)
        { }
    obj2.start();
    }
}
