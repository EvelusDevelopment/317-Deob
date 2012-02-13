// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class Queue {

    public Queue(int junk) {
        aClass30_Sub2_43 = new SubNode();
        aClass30_Sub2_43.aClass30_Sub2_1303 = aClass30_Sub2_43;
        aClass30_Sub2_43.aClass30_Sub2_1304 = aClass30_Sub2_43;
    }

    public void add(SubNode class30_sub2) {
        if(class30_sub2.aClass30_Sub2_1304 != null)
            class30_sub2.removeQueue();
        class30_sub2.aClass30_Sub2_1304 = aClass30_Sub2_43.aClass30_Sub2_1304;
        class30_sub2.aClass30_Sub2_1303 = aClass30_Sub2_43;
        class30_sub2.aClass30_Sub2_1304.aClass30_Sub2_1303 = class30_sub2;
        class30_sub2.aClass30_Sub2_1303.aClass30_Sub2_1304 = class30_sub2;
    }

    public SubNode poll()
    {
        SubNode class30_sub2 = aClass30_Sub2_43.aClass30_Sub2_1303;
        if(class30_sub2 == aClass30_Sub2_43)
        {
            return null;
        } else
        {
            class30_sub2.removeQueue();
            return class30_sub2;
        }
    }

    public SubNode getFirst() {
        SubNode class30_sub2 = aClass30_Sub2_43.aClass30_Sub2_1303;
        if(class30_sub2 == aClass30_Sub2_43) {
            aClass30_Sub2_44 = null;
            return null;
        } else {
            aClass30_Sub2_44 = class30_sub2.aClass30_Sub2_1303;
            return class30_sub2;
        }
    }

    public SubNode next(boolean junk) {
        SubNode class30_sub2 = aClass30_Sub2_44;
        if(class30_sub2 == aClass30_Sub2_43) {
            aClass30_Sub2_44 = null;
            return null;
        } else {
            aClass30_Sub2_44 = class30_sub2.aClass30_Sub2_1303;
            return class30_sub2;
        }
    }

    public int size() {
        int i = 0;
        for(SubNode class30_sub2 = aClass30_Sub2_43.aClass30_Sub2_1303; class30_sub2 != aClass30_Sub2_43; class30_sub2 = class30_sub2.aClass30_Sub2_1303)
            i++;
        return i;
    }

    public SubNode aClass30_Sub2_43;
    public SubNode aClass30_Sub2_44;
}
