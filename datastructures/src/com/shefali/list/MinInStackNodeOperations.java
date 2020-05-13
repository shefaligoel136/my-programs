package com.shefali.list;

public class MinInStackNodeOperations {
    Node head = null;

    public void push(MinInStackNodeOperations minStack , int data) {
        if (this.head == null || (data<this.peek()&&data<minStack.peek())) {
            minStack.pushInMin(data);
        }
        Node tmp = new Node(data, this.head);
        this.head = tmp;
    }
    public int peek(){
        int k = this.head.data;
        return k;
    }

    public void pushInMin(int data){
        Node tmp = new Node(data, this.head);
        this.head = tmp;
    }
    public void showMin(){
        System.out.println(this.head.data);
    }

    public static void main(String[] args) {
        MinInStackNodeOperations actualStack = new MinInStackNodeOperations();
        MinInStackNodeOperations minStack = new MinInStackNodeOperations();
        actualStack.push(minStack,18);
        actualStack.push(minStack,15);
        actualStack.push(minStack,2);
        actualStack.push(minStack,16);
        actualStack.push(minStack,19);
        actualStack.push(minStack,76);
        minStack.showMin();

    }
}

