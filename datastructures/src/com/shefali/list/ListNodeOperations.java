package com.shefali.list;

import java.sql.SQLOutput;

public class ListNodeOperations implements NodeOperations{

    static Node head = null;

    @Override
    public void del() {

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

    @Override
    public void push(int data) {
    Node tmp = head;
    if(tmp == null){
        tmp = new Node(data,null);
        head = tmp;
    }
    else{
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        tmp.next = new Node(data,null);
    }

    }

    public void pushAt(int data, int pos){
        Node tmp = head;
        if(tmp == null){
            tmp = new Node(data,null);
            head = tmp;
        }
        else if(pos==0){
            tmp = new Node(data,head);
            head = tmp;
        }
        else{
            Node previous = null;
            for(int i = 0;i<pos;i++)
            {
               previous = tmp;
                tmp = tmp.next;
            }
            Node newNode = new Node(data,tmp);
            previous.next = newNode;
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

    public void delAt(int pos){
        Node tmp = head;
        if(pos == 0)
        {
            tmp = tmp.next;
            head = tmp;
        }
        else {
            for (int i = 1; i < pos - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
    }

    public void reverse(){
        Node current = head;
        Node prev = null;
        Node tmp  = null;
        while(current.next!=null) {

            tmp = current.next;
           // current.next.next = current;
            current.next = prev;

            prev = current;
            current = tmp;
        }
        head = prev;
    }
    public Node nthNodeFromEnd(int nthNode){
        Node nth = null;
        Node tmp = head;
        for(int count=1;count<nthNode;count++){
            if(tmp!=null) {
                tmp = tmp.next;
            }
        }
        while(tmp!=null){
            if(nth==null){
                nth = head;
            }
            else{
                nth = nth.next;
            }
            tmp = tmp.next;
        }
        if(nth!=null){
            return nth;
        }
        return null;

    }

    public Node middleM1(){
        int counter =0;
        Node mid = head;
        Node tmp = head;
        if(mid.next==null){
            return mid;
        }
        while(tmp!=null){
            if(counter%2!=0){
                mid = mid.next;
            }
            counter++;
            tmp = tmp.next;
        }
        return mid;

    }

    public Node middleM2(){
        Node tmp = head;
        Node mid = head;
        while(tmp!=null && tmp.next!=null){
            tmp=tmp.next.next;
            mid = mid.next;
        }
        return mid;
    }

    public void removeDuplicateFromSorted(){
        Node tmp = head;
        Node temp;
        while(tmp!=null){
            temp = tmp;
            while(tmp!=null && temp.data == tmp.data ){
                tmp = tmp.next;
            }
            temp.next = tmp;
            temp = temp.next;
        }
    }

    public void swapNode(int x, int y){
        Node prevX = null;
        Node prevY = null;
        Node currX = head;
        Node currY = head;

        if(x!=y){
            while(currX!=null && currX.data!=x){
                prevX = currX;
                currX = currX.next;
            }
            while(currY!=null && currY.data!=y){
                prevY = currY;
                currY = currY.next;
            }
            if(currX==null || currY==null){
                System.out.println("Key Not found");
            }
            if (prevX != null)
                prevX.next = currY;
            else //make y the new head
                head = currY;

            // If y is not head of linked list
            if (prevY != null)
                prevY.next = currX;
            else // make x the new head
                head = currX;

            // Swap next pointers
            Node temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;
        }
    }

    public void lastTOfirst(){
        Node prev = null;
        Node curr = head;
        if(curr!=null && curr.next!=null){
            while(curr.next!=null){
                prev = curr;
                curr = curr.next;
            }
            curr.next = head;
            prev.next = null;
            head = curr;
        }
    }

    public void evenNodd() {
        Node end = head;
        Node curr = head;
        Node prev = null;
        while(end.next!=null){
            end = end.next;
        }
        Node endNode = end;

        while(curr!=endNode){
              if(curr.data%2!=0){
                  if(curr==head){
                      //prev = curr;
                      head = head.next;
                  }
                  prev.next = curr.next;
                  curr.next = null;
                  end.next = curr;
                  end = curr;
                  curr = prev.next;

              }
              else{
                  prev = curr;
                  curr = curr.next;
              }
        }
    }

    public void delAlternate(){
        Node prev = null;
        Node curr = head;

        while(curr!= null && curr.next!=null){
            prev = curr;
            curr = curr.next.next;
            prev.next = curr;
        }

    }

    public void delLesserNodes(){
        Node prev = null;
        Node curr = head;
        while(curr.next!=null) {
            if (curr.data < curr.next.data) {
                if (prev == null) {
                    head = curr.next;
                    curr.next = null;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void rotatebyK(int k){
        Node temp = null;
        Node tmp = head;
        Node newHead = null;
        for(int i=1;i<k;i++){
            tmp = tmp.next;
        }
        temp = tmp.next;
        newHead = temp;
        tmp.next = null;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        head = newHead;
    }

    public void deleteNafterM(int m,int n) {
        int countM;
        int countN;
        Node tmp = head;
        Node temp = null;
        while (tmp!= null) {
            for (countM = 1; countM < m && tmp!=null ; countM++) {
                tmp = tmp.next;
            }
            if(tmp==null){
                break;
            }
            temp = tmp.next;
            for (countN = 1; countN <n && temp!=null ; countN++) {
                temp = temp.next;
            }
            if(temp.next!=null) {
                tmp.next = temp.next;
            }
            else{
                tmp.next=null;
            }
            tmp = tmp.next;
        }
    }
    public static Node recursivelyReverse(Node head){
        if(head==null || head.next==null)
        return head;
        Node newHead = recursivelyReverse(head.next);
            head.next.next = head;
            head.next = null;
        System.out.println(head.data);

        return newHead;
    }

    public static void main(String[] args) {
        ListNodeOperations listNodeOperations = new ListNodeOperations();
        listNodeOperations.push(12);
        listNodeOperations.push(15);
        listNodeOperations.push(10);
        listNodeOperations.push(11);
        listNodeOperations.push(5);
        listNodeOperations.push(6);
        listNodeOperations.push(2);
        listNodeOperations.push(3);
        //listNodeOperations.push(9);
        //listNodeOperations.evenNodd();
        //listNodeOperations.delAlternate();
        //listNodeOperations.delLesserNodes();
        //listNodeOperations.rotatebyK(4);
        //listNodeOperations.deleteNafterM(2,2);
       // listNodeOperations.show();
//        listNodeOperations.removeDuplicateFromSorted();
//        listNodeOperations.length();
//        listNodeOperations.show();
//        Node nodeIs = listNodeOperations.nthNodeFromEnd(2);
//        System.out.println(nodeIs.data + " Is present! ");
//
//        Node mid1Is = listNodeOperations.middleM1();
//        System.out.println(mid1Is.data + " Is the middle term! ");
//
//        Node mid2Is = listNodeOperations.middleM2();
//        System.out.println(mid2Is.data + " Is the middle term! ");
        //queueNodeOperations.del();

//        listNodeOperations.swapNode(30,50);
//        listNodeOperations.show();
//
//        listNodeOperations.lastTOfirst();
//        listNodeOperations.show();
//
//        listNodeOperations.pushAt(25,2);
//        listNodeOperations.pushAt(35,4);
//        listNodeOperations.show();
//        listNodeOperations.length();
//        listNodeOperations.delAt(0);
//        listNodeOperations.show();
//        listNodeOperations.length();
//        listNodeOperations.delAt(4);
//        listNodeOperations.reverse();
//        listNodeOperations.show();
//        listNodeOperations.length();
          Node n = recursivelyReverse(head);
          listNodeOperations.show();

    }
}
