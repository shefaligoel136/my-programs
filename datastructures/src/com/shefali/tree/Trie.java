package com.shefali.tree;

public class Trie {
    Trie first;
    Trie second;
    Trie third;
    Trie fourth;
    Trie eof;
    char ch;

    Trie(char ch)
    {
        this.ch = ch;
        this.first = null;
        this.second = null;
        this.third = null;
        this.fourth = null;
        this.eof = null;
    }

    public void insert(String word, Trie root)
    {
        Trie t = root;
        char[] chars = word.toCharArray();
        for(char e: chars)
        {
            switch(e)
            {
                case 'a':
                    if(t.first == null) {
                        t.first = new Trie('a');
                    }
                    t = t.first;
                    break;
                case 'b':
                    if(t.second == null) {
                        t.second = new Trie('b');
                    }
                    t = t.second;
                    break;
                case 'c':
                    if(t.third == null) {
                        t.third = new Trie('c');
                    }
                    t = t.third;
                    break;
                case 'd':
                    if(t.fourth == null) {
                        t.fourth = new Trie('d');
                    }
                    t = t.fourth;
                    break;
            }
        }
        t.eof = new Trie('\n');
    }

    public void inOrderTraversal(Trie t, String str) {
        if(t == null) {
            return;
        }
        if(t.eof != null) {
            System.out.println(str + t.ch);
        }
        str = str + t.ch;
        inOrderTraversal(t.first, str);
        inOrderTraversal(t.second, str);
        inOrderTraversal(t.third, str);
        inOrderTraversal(t.fourth, str);
    }

    public boolean search(String word, Trie root) {
        Trie t = root;
        char[] chars = word.toCharArray();
        for(char e: chars)
        {
            switch(e)
            {
                case 'a':
                    if(t.first != null) {
                        t = t.first;
                        continue;
                    }
                    else
                        return false;
                case 'b':
                    if(t.second != null) {
                        t = t.second;
                        continue;

                    }
                    else
                        return false;
                case 'c':
                    if(t.third != null) {
                        t = t.third;
                        continue;
                    }
                    else
                        return false;
                case 'd':
                    if(t.fourth != null) {
                        t = t.fourth;
                        continue;
                    }
                    else
                        return false;
                default:
                    return false;
            }
        }
        if(t.eof != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Trie root = new Trie('\u0000');
        root.insert("da", root);
        root.insert("abcd", root);
        root.insert("aaaa", root);
        root.insert("abd", root);
        root.insert("bca", root);
        root.insert("abc", root);
        root.insert("bda", root);
        root.insert("bc", root);
        root.inOrderTraversal(root, "");
        System.out.println(root.search("aaaa", root));
        System.out.println(root.search("aaa", root));
        System.out.println(root.search("bb", root));
        System.out.println(root.search("bda", root));
        System.out.println(root.search("bca", root));
        System.out.println(root.search("sdfsdj", root));
    }

}