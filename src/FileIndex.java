// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.*;
import sign.signlink;

public class FileIndex {

    public FileIndex(int i, RandomAccessFile randomaccessfile, RandomAccessFile randomaccessfile1, int j, boolean junk) {
        maxsize = 65000;
        anInt311 = j;
        aRandomAccessFile309 = randomaccessfile;
        aRandomAccessFile310 = randomaccessfile1;
        maxsize = i;
    }

    public synchronized byte[] getRawArchive(boolean junk, int i) {
        try
        {
            seek(aRandomAccessFile310, -660, i * 6);
            int l;
            for(int j = 0; j < 6; j += l)
            {
                l = aRandomAccessFile310.read(chunk_buffer, j, 6 - j);
                if(l == -1)
                    return null;
            }

            int size = ((chunk_buffer[0] & 0xff) << 16) + ((chunk_buffer[1] & 0xff) << 8) + (chunk_buffer[2] & 0xff);
            int block = ((chunk_buffer[3] & 0xff) << 16) + ((chunk_buffer[4] & 0xff) << 8) + (chunk_buffer[5] & 0xff);
            if(size < 0 || size > maxsize)
                return null;
            if(block <= 0 || (long)block > aRandomAccessFile309.length() / 520L)
                return null;
            byte abyte0[] = new byte[size];
            int k1 = 0;
            for(int l1 = 0; k1 < size; l1++)
            {
                if(block == 0)
                    return null;
                seek(aRandomAccessFile309, -660, block * 520);
                int k = 0;
                int i2 = size - k1;
                if(i2 > 512)
                    i2 = 512;
                int j2;
                for(; k < i2 + 8; k += j2)
                {
                    j2 = aRandomAccessFile309.read(chunk_buffer, k, (i2 + 8) - k);
                    if(j2 == -1)
                        return null;
                }

                int archiveid = ((chunk_buffer[0] & 0xff) << 8) + (chunk_buffer[1] & 0xff);
                int chunkid = ((chunk_buffer[2] & 0xff) << 8) + (chunk_buffer[3] & 0xff);
                int nxtblock = ((chunk_buffer[4] & 0xff) << 16) + ((chunk_buffer[5] & 0xff) << 8) + (chunk_buffer[6] & 0xff);
                int cacheidx = chunk_buffer[7] & 0xff;
                if(archiveid != i || chunkid != l1 || cacheidx != anInt311)
                    return null;
                if(nxtblock < 0 || (long)nxtblock > aRandomAccessFile309.length() / 520L)
                    return null;
                for(int k3 = 0; k3 < i2; k3++)
                    abyte0[k1++] = chunk_buffer[k3 + 8];
                block = nxtblock;
            }

            return abyte0;
        }
        catch(IOException _ex)
        {
            return null;
        }
    }

    public synchronized boolean writeArchive(int i, byte abyte0[], int j)
    {
        boolean flag = writeArchive(true, j, i, abyte0);
        if(!flag)
            flag = writeArchive(false, j, i, abyte0);
        return flag;
    }

    public synchronized boolean writeArchive(boolean flag, int j, int k, byte abyte0[]) {
        try {
            int l;
            if(flag)
            {
                seek(aRandomAccessFile310, -660, j * 6);
                int k1;
                for(int i1 = 0; i1 < 6; i1 += k1)
                {
                    k1 = aRandomAccessFile310.read(chunk_buffer, i1, 6 - i1);
                    if(k1 == -1)
                        return false;
                }

                l = ((chunk_buffer[3] & 0xff) << 16) + ((chunk_buffer[4] & 0xff) << 8) + (chunk_buffer[5] & 0xff);
                if(l <= 0 || (long)l > aRandomAccessFile309.length() / 520L)
                    return false;
            } else
            {
                l = (int)((aRandomAccessFile309.length() + 519L) / 520L);
                if(l == 0)
                    l = 1;
            }
            chunk_buffer[0] = (byte)(k >> 16);
            chunk_buffer[1] = (byte)(k >> 8);
            chunk_buffer[2] = (byte)k;
            chunk_buffer[3] = (byte)(l >> 16);
            chunk_buffer[4] = (byte)(l >> 8);
            chunk_buffer[5] = (byte)l;
            seek(aRandomAccessFile310, -660, j * 6);
            aRandomAccessFile310.write(chunk_buffer, 0, 6);
            int j1 = 0;
            for(int l1 = 0; j1 < k; l1++) {
                int i2 = 0;
                if(flag)
                {
                    seek(aRandomAccessFile309, -660, l * 520);
                    int j2;
                    int l2;
                    for(j2 = 0; j2 < 8; j2 += l2)
                    {
                        l2 = aRandomAccessFile309.read(chunk_buffer, j2, 8 - j2);
                        if(l2 == -1)
                            break;
                    }

                    if(j2 == 8)
                    {
                        int i3 = ((chunk_buffer[0] & 0xff) << 8) + (chunk_buffer[1] & 0xff);
                        int j3 = ((chunk_buffer[2] & 0xff) << 8) + (chunk_buffer[3] & 0xff);
                        i2 = ((chunk_buffer[4] & 0xff) << 16) + ((chunk_buffer[5] & 0xff) << 8) + (chunk_buffer[6] & 0xff);
                        int k3 = chunk_buffer[7] & 0xff;
                        if(i3 != j || j3 != l1 || k3 != anInt311)
                            return false;
                        if(i2 < 0 || (long)i2 > aRandomAccessFile309.length() / 520L)
                            return false;
                    }
                }
                if(i2 == 0)
                {
                    flag = false;
                    i2 = (int)((aRandomAccessFile309.length() + 519L) / 520L);
                    if(i2 == 0)
                        i2++;
                    if(i2 == l)
                        i2++;
                }
                if(k - j1 <= 512)
                    i2 = 0;
                chunk_buffer[0] = (byte)(j >> 8);
                chunk_buffer[1] = (byte)j;
                chunk_buffer[2] = (byte)(l1 >> 8);
                chunk_buffer[3] = (byte)l1;
                chunk_buffer[4] = (byte)(i2 >> 16);
                chunk_buffer[5] = (byte)(i2 >> 8);
                chunk_buffer[6] = (byte)i2;
                chunk_buffer[7] = (byte)anInt311;
                seek(aRandomAccessFile309, -660, l * 520);
                aRandomAccessFile309.write(chunk_buffer, 0, 8);
                int k2 = k - j1;
                if(k2 > 512)
                    k2 = 512;
                aRandomAccessFile309.write(abyte0, j1, k2);
                j1 += k2;
                l = i2;
            }

            return true;
        }
        catch(IOException _ex)
        {
            return false;
        }
    }

    public synchronized void seek(RandomAccessFile randomaccessfile, int junk, int j) throws IOException {
        if(j < 0 || j > 0x3c00000) {
            System.out.println("Badseek - pos:" + j + " len:" + randomaccessfile.length());
            j = 0x3c00000;
            try {
                Thread.sleep(1000L);
            } catch(Exception _ex) { 
			}
        }
        randomaccessfile.seek(j);
    }

    public static byte chunk_buffer[] = new byte[520];
    public RandomAccessFile aRandomAccessFile309;
    public RandomAccessFile aRandomAccessFile310;
    public int anInt311;
    public int maxsize;

}
