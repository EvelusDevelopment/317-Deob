// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class Sound {

    public Sound(int i) {
        aBoolean321 = true;
        aClass6Array329 = new SoundTrack[10];
        if(i < 8 || i > 8)
            anInt324 = 477;
    }

    public static void method240(int i, Buffer buffer0) {
        aByteArray327 = new byte[0x6baa8];
        aClass30_Sub2_Sub2_328 = new Buffer(aByteArray327);
        if(i != 0)
            aBoolean322 = !aBoolean322;
        SoundTrack.method166();
        do
        {
            int j = buffer0.getShort();
            if(j == 65535)
                return;
            aClass16Array325[j] = new Sound(8);
            aClass16Array325[j].method242(true, buffer0);
            anIntArray326[j] = aClass16Array325[j].method243(0);
        } while(true);
    }

    public static Buffer method241(int i, int j, boolean flag)
    {
        if(flag)
            aBoolean323 = !aBoolean323;
        if(aClass16Array325[j] != null)
        {
            Sound class16 = aClass16Array325[j];
            return class16.method244(i, 6);
        } else
        {
            return null;
        }
    }

    public void method242(boolean flag, Buffer buffer0)
    {
        for(int i = 0; i < 10; i++)
        {
            int j = buffer0.getUByte();
            if(j != 0)
            {
                buffer0.position--;
                aClass6Array329[i] = new SoundTrack();
                aClass6Array329[i].method169(true, buffer0);
            }
        }

        if(!flag)
            anInt324 = 58;
        anInt330 = buffer0.getShort();
        anInt331 = buffer0.getShort();
    }

    public int method243(int i)
    {
        int j = 0x98967f;
        if(i != 0)
            anInt324 = -52;
        for(int k = 0; k < 10; k++)
            if(aClass6Array329[k] != null && aClass6Array329[k].anInt114 / 20 < j)
                j = aClass6Array329[k].anInt114 / 20;

        if(anInt330 < anInt331 && anInt330 / 20 < j)
            j = anInt330 / 20;
        if(j == 0x98967f || j == 0)
            return 0;
        for(int l = 0; l < 10; l++)
            if(aClass6Array329[l] != null)
                aClass6Array329[l].anInt114 -= j * 20;

        if(anInt330 < anInt331)
        {
            anInt330 -= j * 20;
            anInt331 -= j * 20;
        }
        return j;
    }

    public Buffer method244(int i, int j)
    {
        int k = method245(i);
        aClass30_Sub2_Sub2_328.position = 0;
        aClass30_Sub2_Sub2_328.putInt(0x52494646);
        aClass30_Sub2_Sub2_328.putIntLE(36 + k);
        aClass30_Sub2_Sub2_328.putInt(0x57415645);
        aClass30_Sub2_Sub2_328.putInt(0x666d7420);
        aClass30_Sub2_Sub2_328.putIntLE(16);
        aClass30_Sub2_Sub2_328.putShortLE(1);
        if(j < 6 || j > 6)
        {
            for(int l = 1; l > 0; l++);
        }
        aClass30_Sub2_Sub2_328.putShortLE(1);
        aClass30_Sub2_Sub2_328.putIntLE(22050);
        aClass30_Sub2_Sub2_328.putIntLE(22050);
        aClass30_Sub2_Sub2_328.putShortLE(1);
        aClass30_Sub2_Sub2_328.putShortLE(8);
        aClass30_Sub2_Sub2_328.putInt(0x64617461);
        aClass30_Sub2_Sub2_328.putIntLE(k);
        aClass30_Sub2_Sub2_328.position += k;
        return aClass30_Sub2_Sub2_328;
    }

    public int method245(int i)
    {
        int j = 0;
        for(int k = 0; k < 10; k++)
            if(aClass6Array329[k] != null && aClass6Array329[k].anInt113 + aClass6Array329[k].anInt114 > j)
                j = aClass6Array329[k].anInt113 + aClass6Array329[k].anInt114;

        if(j == 0)
            return 0;
        int l = (22050 * j) / 1000;
        int i1 = (22050 * anInt330) / 1000;
        int j1 = (22050 * anInt331) / 1000;
        if(i1 < 0 || i1 > l || j1 < 0 || j1 > l || i1 >= j1)
            i = 0;
        int k1 = l + (j1 - i1) * (i - 1);
        for(int l1 = 44; l1 < k1 + 44; l1++)
            aByteArray327[l1] = -128;

        for(int i2 = 0; i2 < 10; i2++)
            if(aClass6Array329[i2] != null)
            {
                int j2 = (aClass6Array329[i2].anInt113 * 22050) / 1000;
                int i3 = (aClass6Array329[i2].anInt114 * 22050) / 1000;
                int ai[] = aClass6Array329[i2].method167(j2, aClass6Array329[i2].anInt113);
                for(int l3 = 0; l3 < j2; l3++)
                    aByteArray327[l3 + i3 + 44] += (byte)(ai[l3] >> 8);

            }

        if(i > 1)
        {
            i1 += 44;
            j1 += 44;
            l += 44;
            int k2 = (k1 += 44) - l;
            for(int j3 = l - 1; j3 >= j1; j3--)
                aByteArray327[j3 + k2] = aByteArray327[j3];

            for(int k3 = 1; k3 < i; k3++)
            {
                int l2 = (j1 - i1) * k3;
                for(int i4 = i1; i4 < j1; i4++)
                    aByteArray327[i4 + l2] = aByteArray327[i4];

            }

            k1 -= 44;
        }
        return k1;
    }

    public boolean aBoolean321;
    public static boolean aBoolean322;
    public static boolean aBoolean323 = true;
    public int anInt324;
    public static Sound aClass16Array325[] = new Sound[5000];
    public static int anIntArray326[] = new int[5000];
    public static byte aByteArray327[];
    public static Buffer aClass30_Sub2_Sub2_328;
    public SoundTrack aClass6Array329[];
    public int anInt330;
    public int anInt331;

}
