package com.shefali.list;

public class StackNodeOperations implements NodeOperations {

    Node head = null;

    @Override
    public void push(int data) {
        Node tmp = new Node(data,null);
        tmp.next = head;
        head = tmp;
    }

    @Override
    public void del() {
        if(head==null)
        {
            System.out.println("no element to delete");
        }
        else {
            head = head.next;
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
        StackNodeOperations stackNodeOperations = new StackNodeOperations();
        stackNodeOperations.push(10);
        stackNodeOperations.push(20);
        stackNodeOperations.push(30);
        stackNodeOperations.push(40);
        stackNodeOperations.length();
        stackNodeOperations.show();
        stackNodeOperations.del();
        stackNodeOperations.del();
        stackNodeOperations.del();
        stackNodeOperations.show();
        stackNodeOperations.del();
        stackNodeOperations.del();
        stackNodeOperations.show();
        stackNodeOperations.push(20);
        stackNodeOperations.push(30);
        stackNodeOperations.show();
        stackNodeOperations.length();


    }
}
