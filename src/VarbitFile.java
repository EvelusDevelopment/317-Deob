// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.PrintStream;
import sign.signlink;

public class VarbitFile {

    public static void method533(int i, FileContainer class44) {
        if(i != 0)
            anInt644 = 91;
        Buffer buffer0 = new Buffer(class44.getEntry("varbit.dat", null));
        anInt645 = buffer0.getShort();
        if(aClass37Array646 == null)
            aClass37Array646 = new VarbitFile[anInt645];
        for(int j = 0; j < anInt645; j++) {
            if(aClass37Array646[j] == null)
                aClass37Array646[j] = new VarbitFile();
            aClass37Array646[j].method534(buffer0, false, j);
            if(aClass37Array646[j].aBoolean651)
                VarpFile.aClass41Array701[aClass37Array646[j].config_num].aBoolean713 = true;
        }

        if(buffer0.position != buffer0.payload.length)
            System.out.println("varbit load mismatch");
    }

    public void method534(Buffer buffer0, boolean flag, int i)
    {
        if(flag)
            return;
        do
        {
            int j = buffer0.getUByte();
            if(j == 0)
                return;
            if(j == 1)
            {
                config_num = buffer0.getShort();
                anInt649 = buffer0.getUByte();
                anInt650 = buffer0.getUByte();
            } else
            if(j == 10)
                aString647 = buffer0.getCStr();
            else
            if(j == 2)
                aBoolean651 = true;
            else
            if(j == 3)
                anInt652 = buffer0.getInt();
            else
            if(j == 4)
                anInt653 = buffer0.getInt();
            else
                System.out.println("Error unrecognised config code: " + j);
        } while(true);
    }

    public VarbitFile()
    {
        aBoolean651 = false;
        anInt652 = -1;
    }

    public static int anInt644;
    public static int anInt645;
    public static VarbitFile aClass37Array646[];
    public String aString647;
    public int config_num;
    public int anInt649;
    public int anInt650;
    public boolean aBoolean651;
    public int anInt652;
    public int anInt653;
}
