// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.PrintStream;
import sign.signlink;

public class AnimSequence {

    public static void unpackAnimSequences(ContainerArchive archive) {
        Buffer buffer0 = new Buffer(archive.getEntry("seq.dat", null));
        amountanimationseqs = buffer0.getShort();
        if(animationsequences == null)
            animationsequences = new AnimSequence[amountanimationseqs];
        for(int j = 0; j < amountanimationseqs; j++) {
            if(animationsequences[j] == null)
                animationsequences[j] = new AnimSequence();
            animationsequences[j].loadAnimSeq(true, buffer0);
        }
    }

    public int method258(int i, byte byte0)
    {
        int j = anIntArray355[i];
        if(byte0 != -39)
        {
            for(int k = 1; k > 0; k++);
        }
        if(j == 0)
        {
            AnimFrame class36 = AnimFrame.getAnimationFrame(anIntArray353[i]);
            if(class36 != null)
                j = anIntArray355[i] = class36.anInt636;
        }
        if(j == 0)
            j = 1;
        return j;
    }

    public void loadAnimSeq(boolean flag, Buffer buffer0)
    {
        if(!flag)
            aBoolean349 = !aBoolean349;
        do
        {
            int opcode = buffer0.getUByte();
            if(opcode == 0)
                break;
            if(opcode == 1)
            {
                anInt352 = buffer0.getUByte();
                anIntArray353 = new int[anInt352];
                anIntArray354 = new int[anInt352];
                anIntArray355 = new int[anInt352];
                for(int j = 0; j < anInt352; j++)
                {
                    anIntArray353[j] = buffer0.getShort();
                    anIntArray354[j] = buffer0.getShort();
                    if(anIntArray354[j] == 65535)
                        anIntArray354[j] = -1;
                    anIntArray355[j] = buffer0.getShort();
                }

            } else
            if(opcode == 2)
                anInt356 = buffer0.getShort();
            else
            if(opcode == 3)
            {
                int k = buffer0.getUByte();
                anIntArray357 = new int[k + 1];
                for(int l = 0; l < k; l++)
                    anIntArray357[l] = buffer0.getUByte();

                anIntArray357[k] = 0x98967f;
            } else
            if(opcode == 4)
                aBoolean358 = true;
            else
            if(opcode == 5)
                anInt359 = buffer0.getUByte();
            else
            if(opcode == 6)
                anInt360 = buffer0.getShort();
            else
            if(opcode == 7)
                anInt361 = buffer0.getShort();
            else
            if(opcode == 8)
                anInt362 = buffer0.getUByte();
            else
            if(opcode == 9)
                anInt363 = buffer0.getUByte();
            else
            if(opcode == 10)
                anInt364 = buffer0.getUByte();
            else
            if(opcode == 11)
                anInt365 = buffer0.getUByte();
            else
            if(opcode == 12)
                anInt366 = buffer0.getInt();
            else
                System.out.println("Error unrecognised seq config code: " + opcode);
        } while(true);
        if(anInt352 == 0)
        {
            anInt352 = 1;
            anIntArray353 = new int[1];
            anIntArray353[0] = -1;
            anIntArray354 = new int[1];
            anIntArray354[0] = -1;
            anIntArray355 = new int[1];
            anIntArray355[0] = -1;
        }
        if(anInt363 == -1)
            if(anIntArray357 != null)
                anInt363 = 2;
            else
                anInt363 = 0;
        if(anInt364 == -1)
        {
            if(anIntArray357 != null)
            {
                anInt364 = 2;
                return;
            }
            anInt364 = 0;
        }
    }

    public AnimSequence()
    {
        anInt348 = 9;
        aBoolean349 = false;
        anInt356 = -1;
        aBoolean358 = false;
        anInt359 = 5;
        anInt360 = -1;
        anInt361 = -1;
        anInt362 = 99;
        anInt363 = -1;
        anInt364 = -1;
        anInt365 = 2;
    }

    public int anInt348;
    public boolean aBoolean349;
    public static int amountanimationseqs;
    public static AnimSequence animationsequences[];
    public int anInt352;
    public int anIntArray353[];
    public int anIntArray354[];
    public int anIntArray355[];
    public int anInt356;
    public int anIntArray357[];
    public boolean aBoolean358;
    public int anInt359;
    public int anInt360;
    public int anInt361;
    public int anInt362;
    public int anInt363;
    public int anInt364;
    public int anInt365;
    public int anInt366;
    public static int anInt367;
}
