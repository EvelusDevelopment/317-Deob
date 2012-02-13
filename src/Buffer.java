// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.math.BigInteger;
import sign.signlink;

public class Buffer extends SubNode {

    public static Buffer create(int type) {
        Buffer buffer = new Buffer();
        buffer.position = 0;
        if(type == 0)
            buffer.payload = new byte[100];
        else if(type == 1)
            buffer.payload = new byte[5000];
        else
            buffer.payload = new byte[30000];
        return buffer;
    }

    public Buffer() {
    }

    public Buffer(byte bytes[])
    {
        payload = bytes;
        position = 0;
    }

    public void putPacket(int id) {
        payload[position++] = (byte)(id + encryption.poll());
    }

    public void put(int value) {
        payload[position++] = (byte) value;
    }

    public void putShort(int value) {
        payload[position++] = (byte)(value >> 8);
        payload[position++] = (byte)value;
    }

    public void putShortLE(int value) {
        payload[position++] = (byte) value;
        payload[position++] = (byte)(value >> 8);
    }

    public void putTri(int value) {
        payload[position++] = (byte)(value >> 16);
        payload[position++] = (byte)(value >> 8);
        payload[position++] = (byte) value;
    }

    public void putInt(int value) {
        payload[position++] = (byte)(value >> 24);
        payload[position++] = (byte)(value >> 16);
        payload[position++] = (byte)(value >> 8);
        payload[position++] = (byte)value;
    }

    public void putIntLE(int value) {
        payload[position++] = (byte)value;
        payload[position++] = (byte)(value >> 8);
        payload[position++] = (byte)(value >> 16);
        payload[position++] = (byte)(value >> 24);
    }

    public void putLong(long l) {
        try
        {
            payload[position++] = (byte)(int)(l >> 56);
            payload[position++] = (byte)(int)(l >> 48);
            payload[position++] = (byte)(int)(l >> 40);
            payload[position++] = (byte)(int)(l >> 32);
            payload[position++] = (byte)(int)(l >> 24);
            payload[position++] = (byte)(int)(l >> 16);
            payload[position++] = (byte)(int)(l >> 8);
            payload[position++] = (byte)(int)l;
        } catch(RuntimeException runtimeexception) {
            signlink.reporterror("14395, " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void putCStr(String s) {
        s.getBytes(0, s.length(), payload, position);
        position += s.length();
        payload[position++] = 10;
    }

    public void put(byte bytes[], int i, boolean flag, int j) {
        for(int k = j; k < j + i; k++)
            payload[position++] = bytes[k];
    }

    public void finishByteVar(int i, byte byte0) {
        payload[position - i - 1] = (byte) i;
    }

    public int getUByte() {
        return payload[position++] & 0xff;
    }

    public byte getByte() {
        return payload[position++];
    }

    public int getShort() {
        position += 2;
        return ((payload[position - 2] & 0xff) << 8) + (payload[position - 1] & 0xff);
    }

    public int putShortB() {
        position += 2;
        int i = ((payload[position - 2] & 0xff) << 8) + (payload[position - 1] & 0xff);
        if(i > 32767)
            i -= 0x10000;
        return i;
    }

    public int getTri() {
        position += 3;
        return ((payload[position - 3] & 0xff) << 16) + ((payload[position - 2] & 0xff) << 8) + (payload[position - 1] & 0xff);
    }

    public int getInt() {
        position += 4;
        return ((payload[position - 4] & 0xff) << 24) + ((payload[position - 3] & 0xff) << 16) + ((payload[position - 2] & 0xff) << 8) + (payload[position - 1] & 0xff);
    }

    public long getLong(int i) {
        long l = (long)getInt() & 0xffffffffL;
        long l1 = (long)getInt() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public String getCStr() {
        int i = position;
        while(payload[position++] != 10) ;
        return new String(payload, i, position - i - 1);
    }

    public byte[] getCStrBytes(byte junk) {
        int i = position;
        while(payload[position++] != 10) ;
        byte abyte0[] = new byte[position - i - 1];
        for(int j = i; j < position - 1; j++)
            abyte0[j - i] = payload[j];
        return abyte0;
    }

    public void getBytes(int i, byte junk, int j, byte abyte0[]) {
        for(int l = j; l < j + i; l++)
            abyte0[l] = payload[position++];
    }

    public void initBitAccess(int junk) {
        bitposition = position * 8;
    }

    public int getBits(int i, int junk) {
        int k = bitposition >> 3;
        int l = 8 - (bitposition & 7);
        int i1 = 0;
        bitposition += i;
        for(; i > l; l = 8)
        {
            i1 += (payload[k++] & bit_masks[l]) << i - l;
            i -= l;
        }

        if(i == l)
            i1 += payload[k] & bit_masks[l];
        else
            i1 += payload[k] >> l - i & bit_masks[i];
        return i1;
    }

    public void endBitAccess(boolean junk) {
        position = (bitposition + 7) / 8;
    }

    public int getSmartA() {
        int i = payload[position] & 0xff;
        if(i < 128)
            return getUByte() - 64;
        else
            return getShort() - 49152;
    }

    public int getSmartB()
    {
        int i = payload[position] & 0xff;
        if(i < 128)
            return getUByte();
        else
            return getShort() - 32768;
    }

    public void applyRSA(BigInteger biginteger, BigInteger biginteger1, byte junk) {
        int i = position;
        position = 0;
        byte abyte0[] = new byte[i];
        getBytes(i, (byte) 0, 0, abyte0);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2;//.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        position = 0;
        put(abyte1.length);
        put(abyte1, abyte1.length, true, 0);
    }

    public void putSpecialA(int i, int j) {
        payload[position++] = (byte) (-i);
    }

    public void putSpecialB(int junk, int j)
    {
        payload[position++] = (byte) (128 - j);
    }

    public int getUByte128(int i)
    {
        return payload[position++] - 128 & 0xff;
    }

    public int getUSpecialA(boolean flag) {
        return -payload[position++] & 0xff;
    }

    public int getUSpecialB(int junk) {
        return 128 - payload[position++] & 0xff;
    }

    public byte getSpecialA(byte junk)
    {
        return (byte)(-payload[position++]);
    }

    public byte getSpecialB(int junk)
    {
        return (byte)(128 - payload[position++]);
    }

    public void putShortLE_(boolean junk, int i)
    {
        payload[position++] = (byte)i;
        payload[position++] = (byte)(i >> 8);
    }

    public void putShort128(int i, int j)
    {
        payload[position++] = (byte)(j >> 8);
        payload[position++] = (byte)(j + 128);
    }

    public void putShortLE128(int i, int j)
    {
        payload[position++] = (byte)(j + 128);
        payload[position++] = (byte)(j >> 8);
    }

    public int getShortLE(byte junk)
    {
        position += 2;
        return ((payload[position - 1] & 0xff) << 8) + (payload[position - 2] & 0xff);
    }

    public int getShort128(boolean junk)
    {
        position += 2;
        return ((payload[position - 2] & 0xff) << 8) + (payload[position - 1] - 128 & 0xff);
    }

    public int getShortLE128(byte junk)
    {
        position += 2;
        return ((payload[position - 1] & 0xff) << 8) + (payload[position - 2] - 128 & 0xff);
    }

    public int getShortBLE(int junk)
    {
        position += 2;
        int j = ((payload[position - 1] & 0xff) << 8) + (payload[position - 2] & 0xff);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public int getShortB128LE(boolean junk)
    {
        position += 2;
        int j = ((payload[position - 1] & 0xff) << 8) + (payload[position - 2] - 128 & 0xff);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public int getIntB(byte junk)
    {
        position += 4;
        return ((payload[position - 2] & 0xff) << 24) + ((payload[position - 1] & 0xff) << 16) + ((payload[position - 4] & 0xff) << 8) + (payload[position - 3] & 0xff);
    }

    public int getIntC(boolean junk)
    {
        position += 4;
        return ((payload[position - 3] & 0xff) << 24) + ((payload[position - 4] & 0xff) << 16) + ((payload[position - 1] & 0xff) << 8) + (payload[position - 2] & 0xff);
    }

    public void putBytes128(int i, byte junk, byte abyte0[], int j) {
        for(int k = (i + j) - 1; k >= i; k--)
            payload[position++] = (byte) (abyte0[k] + 128);
    }

    public void putBytes(int i, int j, boolean junk, byte abyte0[])
    {
        for(int k = (j + i) - 1; k >= j; k--)
            abyte0[k] = payload[position++];
    }


    public byte payload[];
    public int position;
    public int bitposition;	
    public static final int bit_masks[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };	
    public ISAAC encryption;

}
