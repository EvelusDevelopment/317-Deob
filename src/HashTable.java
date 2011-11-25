// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class HashTable {

    public HashTable(int junk, int s) {
        size = s;
        nodes = new Node[s];
        for(int pos = 0; pos < s; pos++) {
            Node class30 = nodes[pos] = new Node();
            class30.aClass30_549 = class30;
            class30.aClass30_550 = class30;
        }
    }

    public Node getNode(long l) {
        Node class30 = nodes[(int)(l & (long)(size - 1))];
        for(Node class30_1 = class30.aClass30_549; class30_1 != class30; class30_1 = class30_1.aClass30_549)
            if(class30_1.key == l)
                return class30_1;
        return null;
    }

    public void put(Node class30, long l, byte junk) {
        try {
			/* Prevent collisions */
            if(class30.aClass30_550 != null)
                class30.removeDeque();
            Node class30_1 = nodes[(int)(l & (long)(size - 1))];
            class30.aClass30_550 = class30_1.aClass30_550;
            class30.aClass30_549 = class30_1;
            class30.aClass30_550.aClass30_549 = class30;
            class30.aClass30_549.aClass30_550 = class30;
			class30.key = l;
			return;
        } catch(RuntimeException runtimeexception) {
            signlink.reporterror("91499, " + class30 + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int size;
    public Node nodes[];
}
