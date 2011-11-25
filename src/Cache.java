// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class Cache {

    public Cache(boolean junk, int i) {
        aBoolean295 = false;
        aBoolean297 = false;
        aClass30_Sub2_300 = new SubNode();
        aClass2_304 = new Queue(anInt296);
        anInt301 = i;
        anInt302 = i;
        aClass1_303 = new HashTable(-877, 1024);
    }

    public SubNode method222(long l)
    {
        SubNode class30_sub2 = (SubNode)aClass1_303.getNode(l);
        if(class30_sub2 != null)
        {
            aClass2_304.add(class30_sub2);
            anInt299++;
        } else
        {
            anInt298++;
        }
        return class30_sub2;
    }

    public void method223(SubNode class30_sub2, long l, byte junk)
    {
        try
        {
            if(anInt302 == 0)
            {
                SubNode class30_sub2_1 = aClass2_304.method151();
                class30_sub2_1.removeDeque();
                class30_sub2_1.removeQueue();
                if(class30_sub2_1 == aClass30_Sub2_300)
                {
                    SubNode class30_sub2_2 = aClass2_304.method151();
                    class30_sub2_2.removeDeque();
                    class30_sub2_2.removeQueue();
                }
            } else
            {
                anInt302--;
            }
            aClass1_303.put(class30_sub2, l, (byte)7);
            aClass2_304.add(class30_sub2);
            return;
        } catch (RuntimeException runtimeexception) {
			runtimeexception.printStackTrace();
            signlink.reporterror("47547, " + class30_sub2 + ", " + l + ", " + junk + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void clear() {
        do
        {
            SubNode class30_sub2 = aClass2_304.method151();
            if(class30_sub2 != null) {
                class30_sub2.removeDeque();
                class30_sub2.removeQueue();
            } else {
                anInt302 = anInt301;
                return;
            }
        } while(true);
    }

    public boolean aBoolean295;
    public static int anInt296;
    public boolean aBoolean297;
    public int anInt298;
    public int anInt299;
    public SubNode aClass30_Sub2_300;
    public int anInt301;
    public int anInt302;
    public HashTable aClass1_303;
    public Queue aClass2_304;
}
