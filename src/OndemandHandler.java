// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.*;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;
import sign.signlink;

public class OndemandHandler extends NumericLoader implements Runnable {

    public boolean validate(int version, int crc, byte bytes[])
    {
        if(bytes == null || bytes.length < 2)
            return false;
        int offset = bytes.length - 2;
        int calcedversion = ((bytes[offset] & 0xff) << 8) + (bytes[offset + 1] & 0xff);
        aCRC32_1338.reset();
        aCRC32_1338.update(bytes, 0, offset);
        int calcedcrc = (int) aCRC32_1338.getValue();
        if(calcedversion != version)
            return false;
        return calcedcrc == crc;
    }

    public void parseArchive(int i)
    {
        try
        {
            int avail = inputstream.available();
            if(requestoffset == 0 && avail >= 6)
            {
                aBoolean1357 = true;
                for(int k = 0; k < 6; k += inputstream.read(payload, k, 6 - k));
                int index = payload[0] & 0xff;
                int archiveid = ((payload[1] & 0xff) << 8) + (payload[2] & 0xff);
                int archivesize = ((payload[3] & 0xff) << 8) + (payload[4] & 0xff);
                int chunknum = payload[5] & 0xff;
                currentrequest = null;
                for(OndemandRequest request = (OndemandRequest)aClass19_1331.getFirst(); request != null; request = (OndemandRequest)aClass19_1331.getNextForwards(false))
                {
                    if(request.index == index && request.archiveid == archiveid)
                        currentrequest = request;
                    if(currentrequest != null)
                        request.anInt1423 = 0;
                }
                if(currentrequest != null)
                {
                    anInt1373 = 0;
                    if(archivesize == 0)
                    {
                        signlink.reporterror("Rej: " + index + "," + archiveid);
                        currentrequest.request_data = null;
                        if(currentrequest.aBoolean1422)
                            synchronized(aClass19_1358)
                            {
                                aClass19_1358.addLast(currentrequest);
                            }
                        else
                            currentrequest.removeDeque();
                        currentrequest = null;
                    } else
                    {
                        if(currentrequest.request_data == null && chunknum == 0)
                            currentrequest.request_data = new byte[archivesize];
                        if(currentrequest.request_data == null && chunknum != 0)
                            throw new IOException("missing start of file");
                    }
                }
                requestposition = chunknum * 500;
                requestoffset = 500;
                if(requestoffset > archivesize - chunknum * 500)
                    requestoffset = archivesize - chunknum * 500;
            }
            if(requestoffset > 0 && avail >= requestoffset)
            {
                aBoolean1357 = true;
                byte bytes[] = payload;
                int position = 0;
                if(currentrequest != null)
                {
                    bytes = currentrequest.request_data;
                    position = requestposition;
                }
                for(int read = 0; read < requestoffset; read += inputstream.read(bytes, read + position, requestoffset - read));
                if(requestoffset + requestposition >= bytes.length && currentrequest != null)
                {
                    if(main.cacheindexes[0] != null)
                        main.cacheindexes[currentrequest.index + 1].writeArchive(bytes.length, bytes, currentrequest.archiveid);
                    if(!currentrequest.aBoolean1422 && currentrequest.index == 3)
                    {
                        currentrequest.aBoolean1422 = true;
                        currentrequest.index = 93;
                    }
                    if(currentrequest.aBoolean1422)
                        synchronized(aClass19_1358)
                        {
                            aClass19_1358.addLast(currentrequest);
                        }
                    else
                        currentrequest.removeDeque();
                }
                requestoffset = 0;
                return;
            }
        }
        catch(IOException ioexception)
        {
            try
            {
                socket.close();
            }
            catch(Exception _ex) { }
            socket = null;
            inputstream = null;
            outputstream = null;
            requestoffset = 0;
        }
    }

    public void loadVersionList(FileContainer class44, Main client1)
    {
        String as[] = {
            "model_version", "anim_version", "midi_version", "map_version"
        };
        for(int i = 0; i < 4; i++)
        {
            byte abyte0[] = class44.getEntry(as[i], null);
            int j = abyte0.length / 2;
            Buffer buffer0 = new Buffer(abyte0);
            versions[i] = new int[j];
            aByteArrayArray1342[i] = new byte[j];
            for(int l = 0; l < j; l++)
                versions[i][l] = buffer0.getShort();

        }

        String as1[] = {
            "model_crc", "anim_crc", "midi_crc", "map_crc"
        };
        for(int k = 0; k < 4; k++)
        {
            byte abyte1[] = class44.getEntry(as1[k], null);
            int i1 = abyte1.length / 4;
            Buffer class30_sub2_sub2_1 = new Buffer(abyte1);
            crcs[k] = new int[i1];
            for(int l1 = 0; l1 < i1; l1++)
                crcs[k][l1] = class30_sub2_sub2_1.getInt();

        }

        byte abyte2[] = class44.getEntry("model_index", null);
        int j1 = versions[0].length;
        model_index = new byte[j1];
        for(int k1 = 0; k1 < j1; k1++)
            if(k1 < abyte2.length)
                model_index[k1] = abyte2[k1];
            else
                model_index[k1] = 0;

        abyte2 = class44.getEntry("map_index", null);
        Buffer class30_sub2_sub2_2 = new Buffer(abyte2);
        j1 = abyte2.length / 7;
        region_ptrs = new int[j1];
        map_index0 = new int[j1];
        map_index1 = new int[j1];
        extra_maps = new int[j1];
        for(int i2 = 0; i2 < j1; i2++)
        {
            region_ptrs[i2] = class30_sub2_sub2_2.getShort();
            map_index0[i2] = class30_sub2_sub2_2.getShort();
            map_index1[i2] = class30_sub2_sub2_2.getShort();
            extra_maps[i2] = class30_sub2_sub2_2.getUByte();
        }

        abyte2 = class44.getEntry("anim_index", null);
        class30_sub2_sub2_2 = new Buffer(abyte2);
        j1 = abyte2.length / 2;
        anim_index = new int[j1];
        for(int j2 = 0; j2 < j1; j2++)
            anim_index[j2] = class30_sub2_sub2_2.getShort();

        abyte2 = class44.getEntry("midi_index", null);
        class30_sub2_sub2_2 = new Buffer(abyte2);
        j1 = abyte2.length;
        midi_index = new int[j1];
        for(int k2 = 0; k2 < j1; k2++)
            midi_index[k2] = class30_sub2_sub2_2.getUByte();

        main = client1;
        aBoolean1353 = true;
        main.spawnThread(this, 2);
    }

    public int amount() {
        synchronized(aClass2_1361) {
            int i = aClass2_1361.size();
            return i;
        }
    }

    public void hault()
    {
        aBoolean1353 = false;
    }

    public void method554(boolean members, int i)
    {
        int j = region_ptrs.length;
        if(i != 0)
            anInt1345 = 20;
        for(int k = 0; k < j; k++)
            if(members || extra_maps[k] != 0)
            {
                method563((byte)2, 3, map_index1[k], (byte)8);
                method563((byte)2, 3, map_index0[k], (byte)8);
            }

    }

    public int getAmountArchives(int junk, int j) {
        return versions[j].length;
    }

    public void writeRequest(int i, OndemandRequest class30_sub2_sub3)
    {
        if(i < 8 || i > 8)
            anInt1352 = -339;
        try
        {
            if(socket == null)
            {
                long l = System.currentTimeMillis();
                if(l - aLong1335 < 4000L)
                    return;
                aLong1335 = l;
                socket = main.spawnSocket(43594 + Main.portoff);
                inputstream = socket.getInputStream();
                outputstream = socket.getOutputStream();
                outputstream.write(15);
                for(int j = 0; j < 8; j++)
                    inputstream.read();

                anInt1373 = 0;
            }
            payload[0] = (byte)class30_sub2_sub3.index;
            payload[1] = (byte)(class30_sub2_sub3.archiveid >> 8);
            payload[2] = (byte)class30_sub2_sub3.archiveid;
            if(class30_sub2_sub3.aBoolean1422)
                payload[3] = 2;
            else
            if(!main.aBoolean1157)
                payload[3] = 1;
            else
                payload[3] = 0;
            outputstream.write(payload, 0, 4);
            anInt1334 = 0;
            anInt1349 = -10000;
            return;
        }
        catch(IOException ioexception) { }
        try
        {
            socket.close();
        }
        catch(Exception _ex) { }
        socket = null;
        inputstream = null;
        outputstream = null;
        requestoffset = 0;
        anInt1349++;
    }

    public int getAmountAnimations(int i)
    {
        return anim_index.length;
    }

    public void requestUrgentArchive(int i, int j)
    {
        if(i < 0 || i > versions.length || j < 0 || j > versions[i].length)
            return;
        if(versions[i][j] == 0)
            return;
        synchronized(aClass2_1361)
        {
            for(OndemandRequest class30_sub2_sub3 = (OndemandRequest)aClass2_1361.getFirst(); class30_sub2_sub3 != null; class30_sub2_sub3 = (OndemandRequest)aClass2_1361.next(false))
                if(class30_sub2_sub3.index == i && class30_sub2_sub3.archiveid == j)
                    return;

            OndemandRequest class30_sub2_sub3_1 = new OndemandRequest();
            class30_sub2_sub3_1.index = i;
            class30_sub2_sub3_1.archiveid = j;
            class30_sub2_sub3_1.aBoolean1422 = true;
            synchronized(aClass19_1370)
            {
                aClass19_1370.addLast(class30_sub2_sub3_1);
            }
            aClass2_1361.add(class30_sub2_sub3_1);
        }
    }

    public int getModelIndex(int i, int j)
    {
        return model_index[i] & 0xff;
    }

    public void run()
    {
        try
        {
            while(aBoolean1353) 
            {
                ondemand_cycle++;
                int i = 20;
                if(anInt1332 == 0 && main.cacheindexes[0] != null)
                    i = 50;
                try
                {
                    Thread.sleep(i);
                }
                catch(Exception _ex) { }
                aBoolean1357 = true;
                for(int j = 0; j < 100; j++)
                {
                    if(!aBoolean1357)
                        break;
                    aBoolean1357 = false;
                    method567(true);
                    method565(false);
                    if(anInt1366 == 0 && j >= 5)
                        break;
                    method568((byte)-56);
                    if(inputstream != null)
                        parseArchive(-369);
                }

                boolean flag = false;
                for(OndemandRequest class30_sub2_sub3 = (OndemandRequest)aClass19_1331.getFirst(); class30_sub2_sub3 != null; class30_sub2_sub3 = (OndemandRequest)aClass19_1331.getNextForwards(false))
                    if(class30_sub2_sub3.aBoolean1422)
                    {
                        flag = true;
                        class30_sub2_sub3.anInt1423++;
                        if(class30_sub2_sub3.anInt1423 > 50)
                        {
                            class30_sub2_sub3.anInt1423 = 0;
                            writeRequest(8, class30_sub2_sub3);
                        }
                    }

                if(!flag)
                {
                    for(OndemandRequest class30_sub2_sub3_1 = (OndemandRequest)aClass19_1331.getFirst(); class30_sub2_sub3_1 != null; class30_sub2_sub3_1 = (OndemandRequest)aClass19_1331.getNextForwards(false))
                    {
                        flag = true;
                        class30_sub2_sub3_1.anInt1423++;
                        if(class30_sub2_sub3_1.anInt1423 > 50)
                        {
                            class30_sub2_sub3_1.anInt1423 = 0;
                            writeRequest(8, class30_sub2_sub3_1);
                        }
                    }

                }
                if(flag)
                {
                    anInt1373++;
                    if(anInt1373 > 750)
                    {
                        try
                        {
                            socket.close();
                        }
                        catch(Exception _ex) { }
                        socket = null;
                        inputstream = null;
                        outputstream = null;
                        requestoffset = 0;
                    }
                } else
                {
                    anInt1373 = 0;
                    extrafiles_str = "";
                }
                if(main.aBoolean1157 && socket != null && outputstream != null && (anInt1332 > 0 || main.cacheindexes[0] == null))
                {
                    anInt1334++;
                    if(anInt1334 > 500)
                    {
                        anInt1334 = 0;
                        payload[0] = 0;
                        payload[1] = 0;
                        payload[2] = 0;
                        payload[3] = 10;
                        try
                        {
                            outputstream.write(payload, 0, 4);
                        }
                        catch(IOException _ex)
                        {
                            anInt1373 = 5000;
                        }
                    }
                }
            }
            return;
        }
        catch(Exception exception)
        {
            signlink.reporterror("od_ex " + exception.getMessage());
        }
    }

    public void requestArchive(int i, int j, boolean junk)
    {
        if(main.cacheindexes[0] == null)
            return;
        if(versions[j][i] == 0)
            return;
        if(aByteArrayArray1342[j][i] == 0)
            return;
        if(anInt1332 == 0)
            return;
        OndemandRequest class30_sub2_sub3 = new OndemandRequest();
        class30_sub2_sub3.index = j;
        class30_sub2_sub3.archiveid = i;
        class30_sub2_sub3.aBoolean1422 = false;
        synchronized(aClass19_1344)
        {
            aClass19_1344.addLast(class30_sub2_sub3);
        }
    }

    public OndemandRequest getFinalizedRequest()
    {
        OndemandRequest class30_sub2_sub3;
        synchronized(aClass19_1358)
        {
            class30_sub2_sub3 = (OndemandRequest)aClass19_1358.pop();
        }
        if(class30_sub2_sub3 == null)
            return null;
        synchronized(aClass2_1361)
        {
            class30_sub2_sub3.removeQueue();
        }
        if(class30_sub2_sub3.request_data == null)
            return class30_sub2_sub3;
        int i = 0;
        try
        {
            GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(class30_sub2_sub3.request_data));
            do
            {
                if(i == aByteArray1359.length)
                    throw new RuntimeException("buffer overflow!");
                int k = gzipinputstream.read(aByteArray1359, i, aByteArray1359.length - i);
                if(k == -1)
                    break;
                i += k;
            } while(true);
        }
        catch(IOException _ex)
        {
            throw new RuntimeException("error unzipping");
        }
        class30_sub2_sub3.request_data = new byte[i];
        for(int j = 0; j < i; j++)
            class30_sub2_sub3.request_data[j] = aByteArray1359[j];

        return class30_sub2_sub3;
    }

    public int method562(int type, int junk, int k, int l)
    {
        int i1 = (l << 8) + k;
        for(int j1 = 0; j1 < region_ptrs.length; j1++)
            if(region_ptrs[j1] == i1)
                if(type == 0)
                    return map_index0[j1];
                else
                    return map_index1[j1];
        return -1;
    }

    public void load(int i) {
        requestUrgentArchive(0, i);
    }

    public void method563(byte byte0, int i, int j, byte junk)
    {
        if(main.cacheindexes[0] == null)
            return;
        if(versions[i][j] == 0)
            return;
        byte abyte0[] = main.cacheindexes[i + 1].getRawArchive(true, j);
        if(validate(versions[i][j], crcs[i][j], abyte0))
            return;
        aByteArrayArray1342[i][j] = byte0;
        if(byte0 > anInt1332)
            anInt1332 = byte0;
        amount_extras++;
    }

    public boolean method564(int i, int j)
    {
        while(j >= 0) 
            throw new NullPointerException();
        for(int k = 0; k < region_ptrs.length; k++)
            if(map_index1[k] == i)
                return true;

        return false;
    }

    public void method565(boolean flag)
    {
        anInt1366 = 0;
        if(flag)
            return;
        anInt1367 = 0;
        for(OndemandRequest class30_sub2_sub3 = (OndemandRequest)aClass19_1331.getFirst(); class30_sub2_sub3 != null; class30_sub2_sub3 = (OndemandRequest)aClass19_1331.getNextForwards(false))
            if(class30_sub2_sub3.aBoolean1422)
                anInt1366++;
            else
                anInt1367++;

        while(anInt1366 < 10) 
        {
            OndemandRequest class30_sub2_sub3_1 = (OndemandRequest)aClass19_1368.pop();
            if(class30_sub2_sub3_1 == null)
                break;
            if(aByteArrayArray1342[class30_sub2_sub3_1.index][class30_sub2_sub3_1.archiveid] != 0)
                loaded_extras++;
            aByteArrayArray1342[class30_sub2_sub3_1.index][class30_sub2_sub3_1.archiveid] = 0;
            aClass19_1331.addLast(class30_sub2_sub3_1);
            anInt1366++;
            writeRequest(8, class30_sub2_sub3_1);
            aBoolean1357 = true;
        }
    }

    public void method566(int i)
    {
        synchronized(aClass19_1344)
        {
            aClass19_1344.clear();
        }
    }

    public void method567(boolean flag)
    {
        if(!flag)
            return;
        OndemandRequest class30_sub2_sub3;
        synchronized(aClass19_1370)
        {
            class30_sub2_sub3 = (OndemandRequest) aClass19_1370.pop();
        }
        while(class30_sub2_sub3 != null) 
        {
            aBoolean1357 = true;
            byte abyte0[] = null;
            if(main.cacheindexes[0] != null)
                abyte0 = main.cacheindexes[class30_sub2_sub3.index + 1].getRawArchive(true, class30_sub2_sub3.archiveid);
            if(!validate(versions[class30_sub2_sub3.index][class30_sub2_sub3.archiveid], crcs[class30_sub2_sub3.index][class30_sub2_sub3.archiveid], abyte0))
                abyte0 = null;
            synchronized(aClass19_1370)
            {
                if(abyte0 == null)
                {
                    aClass19_1368.addLast(class30_sub2_sub3);
                } else
                {
                    class30_sub2_sub3.request_data = abyte0;
                    synchronized(aClass19_1358)
                    {
                        aClass19_1358.addLast(class30_sub2_sub3);
                    }
                }
                class30_sub2_sub3 = (OndemandRequest)aClass19_1370.pop();
            }
        }
    }

    public void method568(byte byte0)
    {
        if(byte0 != -56)
        {
            for(int i = 1; i > 0; i++);
        }
        while(anInt1366 == 0 && anInt1367 < 10) 
        {
            if(anInt1332 == 0)
                break;
            OndemandRequest class30_sub2_sub3;
            synchronized(aClass19_1344)
            {
                class30_sub2_sub3 = (OndemandRequest)aClass19_1344.pop();
            }
            while(class30_sub2_sub3 != null) 
            {
                if(aByteArrayArray1342[class30_sub2_sub3.index][class30_sub2_sub3.archiveid] != 0)
                {
                    aByteArrayArray1342[class30_sub2_sub3.index][class30_sub2_sub3.archiveid] = 0;
                    aClass19_1331.addLast(class30_sub2_sub3);
                    writeRequest(8, class30_sub2_sub3);
                    aBoolean1357 = true;
                    if(loaded_extras < amount_extras)
                        loaded_extras++;
                    extrafiles_str = "Loading extra files - " + (loaded_extras * 100) / amount_extras + "%";
                    anInt1367++;
                    if(anInt1367 == 10)
                        return;
                }
                synchronized(aClass19_1344)
                {
                    class30_sub2_sub3 = (OndemandRequest)aClass19_1344.pop();
                }
            }
            for(int j = 0; j < 4; j++)
            {
                byte abyte0[] = aByteArrayArray1342[j];
                int k = abyte0.length;
                for(int l = 0; l < k; l++)
                    if(abyte0[l] == anInt1332)
                    {
                        abyte0[l] = 0;
                        OndemandRequest class30_sub2_sub3_1 = new OndemandRequest();
                        class30_sub2_sub3_1.index = j;
                        class30_sub2_sub3_1.archiveid = l;
                        class30_sub2_sub3_1.aBoolean1422 = false;
                        aClass19_1331.addLast(class30_sub2_sub3_1);
                        writeRequest(8, class30_sub2_sub3_1);
                        aBoolean1357 = true;
                        if(loaded_extras < amount_extras)
                            loaded_extras++;
                        extrafiles_str = "Loading extra files - " + (loaded_extras * 100) / amount_extras + "%";
                        anInt1367++;
                        if(anInt1367 == 10)
                            return;
                    }

            }

            anInt1332--;
        }
    }

    public boolean isExtraMidi(int i, int j)
    {
        return midi_index[i] == 1;
    }

    public OndemandHandler()
    {
        aClass19_1331 = new Deque(169);
        extrafiles_str = "";
        aBoolean1336 = true;
        aCRC32_1338 = new CRC32();
        payload = new byte[500];
        anInt1340 = 923;
        aByteArrayArray1342 = new byte[4][];
        aClass19_1344 = new Deque(169);
        anInt1352 = 13603;
        aBoolean1353 = true;
        aBoolean1355 = false;
        aBoolean1357 = false;
        aClass19_1358 = new Deque(169);
        aByteArray1359 = new byte[65000];
        aClass2_1361 = new Queue(anInt1345);
        versions = new int[4][];
        crcs = new int[4][];
        aClass19_1368 = new Deque(169);
        aClass19_1370 = new Deque(169);
    }

    public int amount_extras;
    public Deque aClass19_1331;
    public int anInt1332;
    public String extrafiles_str;
    public int anInt1334;
    public long aLong1335;
    public boolean aBoolean1336;
    public int map_index1[];
    public CRC32 aCRC32_1338;
    public byte payload[];
    public int anInt1340;
    public int ondemand_cycle;
    public byte aByteArrayArray1342[][];
    public Main main;
    public Deque aClass19_1344;
    public static int anInt1345;
    public int requestposition;
    public int requestoffset;
    public int midi_index[];
    public int anInt1349;
    public int map_index0[];
    public int loaded_extras;
    public int anInt1352;
    public boolean aBoolean1353;
    public OutputStream outputstream;
    public boolean aBoolean1355;
    public int extra_maps[];
    public boolean aBoolean1357;
    public Deque aClass19_1358;
    public byte aByteArray1359[];
    public int anim_index[];
    public Queue aClass2_1361;
    public InputStream inputstream;
    public Socket socket;
    public int versions[][];
    public int crcs[][];
    public int anInt1366;
    public int anInt1367;
    public Deque aClass19_1368;
    public OndemandRequest currentrequest;
    public Deque aClass19_1370;
    public int region_ptrs[];
    public byte model_index[];
    public int anInt1373;
}
