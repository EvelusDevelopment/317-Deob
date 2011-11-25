// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class Deque {

    public Deque(int junk) {
        aClass30_346 = new Node();
        aClass30_346.aClass30_549 = aClass30_346;
        aClass30_346.aClass30_550 = aClass30_346;
    }

    public void addLast(Node class30) {
        if(class30.aClass30_550 != null)
            class30.removeDeque();
        class30.aClass30_550 = aClass30_346.aClass30_550;
        class30.aClass30_549 = aClass30_346;
        class30.aClass30_550.aClass30_549 = class30;
        class30.aClass30_549.aClass30_550 = class30;
    }

    public void addFirst(int junk, Node class30) {
        if(class30.aClass30_550 != null)
            class30.removeDeque();
        class30.aClass30_550 = aClass30_346;
        class30.aClass30_549 = aClass30_346.aClass30_549;
        class30.aClass30_550.aClass30_549 = class30;
        class30.aClass30_549.aClass30_550 = class30;
    }

    public Node pop() {
        Node class30 = aClass30_346.aClass30_549;
        if(class30 == aClass30_346) {
            return null;
        } else {
            class30.removeDeque();
            return class30;
        }
    }

    public Node getFirst()
    {
        Node class30 = aClass30_346.aClass30_549;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        } else
        {
            aClass30_347 = class30.aClass30_549;
            return class30;
        }
    }

    public Node getLast(int junk)
    {
        Node class30 = aClass30_346.aClass30_550;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        } else
        {
            aClass30_347 = class30.aClass30_550;
            return class30;
        }
    }

    public Node getNextForwards(boolean flag)
    {
        Node class30 = aClass30_347;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        } else
        {
            aClass30_347 = class30.aClass30_549;
            return class30;
        }
    }

    public Node getNextBackwards(int i)
    {
        Node class30 = aClass30_347;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        }
        aClass30_347 = class30.aClass30_550;
            return class30;
    }

    public void clear()
    {
        if(aClass30_346.aClass30_549 == aClass30_346)
            return;
        do
        {
            Node class30 = aClass30_346.aClass30_549;
            if(class30 == aClass30_346)
                return;
            class30.removeDeque();
        } while(true);
    }

    public Node aClass30_346;
    public Node aClass30_347;
}
