// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class FileContainer {

    public FileContainer(int junk, byte abyte0[]) {
        initialize(abyte0, (byte) 'j');
    }

    public void initialize(byte abyte0[], byte junk) {
        Buffer buffer = new Buffer(abyte0);
        int i = buffer.getTri();
        int j = buffer.getTri();
        if(j != i) {
            byte abyte1[] = new byte[i];
            BZ2Decompressor.method225(abyte1, i, abyte0, j, 6);
            archive_data = abyte1;
            buffer = new Buffer(archive_data);
            compressed = true;
        } else {
            archive_data = abyte0;
            compressed = false;
        }
        entries = buffer.getShort();
        name_hashes = new int[entries];
        uncompressed_sizes = new int[entries];
        compressed_sizes = new int[entries];
        ptrs = new int[entries];
        int offset = buffer.position + entries * 10;
        for(int l = 0; l < entries; l++) {
            name_hashes[l] = buffer.getInt();
            uncompressed_sizes[l] = buffer.getTri();
            compressed_sizes[l] = buffer.getTri();
            ptrs[l] = offset;
            offset += compressed_sizes[l];
        }
    }

    public byte[] getEntry(String s, byte out[]) {
        int i = 0;
        s = s.toUpperCase();
        for(int j = 0; j < s.length(); j++)
            i = (i * 61 + s.charAt(j)) - 32;
        for(int k = 0; k < entries; k++)
            if(name_hashes[k] == i) {
                if(out == null)
                    out = new byte[uncompressed_sizes[k]];
                if(!compressed) {
                    BZ2Decompressor.method225(out, uncompressed_sizes[k], archive_data, compressed_sizes[k], ptrs[k]);
                } else {
                    for(int pos = 0; pos < uncompressed_sizes[k]; pos++)
                        out[pos] = archive_data[ptrs[k] + pos];
                }
                return out;
            }
        return null;
    }

    public byte archive_data[];
    public int entries;
    public int name_hashes[];
    public int uncompressed_sizes[];
    public int compressed_sizes[];
    public int ptrs[];
    public boolean compressed;
}
