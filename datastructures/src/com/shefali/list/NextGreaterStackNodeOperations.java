package com.shefali.list;

public class NextGreaterStackNodeOperations {
    Node head = null;
    public void push(int data){
        if(head==null) {
            Node tmp = new Node(data, head);
            head = tmp;
        }
        else if(peep()<data){
            if(head!=null) {
                System.out.println(peep() + "'s" + " " + "next greater element is " + data);
                pop();
            }
            Node tmp = new Node(data, head);
            head = tmp;
        }
        else{
            Node tmp = new Node(data, head);
            head = tmp;
        }

    }
    public int peep(){
        int k = head.data;
        return k;
    }
    public void pop(){
        if(head==null)
        {
            System.out.println("no element to delete");
        }
        else {
            head = head.next;
        }
    }
    public void nextGreaterElement() {
        int k = peep();
        while (head != null) {
            if(head.data>=k) {
                System.out.println(peep() + "'s" + " " + "next greater element is -1 ");
            }
            else{
                System.out.println(peep() + "'s" + " " + "next greater element is " + k);
            }
            pop();
        }
    }

    public static void main(String[] args) {
        NextGreaterStackNodeOperations greaterElement = new NextGreaterStackNodeOperations();
        greaterElement.push(11);
        greaterElement.push(13);
        greaterElement.push(21);
        greaterElement.push(3);
        greaterElement.nextGreaterElement();
    }
}
