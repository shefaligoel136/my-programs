package com.shefali.list;

public class DoubleListNodeOperation implements NodeOperations {

    DoubleNode head = null;

    @Override
    public void del() {
        DoubleNode tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.previous.next = null;

    }
    public void delAt(int pos) {
        DoubleNode tmp = head;
        DoubleNode temp = null ;

        if(pos==0 && head==null){
            System.out.println("Nothing to remove");
        }
        else if(pos==0){
            head = tmp.next;
            head.previous = null;
        }
        else{
            for(int i=1;i<pos;i++){
                temp = tmp;
                tmp = tmp.next;
            }
            if(tmp==null){
                tmp.previous.next = null;
            }
            else{
                temp.next = tmp.next;
                tmp.next.previous = tmp.previous;
            }

        }

    }

    @Override
    public void length() {
        DoubleNode tmp = head;
        int l = 0;
        if (tmp == null) {
            System.out.println(l);
        } else {
            while (tmp != null) {
                l = l + 1;
                tmp = tmp.next;
            }
            System.out.println(l);
        }
    }

    @Override
    public void push(int data) {
        DoubleNode tmp = head;
        if (tmp == null) {
            tmp = new DoubleNode(data, null, null);
            head = tmp;
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new DoubleNode(data, null, tmp);
        }
    }

    @Override
    public void show() {
        DoubleNode tmp = head;
        if (tmp == null) {
            System.out.println("No element to show");
        } else {
            while (tmp!= null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
    }
    public void showRev() {
        DoubleNode tmp = head;
        if (tmp == null) {
            System.out.println("No element to show");
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            System.out.println(tmp.data);

            while(tmp.previous != null){
                tmp = tmp.previous;
                System.out.println(tmp.data);
            }
        }
    }
    public void pushAt(int data, int pos){
        DoubleNode tmp = head;
        DoubleNode temp2 = null ;
        if (tmp == null) {
            tmp = new DoubleNode(data, null, null);
            head = tmp;
        }
        else if(pos==0){
            tmp = new DoubleNode(data,head,null);
            head.previous = tmp;
            head = tmp;
        }
        else{
            for(int i = 0;i<pos;i++){
                temp2 = tmp;
                tmp = tmp.next;
            }
            DoubleNode temp1 = new DoubleNode(data, tmp, temp2);
            temp1.next.previous = temp1;
            temp2.next = temp1;
        }

    }

    public static void main(String[] args) {
        DoubleListNodeOperation doublelistNodeOperations = new DoubleListNodeOperation();
        doublelistNodeOperations.pushAt(5,0);
        doublelistNodeOperations.push(10);
        doublelistNodeOperations.push(20);
        doublelistNodeOperations.push(30);
        doublelistNodeOperations.push(40);
        doublelistNodeOperations.length();
        doublelistNodeOperations.show();
        doublelistNodeOperations.pushAt(25,0);
        doublelistNodeOperations.pushAt(35,4);
        //doublelistNodeOperations.pushAt(45,6);
        doublelistNodeOperations.length();
        doublelistNodeOperations.delAt(0);
        doublelistNodeOperations.delAt(4);
        doublelistNodeOperations.showRev();
    }
}
