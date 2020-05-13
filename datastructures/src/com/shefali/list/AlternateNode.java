package com.shefali.list;

public class AlternateNode implements NodeOperations {
    Node head = null;

    @Override
    public void push(int data) {
        Node tmp = head;
        if (tmp == null) {
            tmp = new Node(data, null);
            head = tmp;
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node(data, null);
        }
    }

    @Override
    public void del() {
        Node tmp = head;
        if (tmp == null) {
            return;
        } else if (tmp.next == null) {
            head = null;
        } else {
            head = head.next;
        }

    }

    @Override
    public void show() {
        Node tmp = head;
        if (tmp == null) {
            System.out.println("No element to show");
        } else {
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }

    }

    @Override
    public void length() {
        Node tmp = head;
        int ln = 0;
        if (tmp == null) {
            System.out.println(ln);
        } else {
            while (tmp != null) {
                ln = ln + 1;
                tmp = tmp.next;
            }
            System.out.println(ln);
        }
    }

    public void alternate(AlternateNode an1, AlternateNode an2) {
        Node tmp1 = an1.head;
        Node tmp2 = an2.head;
        while(tmp1 != null && an2.head!=null) {
            int d = an2.head.data;
            Node a = new Node(d, null);
            an2.del();
            a.next = tmp1.next;
            tmp1.next = a;
            tmp1 = tmp1.next.next;
        }
    }

    public static void main(String[] args) {
        AlternateNode an1 = new AlternateNode();
        AlternateNode an2 = new AlternateNode();

        an1.push(10);
        an1.push(30);
        an1.push(50);
        an1.push(70);
        an1.push(90);

        an2.push(20);
        an2.push(40);
        an2.push(60);
//        an2.push(80);
//        an2.push(100);

        an1.alternate(an1, an2);
        an1.show();
        an2.show();
    }
}
