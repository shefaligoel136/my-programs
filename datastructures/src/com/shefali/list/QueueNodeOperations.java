package com.shefali.list;

public class QueueNodeOperations implements NodeOperations {

    Node head = null;

    @Override
    public void push(int data) {
        Node tmp = head;
        if(tmp == null)
        {
            tmp = new Node(data,null);
            head = tmp;
        }
        else
        {
            while(tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = new Node(data,null);
        }
    }

    @Override
    public void del() {
        Node tmp = head;
        if(tmp == null)
        {
            System.out.println("No Element");
        }
        else if(tmp.next == null)
        {
            head = null;
        }
        else
        {
            head = head.next;
//            while(tmp.next.next!=null)
//            {
//                tmp = tmp.next;
//            }
//            tmp.next = null;
        }
    }

    @Override
    public void show() {
        Node tmp = head;
        if(tmp==null)
        {
            System.out.println("No element to show");
        }
        else {
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }

    }

    @Override
    public void length() {
        Node tmp = head;
        int l = 0;
        if(tmp==null)
        {
            System.out.println(l);
        }
        else{
            while(tmp != null)
            {
                l = l+1;
                tmp = tmp.next;
            }
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        QueueNodeOperations queueNodeOperations = new QueueNodeOperations();
        queueNodeOperations.push(10);
        queueNodeOperations.push(20);
        queueNodeOperations.push(30);
        queueNodeOperations.push(40);
        queueNodeOperations.length();
        queueNodeOperations.show();
        queueNodeOperations.del();
        queueNodeOperations.del();
        queueNodeOperations.del();
        queueNodeOperations.show();
        queueNodeOperations.del();
        queueNodeOperations.del();
        queueNodeOperations.show();
        queueNodeOperations.push(20);
        queueNodeOperations.push(30);
        queueNodeOperations.show();
        queueNodeOperations.length();


    }
}
