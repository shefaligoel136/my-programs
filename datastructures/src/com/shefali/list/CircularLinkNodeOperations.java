package com.shefali.list;

import java.sql.SQLOutput;

public class CircularLinkNodeOperations implements NodeOperations {
    Node head = null;
    int l;
    @Override
    public void del() {
    }
    public void delAt(int pos){
        Node tmp = head;
        //Node tmpNew = null;
        if(tmp==null){
            System.out.println("Nothing to remove");
        }
        else if(pos==0){
            while(tmp.next!=head){
                tmp = tmp.next;
            }
            tmp.next = head.next;
            head = tmp.next;
        }
        else{
            if(pos<=l){
                for (int i = 1; i < pos - 1; i++) {
                    tmp = tmp.next;
                }
                tmp.next = tmp.next.next;
            }
            else{
                System.out.println("Position not found");
            }
        }
    }

    @Override
    public void push(int data) {
        Node tmp = head;
        if(tmp == null) {
            tmp = new Node(data, null);
            head = tmp;
            head.next = head;
        }
        else {
            while(tmp.next != head) {
                tmp = tmp.next;
            }
            tmp.next = new Node(data,head);
        }
    }

    @Override
    public void show() {

        Node tmp = head;
        if (tmp == null) {
            System.out.println("No element to show");
        } else {
            do{
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
            while (tmp != head);
        }
    }


    @Override
    public void length() {
        Node tmp = head;
        l = 0;
        if(tmp==null)
        {
            System.out.println(l);
        }
        else{
            do
            {
                l = l+1;
                tmp = tmp.next;
            }
            while(tmp != head);
            System.out.println(l);
        }

    }

    public void pushAt(int data, int pos) {
        Node tmp = head;
        if (tmp == null && pos > 0) {
            System.out.println("List is empty cannot enter data at this position ");
        } else if (tmp == null && pos == 0) {
            tmp = new Node(data, null);
            head = tmp;
            head.next = head;
        } else if (pos == 0) {
            while (tmp.next != head) {
                tmp = tmp.next;
            }
            Node tmpNew = new Node(data, head);
            tmp.next = tmpNew;
            head = tmpNew;
        } else {
            if (pos <= l) {
                Node previous = null;
                for (int i = 0; i < pos; i++) {
                    previous = tmp;
                    tmp = tmp.next;
                }
                Node newNode = new Node(data, tmp);
                previous.next = newNode;
            } else {
                System.out.println("position not found");
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkNodeOperations CircularlistNodeOperations = new CircularLinkNodeOperations();
        CircularlistNodeOperations.push(10);
        CircularlistNodeOperations.push(20);
        CircularlistNodeOperations.push(30);
        CircularlistNodeOperations.push(40);
        CircularlistNodeOperations.length();
        CircularlistNodeOperations.show();
        CircularlistNodeOperations.pushAt(5,6);
        CircularlistNodeOperations.pushAt(25,3);
        CircularlistNodeOperations.pushAt(45,6);
        CircularlistNodeOperations.length();
        CircularlistNodeOperations.show();
        CircularlistNodeOperations.delAt(0);
        CircularlistNodeOperations.delAt(4);
        CircularlistNodeOperations.delAt(7);
        CircularlistNodeOperations.length();
        CircularlistNodeOperations.show();
    }
}
