// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.zip.CRC32;
import sign.signlink;

public class Main extends RSApplet {

    public static String method14(int i, int j) {
        String s = String.valueOf(i);
        for(int k = s.length() - 3; k > 0; k -= 3)
            s = s.substring(0, k) + "," + s.substring(k);
        if(j != 0)
            aBoolean1224 = !aBoolean1224;
        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return " " + s;
    }

    public void stopMidi(int junk)
    {
        signlink.midifade = 0;
        signlink.midi = "stop";
    }

    public void grabCRCs(int i) {
        /*
        if(i <= 0)
            anInt1218 = packetencryption.poll();
        int j = 5;
        cacheidx_crcs[8] = 0;
        int k = 0;
        while(cacheidx_crcs[8] == 0) 
        {
            String s = "Unknown problem";
            drawLoadingBar(20, (byte)4, "Connecting to web server");
            try
            {
                DataInputStream datainputstream = getJAGGRABRequest("crc" + (int)(Math.random() * 99999999D) + "-" + 317);
                Buffer buffer0 = new Buffer(new byte[40], 891);
                datainputstream.readFully(buffer0.payload, 0, 40);
                datainputstream.close();
                for(int i1 = 0; i1 < 9; i1++)
                    cacheidx_crcs[i1] = buffer0.getInt();

                int j1 = buffer0.getInt();
                int k1 = 1234;
                for(int l1 = 0; l1 < 9; l1++)
                    k1 = (k1 << 1) + cacheidx_crcs[l1];

                if(j1 != k1)
                {
                    s = "checksum problem";
                    cacheidx_crcs[8] = 0;
                }
            }
            catch(EOFException _ex)
            {
                s = "EOF problem";
                cacheidx_crcs[8] = 0;
            }
            catch(IOException _ex)
            {
                s = "Connection problem";
                cacheidx_crcs[8] = 0;
            }
            catch(Exception _ex)
            {
                s = "Logic problem";
                cacheidx_crcs[8] = 0;
                if(!signlink.reporterror)
                    return;
            }
            if(cacheidx_crcs[8] == 0)
            {
                k++;
                for(int l = j; l > 0; l--)
                {
                    if(k >= 10)
                    {
                        drawLoadingBar(10, (byte)4, "Game updated - please reload page");
                        l = 10;
                    } else
                    {
                        drawLoadingBar(10, (byte)4, s + " - Will retry in " + l + " secs.");
                    }
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(Exception _ex) { }
                }

                j *= 2;
                if(j > 60)
                    j = 60;
                aBoolean872 = !aBoolean872;
            }
        } 
         */
    }

    public boolean method17(int i, int j)
    {
        if(j < 0)
            return false;
        int k = interfaceopcodestack[j];
        if(i != 9)
            packetnum = -1;
        if(k >= 2000)
            k -= 2000;
        return k == 337;
    }

    public void renderChat(int i)
    {
        chat_imagefetcher.initialize(0);
        TriangleRasterizer.heightoffsets = anIntArray1180;
        chatback.renderImage(0, 16083, 0);
        if(aBoolean1256)
        {
            b12_font.drawCenteredYText(0, aString1121, 23693, 40, 239);
            b12_font.drawCenteredYText(128, aString1212 + "*", 23693, 60, 239);
        } else
        if(anInt1225 == 1)
        {
            b12_font.drawCenteredYText(0, "Enter amount:", 23693, 40, 239);
            b12_font.drawCenteredYText(128, aString1004 + "*", 23693, 60, 239);
        } else
        if(anInt1225 == 2)
        {
            b12_font.drawCenteredYText(0, "Enter name:", 23693, 40, 239);
            b12_font.drawCenteredYText(128, aString1004 + "*", 23693, 60, 239);
        } else
        if(aString844 != null)
        {
            b12_font.drawCenteredYText(0, aString844, 23693, 40, 239);
            b12_font.drawCenteredYText(128, "Click to continue", 23693, 60, 239);
        } else
        if(anInt1276 != -1)
            drawWidget(Widget.widgets[anInt1276],0, 0, 0);
        else
        if(anInt1042 != -1)
        {
            drawWidget(Widget.widgets[anInt1042],0, 0, 0);
        } else
        {
            RSFont class30_sub2_sub1_sub4 = p12_font;
            int j = 0;
            Raster.setDimensions(463, 0, 77, 0);
            for(int k = 0; k < 100; k++)
                if(msgbody_stack[k] != null)
                {
                    int l = msgtype_stack[k];
                    int i1 = (70 - j * 14) + anInt1089;
                    String s1 = msgprefix_stack[k];
                    byte byte0 = 0;
                    if(s1 != null && s1.startsWith("@cr1@"))
                    {
                        s1 = s1.substring(5);
                        byte0 = 1;
                    }
                    if(s1 != null && s1.startsWith("@cr2@"))
                    {
                        s1 = s1.substring(5);
                        byte0 = 2;
                    }
                    if(l == 0)
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.drawText(0, msgbody_stack[k], i1, 822, 4);
                        j++;
                    }
                    if((l == 1 || l == 2) && (l == 1 || anInt1287 == 0 || anInt1287 == 1 && onFriendsList(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                        {
                            int j1 = 4;
                            if(byte0 == 1)
                            {
                                mod_icons[0].renderImage(j1, 16083, i1 - 12);
                                j1 += 14;
                            }
                            if(byte0 == 2)
                            {
                                mod_icons[1].renderImage(j1, 16083, i1 - 12);
                                j1 += 14;
                            }
                            class30_sub2_sub1_sub4.drawText(0, s1 + ":", i1, 822, j1);
                            j1 += class30_sub2_sub1_sub4.widthFontMetrics(anInt1116, s1) + 8;
                            class30_sub2_sub1_sub4.drawText(255, msgbody_stack[k], i1, 822, j1);
                        }
                        j++;
                    }
                    if((l == 3 || l == 7) && anInt1195 == 0 && (l == 7 || anInt845 == 0 || anInt845 == 1 && onFriendsList(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                        {
                            int k1 = 4;
                            class30_sub2_sub1_sub4.drawText(0, "From", i1, 822, k1);
                            k1 += class30_sub2_sub1_sub4.widthFontMetrics(anInt1116, "From ");
                            if(byte0 == 1)
                            {
                                mod_icons[0].renderImage(k1, 16083, i1 - 12);
                                k1 += 14;
                            }
                            if(byte0 == 2)
                            {
                                mod_icons[1].renderImage(k1, 16083, i1 - 12);
                                k1 += 14;
                            }
                            class30_sub2_sub1_sub4.drawText(0, s1 + ":", i1, 822, k1);
                            k1 += class30_sub2_sub1_sub4.widthFontMetrics(anInt1116, s1) + 8;
                            class30_sub2_sub1_sub4.drawText(0x800000, msgbody_stack[k], i1, 822, k1);
                        }
                        j++;
                    }
                    if(l == 4 && (anInt1248 == 0 || anInt1248 == 1 && onFriendsList(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.drawText(0x800080, s1 + " " + msgbody_stack[k], i1, 822, 4);
                        j++;
                    }
                    if(l == 5 && anInt1195 == 0 && anInt845 < 2)
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.drawText(0x800000, msgbody_stack[k], i1, 822, 4);
                        j++;
                    }
                    if(l == 6 && anInt1195 == 0 && anInt845 < 2)
                    {
                        if(i1 > 0 && i1 < 110)
                        {
                            class30_sub2_sub1_sub4.drawText(0, "To " + s1 + ":", i1, 822, 4);
                            class30_sub2_sub1_sub4.drawText(0x800000, msgbody_stack[k], i1, 822, 12 + class30_sub2_sub1_sub4.widthFontMetrics(anInt1116, "To " + s1));
                        }
                        j++;
                    }
                    if(l == 8 && (anInt1248 == 0 || anInt1248 == 1 && onFriendsList(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.drawText(0x7e3200, s1 + " " + msgbody_stack[k], i1, 822, 4);
                        j++;
                    }
                }

            Raster.reset();
            anInt1211 = j * 14 + 7;
            if(anInt1211 < 78)
                anInt1211 = 78;
            drawScrollBar(519, 77, anInt1211 - anInt1089 - 77, 0, 463, anInt1211);
            String s;
            if(localplayer != null && localplayer.name != null)
                s = localplayer.name;
            else
                s = TextUtils.formatUsername(-45804, username);
            class30_sub2_sub1_sub4.drawText(0, s + ":", 90, 822, 4);
            class30_sub2_sub1_sub4.drawText(255, aString887 + "*", 90, 822, 6 + class30_sub2_sub1_sub4.widthFontMetrics(anInt1116, s + ": "));
            Raster.drawHorizontalLine(0, 77, 479, 0);
        }
        if(aBoolean885 && clickarea == 2)
            method40((byte)9);
        chat_imagefetcher.updateGraphics(357, 23680, super.graphics, 17);
        toplefttext_imagefetcher.initialize(0);
        TriangleRasterizer.heightoffsets = anIntArray1182;
        if(i < 6 || i > 6)
            aBoolean991 = !aBoolean991;
    }

    public void init() {
        nodeid = Integer.parseInt(getParameter("nodeid"));
        portoff = Integer.parseInt(getParameter("portoff"));
        String s = getParameter("lowmem");
        if(s != null && s.equals("1"))
            setLowMem((byte)77);
        else
            setHighMem(false);
        String s1 = getParameter("free");
        if(s1 != null && s1.equals("1"))
            members = false;
        else
            members = true;
        webInitialize(503, false, 765);
    }

    public void spawnThread(Runnable runnable, int i)
    {
        if(i > 10)
            i = 10;
        if(signlink.mainapp != null)
        {
            signlink.startthread(runnable, i);
            return;
        } else
        {
            super.spawnThread(runnable, i);
            return;
        }
    }

    public Socket spawnSocket(int i) throws IOException {
        if(signlink.mainapp != null)
            return signlink.opensocket(i);
        else
            return new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
    }

    public void handleClickPackets_(int i)
    {
        if(i != 4)
            packetnum = inbuffer.getUByte();
        if(anInt1086 != 0)
            return;
        int j = super.anInt26;
        if(anInt1136 == 1 && super.curpressed_x >= 516 && super.curpressed_y >= 160 && super.curpressed_x <= 765 && super.curpressed_y <= 205)
            j = 0;
        if(aBoolean885)
        {
            if(j != 1)
            {
                int k = super.mouse_x;
                int j1 = super.mouse_y;
                if(clickarea == 0)
                {
                    k -= 4;
                    j1 -= 4;
                }
                if(clickarea == 1)
                {
                    k -= 553;
                    j1 -= 205;
                }
                if(clickarea == 2)
                {
                    k -= 17;
                    j1 -= 357;
                }
                if(k < anInt949 - 10 || k > anInt949 + anInt951 + 10 || j1 < anInt950 - 10 || j1 > anInt950 + anInt952 + 10)
                {
                    aBoolean885 = false;
                    if(clickarea == 1)
                        aBoolean1153 = true;
                    if(clickarea == 2)
                        aBoolean1223 = true;
                }
            }
            if(j == 1)
            {
                int l = anInt949;
                int k1 = anInt950;
                int i2 = anInt951;
                int k2 = super.curpressed_x;
                int l2 = super.curpressed_y;
                if(clickarea == 0)
                {
                    k2 -= 4;
                    l2 -= 4;
                }
                if(clickarea == 1)
                {
                    k2 -= 553;
                    l2 -= 205;
                }
                if(clickarea == 2)
                {
                    k2 -= 17;
                    l2 -= 357;
                }
                int i3 = -1;
                for(int j3 = 0; j3 < anInt1133; j3++)
                {
                    int k3 = k1 + 31 + (anInt1133 - 1 - j3) * 15;
                    if(k2 > l && k2 < l + i2 && l2 > k3 - 13 && l2 < k3 + 3)
                        i3 = j3;
                }

                if(i3 != -1)
                    handleClick(i3, false);
                aBoolean885 = false;
                if(clickarea == 1)
                    aBoolean1153 = true;
                if(clickarea == 2)
                {
                    aBoolean1223 = true;
                    return;
                }
            }
        } else
        {
            if(j == 1 && anInt1133 > 0)
            {
                int i1 = interfaceopcodestack[anInt1133 - 1];
                if(i1 == 632 || i1 == 78 || i1 == 867 || i1 == 431 || i1 == 53 || i1 == 74 || i1 == 454 || i1 == 539 || i1 == 493 || i1 == 847 || i1 == 447 || i1 == 1125)
                {
                    int l1 = interfacestack_a[anInt1133 - 1];
                    int j2 = interfacestack_b[anInt1133 - 1];
                    Widget class9 = Widget.widgets[j2];
                    if(class9.aBoolean259 || class9.aBoolean235)
                    {
                        aBoolean1242 = false;
                        anInt989 = 0;
                        moveitem_frameid = j2;
                        moveitem_startslot = l1;
                        anInt1086 = 2;
                        anInt1087 = super.curpressed_x;
                        anInt1088 = super.curpressed_y;
                        if(Widget.widgets[j2].parentid == anInt857)
                            anInt1086 = 1;
                        if(Widget.widgets[j2].parentid == anInt1276)
                            anInt1086 = 3;
                        return;
                    }
                }
            }
            if(j == 1 && (anInt1253 == 1 || method17(9, anInt1133 - 1)) && anInt1133 > 2)
                j = 2;
            if(j == 1 && anInt1133 > 0)
                handleClick(anInt1133 - 1, false);
            if(j == 2 && anInt1133 > 0)
                method116(true);
        }
    }

    public void initMidi(boolean fade, int junk, byte data[])
    {
        signlink.midifade = fade ? 1 : 0;
        signlink.midisave(data, data.length);
    }

    public void processLandscapeLoading_(boolean flag)
    {
        try
        {
            anInt985 = -1;
            gfxs_storage.clear();
            aClass19_1013.clear();
            TriangleRasterizer.resetCaches(anInt846);
            clearModelCaches(false);
            pallet.reset();
            System.gc();
            for(int i = 0; i < 4; i++)
                collisionmaps[i].initialize();
            for(int l = 0; l < 4; l++)
            {
                for(int k1 = 0; k1 < 104; k1++)
                {
                    for(int j2 = 0; j2 < 104; j2++)
                        main_tilesettings[l][k1][j2] = 0;
                }
            }

            MapLoader class7 = new MapLoader(main_tilesettings, -60, 104, 104, main_heightmap);
            int k2 = tilebytes.length;
            packetbuffer.putPacket(0);
            if(!aBoolean1159)
            {
                for(int i3 = 0; i3 < k2; i3++)
                {
                    int i4 = (regionhashes[i3] >> 8) * 64 - palettex;
                    int k5 = (regionhashes[i3] & 0xff) * 64 - palettey;
                    byte abyte0[] = tilebytes[i3];
                    if(abyte0 != null)
                        class7.method180(abyte0, k5, i4, (chunkx_ - 6) * 8, (chunky_ - 6) * 8, (byte)4, collisionmaps);
                }

                for(int j4 = 0; j4 < k2; j4++)
                {
                    int l5 = (regionhashes[j4] >> 8) * 64 - palettex;
                    int k7 = (regionhashes[j4] & 0xff) * 64 - palettey;
                    byte abyte2[] = tilebytes[j4];
                    if(abyte2 == null && chunky_ < 800)
                        class7.method174(k7, 64, 0, 64, l5);
                }

                anInt1097++;
                if(anInt1097 > 160)
                {
                    anInt1097 = 0;
                    packetbuffer.putPacket(238);
                    packetbuffer.put(96);
                }
                packetbuffer.putPacket(0);
                for(int i6 = 0; i6 < k2; i6++)
                {
                    byte abyte1[] = regionbytes[i6];
                    if(abyte1 != null)
                    {
                        int l8 = (regionhashes[i6] >> 8) * 64 - palettex;
                        int k9 = (regionhashes[i6] & 0xff) * 64 - palettey;
                        class7.method190(l8, collisionmaps, k9, 7, pallet, abyte1);
                    }
                }

            }
            if(aBoolean1159)
            {
                for(int j3 = 0; j3 < 4; j3++)
                {
                    for(int k4 = 0; k4 < 13; k4++)
                    {
                        for(int j6 = 0; j6 < 13; j6++)
                        {
                            int l7 = custompalette[j3][k4][j6];
                            if(l7 != -1)
                            {
                                int i9 = l7 >> 24 & 3;
                                int l9 = l7 >> 1 & 3;
                                int j10 = l7 >> 14 & 0x3ff;
                                int l10 = l7 >> 3 & 0x7ff;
                                int j11 = (j10 / 8 << 8) + l10 / 8;
                                for(int l11 = 0; l11 < regionhashes.length; l11++)
                                {
                                    if(regionhashes[l11] != j11 || tilebytes[l11] == null)
                                        continue;
                                    class7.method179(i9, l9, collisionmaps, 9, k4 * 8, (j10 & 7) * 8, tilebytes[l11], (l10 & 7) * 8, j3, j6 * 8);
                                    break;
                                }

                            }
                        }

                    }

                }

                for(int l4 = 0; l4 < 13; l4++)
                {
                    for(int k6 = 0; k6 < 13; k6++)
                    {
                        int i8 = custompalette[0][l4][k6];
                        if(i8 == -1)
                            class7.method174(k6 * 8, 8, 0, 8, l4 * 8);
                    }

                }

                packetbuffer.putPacket(0);
                for(int h = 0; h < 4; h++)
                {
                    for(int x = 0; x < 13; x++)
                    {
                        for(int y = 0; y < 13; y++)
                        {
                            int i10 = custompalette[h][x][y];
                            if(i10 != -1)
                            {
                                int z = i10 >> 24 & 3;
                                int rotation = i10 >> 1 & 3;
                                int chunkx = i10 >> 14 & 0x3ff;
                                int chunky = i10 >> 3 & 0x7ff;
                                int regionhash = (chunkx / 8 << 8) + chunky / 8;
                                for(int k12 = 0; k12 < regionhashes.length; k12++)
                                {
                                    if(regionhashes[k12] != regionhash || regionbytes[k12] == null)
                                        continue;
                                    class7.loadConstructionChunk(collisionmaps, pallet, z, x * 8, (chunky & 7) * 8, true, h, regionbytes[k12], (chunkx & 7) * 8, rotation, y * 8);
                                    break;
                                }

                            }
                        }

                    }

                }

            }
            packetbuffer.putPacket(0);
            class7.method171(collisionmaps, pallet, 2);
            toplefttext_imagefetcher.initialize(0);
            packetbuffer.putPacket(0);
            int k3 = MapLoader.anInt145;
            if(k3 > cheight)
                k3 = cheight;
            if(k3 < cheight - 1)
                k3 = cheight - 1;
            if(lowmemory)
                pallet.buildPlane(MapLoader.anInt145);
            else
                pallet.buildPlane(0);
            for(int i5 = 0; i5 < 104; i5++)
            {
                for(int i7 = 0; i7 < 104; i7++)
                    method25(i5, i7);

            }

            anInt1051++;
            if(anInt1051 > 98)
            {
                anInt1051 = 0;
                packetbuffer.putPacket(150);
            }
            method63(-919);
        }
        catch(Exception exception) { }
        ObjectDefinition.aClass12_785.clear();
        aBoolean1157 &= flag;
        if(super.rs_frame != null)
        {
            packetbuffer.putPacket(210);
            packetbuffer.putInt(0x3f008edd);
        }
        if(lowmemory && signlink.cache_dat != null)
        {
            int j = ondemandhandler.getAmountArchives(79, 0);
            for(int i1 = 0; i1 < j; i1++)
            {
                int l1 = ondemandhandler.getModelIndex(i1, -203);
                if((l1 & 0x79) == 0)
                    Model.remove(116, i1);
            }

        }
        System.gc();
        TriangleRasterizer.initialize(20, true);
        ondemandhandler.method566(0);
        int k = (chunkx_ - 6) / 8 - 1;
        int j1 = (chunkx_ + 6) / 8 + 1;
        int i2 = (chunky_ - 6) / 8 - 1;
        int l2 = (chunky_ + 6) / 8 + 1;
        if(isLoadedLandscapes)
        {
            k = 49;
            j1 = 50;
            i2 = 49;
            l2 = 50;
        }
        for(int l3 = k; l3 <= j1; l3++)
        {
            for(int j5 = i2; j5 <= l2; j5++)
                if(l3 == k || l3 == j1 || j5 == i2 || j5 == l2)
                {
                    int j7 = ondemandhandler.method562(0, 0, j5, l3);
                    if(j7 != -1)
                        ondemandhandler.requestArchive(j7, 3, false);
                    int k8 = ondemandhandler.method562(1, 0, j5, l3);
                    if(k8 != -1)
                        ondemandhandler.requestArchive(k8, 3, false);
                }

        }

    }

    public void clearModelCaches(boolean junk)
    {
        ObjectDefinition.aClass12_785.clear();
        ObjectDefinition.object_modelstorage.clear();
        NPCDefinition.aClass12_95.clear();
        ItemDefinition.item_modelstorage.clear();
        ItemDefinition.aClass12_158.clear();
        Player.aClass12_1704.clear();
        SpotAnim.aClass12_415.clear();
    }

    public void method24(boolean flag, int i)
    {
        int ai[] = aClass30_Sub2_Sub1_Sub1_1263.pixels;
        int j = ai.length;
        for(int k = 0; k < j; k++)
            ai[k] = 0;

        for(int l = 1; l < 103; l++)
        {
            int i1 = 24628 + (103 - l) * 512 * 4;
            for(int k1 = 1; k1 < 103; k1++)
            {
                if((main_tilesettings[i][k1][l] & 0x18) == 0)
                    pallet.method309(ai, i1, 512, i, k1, l);
                if(i < 3 && (main_tilesettings[i + 1][k1][l] & 8) != 0)
                    pallet.method309(ai, i1, 512, i + 1, k1, l);
                i1 += 4;
            }

        }

        int j1 = ((238 + (int)(Math.random() * 20D)) - 10 << 16) + ((238 + (int)(Math.random() * 20D)) - 10 << 8) + ((238 + (int)(Math.random() * 20D)) - 10);
        int l1 = (238 + (int)(Math.random() * 20D)) - 10 << 16;
        aClass30_Sub2_Sub1_Sub1_1263.setOutput();
        for(int i2 = 1; i2 < 103; i2++)
        {
            for(int j2 = 1; j2 < 103; j2++)
            {
                if((main_tilesettings[i][j2][i2] & 0x18) == 0)
                    method50(i2, -960, j1, j2, l1, i);
                if(i < 3 && (main_tilesettings[i + 1][j2][i2] & 8) != 0)
                    method50(i2, -960, j1, j2, l1, i + 1);
            }

        }

        toplefttext_imagefetcher.initialize(0);
        aBoolean1157 &= flag;
        mapfunctionstackpos = 0;
        for(int k2 = 0; k2 < 104; k2++)
        {
            for(int l2 = 0; l2 < 104; l2++)
            {
                int i3 = pallet.method303(cheight, k2, l2);
                if(i3 != 0)
                {
                    i3 = i3 >> 14 & 0x7fff;
                    int j3 = ObjectDefinition.getObjectDefinition(i3).mapsprite;
                    if(j3 >= 0)
                    {
                        int k3 = k2;
                        int l3 = l2;
                        if(j3 != 22 && j3 != 29 && j3 != 34 && j3 != 36 && j3 != 46 && j3 != 47 && j3 != 48)
                        {
                            byte byte0 = 104;
                            byte byte1 = 104;
                            int ai1[][] = collisionmaps[cheight].index;
                            for(int i4 = 0; i4 < 10; i4++)
                            {
                                int j4 = (int)(Math.random() * 4D);
                                if(j4 == 0 && k3 > 0 && k3 > k2 - 3 && (ai1[k3 - 1][l3] & 0x1280108) == 0)
                                    k3--;
                                if(j4 == 1 && k3 < byte0 - 1 && k3 < k2 + 3 && (ai1[k3 + 1][l3] & 0x1280180) == 0)
                                    k3++;
                                if(j4 == 2 && l3 > 0 && l3 > l2 - 3 && (ai1[k3][l3 - 1] & 0x1280102) == 0)
                                    l3--;
                                if(j4 == 3 && l3 < byte1 - 1 && l3 < l2 + 3 && (ai1[k3][l3 + 1] & 0x1280120) == 0)
                                    l3++;
                            }

                        }
                        mapfunctionstack[mapfunctionstackpos] = mapfunction[j3];
                        anIntArray1072[mapfunctionstackpos] = k3;
                        anIntArray1073[mapfunctionstackpos] = l3;
                        mapfunctionstackpos++;
                    }
                }
            }

        }

    }

    public void method25(int i, int j)
    {
        Deque class19 = grounditems[cheight][i][j];
        if(class19 == null)
        {
            pallet.method295(cheight, i, j);
            return;
        }
        int k = 0xfa0a1f01;
        Object obj = null;
        for(GroundItem class30_sub2_sub4_sub2 = (GroundItem)class19.getFirst(); class30_sub2_sub4_sub2 != null; class30_sub2_sub4_sub2 = (GroundItem)class19.getNextForwards(false))
        {
            ItemDefinition class8 = ItemDefinition.getItemDefinition(class30_sub2_sub4_sub2.itemid);
            int l = class8.anInt155;
            if(class8.aBoolean176)
                l *= class30_sub2_sub4_sub2.amount + 1;
            if(l > k)
            {
                k = l;
                obj = class30_sub2_sub4_sub2;
            }
        }

        class19.addFirst(-493, ((Node) (obj)));
        Object obj1 = null;
        Object obj2 = null;
        for(GroundItem class30_sub2_sub4_sub2_1 = (GroundItem)class19.getFirst(); class30_sub2_sub4_sub2_1 != null; class30_sub2_sub4_sub2_1 = (GroundItem)class19.getNextForwards(false))
        {
            if(class30_sub2_sub4_sub2_1.itemid != ((GroundItem) (obj)).itemid && obj1 == null)
                obj1 = class30_sub2_sub4_sub2_1;
            if(class30_sub2_sub4_sub2_1.itemid != ((GroundItem) (obj)).itemid && class30_sub2_sub4_sub2_1.itemid != ((GroundItem) (obj1)).itemid && obj2 == null)
                obj2 = class30_sub2_sub4_sub2_1;
        }

        int i1 = i + (j << 7) + 0x60000000;
        pallet.method281((byte)7, i, i1, ((Entity) (obj1)), calculateTileHeight( i * 128 + 64, j * 128 + 64, cheight), ((Entity) (obj2)), ((Entity) (obj)), cheight, j);
    }

    public void processNPCs(boolean flag, int i)
    {
        for(int j = 0; j < anInt836; j++)
        {
            NPC class30_sub2_sub4_sub1_sub1 = npcs[updatenpcs[j]];
            int k = 0x20000000 + (updatenpcs[j] << 14);
            if(class30_sub2_sub4_sub1_sub1 == null || !class30_sub2_sub4_sub1_sub1.hasDefinition(aBoolean1224) || class30_sub2_sub4_sub1_sub1.definition.placementpriority != flag)
                continue;
            int l = ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx >> 7;
            int i1 = ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy >> 7;
            if(l < 0 || l >= 104 || i1 < 0 || i1 >= 104)
                continue;
            if(((Mob) (class30_sub2_sub4_sub1_sub1)).halftile_offsets == 1 && (((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx & 0x7f) == 64 && (((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy & 0x7f) == 64)
            {
                if(anIntArrayArray929[l][i1] == anInt1265)
                    continue;
                anIntArrayArray929[l][i1] = anInt1265;
            }
            if(!class30_sub2_sub4_sub1_sub1.definition.isvisible)
                k += 0x80000000;
            pallet.method285(cheight, ((Mob) (class30_sub2_sub4_sub1_sub1)).anInt1552, (byte)6, calculateTileHeight( ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx, ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy, cheight), k, ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy, (((Mob) (class30_sub2_sub4_sub1_sub1)).halftile_offsets - 1) * 64 + 60, ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx, class30_sub2_sub4_sub1_sub1, ((Mob) (class30_sub2_sub4_sub1_sub1)).aBoolean1541);
        }

        if(i == -30815);
    }

    public boolean waveReplay(int i)
    {
        if(i != 11456)
            throw new NullPointerException();
        else
            return signlink.wavereplay();
    }

    public void displayLoadError(String s)
    {
        try {
            getAppletContext().showDocument(new URL(getCodeBase(), "loaderror_" + s + ".html"));
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        do
            try
            {
                Thread.sleep(1000L);
            }
            catch(Exception _ex) { }
        while(true);
    }

    public void handleInterfaceOptions(int xlimit, int junk, Widget parent, int mousex, int ylimit, int mousey, int yoffset)
    {
        if(parent.widgettype != 0 || parent.childrenwidgets == null || parent.aBoolean266)
            return;
        if(mousex < xlimit || mousey < ylimit || mousex > xlimit + parent.width || mousey > ylimit + parent.height)
            return;
        int k1 = parent.childrenwidgets.length;
        for(int l1 = 0; l1 < k1; l1++)
        {
            int i2 = parent.positionx[l1] + xlimit;
            int j2 = (parent.positiony[l1] + ylimit) - yoffset;
            Widget class9_1 = Widget.widgets[parent.childrenwidgets[l1]];
            i2 += class9_1.anInt263;
            j2 += class9_1.anInt265;
            if((class9_1.anInt230 >= 0 || class9_1.anInt216 != 0) && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                if(class9_1.anInt230 >= 0)
                    anInt886 = class9_1.anInt230;
                else
                    anInt886 = class9_1.widgetid;
            if(class9_1.widgettype == 0)
            {
                handleInterfaceOptions(i2, 13037, class9_1, mousex, j2, mousey, class9_1.anInt224);
                if(class9_1.anInt261 > class9_1.height)
                    method65(i2 + class9_1.width, class9_1.height, mousex, mousey, class9_1, j2, true, class9_1.anInt261, 0);
            } else
            {
                if(class9_1.textfieldtype == 1 && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                {
                    boolean flag = false;
                    if(class9_1.actioncode != 0)
                        flag = method103(class9_1, false);
                    if(!flag)
                    {
                        interfacestringstack[anInt1133] = class9_1.aString221;
                        interfaceopcodestack[anInt1133] = 315;
                        interfacestack_b[anInt1133] = class9_1.widgetid;
                        anInt1133++;
                    }
                }
                if(class9_1.textfieldtype == 2 && anInt1136 == 0 && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                {
                    String s = class9_1.aString222;
                    if(s.indexOf(" ") != -1)
                        s = s.substring(0, s.indexOf(" "));
                    interfacestringstack[anInt1133] = s + " @gre@" + class9_1.aString218;
                    interfaceopcodestack[anInt1133] = 626;
                    interfacestack_b[anInt1133] = class9_1.widgetid;
                    anInt1133++;
                }
                if(class9_1.textfieldtype == 3 && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                {
                    interfacestringstack[anInt1133] = "Close";
                    interfaceopcodestack[anInt1133] = 200;
                    interfacestack_b[anInt1133] = class9_1.widgetid;
                    anInt1133++;
                }
                if(class9_1.textfieldtype == 4 && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                {
                    interfacestringstack[anInt1133] = class9_1.aString221;
                    interfaceopcodestack[anInt1133] = 169;
                    interfacestack_b[anInt1133] = class9_1.widgetid;
                    anInt1133++;
                }
                if(class9_1.textfieldtype == 5 && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                {
                    interfacestringstack[anInt1133] = class9_1.aString221;
                    interfaceopcodestack[anInt1133] = 646;
                    interfacestack_b[anInt1133] = class9_1.widgetid;
                    anInt1133++;
                }
                if(class9_1.textfieldtype == 6 && !aBoolean1149 && mousex >= i2 && mousey >= j2 && mousex < i2 + class9_1.width && mousey < j2 + class9_1.height)
                {
                    interfacestringstack[anInt1133] = class9_1.aString221;
                    interfaceopcodestack[anInt1133] = 679;
                    interfacestack_b[anInt1133] = class9_1.widgetid;
                    anInt1133++;
                }
                if(class9_1.widgettype == 2)
                {
                    int k2 = 0;
                    for(int l2 = 0; l2 < class9_1.height; l2++)
                    {
                        for(int i3 = 0; i3 < class9_1.width; i3++)
                        {
                            int j3 = i2 + i3 * (32 + class9_1.anInt231);
                            int k3 = j2 + l2 * (32 + class9_1.anInt244);
                            if(k2 < 20)
                            {
                                j3 += class9_1.anIntArray215[k2];
                                k3 += class9_1.anIntArray247[k2];
                            }
                            if(mousex >= j3 && mousey >= k3 && mousex < j3 + 32 && mousey < k3 + 32)
                            {
                                moveitem_endslot = k2;
                                anInt1067 = class9_1.widgetid;
                                if(class9_1.itemarray[k2] > 0)
                                {
                                    ItemDefinition class8 = ItemDefinition.getItemDefinition(class9_1.itemarray[k2] - 1);
                                    if(anInt1282 == 1 && class9_1.aBoolean249)
                                    {
                                        if(class9_1.widgetid != anInt1284 || k2 != anInt1283)
                                        {
                                            interfacestringstack[anInt1133] = "Use " + aString1286 + " with @lre@" + class8.name;
                                            interfaceopcodestack[anInt1133] = 870;
                                            interfacestack_c[anInt1133] = class8.id;
                                            interfacestack_a[anInt1133] = k2;
                                            interfacestack_b[anInt1133] = class9_1.widgetid;
                                            anInt1133++;
                                        }
                                    } else
                                    if(anInt1136 == 1 && class9_1.aBoolean249)
                                    {
                                        if((anInt1138 & 0x10) == 16)
                                        {
                                            interfacestringstack[anInt1133] = aString1139 + " @lre@" + class8.name;
                                            interfaceopcodestack[anInt1133] = 543;
                                            interfacestack_c[anInt1133] = class8.id;
                                            interfacestack_a[anInt1133] = k2;
                                            interfacestack_b[anInt1133] = class9_1.widgetid;
                                            anInt1133++;
                                        }
                                    } else
                                    {
                                        if(class9_1.aBoolean249)
                                        {
                                            for(int l3 = 4; l3 >= 3; l3--)
                                                if(class8.inventory_options != null && class8.inventory_options[l3] != null)
                                                {
                                                    interfacestringstack[anInt1133] = class8.inventory_options[l3] + " @lre@" + class8.name;
                                                    if(l3 == 3)
                                                        interfaceopcodestack[anInt1133] = 493;
                                                    if(l3 == 4)
                                                        interfaceopcodestack[anInt1133] = 847;
                                                    interfacestack_c[anInt1133] = class8.id;
                                                    interfacestack_a[anInt1133] = k2;
                                                    interfacestack_b[anInt1133] = class9_1.widgetid;
                                                    anInt1133++;
                                                } else
                                                if(l3 == 4)
                                                {
                                                    interfacestringstack[anInt1133] = "Drop @lre@" + class8.name;
                                                    interfaceopcodestack[anInt1133] = 847;
                                                    interfacestack_c[anInt1133] = class8.id;
                                                    interfacestack_a[anInt1133] = k2;
                                                    interfacestack_b[anInt1133] = class9_1.widgetid;
                                                    anInt1133++;
                                                }

                                        }
                                        if(class9_1.aBoolean242)
                                        {
                                            interfacestringstack[anInt1133] = "Use @lre@" + class8.name;
                                            interfaceopcodestack[anInt1133] = 447;
                                            interfacestack_c[anInt1133] = class8.id;
                                            interfacestack_a[anInt1133] = k2;
                                            interfacestack_b[anInt1133] = class9_1.widgetid;
                                            anInt1133++;
                                        }
                                        if(class9_1.aBoolean249 && class8.inventory_options != null)
                                        {
                                            for(int i4 = 2; i4 >= 0; i4--)
                                                if(class8.inventory_options[i4] != null)
                                                {
                                                    interfacestringstack[anInt1133] = class8.inventory_options[i4] + " @lre@" + class8.name;
                                                    if(i4 == 0)
                                                        interfaceopcodestack[anInt1133] = 74;
                                                    if(i4 == 1)
                                                        interfaceopcodestack[anInt1133] = 454;
                                                    if(i4 == 2)
                                                        interfaceopcodestack[anInt1133] = 539;
                                                    interfacestack_c[anInt1133] = class8.id;
                                                    interfacestack_a[anInt1133] = k2;
                                                    interfacestack_b[anInt1133] = class9_1.widgetid;
                                                    anInt1133++;
                                                }

                                        }
                                        if(class9_1.itemoptions != null)
                                        {
                                            for(int j4 = 4; j4 >= 0; j4--)
                                                if(class9_1.itemoptions[j4] != null)
                                                {
                                                    interfacestringstack[anInt1133] = class9_1.itemoptions[j4] + " @lre@" + class8.name;
                                                    if(j4 == 0)
                                                        interfaceopcodestack[anInt1133] = 632;
                                                    if(j4 == 1)
                                                        interfaceopcodestack[anInt1133] = 78;
                                                    if(j4 == 2)
                                                        interfaceopcodestack[anInt1133] = 867;
                                                    if(j4 == 3)
                                                        interfaceopcodestack[anInt1133] = 431;
                                                    if(j4 == 4)
                                                        interfaceopcodestack[anInt1133] = 53;
                                                    interfacestack_c[anInt1133] = class8.id;
                                                    interfacestack_a[anInt1133] = k2;
                                                    interfacestack_b[anInt1133] = class9_1.widgetid;
                                                    anInt1133++;
                                                }

                                        }
                                        interfacestringstack[anInt1133] = "Examine @lre@" + class8.name;
                                        interfaceopcodestack[anInt1133] = 1125;
                                        interfacestack_c[anInt1133] = class8.id;
                                        interfacestack_a[anInt1133] = k2;
                                        interfacestack_b[anInt1133] = class9_1.widgetid;
                                        anInt1133++;
                                    }
                                }
                            }
                            k2++;
                        }

                    }

                }
            }
        }

    }

    public void drawScrollBar(int i, int j, int k, int l, int i1, int j1)
    {
        scrollbar0.renderImage(i1, 16083, l);
        scrollbar1.renderImage(i1, 16083, (l + j) - 16);
        Raster.drawQuadrilateral(i1, l + 16, 16, j - 32, anInt1002);
        int k1 = ((j - 32) * j) / j1;
        if(k1 < 8)
            k1 = 8;
        int l1 = ((j - 32 - k1) * k) / (j1 - j);
        Raster.drawQuadrilateral(i1, l + 16 + l1, 16, k1, anInt1063);
        Raster.drawVerticalLine(i1,l + 16 + l1, k1, anInt902);
        Raster.drawVerticalLine(i1 + 1, l + 16 + l1, k1, anInt902);
        Raster.drawHorizontalLine( i1, l + 16 + l1, 16, anInt902);
        Raster.drawHorizontalLine( i1, l + 17 + l1, 16, anInt902);
        Raster.drawVerticalLine(i1 + 15, l + 16 + l1, k1, anInt927);
        Raster.drawVerticalLine(i1 + 14, l + 17 + l1, k1 - 1, anInt927);
        Raster.drawHorizontalLine( i1, l + 15 + l1 + k1, 16, anInt927);
        Raster.drawHorizontalLine(i1 + 1, l + 14 + l1 + k1, 15, anInt927);
    }

    public void parseNpcUpdate(Buffer buffer, int i, int j)
    {
        amtplayerremovestack = 0;
        amtplayerupdatestack = 0;
        method139(buffer, -45, i);
        processNpcs(i, buffer, (byte)2);
        parseNpcUpdateMasks(i, buffer, true);
        for(int k = 0; k < amtplayerremovestack; k++)
        {
            int l = playerremove_stack[k];
            if(((Mob) (npcs[l])).anInt1537 != loopcycle)
            {
                npcs[l].definition = null;
                npcs[l] = null;
            }
        }

        if(buffer.position != i)
        {
            signlink.reporterror(username + " size mismatch in getnpcpos - pos:" + buffer.position + " psize:" + i);
            throw new RuntimeException("eek");
        }
        for(int i1 = 0; i1 < anInt836; i1++)
            if(npcs[updatenpcs[i1]] == null)
            {
                signlink.reporterror(username + " null entry in npc list - pos:" + i1 + " size:" + anInt836);
                throw new RuntimeException("eek");
            }

    }

    public void handleClientToolbar(boolean flag)
    {
        aBoolean1157 &= flag;
        if(super.anInt26 == 1)
        {
            if(super.curpressed_x >= 6 && super.curpressed_x <= 106 && super.curpressed_y >= 467 && super.curpressed_y <= 499)
            {
                anInt1287 = (anInt1287 + 1) % 4;
                updatetoolbar = true;
                aBoolean1223 = true;
                packetbuffer.putPacket(95);
                packetbuffer.put(anInt1287);
                packetbuffer.put(anInt845);
                packetbuffer.put(anInt1248);
            }
            if(super.curpressed_x >= 135 && super.curpressed_x <= 235 && super.curpressed_y >= 467 && super.curpressed_y <= 499)
            {
                anInt845 = (anInt845 + 1) % 3;
                updatetoolbar = true;
                aBoolean1223 = true;
                packetbuffer.putPacket(95);
                packetbuffer.put(anInt1287);
                packetbuffer.put(anInt845);
                packetbuffer.put(anInt1248);
            }
            if(super.curpressed_x >= 273 && super.curpressed_x <= 373 && super.curpressed_y >= 467 && super.curpressed_y <= 499)
            {
                anInt1248 = (anInt1248 + 1) % 3;
                updatetoolbar = true;
                aBoolean1223 = true;
                packetbuffer.putPacket(95);
                packetbuffer.put(anInt1287);
                packetbuffer.put(anInt845);
                packetbuffer.put(anInt1248);
            }
            if(super.curpressed_x >= 412 && super.curpressed_x <= 512 && super.curpressed_y >= 467 && super.curpressed_y <= 499)
                if(anInt857 == -1)
                {
                    method147(537);
                    aString881 = "";
                    aBoolean1158 = false;
                    for(int i = 0; i < Widget.widgets.length; i++)
                    {
                        if(Widget.widgets[i] == null || Widget.widgets[i].actioncode != 600)
                            continue;
                        anInt1178 = anInt857 = Widget.widgets[i].parentid;
                        break;
                    }

                } else
                {
                    pushMessage("Please close the interface you have open before using 'report abuse'", 0, "", aBoolean991);
                }
            anInt940++;
            if(anInt940 > 1386)
            {
                anInt940 = 0;
                packetbuffer.putPacket(165);
                packetbuffer.put(0);
                int j = packetbuffer.position;
                packetbuffer.put(139);
                packetbuffer.put(150);
                packetbuffer.putShort(32131);
                packetbuffer.put((int)(Math.random() * 256D));
                packetbuffer.putShort(3250);
                packetbuffer.put(177);
                packetbuffer.putShort(24859);
                packetbuffer.put(119);
                if((int)(Math.random() * 2D) == 0)
                    packetbuffer.putShort(47234);
                if((int)(Math.random() * 2D) == 0)
                    packetbuffer.put(21);
                packetbuffer.finishByteVar(packetbuffer.position - j, (byte)0);
            }
        }
    }

    public void parseClientVarps(boolean flag, int i) {
        int j = VarpFile.aClass41Array701[i].anInt709;
        if(j == 0)
            return;
        int k = configstates[i];
        if(flag)
            anInt961 = packetencryption.poll();
		/* Screen brighten */
        if(j == 1)
        {
            if(k == 1)
                TriangleRasterizer.method372(0.90000000000000002D, aByte1200);
            if(k == 2)
                TriangleRasterizer.method372(0.80000000000000004D, aByte1200);
            if(k == 3)
                TriangleRasterizer.method372(0.69999999999999996D, aByte1200);
            if(k == 4)
                TriangleRasterizer.method372(0.59999999999999998D, aByte1200);
            ItemDefinition.aClass12_158.clear();
            aBoolean1255 = true;
        }
        if(j == 3)
        {
            boolean flag1 = aBoolean1151;
            if(k == 0)
            {
                volumeAdjustMidi((byte)0, aBoolean1151, 0);
                aBoolean1151 = true;
            }
            if(k == 1)
            {
                volumeAdjustMidi((byte)0, aBoolean1151, -400);
                aBoolean1151 = true;
            }
            if(k == 2)
            {
                volumeAdjustMidi((byte)0, aBoolean1151, -800);
                aBoolean1151 = true;
            }
            if(k == 3)
            {
                volumeAdjustMidi((byte)0, aBoolean1151, -1200);
                aBoolean1151 = true;
            }
            if(k == 4)
                aBoolean1151 = false;
            if(aBoolean1151 != flag1 && !lowmemory)
            {
                if(aBoolean1151)
                {
                    anInt1227 = anInt956;
                    aBoolean1228 = true;
                    ondemandhandler.requestUrgentArchive(2, anInt1227);
                } else
                {
                    stopMidi(860);
                }
                anInt1259 = 0;
            }
        }
        if(j == 4)
        {
            if(k == 0)
            {
                aBoolean848 = true;
                method111((byte)2, 0);
            }
            if(k == 1)
            {
                aBoolean848 = true;
                method111((byte)2, -400);
            }
            if(k == 2)
            {
                aBoolean848 = true;
                method111((byte)2, -800);
            }
            if(k == 3)
            {
                aBoolean848 = true;
                method111((byte)2, -1200);
            }
            if(k == 4)
                aBoolean848 = false;
        }
        if(j == 5)
            anInt1253 = k;
        if(j == 6)
            anInt1249 = k;
        if(j == 8)
        {
            anInt1195 = k;
            aBoolean1223 = true;
        }
        if(j == 9)
            anInt913 = k;
    }

    public void updateMobGraphics(int i)
    {
        anInt974 = 0;
        for(int j = -1; j < anInt891 + anInt836; j++)
        {
            Object obj;
            if(j == -1)
                obj = localplayer;
            else
            if(j < anInt891)
                obj = players[anIntArray892[j]];
            else
                obj = npcs[updatenpcs[j - anInt891]];
            if(obj == null || !((Mob) (obj)).hasDefinition(aBoolean1224))
                continue;
            if(obj instanceof NPC)
            {
                NPCDefinition class5 = ((NPC)obj).definition;
                if(class5.confignpcs != null)
                    class5 = class5.method161(anInt877);
                if(class5 == null)
                    continue;
            }
            if(j < anInt891)
            {
                int l = 30;
                Player class30_sub2_sub4_sub1_sub2 = (Player)obj;
		/* Render active head icons */
                if(class30_sub2_sub4_sub1_sub2.active_headicons != 0)
                {
                    calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507 + 15);
                    if(spriteX > -1)
                    {
                        for(int i2 = 0; i2 < 8; i2++)
                            if((class30_sub2_sub4_sub1_sub2.active_headicons & 1 << i2) != 0)
                            {
                                headicons[i2].drawOverlay(spriteX - 12, 16083, spriteY - l);
                                l -= 25;
                            }
                    }
                }
		/* Render hint icon */
                if(j >= 0 && markertype == 10 && pmarker_id == anIntArray892[j])
                {
                    calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507 + 15);
                    if(spriteX > -1)
                        headicons[7].drawOverlay(spriteX - 12, 16083, spriteY - l);
                }
            } else
            {
                NPCDefinition class5_1 = ((NPC)obj).definition;
				/* Render NPC head icon */
                if(class5_1.npcheadicon >= 0 && class5_1.npcheadicon < headicons.length)
                {
                    calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507 + 15);
                    if(spriteX > -1)
                        headicons[class5_1.npcheadicon].drawOverlay(spriteX - 12, 16083, spriteY - 30);
                }
				/* Render hint icon */
                if(markertype == 1 && nmarker_id == updatenpcs[j - anInt891] && loopcycle % 20 < 10)
                {
                    calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507 + 15);
                    if(spriteX > -1)
                        headicons[2].drawOverlay(spriteX - 12, 16083, spriteY - 28);
                }
            }
			/* Update chat */
            if(((Mob) (obj)).chat_txt != null && (j >= anInt891 || anInt1287 == 0 || anInt1287 == 3 || anInt1287 == 1 && onFriendsList(false, ((Player)obj).name)))
            {
                calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507);
                if(spriteX > -1 && anInt974 < anInt975)
                {
                    anIntArray979[anInt974] = b12_font.heightFontMetrics(((Mob) (obj)).chat_txt, true) / 2;
                    anIntArray978[anInt974] = b12_font.maxh;
                    anIntArray976[anInt974] = spriteX;
                    anIntArray977[anInt974] = spriteY;
                    anIntArray980[anInt974] = ((Mob) (obj)).anInt1513;
                    anIntArray981[anInt974] = ((Mob) (obj)).anInt1531;
                    anIntArray982[anInt974] = ((Mob) (obj)).anInt1535;
                    aStringArray983[anInt974++] = ((Mob) (obj)).chat_txt;
                    if(anInt1249 == 0 && ((Mob) (obj)).anInt1531 >= 1 && ((Mob) (obj)).anInt1531 <= 3)
                    {
                        anIntArray978[anInt974] += 10;
                        anIntArray977[anInt974] += 5;
                    }
                    if(anInt1249 == 0 && ((Mob) (obj)).anInt1531 == 4)
                        anIntArray979[anInt974] = 60;
                    if(anInt1249 == 0 && ((Mob) (obj)).anInt1531 == 5)
                        anIntArray978[anInt974] += 5;
                }
            }
			/* Update HPs? */
            if(((Mob) (obj)).anInt1532 > loopcycle)
            {
                calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507 + 15);
                if(spriteX > -1)
                {
                    int i1 = (((Mob) (obj)).anInt1533 * 30) / ((Mob) (obj)).anInt1534;
                    if(i1 > 30)
                        i1 = 30;
                    Raster.drawQuadrilateral( spriteX - 15, spriteY - 3, i1, 5, 65280);
                    Raster.drawQuadrilateral((spriteX - 15) + i1, spriteY - 3, 30 - i1, 5, 0xff0000);
                }
            }
			/* Draw hitmarks */
            for(int j1 = 0; j1 < 4; j1++)
                if(((Mob) (obj)).hitdelay_stack[j1] > loopcycle)
                {
                    calculateSpriteMobXY(true, ((Mob) (obj)), ((Mob) (obj)).anInt1507 / 2);
                    if(spriteX > -1)
                    {
                        if(j1 == 1)
                            spriteY -= 20;
                        if(j1 == 2)
                        {
                            spriteX -= 15;
                            spriteY -= 10;
                        }
                        if(j1 == 3)
                        {
                            spriteX += 15;
                            spriteY -= 10;
                        }
                        hitmarks[((Mob) (obj)).hittype_stack[j1]].drawOverlay(spriteX - 12, 16083, spriteY - 12);
						/* Shadow */
                        p11_font.drawCenteredYText(0, String.valueOf(((Mob) (obj)).hitamt_stack[j1]), 23693, spriteY + 4, spriteX);
						/* Amount text */
                        p11_font.drawCenteredYText(0xffffff, String.valueOf(((Mob) (obj)).hitamt_stack[j1]), 23693, spriteY + 3, spriteX - 1);
                    }
                }

        }

        if(i != 0)
            loadClient();
        for(int k = 0; k < anInt974; k++)
        {
            int k1 = anIntArray976[k];
            int l1 = anIntArray977[k];
            int j2 = anIntArray979[k];
            int k2 = anIntArray978[k];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l2 = 0; l2 < k; l2++)
                    if(l1 + 2 > anIntArray977[l2] - anIntArray978[l2] && l1 - k2 < anIntArray977[l2] + 2 && k1 - j2 < anIntArray976[l2] + anIntArray979[l2] && k1 + j2 > anIntArray976[l2] - anIntArray979[l2] && anIntArray977[l2] - anIntArray978[l2] < l1)
                    {
                        l1 = anIntArray977[l2] - anIntArray978[l2];
                        flag = true;
                    }

            }
            spriteX = anIntArray976[k];
            spriteY = anIntArray977[k] = l1;
            String s = aStringArray983[k];
            if(anInt1249 == 0)
            {
                int i3 = 0xffff00;
                if(anIntArray980[k] < 6)
                    i3 = anIntArray965[anIntArray980[k]];
                if(anIntArray980[k] == 6)
                    i3 = anInt1265 % 20 >= 10 ? 0xffff00 : 0xff0000;
                if(anIntArray980[k] == 7)
                    i3 = anInt1265 % 20 >= 10 ? 65535 : 255;
                if(anIntArray980[k] == 8)
                    i3 = anInt1265 % 20 >= 10 ? 0x80ff80 : 45056;
                if(anIntArray980[k] == 9)
                {
                    int j3 = 150 - anIntArray982[k];
                    if(j3 < 50)
                        i3 = 0xff0000 + 1280 * j3;
                    else
                    if(j3 < 100)
                        i3 = 0xffff00 - 0x50000 * (j3 - 50);
                    else
                    if(j3 < 150)
                        i3 = 65280 + 5 * (j3 - 100);
                }
                if(anIntArray980[k] == 10)
                {
                    int k3 = 150 - anIntArray982[k];
                    if(k3 < 50)
                        i3 = 0xff0000 + 5 * k3;
                    else
                    if(k3 < 100)
                        i3 = 0xff00ff - 0x50000 * (k3 - 50);
                    else
                    if(k3 < 150)
                        i3 = (255 + 0x50000 * (k3 - 100)) - 5 * (k3 - 100);
                }
                if(anIntArray980[k] == 11)
                {
                    int l3 = 150 - anIntArray982[k];
                    if(l3 < 50)
                        i3 = 0xffffff - 0x50005 * l3;
                    else
                    if(l3 < 100)
                        i3 = 65280 + 0x50005 * (l3 - 50);
                    else
                    if(l3 < 150)
                        i3 = 0xffffff - 0x50000 * (l3 - 100);
                }
                if(anIntArray981[k] == 0)
                {
                    b12_font.drawCenteredYText(0, s, 23693, spriteY + 1, spriteX);
                    b12_font.drawCenteredYText(i3, s, 23693, spriteY, spriteX);
                }
                if(anIntArray981[k] == 1)
                {
                    b12_font.drawWaveyText(0, true, s, spriteX, anInt1265, spriteY + 1);
                    b12_font.drawWaveyText(i3, true, s, spriteX, anInt1265, spriteY);
                }
                if(anIntArray981[k] == 2)
                {
                    b12_font.drawWaveyText2(spriteX, s, anInt1265, spriteY + 1, aByte1194, 0);
                    b12_font.drawWaveyText2(spriteX, s, anInt1265, spriteY, aByte1194, i3);
                }
                if(anIntArray981[k] == 3)
                {
                    b12_font.drawWaveyText3(150 - anIntArray982[k], s, true, anInt1265, spriteY + 1, spriteX, 0);
                    b12_font.drawWaveyText3(150 - anIntArray982[k], s, true, anInt1265, spriteY, spriteX, i3);
                }
                if(anIntArray981[k] == 4)
                {
                    int i4 = b12_font.heightFontMetrics(s, true);
                    int k4 = ((150 - anIntArray982[k]) * (i4 + 100)) / 150;
                    Raster.setDimensions(spriteX + 50, spriteX - 50, 334, 0);
                    b12_font.drawText(0, s, spriteY + 1, 822, (spriteX + 50) - k4);
                    b12_font.drawText(i3, s, spriteY, 822, (spriteX + 50) - k4);
                    Raster.reset();
                }
                if(anIntArray981[k] == 5)
                {
                    int j4 = 150 - anIntArray982[k];
                    int l4 = 0;
                    if(j4 < 25)
                        l4 = j4 - 25;
                    else
                    if(j4 > 125)
                        l4 = j4 - 125;
                    Raster.setDimensions( 512, 0, spriteY + 5, spriteY - b12_font.maxh - 1);
                    b12_font.drawCenteredYText(0, s, 23693, spriteY + 1 + l4, spriteX);
                    b12_font.drawCenteredYText(i3, s, 23693, spriteY + l4, spriteX);
                    Raster.reset();
                }
            } else
            {
                b12_font.drawCenteredYText(0, s, 23693, spriteY + 1, spriteX);
                b12_font.drawCenteredYText(0xffff00, s, 23693, spriteY, spriteX);
            }
        }

    }

    public void removeFriend(boolean flag, long l)
    {
        try
        {
            if(l == 0L)
                return;
            for(int i = 0; i < amt_friendhashes; i++)
            {
                if(friend_hashes[i] != l)
                    continue;
                amt_friendhashes--;
                aBoolean1153 = true;
                for(int j = i; j < amt_friendhashes; j++)
                {
                    friendusernames[j] = friendusernames[j + 1];
                    anIntArray826[j] = anIntArray826[j + 1];
                    friend_hashes[j] = friend_hashes[j + 1];
                }

                packetbuffer.putPacket(215);
                packetbuffer.putLong(l);
                break;
            }

            if(flag)
                return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("18622, " + flag + ", " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method36(byte byte0)
    {
        aClass15_1163.initialize(0);
        TriangleRasterizer.heightoffsets = anIntArray1181;
        if(byte0 != -81)
            return;
        invback.renderImage(0, 16083, 0);
        if(anInt1189 != -1)
            drawWidget(Widget.widgets[anInt1189],0, 0, 0);
        else
        if(tab_interfaces[current_tab] != -1)
            drawWidget(Widget.widgets[tab_interfaces[current_tab]],0, 0, 0);
        if(aBoolean885 && clickarea == 1)
            method40((byte)9);
        aClass15_1163.updateGraphics(205, 23680, super.graphics, 553);
        toplefttext_imagefetcher.initialize(0);
        TriangleRasterizer.heightoffsets = anIntArray1182;
    }

    public void method37(int i, int j)
    {
        if(i <= 0)
            packetnum = -1;
        if(!lowmemory)
        {
            if(TriangleRasterizer.unpackcounters[17] >= j)
            {
                IndexedColorSprite class30_sub2_sub1_sub2 = TriangleRasterizer.textures[17];
                int k = class30_sub2_sub1_sub2.indexwidth_ * class30_sub2_sub1_sub2.indexheight_ - 1;
                int j1 = class30_sub2_sub1_sub2.indexwidth_ * anInt945 * 2;
                byte abyte0[] = class30_sub2_sub1_sub2.colorindex;
                byte abyte3[] = aByteArray912;
                for(int i2 = 0; i2 <= k; i2++)
                    abyte3[i2] = abyte0[i2 - j1 & k];

                class30_sub2_sub1_sub2.colorindex = abyte3;
                aByteArray912 = abyte0;
                TriangleRasterizer.pushTexture(17);
                anInt854++;
                if(anInt854 > 1235)
                {
                    anInt854 = 0;
                    packetbuffer.putPacket(226);
                    packetbuffer.put(0);
                    int l2 = packetbuffer.position;
                    packetbuffer.putShort(58722);
                    packetbuffer.put(240);
                    packetbuffer.putShort((int)(Math.random() * 65536D));
                    packetbuffer.put((int)(Math.random() * 256D));
                    if((int)(Math.random() * 2D) == 0)
                        packetbuffer.putShort(51825);
                    packetbuffer.put((int)(Math.random() * 256D));
                    packetbuffer.putShort((int)(Math.random() * 65536D));
                    packetbuffer.putShort(7130);
                    packetbuffer.putShort((int)(Math.random() * 65536D));
                    packetbuffer.putShort(61657);
                    packetbuffer.finishByteVar(packetbuffer.position - l2, (byte)0);
                }
            }
            if(TriangleRasterizer.unpackcounters[24] >= j)
            {
                IndexedColorSprite class30_sub2_sub1_sub2_1 = TriangleRasterizer.textures[24];
                int l = class30_sub2_sub1_sub2_1.indexwidth_ * class30_sub2_sub1_sub2_1.indexheight_ - 1;
                int k1 = class30_sub2_sub1_sub2_1.indexwidth_ * anInt945 * 2;
                byte abyte1[] = class30_sub2_sub1_sub2_1.colorindex;
                byte abyte4[] = aByteArray912;
                for(int j2 = 0; j2 <= l; j2++)
                    abyte4[j2] = abyte1[j2 - k1 & l];

                class30_sub2_sub1_sub2_1.colorindex = abyte4;
                aByteArray912 = abyte1;
                TriangleRasterizer.pushTexture(24);
            }
            if(TriangleRasterizer.unpackcounters[34] >= j)
            {
                IndexedColorSprite class30_sub2_sub1_sub2_2 = TriangleRasterizer.textures[34];
                int i1 = class30_sub2_sub1_sub2_2.indexwidth_ * class30_sub2_sub1_sub2_2.indexheight_ - 1;
                int l1 = class30_sub2_sub1_sub2_2.indexwidth_ * anInt945 * 2;
                byte abyte2[] = class30_sub2_sub1_sub2_2.colorindex;
                byte abyte5[] = aByteArray912;
                for(int k2 = 0; k2 <= i1; k2++)
                    abyte5[k2] = abyte2[k2 - l1 & i1];

                class30_sub2_sub1_sub2_2.colorindex = abyte5;
                aByteArray912 = abyte2;
                TriangleRasterizer.pushTexture(34);
            }
        }
    }

    public void resetMobsChatText(byte byte0)
    {
        if(byte0 != -92)
            packetbuffer.put(214);
        for(int i = -1; i < anInt891; i++)
        {
            int j;
            if(i == -1)
                j = localindex;
            else
                j = anIntArray892[i];
            Player class30_sub2_sub4_sub1_sub2 = players[j];
            if(class30_sub2_sub4_sub1_sub2 != null && ((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1535 > 0)
            {
                class30_sub2_sub4_sub1_sub2.anInt1535--;
                if(((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1535 == 0)
                    class30_sub2_sub4_sub1_sub2.chat_txt = null;
            }
        }

        for(int k = 0; k < anInt836; k++)
        {
            int l = updatenpcs[k];
            NPC class30_sub2_sub4_sub1_sub1 = npcs[l];
            if(class30_sub2_sub4_sub1_sub1 != null && ((Mob) (class30_sub2_sub4_sub1_sub1)).anInt1535 > 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1535--;
                if(((Mob) (class30_sub2_sub4_sub1_sub1)).anInt1535 == 0)
                    class30_sub2_sub4_sub1_sub1.chat_txt = null;
            }
        }

    }

    public void calculateCameraPosition(byte junk)
    {
		/* Spinning camera calculations */
        int i = spincam_x * 128 + 64;
        int j = spincam_y * 128 + 64;
        int k = calculateTileHeight(i, j, cheight) - spincam_z;
		/* Calculate moving right */
        if(camerax < i)
        {
            camerax += spincam_speed + ((i - camerax) * spincam_angle) / 1000;
            if(camerax > i)
                camerax = i;
        }
		/* Calculate moving left */
        if(camerax > i)
        {
            camerax -= spincam_speed + ((camerax - i) * spincam_angle) / 1000;
            if(camerax < i)
                camerax = i;
        }
		/* Calculate moving up */
        if(cameraz < k)
        {
            cameraz += spincam_speed + ((k - cameraz) * spincam_angle) / 1000;
            if(cameraz > k)
                cameraz = k;
        }
		/* Calculate moving down */
        if(cameraz > k)
        {
            cameraz -= spincam_speed + ((cameraz - k) * spincam_angle) / 1000;
            if(cameraz < k)
                cameraz = k;
        }
		/* Calculate moving forwards */
        if(cameray < j)
        {
            cameray += spincam_speed + ((j - cameray) * spincam_angle) / 1000;
            if(cameray > j)
                cameray = j;
        }
		/* Calculate moving backwards */
        if(cameray > j)
        {
            cameray -= spincam_speed + ((cameray - j) * spincam_angle) / 1000;
            if(cameray < j)
                cameray = j;
        }
        i = normalcam_x * 128 + 64;
        j = normalcam_y * 128 + 64;
        k = calculateTileHeight(i, j, cheight) - normalcam_z;
        int l = i - camerax;
        int i1 = k - cameraz;
        int j1 = j - cameray;
        int k1 = (int)Math.sqrt(l * l + j1 * j1);
        int l1 = (int)(Math.atan2(i1, k1) * 325.94900000000001D) & 0x7ff;
        int i2 = (int)(Math.atan2(l, j1) * -325.94900000000001D) & 0x7ff;
        if(l1 < 128)
            l1 = 128;
        if(l1 > 383)
            l1 = 383;
        if(camerapitch$ < l1)
        {
            camerapitch$ += normalcam_speed + ((l1 - camerapitch$) * normalcam_angle) / 1000;
            if(camerapitch$ > l1)
                camerapitch$ = l1;
        }
        if(camerapitch$ > l1)
        {
            camerapitch$ -= normalcam_speed + ((camerapitch$ - l1) * normalcam_angle) / 1000;
            if(camerapitch$ < l1)
                camerapitch$ = l1;
        }
        int j2 = i2 - camerayaw$;
        if(j2 > 1024)
            j2 -= 2048;
        if(j2 < -1024)
            j2 += 2048;
        if(j2 > 0)
        {
            camerayaw$ += normalcam_speed + (j2 * normalcam_angle) / 1000;
            camerayaw$ &= 0x7ff;
        }
        if(j2 < 0)
        {
            camerayaw$ -= normalcam_speed + (-j2 * normalcam_angle) / 1000;
            camerayaw$ &= 0x7ff;
        }
        int k2 = i2 - camerayaw$;
        if(k2 > 1024)
            k2 -= 2048;
        if(k2 < -1024)
            k2 += 2048;
        if(k2 < 0 && j2 > 0 || k2 > 0 && j2 < 0)
            camerayaw$ = i2;
    }

    public void method40(byte byte0)
    {
        int i = anInt949;
        int j = anInt950;
        int k = anInt951;
        int l = anInt952;
        int i1 = 0x5d5447;
        Raster.drawQuadrilateral(i, j, k, l, i1);
        if(byte0 == 9)
            byte0 = 0;
        else
            return;
        Raster.drawQuadrilateral( i + 1, j + 1, k - 2, 16, 0);
        Raster.drawQuadrilateralOutline(i + 1, j + 18, k - 2, l - 19, 0);
        b12_font.drawText(i1, "Choose Option", j + 14, 822, i + 3);
        int j1 = super.mouse_x;
        int k1 = super.mouse_y;
        if(clickarea == 0)
        {
            j1 -= 4;
            k1 -= 4;
        }
        if(clickarea == 1)
        {
            j1 -= 553;
            k1 -= 205;
        }
        if(clickarea == 2)
        {
            j1 -= 17;
            k1 -= 357;
        }
        for(int l1 = 0; l1 < anInt1133; l1++)
        {
            int i2 = j + 31 + (anInt1133 - 1 - l1) * 15;
            int j2 = 0xffffff;
            if(j1 > i && j1 < i + k && k1 > i2 - 13 && k1 < i2 + 3)
                j2 = 0xffff00;
            b12_font.drawText2(false, true, i + 3, j2, interfacestringstack[l1], i2);
        }

    }

    public void socialListLogic(byte byte0, long l)
    {
        try
        {
            if(l == 0L)
                return;
            if(amt_friendhashes >= 100 && anInt1046 != 1)
            {
                pushMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "", aBoolean991);
                return;
            }
            if(amt_friendhashes >= 200)
            {
                pushMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "", aBoolean991);
                return;
            }
            String s = TextUtils.formatUsername(-45804, TextUtils.longToString(l, (byte)-99));
            for(int i = 0; i < amt_friendhashes; i++)
                if(friend_hashes[i] == l)
                {
                    pushMessage(s + " is already on your friend list", 0, "", aBoolean991);
                    return;
                }

            if(byte0 != 68)
                packetnum = -1;
            for(int j = 0; j < amt_ignorehashes; j++)
                if(ignore_hashes[j] == l)
                {
                    pushMessage("Please remove " + s + " from your ignore list first", 0, "", aBoolean991);
                    return;
                }

            if(s.equals(localplayer.name))
            {
                return;
            } else
            {
                friendusernames[amt_friendhashes] = s;
                friend_hashes[amt_friendhashes] = l;
                anIntArray826[amt_friendhashes] = 0;
                amt_friendhashes++;
                aBoolean1153 = true;
                packetbuffer.putPacket(188);
                packetbuffer.putLong(l);
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("15283, " + byte0 + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int calculateTileHeight(int finex, int finey, int z)
    {
        int x = finex >> 7;
        int y = finey >> 7;
        if(x < 0 || y < 0 || x > 103 || y > 103)
            return 0;
        int height = z;
        if(height < 3 && (main_tilesettings[1][x][y] & 2) == 2)
            height++;
        int finetilex = finex & 0x7f;
        int finetiley = finey & 0x7f;
        int i2 = main_heightmap[height][x][y] * (128 - finetilex) + main_heightmap[height][x + 1][y] * finetilex >> 7;
        int j2 = main_heightmap[height][x][y + 1] * (128 - finetilex) + main_heightmap[height][x + 1][y + 1] * finetilex >> 7;
        return i2 * (128 - finetiley) + j2 * finetiley >> 7;
    }

    public static String amountToAmountStr(int junk, int j)
    {
        if(j < 0x186a0)
            return String.valueOf(j);
        if(j < 0x989680)
            return j / 1000 + "K";
        else
            return j / 0xf4240 + "M";
    }

    public void killToMainscreen(boolean flag)
    {
        try
        {
            if(gameserver_sockethandler != null)
                gameserver_sockethandler.method267();
        }
        catch(Exception _ex) { }
        gameserver_sockethandler = null;
        if(!flag)
            return;
        aBoolean1157 = false;
        titlescreen_tab = 0;
        username = "";
        password = "";
        clearModelCaches(false);
        pallet.reset();
        for(int i = 0; i < 4; i++)
            collisionmaps[i].initialize();

        System.gc();
        stopMidi(860);
        anInt956 = -1;
        anInt1227 = -1;
        anInt1259 = 0;
    }

    public void method45(int i)
    {
        if(i != 0)
            packetnum = -1;
        aBoolean1031 = true;
        for(int j = 0; j < 7; j++)
        {
            anIntArray1065[j] = -1;
            for(int k = 0; k < CharModel.anInt655; k++)
            {
                if(CharModel.charactermodels[k].aBoolean662 || CharModel.charactermodels[k].anInt657 != j + (aBoolean1047 ? 0 : 7))
                    continue;
                anIntArray1065[j] = k;
                break;
            }

        }

    }

    public void processNpcs(int i, Buffer buffer0, byte byte0)
    {
        while(buffer0.bitposition + 21 < i * 8) 
        {
            int k = buffer0.getBits(14, 0);
            if(k == 16383)
                break;
            if(npcs[k] == null)
                npcs[k] = new NPC();
            NPC class30_sub2_sub4_sub1_sub1 = npcs[k];
            updatenpcs[anInt836++] = k;
            class30_sub2_sub4_sub1_sub1.anInt1537 = loopcycle;
            int l = buffer0.getBits(5, 0);
            if(l > 15)
                l -= 32;
            int i1 = buffer0.getBits(5, 0);
            if(i1 > 15)
                i1 -= 32;
            int j1 = buffer0.getBits(1, 0);
            class30_sub2_sub4_sub1_sub1.definition = NPCDefinition.getNPCDefinition(buffer0.getBits(12, 0));
            int k1 = buffer0.getBits(1, 0);
            if(k1 == 1)
                playerupdate_stack[amtplayerupdatestack++] = k;
            class30_sub2_sub4_sub1_sub1.halftile_offsets = class30_sub2_sub4_sub1_sub1.definition.npc_halftileoffsets;
            class30_sub2_sub4_sub1_sub1.rotation = class30_sub2_sub4_sub1_sub1.definition.spawndirection;
            class30_sub2_sub4_sub1_sub1.walk_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_walkanim;
            class30_sub2_sub4_sub1_sub1.turn180_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_turn180anim;
            class30_sub2_sub4_sub1_sub1.turn90cw_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_turn90cw;
            class30_sub2_sub4_sub1_sub1.turn90ccw_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_turn90ccw;
            class30_sub2_sub4_sub1_sub1.stand_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_standanim;
            class30_sub2_sub4_sub1_sub1.updateMobPosition(((Mob) (localplayer)).palettex_stack[0] + i1, ((Mob) (localplayer)).palettey_stack[0] + l, j1 == 1, false);
        }
        buffer0.endBitAccess(true);
    }

    public void handleLoopCycle() {
        if(aBoolean1252 || aBoolean926 || aBoolean1176)
            return;
        loopcycle++;
        if(!aBoolean1157)
            loopCycleTitle(true);
        else
            loopCycleGame(anInt1218);
        loadFinalizedRequest(false);
    }

    public void processPlayers(int i, boolean flag)
    {
        if(((Mob) (localplayer)).fineposx >> 7 == anInt1261 && ((Mob) (localplayer)).fineposy >> 7 == anInt1262)
            anInt1261 = 0;
        int j = anInt891;
        if(i != 0)
        {
            for(int k = 1; k > 0; k++);
        }
        if(flag)
            j = 1;
        for(int l = 0; l < j; l++)
        {
            Player class30_sub2_sub4_sub1_sub2;
            int i1;
            if(flag)
            {
                class30_sub2_sub4_sub1_sub2 = localplayer;
                i1 = localindex << 14;
            } else
            {
                class30_sub2_sub4_sub1_sub2 = players[anIntArray892[l]];
                i1 = anIntArray892[l] << 14;
            }
            if(class30_sub2_sub4_sub1_sub2 == null || !class30_sub2_sub4_sub1_sub2.hasDefinition(aBoolean1224))
                continue;
            class30_sub2_sub4_sub1_sub2.aBoolean1699 = false;
            if((lowmemory && anInt891 > 50 || anInt891 > 200) && !flag && ((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1517 == ((Mob) (class30_sub2_sub4_sub1_sub2)).stand_anim)
                class30_sub2_sub4_sub1_sub2.aBoolean1699 = true;
            int j1 = ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx >> 7;
            int k1 = ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy >> 7;
            if(j1 < 0 || j1 >= 104 || k1 < 0 || k1 >= 104)
                continue;
            if(class30_sub2_sub4_sub1_sub2.aActor_Sub6_1714 != null && loopcycle >= class30_sub2_sub4_sub1_sub2.anInt1707 && loopcycle < class30_sub2_sub4_sub1_sub2.anInt1708)
            {
                class30_sub2_sub4_sub1_sub2.aBoolean1699 = false;
                class30_sub2_sub4_sub1_sub2.tileheight$ = calculateTileHeight( ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy, cheight);
                pallet.method286(60, cheight, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy, class30_sub2_sub4_sub1_sub2, ((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1552, class30_sub2_sub4_sub1_sub2.anInt1722, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx, class30_sub2_sub4_sub1_sub2.tileheight$, class30_sub2_sub4_sub1_sub2.anInt1719, class30_sub2_sub4_sub1_sub2.anInt1721, i1, class30_sub2_sub4_sub1_sub2.anInt1720, (byte)35);
                continue;
            }
            if((((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx & 0x7f) == 64 && (((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy & 0x7f) == 64)
            {
                if(anIntArrayArray929[j1][k1] == anInt1265)
                    continue;
                anIntArrayArray929[j1][k1] = anInt1265;
            }
            class30_sub2_sub4_sub1_sub2.tileheight$ = calculateTileHeight( ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy, cheight);
            pallet.method285(cheight, ((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1552, (byte)6, class30_sub2_sub4_sub1_sub2.tileheight$, i1, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy, 60, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx, class30_sub2_sub4_sub1_sub2, ((Mob) (class30_sub2_sub4_sub1_sub2)).aBoolean1541);
        }

    }

    public boolean method48(int i, Widget class9)
    {
        if(i <= 0)
            packetnum = -1;
        int j = class9.actioncode;
        if(anInt900 == 2)
        {
            if(j == 201)
            {
                aBoolean1223 = true;
                anInt1225 = 0;
                aBoolean1256 = true;
                aString1212 = "";
                anInt1064 = 1;
                aString1121 = "Enter name of friend to add to list";
            }
            if(j == 202)
            {
                aBoolean1223 = true;
                anInt1225 = 0;
                aBoolean1256 = true;
                aString1212 = "";
                anInt1064 = 2;
                aString1121 = "Enter name of friend to delete from list";
            }
        }
        if(j == 205)
        {
            anInt1011 = 250;
            return true;
        }
        if(j == 501)
        {
            aBoolean1223 = true;
            anInt1225 = 0;
            aBoolean1256 = true;
            aString1212 = "";
            anInt1064 = 4;
            aString1121 = "Enter name of player to add to list";
        }
        if(j == 502)
        {
            aBoolean1223 = true;
            anInt1225 = 0;
            aBoolean1256 = true;
            aString1212 = "";
            anInt1064 = 5;
            aString1121 = "Enter name of player to delete from list";
        }
        if(j >= 300 && j <= 313)
        {
            int k = (j - 300) / 2;
            int j1 = j & 1;
            int i2 = anIntArray1065[k];
            if(i2 != -1)
            {
                do
                {
                    if(j1 == 0 && --i2 < 0)
                        i2 = CharModel.anInt655 - 1;
                    if(j1 == 1 && ++i2 >= CharModel.anInt655)
                        i2 = 0;
                } while(CharModel.charactermodels[i2].aBoolean662 || CharModel.charactermodels[i2].anInt657 != k + (aBoolean1047 ? 0 : 7));
                anIntArray1065[k] = i2;
                aBoolean1031 = true;
            }
        }
        if(j >= 314 && j <= 323)
        {
            int l = (j - 314) / 2;
            int k1 = j & 1;
            int j2 = anIntArray990[l];
            if(k1 == 0 && --j2 < 0)
                j2 = anIntArrayArray1003[l].length - 1;
            if(k1 == 1 && ++j2 >= anIntArrayArray1003[l].length)
                j2 = 0;
            anIntArray990[l] = j2;
            aBoolean1031 = true;
        }
        if(j == 324 && !aBoolean1047)
        {
            aBoolean1047 = true;
            method45(0);
        }
        if(j == 325 && aBoolean1047)
        {
            aBoolean1047 = false;
            method45(0);
        }
        if(j == 326)
        {
            packetbuffer.putPacket(101);
            packetbuffer.put(aBoolean1047 ? 0 : 1);
            for(int i1 = 0; i1 < 7; i1++)
                packetbuffer.put(anIntArray1065[i1]);

            for(int l1 = 0; l1 < 5; l1++)
                packetbuffer.put(anIntArray990[l1]);

            return true;
        }
        if(j == 613)
            aBoolean1158 = !aBoolean1158;
        if(j >= 601 && j <= 612)
        {
            method147(537);
            if(aString881.length() > 0)
            {
                packetbuffer.putPacket(218);
                packetbuffer.putLong(TextUtils.stringToLong(aString881));
                packetbuffer.put(j - 601);
                packetbuffer.put(aBoolean1158 ? 1 : 0);
            }
        }
        return false;
    }

    public void doPlayerUpdateMasks(int i, byte byte0, Buffer buffer0)
    {
        if(byte0 == 2)
            byte0 = 0;
        else
            return;
        for(int j = 0; j < amtplayerupdatestack; j++)
        {
            int k = playerupdate_stack[j];
            Player class30_sub2_sub4_sub1_sub2 = players[k];
            int l = buffer0.getUByte();
            if((l & 0x40) != 0)
                l += buffer0.getUByte() << 8;
            parsePlayerUpdateMasks(l, k, buffer0, aByte923, class30_sub2_sub4_sub1_sub2);
        }

    }

    public void method50(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = pallet.method300(j1, l, i);
        if(j >= 0)
            return;
        if(k1 != 0)
        {
            int l1 = pallet.method304(j1, l, i, k1);
            int k2 = l1 >> 6 & 3;
            int i3 = l1 & 0x1f;
            int k3 = k;
            if(k1 > 0)
                k3 = i1;
            int ai[] = aClass30_Sub2_Sub1_Sub1_1263.pixels;
            int k4 = 24624 + l * 4 + (103 - i) * 512 * 4;
            int i5 = k1 >> 14 & 0x7fff;
            ObjectDefinition class46_2 = ObjectDefinition.getObjectDefinition(i5);
            if(class46_2.anInt758 != -1)
            {
                IndexedColorSprite class30_sub2_sub1_sub2_2 = mapscene[class46_2.anInt758];
                if(class30_sub2_sub1_sub2_2 != null)
                {
                    int i6 = (class46_2.anInt744 * 4 - class30_sub2_sub1_sub2_2.indexwidth_) / 2;
                    int j6 = (class46_2.objsize * 4 - class30_sub2_sub1_sub2_2.indexheight_) / 2;
                    class30_sub2_sub1_sub2_2.renderImage(48 + l * 4 + i6, 16083, 48 + (104 - i - class46_2.objsize) * 4 + j6);
                }
            } else
            {
                if(i3 == 0 || i3 == 2)
                    if(k2 == 0)
                    {
                        ai[k4] = k3;
                        ai[k4 + 512] = k3;
                        ai[k4 + 1024] = k3;
                        ai[k4 + 1536] = k3;
                    } else
                    if(k2 == 1)
                    {
                        ai[k4] = k3;
                        ai[k4 + 1] = k3;
                        ai[k4 + 2] = k3;
                        ai[k4 + 3] = k3;
                    } else
                    if(k2 == 2)
                    {
                        ai[k4 + 3] = k3;
                        ai[k4 + 3 + 512] = k3;
                        ai[k4 + 3 + 1024] = k3;
                        ai[k4 + 3 + 1536] = k3;
                    } else
                    if(k2 == 3)
                    {
                        ai[k4 + 1536] = k3;
                        ai[k4 + 1536 + 1] = k3;
                        ai[k4 + 1536 + 2] = k3;
                        ai[k4 + 1536 + 3] = k3;
                    }
                if(i3 == 3)
                    if(k2 == 0)
                        ai[k4] = k3;
                    else
                    if(k2 == 1)
                        ai[k4 + 3] = k3;
                    else
                    if(k2 == 2)
                        ai[k4 + 3 + 1536] = k3;
                    else
                    if(k2 == 3)
                        ai[k4 + 1536] = k3;
                if(i3 == 2)
                    if(k2 == 3)
                    {
                        ai[k4] = k3;
                        ai[k4 + 512] = k3;
                        ai[k4 + 1024] = k3;
                        ai[k4 + 1536] = k3;
                    } else
                    if(k2 == 0)
                    {
                        ai[k4] = k3;
                        ai[k4 + 1] = k3;
                        ai[k4 + 2] = k3;
                        ai[k4 + 3] = k3;
                    } else
                    if(k2 == 1)
                    {
                        ai[k4 + 3] = k3;
                        ai[k4 + 3 + 512] = k3;
                        ai[k4 + 3 + 1024] = k3;
                        ai[k4 + 3 + 1536] = k3;
                    } else
                    if(k2 == 2)
                    {
                        ai[k4 + 1536] = k3;
                        ai[k4 + 1536 + 1] = k3;
                        ai[k4 + 1536 + 2] = k3;
                        ai[k4 + 1536 + 3] = k3;
                    }
            }
        }
        k1 = pallet.method302(j1, l, i);
        if(k1 != 0)
        {
            int i2 = pallet.method304(j1, l, i, k1);
            int l2 = i2 >> 6 & 3;
            int j3 = i2 & 0x1f;
            int l3 = k1 >> 14 & 0x7fff;
            ObjectDefinition class46_1 = ObjectDefinition.getObjectDefinition(l3);
            if(class46_1.anInt758 != -1)
            {
                IndexedColorSprite class30_sub2_sub1_sub2_1 = mapscene[class46_1.anInt758];
                if(class30_sub2_sub1_sub2_1 != null)
                {
                    int j5 = (class46_1.anInt744 * 4 - class30_sub2_sub1_sub2_1.indexwidth_) / 2;
                    int k5 = (class46_1.objsize * 4 - class30_sub2_sub1_sub2_1.indexheight_) / 2;
                    class30_sub2_sub1_sub2_1.renderImage(48 + l * 4 + j5, 16083, 48 + (104 - i - class46_1.objsize) * 4 + k5);
                }
            } else
            if(j3 == 9)
            {
                int l4 = 0xeeeeee;
                if(k1 > 0)
                    l4 = 0xee0000;
                int ai1[] = aClass30_Sub2_Sub1_Sub1_1263.pixels;
                int l5 = 24624 + l * 4 + (103 - i) * 512 * 4;
                if(l2 == 0 || l2 == 2)
                {
                    ai1[l5 + 1536] = l4;
                    ai1[l5 + 1024 + 1] = l4;
                    ai1[l5 + 512 + 2] = l4;
                    ai1[l5 + 3] = l4;
                } else
                {
                    ai1[l5] = l4;
                    ai1[l5 + 512 + 1] = l4;
                    ai1[l5 + 1024 + 2] = l4;
                    ai1[l5 + 1536 + 3] = l4;
                }
            }
        }
        k1 = pallet.method303(j1, l, i);
        if(k1 != 0)
        {
            int j2 = k1 >> 14 & 0x7fff;
            ObjectDefinition class46 = ObjectDefinition.getObjectDefinition(j2);
            if(class46.anInt758 != -1)
            {
                IndexedColorSprite class30_sub2_sub1_sub2 = mapscene[class46.anInt758];
                if(class30_sub2_sub1_sub2 != null)
                {
                    int i4 = (class46.anInt744 * 4 - class30_sub2_sub1_sub2.indexwidth_) / 2;
                    int j4 = (class46.objsize * 4 - class30_sub2_sub1_sub2.indexheight_) / 2;
                    class30_sub2_sub1_sub2.renderImage(48 + l * 4 + i4, 16083, 48 + (104 - i - class46.objsize) * 4 + j4);
                }
            }
        }
    }

    public void method51(int i)
    {
        aClass30_Sub2_Sub1_Sub2_966 = new IndexedColorSprite(titlescreen_archive, "titlebox", 0);
        if(i <= 0)
            aBoolean1231 = !aBoolean1231;
        aClass30_Sub2_Sub1_Sub2_967 = new IndexedColorSprite(titlescreen_archive, "titlebutton", 0);
        titlescreen_sprites = new IndexedColorSprite[12];
        int j = 0;
        try
        {
            j = Integer.parseInt(getParameter("fl_icon"));
        }
        catch(Exception _ex) { }
        if(j == 0)
        {
            for(int k = 0; k < 12; k++)
                titlescreen_sprites[k] = new IndexedColorSprite(titlescreen_archive, "runes", k);

        } else
        {
            for(int l = 0; l < 12; l++)
                titlescreen_sprites[l] = new IndexedColorSprite(titlescreen_archive, "runes", 12 + (l & 3));

        }
        aClass30_Sub2_Sub1_Sub1_1201 = new DirectColorSprite(128, 265);
        aClass30_Sub2_Sub1_Sub1_1202 = new DirectColorSprite(128, 265);
        for(int i1 = 0; i1 < 33920; i1++)
            aClass30_Sub2_Sub1_Sub1_1201.pixels[i1] = titletopleft_imagefetcher.pixels[i1];

        for(int j1 = 0; j1 < 33920; j1++)
            aClass30_Sub2_Sub1_Sub1_1202.pixels[j1] = titletopright_imagefetcher.pixels[j1];

        anIntArray851 = new int[256];
        for(int k1 = 0; k1 < 64; k1++)
            anIntArray851[k1] = k1 * 0x40000;

        for(int l1 = 0; l1 < 64; l1++)
            anIntArray851[l1 + 64] = 0xff0000 + 1024 * l1;

        for(int i2 = 0; i2 < 64; i2++)
            anIntArray851[i2 + 128] = 0xffff00 + 4 * i2;

        for(int j2 = 0; j2 < 64; j2++)
            anIntArray851[j2 + 192] = 0xffffff;

        anIntArray852 = new int[256];
        for(int k2 = 0; k2 < 64; k2++)
            anIntArray852[k2] = k2 * 1024;

        for(int l2 = 0; l2 < 64; l2++)
            anIntArray852[l2 + 64] = 65280 + 4 * l2;

        for(int i3 = 0; i3 < 64; i3++)
            anIntArray852[i3 + 128] = 65535 + 0x40000 * i3;

        for(int j3 = 0; j3 < 64; j3++)
            anIntArray852[j3 + 192] = 0xffffff;

        anIntArray853 = new int[256];
        for(int k3 = 0; k3 < 64; k3++)
            anIntArray853[k3] = k3 * 4;

        for(int l3 = 0; l3 < 64; l3++)
            anIntArray853[l3 + 64] = 255 + 0x40000 * l3;

        for(int i4 = 0; i4 < 64; i4++)
            anIntArray853[i4 + 128] = 0xff00ff + 1024 * i4;

        for(int j4 = 0; j4 < 64; j4++)
            anIntArray853[j4 + 192] = 0xffffff;

        anIntArray850 = new int[256];
        anIntArray1190 = new int[32768];
        anIntArray1191 = new int[32768];
        method106(null, -135);
        anIntArray828 = new int[32768];
        anIntArray829 = new int[32768];
        drawLoadingBar(10, (byte)4, "Connecting to fileserver");
        if(!runflamecycle)
        {
            runclient = true;
            runflamecycle = true;
            spawnThread(this, 2);
        }
    }

    public static void setHighMem(boolean junk) {
        Palette.lowmemory = false;
        TriangleRasterizer.lowmemory = false;
        lowmemory = false;
        MapLoader.lowmemory = false;
        ObjectDefinition.lowmemory = false;
    }

    public static void main(String args[]) {
        try {
            System.out.println("RS2 user Main - release #" + 317);
            if(args.length != 5) {
                System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                return;
            }
            nodeid = Integer.parseInt(args[0]);
            portoff = Integer.parseInt(args[1]);
            if(args[2].equals("lowmem"))
                setLowMem((byte)77);
            else if(args[2].equals("highmem")) {
                setHighMem(false);
            } else {
                System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                return;
            }
            if(args[3].equals("free"))
                members = false;
            else if(args[3].equals("members")) {
                members = true;
            } else {
                System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                return;
            }
            signlink.storeid = Integer.parseInt(args[4]);
            signlink.startpriv(InetAddress.getLocalHost());
            Main client = new Main();
            client.frameInitialize(503, false, 765);
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public void landscapeLoadingStep1(int i)
    {
        if(i != -48877)
            return;
        if(lowmemory && landscape_stage == 2 && MapLoader.ml_hieght != cheight)
        {
            toplefttext_imagefetcher.initialize(0);
            p12_font.drawCenteredYText(0, "Loading - please wait.", 23693, 151, 257);
            p12_font.drawCenteredYText(0xffffff, "Loading - please wait.", 23693, 150, 256);
            toplefttext_imagefetcher.updateGraphics(4, 23680, super.graphics, 4);
            landscape_stage = 1;
            aLong824 = System.currentTimeMillis();
        }
        if(landscape_stage == 1)
        {
            int j = method54();
            if(j != 0 && System.currentTimeMillis() - aLong824 > 0x57e40L)
            {
                signlink.reporterror(username + " glcfb " + ssk + "," + j + "," + lowmemory + "," + cacheindexes[0] + "," + ondemandhandler.amount() + "," + cheight + "," + chunkx_ + "," + chunky_);
                aLong824 = System.currentTimeMillis();
            }
        }
        if(landscape_stage == 2 && cheight != anInt985)
        {
            anInt985 = cheight;
            method24(true, cheight);
        }
    }

    public int method54()
    {
        for(int i = 0; i < tilebytes.length; i++)
        {
            if(tilebytes[i] == null && anIntArray1235[i] != -1)
                return -1;
            if(regionbytes[i] == null && anIntArray1236[i] != -1)
                return -2;
        }

        boolean flag = true;
        for(int j = 0; j < tilebytes.length; j++)
        {
            byte abyte0[] = regionbytes[j];
            if(abyte0 != null)
            {
                int k = (regionhashes[j] >> 8) * 64 - palettex;
                int l = (regionhashes[j] & 0xff) * 64 - palettey;
                if(aBoolean1159)
                {
                    k = 10;
                    l = 10;
                }
                flag &= MapLoader.method189(k, abyte0, l, 6);
            }
        }

        if(!flag)
            return -3;
        if(aBoolean1080)
        {
            return -4;
        } else
        {
            landscape_stage = 2;
            MapLoader.ml_hieght = cheight;
            processLandscapeLoading_(true);
            packetbuffer.putPacket(121);
            return 0;
        }
    }

    public void processProjectiles(int i)
    {
        while(i >= 0) 
            loadClient();
        for(Projectile class30_sub2_sub4_sub4 = (Projectile)aClass19_1013.getFirst(); class30_sub2_sub4_sub4 != null; class30_sub2_sub4_sub4 = (Projectile)aClass19_1013.getNextForwards(false))
            if(class30_sub2_sub4_sub4.anInt1597 != cheight || loopcycle > class30_sub2_sub4_sub4.anInt1572)
                class30_sub2_sub4_sub4.removeDeque();
            else
            if(loopcycle >= class30_sub2_sub4_sub4.anInt1571)
            {
                if(class30_sub2_sub4_sub4.anInt1590 > 0)
                {
                    NPC class30_sub2_sub4_sub1_sub1 = npcs[class30_sub2_sub4_sub4.anInt1590 - 1];
                    if(class30_sub2_sub4_sub1_sub1 != null && ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx >= 0 && ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx < 13312 && ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy >= 0 && ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy < 13312)
                        class30_sub2_sub4_sub4.method455(loopcycle, ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy, calculateTileHeight(((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx, ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy, class30_sub2_sub4_sub4.anInt1597) - class30_sub2_sub4_sub4.anInt1583, ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx, (byte)-83);
                }
                if(class30_sub2_sub4_sub4.anInt1590 < 0)
                {
                    int j = -class30_sub2_sub4_sub4.anInt1590 - 1;
                    Player class30_sub2_sub4_sub1_sub2;
                    if(j == anInt884)
                        class30_sub2_sub4_sub1_sub2 = localplayer;
                    else
                        class30_sub2_sub4_sub1_sub2 = players[j];
                    if(class30_sub2_sub4_sub1_sub2 != null && ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx >= 0 && ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx < 13312 && ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy >= 0 && ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy < 13312)
                        class30_sub2_sub4_sub4.method455(loopcycle, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy, calculateTileHeight(((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy, class30_sub2_sub4_sub4.anInt1597) - class30_sub2_sub4_sub4.anInt1583, ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx, (byte)-83);
                }
                class30_sub2_sub4_sub4.method456(anInt945, anInt1020);
                pallet.method285(cheight, class30_sub2_sub4_sub4.anInt1595, (byte)6, (int)class30_sub2_sub4_sub4.aDouble1587, -1, (int)class30_sub2_sub4_sub4.aDouble1586, 60, (int)class30_sub2_sub4_sub4.aDouble1585, class30_sub2_sub4_sub4, false);
            }

    }

    public AppletContext getAppletContext()
    {
        if(signlink.mainapp != null)
            return signlink.mainapp.getAppletContext();
        else
            return super.getAppletContext();
    }

    public void drawTitleBackround(int i)
    {
        byte abyte0[] = titlescreen_archive.getEntry("title.dat", null);
        DirectColorSprite sprite = new DirectColorSprite(this, abyte0);
        titletopleft_imagefetcher.initialize(0);
        sprite.draw(0, 0);
        titletopright_imagefetcher.initialize(0);
        sprite.draw(-637, 0);
        logo_imagefetcher.initialize(0);
        sprite.draw(-128, 0);
        bottomleftmid_imagefetcher.initialize(0);
        sprite.draw(-202, -371);
        aClass15_1109.initialize(0);
        sprite.draw(-202, -171);
        aClass15_1112.initialize(0);
        sprite.draw(0, -265);
        aClass15_1113.initialize(0);
        sprite.draw(-562, -265);
        aClass15_1114.initialize(0);
        sprite.draw(-128, -171);
        aClass15_1115.initialize(0);
        sprite.draw(-562, -171);
		/* Do other half */
        int ai[] = new int[sprite.indexwidth];
        for(int j = 0; j < sprite.indexheight; j++)
        {
            for(int k = 0; k < sprite.indexwidth; k++)
                ai[k] = sprite.pixels[(sprite.indexwidth - k - 1) + sprite.indexwidth * j];

            for(int l = 0; l < sprite.indexwidth; l++)
                sprite.pixels[l + sprite.indexwidth * j] = ai[l];
        }
        titletopleft_imagefetcher.initialize(0);
        sprite.draw(382, 0);
        titletopright_imagefetcher.initialize(0);
        sprite.draw(-255, 0);
        logo_imagefetcher.initialize(0);
        sprite.draw(254, 0);
        bottomleftmid_imagefetcher.initialize(0);
        sprite.draw(180, -371);
        aClass15_1109.initialize(0);
        sprite.draw(180, -171);
        aClass15_1112.initialize(0);
        sprite.draw(382, -265);
        aClass15_1113.initialize(0);
        sprite.draw(-180, -265);
        aClass15_1114.initialize(0);
        sprite.draw(254, -171);
        aClass15_1115.initialize(0);
        sprite.draw(-180, -171);
        sprite = new DirectColorSprite(titlescreen_archive, "logo", 0);
        logo_imagefetcher.initialize(0);
        sprite.drawOverlay(382 - sprite.indexwidth / 2 - 128, 16083, 18);
        sprite = null;
        Object obj = null;
        Object obj1 = null;
        System.gc();
    }

    public void loadFinalizedRequest(boolean flag)
    {
        if(flag)
            anInt883 = -72;
        do
        {
            OndemandRequest class30_sub2_sub3;
            do
            {
                class30_sub2_sub3 = ondemandhandler.getFinalizedRequest();
                if(class30_sub2_sub3 == null)
                    return;
                if(class30_sub2_sub3.index == 0)
                {
                    Model.unpackRawModel(class30_sub2_sub3.request_data, -4036, class30_sub2_sub3.archiveid);
                    if((ondemandhandler.getModelIndex(class30_sub2_sub3.archiveid, -203) & 0x62) != 0)
                    {
                        aBoolean1153 = true;
                        if(anInt1276 != -1)
                            aBoolean1223 = true;
                    }
                }
                if(class30_sub2_sub3.index == 1 && class30_sub2_sub3.request_data != null)
                    AnimFrame.unpackAnimFrames(class30_sub2_sub3.request_data);
                if(class30_sub2_sub3.index == 2 && class30_sub2_sub3.archiveid == anInt1227 && class30_sub2_sub3.request_data != null)
                    initMidi(aBoolean1228, 0, class30_sub2_sub3.request_data);
                if(class30_sub2_sub3.index == 3 && landscape_stage == 1)
                {
                    for(int i = 0; i < tilebytes.length; i++)
                    {
                        if(anIntArray1235[i] == class30_sub2_sub3.archiveid)
                        {
                            tilebytes[i] = class30_sub2_sub3.request_data;
                            if(class30_sub2_sub3.request_data == null)
                                anIntArray1235[i] = -1;
                            break;
                        }
                        if(anIntArray1236[i] != class30_sub2_sub3.archiveid)
                            continue;
                        regionbytes[i] = class30_sub2_sub3.request_data;
                        if(class30_sub2_sub3.request_data == null)
                            anIntArray1236[i] = -1;
                        break;
                    }

                }
            } while(class30_sub2_sub3.index != 93 || !ondemandhandler.method564(class30_sub2_sub3.archiveid, -520));
            MapLoader.loadExtraObjects((byte)-107, new Buffer(class30_sub2_sub3.request_data), ondemandhandler);
        } while(true);
    }

    public void method58(int i)
    {
        char c = '\u0100';
        for(int j = 10; j < 117; j++)
        {
            int k = (int)(Math.random() * 100D);
            if(k < 50)
                anIntArray828[j + (c - 2 << 7)] = 255; //White
        }

        if(i != 25106)
            loadClient();
        for(int l = 0; l < 100; l++)
        {
            int i1 = (int)(Math.random() * 124D) + 2;
            int k1 = (int)(Math.random() * 128D) + 128;
            int k2 = i1 + (k1 << 7);
            anIntArray828[k2] = 192;
        }

        for(int j1 = 1; j1 < c - 1; j1++)
        {
            for(int l1 = 1; l1 < 127; l1++)
            {
                int l2 = l1 + (j1 << 7);
                anIntArray829[l2] = (anIntArray828[l2 - 1] + anIntArray828[l2 + 1] + anIntArray828[l2 - 128] + anIntArray828[l2 + 128]) / 4;
            }

        }

        anInt1275 += 128;
        if(anInt1275 > anIntArray1190.length)
        {
            anInt1275 -= anIntArray1190.length;
            int i2 = (int)(Math.random() * 12D);
            method106(titlescreen_sprites[i2], -135);
        }
        for(int j2 = 1; j2 < c - 1; j2++)
        {
            for(int i3 = 1; i3 < 127; i3++)
            {
                int k3 = i3 + (j2 << 7);
                int i4 = anIntArray829[k3 + 128] - anIntArray1190[k3 + anInt1275 & anIntArray1190.length - 1] / 5;
                if(i4 < 0)
                    i4 = 0;
                anIntArray828[k3] = i4;
            }

        }

        for(int j3 = 0; j3 < c - 1; j3++)
            anIntArray969[j3] = anIntArray969[j3 + 1];
		/* Side ways */
        anIntArray969[c - 1] = (int)(Math.sin((double)loopcycle / 14D) * 16D + Math.sin((double)loopcycle / 15D) * 14D + Math.sin((double)loopcycle / 16D) * 12D);
        if(anInt1040 > 0)
            anInt1040 -= 4;
        if(anInt1041 > 0)
            anInt1041 -= 4;
        if(anInt1040 == 0 && anInt1041 == 0)
        {
            int l3 = (int)(Math.random() * 2000D);
            if(l3 == 0)
                anInt1040 = 1024;
            if(l3 == 1)
                anInt1041 = 1024;
        }
    }

    public boolean method59(byte abyte0[], byte byte0, int i)
    {
        if(byte0 != 116)
            throw new NullPointerException();
        if(abyte0 == null)
            return true;
        else
            return signlink.wavesave(abyte0, i);
    }

    public void method60(int i, byte byte0)
    {
        Widget class9 = Widget.widgets[i];
        for(int j = 0; j < class9.childrenwidgets.length; j++)
        {
            if(class9.childrenwidgets[j] == -1)
                break;
            Widget class9_1 = Widget.widgets[class9.childrenwidgets[j]];
            if(class9_1.widgettype == 1)
                method60(class9_1.widgetid, (byte)6);
            class9_1.anInt246 = 0;
            class9_1.anInt208 = 0;
        }

        if(byte0 == 6)
            byte0 = 0;
    }

    public void drawMarkerOnLocation(int i)
    {
        if(markertype != 2)
            return;
        calculateSpriteXY((markerloc_x - palettex << 7) + markeroffset_x, markerheight * 2, anInt875, (markerloc_y - palettey << 7) + markeroffset_y);
        if(i >= 0)
            aBoolean1224 = !aBoolean1224;
        if(spriteX > -1 && loopcycle % 20 < 10)
            headicons[2].drawOverlay(spriteX - 12, 16083, spriteY - 28);
    }

    public void loopCycleGame(int i)
    {
		/* Unknown timer */
        if(anInt1104 > 1)
            anInt1104--;
		/* Unknown timer */
        if(anInt1011 > 0)
            anInt1011--;
		/* Parse the incoming packets */
        for(int j = 0; j < 5; j++)
            if(!parsePackets(true))
                break;
        if(!aBoolean1157)
            return;
		/* Write watchdog packet */
        synchronized(watchdog.sync)
        {
            if(flagged) {
                if(super.anInt26 != 0 || watchdog.position >= 40) {
                    packetbuffer.putPacket(45);
                    packetbuffer.put(0);
                    int j2 = packetbuffer.position;
                    int j3 = 0;
                    for(int j4 = 0; j4 < watchdog.position; j4++) {
                        if(j2 - packetbuffer.position >= 240)
                            break;
                        j3++;
                        int l4 = watchdog.y_queue[j4];
                        if(l4 < 0)
                            l4 = 0;
                        else
                        if(l4 > 502)
                            l4 = 502;
                        int k5 = watchdog.x_queue[j4];
                        if(k5 < 0)
                            k5 = 0;
                        else
                        if(k5 > 764)
                            k5 = 764;
                        int i6 = l4 * 765 + k5;
                        if(watchdog.y_queue[j4] == -1 && watchdog.x_queue[j4] == -1)
                        {
                            k5 = -1;
                            l4 = -1;
                            i6 = 0x7ffff;
                        }
                        if(k5 == anInt1237 && l4 == anInt1238)
                        {
                            if(anInt1022 < 2047)
                                anInt1022++;
                        } else
                        {
                            int j6 = k5 - anInt1237;
                            anInt1237 = k5;
                            int k6 = l4 - anInt1238;
                            anInt1238 = l4;
                            if(anInt1022 < 8 && j6 >= -32 && j6 <= 31 && k6 >= -32 && k6 <= 31)
                            {
                                j6 += 32;
                                k6 += 32;
                                packetbuffer.putShort((anInt1022 << 12) + (j6 << 6) + k6);
                                anInt1022 = 0;
                            } else
                            if(anInt1022 < 8)
                            {
                                packetbuffer.putTri(0x800000 + (anInt1022 << 19) + i6);
                                anInt1022 = 0;
                            } else
                            {
                                packetbuffer.putInt(0xc0000000 + (anInt1022 << 19) + i6);
                                anInt1022 = 0;
                            }
                        }
                    }

                    packetbuffer.finishByteVar(packetbuffer.position - j2, (byte)0);
                    if(j3 >= watchdog.position)
                    {
                        watchdog.position = 0;
                    } else
                    {
                        watchdog.position -= j3;
                        for(int i5 = 0; i5 < watchdog.position; i5++)
                        {
                            watchdog.x_queue[i5] = watchdog.x_queue[i5 + j3];
                            watchdog.y_queue[i5] = watchdog.y_queue[i5 + j3];
                        }

                    }
                }
            } else
            {
                watchdog.position = 0;
            }
        }
		/* Write click packet */
        if(super.anInt26 != 0)
        {
            long l = (super.curpressed_t - lastpressed_t) / 50L;
            if(l > 4095L)
                l = 4095L;
            lastpressed_t = super.curpressed_t;
            int k2 = super.curpressed_y;
            if(k2 < 0)
                k2 = 0;
            else
            if(k2 > 502)
                k2 = 502;
            int k3 = super.curpressed_x;
            if(k3 < 0)
                k3 = 0;
            else
            if(k3 > 764)
                k3 = 764;
            int k4 = k2 * 765 + k3;
            int j5 = 0;
            if(super.anInt26 == 2)
                j5 = 1;
            int l5 = (int)l;
            packetbuffer.putPacket(241);
            packetbuffer.putInt((l5 << 20) + (j5 << 19) + k4);
        }
        if(camerapacket_delay > 0)
            camerapacket_delay--;
		/* Up, down, left, right */
        if(super.active_keycodes[1] == 1 || super.active_keycodes[2] == 1 || super.active_keycodes[3] == 1 || super.active_keycodes[4] == 1)
            camerapacket_write = true;
		/* Camera change */
        if(camerapacket_write && camerapacket_delay <= 0)
        {
            camerapacket_delay = 20;
            camerapacket_write = false;
            packetbuffer.putPacket(86);
            packetbuffer.putShort(camerapitch);
            packetbuffer.putShort128(-431, camerayaw);
        }
		/* Focus change */
        if(super.aBoolean17 && !aBoolean954)
        {
            aBoolean954 = true;
            packetbuffer.putPacket(3);
            packetbuffer.put(1);
        }
		/* Focus change */
        if(!super.aBoolean17 && aBoolean954)
        {
            aBoolean954 = false;
            packetbuffer.putPacket(3);
            packetbuffer.put(0);
        }
        landscapeLoadingStep1(-48877);
        updateSpawnedObjects_((byte)8);
        updateSounds_(false);
        anInt1009++;
        if(anInt1009 > 750)
            connectionLost(-670);
        updatePlayersOrientations((byte)-74);
        updateNPCsOrentation(-8066);
        resetMobsChatText((byte)-92);
        anInt945++;
        if(anInt917 != 0)
        {
            anInt916 += 20;
            if(anInt916 >= 400)
                anInt917 = 0;
        }
        if(anInt1246 != 0)
        {
            anInt1243++;
            if(anInt1243 >= 15)
            {
                if(anInt1246 == 2)
                    aBoolean1153 = true;
                if(anInt1246 == 3)
                    aBoolean1223 = true;
                anInt1246 = 0;
            }
        }
        if(anInt1086 != 0)
        {
            anInt989++;
            if(super.mouse_x > anInt1087 + 5 || super.mouse_x < anInt1087 - 5 || super.mouse_y > anInt1088 + 5 || super.mouse_y < anInt1088 - 5)
                aBoolean1242 = true;
            if(super.anInt19 == 0)
            {
                if(anInt1086 == 2)
                    aBoolean1153 = true;
                if(anInt1086 == 3)
                    aBoolean1223 = true;
                anInt1086 = 0;
                if(aBoolean1242 && anInt989 >= 5)
                {
                    anInt1067 = -1;
                    method82(0);
					/* Write moved item packet */
                    if(anInt1067 == moveitem_frameid && moveitem_endslot != moveitem_startslot)
                    {
                        Widget class9 = Widget.widgets[moveitem_frameid];
                        int j1 = 0;
                        if(anInt913 == 1 && class9.actioncode == 206)
                            j1 = 1;
                        if(class9.itemarray[moveitem_endslot] <= 0)
                            j1 = 0;
                        if(class9.aBoolean235)
                        {
                            int l2 = moveitem_startslot;
                            int l3 = moveitem_endslot;
                            class9.itemarray[l3] = class9.itemarray[l2];
                            class9.itemamounts[l3] = class9.itemamounts[l2];
                            class9.itemarray[l2] = -1;
                            class9.itemamounts[l2] = 0;
                        } else
                        if(j1 == 1)
                        {
                            int i3 = moveitem_startslot;
                            for(int i4 = moveitem_endslot; i3 != i4;)
                                if(i3 > i4)
                                {
                                    class9.initializeWidgets(i3, (byte)9, i3 - 1);
                                    i3--;
                                } else
                                if(i3 < i4)
                                {
                                    class9.initializeWidgets(i3, (byte)9, i3 + 1);
                                    i3++;
                                }

                        } else
                        {
                            class9.initializeWidgets(moveitem_startslot, (byte)9, moveitem_endslot);
                        }
                        packetbuffer.putPacket(214);
                        packetbuffer.putShortLE128(0, moveitem_frameid);
                        packetbuffer.putSpecialA(j1, 0);
                        packetbuffer.putShortLE128(0, moveitem_startslot);
                        packetbuffer.putShortLE_(true, moveitem_endslot);
                    }
                } else
                if((anInt1253 == 1 || method17(9, anInt1133 - 1)) && anInt1133 > 2)
                    method116(true);
                else
                if(anInt1133 > 0)
                    handleClick(anInt1133 - 1, false);
                anInt1243 = 10;
                super.anInt26 = 0;
            }
        }
        if(Palette.anInt470 != -1)
        {
            int k = Palette.anInt470;
            int k1 = Palette.anInt471;
            boolean flag = sendWalkPacket(0, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k1, ((Mob) (localplayer)).palettex_stack[0], true, k);
            Palette.anInt470 = -1;
            if(flag)
            {
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 1;
                anInt916 = 0;
            }
        }
        if(super.anInt26 == 1 && aString844 != null)
        {
            aString844 = null;
            aBoolean1223 = true;
            super.anInt26 = 0;
        }
        handleClickPackets_(4);
        handleMinimapClicking(true);
        handleTabClicking(19);
        handleClientToolbar(true);
        if(super.anInt19 == 1 || super.anInt26 == 1)
            anInt1213++;
        if(landscape_stage == 2)
            handleKeyboardArrows(3);
        if(landscape_stage == 2 && aBoolean1160)
            calculateCameraPosition((byte)5);
        for(int i1 = 0; i1 < 5; i1++)
            cameratransvars2[i1]++;
        method73(732);
		/* Handle idea counter */
        super.idle_counter++;
        if(super.idle_counter > 4500) {
            anInt1011 = 250;
            super.idle_counter -= 500;
            packetbuffer.putPacket(202);
        }
        anInt988++;
        if(i >= 0)
            grounditems = null;
        if(anInt988 > 500)
        {
            anInt988 = 0;
            int l1 = (int)(Math.random() * 8D);
            if((l1 & 1) == 1)
                anInt1278 += anInt1279;
            if((l1 & 2) == 2)
                anInt1131 += anInt1132;
            if((l1 & 4) == 4)
                anInt896 += anInt897;
        }
        if(anInt1278 < -50)
            anInt1279 = 2;
        if(anInt1278 > 50)
            anInt1279 = -2;
        if(anInt1131 < -55)
            anInt1132 = 2;
        if(anInt1131 > 55)
            anInt1132 = -2;
        if(anInt896 < -40)
            anInt897 = 1;
        if(anInt896 > 40)
            anInt897 = -1;
        anInt1254++;
        if(anInt1254 > 500)
        {
            anInt1254 = 0;
            int i2 = (int)(Math.random() * 8D);
            if((i2 & 1) == 1)
                anInt1209 += anInt1210;
            if((i2 & 2) == 2)
                anInt1170 += anInt1171;
        }
        if(anInt1209 < -60)
            anInt1210 = 2;
        if(anInt1209 > 60)
            anInt1210 = -2;
        if(anInt1170 < -20)
            anInt1171 = 1;
        if(anInt1170 > 10)
            anInt1171 = -1;
        anInt1010++;
        if(anInt1010 > 50)
            packetbuffer.putPacket(0);
		/* Write the outgoing bytes */
        try
        {
            if(gameserver_sockethandler != null && packetbuffer.position > 0)
            {
                gameserver_sockethandler.writeBytes(packetbuffer.position, 0, packetbuffer.payload, 0);
                packetbuffer.position = 0;
                anInt1010 = 0;
                return;
            }
        }
        catch(IOException _ex)
        {
            connectionLost(-670);
            return;
        }
        catch(Exception exception)
        {
            killToMainscreen(true);
        }
    }

    public void method63(int i)
    {
        SpawnedObject class30_sub1 = (SpawnedObject)aClass19_1179.getFirst();
        while(i >= 0) 
        {
            for(int j = 1; j > 0; j++);
        }
        for(; class30_sub1 != null; class30_sub1 = (SpawnedObject)aClass19_1179.getNextForwards(false))
            if(class30_sub1.anInt1294 == -1)
            {
                class30_sub1.anInt1302 = 0;
                method89(false, class30_sub1);
            } else
            {
                class30_sub1.removeDeque();
            }

    }

    public void method64(int i)
    {
        if(logo_imagefetcher != null)
            return;
        super.aClass15_13 = null;
        chat_imagefetcher = null;
        aClass15_1164 = null;
        aClass15_1163 = null;
        toplefttext_imagefetcher = null;
        toolbartext_imagefetcher = null;
        aClass15_1124 = null;
        aClass15_1125 = null;
        titletopleft_imagefetcher = new ImageFetcher(128, 265, getDrawableComponent(0), 0);
        Raster.resetOutput();
        titletopright_imagefetcher = new ImageFetcher(128, 265, getDrawableComponent(0), 0);
        Raster.resetOutput();
        logo_imagefetcher = new ImageFetcher(509, 171, getDrawableComponent(0), 0);
        Raster.resetOutput();
        bottomleftmid_imagefetcher = new ImageFetcher(360, 132, getDrawableComponent(0), 0);
        Raster.resetOutput();
        aClass15_1109 = new ImageFetcher(360, 200, getDrawableComponent(0), 0);
        Raster.resetOutput();
        aClass15_1112 = new ImageFetcher(202, 238, getDrawableComponent(0), 0);
        Raster.resetOutput();
        aClass15_1113 = new ImageFetcher(203, 238, getDrawableComponent(0), 0);
        Raster.resetOutput();
        aClass15_1114 = new ImageFetcher(74, 94, getDrawableComponent(0), 0);
        Raster.resetOutput();
        aClass15_1115 = new ImageFetcher(75, 94, getDrawableComponent(0), 0);
        Raster.resetOutput();
        if(titlescreen_archive != null) {
            drawTitleBackround(0);
            method51(215);
        }
        aBoolean1255 = true;
    }

    public void drawLoadingBar(int i, byte byte0, String s)
    {
        anInt1079 = i;
        aString1049 = s;
        method64(0);
        if(titlescreen_archive == null)
        {
            super.drawLoadingBar(i, (byte)4, s);
            return;
        }
        aClass15_1109.initialize(0);
        char c = '\u0168';
        char c1 = '\310';
        byte byte1 = 20;
        p11_font.drawCenteredYText(0xffffff, "RuneScape is loading - please wait...", 23693, c1 / 2 - 26 - byte1, c / 2);
        int j = c1 / 2 - 18 - byte1;
        Raster.drawQuadrilateralOutline(c / 2 - 152, j, 304, 34, 0x8c1111);
        Raster.drawQuadrilateralOutline(c / 2 - 151, j + 1, 302, 32, 0);
        Raster.drawQuadrilateral(c / 2 - 150, j + 2, i * 3, 30, 0x8c1111);
        Raster.drawQuadrilateral( (c / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30, 0);
        b12_font.drawCenteredYText(0xffffff, s, 23693, (c1 / 2 + 5) - byte1, c / 2);
        aClass15_1109.updateGraphics(171, 23680, super.graphics, 202);
        if(byte0 != 4)
        {
            for(int k = 1; k > 0; k++);
        }
        if(aBoolean1255)
        {
            aBoolean1255 = false;
            if(!runflamecycle)
            {
                titletopleft_imagefetcher.updateGraphics(0, 23680, super.graphics, 0);
                titletopright_imagefetcher.updateGraphics(0, 23680, super.graphics, 637);
            }
            logo_imagefetcher.updateGraphics(0, 23680, super.graphics, 128);
            bottomleftmid_imagefetcher.updateGraphics(371, 23680, super.graphics, 202);
            aClass15_1112.updateGraphics(265, 23680, super.graphics, 0);
            aClass15_1113.updateGraphics(265, 23680, super.graphics, 562);
            aClass15_1114.updateGraphics(171, 23680, super.graphics, 128);
            aClass15_1115.updateGraphics(171, 23680, super.graphics, 562);
        }
    }

    public void method65(int i, int j, int k, int l, Widget class9, int i1, boolean flag, 
            int j1, int k1)
    {
        if(aBoolean972)
            anInt992 = 32;
        else
            anInt992 = 0;
        aBoolean972 = false;
        packetsize += k1;
        if(k >= i && k < i + 16 && l >= i1 && l < i1 + 16)
        {
            class9.anInt224 -= anInt1213 * 4;
            if(flag)
            {
                aBoolean1153 = true;
                return;
            }
        } else
        if(k >= i && k < i + 16 && l >= (i1 + j) - 16 && l < i1 + j)
        {
            class9.anInt224 += anInt1213 * 4;
            if(flag)
            {
                aBoolean1153 = true;
                return;
            }
        } else
        if(k >= i - anInt992 && k < i + 16 + anInt992 && l >= i1 + 16 && l < (i1 + j) - 16 && anInt1213 > 0)
        {
            int l1 = ((j - 32) * j) / j1;
            if(l1 < 8)
                l1 = 8;
            int i2 = l - i1 - 16 - l1 / 2;
            int j2 = j - 32 - l1;
            class9.anInt224 = ((j1 - j) * i2) / j2;
            if(flag)
                aBoolean1153 = true;
            aBoolean972 = true;
        }
    }

    public boolean method66(int i, int j, int k, int l)
    {
        int i1 = i >> 14 & 0x7fff;
        int j1 = pallet.method304(cheight, k, j, i);
        if(l >= 0)
            throw new NullPointerException();
        if(j1 == -1)
            return false;
        int k1 = j1 & 0x1f;
        int l1 = j1 >> 6 & 3;
        if(k1 == 10 || k1 == 11 || k1 == 22)
        {
            ObjectDefinition class46 = ObjectDefinition.getObjectDefinition(i1);
            int i2;
            int j2;
            if(l1 == 0 || l1 == 2)
            {
                i2 = class46.anInt744;
                j2 = class46.objsize;
            } else
            {
                i2 = class46.objsize;
                j2 = class46.anInt744;
            }
            int k2 = class46.anInt768;
            if(l1 != 0)
                k2 = (k2 << l1 & 0xf) + (k2 >> 4 - l1);
            sendWalkPacket(2, 0, j2, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], i2, k2, j, ((Mob) (localplayer)).palettex_stack[0], false, k);
        } else
        {
            sendWalkPacket(2, l1, 0, -11308, k1 + 1, ((Mob) (localplayer)).palettey_stack[0], 0, 0, j, ((Mob) (localplayer)).palettex_stack[0], false, k);
        }
        anInt914 = super.curpressed_x;
        anInt915 = super.curpressed_y;
        anInt917 = 2;
        anInt916 = 0;
        return true;
    }

    public ContainerArchive getContainerArchive(int i, String s, String s1, int j, byte byte0, int k)
    {
        byte abyte0[] = null;
        int l = 5;
        try
        {
            if(cacheindexes[0] != null)
                abyte0 = cacheindexes[0].getRawArchive(true, i);
        }
        catch(Exception _ex) { }
        /*if(abyte0 != null) {
            aCRC32_930.reset();
            aCRC32_930.update(abyte0);
            int i1 = (int)aCRC32_930.getValue();
            if(i1 != j)
                abyte0 = null;
        } */
        if(abyte0 != null)
        {
            ContainerArchive class44 = new ContainerArchive(44820, abyte0);
            return class44;
        }
        int j1 = 0;
        while(abyte0 == null) 
        {
            String s2 = "Unknown error";
            drawLoadingBar(k, (byte)4, "Requesting " + s);
            Object obj = null;
            try
            {
                int k1 = 0;
                DataInputStream datainputstream = getJAGGRABRequest(s1 + j);
                byte abyte1[] = new byte[6];
                datainputstream.readFully(abyte1, 0, 6);
                Buffer buffer0 = new Buffer(abyte1);
                buffer0.position = 3;
                int i2 = buffer0.getTri() + 6;
                int j2 = 6;
                abyte0 = new byte[i2];
                for(int k2 = 0; k2 < 6; k2++)
                    abyte0[k2] = abyte1[k2];

                while(j2 < i2) 
                {
                    int l2 = i2 - j2;
                    if(l2 > 1000)
                        l2 = 1000;
                    int j3 = datainputstream.read(abyte0, j2, l2);
                    if(j3 < 0)
                    {
                        s2 = "Length error: " + j2 + "/" + i2;
                        throw new IOException("EOF");
                    }
                    j2 += j3;
                    int k3 = (j2 * 100) / i2;
                    if(k3 != k1)
                        drawLoadingBar(k, (byte)4, "Loading " + s + " - " + k3 + "%");
                    k1 = k3;
                }
                datainputstream.close();
                try
                {
                    if(cacheindexes[0] != null)
                        cacheindexes[0].writeArchive(abyte0.length, abyte0, i);
                }
                catch(Exception _ex)
                {
                    cacheindexes[0] = null;
                }
                
				
				if(abyte0 != null)
                {
                    aCRC32_930.reset();
                    aCRC32_930.update(abyte0);
                    int i3 = (int)aCRC32_930.getValue();
                    if(i3 != j)
                    {
                        abyte0 = null;
                        j1++;
                        s2 = "Checksum error: " + i3;
                    }
                } 
				
				
            } catch(IOException ioexception) {
                if(s2.equals("Unknown error"))
                    s2 = "Connection error";
                abyte0 = null;
            } catch(NullPointerException _ex) {
                s2 = "Null error";
                abyte0 = null;
                if(!signlink.reporterror)
                    return null;
            } catch(ArrayIndexOutOfBoundsException _ex) {
                s2 = "Bounds error";
                abyte0 = null;
                if(!signlink.reporterror)
                    return null;
            }
            catch(Exception _ex)
            {
                s2 = "Unexpected error";
                abyte0 = null;
                if(!signlink.reporterror)
                    return null;
            }
            if(abyte0 == null)
            {
                for(int l1 = l; l1 > 0; l1--)
                {
                    if(j1 >= 3)
                    {
                        drawLoadingBar(k, (byte)4, "Game updated - please reload page");
                        l1 = 10;
                    } else
                    {
                        drawLoadingBar(k, (byte)4, s2 + " - Retrying in " + l1);
                    }
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(Exception _ex) { }
                }

                l *= 2;
                if(l > 60)
                    l = 60;
                aBoolean872 = !aBoolean872;
            }
        }
        ContainerArchive class44_1 = new ContainerArchive(44820, abyte0);
        if(byte0 != -41)
            throw new NullPointerException();
        else
            return class44_1;
    }

    public void connectionLost(int i)
    {
        if(anInt1011 > 0)
        {
            killToMainscreen(true);
            return;
        }
        toplefttext_imagefetcher.initialize(0);
        p12_font.drawCenteredYText(0, "Connection lost", 23693, 144, 257);
        p12_font.drawCenteredYText(0xffffff, "Connection lost", 23693, 143, 256);
        p12_font.drawCenteredYText(0, "Please wait - attempting to reestablish", 23693, 159, 257);
        p12_font.drawCenteredYText(0xffffff, "Please wait - attempting to reestablish", 23693, 158, 256);
        while(i >= 0) 
            packetbuffer.put(164);
        toplefttext_imagefetcher.updateGraphics(4, 23680, super.graphics, 4);
        anInt1021 = 0;
        anInt1261 = 0;
        SocketHandler class24 = gameserver_sockethandler;
        aBoolean1157 = false;
        anInt1038 = 0;
        login(username, password, true);
        if(!aBoolean1157)
            killToMainscreen(true);
        try
        {
            class24.method267();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public void handleClick(int i, boolean flag)
    {
        if(i < 0)
            return;
        if(anInt1225 != 0)
        {
            anInt1225 = 0;
            aBoolean1223 = true;
        }
        int j = interfacestack_a[i];
        int k = interfacestack_b[i];
        int l = interfaceopcodestack[i];
        int i1 = interfacestack_c[i];
        if(l >= 2000)
            l -= 2000;
		/* Write item on NPC packet */
        if(l == 582)
        {
            NPC class30_sub2_sub4_sub1_sub1 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(57);
                packetbuffer.putShort128(-431, anInt1285);
                packetbuffer.putShort128(-431, i1);
                packetbuffer.putShortLE_(true, anInt1283);
                packetbuffer.putShort128(-431, anInt1284);
            }
        }
		/* Pickup ground item */
        if(l == 234)
        {
            boolean flag1 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag1)
                flag1 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(236);
            packetbuffer.putShortLE_(true, k + palettey);
            packetbuffer.putShort(i1);
            packetbuffer.putShortLE_(true, j + palettex);
        }
		/* Item on object */
        if(l == 62 && method66(i1, k, j, -770))
        {
            packetbuffer.putPacket(192);
            packetbuffer.putShort(anInt1284);
            packetbuffer.putShortLE_(true, i1 >> 14 & 0x7fff);
            packetbuffer.putShortLE128(0, k + palettey);
            packetbuffer.putShortLE_(true, anInt1283);
            packetbuffer.putShortLE128(0, j + palettex);
            packetbuffer.putShort(anInt1285);
        }
		/* Item on floor */
        if(l == 511)
        {
            boolean flag2 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag2)
                flag2 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(25);
            packetbuffer.putShortLE_(true, anInt1284);
            packetbuffer.putShort128(-431, anInt1285);
            packetbuffer.putShort(i1);
            packetbuffer.putShort128(-431, k + palettey);
            packetbuffer.putShortLE128(0, anInt1283);
            packetbuffer.putShort(j + palettex);
        }
		/* Item action one */
        if(l == 74)
        {
            packetbuffer.putPacket(122);
            packetbuffer.putShortLE128(0, k);
            packetbuffer.putShort128(-431, j);
            packetbuffer.putShortLE_(true, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
		/* Button click */
        if(l == 315)
        {
            Widget class9 = Widget.widgets[k];
            boolean flag8 = true;
            if(class9.actioncode > 0)
                flag8 = method48(505, class9);
            if(flag8)
            {
                packetbuffer.putPacket(185);
                packetbuffer.putShort(k);
            }
        }
        if(l == 561)
        {
            Player class30_sub2_sub4_sub1_sub2 = players[i1];
            if(class30_sub2_sub4_sub1_sub2 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                anInt1188 += i1;
                if(anInt1188 >= 90)
                {
                    packetbuffer.putPacket(136);
                    anInt1188 = 0;
                }
                packetbuffer.putPacket(128);
                packetbuffer.putShort(i1);
            }
        }
        if(l == 20)
        {
            NPC class30_sub2_sub4_sub1_sub1_1 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_1 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1_1)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1_1)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(155);
                packetbuffer.putShortLE_(true, i1);
            }
        }
        if(l == 779)
        {
            Player class30_sub2_sub4_sub1_sub2_1 = players[i1];
            if(class30_sub2_sub4_sub1_sub2_1 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_1)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_1)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(153);
                packetbuffer.putShortLE_(true, i1);
            }
        }
        if(l == 516)
            if(!aBoolean885)
                pallet.method312(false, super.curpressed_y - 4, super.curpressed_x - 4);
            else
                pallet.method312(false, k - 4, j - 4);
        if(l == 1062)
        {
            anInt924 += palettex;
            if(anInt924 >= 113)
            {
                packetbuffer.putPacket(183);
                packetbuffer.putTri(0xe63271);
                anInt924 = 0;
            }
            method66(i1, k, j, -770);
            packetbuffer.putPacket(228);
            packetbuffer.putShort128(-431, i1 >> 14 & 0x7fff);
            packetbuffer.putShort128(-431, k + palettey);
            packetbuffer.putShort(j + palettex);
        }
        if(l == 679 && !aBoolean1149)
        {
            packetbuffer.putPacket(40);
            packetbuffer.putShort(k);
            aBoolean1149 = true;
        }
        if(l == 431)
        {
            packetbuffer.putPacket(129);
            packetbuffer.putShort128(-431, j);
            packetbuffer.putShort(k);
            packetbuffer.putShort128(-431, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 337 || l == 42 || l == 792 || l == 322)
        {
            String s = interfacestringstack[i];
            int k1 = s.indexOf("@whi@");
            if(k1 != -1)
            {
                long l3 = TextUtils.stringToLong(s.substring(k1 + 5).trim());
                if(l == 337)
                    socialListLogic((byte)68, l3);
                if(l == 42)
                    method113(l3, 4);
                if(l == 792)
                    removeFriend(false, l3);
                if(l == 322)
                    method122(3, l3);
            }
        }
        if(l == 53)
        {
            packetbuffer.putPacket(135);
            packetbuffer.putShortLE_(true, j);
            packetbuffer.putShort128(-431, k);
            packetbuffer.putShortLE_(true, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 539)
        {
            packetbuffer.putPacket(16);
            packetbuffer.putShort128(-431, i1);
            packetbuffer.putShortLE128(0, j);
            packetbuffer.putShortLE128(0, k);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 484 || l == 6)
        {
            String s1 = interfacestringstack[i];
            int l1 = s1.indexOf("@whi@");
            if(l1 != -1)
            {
                s1 = s1.substring(l1 + 5).trim();
                String s7 = TextUtils.formatUsername(-45804, TextUtils.longToString(TextUtils.stringToLong(s1), (byte)-99));
                boolean flag9 = false;
                for(int j3 = 0; j3 < anInt891; j3++)
                {
                    Player class30_sub2_sub4_sub1_sub2_7 = players[anIntArray892[j3]];
                    if(class30_sub2_sub4_sub1_sub2_7 == null || class30_sub2_sub4_sub1_sub2_7.name == null || !class30_sub2_sub4_sub1_sub2_7.name.equalsIgnoreCase(s7))
                        continue;
                    sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_7)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_7)).palettex_stack[0]);
                    if(l == 484)
                    {
                        packetbuffer.putPacket(139);
                        packetbuffer.putShortLE_(true, anIntArray892[j3]);
                    }
                    if(l == 6)
                    {
                        anInt1188 += i1;
                        if(anInt1188 >= 90)
                        {
                            packetbuffer.putPacket(136);
                            anInt1188 = 0;
                        }
                        packetbuffer.putPacket(128);
                        packetbuffer.putShort(anIntArray892[j3]);
                    }
                    flag9 = true;
                    break;
                }

                if(!flag9)
                    pushMessage("Unable to find " + s7, 0, "", aBoolean991);
            }
        }
		/* Item on item */
        if(l == 870)
        {
            packetbuffer.putPacket(53);
            packetbuffer.putShort(j);
            packetbuffer.putShort128(-431, anInt1283);
            packetbuffer.putShortLE128(0, i1);
            packetbuffer.putShort(anInt1284);
            packetbuffer.putShortLE_(true, anInt1285);
            packetbuffer.putShort(k);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
		/* Drop item */
        if(l == 847)
        {
            packetbuffer.putPacket(87);
            packetbuffer.putShort128(-431, i1);
            packetbuffer.putShort(k);
            packetbuffer.putShort128(-431, j);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 626)
        {
            Widget class9_1 = Widget.widgets[k];
            anInt1136 = 1;
            anInt1137 = k;
            anInt1138 = class9_1.anInt237;
            anInt1282 = 0;
            aBoolean1153 = true;
            String s4 = class9_1.aString222;
            if(s4.indexOf(" ") != -1)
                s4 = s4.substring(0, s4.indexOf(" "));
            String s8 = class9_1.aString222;
            if(s8.indexOf(" ") != -1)
                s8 = s8.substring(s8.indexOf(" ") + 1);
            aString1139 = s4 + " " + class9_1.aString218 + " " + s8;
            if(anInt1138 == 16)
            {
                aBoolean1153 = true;
                current_tab = 3;
                update_tabs = true;
            }
            return;
        }
        if(l == 78)
        {
            packetbuffer.putPacket(117);
            packetbuffer.putShortLE128(0, k);
            packetbuffer.putShortLE128(0, i1);
            packetbuffer.putShortLE_(true, j);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 27)
        {
            Player class30_sub2_sub4_sub1_sub2_2 = players[i1];
            if(class30_sub2_sub4_sub1_sub2_2 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_2)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_2)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                anInt986 += i1;
                if(anInt986 >= 54)
                {
                    packetbuffer.putPacket(189);
                    packetbuffer.put(234);
                    anInt986 = 0;
                }
                packetbuffer.putPacket(73);
                packetbuffer.putShortLE_(true, i1);
            }
        }
        if(l == 213)
        {
            boolean flag3 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag3)
                flag3 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(79);
            packetbuffer.putShortLE_(true, k + palettey);
            packetbuffer.putShort(i1);
            packetbuffer.putShort128(-431, j + palettex);
        }
        if(l == 632)
        {
            packetbuffer.putPacket(145);
            packetbuffer.putShort128(-431, k);
            packetbuffer.putShort128(-431, j);
            packetbuffer.putShort128(-431, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 493)
        {
            packetbuffer.putPacket(75);
            packetbuffer.putShortLE128(0, k);
            packetbuffer.putShortLE_(true, j);
            packetbuffer.putShort128(-431, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 652)
        {
            boolean flag4 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag4)
                flag4 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(156);
            packetbuffer.putShort128(-431, j + palettex);
            packetbuffer.putShortLE_(true, k + palettey);
            packetbuffer.putShortLE128(0, i1);
        }
        if(l == 94)
        {
            boolean flag5 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag5)
                flag5 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(181);
            packetbuffer.putShortLE_(true, k + palettey);
            packetbuffer.putShort(i1);
            packetbuffer.putShortLE_(true, j + palettex);
            packetbuffer.putShort128(-431, anInt1137);
        }
        if(l == 646)
        {
            packetbuffer.putPacket(185);
            packetbuffer.putShort(k);
            Widget class9_2 = Widget.widgets[k];
            if(class9_2.anIntArrayArray226 != null && class9_2.anIntArrayArray226[0][0] == 5)
            {
                int i2 = class9_2.anIntArrayArray226[0][1];
                if(configstates[i2] != class9_2.updatestates[0])
                {
                    configstates[i2] = class9_2.updatestates[0];
                    parseClientVarps(false, i2);
                    aBoolean1153 = true;
                }
            }
        }
        if(l == 225)
        {
            NPC class30_sub2_sub4_sub1_sub1_2 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_2 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1_2)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1_2)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                anInt1226 += i1;
                if(anInt1226 >= 85)
                {
                    packetbuffer.putPacket(230);
                    packetbuffer.put(239);
                    anInt1226 = 0;
                }
                packetbuffer.putPacket(17);
                packetbuffer.putShortLE128(0, i1);
            }
        }
        if(l == 965)
        {
            NPC class30_sub2_sub4_sub1_sub1_3 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_3 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1_3)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1_3)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                anInt1134++;
                if(anInt1134 >= 96)
                {
                    packetbuffer.putPacket(152);
                    packetbuffer.put(88);
                    anInt1134 = 0;
                }
                packetbuffer.putPacket(21);
                packetbuffer.putShort(i1);
            }
        }
        if(l == 413)
        {
            NPC class30_sub2_sub4_sub1_sub1_4 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_4 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1_4)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1_4)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(131);
                packetbuffer.putShortLE128(0, i1);
                packetbuffer.putShort128(-431, anInt1137);
            }
        }
        if(l == 200)
            method147(537);
        if(l == 1025)
        {
            NPC class30_sub2_sub4_sub1_sub1_5 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_5 != null)
            {
                NPCDefinition class5 = class30_sub2_sub4_sub1_sub1_5.definition;
                if(class5.confignpcs != null)
                    class5 = class5.method161(anInt877);
                if(class5 != null)
                {
                    String s9;
                    if(class5.examine != null)
                        s9 = new String(class5.examine);
                    else
                        s9 = "It's a " + class5.name + ".";
                    pushMessage(s9, 0, "", aBoolean991);
                }
            }
        }
        if(l == 900)
        {
            method66(i1, k, j, -770);
            packetbuffer.putPacket(252);
            packetbuffer.putShortLE128(0, i1 >> 14 & 0x7fff);
            packetbuffer.putShortLE_(true, k + palettey);
            packetbuffer.putShort128(-431, j + palettex);
        }
        if(l == 412)
        {
            NPC class30_sub2_sub4_sub1_sub1_6 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_6 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1_6)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1_6)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(72);
                packetbuffer.putShort128(-431, i1);
            }
        }
        if(l == 365)
        {
            Player class30_sub2_sub4_sub1_sub2_3 = players[i1];
            if(class30_sub2_sub4_sub1_sub2_3 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_3)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_3)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(249);
                packetbuffer.putShort128(-431, i1);
                packetbuffer.putShortLE_(true, anInt1137);
            }
        }
        if(l == 729)
        {
            Player class30_sub2_sub4_sub1_sub2_4 = players[i1];
            if(class30_sub2_sub4_sub1_sub2_4 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_4)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_4)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(39);
                packetbuffer.putShortLE_(true, i1);
            }
        }
        if(l == 577)
        {
            Player class30_sub2_sub4_sub1_sub2_5 = players[i1];
            if(class30_sub2_sub4_sub1_sub2_5 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_5)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_5)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(139);
                packetbuffer.putShortLE_(true, i1);
            }
        }
        if(l == 956 && method66(i1, k, j, -770))
        {
            packetbuffer.putPacket(35);
            packetbuffer.putShortLE_(true, j + palettex);
            packetbuffer.putShort128(-431, anInt1137);
            packetbuffer.putShort128(-431, k + palettey);
            packetbuffer.putShortLE_(true, i1 >> 14 & 0x7fff);
        }
        if(l == 567)
        {
            boolean flag6 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag6)
                flag6 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(23);
            packetbuffer.putShortLE_(true, k + palettey);
            packetbuffer.putShortLE_(true, i1);
            packetbuffer.putShortLE_(true, j + palettex);
        }
        if(l == 867)
        {
            if((i1 & 3) == 0)
                anInt1175++;
            if(anInt1175 >= 59)
            {
                packetbuffer.putPacket(200);
                packetbuffer.putShort(25501);
                anInt1175 = 0;
            }
            packetbuffer.putPacket(43);
            packetbuffer.putShortLE_(true, k);
            packetbuffer.putShort128(-431, i1);
            packetbuffer.putShort128(-431, j);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 543)
        {
            packetbuffer.putPacket(237);
            packetbuffer.putShort(j);
            packetbuffer.putShort128(-431, i1);
            packetbuffer.putShort(k);
            packetbuffer.putShort128(-431, anInt1137);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 606)
        {
            String s2 = interfacestringstack[i];
            int j2 = s2.indexOf("@whi@");
            if(j2 != -1)
                if(anInt857 == -1)
                {
                    method147(537);
                    aString881 = s2.substring(j2 + 5).trim();
                    aBoolean1158 = false;
                    for(int i3 = 0; i3 < Widget.widgets.length; i3++)
                    {
                        if(Widget.widgets[i3] == null || Widget.widgets[i3].actioncode != 600)
                            continue;
                        anInt1178 = anInt857 = Widget.widgets[i3].parentid;
                        break;
                    }

                } else
                {
                    pushMessage("Please close the interface you have open before using 'report abuse'", 0, "", aBoolean991);
                }
        }
        if(l == 491)
        {
            Player class30_sub2_sub4_sub1_sub2_6 = players[i1];
            if(class30_sub2_sub4_sub1_sub2_6 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub2_6)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub2_6)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                packetbuffer.putPacket(14);
                packetbuffer.putShort128(-431, anInt1284);
                packetbuffer.putShort(i1);
                packetbuffer.putShort(anInt1285);
                packetbuffer.putShortLE_(true, anInt1283);
            }
        }
        if(l == 639)
        {
            String s3 = interfacestringstack[i];
            int k2 = s3.indexOf("@whi@");
            if(k2 != -1)
            {
                long l4 = TextUtils.stringToLong(s3.substring(k2 + 5).trim());
                int k3 = -1;
                for(int i4 = 0; i4 < amt_friendhashes; i4++)
                {
                    if(friend_hashes[i4] != l4)
                        continue;
                    k3 = i4;
                    break;
                }

                if(k3 != -1 && anIntArray826[k3] > 0)
                {
                    aBoolean1223 = true;
                    anInt1225 = 0;
                    aBoolean1256 = true;
                    aString1212 = "";
                    anInt1064 = 3;
                    aLong953 = friend_hashes[k3];
                    aString1121 = "Enter message to send to " + friendusernames[k3];
                }
            }
        }
        if(l == 454)
        {
            packetbuffer.putPacket(41);
            packetbuffer.putShort(i1);
            packetbuffer.putShort128(-431, j);
            packetbuffer.putShort128(-431, k);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Widget.widgets[k].parentid == anInt857)
                anInt1246 = 1;
            if(Widget.widgets[k].parentid == anInt1276)
                anInt1246 = 3;
        }
        if(l == 478)
        {
            NPC class30_sub2_sub4_sub1_sub1_7 = npcs[i1];
            if(class30_sub2_sub4_sub1_sub1_7 != null)
            {
                sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, ((Mob) (class30_sub2_sub4_sub1_sub1_7)).palettey_stack[0], ((Mob) (localplayer)).palettex_stack[0], false, ((Mob) (class30_sub2_sub4_sub1_sub1_7)).palettex_stack[0]);
                anInt914 = super.curpressed_x;
                anInt915 = super.curpressed_y;
                anInt917 = 2;
                anInt916 = 0;
                if((i1 & 3) == 0)
                    anInt1155++;
                if(anInt1155 >= 53)
                {
                    packetbuffer.putPacket(85);
                    packetbuffer.put(66);
                    anInt1155 = 0;
                }
                packetbuffer.putPacket(18);
                packetbuffer.putShortLE_(true, i1);
            }
        }
        if(l == 113)
        {
            method66(i1, k, j, -770);
            packetbuffer.putPacket(70);
            packetbuffer.putShortLE_(true, j + palettex);
            packetbuffer.putShort(k + palettey);
            packetbuffer.putShortLE128(0, i1 >> 14 & 0x7fff);
        }
        if(l == 872)
        {
            method66(i1, k, j, -770);
            packetbuffer.putPacket(234);
            packetbuffer.putShortLE128(0, j + palettex);
            packetbuffer.putShort128(-431, i1 >> 14 & 0x7fff);
            packetbuffer.putShortLE128(0, k + palettey);
        }
        if(l == 502)
        {
            method66(i1, k, j, -770);
            packetbuffer.putPacket(132);
            packetbuffer.putShortLE128(0, j + palettex);
            packetbuffer.putShort(i1 >> 14 & 0x7fff);
            packetbuffer.putShort128(-431, k + palettey);
        }
        if(l == 1125)
        {
            ItemDefinition class8 = ItemDefinition.getItemDefinition(i1);
            Widget class9_4 = Widget.widgets[k];
            String s5;
            if(class9_4 != null && class9_4.itemamounts[j] >= 0x186a0)
                s5 = class9_4.itemamounts[j] + " x " + class8.name;
            else
            if(class8.examine != null)
                s5 = new String(class8.examine);
            else
                s5 = "It's a " + class8.name + ".";
            pushMessage(s5, 0, "", aBoolean991);
        }
        if(l == 169)
        {
            packetbuffer.putPacket(185);
            packetbuffer.putShort(k);
            Widget class9_3 = Widget.widgets[k];
            if(class9_3.anIntArrayArray226 != null && class9_3.anIntArrayArray226[0][0] == 5)
            {
                int l2 = class9_3.anIntArrayArray226[0][1];
                configstates[l2] = 1 - configstates[l2];
                parseClientVarps(false, l2);
                aBoolean1153 = true;
            }
        }
        if(l == 447)
        {
            anInt1282 = 1;
            anInt1283 = j;
            anInt1284 = k;
            anInt1285 = i1;
            aString1286 = ItemDefinition.getItemDefinition(i1).name;
            anInt1136 = 0;
            aBoolean1153 = true;
            return;
        }
        if(l == 1226)
        {
            int j1 = i1 >> 14 & 0x7fff;
            ObjectDefinition class46 = ObjectDefinition.getObjectDefinition(j1);
            String s10;
            if(class46.aByteArray777 != null)
                s10 = new String(class46.aByteArray777);
            else
                s10 = "It's a " + class46.aString739 + ".";
            pushMessage(s10, 0, "", aBoolean991);
        }
        if(l == 244)
        {
            boolean flag7 = sendWalkPacket(2, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            if(!flag7)
                flag7 = sendWalkPacket(2, 0, 1, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 1, 0, k, ((Mob) (localplayer)).palettex_stack[0], false, j);
            anInt914 = super.curpressed_x;
            anInt915 = super.curpressed_y;
            anInt917 = 2;
            anInt916 = 0;
            packetbuffer.putPacket(253);
            packetbuffer.putShortLE_(true, j + palettex);
            packetbuffer.putShortLE128(0, k + palettey);
            packetbuffer.putShort128(-431, i1);
        }
        if(l == 1448)
        {
            ItemDefinition class8_1 = ItemDefinition.getItemDefinition(i1);
            String s6;
            if(class8_1.examine != null)
                s6 = new String(class8_1.examine);
            else
                s6 = "It's a " + class8_1.name + ".";
            pushMessage(s6, 0, "", aBoolean991);
        }
        anInt1282 = 0;
        if(flag)
        {
            return;
        } else
        {
            anInt1136 = 0;
            aBoolean1153 = true;
            return;
        }
    }

    public void calculateOntutorialIsland(int junk)
    {
        ontutorial_island = 0;
        int x = (((Mob) (localplayer)).fineposx >> 7) + palettex;
        int y = (((Mob) (localplayer)).fineposy >> 7) + palettey;
        if(x >= 3053 && x <= 3156 && y >= 3056 && y <= 3136)
            ontutorial_island = 1;
        if(x >= 3072 && x <= 3118 && y >= 9492 && y <= 9535)
            ontutorial_island = 1;
        if(ontutorial_island == 1 && x >= 3139 && x <= 3199 && y >= 3008 && y <= 3062)
            ontutorial_island = 0;
    }

    public void run()
    {
        if(runclient)
        {
            clientProcess((byte)59);
            return;
        } else
        {
            super.run();
            return;
        }
    }

    public void method71(int i)
    {
        if(anInt1282 == 0 && anInt1136 == 0)
        {
            interfacestringstack[anInt1133] = "Walk here";
            interfaceopcodestack[anInt1133] = 516;
            interfacestack_a[anInt1133] = super.mouse_x;
            interfacestack_b[anInt1133] = super.mouse_y;
            anInt1133++;
        }
        int j = -1;
        for(int k = 0; k < Model.anInt1687; k++)
        {
            int l = Model.anIntArray1688[k];
            int i1 = l & 0x7f;
            int j1 = l >> 7 & 0x7f;
            int k1 = l >> 29 & 3;
            int l1 = l >> 14 & 0x7fff;
            if(l == j)
                continue;
            j = l;
            if(k1 == 2 && pallet.method304(cheight, i1, j1, l) >= 0)
            {
                ObjectDefinition class46 = ObjectDefinition.getObjectDefinition(l1);
                if(class46.anIntArray759 != null)
                    class46 = class46.method580(true);
                if(class46 == null)
                    continue;
                if(anInt1282 == 1)
                {
                    interfacestringstack[anInt1133] = "Use " + aString1286 + " with @cya@" + class46.aString739;
                    interfaceopcodestack[anInt1133] = 62;
                    interfacestack_c[anInt1133] = l;
                    interfacestack_a[anInt1133] = i1;
                    interfacestack_b[anInt1133] = j1;
                    anInt1133++;
                } else
                if(anInt1136 == 1)
                {
                    if((anInt1138 & 4) == 4)
                    {
                        interfacestringstack[anInt1133] = aString1139 + " @cya@" + class46.aString739;
                        interfaceopcodestack[anInt1133] = 956;
                        interfacestack_c[anInt1133] = l;
                        interfacestack_a[anInt1133] = i1;
                        interfacestack_b[anInt1133] = j1;
                        anInt1133++;
                    }
                } else
                {
                    if(class46.aStringArray786 != null)
                    {
                        for(int i2 = 4; i2 >= 0; i2--)
                            if(class46.aStringArray786[i2] != null)
                            {
                                interfacestringstack[anInt1133] = class46.aStringArray786[i2] + " @cya@" + class46.aString739;
                                if(i2 == 0)
                                    interfaceopcodestack[anInt1133] = 502;
                                if(i2 == 1)
                                    interfaceopcodestack[anInt1133] = 900;
                                if(i2 == 2)
                                    interfaceopcodestack[anInt1133] = 113;
                                if(i2 == 3)
                                    interfaceopcodestack[anInt1133] = 872;
                                if(i2 == 4)
                                    interfaceopcodestack[anInt1133] = 1062;
                                interfacestack_c[anInt1133] = l;
                                interfacestack_a[anInt1133] = i1;
                                interfacestack_b[anInt1133] = j1;
                                anInt1133++;
                            }

                    }
                    interfacestringstack[anInt1133] = "Examine @cya@" + class46.aString739;
                    interfaceopcodestack[anInt1133] = 1226;
                    interfacestack_c[anInt1133] = class46.id << 14;
                    interfacestack_a[anInt1133] = i1;
                    interfacestack_b[anInt1133] = j1;
                    anInt1133++;
                }
            }
            if(k1 == 1)
            {
                NPC class30_sub2_sub4_sub1_sub1 = npcs[l1];
                if(class30_sub2_sub4_sub1_sub1.definition.npc_halftileoffsets == 1 && (((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx & 0x7f) == 64 && (((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy & 0x7f) == 64)
                {
                    for(int j2 = 0; j2 < anInt836; j2++)
                    {
                        NPC class30_sub2_sub4_sub1_sub1_1 = npcs[updatenpcs[j2]];
                        if(class30_sub2_sub4_sub1_sub1_1 != null && class30_sub2_sub4_sub1_sub1_1 != class30_sub2_sub4_sub1_sub1 && class30_sub2_sub4_sub1_sub1_1.definition.npc_halftileoffsets == 1 && ((Mob) (class30_sub2_sub4_sub1_sub1_1)).fineposx == ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx && ((Mob) (class30_sub2_sub4_sub1_sub1_1)).fineposy == ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy)
                            method87(class30_sub2_sub4_sub1_sub1_1.definition, updatenpcs[j2], false, j1, i1);
                    }

                    for(int l2 = 0; l2 < anInt891; l2++)
                    {
                        Player class30_sub2_sub4_sub1_sub2_1 = players[anIntArray892[l2]];
                        if(class30_sub2_sub4_sub1_sub2_1 != null && ((Mob) (class30_sub2_sub4_sub1_sub2_1)).fineposx == ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx && ((Mob) (class30_sub2_sub4_sub1_sub2_1)).fineposy == ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy)
                            method88(i1, anIntArray892[l2], class30_sub2_sub4_sub1_sub2_1, false, j1);
                    }

                }
                method87(class30_sub2_sub4_sub1_sub1.definition, l1, false, j1, i1);
            }
            if(k1 == 0)
            {
                Player class30_sub2_sub4_sub1_sub2 = players[l1];
                if((((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx & 0x7f) == 64 && (((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy & 0x7f) == 64)
                {
                    for(int k2 = 0; k2 < anInt836; k2++)
                    {
                        NPC class30_sub2_sub4_sub1_sub1_2 = npcs[updatenpcs[k2]];
                        if(class30_sub2_sub4_sub1_sub1_2 != null && class30_sub2_sub4_sub1_sub1_2.definition.npc_halftileoffsets == 1 && ((Mob) (class30_sub2_sub4_sub1_sub1_2)).fineposx == ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx && ((Mob) (class30_sub2_sub4_sub1_sub1_2)).fineposy == ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy)
                            method87(class30_sub2_sub4_sub1_sub1_2.definition, updatenpcs[k2], false, j1, i1);
                    }

                    for(int i3 = 0; i3 < anInt891; i3++)
                    {
                        Player class30_sub2_sub4_sub1_sub2_2 = players[anIntArray892[i3]];
                        if(class30_sub2_sub4_sub1_sub2_2 != null && class30_sub2_sub4_sub1_sub2_2 != class30_sub2_sub4_sub1_sub2 && ((Mob) (class30_sub2_sub4_sub1_sub2_2)).fineposx == ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx && ((Mob) (class30_sub2_sub4_sub1_sub2_2)).fineposy == ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy)
                            method88(i1, anIntArray892[i3], class30_sub2_sub4_sub1_sub2_2, false, j1);
                    }

                }
                method88(i1, l1, class30_sub2_sub4_sub1_sub2, false, j1);
            }
            if(k1 == 3)
            {
                Deque class19 = grounditems[cheight][i1][j1];
                if(class19 != null)
                {
                    for(GroundItem class30_sub2_sub4_sub2 = (GroundItem)class19.getLast(5); class30_sub2_sub4_sub2 != null; class30_sub2_sub4_sub2 = (GroundItem)class19.getNextBackwards(8))
                    {
                        ItemDefinition class8 = ItemDefinition.getItemDefinition(class30_sub2_sub4_sub2.itemid);
                        if(anInt1282 == 1)
                        {
                            interfacestringstack[anInt1133] = "Use " + aString1286 + " with @lre@" + class8.name;
                            interfaceopcodestack[anInt1133] = 511;
                            interfacestack_c[anInt1133] = class30_sub2_sub4_sub2.itemid;
                            interfacestack_a[anInt1133] = i1;
                            interfacestack_b[anInt1133] = j1;
                            anInt1133++;
                        } else
                        if(anInt1136 == 1)
                        {
                            if((anInt1138 & 1) == 1)
                            {
                                interfacestringstack[anInt1133] = aString1139 + " @lre@" + class8.name;
                                interfaceopcodestack[anInt1133] = 94;
                                interfacestack_c[anInt1133] = class30_sub2_sub4_sub2.itemid;
                                interfacestack_a[anInt1133] = i1;
                                interfacestack_b[anInt1133] = j1;
                                anInt1133++;
                            }
                        } else
                        {
                            for(int j3 = 4; j3 >= 0; j3--)
                                if(class8.ground_options != null && class8.ground_options[j3] != null)
                                {
                                    interfacestringstack[anInt1133] = class8.ground_options[j3] + " @lre@" + class8.name;
                                    if(j3 == 0)
                                        interfaceopcodestack[anInt1133] = 652;
                                    if(j3 == 1)
                                        interfaceopcodestack[anInt1133] = 567;
                                    if(j3 == 2)
                                        interfaceopcodestack[anInt1133] = 234;
                                    if(j3 == 3)
                                        interfaceopcodestack[anInt1133] = 244;
                                    if(j3 == 4)
                                        interfaceopcodestack[anInt1133] = 213;
                                    interfacestack_c[anInt1133] = class30_sub2_sub4_sub2.itemid;
                                    interfacestack_a[anInt1133] = i1;
                                    interfacestack_b[anInt1133] = j1;
                                    anInt1133++;
                                } else
                                if(j3 == 2)
                                {
                                    interfacestringstack[anInt1133] = "Take @lre@" + class8.name;
                                    interfaceopcodestack[anInt1133] = 234;
                                    interfacestack_c[anInt1133] = class30_sub2_sub4_sub2.itemid;
                                    interfacestack_a[anInt1133] = i1;
                                    interfacestack_b[anInt1133] = j1;
                                    anInt1133++;
                                }

                            interfacestringstack[anInt1133] = "Examine @lre@" + class8.name;
                            interfaceopcodestack[anInt1133] = 1448;
                            interfacestack_c[anInt1133] = class30_sub2_sub4_sub2.itemid;
                            interfacestack_a[anInt1133] = i1;
                            interfacestack_b[anInt1133] = j1;
                            anInt1133++;
                        }
                    }

                }
            }
        }

        if(i != 33660)
            packetnum = inbuffer.getUByte();
    }

    public void destroy(int i)
    {
        signlink.reporterror = false;
        try
        {
            if(gameserver_sockethandler != null)
                gameserver_sockethandler.method267();
        }
        catch(Exception _ex) { }
        gameserver_sockethandler = null;
        stopMidi(860);
        if(watchdog != null)
            watchdog.running = false;
        watchdog = null;
        ondemandhandler.hault();
        ondemandhandler = null;
        aClass30_Sub2_Sub2_834 = null;
        packetbuffer = null;
        loginbuffer = null;
        inbuffer = null;
        regionhashes = null;
        tilebytes = null;
        regionbytes = null;
        anIntArray1235 = null;
        anIntArray1236 = null;
        main_heightmap = null;
        main_tilesettings = null;
        pallet = null;
        collisionmaps = null;
        anIntArrayArray901 = null;
        distancestrength = null;
        walkingstepsx = null;
        walkingstepsy = null;
        aByteArray912 = null;
        aClass15_1163 = null;
        aClass15_1164 = null;
        toplefttext_imagefetcher = null;
        chat_imagefetcher = null;
        toolbartext_imagefetcher = null;
        aClass15_1124 = null;
        aClass15_1125 = null;
        backleft1_imagefetcher = null;
        backleft2_imagefetcher = null;
        backright1_imagefetcher = null;
        backright2_imagefetcher = null;
        backtop1_imagefetcher = null;
        backvmid1_imagefetcher = null;
        backvmid2_imagefetcher = null;
        backvmid3_imagefetcher = null;
        backhmid2_imagefetcher = null;
        invback = null;
        mapback = null;
        chatback = null;
        backbase1 = null;
        backbase2 = null;
        backmid1 = null;
        sideicons = null;
        redstone1 = null;
        redstone2 = null;
        redstone3 = null;
        redstone1_2 = null;
        redstone2_2 = null;
        redstone1_3 = null;
        redstone2_3 = null;
        redstone3_2 = null;
        redstone1_4 = null;
        redstone2_4 = null;
        compass = null;
        hitmarks = null;
        headicons = null;
        cross_sprites = null;
        grounditem_mapdotsprite = null;
        mapdots1 = null;
        mapdots2 = null;
        mapdots3 = null;
        mapdots4 = null;
        mapscene = null;
        mapfunction = null;
        anIntArrayArray929 = null;
        players = null;
        anIntArray892 = null;
        playerupdate_stack = null;
        appearancebuffers = null;
        playerremove_stack = null;
        npcs = null;
        updatenpcs = null;
        grounditems = null;
        aClass19_1179 = null;
        i = 55 / i;
        aClass19_1013 = null;
        gfxs_storage = null;
        interfacestack_a = null;
        interfacestack_b = null;
        interfaceopcodestack = null;
        interfacestack_c = null;
        interfacestringstack = null;
        configstates = null;
        anIntArray1072 = null;
        anIntArray1073 = null;
        mapfunctionstack = null;
        aClass30_Sub2_Sub1_Sub1_1263 = null;
        friendusernames = null;
        friend_hashes = null;
        anIntArray826 = null;
        titletopleft_imagefetcher = null;
        titletopright_imagefetcher = null;
        logo_imagefetcher = null;
        bottomleftmid_imagefetcher = null;
        aClass15_1109 = null;
        aClass15_1112 = null;
        aClass15_1113 = null;
        aClass15_1114 = null;
        aClass15_1115 = null;
        method118(3);
        ObjectDefinition.dystory(-501);
        NPCDefinition.dystroy(-501);
        ItemDefinition.dystroy(-501);
        Floor.floors = null;
        CharModel.charactermodels = null;
        Widget.widgets = null;
        AnimSequence.animationsequences = null;
        SpotAnim.aClass23Array403 = null;
        SpotAnim.aClass12_415 = null;
        VarpFile.aClass41Array701 = null;
        super.aClass15_13 = null;
        Player.aClass12_1704 = null;
        TriangleRasterizer.destroy(-501);
        Palette.dystroy(-501);
        Model.dystroy(-501);
        AnimFrame.method530(-501);
        System.gc();
    }

    public void printClientStats(byte junk)
    {
        System.out.println("============");
        System.out.println("flame-cycle:" + flame_cycle);
        if(ondemandhandler != null)
            System.out.println("Ondemandd-cycle:" + ondemandhandler.ondemand_cycle);
        System.out.println("loop-cycle:" + loopcycle);
        System.out.println("draw-cycle:" + draw_cycle);
        System.out.println("ptype:" + packetnum);
        System.out.println("psize:" + packetsize);
        if(gameserver_sockethandler != null)
            gameserver_sockethandler.method272((byte)1);
        super.aBoolean9 = true;
    }

    public Component getDrawableComponent(int i)
    {
        packetsize += i;
        if(signlink.mainapp != null)
            return signlink.mainapp;
        if(super.rs_frame != null)
            return super.rs_frame;
        else
            return this;
    }

    public void method73(int i)
    {
        i = 55 / i;
        do
        {
            int j = getKey(-796);
            if(j == -1)
                break;
            if(anInt857 != -1 && anInt857 == anInt1178)
            {
                if(j == 8 && aString881.length() > 0)
                    aString881 = aString881.substring(0, aString881.length() - 1);
                if((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32) && aString881.length() < 12)
                    aString881 += (char)j;
            } else
            if(aBoolean1256)
            {
                if(j >= 32 && j <= 122 && aString1212.length() < 80)
                {
                    aString1212 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString1212.length() > 0)
                {
                    aString1212 = aString1212.substring(0, aString1212.length() - 1);
                    aBoolean1223 = true;
                }
                if(j == 13 || j == 10)
                {
                    aBoolean1256 = false;
                    aBoolean1223 = true;
                    if(anInt1064 == 1)
                    {
                        long l = TextUtils.stringToLong(aString1212);
                        socialListLogic((byte)68, l);
                    }
                    if(anInt1064 == 2 && amt_friendhashes > 0)
                    {
                        long l1 = TextUtils.stringToLong(aString1212);
                        removeFriend(false, l1);
                    }
                    if(anInt1064 == 3 && aString1212.length() > 0)
                    {
                        packetbuffer.putPacket(126);
                        packetbuffer.put(0);
                        int k = packetbuffer.position;
                        packetbuffer.putLong(aLong953);
                        ChatUtils.method526(aString1212, aBoolean1277, packetbuffer);
                        packetbuffer.finishByteVar(packetbuffer.position - k, (byte)0);
                        aString1212 = ChatUtils.method527(aString1212, 0);
                        aString1212 = Censor.censor(aString1212, 0);
                        pushMessage(aString1212, 6, TextUtils.formatUsername(-45804, TextUtils.longToString(aLong953, (byte)-99)), aBoolean991);
                        if(anInt845 == 2)
                        {
                            anInt845 = 1;
                            updatetoolbar = true;
                            packetbuffer.putPacket(95);
                            packetbuffer.put(anInt1287);
                            packetbuffer.put(anInt845);
                            packetbuffer.put(anInt1248);
                        }
                    }
                    if(anInt1064 == 4 && amt_ignorehashes < 100)
                    {
                        long l2 = TextUtils.stringToLong(aString1212);
                        method113(l2, 4);
                    }
                    if(anInt1064 == 5 && amt_ignorehashes > 0)
                    {
                        long l3 = TextUtils.stringToLong(aString1212);
                        method122(3, l3);
                    }
                }
            } else
            if(anInt1225 == 1)
            {
                if(j >= 48 && j <= 57 && aString1004.length() < 10)
                {
                    aString1004 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString1004.length() > 0)
                {
                    aString1004 = aString1004.substring(0, aString1004.length() - 1);
                    aBoolean1223 = true;
                }
                if(j == 13 || j == 10)
                {
                    if(aString1004.length() > 0)
                    {
                        int i1 = 0;
                        try
                        {
                            i1 = Integer.parseInt(aString1004);
                        }
                        catch(Exception _ex) { }
                        packetbuffer.putPacket(208);
                        packetbuffer.putInt(i1);
                    }
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
            } else
            if(anInt1225 == 2)
            {
                if(j >= 32 && j <= 122 && aString1004.length() < 12)
                {
                    aString1004 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString1004.length() > 0)
                {
                    aString1004 = aString1004.substring(0, aString1004.length() - 1);
                    aBoolean1223 = true;
                }
                if(j == 13 || j == 10)
                {
                    if(aString1004.length() > 0)
                    {
                        packetbuffer.putPacket(60);
                        packetbuffer.putLong(TextUtils.stringToLong(aString1004));
                    }
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
            } else
            if(anInt1276 == -1)
            {
                if(j >= 32 && j <= 122 && aString887.length() < 80)
                {
                    aString887 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString887.length() > 0)
                {
                    aString887 = aString887.substring(0, aString887.length() - 1);
                    aBoolean1223 = true;
                }
                if((j == 13 || j == 10) && aString887.length() > 0)
                {
                    if(rights == 2)
                    {
                        if(aString887.equals("::clientdrop"))
                            connectionLost(-670);
                        if(aString887.equals("::lag"))
                            printClientStats((byte)1);
                        if(aString887.equals("::prefetchmusic")) {
                            for(int j1 = 0; j1 < ondemandhandler.getAmountArchives(79, 2); j1++)
                                ondemandhandler.method563((byte)1, 2, j1, (byte)8);

                        }
                        if(aString887.equals("::fpson"))
                            drawfps = true;
                        if(aString887.equals("::fpsoff"))
                            drawfps = false;
                        if(aString887.equals("::noclip"))
                        {
                            for(int k1 = 0; k1 < 4; k1++)
                            {
                                for(int i2 = 1; i2 < 103; i2++)
                                {
                                    for(int k2 = 1; k2 < 103; k2++)
                                        collisionmaps[k1].index[i2][k2] = 0;

                                }

                            }

                        }
                    }
                    if(aString887.startsWith("::"))
                    {
                        packetbuffer.putPacket(103);
                        packetbuffer.put(aString887.length() - 1);
                        packetbuffer.putCStr(aString887.substring(2));
                    } else
                    {
                        String s = aString887.toLowerCase();
                        int j2 = 0;
                        if(s.startsWith("yellow:"))
                        {
                            j2 = 0;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("red:"))
                        {
                            j2 = 1;
                            aString887 = aString887.substring(4);
                        } else
                        if(s.startsWith("green:"))
                        {
                            j2 = 2;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("cyan:"))
                        {
                            j2 = 3;
                            aString887 = aString887.substring(5);
                        } else
                        if(s.startsWith("purple:"))
                        {
                            j2 = 4;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("white:"))
                        {
                            j2 = 5;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("flash1:"))
                        {
                            j2 = 6;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("flash2:"))
                        {
                            j2 = 7;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("flash3:"))
                        {
                            j2 = 8;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("glow1:"))
                        {
                            j2 = 9;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("glow2:"))
                        {
                            j2 = 10;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("glow3:"))
                        {
                            j2 = 11;
                            aString887 = aString887.substring(6);
                        }
                        s = aString887.toLowerCase();
                        int i3 = 0;
                        if(s.startsWith("wave:"))
                        {
                            i3 = 1;
                            aString887 = aString887.substring(5);
                        } else
                        if(s.startsWith("wave2:"))
                        {
                            i3 = 2;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("shake:"))
                        {
                            i3 = 3;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("scroll:"))
                        {
                            i3 = 4;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("slide:"))
                        {
                            i3 = 5;
                            aString887 = aString887.substring(6);
                        }
                        packetbuffer.putPacket(4);
                        packetbuffer.put(0);
                        int j3 = packetbuffer.position;
                        packetbuffer.putSpecialB(301, i3);
                        packetbuffer.putSpecialB(301, j2);
                        aClass30_Sub2_Sub2_834.position = 0;
                        ChatUtils.method526(aString887, aBoolean1277, aClass30_Sub2_Sub2_834);
                        packetbuffer.putBytes128(0, aByte1217, aClass30_Sub2_Sub2_834.payload, aClass30_Sub2_Sub2_834.position);
                        packetbuffer.finishByteVar(packetbuffer.position - j3, (byte)0);
                        aString887 = ChatUtils.method527(aString887, 0);
                        aString887 = Censor.censor(aString887, 0);
                        localplayer.chat_txt = aString887;
                        localplayer.anInt1513 = j2;
                        localplayer.anInt1531 = i3;
                        localplayer.anInt1535 = 150;
                        if(rights == 2)
                            pushMessage(((Mob) (localplayer)).chat_txt, 2, "@cr2@" + localplayer.name, aBoolean991);
                        else
                        if(rights == 1)
                            pushMessage(((Mob) (localplayer)).chat_txt, 2, "@cr1@" + localplayer.name, aBoolean991);
                        else
                            pushMessage(((Mob) (localplayer)).chat_txt, 2, localplayer.name, aBoolean991);
                        if(anInt1287 == 2)
                        {
                            anInt1287 = 3;
                            updatetoolbar = true;
                            packetbuffer.putPacket(95);
                            packetbuffer.put(anInt1287);
                            packetbuffer.put(anInt845);
                            packetbuffer.put(anInt1248);
                        }
                    }
                    aString887 = "";
                    aBoolean1223 = true;
                }
            }
        } while(true);
    }

    public void method74(int i, int j, int k)
    {
        if(k != anInt838)
            anInt838 = packetencryption.poll();
        int l = 0;
        for(int i1 = 0; i1 < 100; i1++)
        {
            if(msgbody_stack[i1] == null)
                continue;
            int j1 = msgtype_stack[i1];
            int k1 = (70 - l * 14) + anInt1089 + 4;
            if(k1 < -20)
                break;
            String s = msgprefix_stack[i1];
            boolean flag = false;
            if(s != null && s.startsWith("@cr1@"))
            {
                s = s.substring(5);
                boolean flag1 = true;
            }
            if(s != null && s.startsWith("@cr2@"))
            {
                s = s.substring(5);
                byte byte0 = 2;
            }
            if(j1 == 0)
                l++;
            if((j1 == 1 || j1 == 2) && (j1 == 1 || anInt1287 == 0 || anInt1287 == 1 && onFriendsList(false, s)))
            {
                if(j > k1 - 14 && j <= k1 && !s.equals(localplayer.name))
                {
                    if(rights >= 1)
                    {
                        interfacestringstack[anInt1133] = "Report abuse @whi@" + s;
                        interfaceopcodestack[anInt1133] = 606;
                        anInt1133++;
                    }
                    interfacestringstack[anInt1133] = "Add ignore @whi@" + s;
                    interfaceopcodestack[anInt1133] = 42;
                    anInt1133++;
                    interfacestringstack[anInt1133] = "Add friend @whi@" + s;
                    interfaceopcodestack[anInt1133] = 337;
                    anInt1133++;
                }
                l++;
            }
            if((j1 == 3 || j1 == 7) && anInt1195 == 0 && (j1 == 7 || anInt845 == 0 || anInt845 == 1 && onFriendsList(false, s)))
            {
                if(j > k1 - 14 && j <= k1)
                {
                    if(rights >= 1)
                    {
                        interfacestringstack[anInt1133] = "Report abuse @whi@" + s;
                        interfaceopcodestack[anInt1133] = 606;
                        anInt1133++;
                    }
                    interfacestringstack[anInt1133] = "Add ignore @whi@" + s;
                    interfaceopcodestack[anInt1133] = 42;
                    anInt1133++;
                    interfacestringstack[anInt1133] = "Add friend @whi@" + s;
                    interfaceopcodestack[anInt1133] = 337;
                    anInt1133++;
                }
                l++;
            }
            if(j1 == 4 && (anInt1248 == 0 || anInt1248 == 1 && onFriendsList(false, s)))
            {
                if(j > k1 - 14 && j <= k1)
                {
                    interfacestringstack[anInt1133] = "Accept trade @whi@" + s;
                    interfaceopcodestack[anInt1133] = 484;
                    anInt1133++;
                }
                l++;
            }
            if((j1 == 5 || j1 == 6) && anInt1195 == 0 && anInt845 < 2)
                l++;
            if(j1 == 8 && (anInt1248 == 0 || anInt1248 == 1 && onFriendsList(false, s)))
            {
                if(j > k1 - 14 && j <= k1)
                {
                    interfacestringstack[anInt1133] = "Accept challenge @whi@" + s;
                    interfaceopcodestack[anInt1133] = 6;
                    anInt1133++;
                }
                l++;
            }
        }

    }

    public void handleWidgetActionCode(int i, Widget widget)
    {
        int code = widget.actioncode;
        if(code >= 1 && code <= 100 || code >= 701 && code <= 800)
        {
            if(code == 1 && anInt900 == 0)
            {
                widget.aString248 = "Loading friend list";
                widget.textfieldtype = 0;
                return;
            }
            if(code == 1 && anInt900 == 1)
            {
                widget.aString248 = "Connecting to friendserver";
                widget.textfieldtype = 0;
                return;
            }
            if(code == 2 && anInt900 != 2)
            {
                widget.aString248 = "Please wait...";
                widget.textfieldtype = 0;
                return;
            }
            int k = amt_friendhashes;
            if(anInt900 != 2)
                k = 0;
            if(code > 700)
                code -= 601;
            else
                code--;
            if(code >= k)
            {
                widget.aString248 = "";
                widget.textfieldtype = 0;
                return;
            } else
            {
                widget.aString248 = friendusernames[code];
                widget.textfieldtype = 1;
                return;
            }
        }
        if(code >= 101 && code <= 200 || code >= 801 && code <= 900)
        {
            int l = amt_friendhashes;
            if(anInt900 != 2)
                l = 0;
            if(code > 800)
                code -= 701;
            else
                code -= 101;
            if(code >= l)
            {
                widget.aString248 = "";
                widget.textfieldtype = 0;
                return;
            }
            if(anIntArray826[code] == 0)
                widget.aString248 = "@red@Offline";
            else
            if(anIntArray826[code] == nodeid)
                widget.aString248 = "@gre@World-" + (anIntArray826[code] - 9);
            else
                widget.aString248 = "@yel@World-" + (anIntArray826[code] - 9);
            widget.textfieldtype = 1;
            return;
        }
        if(code == 203)
        {
            int i1 = amt_friendhashes;
            if(anInt900 != 2)
                i1 = 0;
            widget.anInt261 = i1 * 15 + 20;
            if(widget.anInt261 <= widget.height)
                widget.anInt261 = widget.height + 1;
            return;
        }
        if(code >= 401 && code <= 500)
        {
            if((code -= 401) == 0 && anInt900 == 0)
            {
                widget.aString248 = "Loading ignore list";
                widget.textfieldtype = 0;
                return;
            }
            if(code == 1 && anInt900 == 0)
            {
                widget.aString248 = "Please wait...";
                widget.textfieldtype = 0;
                return;
            }
            int j1 = amt_ignorehashes;
            if(anInt900 == 0)
                j1 = 0;
            if(code >= j1)
            {
                widget.aString248 = "";
                widget.textfieldtype = 0;
                return;
            } else
            {
                widget.aString248 = TextUtils.formatUsername(-45804, TextUtils.longToString(ignore_hashes[code], (byte)-99));
                widget.textfieldtype = 1;
                return;
            }
        }
        if(code == 503)
        {
            widget.anInt261 = amt_ignorehashes * 15 + 20;
            if(widget.anInt261 <= widget.height)
                widget.anInt261 = widget.height + 1;
            return;
        }
        if(code == 327)
        {
            widget.anInt270 = 150;
            widget.anInt271 = (int)(Math.sin((double)loopcycle / 40D) * 256D) & 0x7ff;
            if(aBoolean1031)
            {
                for(int k1 = 0; k1 < 7; k1++)
                {
                    int l1 = anIntArray1065[k1];
                    if(l1 >= 0 && !CharModel.charactermodels[l1].method537((byte)2))
                        return;
                }

                aBoolean1031 = false;
                Model charmodels[] = new Model[7];
                int i2 = 0;
                for(int j2 = 0; j2 < 7; j2++)
                {
                    int k2 = anIntArray1065[j2];
                    if(k2 >= 0)
                        charmodels[i2++] = CharModel.charactermodels[k2].method538(false);
                }

                Model charmodel = new Model(charmodels, i2);
                for(int l2 = 0; l2 < 5; l2++)
                    if(anIntArray990[l2] != 0)
                    {
                        charmodel.setTriangleColors(anIntArrayArray1003[l2][0], anIntArrayArray1003[l2][anIntArray990[l2]]);
                        if(l2 == 1)
                            charmodel.setTriangleColors(anIntArray1204[0], anIntArray1204[anIntArray990[l2]]);
                    }
                charmodel.setVertexTriangleGroups();
                charmodel.applyAnimationFrame(AnimSequence.animationsequences[((Mob) (localplayer)).stand_anim].anIntArray353[0]);
                charmodel.setLightingVectors(64, 850, -30, -50, -30, true);
                widget.anInt233 = 5;
                widget.anInt234 = 0;
                Widget.method208(0, aBoolean994, 5, charmodel);
            }
            return;
        }
        if(code == 324)
        {
            if(aClass30_Sub2_Sub1_Sub1_931 == null)
            {
                aClass30_Sub2_Sub1_Sub1_931 = widget.aClass30_Sub2_Sub1_Sub1_207;
                aClass30_Sub2_Sub1_Sub1_932 = widget.aClass30_Sub2_Sub1_Sub1_260;
            }
            if(aBoolean1047)
            {
                widget.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_932;
                return;
            } else
            {
                widget.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_931;
                return;
            }
        }
        if(code == 325)
        {
            if(aClass30_Sub2_Sub1_Sub1_931 == null)
            {
                aClass30_Sub2_Sub1_Sub1_931 = widget.aClass30_Sub2_Sub1_Sub1_207;
                aClass30_Sub2_Sub1_Sub1_932 = widget.aClass30_Sub2_Sub1_Sub1_260;
            }
            if(aBoolean1047)
            {
                widget.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_931;
                return;
            } else
            {
                widget.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_932;
                return;
            }
        }
        if(code == 600)
        {
            widget.aString248 = aString881;
            if(loopcycle % 20 < 10)
            {
                widget.aString248 += "|";
                return;
            } else
            {
                widget.aString248 += " ";
                return;
            }
        }
        if(code == 613)
            if(rights >= 1)
            {
                if(aBoolean1158)
                {
                    widget.anInt232 = 0xff0000;
                    widget.aString248 = "Moderator option: Mute player for 48 hours: <ON>";
                } else
                {
                    widget.anInt232 = 0xffffff;
                    widget.aString248 = "Moderator option: Mute player for 48 hours: <OFF>";
                }
            } else
            {
                widget.aString248 = "";
            }
        if(code == 650 || code == 655)
            if(anInt1193 != 0)
            {
                String s;
                if(pastlaginamountdays == 0)
                    s = "earlier today";
                else
                if(pastlaginamountdays == 1)
                    s = "yesterday";
                else
                    s = pastlaginamountdays + " days ago";
                widget.aString248 = "You last logged in " + s + " from: " + signlink.dns;
            } else
            {
                widget.aString248 = "";
            }
        if(code == 651)
        {
            if(anInt1154 == 0)
            {
                widget.aString248 = "0 unread messages";
                widget.anInt232 = 0xffff00;
            }
            if(anInt1154 == 1)
            {
                widget.aString248 = "1 unread message";
                widget.anInt232 = 65280;
            }
            if(anInt1154 > 1)
            {
                widget.aString248 = anInt1154 + " unread messages";
                widget.anInt232 = 65280;
            }
        }
        if(code == 652)
            if(anInt1167 == 201)
            {
                if(anInt1120 == 1)
                    widget.aString248 = "@yel@This is a non-members world: @whi@Since you are a member we";
                else
                    widget.aString248 = "";
            } else
            if(anInt1167 == 200)
            {
                widget.aString248 = "You have not yet set any password recovery questions.";
            } else
            {
                String s1;
                if(anInt1167 == 0)
                    s1 = "Earlier today";
                else
                if(anInt1167 == 1)
                    s1 = "Yesterday";
                else
                    s1 = anInt1167 + " days ago";
                widget.aString248 = s1 + " you changed your recovery questions";
            }
        if(code == 653)
            if(anInt1167 == 201)
            {
                if(anInt1120 == 1)
                    widget.aString248 = "@whi@recommend you use a members world instead. You may use";
                else
                    widget.aString248 = "";
            } else
            if(anInt1167 == 200)
                widget.aString248 = "We strongly recommend you do so now to secure your account.";
            else
                widget.aString248 = "If you do not remember making this change then cancel it immediately";
        if(code == 654)
        {
            if(anInt1167 == 201)
                if(anInt1120 == 1)
                {
                    widget.aString248 = "@whi@this world but member benefits are unavailable whilst here.";
                    return;
                } else
                {
                    widget.aString248 = "";
                    return;
                }
            if(anInt1167 == 200)
            {
                widget.aString248 = "Do this from the 'account management' area on our front webpage";
                return;
            }
            widget.aString248 = "Do this from the 'account management' area on our front webpage";
        }
    }

    public void method76(byte byte0)
    {
        if(anInt1195 == 0)
            return;
        RSFont class30_sub2_sub1_sub4 = p12_font;
        if(byte0 != aByte1274)
            aBoolean1231 = !aBoolean1231;
        int i = 0;
        if(anInt1104 != 0)
            i = 1;
        for(int j = 0; j < 100; j++)
            if(msgbody_stack[j] != null)
            {
                int k = msgtype_stack[j];
                String s = msgprefix_stack[j];
                byte byte1 = 0;
                if(s != null && s.startsWith("@cr1@"))
                {
                    s = s.substring(5);
                    byte1 = 1;
                }
                if(s != null && s.startsWith("@cr2@"))
                {
                    s = s.substring(5);
                    byte1 = 2;
                }
                if((k == 3 || k == 7) && (k == 7 || anInt845 == 0 || anInt845 == 1 && onFriendsList(false, s)))
                {
                    int l = 329 - i * 13;
                    int k1 = 4;
                    class30_sub2_sub1_sub4.drawText(0, "From", l, 822, k1);
                    class30_sub2_sub1_sub4.drawText(65535, "From", l - 1, 822, k1);
                    k1 += class30_sub2_sub1_sub4.widthFontMetrics(anInt1116, "From ");
                    if(byte1 == 1)
                    {
                        mod_icons[0].renderImage(k1, 16083, l - 12);
                        k1 += 14;
                    }
                    if(byte1 == 2)
                    {
                        mod_icons[1].renderImage(k1, 16083, l - 12);
                        k1 += 14;
                    }
                    class30_sub2_sub1_sub4.drawText(0, s + ": " + msgbody_stack[j], l, 822, k1);
                    class30_sub2_sub1_sub4.drawText(65535, s + ": " + msgbody_stack[j], l - 1, 822, k1);
                    if(++i >= 5)
                        return;
                }
                if(k == 5 && anInt845 < 2)
                {
                    int i1 = 329 - i * 13;
                    class30_sub2_sub1_sub4.drawText(0, msgbody_stack[j], i1, 822, 4);
                    class30_sub2_sub1_sub4.drawText(65535, msgbody_stack[j], i1 - 1, 822, 4);
                    if(++i >= 5)
                        return;
                }
                if(k == 6 && anInt845 < 2)
                {
                    int j1 = 329 - i * 13;
                    class30_sub2_sub1_sub4.drawText(0, "To " + s + ": " + msgbody_stack[j], j1, 822, 4);
                    class30_sub2_sub1_sub4.drawText(65535, "To " + s + ": " + msgbody_stack[j], j1 - 1, 822, 4);
                    if(++i >= 5)
                        return;
                }
            }

    }

    public void pushMessage(String s, int i, String s1, boolean flag)
    {
        if(flag)
            return;
        if(i == 0 && anInt1042 != -1)
        {
            aString844 = s;
            super.anInt26 = 0;
        }
        if(anInt1276 == -1)
            aBoolean1223 = true;
        for(int j = 99; j > 0; j--)
        {
            msgtype_stack[j] = msgtype_stack[j - 1];
            msgprefix_stack[j] = msgprefix_stack[j - 1];
            msgbody_stack[j] = msgbody_stack[j - 1];
        }
        msgtype_stack[0] = i;
        msgprefix_stack[0] = s1;
        msgbody_stack[0] = s;
    }

    public void handleTabClicking(int i)
    {
        i = 72 / i;
        if(super.anInt26 == 1)
        {
            if(super.curpressed_x >= 539 && super.curpressed_x <= 573 && super.curpressed_y >= 169 && super.curpressed_y < 205 && tab_interfaces[0] != -1)
            {
                aBoolean1153 = true;
                current_tab = 0;
                update_tabs = true;
            }
            if(super.curpressed_x >= 569 && super.curpressed_x <= 599 && super.curpressed_y >= 168 && super.curpressed_y < 205 && tab_interfaces[1] != -1)
            {
                aBoolean1153 = true;
                current_tab = 1;
                update_tabs = true;
            }
            if(super.curpressed_x >= 597 && super.curpressed_x <= 627 && super.curpressed_y >= 168 && super.curpressed_y < 205 && tab_interfaces[2] != -1)
            {
                aBoolean1153 = true;
                current_tab = 2;
                update_tabs = true;
            }
            if(super.curpressed_x >= 625 && super.curpressed_x <= 669 && super.curpressed_y >= 168 && super.curpressed_y < 203 && tab_interfaces[3] != -1)
            {
                aBoolean1153 = true;
                current_tab = 3;
                update_tabs = true;
            }
            if(super.curpressed_x >= 666 && super.curpressed_x <= 696 && super.curpressed_y >= 168 && super.curpressed_y < 205 && tab_interfaces[4] != -1)
            {
                aBoolean1153 = true;
                current_tab = 4;
                update_tabs = true;
            }
            if(super.curpressed_x >= 694 && super.curpressed_x <= 724 && super.curpressed_y >= 168 && super.curpressed_y < 205 && tab_interfaces[5] != -1)
            {
                aBoolean1153 = true;
                current_tab = 5;
                update_tabs = true;
            }
            if(super.curpressed_x >= 722 && super.curpressed_x <= 756 && super.curpressed_y >= 169 && super.curpressed_y < 205 && tab_interfaces[6] != -1)
            {
                aBoolean1153 = true;
                current_tab = 6;
                update_tabs = true;
            }
            if(super.curpressed_x >= 540 && super.curpressed_x <= 574 && super.curpressed_y >= 466 && super.curpressed_y < 502 && tab_interfaces[7] != -1)
            {
                aBoolean1153 = true;
                current_tab = 7;
                update_tabs = true;
            }
            if(super.curpressed_x >= 572 && super.curpressed_x <= 602 && super.curpressed_y >= 466 && super.curpressed_y < 503 && tab_interfaces[8] != -1)
            {
                aBoolean1153 = true;
                current_tab = 8;
                update_tabs = true;
            }
            if(super.curpressed_x >= 599 && super.curpressed_x <= 629 && super.curpressed_y >= 466 && super.curpressed_y < 503 && tab_interfaces[9] != -1)
            {
                aBoolean1153 = true;
                current_tab = 9;
                update_tabs = true;
            }
            if(super.curpressed_x >= 627 && super.curpressed_x <= 671 && super.curpressed_y >= 467 && super.curpressed_y < 502 && tab_interfaces[10] != -1)
            {
                aBoolean1153 = true;
                current_tab = 10;
                update_tabs = true;
            }
            if(super.curpressed_x >= 669 && super.curpressed_x <= 699 && super.curpressed_y >= 466 && super.curpressed_y < 503 && tab_interfaces[11] != -1)
            {
                aBoolean1153 = true;
                current_tab = 11;
                update_tabs = true;
            }
            if(super.curpressed_x >= 696 && super.curpressed_x <= 726 && super.curpressed_y >= 466 && super.curpressed_y < 503 && tab_interfaces[12] != -1)
            {
                aBoolean1153 = true;
                current_tab = 12;
                update_tabs = true;
            }
            if(super.curpressed_x >= 724 && super.curpressed_x <= 758 && super.curpressed_y >= 466 && super.curpressed_y < 502 && tab_interfaces[13] != -1)
            {
                aBoolean1153 = true;
                current_tab = 13;
                update_tabs = true;
            }
        }
    }

    public void method79(int i)
    {
        if(chat_imagefetcher != null)
            return;
        method118(3);
        super.aClass15_13 = null;
        logo_imagefetcher = null;
        bottomleftmid_imagefetcher = null;
        aClass15_1109 = null;
        titletopleft_imagefetcher = null;
        titletopright_imagefetcher = null;
        aClass15_1112 = null;
        aClass15_1113 = null;
        aClass15_1114 = null;
        aClass15_1115 = null;
        chat_imagefetcher = new ImageFetcher(479, 96, getDrawableComponent(0), 0);
        aClass15_1164 = new ImageFetcher(172, 156, getDrawableComponent(0), 0);
        Raster.resetOutput();
        mapback.renderImage(0, 16083, 0);
        aClass15_1163 = new ImageFetcher(190, 261, getDrawableComponent(0), 0);
        toplefttext_imagefetcher = new ImageFetcher(512, 334, getDrawableComponent(0), 0);
        Raster.resetOutput();
        toolbartext_imagefetcher = new ImageFetcher(496, 50, getDrawableComponent(0), 0);
        if(i != 1)
            loadClient();
        aClass15_1124 = new ImageFetcher(269, 37, getDrawableComponent(0), 0);
        aClass15_1125 = new ImageFetcher(249, 45, getDrawableComponent(0), 0);
        aBoolean1255 = true;
    }

    public String method80(boolean flag)
    {
        aBoolean1157 &= flag;
        if(signlink.mainapp != null)
            return signlink.mainapp.getDocumentBase().getHost().toLowerCase();
        if(super.rs_frame != null)
            return "runescape.com";
        else
            return super.getDocumentBase().getHost().toLowerCase();
    }

    public void method81(DirectColorSprite class30_sub2_sub1_sub1, int i, int j, int k)
    {
        int l = k * k + j * j;
        if(i >= 0)
            loadClient();
        if(l > 4225 && l < 0x15f90)
        {
            int yaw = camerayaw + anInt1209 & 0x7ff;
            int sine = Model.sinetable[yaw];
            int cosine = Model.cosinetable[yaw];
            sine = (sine * 256) / (anInt1170 + 256);
            cosine = (cosine * 256) / (anInt1170 + 256);
            int l1 = j * sine + k * cosine >> 16;
            int i2 = j * cosine - k * sine >> 16;
            double d = Math.atan2(l1, i2);
            int j2 = (int)(Math.sin(d) * 63D);
            int k2 = (int)(Math.cos(d) * 57D);
            mapedge.drawRotatedRadians(83 - k2 - 20, 15, 20, 15, 41960, 256, 20, d, (94 + j2 + 4) - 10);
            return;
        } else
        {
            drawOnMinimap(class30_sub2_sub1_sub1, k, j, false);
            return;
        }
    }

    public void method82(int i)
    {
        if(anInt1086 != 0)
            return;
        interfacestringstack[0] = "Cancel";
        interfaceopcodestack[0] = 1107;
        anInt1133 = 1;
        method129(false);
        anInt886 = 0;
        if(super.mouse_x > 4 && super.mouse_y > 4 && super.mouse_x < 516 && super.mouse_y < 338)
            if(anInt857 != -1)
                handleInterfaceOptions(4, 13037, Widget.widgets[anInt857], super.mouse_x, 4, super.mouse_y, 0);
            else
                method71(33660);
        if(anInt886 != anInt1026)
            anInt1026 = anInt886;
        anInt886 = 0;
        if(super.mouse_x > 553 && super.mouse_y > 205 && super.mouse_x < 743 && super.mouse_y < 466)
            if(anInt1189 != -1)
                handleInterfaceOptions(553, 13037, Widget.widgets[anInt1189], super.mouse_x, 205, super.mouse_y, 0);
            else
            if(tab_interfaces[current_tab] != -1)
                handleInterfaceOptions(553, 13037, Widget.widgets[tab_interfaces[current_tab]], super.mouse_x, 205, super.mouse_y, 0);
        if(anInt886 != anInt1048)
        {
            aBoolean1153 = true;
            anInt1048 = anInt886;
        }
        anInt886 = 0;
        if(super.mouse_x > 17 && super.mouse_y > 357 && super.mouse_x < 496 && super.mouse_y < 453)
            if(anInt1276 != -1)
                handleInterfaceOptions(17, 13037, Widget.widgets[anInt1276], super.mouse_x, 357, super.mouse_y, 0);
            else
            if(super.mouse_y < 434 && super.mouse_x < 426)
                method74(super.mouse_x - 17, super.mouse_y - 357, 9);
        if(anInt1276 != -1 && anInt886 != anInt1039)
        {
            aBoolean1223 = true;
            anInt1039 = anInt886;
        }
        boolean flag = false;
        packetsize += i;
        while(!flag) 
        {
            flag = true;
            for(int j = 0; j < anInt1133 - 1; j++)
                if(interfaceopcodestack[j] < 1000 && interfaceopcodestack[j + 1] > 1000)
                {
                    String s = interfacestringstack[j];
                    interfacestringstack[j] = interfacestringstack[j + 1];
                    interfacestringstack[j + 1] = s;
                    int k = interfaceopcodestack[j];
                    interfaceopcodestack[j] = interfaceopcodestack[j + 1];
                    interfaceopcodestack[j + 1] = k;
                    k = interfacestack_a[j];
                    interfacestack_a[j] = interfacestack_a[j + 1];
                    interfacestack_a[j + 1] = k;
                    k = interfacestack_b[j];
                    interfacestack_b[j] = interfacestack_b[j + 1];
                    interfacestack_b[j + 1] = k;
                    k = interfacestack_c[j];
                    interfacestack_c[j] = interfacestack_c[j + 1];
                    interfacestack_c[j + 1] = k;
                    flag = false;
                }

        }
    }

    public int method83(boolean junk, int i, int j, int k)
    {
		/* Remove bits from byte */
        int l = 256 - k;
        return ((i & 0xff00ff) * l + (j & 0xff00ff) * k & 0xff00ff00) + ((i & 0xff00) * l + (j & 0xff00) * k & 0xff0000) >> 8;
    }

    public void login(String s, String s1, boolean flag)
    {
        signlink.errorname = s;
        try
        {
            if(!flag)
            {
                aString1266 = "";
                aString1267 = "Connecting to server...";
                drawTitleScreen(true, false);
            }
            gameserver_sockethandler = new SocketHandler(this, -978, spawnSocket(43594 + portoff));
            long l = TextUtils.stringToLong(s);
            int i = (int)(l >> 16 & 31L);
            packetbuffer.position = 0;
            packetbuffer.put(14);
            packetbuffer.put(i);
            gameserver_sockethandler.writeBytes(2, 0, packetbuffer.payload, 0);
            /* for(int j = 0; j < 8; j++)
                gameserver_sockethandler.method268(); */
            int k = gameserver_sockethandler.method268();
            int i1 = k;
            if(k == 0)
            {
                gameserver_sockethandler.readBytes(inbuffer.payload, 0, 8);
                inbuffer.position = 0;
                ssk = inbuffer.getLong(-35089);
                int seeds[] = new int[4];
                seeds[0] = (int)(Math.random() * 99999999D);
                seeds[1] = (int)(Math.random() * 99999999D);
                seeds[2] = (int)(ssk >> 32);
                seeds[3] = (int)ssk;
                packetbuffer.position = 0;
                packetbuffer.put(10);
                packetbuffer.putInt(seeds[0]);
                packetbuffer.putInt(seeds[1]);
                packetbuffer.putInt(seeds[2]);
                packetbuffer.putInt(seeds[3]);
                packetbuffer.putInt(signlink.uid);
                packetbuffer.putCStr(s);
                packetbuffer.putCStr(s1);
                packetbuffer.applyRSA(aBigInteger1032, aBigInteger856, (byte)0);
                loginbuffer.position = 0;
                if(flag)
                    loginbuffer.put(18);
                else
                    loginbuffer.put(16);
                loginbuffer.put(packetbuffer.position + 36 + 1 + 1 + 2);
                loginbuffer.put(255);
                loginbuffer.putShort(317);
                loginbuffer.put(lowmemory ? 1 : 0);
                for(int l1 = 0; l1 < 9; l1++)
                    loginbuffer.putInt(cacheidx_crcs[l1]);

                loginbuffer.put(packetbuffer.payload, packetbuffer.position, true, 0);
                packetbuffer.encryption = new ISAAC(seeds);
                for(int j2 = 0; j2 < 4; j2++)
                    seeds[j2] += 50;
                packetencryption = new ISAAC(seeds);
                gameserver_sockethandler.writeBytes(loginbuffer.position, 0, loginbuffer.payload, 0);
                k = gameserver_sockethandler.method268();
            }
            if(k == 1)
            {
                try
                {
                    Thread.sleep(2000L);
                }
                catch(Exception _ex) { }
                login(s, s1, flag);
                return;
            }
            if(k == 2)
            {
                rights = gameserver_sockethandler.method268();
                flagged = gameserver_sockethandler.method268() == 1;
                lastpressed_t = 0L;
                anInt1022 = 0;
                watchdog.position = 0;
                super.aBoolean17 = true;
                aBoolean954 = true;
                aBoolean1157 = true;
                packetbuffer.position = 0;
                inbuffer.position = 0;
                packetnum = -1;
                anInt841 = -1;
                anInt842 = -1;
                anInt843 = -1;
                packetsize = 0;
                anInt1009 = 0;
                anInt1104 = 0;
                anInt1011 = 0;
                markertype = 0;
                anInt1133 = 0;
                aBoolean885 = false;
                super.idle_counter = 0;
                for(int j1 = 0; j1 < 100; j1++)
                    msgbody_stack[j1] = null;
                anInt1282 = 0;
                anInt1136 = 0;
                landscape_stage = 0;
                anInt1062 = 0;
                anInt1278 = (int)(Math.random() * 100D) - 50;
                anInt1131 = (int)(Math.random() * 110D) - 55;
                anInt896 = (int)(Math.random() * 80D) - 40;
                anInt1209 = (int)(Math.random() * 120D) - 60;
                anInt1170 = (int)(Math.random() * 30D) - 20;
                camerayaw = (int)(Math.random() * 20D) - 10 & 0x7ff;
                anInt1021 = 0;
                anInt985 = -1;
                anInt1261 = 0;
                anInt1262 = 0;
                anInt891 = 0;
                anInt836 = 0;
                for(int i2 = 0; i2 < maxplayers; i2++)
                {
                    players[i2] = null;
                    appearancebuffers[i2] = null;
                }

                for(int k2 = 0; k2 < 16384; k2++)
                    npcs[k2] = null;

                localplayer = players[localindex] = new Player();
                aClass19_1013.clear();
                gfxs_storage.clear();
                for(int l2 = 0; l2 < 4; l2++)
                {
                    for(int i3 = 0; i3 < 104; i3++)
                    {
                        for(int k3 = 0; k3 < 104; k3++)
                            grounditems[l2][i3][k3] = null;

                    }

                }

                aClass19_1179 = new Deque(169);
                anInt900 = 0;
                amt_friendhashes = 0;
                anInt1042 = -1;
                anInt1276 = -1;
                anInt857 = -1;
                anInt1189 = -1;
                anInt1018 = -1;
                aBoolean1149 = false;
                current_tab = 3;
                anInt1225 = 0;
                aBoolean885 = false;
                aBoolean1256 = false;
                aString844 = null;
                anInt1055 = 0;
                anInt1054 = -1;
                aBoolean1047 = true;
                method45(0);
                for(int j3 = 0; j3 < 5; j3++)
                    anIntArray990[j3] = 0;

                for(int l3 = 0; l3 < 5; l3++)
                {
                    aStringArray1127[l3] = null;
                    aBooleanArray1128[l3] = false;
                }

                anInt1175 = 0;
                anInt1134 = 0;
                anInt986 = 0;
                stepcounters = 0;
                anInt924 = 0;
                anInt1188 = 0;
                anInt1155 = 0;
                anInt1226 = 0;
                anInt941 = 0;
                anInt1260 = 0;
                method79(1);
                return;
            }
            if(k == 3)
            {
                aString1266 = "";
                aString1267 = "Invalid username or password.";
                return;
            }
            if(k == 4)
            {
                aString1266 = "Your account has been disabled.";
                aString1267 = "Please check your message-centre for details.";
                return;
            }
            if(k == 5)
            {
                aString1266 = "Your account is already logged in.";
                aString1267 = "Try again in 60 secs...";
                return;
            }
            if(k == 6)
            {
                aString1266 = "RuneScape has been updated!";
                aString1267 = "Please reload this page.";
                return;
            }
            if(k == 7)
            {
                aString1266 = "This world is full.";
                aString1267 = "Please use a different world.";
                return;
            }
            if(k == 8)
            {
                aString1266 = "Unable to connect.";
                aString1267 = "Login server offline.";
                return;
            }
            if(k == 9)
            {
                aString1266 = "Login limit exceeded.";
                aString1267 = "Too many connections from your address.";
                return;
            }
            if(k == 10)
            {
                aString1266 = "Unable to connect.";
                aString1267 = "Bad session id.";
                return;
            }
            if(k == 11)
            {
                aString1267 = "Login server rejected session.";
                aString1267 = "Please try again.";
                return;
            }
            if(k == 12)
            {
                aString1266 = "You need a members account to login to this world.";
                aString1267 = "Please subscribe, or use a different world.";
                return;
            }
            if(k == 13)
            {
                aString1266 = "Could not complete login.";
                aString1267 = "Please try using a different world.";
                return;
            }
            if(k == 14)
            {
                aString1266 = "The server is being updated.";
                aString1267 = "Please wait 1 minute and try again.";
                return;
            }
            if(k == 15)
            {
                aBoolean1157 = true;
                packetbuffer.position = 0;
                inbuffer.position = 0;
                packetnum = -1;
                anInt841 = -1;
                anInt842 = -1;
                anInt843 = -1;
                packetsize = 0;
                anInt1009 = 0;
                anInt1104 = 0;
                anInt1133 = 0;
                aBoolean885 = false;
                aLong824 = System.currentTimeMillis();
                return;
            }
            if(k == 16)
            {
                aString1266 = "Login attempts exceeded.";
                aString1267 = "Please wait 1 minute and try again.";
                return;
            }
            if(k == 17)
            {
                aString1266 = "You are standing in a members-only area.";
                aString1267 = "To play on this world move to a free area first";
                return;
            }
            if(k == 20)
            {
                aString1266 = "Invalid loginserver requested";
                aString1267 = "Please try using a different world.";
                return;
            }
            if(k == 21)
            {
                for(int k1 = gameserver_sockethandler.method268(); k1 >= 0; k1--)
                {
                    aString1266 = "You have only just left another world";
                    aString1267 = "Your profile will be transferred in: " + k1 + " seconds";
                    drawTitleScreen(true, false);
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(Exception _ex) { }
                }

                login(s, s1, flag);
                return;
            }
            if(k == -1)
            {
                if(i1 == 0)
                {
                    if(anInt1038 < 2)
                    {
                        try
                        {
                            Thread.sleep(2000L);
                        }
                        catch(Exception _ex) { }
                        anInt1038++;
                        login(s, s1, flag);
                        return;
                    } else
                    {
                        aString1266 = "No response from loginserver";
                        aString1267 = "Please wait 1 minute and try again.";
                        return;
                    }
                } else
                {
                    aString1266 = "No response from server";
                    aString1267 = "Please try using a different world.";
                    return;
                }
            } else
            {
                System.out.println("response:" + k);
                aString1266 = "Unexpected server response";
                aString1267 = "Please try using a different world.";
                return;
            }
        }
        catch(IOException _ex)
        {
            aString1266 = "";
        }
        aString1267 = "Error connecting to server.";
    }

    public boolean sendWalkPacket(int type, int j, int k, int l, int i1, int j1, int k1,
            int l1, int i2, int j2, boolean flag, int k2)
    {
        byte w = 104;
        byte h = 104;
        for(int l2 = 0; l2 < w; l2++)
        {
            for(int i3 = 0; i3 < h; i3++)
            {
                anIntArrayArray901[l2][i3] = 0;
                distancestrength[l2][i3] = 0x5f5e0ff;
            }

        }

        int stepx = j2;
        int stepy = j1;
        anIntArrayArray901[j2][j1] = 99;
        distancestrength[j2][j1] = 0;
        int steppos = 0;
        int stepoff = 0;
        walkingstepsx[steppos] = j2;
        walkingstepsy[steppos++] = j1;
        boolean flag1 = false;
        int steparrsize = walkingstepsx.length;
        int ai[][] = collisionmaps[cheight].index;
        while(stepoff != steppos)
        {
            stepx = walkingstepsx[stepoff];
            stepy = walkingstepsy[stepoff];
            stepoff = (stepoff + 1) % steparrsize;
            if(stepx == k2 && stepy == i2)
            {
                flag1 = true;
                break;
            }
            if(i1 != 0)
            {
                if((i1 < 5 || i1 == 10) && collisionmaps[cheight].method219(k2, stepx, stepy, 0, j, i1 - 1, i2))
                {
                    flag1 = true;
                    break;
                }
                if(i1 < 10 && collisionmaps[cheight].method220(k2, i2, stepy, i1 - 1, j, stepx, 0))
                {
                    flag1 = true;
                    break;
                }
            }
            if(k1 != 0 && k != 0 && collisionmaps[cheight].method221((byte)1, i2, k2, stepx, k, l1, k1, stepy))
            {
                flag1 = true;
                break;
            }
            int l4 = distancestrength[stepx][stepy] + 1;
            if(stepx > 0 && anIntArrayArray901[stepx - 1][stepy] == 0 && (ai[stepx - 1][stepy] & 0x1280108) == 0)
            {
                walkingstepsx[steppos] = stepx - 1;
                walkingstepsy[steppos] = stepy;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx - 1][stepy] = 2;
                distancestrength[stepx - 1][stepy] = l4;
            }
            if(stepx < w - 1 && anIntArrayArray901[stepx + 1][stepy] == 0 && (ai[stepx + 1][stepy] & 0x1280180) == 0)
            {
                walkingstepsx[steppos] = stepx + 1;
                walkingstepsy[steppos] = stepy;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx + 1][stepy] = 8;
                distancestrength[stepx + 1][stepy] = l4;
            }
            if(stepy > 0 && anIntArrayArray901[stepx][stepy - 1] == 0 && (ai[stepx][stepy - 1] & 0x1280102) == 0)
            {
                walkingstepsx[steppos] = stepx;
                walkingstepsy[steppos] = stepy - 1;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx][stepy - 1] = 1;
                distancestrength[stepx][stepy - 1] = l4;
            }
            if(stepy < h - 1 && anIntArrayArray901[stepx][stepy + 1] == 0 && (ai[stepx][stepy + 1] & 0x1280120) == 0)
            {
                walkingstepsx[steppos] = stepx;
                walkingstepsy[steppos] = stepy + 1;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx][stepy + 1] = 4;
                distancestrength[stepx][stepy + 1] = l4;
            }
            if(stepx > 0 && stepy > 0 && anIntArrayArray901[stepx - 1][stepy - 1] == 0 && (ai[stepx - 1][stepy - 1] & 0x128010e) == 0 && (ai[stepx - 1][stepy] & 0x1280108) == 0 && (ai[stepx][stepy - 1] & 0x1280102) == 0)
            {
                walkingstepsx[steppos] = stepx - 1;
                walkingstepsy[steppos] = stepy - 1;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx - 1][stepy - 1] = 3;
                distancestrength[stepx - 1][stepy - 1] = l4;
            }
            if(stepx < w - 1 && stepy > 0 && anIntArrayArray901[stepx + 1][stepy - 1] == 0 && (ai[stepx + 1][stepy - 1] & 0x1280183) == 0 && (ai[stepx + 1][stepy] & 0x1280180) == 0 && (ai[stepx][stepy - 1] & 0x1280102) == 0)
            {
                walkingstepsx[steppos] = stepx + 1;
                walkingstepsy[steppos] = stepy - 1;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx + 1][stepy - 1] = 9;
                distancestrength[stepx + 1][stepy - 1] = l4;
            }
            if(stepx > 0 && stepy < h - 1 && anIntArrayArray901[stepx - 1][stepy + 1] == 0 && (ai[stepx - 1][stepy + 1] & 0x1280138) == 0 && (ai[stepx - 1][stepy] & 0x1280108) == 0 && (ai[stepx][stepy + 1] & 0x1280120) == 0)
            {
                walkingstepsx[steppos] = stepx - 1;
                walkingstepsy[steppos] = stepy + 1;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx - 1][stepy + 1] = 6;
                distancestrength[stepx - 1][stepy + 1] = l4;
            }
            if(stepx < w - 1 && stepy < h - 1 && anIntArrayArray901[stepx + 1][stepy + 1] == 0 && (ai[stepx + 1][stepy + 1] & 0x12801e0) == 0 && (ai[stepx + 1][stepy] & 0x1280180) == 0 && (ai[stepx][stepy + 1] & 0x1280120) == 0)
            {
                walkingstepsx[steppos] = stepx + 1;
                walkingstepsy[steppos] = stepy + 1;
                steppos = (steppos + 1) % steparrsize;
                anIntArrayArray901[stepx + 1][stepy + 1] = 12;
                distancestrength[stepx + 1][stepy + 1] = l4;
            }
        }
        anInt1264 = 0;
        if(!flag1)
        {
            if(flag)
            {
                int i5 = 100;
                for(int k5 = 1; k5 < 2; k5++)
                {
                    for(int i6 = k2 - k5; i6 <= k2 + k5; i6++)
                    {
                        for(int l6 = i2 - k5; l6 <= i2 + k5; l6++)
                            if(i6 >= 0 && l6 >= 0 && i6 < 104 && l6 < 104 && distancestrength[i6][l6] < i5)
                            {
                                i5 = distancestrength[i6][l6];
                                stepx = i6;
                                stepy = l6;
                                anInt1264 = 1;
                                flag1 = true;
                            }

                    }

                    if(flag1)
                        break;
                }

            }
            if(!flag1)
                return false;
        }
        stepoff = 0;
        walkingstepsx[stepoff] = stepx;
        walkingstepsy[stepoff++] = stepy;
        int l5;
        for(int j5 = l5 = anIntArrayArray901[stepx][stepy]; stepx != j2 || stepy != j1; j5 = anIntArrayArray901[stepx][stepy])
        {
            if(j5 != l5)
            {
                l5 = j5;
                walkingstepsx[stepoff] = stepx;
                walkingstepsy[stepoff++] = stepy;
            }
            if((j5 & 2) != 0)
                stepx++;
            else
            if((j5 & 8) != 0)
                stepx--;
            if((j5 & 1) != 0)
                stepy++;
            else
            if((j5 & 4) != 0)
                stepy--;
        }

        if(stepoff > 0)
        {
            int amtsteps = stepoff;
            if(amtsteps > 25)
                amtsteps = 25;
            stepoff--;
            int k6 = walkingstepsx[stepoff];
            int i7 = walkingstepsy[stepoff];
            stepcounters += amtsteps;
            if(stepcounters >= 92)
            {
                packetbuffer.putPacket(36);
                packetbuffer.putInt(0);
                stepcounters = 0;
            }
            if(type == 0)
            {
                packetbuffer.putPacket(164);
                packetbuffer.put(amtsteps + amtsteps + 3);
            }
            if(type == 1)
            {
                packetbuffer.putPacket(248);
                packetbuffer.put(amtsteps + amtsteps + 3 + 14);
            }
            if(type == 2)
            {
                packetbuffer.putPacket(98);
                packetbuffer.put(amtsteps + amtsteps + 3);
            }
            packetbuffer.putShortLE128(0, k6 + palettex);
            anInt1261 = walkingstepsx[0];
            anInt1262 = walkingstepsy[0];
            for(int j7 = 1; j7 < amtsteps; j7++)
            {
                stepoff--;
                packetbuffer.put(walkingstepsx[stepoff] - k6);
                packetbuffer.put(walkingstepsy[stepoff] - i7);
            }

            packetbuffer.putShortLE_(true, i7 + palettey);
            packetbuffer.putSpecialA(super.active_keycodes[5] != 1 ? 0 : 1, 0);
            return true;
        }
        return type != 1;
    }

    public void parseNpcUpdateMasks(int i, Buffer buffer0, boolean flag)
    {
        for(int j = 0; j < amtplayerupdatestack; j++)
        {
            int k = playerupdate_stack[j];
            NPC class30_sub2_sub4_sub1_sub1 = npcs[k];
            int l = buffer0.getUByte();
			/* Animation */
            if((l & 0x10) != 0)
            {
                int i1 = buffer0.getShortLE((byte)108);
                if(i1 == 65535)
                    i1 = -1;
                int i2 = buffer0.getUByte();
                if(i1 == ((Mob) (class30_sub2_sub4_sub1_sub1)).animid_request && i1 != -1)
                {
                    int l2 = AnimSequence.animationsequences[i1].anInt365;
                    if(l2 == 1)
                    {
                        class30_sub2_sub4_sub1_sub1.anInt1527 = 0;
                        class30_sub2_sub4_sub1_sub1.anInt1528 = 0;
                        class30_sub2_sub4_sub1_sub1.animdelay_request = i2;
                        class30_sub2_sub4_sub1_sub1.anInt1530 = 0;
                    }
                    if(l2 == 2)
                        class30_sub2_sub4_sub1_sub1.anInt1530 = 0;
                } else
                if(i1 == -1 || ((Mob) (class30_sub2_sub4_sub1_sub1)).animid_request == -1 || AnimSequence.animationsequences[i1].anInt359 >= AnimSequence.animationsequences[((Mob) (class30_sub2_sub4_sub1_sub1)).animid_request].anInt359)
                {
                    class30_sub2_sub4_sub1_sub1.animid_request = i1;
                    class30_sub2_sub4_sub1_sub1.anInt1527 = 0;
                    class30_sub2_sub4_sub1_sub1.anInt1528 = 0;
                    class30_sub2_sub4_sub1_sub1.animdelay_request = i2;
                    class30_sub2_sub4_sub1_sub1.anInt1530 = 0;
                    class30_sub2_sub4_sub1_sub1.anInt1542 = ((Mob) (class30_sub2_sub4_sub1_sub1)).stack_position_mob;
                }
            }
            if((l & 8) != 0)
            {
                int j1 = buffer0.getUByte128(0);
                int j2 = buffer0.getUSpecialA(false);
                class30_sub2_sub4_sub1_sub1.pushHit(-35698, j2, j1, loopcycle);
                class30_sub2_sub4_sub1_sub1.anInt1532 = loopcycle + 300;
                class30_sub2_sub4_sub1_sub1.anInt1533 = buffer0.getUByte128(0);
                class30_sub2_sub4_sub1_sub1.anInt1534 = buffer0.getUByte();
            }
            if((l & 0x80) != 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1520 = buffer0.getShort();
                int k1 = buffer0.getInt();
                class30_sub2_sub4_sub1_sub1.anInt1524 = k1 >> 16;
                class30_sub2_sub4_sub1_sub1.anInt1523 = loopcycle + (k1 & 0xffff);
                class30_sub2_sub4_sub1_sub1.anInt1521 = 0;
                class30_sub2_sub4_sub1_sub1.anInt1522 = 0;
                if(((Mob) (class30_sub2_sub4_sub1_sub1)).anInt1523 > loopcycle)
                    class30_sub2_sub4_sub1_sub1.anInt1521 = -1;
                if(((Mob) (class30_sub2_sub4_sub1_sub1)).anInt1520 == 65535)
                    class30_sub2_sub4_sub1_sub1.anInt1520 = -1;
            }
            if((l & 0x20) != 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1502 = buffer0.getShort();
                if(((Mob) (class30_sub2_sub4_sub1_sub1)).anInt1502 == 65535)
                    class30_sub2_sub4_sub1_sub1.anInt1502 = -1;
            }
            if((l & 1) != 0)
            {
                class30_sub2_sub4_sub1_sub1.chat_txt = buffer0.getCStr();
                class30_sub2_sub4_sub1_sub1.anInt1535 = 100;
            }
            if((l & 0x40) != 0)
            {
                int l1 = buffer0.getUSpecialA(false);
                int k2 = buffer0.getUSpecialB(2);
                class30_sub2_sub4_sub1_sub1.pushHit(-35698, k2, l1, loopcycle);
                class30_sub2_sub4_sub1_sub1.anInt1532 = loopcycle + 300;
                class30_sub2_sub4_sub1_sub1.anInt1533 = buffer0.getUSpecialB(2);
                class30_sub2_sub4_sub1_sub1.anInt1534 = buffer0.getUSpecialA(false);
            }
			/* Switch NPC */
            if((l & 2) != 0)
            {
                class30_sub2_sub4_sub1_sub1.definition = NPCDefinition.getNPCDefinition(buffer0.getShortLE128((byte)-74));
                class30_sub2_sub4_sub1_sub1.halftile_offsets = class30_sub2_sub4_sub1_sub1.definition.npc_halftileoffsets;
                class30_sub2_sub4_sub1_sub1.rotation = class30_sub2_sub4_sub1_sub1.definition.spawndirection;
                class30_sub2_sub4_sub1_sub1.walk_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_walkanim;
                class30_sub2_sub4_sub1_sub1.turn180_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_turn180anim;
                class30_sub2_sub4_sub1_sub1.turn90cw_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_turn90cw;
                class30_sub2_sub4_sub1_sub1.turn90ccw_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_turn90ccw;
                class30_sub2_sub4_sub1_sub1.stand_anim = class30_sub2_sub4_sub1_sub1.definition.npcdef_standanim;
            }
            if((l & 4) != 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1538 = buffer0.getShortLE((byte)108);
                class30_sub2_sub4_sub1_sub1.anInt1539 = buffer0.getShortLE((byte)108);
            }
        }

        aBoolean1157 &= flag;
    }

    public void method87(NPCDefinition class5, int i, boolean flag, int j, int k)
    {
        if(anInt1133 >= 400)
            return;
        if(class5.confignpcs != null)
            class5 = class5.method161(anInt877);
        if(class5 == null)
            return;
        if(!class5.isvisible)
            return;
        String s = class5.name;
        if(flag)
            aBoolean919 = !aBoolean919;
        if(class5.level != 0)
            s = s + getLevelColor(localplayer.combatlevel, class5.level, true) + " (level-" + class5.level + ")";
        if(anInt1282 == 1)
        {
            interfacestringstack[anInt1133] = "Use " + aString1286 + " with @yel@" + s;
            interfaceopcodestack[anInt1133] = 582;
            interfacestack_c[anInt1133] = i;
            interfacestack_a[anInt1133] = k;
            interfacestack_b[anInt1133] = j;
            anInt1133++;
            return;
        }
        if(anInt1136 == 1)
        {
            if((anInt1138 & 2) == 2)
            {
                interfacestringstack[anInt1133] = aString1139 + " @yel@" + s;
                interfaceopcodestack[anInt1133] = 413;
                interfacestack_c[anInt1133] = i;
                interfacestack_a[anInt1133] = k;
                interfacestack_b[anInt1133] = j;
                anInt1133++;
                return;
            }
        } else
        {
            if(class5.options != null)
            {
                for(int l = 4; l >= 0; l--)
                    if(class5.options[l] != null && !class5.options[l].equalsIgnoreCase("attack"))
                    {
                        interfacestringstack[anInt1133] = class5.options[l] + " @yel@" + s;
                        if(l == 0)
                            interfaceopcodestack[anInt1133] = 20;
                        if(l == 1)
                            interfaceopcodestack[anInt1133] = 412;
                        if(l == 2)
                            interfaceopcodestack[anInt1133] = 225;
                        if(l == 3)
                            interfaceopcodestack[anInt1133] = 965;
                        if(l == 4)
                            interfaceopcodestack[anInt1133] = 478;
                        interfacestack_c[anInt1133] = i;
                        interfacestack_a[anInt1133] = k;
                        interfacestack_b[anInt1133] = j;
                        anInt1133++;
                    }

            }
            if(class5.options != null)
            {
                for(int i1 = 4; i1 >= 0; i1--)
                    if(class5.options[i1] != null && class5.options[i1].equalsIgnoreCase("attack"))
                    {
                        char c = '\0';
                        if(class5.level > localplayer.combatlevel)
                            c = '\u07D0';
                        interfacestringstack[anInt1133] = class5.options[i1] + " @yel@" + s;
                        if(i1 == 0)
                            interfaceopcodestack[anInt1133] = 20 + c;
                        if(i1 == 1)
                            interfaceopcodestack[anInt1133] = 412 + c;
                        if(i1 == 2)
                            interfaceopcodestack[anInt1133] = 225 + c;
                        if(i1 == 3)
                            interfaceopcodestack[anInt1133] = 965 + c;
                        if(i1 == 4)
                            interfaceopcodestack[anInt1133] = 478 + c;
                        interfacestack_c[anInt1133] = i;
                        interfacestack_a[anInt1133] = k;
                        interfacestack_b[anInt1133] = j;
                        anInt1133++;
                    }

            }
            interfacestringstack[anInt1133] = "Examine @yel@" + s;
            interfaceopcodestack[anInt1133] = 1025;
            interfacestack_c[anInt1133] = i;
            interfacestack_a[anInt1133] = k;
            interfacestack_b[anInt1133] = j;
            anInt1133++;
        }
    }

    public void method88(int i, int j, Player class30_sub2_sub4_sub1_sub2, boolean flag, int k)
    {
        if(class30_sub2_sub4_sub1_sub2 == localplayer)
            return;
        if(anInt1133 >= 400)
            return;
        if(flag)
            return;
        String s;
        if(class30_sub2_sub4_sub1_sub2.skilltotal == 0)
            s = class30_sub2_sub4_sub1_sub2.name + getLevelColor(localplayer.combatlevel, class30_sub2_sub4_sub1_sub2.combatlevel, true) + " (level-" + class30_sub2_sub4_sub1_sub2.combatlevel + ")";
        else
            s = class30_sub2_sub4_sub1_sub2.name + " (skill-" + class30_sub2_sub4_sub1_sub2.skilltotal + ")";
        if(anInt1282 == 1)
        {
            interfacestringstack[anInt1133] = "Use " + aString1286 + " with @whi@" + s;
            interfaceopcodestack[anInt1133] = 491;
            interfacestack_c[anInt1133] = j;
            interfacestack_a[anInt1133] = i;
            interfacestack_b[anInt1133] = k;
            anInt1133++;
        } else
        if(anInt1136 == 1)
        {
            if((anInt1138 & 8) == 8)
            {
                interfacestringstack[anInt1133] = aString1139 + " @whi@" + s;
                interfaceopcodestack[anInt1133] = 365;
                interfacestack_c[anInt1133] = j;
                interfacestack_a[anInt1133] = i;
                interfacestack_b[anInt1133] = k;
                anInt1133++;
            }
        } else
        {
            for(int l = 4; l >= 0; l--)
                if(aStringArray1127[l] != null)
                {
                    interfacestringstack[anInt1133] = aStringArray1127[l] + " @whi@" + s;
                    char c = '\0';
                    if(aStringArray1127[l].equalsIgnoreCase("attack"))
                    {
                        if(class30_sub2_sub4_sub1_sub2.combatlevel > localplayer.combatlevel)
                            c = '\u07D0';
                        if(localplayer.anInt1701 != 0 && class30_sub2_sub4_sub1_sub2.anInt1701 != 0)
                            if(localplayer.anInt1701 == class30_sub2_sub4_sub1_sub2.anInt1701)
                                c = '\u07D0';
                            else
                                c = '\0';
                    } else
                    if(aBooleanArray1128[l])
                        c = '\u07D0';
                    if(l == 0)
                        interfaceopcodestack[anInt1133] = 561 + c;
                    if(l == 1)
                        interfaceopcodestack[anInt1133] = 779 + c;
                    if(l == 2)
                        interfaceopcodestack[anInt1133] = 27 + c;
                    if(l == 3)
                        interfaceopcodestack[anInt1133] = 577 + c;
                    if(l == 4)
                        interfaceopcodestack[anInt1133] = 729 + c;
                    interfacestack_c[anInt1133] = j;
                    interfacestack_a[anInt1133] = i;
                    interfacestack_b[anInt1133] = k;
                    anInt1133++;
                }

        }
        for(int i1 = 0; i1 < anInt1133; i1++)
            if(interfaceopcodestack[i1] == 516)
            {
                interfacestringstack[i1] = "Walk here @whi@" + s;
                return;
            }

    }

    public void method89(boolean flag, SpawnedObject class30_sub1)
    {
        int i = 0;
        int j = -1;
        int k = 0;
        int l = 0;
        if(class30_sub1.type_num == 0)
            i = pallet.method300(class30_sub1.cheight, class30_sub1.pallete_x, class30_sub1.pallete_y);
        if(class30_sub1.type_num == 1)
            i = pallet.method301(class30_sub1.cheight, class30_sub1.pallete_x, 0, class30_sub1.pallete_y);
        if(class30_sub1.type_num == 2)
            i = pallet.method302(class30_sub1.cheight, class30_sub1.pallete_x, class30_sub1.pallete_y);
        if(class30_sub1.type_num == 3)
            i = pallet.method303(class30_sub1.cheight, class30_sub1.pallete_x, class30_sub1.pallete_y);
        if(i != 0)
        {
            int i1 = pallet.method304(class30_sub1.cheight, class30_sub1.pallete_x, class30_sub1.pallete_y, i);
            j = i >> 14 & 0x7fff;
            k = i1 & 0x1f;
            l = i1 >> 6;
        }
        class30_sub1.anInt1299 = j;
        class30_sub1.anInt1301 = k;
        if(flag)
        {
            for(int j1 = 1; j1 > 0; j1++);
        }
        class30_sub1.anInt1300 = l;
    }

    public void updateSounds_(boolean flag)
    {
        if(flag)
            packetnum = -1;
        for(int i = 0; i < anInt1062; i++)
            if(anIntArray1250[i] <= 0)
            {
                boolean flag1 = false;
                try
                {
                    if(anIntArray1207[i] == anInt874 && anIntArray1241[i] == anInt1289)
                    {
                        if(!waveReplay(11456))
                            flag1 = true;
                    } else
                    {
                        Buffer buffer0 = Sound.method241(anIntArray1241[i], anIntArray1207[i], false);
                        if(System.currentTimeMillis() + (long)(buffer0.position / 22) > aLong1172 + (long)(anInt1257 / 22))
                        {
                            anInt1257 = buffer0.position;
                            aLong1172 = System.currentTimeMillis();
                            if(method59(buffer0.payload, (byte)116, buffer0.position))
                            {
                                anInt874 = anIntArray1207[i];
                                anInt1289 = anIntArray1241[i];
                            } else
                            {
                                flag1 = true;
                            }
                        }
                    }
                }
                catch(Exception exception) { }
                if(!flag1 || anIntArray1250[i] == -5)
                {
                    anInt1062--;
                    for(int j = i; j < anInt1062; j++)
                    {
                        anIntArray1207[j] = anIntArray1207[j + 1];
                        anIntArray1241[j] = anIntArray1241[j + 1];
                        anIntArray1250[j] = anIntArray1250[j + 1];
                    }

                    i--;
                } else
                {
                    anIntArray1250[i] = -5;
                }
            } else
            {
                anIntArray1250[i]--;
            }

        if(anInt1259 > 0)
        {
            anInt1259 -= 20;
            if(anInt1259 < 0)
                anInt1259 = 0;
            if(anInt1259 == 0 && aBoolean1151 && !lowmemory)
            {
                anInt1227 = anInt956;
                aBoolean1228 = true;
                ondemandhandler.requestUrgentArchive(2, anInt1227);
            }
        }
    }

    public void loadClient()
    {
        drawLoadingBar(20, (byte)4, "Starting up");
        if(signlink.sunjava)
            super.mindel = 5;
        if(aBoolean993)
        {
            aBoolean1252 = true;
            return;
        }
        aBoolean993 = true;
        boolean flag = false;
        String s = method80(true);
        if(s.endsWith("jagex.com"))
            flag = true;
        if(s.endsWith("runescape.com"))
            flag = true;
        if(s.endsWith("192.168.1.2"))
            flag = true;
        if(s.endsWith("192.168.1.229"))
            flag = true;
        if(s.endsWith("192.168.1.228"))
            flag = true;
        if(s.endsWith("192.168.1.227"))
            flag = true;
        if(s.endsWith("192.168.1.226"))
            flag = true;
        if(s.endsWith("127.0.0.1"))
            flag = true;
        if(!flag)
        {
            aBoolean1176 = true;
            return;
        }
        if(signlink.cache_dat != null)
        {
            for(int i = 0; i < 5; i++)
                cacheindexes[i] = new CacheIndex(0xffffff, signlink.cache_dat, signlink.cache_idx[i], i + 1, true);
        }
        try
        {
            grabCRCs(533);
            titlescreen_archive = getContainerArchive(1, "title screen", "title", cacheidx_crcs[1], (byte)-41, 25);
            p11_font = new RSFont(false, "p11_full", 0, titlescreen_archive);
            p12_font = new RSFont(false, "p12_full", 0, titlescreen_archive);
            b12_font = new RSFont(false, "b12_full", 0, titlescreen_archive);
            q8_font = new RSFont(true, "q8_full", 0, titlescreen_archive);
            drawTitleBackround(0);
            method51(215);
            ContainerArchive class44 = getContainerArchive(2, "config", "config", cacheidx_crcs[2], (byte)-41, 30);
            ContainerArchive class44_1 = getContainerArchive(3, "interface", "interface", cacheidx_crcs[3], (byte)-41, 35);
            ContainerArchive graphics_archive = getContainerArchive(4, "2d graphics", "media", cacheidx_crcs[4], (byte)-41, 40);
            ContainerArchive class44_3 = getContainerArchive(6, "textures", "textures", cacheidx_crcs[6], (byte)-41, 45);
            ContainerArchive class44_4 = getContainerArchive(7, "chat system", "wordenc", cacheidx_crcs[7], (byte)-41, 50);
            ContainerArchive class44_5 = getContainerArchive(8, "sound effects", "sounds", cacheidx_crcs[8], (byte)-41, 55);
            main_tilesettings = new byte[4][104][104];
            main_heightmap = new int[4][105][105];
            pallet = new Palette(104, 104, 4, main_heightmap);
            for(int j = 0; j < 4; j++)
                collisionmaps[j] = new CollisionMap(104, 104);
            aClass30_Sub2_Sub1_Sub1_1263 = new DirectColorSprite(512, 512);
            ContainerArchive class44_6 = getContainerArchive(5, "update list", "versionlist", cacheidx_crcs[5], (byte)-41, 60);
            drawLoadingBar(60, (byte)4, "Connecting to update server");
            ondemandhandler = new OndemandHandler();
            ondemandhandler.loadVersionList(class44_6, this);
            AnimFrame.initialize(ondemandhandler.getAmountAnimations(0));
            Model.initialize(ondemandhandler.getAmountArchives(79, 0), ondemandhandler);
            if(!lowmemory) {
                anInt1227 = 0;
                try {
                    anInt1227 = Integer.parseInt(getParameter("music"));
                }
                catch(Exception _ex) { }
                aBoolean1228 = true;
                ondemandhandler.requestUrgentArchive(2, anInt1227);
                while(ondemandhandler.amount() > 0) {
                    loadFinalizedRequest(false);
                    try {
                        Thread.sleep(100L);
                    } catch(Exception _ex) { }
                    if(ondemandhandler.anInt1349 > 3) {
                        displayLoadError("ondemand");
                        return;
                    }
                }
            }
            drawLoadingBar(65, (byte)4, "Requesting animations");
            int k = ondemandhandler.getAmountArchives(79, 1);
            for(int i1 = 0; i1 < k; i1++)
                ondemandhandler.requestUrgentArchive(1, i1);
            while(ondemandhandler.amount() > 0) 
            {
                int j1 = k - ondemandhandler.amount();
                if(j1 > 0)
                    drawLoadingBar(65, (byte)4, "Loading animations - " + (j1 * 100) / k + "%");
                loadFinalizedRequest(false);
                try
                {
                    Thread.sleep(100L);
                }
                catch(Exception _ex) { }
                if(ondemandhandler.anInt1349 > 3)
                {
                    displayLoadError("ondemand");
                    return;
                }
            }
            drawLoadingBar(70, (byte)4, "Requesting models");
            k = ondemandhandler.getAmountArchives(79, 0);
            for(int k1 = 0; k1 < k; k1++)
            {
                int l1 = ondemandhandler.getModelIndex(k1, -203);
                if((l1 & 1) != 0)
                    ondemandhandler.requestUrgentArchive(0, k1);
            }

            k = ondemandhandler.amount();
            while(ondemandhandler.amount() > 0) 
            {
                int i2 = k - ondemandhandler.amount();
                if(i2 > 0)
                    drawLoadingBar(70, (byte)4, "Loading models - " + (i2 * 100) / k + "%");
                loadFinalizedRequest(false);
                try
                {
                    Thread.sleep(100L);
                }
                catch(Exception _ex) { }
            }
            if(cacheindexes[0] != null)
            {
                drawLoadingBar(75, (byte)4, "Requesting maps");
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(0, 0, 48, 47));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(1, 0, 48, 47));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(0, 0, 48, 48));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(1, 0, 48, 48));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(0, 0, 48, 49));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(1, 0, 48, 49));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(0, 0, 47, 47));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(1, 0, 47, 47));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(0, 0, 47, 48));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(1, 0, 47, 48));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(0, 0, 148, 48));
                ondemandhandler.requestUrgentArchive(3, ondemandhandler.method562(1, 0, 148, 48));
                k = ondemandhandler.amount();
                while(ondemandhandler.amount() > 0) 
                {
                    int j2 = k - ondemandhandler.amount();
                    if(j2 > 0)
                        drawLoadingBar(75, (byte)4, "Loading maps - " + (j2 * 100) / k + "%");
                    loadFinalizedRequest(false);
                    try
                    {
                        Thread.sleep(100L);
                    }
                    catch(Exception _ex) { }
                }
            }
            k = ondemandhandler.getAmountArchives(79, 0);
            for(int k2 = 0; k2 < k; k2++)
            {
                int l2 = ondemandhandler.getModelIndex(k2, -203);
                byte byte0 = 0;
                if((l2 & 8) != 0)
                    byte0 = 10;
                else
                if((l2 & 0x20) != 0)
                    byte0 = 9;
                else
                if((l2 & 0x10) != 0)
                    byte0 = 8;
                else
                if((l2 & 0x40) != 0)
                    byte0 = 7;
                else
                if((l2 & 0x80) != 0)
                    byte0 = 6;
                else
                if((l2 & 2) != 0)
                    byte0 = 5;
                else
                if((l2 & 4) != 0)
                    byte0 = 4;
                if((l2 & 1) != 0)
                    byte0 = 3;
                if(byte0 != 0)
                    ondemandhandler.method563(byte0, 0, k2, (byte)8);
            }

            ondemandhandler.method554(members, 0);
            if(!lowmemory)
            {
                int l = ondemandhandler.getAmountArchives(79, 2);
                for(int i3 = 1; i3 < l; i3++)
                    if(ondemandhandler.isExtraMidi(i3, 5))
                        ondemandhandler.method563((byte)1, 2, i3, (byte)8);

            }
            drawLoadingBar(80, (byte)4, "Unpacking media");
            invback = new IndexedColorSprite(graphics_archive, "invback", 0);
            chatback = new IndexedColorSprite(graphics_archive, "chatback", 0);
            mapback = new IndexedColorSprite(graphics_archive, "mapback", 0);
            backbase1 = new IndexedColorSprite(graphics_archive, "backbase1", 0);
            backbase2 = new IndexedColorSprite(graphics_archive, "backbase2", 0);
            backmid1 = new IndexedColorSprite(graphics_archive, "backhmid1", 0);
            for(int j3 = 0; j3 < 13; j3++)
                sideicons[j3] = new IndexedColorSprite(graphics_archive, "sideicons", j3);
            compass = new DirectColorSprite(graphics_archive, "compass", 0);
            mapedge = new DirectColorSprite(graphics_archive, "mapedge", 0);
            mapedge.finalizeImage();
            try
            {
                for(int k3 = 0; k3 < 100; k3++)
                    mapscene[k3] = new IndexedColorSprite(graphics_archive, "mapscene", k3);

            }
            catch(Exception _ex) { }
            try
            {
                for(int l3 = 0; l3 < 100; l3++)
                    mapfunction[l3] = new DirectColorSprite(graphics_archive, "mapfunction", l3);

            }
            catch(Exception _ex) { }
            try
            {
                for(int i4 = 0; i4 < 5; i4++)
                    hitmarks[i4] = new DirectColorSprite(graphics_archive, "hitmarks", i4);

            }
            catch(Exception _ex) { }
            try
            {
                for(int j4 = 0; j4 < 20; j4++)
                    headicons[j4] = new DirectColorSprite(graphics_archive, "headicons", j4);

            }
            catch(Exception _ex) { }
            mapmarker0 = new DirectColorSprite(graphics_archive, "mapmarker", 0);
            mapmarker1 = new DirectColorSprite(graphics_archive, "mapmarker", 1);
            for(int k4 = 0; k4 < 8; k4++)
                cross_sprites[k4] = new DirectColorSprite(graphics_archive, "cross", k4);
            grounditem_mapdotsprite = new DirectColorSprite(graphics_archive, "mapdots", 0);
            mapdots1 = new DirectColorSprite(graphics_archive, "mapdots", 1);
            mapdots2 = new DirectColorSprite(graphics_archive, "mapdots", 2);
            mapdots3 = new DirectColorSprite(graphics_archive, "mapdots", 3);
            mapdots4 = new DirectColorSprite(graphics_archive, "mapdots", 4);
            scrollbar0 = new IndexedColorSprite(graphics_archive, "scrollbar", 0);
            scrollbar1 = new IndexedColorSprite(graphics_archive, "scrollbar", 1);
            redstone1 = new IndexedColorSprite(graphics_archive, "redstone1", 0);
            redstone2 = new IndexedColorSprite(graphics_archive, "redstone2", 0);
            redstone3 = new IndexedColorSprite(graphics_archive, "redstone3", 0);
            redstone1_2 = new IndexedColorSprite(graphics_archive, "redstone1", 0);
            redstone1_2.method358(0);
            redstone2_2 = new IndexedColorSprite(graphics_archive, "redstone2", 0);
            redstone2_2.method358(0);
            redstone1_3 = new IndexedColorSprite(graphics_archive, "redstone1", 0);
            redstone1_3.method359(true);
            redstone2_3 = new IndexedColorSprite(graphics_archive, "redstone2", 0);
            redstone2_3.method359(true);
            redstone3_2 = new IndexedColorSprite(graphics_archive, "redstone3", 0);
            redstone3_2.method359(true);
            redstone1_4 = new IndexedColorSprite(graphics_archive, "redstone1", 0);
            redstone1_4.method358(0);
            redstone1_4.method359(true);
            redstone2_4 = new IndexedColorSprite(graphics_archive, "redstone2", 0);
            redstone2_4.method358(0);
            redstone2_4.method359(true);
            for(int l4 = 0; l4 < 2; l4++)
                mod_icons[l4] = new IndexedColorSprite(graphics_archive, "mod_icons", l4);
			/* */
            DirectColorSprite class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backleft1", 0);
            backleft1_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backleft2", 0);
            backleft2_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backright1", 0);
            backright1_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backright2", 0);
            backright2_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backtop1", 0);
            backtop1_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backvmid1", 0);
            backvmid1_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backvmid2", 0);
            backvmid2_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backvmid3", 0);
            backvmid3_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
			/* */
            class30_sub2_sub1_sub1 = new DirectColorSprite(graphics_archive, "backhmid2", 0);
            backhmid2_imagefetcher = new ImageFetcher(class30_sub2_sub1_sub1.indexwidth, class30_sub2_sub1_sub1.indexheight, getDrawableComponent(0), 0);
            class30_sub2_sub1_sub1.draw(0, 0);
            int i5 = (int)(Math.random() * 21D) - 10;
            int j5 = (int)(Math.random() * 21D) - 10;
            int k5 = (int)(Math.random() * 21D) - 10;
            int l5 = (int)(Math.random() * 41D) - 20;
            for(int i6 = 0; i6 < 100; i6++)
            {
                if(mapfunction[i6] != null)
                    mapfunction[i6].intensifyPixels(i5 + l5, j5 + l5, k5 + l5);
                if(mapscene[i6] != null)
                    mapscene[i6].intensifyColorIndex(i5 + l5, j5 + l5, k5 + l5, 0);
            }

            drawLoadingBar(83, (byte)4, "Unpacking textures");
            TriangleRasterizer.unpackTextures(class44_3);
            TriangleRasterizer.method372(0.80000000000000004D, aByte1200);
            TriangleRasterizer.initialize(20, true);
            drawLoadingBar(86, (byte)4, "Unpacking config");
            AnimSequence.unpackAnimSequences(class44);
            ObjectDefinition.initialize(class44);
            Floor.method260(0, class44);
            ItemDefinition.amountitems(class44);
            NPCDefinition.unpackNpcDefs(class44);
            CharModel.method535(0, class44);
            SpotAnim.method264(0, class44);
            VarpFile.method546(0, class44);
            VarbitFile.method533(0, class44);
            ItemDefinition.aBoolean182 = members;
            if(!lowmemory)
            {
                drawLoadingBar(90, (byte)4, "Unpacking sounds");
                byte abyte0[] = class44_5.getEntry("sounds.dat", null);
                Buffer buffer0 = new Buffer(abyte0);
                Sound.method240(0, buffer0);
            }
            drawLoadingBar(95, (byte)4, "Unpacking interfaces");
            RSFont aclass30_sub2_sub1_sub4[] = {
                p11_font, p12_font, b12_font, q8_font
            };
            Widget.unpackWidgets(class44_1, aclass30_sub2_sub1_sub4, graphics_archive);
            drawLoadingBar(100, (byte)4, "Preparing game engine");
            for(int j6 = 0; j6 < 33; j6++)
            {
                int k6 = 999;
                int i7 = 0;
                for(int k7 = 0; k7 < 34; k7++)
                {
                    if(mapback.colorindex[k7 + j6 * mapback.indexwidth_] == 0)
                    {
                        if(k6 == 999)
                            k6 = k7;
                        continue;
                    }
                    if(k6 == 999)
                        continue;
                    i7 = k7;
                    break;
                }

                anIntArray968[j6] = k6;
                anIntArray1057[j6] = i7 - k6;
            }

            for(int l6 = 5; l6 < 156; l6++)
            {
                int j7 = 999;
                int l7 = 0;
                for(int j8 = 25; j8 < 172; j8++)
                {
                    if(mapback.colorindex[j8 + l6 * mapback.indexwidth_] == 0 && (j8 > 34 || l6 > 34))
                    {
                        if(j7 == 999)
                            j7 = j8;
                        continue;
                    }
                    if(j7 == 999)
                        continue;
                    l7 = j8;
                    break;
                }

                anIntArray1052[l6 - 5] = j7 - 25;
                anIntArray1229[l6 - 5] = l7 - j7;
            }

            TriangleRasterizer.setDimensions(-950, 479, 96);
            anIntArray1180 = TriangleRasterizer.heightoffsets;
            TriangleRasterizer.setDimensions(-950, 190, 261);
            anIntArray1181 = TriangleRasterizer.heightoffsets;
            TriangleRasterizer.setDimensions(-950, 512, 334);
            anIntArray1182 = TriangleRasterizer.heightoffsets;
            int ai[] = new int[9];
            for(int i8 = 0; i8 < 9; i8++)
            {
                int k8 = 128 + i8 * 32 + 15;
                int l8 = 600 + k8 * 3;
                int i9 = TriangleRasterizer.sine_table[k8];
                ai[i8] = l8 * i9 >> 16;
            }

            Palette.method310(500, 800, 512, 334, ai, aBoolean1231);
            Censor.unpackCensor(class44_4);
            watchdog = new WatchDog(this, anInt1096);
            spawnThread(watchdog, 10);
            RSObject.main = this;
            ObjectDefinition.main = this;
            NPCDefinition.main = this;
            return;
        } catch(Exception exception) {
			exception.printStackTrace();
            signlink.reporterror("loaderror " + aString1049 + " " + anInt1079);
        }
        aBoolean926 = true;
    }

    public void method91(Buffer buffer0, int i, byte byte0)
    {
        if(byte0 == 8)
            byte0 = 0;
        else
            anInt1119 = -50;
        while(buffer0.bitposition + 10 < i * 8) 
        {
            int j = buffer0.getBits(11, 0);
            if(j == 2047)
                break;
            if(players[j] == null)
            {
                players[j] = new Player();
                if(appearancebuffers[j] != null)
                    players[j].parseAppearanceUpdate(0, appearancebuffers[j]);
            }
            anIntArray892[anInt891++] = j;
            Player class30_sub2_sub4_sub1_sub2 = players[j];
            class30_sub2_sub4_sub1_sub2.anInt1537 = loopcycle;
            int k = buffer0.getBits(1, 0);
            if(k == 1)
                playerupdate_stack[amtplayerupdatestack++] = j;
            int l = buffer0.getBits(1, 0);
            int i1 = buffer0.getBits(5, 0);
            if(i1 > 15)
                i1 -= 32;
            int j1 = buffer0.getBits(5, 0);
            if(j1 > 15)
                j1 -= 32;
            class30_sub2_sub4_sub1_sub2.updateMobPosition(((Mob) (localplayer)).palettex_stack[0] + j1, ((Mob) (localplayer)).palettey_stack[0] + i1, l == 1, false);
        }
        buffer0.endBitAccess(true);
    }

    public void handleMinimapClicking(boolean flag)
    {
        aBoolean1157 &= flag;
        if(anInt1021 != 0)
            return;
        if(super.anInt26 == 1)
        {
            int i = super.curpressed_x - 25 - 550;
            int j = super.curpressed_y - 5 - 4;
            if(i >= 0 && j >= 0 && i < 146 && j < 151)
            {
				/* Divide by 2 */
                i -= 73;
                j -= 75;
                int k = camerayaw + anInt1209 & 0x7ff;
                int i1 = TriangleRasterizer.sine_table[k];
                int j1 = TriangleRasterizer.cosine_table[k];
                i1 = i1 * (anInt1170 + 256) >> 8;
                j1 = j1 * (anInt1170 + 256) >> 8;
                int k1 = j * i1 + i * j1 >> 11;
                int l1 = j * j1 - i * i1 >> 11;
                int i2 = ((Mob) (localplayer)).fineposx + k1 >> 7;
                int j2 = ((Mob) (localplayer)).fineposy - l1 >> 7;
                boolean flag1 = sendWalkPacket(1, 0, 0, -11308, 0, ((Mob) (localplayer)).palettey_stack[0], 0, 0, j2, ((Mob) (localplayer)).palettex_stack[0], true, i2);
                if(flag1)
                {
                    packetbuffer.put(i);
                    packetbuffer.put(j);
                    packetbuffer.putShort(camerayaw);
                    packetbuffer.put(57);
                    packetbuffer.put(anInt1209);
                    packetbuffer.put(anInt1170);
                    packetbuffer.put(89);
                    packetbuffer.putShort(((Mob) (localplayer)).fineposx);
                    packetbuffer.putShort(((Mob) (localplayer)).fineposy);
                    packetbuffer.put(anInt1264);
                    packetbuffer.put(63);
                }
            }
            anInt1117++;
            if(anInt1117 > 1151)
            {
                anInt1117 = 0;
                packetbuffer.putPacket(246);
                packetbuffer.put(0);
                int l = packetbuffer.position;
                if((int)(Math.random() * 2D) == 0)
                    packetbuffer.put(101);
                packetbuffer.put(197);
                packetbuffer.putShort((int)(Math.random() * 65536D));
                packetbuffer.put((int)(Math.random() * 256D));
                packetbuffer.put(67);
                packetbuffer.putShort(14214);
                if((int)(Math.random() * 2D) == 0)
                    packetbuffer.putShort(29487);
                packetbuffer.putShort((int)(Math.random() * 65536D));
                if((int)(Math.random() * 2D) == 0)
                    packetbuffer.put(220);
                packetbuffer.put(180);
                packetbuffer.finishByteVar(packetbuffer.position - l, (byte)0);
            }
        }
    }

    public String method93(int i, int j)
    {
        if(i <= 0)
            packetnum = inbuffer.getUByte();
        if(j < 0x3b9ac9ff)
            return String.valueOf(j);
        else
            return "*";
    }

    public void method94(int i)
    {
        if(i != -13873)
        {
            for(int j = 1; j > 0; j++);
        }
        Graphics g = getDrawableComponent(0).getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 765, 503);
        setDeltime(false, 1);
        if(aBoolean926)
        {
            runflamecycle = false;
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int k = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, k);
            k += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, k);
            k += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, k);
            k += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, k);
            k += 30;
            g.drawString("3: Try using a different game-world", 30, k);
            k += 30;
            g.drawString("4: Try rebooting your computer", 30, k);
            k += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, k);
        }
        if(aBoolean1176)
        {
            runflamecycle = false;
            g.setFont(new Font("Helvetica", 1, 20));
            g.setColor(Color.white);
            g.drawString("Error - unable to load game!", 50, 50);
            g.drawString("To play RuneScape make sure you play from", 50, 100);
            g.drawString("http://www.runescape.com", 50, 150);
        }
        if(aBoolean1252)
        {
            runflamecycle = false;
            g.setColor(Color.yellow);
            int l = 35;
            g.drawString("Error a copy of RuneScape already appears to be loaded", 30, l);
            l += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g.drawString("2: Try rebooting your computer, and reloading", 30, l);
            l += 30;
        }
    }

    public URL getCodeBase()
    {
        if(signlink.mainapp != null)
            return signlink.mainapp.getCodeBase();
        try
        {
            if(super.rs_frame != null)
                return new URL("http://127.0.0.1:" + (80 + portoff));
        }
        catch(Exception _ex) { }
        return super.getCodeBase();
    }

    public void updateNPCsOrentation(int i)
    {
        for(int j = 0; j < anInt836; j++)
        {
            int k = updatenpcs[j];
            NPC class30_sub2_sub4_sub1_sub1 = npcs[k];
            if(class30_sub2_sub4_sub1_sub1 != null)
                updateMobOrentation(46988, class30_sub2_sub4_sub1_sub1.definition.npc_halftileoffsets, class30_sub2_sub4_sub1_sub1);
        }

        if(i != -8066)
            anInt1218 = 148;
    }

    public void updateMobOrentation(int i, int j, Mob class30_sub2_sub4_sub1)
    {
        if(i != 46988)
            packetnum = -1;
        if(class30_sub2_sub4_sub1.fineposx < 128 || class30_sub2_sub4_sub1.fineposy < 128 || class30_sub2_sub4_sub1.fineposx >= 13184 || class30_sub2_sub4_sub1.fineposy >= 13184)
        {
            class30_sub2_sub4_sub1.animid_request = -1;
            class30_sub2_sub4_sub1.anInt1520 = -1;
            class30_sub2_sub4_sub1.forcewlk_sp1 = 0;
            class30_sub2_sub4_sub1.forcewlk_sp2 = 0;
            class30_sub2_sub4_sub1.fineposx = class30_sub2_sub4_sub1.palettex_stack[0] * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            class30_sub2_sub4_sub1.fineposy = class30_sub2_sub4_sub1.palettey_stack[0] * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            class30_sub2_sub4_sub1.method446(true);
        }
        if(class30_sub2_sub4_sub1 == localplayer && (class30_sub2_sub4_sub1.fineposx < 1536 || class30_sub2_sub4_sub1.fineposy < 1536 || class30_sub2_sub4_sub1.fineposx >= 11776 || class30_sub2_sub4_sub1.fineposy >= 11776))
        {
            class30_sub2_sub4_sub1.animid_request = -1;
            class30_sub2_sub4_sub1.anInt1520 = -1;
            class30_sub2_sub4_sub1.forcewlk_sp1 = 0;
            class30_sub2_sub4_sub1.forcewlk_sp2 = 0;
            class30_sub2_sub4_sub1.fineposx = class30_sub2_sub4_sub1.palettex_stack[0] * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            class30_sub2_sub4_sub1.fineposy = class30_sub2_sub4_sub1.palettey_stack[0] * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            class30_sub2_sub4_sub1.method446(true);
        }
        if(class30_sub2_sub4_sub1.forcewlk_sp1 > loopcycle)
            method97(class30_sub2_sub4_sub1, true);
        else
        if(class30_sub2_sub4_sub1.forcewlk_sp2 >= loopcycle)
            method98(class30_sub2_sub4_sub1, aByte1012);
        else
            method99((byte)34, class30_sub2_sub4_sub1);
        method100(class30_sub2_sub4_sub1, -843);
        method101(class30_sub2_sub4_sub1, -805);
    }

    public void method97(Mob class30_sub2_sub4_sub1, boolean flag)
    {
        int i = class30_sub2_sub4_sub1.forcewlk_sp1 - loopcycle;
        int j = class30_sub2_sub4_sub1.forcewlk_startx * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
        int k = class30_sub2_sub4_sub1.forcewlk_starty * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
        class30_sub2_sub4_sub1.fineposx += (j - class30_sub2_sub4_sub1.fineposx) / i;
        if(!flag)
            return;
        class30_sub2_sub4_sub1.fineposy += (k - class30_sub2_sub4_sub1.fineposy) / i;
        class30_sub2_sub4_sub1.anInt1503 = 0;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 0)
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 1)
            class30_sub2_sub4_sub1.anInt1510 = 1536;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 2)
            class30_sub2_sub4_sub1.anInt1510 = 0;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 3)
            class30_sub2_sub4_sub1.anInt1510 = 512;
    }

    public void method98(Mob class30_sub2_sub4_sub1, byte byte0)
    {
        if(class30_sub2_sub4_sub1.forcewlk_sp2 == loopcycle || class30_sub2_sub4_sub1.animid_request == -1 || class30_sub2_sub4_sub1.animdelay_request != 0 || class30_sub2_sub4_sub1.anInt1528 + 1 > AnimSequence.animationsequences[class30_sub2_sub4_sub1.animid_request].method258(class30_sub2_sub4_sub1.anInt1527, (byte)-39))
        {
            int i = class30_sub2_sub4_sub1.forcewlk_sp2 - class30_sub2_sub4_sub1.forcewlk_sp1;
            int j = loopcycle - class30_sub2_sub4_sub1.forcewlk_sp1;
            int k = class30_sub2_sub4_sub1.forcewlk_startx * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            int l = class30_sub2_sub4_sub1.forcewlk_starty * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            int i1 = class30_sub2_sub4_sub1.forcewlk_endx * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            int j1 = class30_sub2_sub4_sub1.forcewlk_endy * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
            class30_sub2_sub4_sub1.fineposx = (k * (i - j) + i1 * j) / i;
            class30_sub2_sub4_sub1.fineposy = (l * (i - j) + j1 * j) / i;
        }
        class30_sub2_sub4_sub1.anInt1503 = 0;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 0)
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 1)
            class30_sub2_sub4_sub1.anInt1510 = 1536;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 2)
            class30_sub2_sub4_sub1.anInt1510 = 0;
        if(class30_sub2_sub4_sub1.forcewlk_dir == 3)
            class30_sub2_sub4_sub1.anInt1510 = 512;
        class30_sub2_sub4_sub1.anInt1552 = class30_sub2_sub4_sub1.anInt1510;
        if(byte0 != aByte1012)
            anInt1096 = -383;
    }

    public void method99(byte byte0, Mob class30_sub2_sub4_sub1)
    {
        class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.stand_anim;
        if(class30_sub2_sub4_sub1.stack_position_mob == 0)
        {
            class30_sub2_sub4_sub1.anInt1503 = 0;
            return;
        }
        if(class30_sub2_sub4_sub1.animid_request != -1 && class30_sub2_sub4_sub1.animdelay_request == 0)
        {
            AnimSequence class20 = AnimSequence.animationsequences[class30_sub2_sub4_sub1.animid_request];
            if(class30_sub2_sub4_sub1.anInt1542 > 0 && class20.anInt363 == 0)
            {
                class30_sub2_sub4_sub1.anInt1503++;
                return;
            }
            if(class30_sub2_sub4_sub1.anInt1542 <= 0 && class20.anInt364 == 0)
            {
                class30_sub2_sub4_sub1.anInt1503++;
                return;
            }
        }
        int i = class30_sub2_sub4_sub1.fineposx;
        int j = class30_sub2_sub4_sub1.fineposy;
        int k = class30_sub2_sub4_sub1.palettex_stack[class30_sub2_sub4_sub1.stack_position_mob - 1] * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
        int l = class30_sub2_sub4_sub1.palettey_stack[class30_sub2_sub4_sub1.stack_position_mob - 1] * 128 + class30_sub2_sub4_sub1.halftile_offsets * 64;
        if(k - i > 256 || k - i < -256 || l - j > 256 || l - j < -256)
        {
            class30_sub2_sub4_sub1.fineposx = k;
            class30_sub2_sub4_sub1.fineposy = l;
            return;
        }
        if(i < k)
        {
            if(j < l)
                class30_sub2_sub4_sub1.anInt1510 = 1280;
            else
            if(j > l)
                class30_sub2_sub4_sub1.anInt1510 = 1792;
            else
                class30_sub2_sub4_sub1.anInt1510 = 1536;
        } else
        if(i > k)
        {
            if(j < l)
                class30_sub2_sub4_sub1.anInt1510 = 768;
            else
            if(j > l)
                class30_sub2_sub4_sub1.anInt1510 = 256;
            else
                class30_sub2_sub4_sub1.anInt1510 = 512;
        } else
        if(j < l)
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        else
            class30_sub2_sub4_sub1.anInt1510 = 0;
        int i1 = class30_sub2_sub4_sub1.anInt1510 - class30_sub2_sub4_sub1.anInt1552 & 0x7ff;
        if(i1 > 1024)
            i1 -= 2048;
        int j1 = class30_sub2_sub4_sub1.turn180_anim;
        if(i1 >= -256 && i1 <= 256)
            j1 = class30_sub2_sub4_sub1.walk_anim;
        else
        if(i1 >= 256 && i1 < 768)
            j1 = class30_sub2_sub4_sub1.turn90ccw_anim;
        else
        if(i1 >= -768 && i1 <= -256)
            j1 = class30_sub2_sub4_sub1.turn90cw_anim;
        if(j1 == -1)
            j1 = class30_sub2_sub4_sub1.walk_anim;
        class30_sub2_sub4_sub1.anInt1517 = j1;
        int k1 = 4;
        if(class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.anInt1510 && class30_sub2_sub4_sub1.anInt1502 == -1 && class30_sub2_sub4_sub1.rotation != 0)
            k1 = 2;
        if(class30_sub2_sub4_sub1.stack_position_mob > 2)
            k1 = 6;
        if(class30_sub2_sub4_sub1.stack_position_mob > 3)
            k1 = 8;
        if(class30_sub2_sub4_sub1.anInt1503 > 0 && class30_sub2_sub4_sub1.stack_position_mob > 1)
        {
            k1 = 8;
            class30_sub2_sub4_sub1.anInt1503--;
        }
        if(class30_sub2_sub4_sub1.running_stack[class30_sub2_sub4_sub1.stack_position_mob - 1])
            k1 <<= 1;
        if(k1 >= 8 && class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.walk_anim && class30_sub2_sub4_sub1.run_anim != -1)
            class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.run_anim;
        if(i < k)
        {
            class30_sub2_sub4_sub1.fineposx += k1;
            if(class30_sub2_sub4_sub1.fineposx > k)
                class30_sub2_sub4_sub1.fineposx = k;
        } else
        if(i > k)
        {
            class30_sub2_sub4_sub1.fineposx -= k1;
            if(class30_sub2_sub4_sub1.fineposx < k)
                class30_sub2_sub4_sub1.fineposx = k;
        }
        if(j < l)
        {
            class30_sub2_sub4_sub1.fineposy += k1;
            if(class30_sub2_sub4_sub1.fineposy > l)
                class30_sub2_sub4_sub1.fineposy = l;
        } else
        if(j > l)
        {
            class30_sub2_sub4_sub1.fineposy -= k1;
            if(class30_sub2_sub4_sub1.fineposy < l)
                class30_sub2_sub4_sub1.fineposy = l;
        }
        if(class30_sub2_sub4_sub1.fineposx == k && class30_sub2_sub4_sub1.fineposy == l)
        {
            class30_sub2_sub4_sub1.stack_position_mob--;
            if(class30_sub2_sub4_sub1.anInt1542 > 0)
                class30_sub2_sub4_sub1.anInt1542--;
        }
    }

    public void method100(Mob class30_sub2_sub4_sub1, int i)
    {
        if(i >= 0)
            return;
        if(class30_sub2_sub4_sub1.rotation == 0)
            return;
        if(class30_sub2_sub4_sub1.anInt1502 != -1 && class30_sub2_sub4_sub1.anInt1502 < 32768)
        {
            NPC class30_sub2_sub4_sub1_sub1 = npcs[class30_sub2_sub4_sub1.anInt1502];
            if(class30_sub2_sub4_sub1_sub1 != null)
            {
                int i1 = class30_sub2_sub4_sub1.fineposx - ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx;
                int k1 = class30_sub2_sub4_sub1.fineposy - ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy;
                if(i1 != 0 || k1 != 0)
                    class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2(i1, k1) * 325.94900000000001D) & 0x7ff;
            }
        }
        if(class30_sub2_sub4_sub1.anInt1502 >= 32768)
        {
            int j = class30_sub2_sub4_sub1.anInt1502 - 32768;
            if(j == anInt884)
                j = localindex;
            Player class30_sub2_sub4_sub1_sub2 = players[j];
            if(class30_sub2_sub4_sub1_sub2 != null)
            {
                int l1 = class30_sub2_sub4_sub1.fineposx - ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx;
                int i2 = class30_sub2_sub4_sub1.fineposy - ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy;
                if(l1 != 0 || i2 != 0)
                    class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2(l1, i2) * 325.94900000000001D) & 0x7ff;
            }
        }
        if((class30_sub2_sub4_sub1.anInt1538 != 0 || class30_sub2_sub4_sub1.anInt1539 != 0) && (class30_sub2_sub4_sub1.stack_position_mob == 0 || class30_sub2_sub4_sub1.anInt1503 > 0))
        {
            int k = class30_sub2_sub4_sub1.fineposx - (class30_sub2_sub4_sub1.anInt1538 - palettex - palettex) * 64;
            int j1 = class30_sub2_sub4_sub1.fineposy - (class30_sub2_sub4_sub1.anInt1539 - palettey - palettey) * 64;
            if(k != 0 || j1 != 0)
                class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2(k, j1) * 325.94900000000001D) & 0x7ff;
            class30_sub2_sub4_sub1.anInt1538 = 0;
            class30_sub2_sub4_sub1.anInt1539 = 0;
        }
        int l = class30_sub2_sub4_sub1.anInt1510 - class30_sub2_sub4_sub1.anInt1552 & 0x7ff;
        if(l != 0)
        {
            if(l < class30_sub2_sub4_sub1.rotation || l > 2048 - class30_sub2_sub4_sub1.rotation)
                class30_sub2_sub4_sub1.anInt1552 = class30_sub2_sub4_sub1.anInt1510;
            else
            if(l > 1024)
                class30_sub2_sub4_sub1.anInt1552 -= class30_sub2_sub4_sub1.rotation;
            else
                class30_sub2_sub4_sub1.anInt1552 += class30_sub2_sub4_sub1.rotation;
            class30_sub2_sub4_sub1.anInt1552 &= 0x7ff;
            if(class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.stand_anim && class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.anInt1510)
            {
                if(class30_sub2_sub4_sub1.standturn_anim != -1)
                {
                    class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.standturn_anim;
                    return;
                }
                class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.walk_anim;
            }
        }
    }

    public void method101(Mob class30_sub2_sub4_sub1, int i)
    {
        if(i >= 0)
            aBoolean919 = !aBoolean919;
        class30_sub2_sub4_sub1.aBoolean1541 = false;
        if(class30_sub2_sub4_sub1.anInt1517 != -1)
        {
            AnimSequence class20 = AnimSequence.animationsequences[class30_sub2_sub4_sub1.anInt1517];
            class30_sub2_sub4_sub1.anInt1519++;
            if(class30_sub2_sub4_sub1.anInt1518 < class20.anInt352 && class30_sub2_sub4_sub1.anInt1519 > class20.method258(class30_sub2_sub4_sub1.anInt1518, (byte)-39))
            {
                class30_sub2_sub4_sub1.anInt1519 = 0;
                class30_sub2_sub4_sub1.anInt1518++;
            }
            if(class30_sub2_sub4_sub1.anInt1518 >= class20.anInt352)
            {
                class30_sub2_sub4_sub1.anInt1519 = 0;
                class30_sub2_sub4_sub1.anInt1518 = 0;
            }
        }
        if(class30_sub2_sub4_sub1.anInt1520 != -1 && loopcycle >= class30_sub2_sub4_sub1.anInt1523)
        {
            if(class30_sub2_sub4_sub1.anInt1521 < 0)
                class30_sub2_sub4_sub1.anInt1521 = 0;
            AnimSequence class20_1 = SpotAnim.aClass23Array403[class30_sub2_sub4_sub1.anInt1520].aClass20_407;
            for(class30_sub2_sub4_sub1.anInt1522++; class30_sub2_sub4_sub1.anInt1521 < class20_1.anInt352 && class30_sub2_sub4_sub1.anInt1522 > class20_1.method258(class30_sub2_sub4_sub1.anInt1521, (byte)-39); class30_sub2_sub4_sub1.anInt1521++)
                class30_sub2_sub4_sub1.anInt1522 -= class20_1.method258(class30_sub2_sub4_sub1.anInt1521, (byte)-39);

            if(class30_sub2_sub4_sub1.anInt1521 >= class20_1.anInt352 && (class30_sub2_sub4_sub1.anInt1521 < 0 || class30_sub2_sub4_sub1.anInt1521 >= class20_1.anInt352))
                class30_sub2_sub4_sub1.anInt1520 = -1;
        }
        if(class30_sub2_sub4_sub1.animid_request != -1 && class30_sub2_sub4_sub1.animdelay_request <= 1)
        {
            AnimSequence class20_2 = AnimSequence.animationsequences[class30_sub2_sub4_sub1.animid_request];
            if(class20_2.anInt363 == 1 && class30_sub2_sub4_sub1.anInt1542 > 0 && class30_sub2_sub4_sub1.forcewlk_sp1 <= loopcycle && class30_sub2_sub4_sub1.forcewlk_sp2 < loopcycle)
            {
                class30_sub2_sub4_sub1.animdelay_request = 1;
                return;
            }
        }
        if(class30_sub2_sub4_sub1.animid_request != -1 && class30_sub2_sub4_sub1.animdelay_request == 0)
        {
            AnimSequence class20_3 = AnimSequence.animationsequences[class30_sub2_sub4_sub1.animid_request];
            for(class30_sub2_sub4_sub1.anInt1528++; class30_sub2_sub4_sub1.anInt1527 < class20_3.anInt352 && class30_sub2_sub4_sub1.anInt1528 > class20_3.method258(class30_sub2_sub4_sub1.anInt1527, (byte)-39); class30_sub2_sub4_sub1.anInt1527++)
                class30_sub2_sub4_sub1.anInt1528 -= class20_3.method258(class30_sub2_sub4_sub1.anInt1527, (byte)-39);

            if(class30_sub2_sub4_sub1.anInt1527 >= class20_3.anInt352)
            {
                class30_sub2_sub4_sub1.anInt1527 -= class20_3.anInt356;
                class30_sub2_sub4_sub1.anInt1530++;
                if(class30_sub2_sub4_sub1.anInt1530 >= class20_3.anInt362)
                    class30_sub2_sub4_sub1.animid_request = -1;
                if(class30_sub2_sub4_sub1.anInt1527 < 0 || class30_sub2_sub4_sub1.anInt1527 >= class20_3.anInt352)
                    class30_sub2_sub4_sub1.animid_request = -1;
            }
            class30_sub2_sub4_sub1.aBoolean1541 = class20_3.aBoolean358;
        }
        if(class30_sub2_sub4_sub1.animdelay_request > 0)
            class30_sub2_sub4_sub1.animdelay_request--;
    }

    public void drawGameScreen(boolean flag)
    {
        if(!flag)
            anInt939 = packetencryption.poll();
        if(aBoolean1255)
        {
            aBoolean1255 = false;
            backleft1_imagefetcher.updateGraphics(4, 23680, super.graphics, 0);
            backleft2_imagefetcher.updateGraphics(357, 23680, super.graphics, 0);
            backright1_imagefetcher.updateGraphics(4, 23680, super.graphics, 722);
            backright2_imagefetcher.updateGraphics(205, 23680, super.graphics, 743);
            backtop1_imagefetcher.updateGraphics(0, 23680, super.graphics, 0);
            backvmid1_imagefetcher.updateGraphics(4, 23680, super.graphics, 516);
            backvmid2_imagefetcher.updateGraphics(205, 23680, super.graphics, 516);
            backvmid3_imagefetcher.updateGraphics(357, 23680, super.graphics, 496);
            backhmid2_imagefetcher.updateGraphics(338, 23680, super.graphics, 0);
            aBoolean1153 = true;
            aBoolean1223 = true;
            update_tabs = true;
            updatetoolbar = true;
            if(landscape_stage != 2)
            {
                toplefttext_imagefetcher.updateGraphics(4, 23680, super.graphics, 4);
                aClass15_1164.updateGraphics(4, 23680, super.graphics, 550);
            }
        }
        if(landscape_stage == 2)
            method146((byte)1);
        if(aBoolean885 && clickarea == 1)
            aBoolean1153 = true;
        if(anInt1189 != -1)
        {
            boolean flag1 = method119(anInt945, false, anInt1189);
            if(flag1)
                aBoolean1153 = true;
        }
        if(anInt1246 == 2)
            aBoolean1153 = true;
        if(anInt1086 == 2)
            aBoolean1153 = true;
        if(aBoolean1153)
        {
            method36((byte)-81);
            aBoolean1153 = false;
        }
        if(anInt1276 == -1)
        {
            aClass9_1059.anInt224 = anInt1211 - anInt1089 - 77;
            if(super.mouse_x > 448 && super.mouse_x < 560 && super.mouse_y > 332)
                method65(463, 77, super.mouse_x - 17, super.mouse_y - 357, aClass9_1059, 0, false, anInt1211, 0);
            int i = anInt1211 - 77 - aClass9_1059.anInt224;
            if(i < 0)
                i = 0;
            if(i > anInt1211 - 77)
                i = anInt1211 - 77;
            if(anInt1089 != i)
            {
                anInt1089 = i;
                aBoolean1223 = true;
            }
        }
        if(anInt1276 != -1)
        {
            boolean flag2 = method119(anInt945, false, anInt1276);
            if(flag2)
                aBoolean1223 = true;
        }
        if(anInt1246 == 3)
            aBoolean1223 = true;
        if(anInt1086 == 3)
            aBoolean1223 = true;
        if(aString844 != null)
            aBoolean1223 = true;
        if(aBoolean885 && clickarea == 2)
            aBoolean1223 = true;
        if(aBoolean1223)
        {
            renderChat(6);
            aBoolean1223 = false;
        }
        if(landscape_stage == 2)
        {
            drawMinimap(false);
            aClass15_1164.updateGraphics(4, 23680, super.graphics, 550);
        }
        if(anInt1054 != -1)
            update_tabs = true;
        if(update_tabs)
        {
            if(anInt1054 != -1 && anInt1054 == current_tab)
            {
                anInt1054 = -1;
                packetbuffer.putPacket(120);
                packetbuffer.put(current_tab);
            }
            update_tabs = false;
            aClass15_1125.initialize(0);
            backmid1.renderImage(0, 16083, 0);
            if(anInt1189 == -1)
            {
                if(tab_interfaces[current_tab] != -1)
                {
                    if(current_tab == 0)
                        redstone1.renderImage(22, 16083, 10);
                    if(current_tab == 1)
                        redstone2.renderImage(54, 16083, 8);
                    if(current_tab == 2)
                        redstone2.renderImage(82, 16083, 8);
                    if(current_tab == 3)
                        redstone3.renderImage(110, 16083, 8);
                    if(current_tab == 4)
                        redstone2_2.renderImage(153, 16083, 8);
                    if(current_tab == 5)
                        redstone2_2.renderImage(181, 16083, 8);
                    if(current_tab == 6)
                        redstone1_2.renderImage(209, 16083, 9);
                }
                if(tab_interfaces[0] != -1 && (anInt1054 != 0 || loopcycle % 20 < 10))
                    sideicons[0].renderImage(29, 16083, 13);
                if(tab_interfaces[1] != -1 && (anInt1054 != 1 || loopcycle % 20 < 10))
                    sideicons[1].renderImage(53, 16083, 11);
                if(tab_interfaces[2] != -1 && (anInt1054 != 2 || loopcycle % 20 < 10))
                    sideicons[2].renderImage(82, 16083, 11);
                if(tab_interfaces[3] != -1 && (anInt1054 != 3 || loopcycle % 20 < 10))
                    sideicons[3].renderImage(115, 16083, 12);
                if(tab_interfaces[4] != -1 && (anInt1054 != 4 || loopcycle % 20 < 10))
                    sideicons[4].renderImage(153, 16083, 13);
                if(tab_interfaces[5] != -1 && (anInt1054 != 5 || loopcycle % 20 < 10))
                    sideicons[5].renderImage(180, 16083, 11);
                if(tab_interfaces[6] != -1 && (anInt1054 != 6 || loopcycle % 20 < 10))
                    sideicons[6].renderImage(208, 16083, 13);
            }
            aClass15_1125.updateGraphics(160, 23680, super.graphics, 516);
            aClass15_1124.initialize(0);
            backbase2.renderImage(0, 16083, 0);
            if(anInt1189 == -1)
            {
                if(tab_interfaces[current_tab] != -1)
                {
                    if(current_tab == 7)
                        redstone1_3.renderImage(42, 16083, 0);
                    if(current_tab == 8)
                        redstone2_3.renderImage(74, 16083, 0);
                    if(current_tab == 9)
                        redstone2_3.renderImage(102, 16083, 0);
                    if(current_tab == 10)
                        redstone3_2.renderImage(130, 16083, 1);
                    if(current_tab == 11)
                        redstone2_4.renderImage(173, 16083, 0);
                    if(current_tab == 12)
                        redstone2_4.renderImage(201, 16083, 0);
                    if(current_tab == 13)
                        redstone1_4.renderImage(229, 16083, 0);
                }
                if(tab_interfaces[8] != -1 && (anInt1054 != 8 || loopcycle % 20 < 10))
                    sideicons[7].renderImage(74, 16083, 2);
                if(tab_interfaces[9] != -1 && (anInt1054 != 9 || loopcycle % 20 < 10))
                    sideicons[8].renderImage(102, 16083, 3);
                if(tab_interfaces[10] != -1 && (anInt1054 != 10 || loopcycle % 20 < 10))
                    sideicons[9].renderImage(137, 16083, 4);
                if(tab_interfaces[11] != -1 && (anInt1054 != 11 || loopcycle % 20 < 10))
                    sideicons[10].renderImage(174, 16083, 2);
                if(tab_interfaces[12] != -1 && (anInt1054 != 12 || loopcycle % 20 < 10))
                    sideicons[11].renderImage(201, 16083, 2);
                if(tab_interfaces[13] != -1 && (anInt1054 != 13 || loopcycle % 20 < 10))
                    sideicons[12].renderImage(226, 16083, 2);
            }
            aClass15_1124.updateGraphics(466, 23680, super.graphics, 496);
            toplefttext_imagefetcher.initialize(0);
        }
        if(updatetoolbar)
        {
            updatetoolbar = false;
            toolbartext_imagefetcher.initialize(0);
            backbase1.renderImage(0, 16083, 0);
            p12_font.drawCenteredXText(0xffffff, 55, anInt939, "Public chat", 28, true);
            if(anInt1287 == 0)
                p12_font.drawCenteredXText(65280, 55, anInt939, "On", 41, true);
            if(anInt1287 == 1)
                p12_font.drawCenteredXText(0xffff00, 55, anInt939, "Friends", 41, true);
            if(anInt1287 == 2)
                p12_font.drawCenteredXText(0xff0000, 55, anInt939, "Off", 41, true);
            if(anInt1287 == 3)
                p12_font.drawCenteredXText(65535, 55, anInt939, "Hide", 41, true);
            p12_font.drawCenteredXText(0xffffff, 184, anInt939, "Private chat", 28, true);
            if(anInt845 == 0)
                p12_font.drawCenteredXText(65280, 184, anInt939, "On", 41, true);
            if(anInt845 == 1)
                p12_font.drawCenteredXText(0xffff00, 184, anInt939, "Friends", 41, true);
            if(anInt845 == 2)
                p12_font.drawCenteredXText(0xff0000, 184, anInt939, "Off", 41, true);
            p12_font.drawCenteredXText(0xffffff, 324, anInt939, "Trade/compete", 28, true);
            if(anInt1248 == 0)
                p12_font.drawCenteredXText(65280, 324, anInt939, "On", 41, true);
            if(anInt1248 == 1)
                p12_font.drawCenteredXText(0xffff00, 324, anInt939, "Friends", 41, true);
            if(anInt1248 == 2)
                p12_font.drawCenteredXText(0xff0000, 324, anInt939, "Off", 41, true);
            p12_font.drawCenteredXText(0xffffff, 458, anInt939, "Report abuse", 33, true);
            toolbartext_imagefetcher.updateGraphics(453, 23680, super.graphics, 0);
            toplefttext_imagefetcher.initialize(0);
        }
        anInt945 = 0;
    }

    public boolean method103(Widget class9, boolean flag)
    {
        int i = class9.actioncode;
        if(flag)
            loadClient();
        if(i >= 1 && i <= 200 || i >= 701 && i <= 900)
        {
            if(i >= 801)
                i -= 701;
            else
            if(i >= 701)
                i -= 601;
            else
            if(i >= 101)
                i -= 101;
            else
                i--;
            interfacestringstack[anInt1133] = "Remove @whi@" + friendusernames[i];
            interfaceopcodestack[anInt1133] = 792;
            anInt1133++;
            interfacestringstack[anInt1133] = "Message @whi@" + friendusernames[i];
            interfaceopcodestack[anInt1133] = 639;
            anInt1133++;
            return true;
        }
        if(i >= 401 && i <= 500)
        {
            interfacestringstack[anInt1133] = "Remove @whi@" + class9.aString248;
            interfaceopcodestack[anInt1133] = 322;
            anInt1133++;
            return true;
        } else
        {
            return false;
        }
    }

    public void processGFXs(boolean flag)
    {
        GFX class30_sub2_sub4_sub3 = (GFX)gfxs_storage.getFirst();
        aBoolean1157 &= flag;
        for(; class30_sub2_sub4_sub3 != null; class30_sub2_sub4_sub3 = (GFX)gfxs_storage.getNextForwards(false))
            if(class30_sub2_sub4_sub3.anInt1560 != cheight || class30_sub2_sub4_sub3.destroy_gfx)
                class30_sub2_sub4_sub3.removeDeque();
            else
            if(loopcycle >= class30_sub2_sub4_sub3.runcycle)
            {
                class30_sub2_sub4_sub3.method454(anInt945, true);
                if(class30_sub2_sub4_sub3.destroy_gfx)
                    class30_sub2_sub4_sub3.removeDeque();
                else
                    pallet.method285(class30_sub2_sub4_sub3.anInt1560, 0, (byte)6, class30_sub2_sub4_sub3.anInt1563, -1, class30_sub2_sub4_sub3.anInt1562, 60, class30_sub2_sub4_sub3.anInt1561, class30_sub2_sub4_sub3, false);
            }

    }

    public void drawWidget(Widget widget, int offsetx, int offsety, int offsety$)
    {
        if(widget.widgettype != 0 || widget.childrenwidgets == null)
            return;
        if(widget.aBoolean266 && anInt1026 != widget.widgetid && anInt1048 != widget.widgetid && anInt1039 != widget.widgetid)
            return;
        int prevwidthoffset = Raster.widthoffset;
        int prevheightoffset = Raster.heightoffset;
        int prevwidth = Raster.width;
        int prevheight = Raster.height;
        Raster.setDimensions(offsetx + widget.width, offsetx, offsety + widget.height, offsety);
        int amountchildren = widget.childrenwidgets.length;
        for(int child = 0; child < amountchildren; child++)
        {
            int x = widget.positionx[child] + offsetx;
            int y = (widget.positiony[child] + offsety) - offsety$;
            Widget childwidget = Widget.widgets[widget.childrenwidgets[child]];
            x += childwidget.anInt263;
            y += childwidget.anInt265;
            if(childwidget.actioncode > 0)
                handleWidgetActionCode(950, childwidget);
            if(childwidget.widgettype == 0)
            {
                if(childwidget.anInt224 > childwidget.anInt261 - childwidget.height)
                    childwidget.anInt224 = childwidget.anInt261 - childwidget.height;
                if(childwidget.anInt224 < 0)
                    childwidget.anInt224 = 0;
                drawWidget(childwidget, x, y, childwidget.anInt224);
                if(childwidget.anInt261 > childwidget.height)
                    drawScrollBar(519, childwidget.height, childwidget.anInt224, y, x + childwidget.width, childwidget.anInt261);
            } else
            if(childwidget.widgettype != 1)
                if(childwidget.widgettype == 2)
                {
                    int i3 = 0;
                    for(int y$ = 0; y$ < childwidget.height; y$++)
                    {
                        for(int x$ = 0; x$ < childwidget.width; x$++)
                        {
                            int k5 = x + x$ * (32 + childwidget.anInt231);
                            int j6 = y + y$ * (32 + childwidget.anInt244);
                            if(i3 < 20)
                            {
                                k5 += childwidget.anIntArray215[i3];
                                j6 += childwidget.anIntArray247[i3];
                            }
                            if(childwidget.itemarray[i3] > 0)
                            {
                                int k6 = 0;
                                int j7 = 0;
                                int itemid = childwidget.itemarray[i3] - 1;
                                if(k5 > Raster.widthoffset - 32 && k5 < Raster.width && j6 > Raster.heightoffset - 32 && j6 < Raster.height || anInt1086 != 0 && moveitem_startslot == i3)
                                {
                                    int l9 = 0;
                                    if(anInt1282 == 1 && anInt1283 == i3 && anInt1284 == childwidget.widgetid)
                                        l9 = 0xffffff;
                                    DirectColorSprite sprite = ItemDefinition.asSprite(itemid, childwidget.itemamounts[i3], l9, 9);
                                    if(sprite != null)
                                    {
                                        if(anInt1086 != 0 && moveitem_startslot == i3 && moveitem_frameid == childwidget.widgetid)
                                        {
                                            k6 = super.mouse_x - anInt1087;
                                            j7 = super.mouse_y - anInt1088;
                                            if(k6 < 5 && k6 > -5)
                                                k6 = 0;
                                            if(j7 < 5 && j7 > -5)
                                                j7 = 0;
                                            if(anInt989 < 5)
                                            {
                                                k6 = 0;
                                                j7 = 0;
                                            }
                                            sprite.drawBlended(k5 + k6, j6 + j7, 128, aBoolean1043);
                                            if(j6 + j7 < Raster.heightoffset && childwidget.anInt224 > 0)
                                            {
                                                int i10 = (anInt945 * (Raster.heightoffset - j6 - j7)) / 3;
                                                if(i10 > anInt945 * 10)
                                                    i10 = anInt945 * 10;
                                                if(i10 > childwidget.anInt224)
                                                    i10 = childwidget.anInt224;
                                                childwidget.anInt224 -= i10;
                                                anInt1088 += i10;
                                            }
                                            if(j6 + j7 + 32 > Raster.height && childwidget.anInt224 < childwidget.anInt261 - childwidget.height)
                                            {
                                                int j10 = (anInt945 * ((j6 + j7 + 32) - Raster.height)) / 3;
                                                if(j10 > anInt945 * 10)
                                                    j10 = anInt945 * 10;
                                                if(j10 > childwidget.anInt261 - childwidget.height - childwidget.anInt224)
                                                    j10 = childwidget.anInt261 - childwidget.height - childwidget.anInt224;
                                                childwidget.anInt224 += j10;
                                                anInt1088 -= j10;
                                            }
                                        } else
                                        if(anInt1246 != 0 && anInt1245 == i3 && anInt1244 == childwidget.widgetid)
                                            sprite.drawBlended(k5, j6, 128, aBoolean1043);
                                        else
                                            sprite.drawOverlay(k5, 16083, j6);
                                        if(sprite.width$ == 33 || childwidget.itemamounts[i3] != 1)
                                        {
                                            int k10 = childwidget.itemamounts[i3];
                                            p11_font.drawText(0, amountToAmountStr(-33245, k10), j6 + 10 + j7, 822, k5 + 1 + k6);
                                            p11_font.drawText(0xffff00, amountToAmountStr(-33245, k10), j6 + 9 + j7, 822, k5 + k6);
                                        }
                                    }
                                }
                            } else
                            if(childwidget.sprites != null && i3 < 20)
                            {
                                DirectColorSprite class30_sub2_sub1_sub1_1 = childwidget.sprites[i3];
                                if(class30_sub2_sub1_sub1_1 != null)
                                    class30_sub2_sub1_sub1_1.drawOverlay(k5, 16083, j6);
                            }
                            i3++;
                        }

                    }

                } else
                if(childwidget.widgettype == 3)
                {
                    boolean flag = false;
                    if(anInt1039 == childwidget.widgetid || anInt1048 == childwidget.widgetid || anInt1026 == childwidget.widgetid)
                        flag = true;
                    int j3;
                    if(isWidgetHiddenActive(childwidget, false))
                    {
                        j3 = childwidget.anInt219;
                        if(flag && childwidget.anInt239 != 0)
                            j3 = childwidget.anInt239;
                    } else
                    {
                        j3 = childwidget.anInt232;
                        if(flag && childwidget.anInt216 != 0)
                            j3 = childwidget.anInt216;
                    }
                    if(childwidget.oalpha == 0)
                    {
                        if(childwidget.aBoolean227)
                            Raster.drawQuadrilateral( x, y, childwidget.width, childwidget.height, j3);
                        else
                            Raster.drawQuadrilateralOutline(x, y, childwidget.width, childwidget.height, j3);
                    } else
                    if(childwidget.aBoolean227)
                        Raster.drawQuadrilateralBlend(x, y, childwidget.width, childwidget.height, 256 - (childwidget.oalpha & 0xff), j3);
                    else
                        Raster.drawQuadrilateralOutlineBlend(x, y, childwidget.width, childwidget.height, 256 - (childwidget.oalpha & 0xff), j3);
                } else
                if(childwidget.widgettype == 4)
                {
                    RSFont font = childwidget.itemfont;
                    String s = childwidget.aString248;
                    boolean flag1 = false;
                    if(anInt1039 == childwidget.widgetid || anInt1048 == childwidget.widgetid || anInt1026 == childwidget.widgetid)
                        flag1 = true;
                    int color;
                    if(isWidgetHiddenActive(childwidget, false))
                    {
                        color = childwidget.anInt219;
                        if(flag1 && childwidget.anInt239 != 0)
                            color = childwidget.anInt239;
                        if(childwidget.hiddentext.length() > 0)
                            s = childwidget.hiddentext;
                    } else
                    {
                        color = childwidget.anInt232;
                        if(flag1 && childwidget.anInt216 != 0)
                            color = childwidget.anInt216;
                    }
                    if(childwidget.textfieldtype == 6 && aBoolean1149)
                    {
                        s = "Please wait...";
                        color = childwidget.anInt232;
                    }
                    if(Raster.outputwidth == 479)
                    {
                        if(color == 0xffff00)
                            color = 255;
                        if(color == 49152)
                            color = 0xffffff;
                    }
                    for(int l6 = y + font.maxh; s.length() > 0; l6 += font.maxh)
                    {
                        if(s.indexOf("%") != -1)
                        {
                            do
                            {
                                int k7 = s.indexOf("%1");
                                if(k7 == -1)
                                    break;
                                s = s.substring(0, k7) + method93(369, calcWidgetState(341, childwidget, 0)) + s.substring(k7 + 2);
                            } while(true);
                            do
                            {
                                int l7 = s.indexOf("%2");
                                if(l7 == -1)
                                    break;
                                s = s.substring(0, l7) + method93(369, calcWidgetState(341, childwidget, 1)) + s.substring(l7 + 2);
                            } while(true);
                            do
                            {
                                int i8 = s.indexOf("%3");
                                if(i8 == -1)
                                    break;
                                s = s.substring(0, i8) + method93(369, calcWidgetState(341, childwidget, 2)) + s.substring(i8 + 2);
                            } while(true);
                            do
                            {
                                int j8 = s.indexOf("%4");
                                if(j8 == -1)
                                    break;
                                s = s.substring(0, j8) + method93(369, calcWidgetState(341, childwidget, 3)) + s.substring(j8 + 2);
                            } while(true);
                            do
                            {
                                int k8 = s.indexOf("%5");
                                if(k8 == -1)
                                    break;
                                s = s.substring(0, k8) + method93(369, calcWidgetState(341, childwidget, 4)) + s.substring(k8 + 2);
                            } while(true);
                        }
                        int l8 = s.indexOf("\\n");
                        String text;
                        if(l8 != -1)
                        {
                            text = s.substring(0, l8);
                            s = s.substring(l8 + 2);
                        } else
                        {
                            text = s;
                            s = "";
                        }
                        if(childwidget.centerx)
                            font.drawCenteredXText(color, x + childwidget.width / 2, anInt939, text, l6, childwidget.shadowtext);
                        else
                            font.drawText2(false, childwidget.shadowtext, x, color, text, l6);
                    }

                } else
                if(childwidget.widgettype == 5)
                {
                    DirectColorSprite class30_sub2_sub1_sub1;
                    if(isWidgetHiddenActive(childwidget, false))
                        class30_sub2_sub1_sub1 = childwidget.aClass30_Sub2_Sub1_Sub1_260;
                    else
                        class30_sub2_sub1_sub1 = childwidget.aClass30_Sub2_Sub1_Sub1_207;
                    if(class30_sub2_sub1_sub1 != null)
                        class30_sub2_sub1_sub1.drawOverlay(x, 16083, y);
                } else
                if(childwidget.widgettype == 6)
                {
                    int k3 = TriangleRasterizer.midwidth;
                    int j4 = TriangleRasterizer.midheight;
                    TriangleRasterizer.midwidth = x + childwidget.width / 2;
                    TriangleRasterizer.midheight = y + childwidget.height / 2;
                    int i5 = TriangleRasterizer.sine_table[childwidget.anInt270] * childwidget.anInt269 >> 16;
                    int l5 = TriangleRasterizer.cosine_table[childwidget.anInt270] * childwidget.anInt269 >> 16;
                    boolean flag2 = isWidgetHiddenActive(childwidget, false);
                    int i7;
                    if(flag2)
                        i7 = childwidget.anInt258;
                    else
                        i7 = childwidget.anInt257;
                    Model model;
                    if(i7 == -1)
                    {
                        model = childwidget.method209(0, -1, -1, flag2);
                    } else
                    {
                        AnimSequence sequence = AnimSequence.animationsequences[i7];
                        model = childwidget.method209(0, sequence.anIntArray354[childwidget.anInt246], sequence.anIntArray353[childwidget.anInt246], flag2);
                    }
                    if(model != null)
                        model.drawModel(0, childwidget.anInt271, 0, childwidget.anInt270, 0, i5, l5);
                    TriangleRasterizer.midwidth = k3;
                    TriangleRasterizer.midheight = j4;
                } else
                if(childwidget.widgettype == 7)
                {
                    RSFont class30_sub2_sub1_sub4_1 = childwidget.itemfont;
                    int k4 = 0;
                    for(int j5 = 0; j5 < childwidget.height; j5++)
                    {
                        for(int i6 = 0; i6 < childwidget.width; i6++)
                        {
                            if(childwidget.itemarray[k4] > 0)
                            {
                                ItemDefinition class8 = ItemDefinition.getItemDefinition(childwidget.itemarray[k4] - 1);
                                String s2 = class8.name;
                                if(class8.aBoolean176 || childwidget.itemamounts[k4] != 1)
                                    s2 = s2 + " x" + method14(childwidget.itemamounts[k4], 0);
                                int i9 = x + i6 * (115 + childwidget.anInt231);
                                int k9 = y + j5 * (12 + childwidget.anInt244);
                                if(childwidget.centerx)
                                    class30_sub2_sub1_sub4_1.drawCenteredXText(childwidget.anInt232, i9 + childwidget.width / 2, anInt939, s2, k9, childwidget.shadowtext);
                                else
                                    class30_sub2_sub1_sub4_1.drawText2(false, childwidget.shadowtext, i9, childwidget.anInt232, s2, k9);
                            }
                            k4++;
                        }

                    }

                }
        }

        Raster.setDimensions(prevwidth, prevwidthoffset, prevheight, prevheightoffset);
    }

    public void method106(IndexedColorSprite class30_sub2_sub1_sub2, int i)
    {
        int j = 256;
        if(i >= 0)
            packetbuffer.put(126);
        for(int k = 0; k < anIntArray1190.length; k++)
            anIntArray1190[k] = 0;

        for(int l = 0; l < 5000; l++)
        {
            int i1 = (int)(Math.random() * 128D * (double)j);
            anIntArray1190[i1] = (int)(Math.random() * 256D);
        }

        for(int j1 = 0; j1 < 20; j1++)
        {
            for(int k1 = 1; k1 < j - 1; k1++)
            {
                for(int i2 = 1; i2 < 127; i2++)
                {
                    int k2 = i2 + (k1 << 7);
                    anIntArray1191[k2] = (anIntArray1190[k2 - 1] + anIntArray1190[k2 + 1] + anIntArray1190[k2 - 128] + anIntArray1190[k2 + 128]) / 4;
                }

            }

            int ai[] = anIntArray1190;
            anIntArray1190 = anIntArray1191;
            anIntArray1191 = ai;
        }

        if(class30_sub2_sub1_sub2 != null)
        {
            int l1 = 0;
            for(int j2 = 0; j2 < class30_sub2_sub1_sub2.indexheight_; j2++)
            {
                for(int l2 = 0; l2 < class30_sub2_sub1_sub2.indexwidth_; l2++)
                    if(class30_sub2_sub1_sub2.colorindex[l1++] != 0)
                    {
                        int i3 = l2 + 16 + class30_sub2_sub1_sub2.anInt1454;
                        int j3 = j2 + 16 + class30_sub2_sub1_sub2.anInt1455;
                        int k3 = i3 + (j3 << 7);
                        anIntArray1190[k3] = 0;
                    }

            }

        }
    }

    public void parsePlayerUpdateMasks(int i, int j, Buffer buffer0, byte byte0, Player class30_sub2_sub4_sub1_sub2)
    {
        if(byte0 != 25)
            grounditems = null;
		/* Force walk */
        if((i & 0x400) != 0)
        {
            class30_sub2_sub4_sub1_sub2.forcewlk_startx = buffer0.getUSpecialB(2);
            class30_sub2_sub4_sub1_sub2.forcewlk_starty = buffer0.getUSpecialB(2);
            class30_sub2_sub4_sub1_sub2.forcewlk_endx = buffer0.getUSpecialB(2);
            class30_sub2_sub4_sub1_sub2.forcewlk_endy = buffer0.getUSpecialB(2);
            class30_sub2_sub4_sub1_sub2.forcewlk_sp1 = buffer0.getShortLE128((byte)-74) + loopcycle;
            class30_sub2_sub4_sub1_sub2.forcewlk_sp2 = buffer0.getShort128(true) + loopcycle;
            class30_sub2_sub4_sub1_sub2.forcewlk_dir = buffer0.getUSpecialB(2);
            class30_sub2_sub4_sub1_sub2.method446(true);
        }
        if((i & 0x100) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1520 = buffer0.getShortLE((byte)108);
            int k = buffer0.getInt();
            class30_sub2_sub4_sub1_sub2.anInt1524 = k >> 16;
            class30_sub2_sub4_sub1_sub2.anInt1523 = loopcycle + (k & 0xffff);
            class30_sub2_sub4_sub1_sub2.anInt1521 = 0;
            class30_sub2_sub4_sub1_sub2.anInt1522 = 0;
            if(((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1523 > loopcycle)
                class30_sub2_sub4_sub1_sub2.anInt1521 = -1;
            if(((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1520 == 65535)
                class30_sub2_sub4_sub1_sub2.anInt1520 = -1;
        }
		/* Animation */
        if((i & 8) != 0)
        {
            int l = buffer0.getShortLE((byte)108);
            if(l == 65535)
                l = -1;
            int i2 = buffer0.getUSpecialA(false);
            if(l == ((Mob) (class30_sub2_sub4_sub1_sub2)).animid_request && l != -1)
            {
                int i3 = AnimSequence.animationsequences[l].anInt365;
                if(i3 == 1) {
                    class30_sub2_sub4_sub1_sub2.anInt1527 = 0;
                    class30_sub2_sub4_sub1_sub2.anInt1528 = 0;
                    class30_sub2_sub4_sub1_sub2.animdelay_request = i2;
                    class30_sub2_sub4_sub1_sub2.anInt1530 = 0;
                }
                if(i3 == 2)
                    class30_sub2_sub4_sub1_sub2.anInt1530 = 0;
            } else
            if(l == -1 || ((Mob) (class30_sub2_sub4_sub1_sub2)).animid_request == -1 || AnimSequence.animationsequences[l].anInt359 >= AnimSequence.animationsequences[((Mob) (class30_sub2_sub4_sub1_sub2)).animid_request].anInt359)
            {
                class30_sub2_sub4_sub1_sub2.animid_request = l;
                class30_sub2_sub4_sub1_sub2.anInt1527 = 0;
                class30_sub2_sub4_sub1_sub2.anInt1528 = 0;
                class30_sub2_sub4_sub1_sub2.animdelay_request = i2;
                class30_sub2_sub4_sub1_sub2.anInt1530 = 0;
                class30_sub2_sub4_sub1_sub2.anInt1542 = ((Mob) (class30_sub2_sub4_sub1_sub2)).stack_position_mob;
            }
        }
        if((i & 4) != 0)
        {
            class30_sub2_sub4_sub1_sub2.chat_txt = buffer0.getCStr();
            if(((Mob) (class30_sub2_sub4_sub1_sub2)).chat_txt.charAt(0) == '~')
            {
                class30_sub2_sub4_sub1_sub2.chat_txt = ((Mob) (class30_sub2_sub4_sub1_sub2)).chat_txt.substring(1);
                pushMessage(((Mob) (class30_sub2_sub4_sub1_sub2)).chat_txt, 2, class30_sub2_sub4_sub1_sub2.name, aBoolean991);
            } else
            if(class30_sub2_sub4_sub1_sub2 == localplayer)
                pushMessage(((Mob) (class30_sub2_sub4_sub1_sub2)).chat_txt, 2, class30_sub2_sub4_sub1_sub2.name, aBoolean991);
            class30_sub2_sub4_sub1_sub2.anInt1513 = 0;
            class30_sub2_sub4_sub1_sub2.anInt1531 = 0;
            class30_sub2_sub4_sub1_sub2.anInt1535 = 150;
        }
        if((i & 0x80) != 0)
        {
            int i1 = buffer0.getShortLE((byte)108);
            int j2 = buffer0.getUByte();
            int j3 = buffer0.getUSpecialA(false);
            int k3 = buffer0.position;
            if(class30_sub2_sub4_sub1_sub2.name != null && class30_sub2_sub4_sub1_sub2.updated)
            {
                long l3 = TextUtils.stringToLong(class30_sub2_sub4_sub1_sub2.name);
                boolean flag = false;
                if(j2 <= 1)
                {
                    for(int i4 = 0; i4 < amt_ignorehashes; i4++)
                    {
                        if(ignore_hashes[i4] != l3)
                            continue;
                        flag = true;
                        break;
                    }

                }
                if(!flag && ontutorial_island == 0)
                    try
                    {
                        aClass30_Sub2_Sub2_834.position = 0;
                        buffer0.putBytes(j3, 0, true, aClass30_Sub2_Sub2_834.payload);
                        aClass30_Sub2_Sub2_834.position = 0;
                        String s = ChatUtils.method525(j3, true, aClass30_Sub2_Sub2_834);
                        s = Censor.censor(s, 0);
                        class30_sub2_sub4_sub1_sub2.chat_txt = s;
                        class30_sub2_sub4_sub1_sub2.anInt1513 = i1 >> 8;
                        class30_sub2_sub4_sub1_sub2.anInt1531 = i1 & 0xff;
                        class30_sub2_sub4_sub1_sub2.anInt1535 = 150;
                        if(j2 == 2 || j2 == 3)
                            pushMessage(s, 1, "@cr2@" + class30_sub2_sub4_sub1_sub2.name, aBoolean991);
                        else
                        if(j2 == 1)
                            pushMessage(s, 1, "@cr1@" + class30_sub2_sub4_sub1_sub2.name, aBoolean991);
                        else
                            pushMessage(s, 2, class30_sub2_sub4_sub1_sub2.name, aBoolean991);
                    }
                    catch(Exception exception)
                    {
                        signlink.reporterror("cde2");
                    }
            }
            buffer0.position = k3 + j3;
        }
        if((i & 1) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1502 = buffer0.getShortLE((byte)108);
            if(((Mob) (class30_sub2_sub4_sub1_sub2)).anInt1502 == 65535)
                class30_sub2_sub4_sub1_sub2.anInt1502 = -1;
        }
        if((i & 0x10) != 0)
        {
            int j1 = buffer0.getUSpecialA(false);
            byte abyte0[] = new byte[j1];
            Buffer class30_sub2_sub2_1 = new Buffer(abyte0);
            buffer0.getBytes(j1, aByte920, 0, abyte0);
            appearancebuffers[j] = class30_sub2_sub2_1;
            class30_sub2_sub4_sub1_sub2.parseAppearanceUpdate(0, class30_sub2_sub2_1);
        }
        if((i & 2) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1538 = buffer0.getShortLE128((byte)-74);
            class30_sub2_sub4_sub1_sub2.anInt1539 = buffer0.getShortLE((byte)108);
        }
        if((i & 0x20) != 0)
        {
            int k1 = buffer0.getUByte();
            int k2 = buffer0.getUByte128(0);
            class30_sub2_sub4_sub1_sub2.pushHit(-35698, k2, k1, loopcycle);
            class30_sub2_sub4_sub1_sub2.anInt1532 = loopcycle + 300;
            class30_sub2_sub4_sub1_sub2.anInt1533 = buffer0.getUSpecialA(false);
            class30_sub2_sub4_sub1_sub2.anInt1534 = buffer0.getUByte();
        }
        if((i & 0x200) != 0)
        {
            int l1 = buffer0.getUByte();
            int l2 = buffer0.getUSpecialB(2);
            class30_sub2_sub4_sub1_sub2.pushHit(-35698, l2, l1, loopcycle);
            class30_sub2_sub4_sub1_sub2.anInt1532 = loopcycle + 300;
            class30_sub2_sub4_sub1_sub2.anInt1533 = buffer0.getUByte();
            class30_sub2_sub4_sub1_sub2.anInt1534 = buffer0.getUSpecialA(false);
        }
    }

    public void handleKeyboardArrows(int i)
    {
        if(i != 3)
            packetnum = -1;
        try
        {
            int finex = ((Mob) (localplayer)).fineposx + anInt1278;
            int finey = ((Mob) (localplayer)).fineposy + anInt1131;
            if(anInt1014 - finex < -500 || anInt1014 - finex > 500 || anInt1015 - finey < -500 || anInt1015 - finey > 500)
            {
                anInt1014 = finex;
                anInt1015 = finey;
            }
            if(anInt1014 != finex)
                anInt1014 += (finex - anInt1014) / 16;
            if(anInt1015 != finey)
                anInt1015 += (finey - anInt1015) / 16;
            /* Left */
            if(super.active_keycodes[1] == 1)
                camerayawrate += (-24 - camerayawrate) / 2;
            /* Right */
            else
            if(super.active_keycodes[2] == 1)
                camerayawrate += (24 - camerayawrate) / 2;
            /* Up */
            else
                camerayawrate /= 2;
            if(super.active_keycodes[3] == 1)
                camerayrate += (12 - camerayrate) / 2;
            /* Down */
            else
            if(super.active_keycodes[4] == 1)
                camerayrate += (-12 - camerayrate) / 2;
            else
                camerayrate /= 2;
            camerayaw = camerayaw + camerayawrate / 2 & 0x7ff;
            camerapitch += camerayrate / 2;
            if(camerapitch < 128)
                camerapitch = 128;
            if(camerapitch > 383)
                camerapitch = 383;
            int l = anInt1014 >> 7;
            int i1 = anInt1015 >> 7;
            int j1 = calculateTileHeight(anInt1014, anInt1015, cheight);
            int k1 = 0;
            if(l > 3 && i1 > 3 && l < 100 && i1 < 100)
            {
                for(int l1 = l - 4; l1 <= l + 4; l1++)
                {
                    for(int k2 = i1 - 4; k2 <= i1 + 4; k2++)
                    {
                        int l2 = cheight;
                        if(l2 < 3 && (main_tilesettings[1][l1][k2] & 2) == 2)
                            l2++;
                        int i3 = j1 - main_heightmap[l2][l1][k2];
                        if(i3 > k1)
                            k1 = i3;
                    }

                }

            }
            anInt1005++;
            if(anInt1005 > 1512)
            {
                anInt1005 = 0;
                packetbuffer.putPacket(77);
                packetbuffer.put(0);
                int i2 = packetbuffer.position;
                packetbuffer.put((int)(Math.random() * 256D));
                packetbuffer.put(101);
                packetbuffer.put(233);
                packetbuffer.putShort(45092);
                if((int)(Math.random() * 2D) == 0)
                    packetbuffer.putShort(35784);
                packetbuffer.put((int)(Math.random() * 256D));
                packetbuffer.put(64);
                packetbuffer.put(38);
                packetbuffer.putShort((int)(Math.random() * 65536D));
                packetbuffer.putShort((int)(Math.random() * 65536D));
                packetbuffer.finishByteVar(packetbuffer.position - i2, (byte)0);
            }
            int j2 = k1 * 192;
            if(j2 > 0x17f00)
                j2 = 0x17f00;
            if(j2 < 32768)
                j2 = 32768;
            if(j2 > anInt984)
            {
                anInt984 += (j2 - anInt984) / 24;
                return;
            }
            if(j2 < anInt984)
            {
                anInt984 += (j2 - anInt984) / 80;
                return;
            }
        }
        catch(Exception _ex)
        {
            signlink.reporterror("glfc_ex " + ((Mob) (localplayer)).fineposx + "," + ((Mob) (localplayer)).fineposy + "," + anInt1014 + "," + anInt1015 + "," + chunkx_ + "," + chunky_ + "," + palettex + "," + palettey);
            throw new RuntimeException("eek");
        }
    }

    public void handleDrawCycle(int junk)
    {
        if(aBoolean1252 || aBoolean926 || aBoolean1176)
        {
            method94(-13873);
            return;
        }
        draw_cycle++;
        if(!aBoolean1157)
            drawTitleScreen(false, false);
        else
            drawGameScreen(true);
        anInt1213 = 0;
    }

    public boolean onFriendsList(boolean flag, String s)
    {
        if(s == null)
            return false;
        for(int i = 0; i < amt_friendhashes; i++)
            if(s.equalsIgnoreCase(friendusernames[i]))
                return true;

        if(flag)
            packetbuffer.put(138);
        return s.equalsIgnoreCase(localplayer.name);
    }

    public static String getLevelColor(int i, int j, boolean junk)
    {
        int k = i - j;
        if(k < -9)
            return "@red@";
        if(k < -6)
            return "@or3@";
        if(k < -3)
            return "@or2@";
        if(k < 0)
            return "@or1@";
        if(k > 9)
            return "@gre@";
        if(k > 6)
            return "@gr3@";
        if(k > 3)
            return "@gr2@";
        if(k > 0)
            return "@gr1@";
        else
            return "@yel@";
    }

    public void method111(byte byte0, int i)
    {
        if(byte0 == 2)
            byte0 = 0;
        else
            loadClient();
        signlink.wavevol = i;
    }

    public void method112(int i)
    {
        if(i != 8)
            anInt939 = 130;
        method76((byte)-13);
        if(anInt917 == 1)
        {
            cross_sprites[anInt916 / 100].drawOverlay(anInt914 - 8 - 4, 16083, anInt915 - 8 - 4);
            anInt1142++;
            if(anInt1142 > 67)
            {
                anInt1142 = 0;
                packetbuffer.putPacket(78);
            }
        }
        if(anInt917 == 2)
            cross_sprites[4 + anInt916 / 100].drawOverlay(anInt914 - 8 - 4, 16083, anInt915 - 8 - 4);
        if(anInt1018 != -1)
        {
            method119(anInt945, false, anInt1018);
            drawWidget(Widget.widgets[anInt1018],0, 0, 0);
        }
        if(anInt857 != -1)
        {
            method119(anInt945, false, anInt857);
            drawWidget(Widget.widgets[anInt857],0, 0, 0);
        }
        calculateOntutorialIsland(184);
        if(!aBoolean885)
        {
            method82(0);
            method125(45706);
        } else
        if(clickarea == 0)
            method40((byte)9);
        if(anInt1055 == 1)
            headicons[1].drawOverlay(472, 16083, 296);
        if(drawfps)
        {
            char c = '\u01FB';
            int k = 20;
            int i1 = 0xffff00;
            if(super.fps < 15)
                i1 = 0xff0000;
            p12_font.drawHeightAlignedText("Fps:" + super.fps, c, i1, (byte)-80, k);
            k += 15;
            Runtime runtime = Runtime.getRuntime();
            int j1 = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
            i1 = 0xffff00;
            if(j1 > 0x2000000 && lowmemory)
                i1 = 0xff0000;
            p12_font.drawHeightAlignedText("Mem:" + j1 + "k", c, 0xffff00, (byte)-80, k);
            k += 15;
        }
        if(anInt1104 != 0)
        {
            int j = anInt1104 / 50;
            int l = j / 60;
            j %= 60;
            if(j < 10)
                p12_font.drawText(0xffff00, "System update in: " + l + ":0" + j, 329, 822, 4);
            else
                p12_font.drawText(0xffff00, "System update in: " + l + ":" + j, 329, 822, 4);
            anInt849++;
            if(anInt849 > 75)
            {
                anInt849 = 0;
                packetbuffer.putPacket(148);
            }
        }
    }

    public void method113(long l, int i)
    {
        try
        {
            if(l == 0L)
                return;
            if(amt_ignorehashes >= 100)
            {
                pushMessage("Your ignore list is full. Max of 100 hit", 0, "", aBoolean991);
                return;
            }
            String s = TextUtils.formatUsername(-45804, TextUtils.longToString(l, (byte)-99));
            for(int j = 0; j < amt_ignorehashes; j++)
                if(ignore_hashes[j] == l)
                {
                    pushMessage(s + " is already on your ignore list", 0, "", aBoolean991);
                    return;
                }

            if(i < 4 || i > 4)
                return;
            for(int k = 0; k < amt_friendhashes; k++)
                if(friend_hashes[k] == l)
                {
                    pushMessage("Please remove " + s + " from your friend list first", 0, "", aBoolean991);
                    return;
                }

            ignore_hashes[amt_ignorehashes++] = l;
            aBoolean1153 = true;
            packetbuffer.putPacket(133);
            packetbuffer.putLong(l);
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("45688, " + l + ", " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void updatePlayersOrientations(byte byte0)
    {
        if(byte0 != aByte973)
            return;
        for(int i = -1; i < anInt891; i++)
        {
            int j;
            if(i == -1)
                j = localindex;
            else
                j = anIntArray892[i];
            Player class30_sub2_sub4_sub1_sub2 = players[j];
            if(class30_sub2_sub4_sub1_sub2 != null)
                updateMobOrentation(46988, 1, class30_sub2_sub4_sub1_sub2);
        }

    }

    public void updateSpawnedObjects_(byte byte0)
    {
        if(byte0 == 8)
            byte0 = 0;
        else
            packetbuffer.put(101);
        if(landscape_stage == 2)
        {
            for(SpawnedObject class30_sub1 = (SpawnedObject)aClass19_1179.getFirst(); class30_sub1 != null; class30_sub1 = (SpawnedObject)aClass19_1179.getNextForwards(false))
            {
                if(class30_sub1.anInt1294 > 0)
                    class30_sub1.anInt1294--;
                if(class30_sub1.anInt1294 == 0)
                {
                    if(class30_sub1.anInt1299 < 0 || MapLoader.method178(class30_sub1.anInt1299, class30_sub1.anInt1301, 8))
                    {
                        method142(class30_sub1.pallete_y, class30_sub1.cheight, class30_sub1.anInt1300, class30_sub1.anInt1301, class30_sub1.pallete_x, class30_sub1.type_num, class30_sub1.anInt1299, 4);
                        class30_sub1.removeDeque();
                    }
                } else
                {
                    if(class30_sub1.anInt1302 > 0)
                        class30_sub1.anInt1302--;
                    if(class30_sub1.anInt1302 == 0 && class30_sub1.pallete_x >= 1 && class30_sub1.pallete_y >= 1 && class30_sub1.pallete_x <= 102 && class30_sub1.pallete_y <= 102 && (class30_sub1.objid < 0 || MapLoader.method178(class30_sub1.objid, class30_sub1.type, 8)))
                    {
                        method142(class30_sub1.pallete_y, class30_sub1.cheight, class30_sub1.rotation, class30_sub1.type, class30_sub1.pallete_x, class30_sub1.type_num, class30_sub1.objid, 4);
                        class30_sub1.anInt1302 = -1;
                        if(class30_sub1.objid == class30_sub1.anInt1299 && class30_sub1.anInt1299 == -1)
                            class30_sub1.removeDeque();
                        else
                        if(class30_sub1.objid == class30_sub1.anInt1299 && class30_sub1.rotation == class30_sub1.anInt1300 && class30_sub1.type == class30_sub1.anInt1301)
                            class30_sub1.removeDeque();
                    }
                }
            }

        }
    }

    public void method116(boolean flag)
    {
        int i = b12_font.widthFontMetrics(anInt1116, "Choose Option");
        aBoolean1157 &= flag;
        for(int j = 0; j < anInt1133; j++)
        {
            int k = b12_font.widthFontMetrics(anInt1116, interfacestringstack[j]);
            if(k > i)
                i = k;
        }

        i += 8;
        int l = 15 * anInt1133 + 21;
        if(super.curpressed_x > 4 && super.curpressed_y > 4 && super.curpressed_x < 516 && super.curpressed_y < 338)
        {
            int i1 = super.curpressed_x - 4 - i / 2;
            if(i1 + i > 512)
                i1 = 512 - i;
            if(i1 < 0)
                i1 = 0;
            int l1 = super.curpressed_y - 4;
            if(l1 + l > 334)
                l1 = 334 - l;
            if(l1 < 0)
                l1 = 0;
            aBoolean885 = true;
            clickarea = 0;
            anInt949 = i1;
            anInt950 = l1;
            anInt951 = i;
            anInt952 = 15 * anInt1133 + 22;
        }
        if(super.curpressed_x > 553 && super.curpressed_y > 205 && super.curpressed_x < 743 && super.curpressed_y < 466)
        {
            int j1 = super.curpressed_x - 553 - i / 2;
            if(j1 < 0)
                j1 = 0;
            else
            if(j1 + i > 190)
                j1 = 190 - i;
            int i2 = super.curpressed_y - 205;
            if(i2 < 0)
                i2 = 0;
            else
            if(i2 + l > 261)
                i2 = 261 - l;
            aBoolean885 = true;
            clickarea = 1;
            anInt949 = j1;
            anInt950 = i2;
            anInt951 = i;
            anInt952 = 15 * anInt1133 + 22;
        }
        if(super.curpressed_x > 17 && super.curpressed_y > 357 && super.curpressed_x < 496 && super.curpressed_y < 453)
        {
            int k1 = super.curpressed_x - 17 - i / 2;
            if(k1 < 0)
                k1 = 0;
            else
            if(k1 + i > 479)
                k1 = 479 - i;
            int j2 = super.curpressed_y - 357;
            if(j2 < 0)
                j2 = 0;
            else
            if(j2 + l > 96)
                j2 = 96 - l;
            aBoolean885 = true;
            clickarea = 2;
            anInt949 = k1;
            anInt950 = j2;
            anInt951 = i;
            anInt952 = 15 * anInt1133 + 22;
        }
    }

    public void method117(Buffer buffer0, int i, byte byte0)
    {
        buffer0.initBitAccess(anInt1118);
        if(byte0 == 5)
            byte0 = 0;
        else
            packetnum = buffer0.getUByte();
        int j = buffer0.getBits(1, 0);
        if(j == 0)
            return;
        int k = buffer0.getBits(2, 0);
        if(k == 0)
        {
            playerupdate_stack[amtplayerupdatestack++] = localindex;
            return;
        }
        if(k == 1)
        {
            int l = buffer0.getBits(3, 0);
            localplayer.handleMobMovment(false, (byte)20, l);
            int k1 = buffer0.getBits(1, 0);
            if(k1 == 1)
                playerupdate_stack[amtplayerupdatestack++] = localindex;
            return;
        }
        if(k == 2)
        {
            int i1 = buffer0.getBits(3, 0);
            localplayer.handleMobMovment(true, (byte)20, i1);
            int l1 = buffer0.getBits(3, 0);
            localplayer.handleMobMovment(true, (byte)20, l1);
            int j2 = buffer0.getBits(1, 0);
            if(j2 == 1)
                playerupdate_stack[amtplayerupdatestack++] = localindex;
            return;
        }
        if(k == 3)
        {
            cheight = buffer0.getBits(2, 0);
            int j1 = buffer0.getBits(1, 0);
            int i2 = buffer0.getBits(1, 0);
            if(i2 == 1)
                playerupdate_stack[amtplayerupdatestack++] = localindex;
            int k2 = buffer0.getBits(7, 0);
            int l2 = buffer0.getBits(7, 0);
            localplayer.updateMobPosition(l2, k2, j1 == 1, false);
        }
    }

    public void method118(int i)
    {
        runflamecycle = false;
        while(aBoolean962) 
        {
            runflamecycle = false;
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }
        }
        aClass30_Sub2_Sub1_Sub2_966 = null;
        aClass30_Sub2_Sub1_Sub2_967 = null;
        titlescreen_sprites = null;
        anIntArray850 = null;
        anIntArray851 = null;
        anIntArray852 = null;
        anIntArray853 = null;
        anIntArray1190 = null;
        anIntArray1191 = null;
        anIntArray828 = null;
        anIntArray829 = null;
        aClass30_Sub2_Sub1_Sub1_1201 = null;
        aClass30_Sub2_Sub1_Sub1_1202 = null;
        if(i < 3 || i > 3)
            grounditems = null;
    }

    public boolean method119(int i, boolean flag, int j)
    {
        boolean flag1 = false;
        if(flag)
            throw new NullPointerException();
        Widget class9 = Widget.widgets[j];
        for(int k = 0; k < class9.childrenwidgets.length; k++)
        {
            if(class9.childrenwidgets[k] == -1)
                break;
            Widget class9_1 = Widget.widgets[class9.childrenwidgets[k]];
            if(class9_1.widgettype == 1)
                flag1 |= method119(i, false, class9_1.widgetid);
            if(class9_1.widgettype == 6 && (class9_1.anInt257 != -1 || class9_1.anInt258 != -1))
            {
                boolean flag2 = isWidgetHiddenActive(class9_1, false);
                int l;
                if(flag2)
                    l = class9_1.anInt258;
                else
                    l = class9_1.anInt257;
                if(l != -1)
                {
                    AnimSequence class20 = AnimSequence.animationsequences[l];
                    for(class9_1.anInt208 += i; class9_1.anInt208 > class20.method258(class9_1.anInt246, (byte)-39);)
                    {
                        class9_1.anInt208 -= class20.method258(class9_1.anInt246, (byte)-39) + 1;
                        class9_1.anInt246++;
                        if(class9_1.anInt246 >= class20.anInt352)
                        {
                            class9_1.anInt246 -= class20.anInt356;
                            if(class9_1.anInt246 < 0 || class9_1.anInt246 >= class20.anInt352)
                                class9_1.anInt246 = 0;
                        }
                        flag1 = true;
                    }

                }
            }
        }

        return flag1;
    }

    public int calculateCameraHeight1()
    {
        int j = 3;
        if(camerapitch$ < 310)
        {
            int camx = camerax >> 7;
            int camy = cameray >> 7;
            int plrx = ((Mob) (localplayer)).fineposx >> 7;
            int plry = ((Mob) (localplayer)).fineposy >> 7;
            if((main_tilesettings[cheight][camx][camy] & 4) != 0)
                j = cheight;
            int dx;
            if(plrx > camx)
                dx = plrx - camx;
            else
                dx = camx - plrx;
            int dy;
            if(plry > camy)
                dy = plry - camy;
            else
                dy = camy - plry;
            if(dx > dy)
            {
                int i2 = (dy * 0x10000) / dx;
                int k2 = 32768;
                while(camx != plrx)
                {
                    if(camx < plrx)
                        camx++;
                    else
                    if(camx > plrx)
                        camx--;
                    if((main_tilesettings[cheight][camx][camy] & 4) != 0)
                        j = cheight;
                    k2 += i2;
                    if(k2 >= 0x10000)
                    {
                        k2 -= 0x10000;
                        if(camy < plry)
                            camy++;
                        else
                        if(camy > plry)
                            camy--;
                        if((main_tilesettings[cheight][camx][camy] & 4) != 0)
                            j = cheight;
                    }
                }
            } else
            {
                int j2 = (dx * 0x10000) / dy;
                int l2 = 32768;
                while(camy != plry)
                {
                    if(camy < plry)
                        camy++;
                    else
                    if(camy > plry)
                        camy--;
                    if((main_tilesettings[cheight][camx][camy] & 4) != 0)
                        j = cheight;
                    l2 += j2;
                    if(l2 >= 0x10000)
                    {
                        l2 -= 0x10000;
                        if(camx < plrx)
                            camx++;
                        else
                        if(camx > plrx)
                            camx--;
                        if((main_tilesettings[cheight][camx][camy] & 4) != 0)
                            j = cheight;
                    }
                }
            }
        }
        if((main_tilesettings[cheight][((Mob) (localplayer)).fineposx >> 7][((Mob) (localplayer)).fineposy >> 7] & 4) != 0)
            j = cheight;
        return j;
    }

    public int calculateCameraHeight2()
    {
        int j = calculateTileHeight(camerax, cameray, cheight);
        if(j - cameraz < 800 && (main_tilesettings[cheight][camerax >> 7][cameray >> 7] & 4) != 0)
            return cheight;
        else
            return 3;
    }

    public void method122(int i, long l)
    {
        try
        {
            if(i != 3)
                loadClient();
            if(l == 0L)
                return;
            for(int j = 0; j < amt_ignorehashes; j++)
                if(ignore_hashes[j] == l)
                {
                    amt_ignorehashes--;
                    aBoolean1153 = true;
                    for(int k = j; k < amt_ignorehashes; k++)
                        ignore_hashes[k] = ignore_hashes[k + 1];

                    packetbuffer.putPacket(74);
                    packetbuffer.putLong(l);
                    return;
                }

            return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("47229, " + i + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public String getParameter(String s)
    {
        if(signlink.mainapp != null)
            return signlink.mainapp.getParameter(s);
        else
            return super.getParameter(s);
    }

    public void volumeAdjustMidi(byte byte0, boolean flag, int i)
    {
        if(byte0 == 0)
            byte0 = 0;
        else
            grounditems = null;
        signlink.midivol = i;
        if(flag)
            signlink.midi = "voladjust";
    }

    public int calcWidgetState(int i, Widget class9, int j)
    {
        if(class9.anIntArrayArray226 == null || j >= class9.anIntArrayArray226.length)
            return -2;
        try
        {
            int opcodes[] = class9.anIntArrayArray226[j];
            int k = 0;
            int opcodeoffset = 0;
            int i1 = 0;
            do
            {
                int opcode = opcodes[opcodeoffset++];
                int value = 0;
                byte byte0 = 0;
                if(opcode == 0)
                    return k;
                if(opcode == 1)
                    value = skilllevels[opcodes[opcodeoffset++]];
                if(opcode == 2)
                    value = anIntArray1044[opcodes[opcodeoffset++]];
                if(opcode == 3)
                    value = skillxp[opcodes[opcodeoffset++]];
                if(opcode == 4)
                {
                    Widget class9_1 = Widget.widgets[opcodes[opcodeoffset++]];
                    int itemid = opcodes[opcodeoffset++];
                    if(itemid >= 0 && itemid < ItemDefinition.anInt203 && (!ItemDefinition.getItemDefinition(itemid).aBoolean161 || members))
                    {
                        for(int j3 = 0; j3 < class9_1.itemarray.length; j3++)
                            if(class9_1.itemarray[j3] == itemid + 1)
                                value += class9_1.itemamounts[j3];

                    }
                }
                if(opcode == 5)
                    value = configstates[opcodes[opcodeoffset++]];
                if(opcode == 6)
                    value = levelforxp[anIntArray1044[opcodes[opcodeoffset++]] - 1];
                if(opcode == 7)
                    value = (configstates[opcodes[opcodeoffset++]] * 100) / 46875;
                if(opcode == 8)
                    value = localplayer.combatlevel;
                if(opcode == 9)
                {
                    for(int l1 = 0; l1 < SkillConsts.amt_skills; l1++)
                        if(SkillConsts.skill_active[l1])
                            value += anIntArray1044[l1];
                }
                if(opcode == 10)
                {
                    Widget class9_2 = Widget.widgets[opcodes[opcodeoffset++]];
                    int l2 = opcodes[opcodeoffset++] + 1;
                    if(l2 >= 0 && l2 < ItemDefinition.anInt203 && (!ItemDefinition.getItemDefinition(l2).aBoolean161 || members))
                    {
                        for(int k3 = 0; k3 < class9_2.itemarray.length; k3++)
                        {
                            if(class9_2.itemarray[k3] != l2)
                                continue;
                            value = 0x3b9ac9ff;
                            break;
                        }

                    }
                }
                if(opcode == 11)
                    value = anInt1148;
                if(opcode == 12)
                    value = anInt878;
                if(opcode == 13)
                {
                    int i2 = configstates[opcodes[opcodeoffset++]];
                    int i3 = opcodes[opcodeoffset++];
                    value = (i2 & 1 << i3) == 0 ? 0 : 1;
                }
                if(opcode == 14)
                {
                    int j2 = opcodes[opcodeoffset++];
                    VarbitFile class37 = VarbitFile.aClass37Array646[j2];
                    int l3 = class37.config_num;
                    int i4 = class37.anInt649;
                    int j4 = class37.anInt650;
                    int k4 = varbit_masks[j4 - i4];
                    value = configstates[l3] >> i4 & k4;
                }
                if(opcode == 15)
                    byte0 = 1;
                if(opcode == 16)
                    byte0 = 2;
                if(opcode == 17)
                    byte0 = 3;
                if(opcode == 18)
                    value = (((Mob) (localplayer)).fineposx >> 7) + palettex;
                if(opcode == 19)
                    value = (((Mob) (localplayer)).fineposy >> 7) + palettey;
                if(opcode == 20)
                    value = opcodes[opcodeoffset++];
                if(byte0 == 0)
                {
                    if(i1 == 0)
                        k += value;
                    if(i1 == 1)
                        k -= value;
                    if(i1 == 2 && value != 0)
                        k /= value;
                    if(i1 == 3)
                        k *= value;
                    i1 = 0;
                } else
                {
                    i1 = byte0;
                }
            } while(true);
        }
        catch(Exception _ex)
        {
            return -1;
        }
    }

    public void method125(int i)
    {
        if(anInt1133 < 2 && anInt1282 == 0 && anInt1136 == 0)
            return;
        String s;
        if(anInt1282 == 1 && anInt1133 < 2)
            s = "Use " + aString1286 + " with...";
        else
        if(anInt1136 == 1 && anInt1133 < 2)
            s = aString1139 + "...";
        else
            s = interfacestringstack[anInt1133 - 1];
        if(anInt1133 > 2)
            s = s + "@whi@ / " + (anInt1133 - 2) + " more options";
        b12_font.method390(true, 4, 0xffffff, s, loopcycle / 1000, 973, 15);
        if(i != 45706)
        {
            for(int j = 1; j > 0; j++);
        }
    }

    public void drawMinimap(boolean flag)
    {
        if(flag)
            return;
        aClass15_1164.initialize(0);
        if(anInt1021 == 2)
        {
            byte abyte0[] = mapback.colorindex;
            int ai[] = Raster.output;
            int k2 = abyte0.length;
            for(int i5 = 0; i5 < k2; i5++)
                if(abyte0[i5] == 0)
                    ai[i5] = 0;

            compass.drawRotatedDegrees(33, camerayaw, anIntArray1057, 256, anIntArray968, -236, 25, 0, 0, 33, 25);
            toplefttext_imagefetcher.initialize(0);
            return;
        }
        int i = camerayaw + anInt1209 & 0x7ff;
        int j = 48 + ((Mob) (localplayer)).fineposx / 32;
        int l2 = 464 - ((Mob) (localplayer)).fineposy / 32;
        aClass30_Sub2_Sub1_Sub1_1263.drawRotatedDegrees(151, i, anIntArray1229, 256 + anInt1170, anIntArray1052, -236, l2, 5, 25, 146, j);
        compass.drawRotatedDegrees(33, camerayaw, anIntArray1057, 256, anIntArray968, -236, 25, 0, 0, 33, 25);
        for(int j5 = 0; j5 < mapfunctionstackpos; j5++)
        {
            int k = (anIntArray1072[j5] * 4 + 2) - ((Mob) (localplayer)).fineposx / 32;
            int i3 = (anIntArray1073[j5] * 4 + 2) - ((Mob) (localplayer)).fineposy / 32;
            drawOnMinimap(mapfunctionstack[j5], k, i3, false);
        }

        for(int k5 = 0; k5 < 104; k5++)
        {
            for(int l5 = 0; l5 < 104; l5++)
            {
                Deque class19 = grounditems[cheight][k5][l5];
                if(class19 != null)
                {
                    int l = (k5 * 4 + 2) - ((Mob) (localplayer)).fineposx / 32;
                    int j3 = (l5 * 4 + 2) - ((Mob) (localplayer)).fineposy / 32;
                    drawOnMinimap(grounditem_mapdotsprite, l, j3, false);
                }
            }

        }

        for(int i6 = 0; i6 < anInt836; i6++)
        {
            NPC class30_sub2_sub4_sub1_sub1 = npcs[updatenpcs[i6]];
            if(class30_sub2_sub4_sub1_sub1 != null && class30_sub2_sub4_sub1_sub1.hasDefinition(aBoolean1224))
            {
                NPCDefinition class5 = class30_sub2_sub4_sub1_sub1.definition;
                if(class5.confignpcs != null)
                    class5 = class5.method161(anInt877);
                if(class5 != null && class5.displaymapdot && class5.isvisible)
                {
                    int i1 = ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposx / 32 - ((Mob) (localplayer)).fineposx / 32;
                    int k3 = ((Mob) (class30_sub2_sub4_sub1_sub1)).fineposy / 32 - ((Mob) (localplayer)).fineposy / 32;
                    drawOnMinimap(mapdots1, i1, k3, false);
                }
            }
        }

        for(int j6 = 0; j6 < anInt891; j6++)
        {
            Player class30_sub2_sub4_sub1_sub2 = players[anIntArray892[j6]];
            if(class30_sub2_sub4_sub1_sub2 != null && class30_sub2_sub4_sub1_sub2.hasDefinition(aBoolean1224))
            {
                int j1 = ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposx / 32 - ((Mob) (localplayer)).fineposx / 32;
                int l3 = ((Mob) (class30_sub2_sub4_sub1_sub2)).fineposy / 32 - ((Mob) (localplayer)).fineposy / 32;
                boolean flag1 = false;
                long l6 = TextUtils.stringToLong(class30_sub2_sub4_sub1_sub2.name);
                for(int k6 = 0; k6 < amt_friendhashes; k6++)
                {
                    if(l6 != friend_hashes[k6] || anIntArray826[k6] == 0)
                        continue;
                    flag1 = true;
                    break;
                }

                boolean flag2 = false;
                if(localplayer.anInt1701 != 0 && class30_sub2_sub4_sub1_sub2.anInt1701 != 0 && localplayer.anInt1701 == class30_sub2_sub4_sub1_sub2.anInt1701)
                    flag2 = true;
                if(flag1)
                    drawOnMinimap(mapdots3, j1, l3, false);
                else
                if(flag2)
                    drawOnMinimap(mapdots4, j1, l3, false);
                else
                    drawOnMinimap(mapdots2, j1, l3, false);
            }
        }

        if(markertype != 0 && loopcycle % 20 < 10)
        {
            if(markertype == 1 && nmarker_id >= 0 && nmarker_id < npcs.length)
            {
                NPC class30_sub2_sub4_sub1_sub1_1 = npcs[nmarker_id];
                if(class30_sub2_sub4_sub1_sub1_1 != null)
                {
                    int k1 = ((Mob) (class30_sub2_sub4_sub1_sub1_1)).fineposx / 32 - ((Mob) (localplayer)).fineposx / 32;
                    int i4 = ((Mob) (class30_sub2_sub4_sub1_sub1_1)).fineposy / 32 - ((Mob) (localplayer)).fineposy / 32;
                    method81(mapmarker1, -760, i4, k1);
                }
            }
            if(markertype == 2)
            {
                int l1 = ((markerloc_x - palettex) * 4 + 2) - ((Mob) (localplayer)).fineposx / 32;
                int j4 = ((markerloc_y - palettey) * 4 + 2) - ((Mob) (localplayer)).fineposy / 32;
                method81(mapmarker1, -760, j4, l1);
            }
            if(markertype == 10 && pmarker_id >= 0 && pmarker_id < players.length)
            {
                Player class30_sub2_sub4_sub1_sub2_1 = players[pmarker_id];
                if(class30_sub2_sub4_sub1_sub2_1 != null)
                {
                    int i2 = ((Mob) (class30_sub2_sub4_sub1_sub2_1)).fineposx / 32 - ((Mob) (localplayer)).fineposx / 32;
                    int k4 = ((Mob) (class30_sub2_sub4_sub1_sub2_1)).fineposy / 32 - ((Mob) (localplayer)).fineposy / 32;
                    method81(mapmarker1, -760, k4, i2);
                }
            }
        }
        if(anInt1261 != 0)
        {
            int j2 = (anInt1261 * 4 + 2) - ((Mob) (localplayer)).fineposx / 32;
            int l4 = (anInt1262 * 4 + 2) - ((Mob) (localplayer)).fineposy / 32;
            drawOnMinimap(mapmarker0, j2, l4, false);
        }
        Raster.drawQuadrilateral(97, 78, 3, 3, 0xffffff);
        toplefttext_imagefetcher.initialize(0);
    }

    public void calculateSpriteMobXY(boolean junk, Mob mob, int height)
    {
        calculateSpriteXY(mob.fineposx, height, anInt875, mob.fineposy);
    }

    public void calculateSpriteXY(int x, int h, int junk, int y)
    {
        if(x < 128 || y < 128 || x > 13056 || y > 13056)
        {
            spriteX = -1;
            spriteY = -1;
            return;
        }
        int z = calculateTileHeight(x, y, cheight) - h;
        x -= camerax;
        z -= cameraz;
        y -= cameray;
        int pitchsine = Model.sinetable[camerapitch$];
        int pitchcosine = Model.cosinetable[camerapitch$];
        int yawsine = Model.sinetable[camerayaw$];
        int yawcosine = Model.cosinetable[camerayaw$];
        /* Z Axis rotation */
        int j2 = (y * yawsine + x * yawcosine) >> 16;
        y = (y * yawcosine - x * yawsine) >> 16;
        x = j2;
        /* X Axis rotation */
        j2 = (z * pitchcosine - y * pitchsine) >> 16;
        y = (z * pitchsine + y * pitchcosine) >> 16;
        z = j2;
        if(y >= 50)
        {
            spriteX = TriangleRasterizer.midwidth + (x << 9) / y;
            spriteY = TriangleRasterizer.midheight + (z << 9) / y;
            return;
        } else
        {
            spriteX = -1;
            spriteY = -1;
            return;
        }
    }

    public void method129(boolean flag)
    {
        if(anInt1195 == 0)
            return;
        int i = 0;
        if(flag)
            packetnum = -1;
        if(anInt1104 != 0)
            i = 1;
        for(int j = 0; j < 100; j++)
            if(msgbody_stack[j] != null)
            {
                int k = msgtype_stack[j];
                String s = msgprefix_stack[j];
                boolean flag1 = false;
                if(s != null && s.startsWith("@cr1@"))
                {
                    s = s.substring(5);
                    boolean flag2 = true;
                }
                if(s != null && s.startsWith("@cr2@"))
                {
                    s = s.substring(5);
                    byte byte0 = 2;
                }
                if((k == 3 || k == 7) && (k == 7 || anInt845 == 0 || anInt845 == 1 && onFriendsList(false, s)))
                {
                    int l = 329 - i * 13;
                    if(super.mouse_x > 4 && super.mouse_y - 4 > l - 10 && super.mouse_y - 4 <= l + 3)
                    {
                        int i1 = p12_font.widthFontMetrics(anInt1116, "From:  " + s + msgbody_stack[j]) + 25;
                        if(i1 > 450)
                            i1 = 450;
                        if(super.mouse_x < 4 + i1)
                        {
                            if(rights >= 1)
                            {
                                interfacestringstack[anInt1133] = "Report abuse @whi@" + s;
                                interfaceopcodestack[anInt1133] = 2606;
                                anInt1133++;
                            }
                            interfacestringstack[anInt1133] = "Add ignore @whi@" + s;
                            interfaceopcodestack[anInt1133] = 2042;
                            anInt1133++;
                            interfacestringstack[anInt1133] = "Add friend @whi@" + s;
                            interfaceopcodestack[anInt1133] = 2337;
                            anInt1133++;
                        }
                    }
                    if(++i >= 5)
                        return;
                }
                if((k == 5 || k == 6) && anInt845 < 2 && ++i >= 5)
                    return;
            }

    }

    public void addSpawnObject(int junk, int j, int k, int r, int tn, int py, int t, int h, int px, int j2) {
        SpawnedObject class30_sub1 = null;
        for(SpawnedObject class30_sub1_1 = (SpawnedObject) aClass19_1179.getFirst(); class30_sub1_1 != null; class30_sub1_1 = (SpawnedObject)aClass19_1179.getNextForwards(false))
        {
            if(class30_sub1_1.cheight != h || class30_sub1_1.pallete_x != px || class30_sub1_1.pallete_y != py || class30_sub1_1.type_num != tn)
                continue;
            class30_sub1 = class30_sub1_1;
            break;
        }
        if(class30_sub1 == null) {
            class30_sub1 = new SpawnedObject();
            class30_sub1.cheight = h;
            class30_sub1.type_num = tn;
            class30_sub1.pallete_x = px;
            class30_sub1.pallete_y = py;
            method89(false, class30_sub1);
            aClass19_1179.addLast(class30_sub1);
        }
        class30_sub1.objid = k;
        class30_sub1.type = t;
        class30_sub1.rotation = r;
        class30_sub1.anInt1302 = j2;
        class30_sub1.anInt1294 = j;
    }

    public boolean isWidgetHiddenActive(Widget class9, boolean flag)
    {
        if(class9.updateconditions == null)
            return false;
        for(int i = 0; i < class9.updateconditions.length; i++)
        {
            int j = calcWidgetState(341, class9, i);
            int k = class9.updatestates[i];
            if(class9.updateconditions[i] == 2)
            {
                if(j >= k)
                    return false;
            } else
            if(class9.updateconditions[i] == 3)
            {
                if(j <= k)
                    return false;
            } else
            if(class9.updateconditions[i] == 4)
            {
                if(j == k)
                    return false;
            } else
            if(j != k)
                return false;
        }

        return true;
    }

    public DataInputStream getJAGGRABRequest(String s)
        throws IOException
    {
        /* if(!aBoolean872)
            if(signlink.mainapp != null)
                return signlink.openurl(s);
            else
                return new DataInputStream((new URL(getCodeBase(), s)).openStream()); */
        if(jaggrab_socket != null)
        {
            try
            {
                jaggrab_socket.close();
            }
            catch(Exception _ex) { }
            jaggrab_socket = null;
        }
        jaggrab_socket = spawnSocket(43595);
        jaggrab_socket.setSoTimeout(10000);
        java.io.InputStream inputstream = jaggrab_socket.getInputStream();
        OutputStream outputstream = jaggrab_socket.getOutputStream();
        outputstream.write(("JAGGRAB /" + s + "\n\n").getBytes());
        return new DataInputStream(inputstream);
    }

    public void method133(byte byte0)
    {
        char c = '\u0100';
        if(anInt1040 > 0)
        {
            for(int i = 0; i < 256; i++)
                if(anInt1040 > 768)
                    anIntArray850[i] = method83(true, anIntArray851[i], anIntArray852[i], 1024 - anInt1040);
                else
                if(anInt1040 > 256)
                    anIntArray850[i] = anIntArray852[i];
                else
                    anIntArray850[i] = method83(true, anIntArray852[i], anIntArray851[i], 256 - anInt1040);

        } else
        if(anInt1041 > 0)
        {
            for(int j = 0; j < 256; j++)
                if(anInt1041 > 768)
                    anIntArray850[j] = method83(true, anIntArray851[j], anIntArray853[j], 1024 - anInt1041);
                else
                if(anInt1041 > 256)
                    anIntArray850[j] = anIntArray853[j];
                else
                    anIntArray850[j] = method83(true, anIntArray853[j], anIntArray851[j], 256 - anInt1041);

        } else
        {
            for(int k = 0; k < 256; k++)
                anIntArray850[k] = anIntArray851[k];

        }
        for(int l = 0; l < 33920; l++)
            titletopleft_imagefetcher.pixels[l] = aClass30_Sub2_Sub1_Sub1_1201.pixels[l];

        int i1 = 0;
        int j1 = 1152;
        for(int k1 = 1; k1 < c - 1; k1++)
        {
            int l1 = (anIntArray969[k1] * (c - k1)) / c;
            int j2 = 22 + l1;
            if(j2 < 0)
                j2 = 0;
            i1 += j2;
            for(int l2 = j2; l2 < 128; l2++)
            {
                int j3 = anIntArray828[i1++];
                if(j3 != 0)
                {
                    int l3 = j3;
                    int j4 = 256 - j3;
                    j3 = anIntArray850[j3];
                    int l4 = titletopleft_imagefetcher.pixels[j1];
                    titletopleft_imagefetcher.pixels[j1++] = ((j3 & 0xff00ff) * l3 + (l4 & 0xff00ff) * j4 & 0xff00ff00) + ((j3 & 0xff00) * l3 + (l4 & 0xff00) * j4 & 0xff0000) >> 8;
                } else
                {
                    j1++;
                }
            }

            j1 += j2;
        }

        titletopleft_imagefetcher.updateGraphics(0, 23680, super.graphics, 0);
        for(int i2 = 0; i2 < 33920; i2++)
            titletopright_imagefetcher.pixels[i2] = aClass30_Sub2_Sub1_Sub1_1202.pixels[i2];

        i1 = 0;
        j1 = 1176;
        for(int k2 = 1; k2 < c - 1; k2++)
        {
            int i3 = (anIntArray969[k2] * (c - k2)) / c;
            int k3 = 103 - i3;
            j1 += i3;
            for(int i4 = 0; i4 < k3; i4++)
            {
                int k4 = anIntArray828[i1++];
                if(k4 != 0)
                {
                    int i5 = k4;
                    int j5 = 256 - k4;
                    k4 = anIntArray850[k4];
                    int k5 = titletopright_imagefetcher.pixels[j1];
                    titletopright_imagefetcher.pixels[j1++] = ((k4 & 0xff00ff) * i5 + (k5 & 0xff00ff) * j5 & 0xff00ff00) + ((k4 & 0xff00) * i5 + (k5 & 0xff00) * j5 & 0xff0000) >> 8;
                } else
                {
                    j1++;
                }
            }

            i1 += 128 - k3;
            j1 += 128 - k3 - i3;
        }

        titletopright_imagefetcher.updateGraphics(0, 23680, super.graphics, 637);
        if(byte0 != 9)
            packetnum = inbuffer.getUByte();
    }

    public void method134(byte byte0, int i, Buffer buffer0)
    {
        int j = buffer0.getBits(8, 0);
        if(j < anInt891)
        {
            for(int k = j; k < anInt891; k++)
                playerremove_stack[amtplayerremovestack++] = anIntArray892[k];

        }
        if(j > anInt891)
        {
            signlink.reporterror(username + " Too many players");
            throw new RuntimeException("eek");
        }
        anInt891 = 0;
        for(int l = 0; l < j; l++)
        {
            int i1 = anIntArray892[l];
            Player class30_sub2_sub4_sub1_sub2 = players[i1];
            int j1 = buffer0.getBits(1, 0);
            if(j1 == 0)
            {
                anIntArray892[anInt891++] = i1;
                class30_sub2_sub4_sub1_sub2.anInt1537 = loopcycle;
            } else
            {
                int k1 = buffer0.getBits(2, 0);
                if(k1 == 0)
                {
                    anIntArray892[anInt891++] = i1;
                    class30_sub2_sub4_sub1_sub2.anInt1537 = loopcycle;
                    playerupdate_stack[amtplayerupdatestack++] = i1;
                } else
                if(k1 == 1)
                {
                    anIntArray892[anInt891++] = i1;
                    class30_sub2_sub4_sub1_sub2.anInt1537 = loopcycle;
                    int l1 = buffer0.getBits(3, 0);
                    class30_sub2_sub4_sub1_sub2.handleMobMovment(false, (byte)20, l1);
                    int j2 = buffer0.getBits(1, 0);
                    if(j2 == 1)
                        playerupdate_stack[amtplayerupdatestack++] = i1;
                } else
                if(k1 == 2)
                {
                    anIntArray892[anInt891++] = i1;
                    class30_sub2_sub4_sub1_sub2.anInt1537 = loopcycle;
                    int i2 = buffer0.getBits(3, 0);
                    class30_sub2_sub4_sub1_sub2.handleMobMovment(true, (byte)20, i2);
                    int k2 = buffer0.getBits(3, 0);
                    class30_sub2_sub4_sub1_sub2.handleMobMovment(true, (byte)20, k2);
                    int l2 = buffer0.getBits(1, 0);
                    if(l2 == 1)
                        playerupdate_stack[amtplayerupdatestack++] = i1;
                } else
                if(k1 == 3)
                    playerremove_stack[amtplayerremovestack++] = i1;
            }
        }

        if(byte0 != 2)
            anInt939 = -80;
    }

    public void drawTitleScreen(boolean flag, boolean flag1)
    {
        method64(0);
        aClass15_1109.initialize(0);
        aClass30_Sub2_Sub1_Sub2_966.renderImage(0, 16083, 0);
        char c = '\u0168';
        char c1 = '\310';
        if(flag1)
            return;
        if(titlescreen_tab == 0)
        {
            int i = c1 / 2 + 80;
            p11_font.drawCenteredXText(0x75a9a9, c / 2, anInt939, ondemandhandler.extrafiles_str, i, true);
            i = c1 / 2 - 20;
            b12_font.drawCenteredXText(0xffff00, c / 2, anInt939, "Welcome to RuneScape", i, true);
            i += 30;
            int l = c / 2 - 80;
            int k1 = c1 / 2 + 20;
            aClass30_Sub2_Sub1_Sub2_967.renderImage(l - 73, 16083, k1 - 20);
            b12_font.drawCenteredXText(0xffffff, l, anInt939, "New User", k1 + 5, true);
            l = c / 2 + 80;
            aClass30_Sub2_Sub1_Sub2_967.renderImage(l - 73, 16083, k1 - 20);
            b12_font.drawCenteredXText(0xffffff, l, anInt939, "Existing User", k1 + 5, true);
        }
        if(titlescreen_tab == 2)
        {
            int j = c1 / 2 - 40;
            if(aString1266.length() > 0)
            {
                b12_font.drawCenteredXText(0xffff00, c / 2, anInt939, aString1266, j - 15, true);
                b12_font.drawCenteredXText(0xffff00, c / 2, anInt939, aString1267, j, true);
                j += 30;
            } else
            {
                b12_font.drawCenteredXText(0xffff00, c / 2, anInt939, aString1267, j - 7, true);
                j += 30;
            }
            b12_font.drawText2(false, true, c / 2 - 90, 0xffffff, "Username: " + username + ((userpass_swtch == 0) & (loopcycle % 40 < 20) ? "@yel@|" : ""), j);
            j += 15;
            b12_font.drawText2(false, true, c / 2 - 88, 0xffffff, "Password: " + TextUtils.asteriskicide(password, 0) + ((userpass_swtch == 1) & (loopcycle % 40 < 20) ? "@yel@|" : ""), j);
            j += 15;
            if(!flag)
            {
                int i1 = c / 2 - 80;
                int l1 = c1 / 2 + 50;
                aClass30_Sub2_Sub1_Sub2_967.renderImage(i1 - 73, 16083, l1 - 20);
                b12_font.drawCenteredXText(0xffffff, i1, anInt939, "Login", l1 + 5, true);
                i1 = c / 2 + 80;
                aClass30_Sub2_Sub1_Sub2_967.renderImage(i1 - 73, 16083, l1 - 20);
                b12_font.drawCenteredXText(0xffffff, i1, anInt939, "Cancel", l1 + 5, true);
            }
        }
        if(titlescreen_tab == 3)
        {
            b12_font.drawCenteredXText(0xffff00, c / 2, anInt939, "Create a free account", c1 / 2 - 60, true);
            int k = c1 / 2 - 35;
            b12_font.drawCenteredXText(0xffffff, c / 2, anInt939, "To create a new account you need to", k, true);
            k += 15;
            b12_font.drawCenteredXText(0xffffff, c / 2, anInt939, "go back to the main RuneScape webpage", k, true);
            k += 15;
            b12_font.drawCenteredXText(0xffffff, c / 2, anInt939, "and choose the red 'create account'", k, true);
            k += 15;
            b12_font.drawCenteredXText(0xffffff, c / 2, anInt939, "button at the top right of that page.", k, true);
            k += 15;
            int j1 = c / 2;
            int i2 = c1 / 2 + 50;
            aClass30_Sub2_Sub1_Sub2_967.renderImage(j1 - 73, 16083, i2 - 20);
            b12_font.drawCenteredXText(0xffffff, j1, anInt939, "Cancel", i2 + 5, true);
        }
        aClass15_1109.updateGraphics(171, 23680, super.graphics, 202);
        if(aBoolean1255)
        {
            aBoolean1255 = false;
            logo_imagefetcher.updateGraphics(0, 23680, super.graphics, 128);
            bottomleftmid_imagefetcher.updateGraphics(371, 23680, super.graphics, 202);
            aClass15_1112.updateGraphics(265, 23680, super.graphics, 0);
            aClass15_1113.updateGraphics(265, 23680, super.graphics, 562);
            aClass15_1114.updateGraphics(171, 23680, super.graphics, 128);
            aClass15_1115.updateGraphics(171, 23680, super.graphics, 562);
        }
    }

    public void clientProcess(byte byte0)
    {
        aBoolean962 = true;
        if(byte0 != 59)
            anInt1058 = -186;
        try
        {
            long l = System.currentTimeMillis();
            int i = 0;
            int j = 20;
            while(runflamecycle) 
            {
                flame_cycle++;
                method58(25106);
                method58(25106);
                method133((byte)9);
                if(++i > 10)
                {
                    long l1 = System.currentTimeMillis();
                    int k = (int)(l1 - l) / 10 - j;
                    j = 40 - k;
                    if(j < 5)
                        j = 5;
                    i = 0;
                    l = l1;
                }
                try
                {
                    Thread.sleep(j);
                }
                catch(Exception _ex) { }
            }
        }
        catch(Exception _ex) { }
        aBoolean962 = false;
    }

    public void method10(byte byte0) {
        aBoolean1255 = true;
    }

    public void parseExtraFiles(int i, Buffer buffer0, int j)
    {
        while(i >= 0) 
            j = -1;
        if(j == 84)
        {
            int k = buffer0.getUByte();
            int j3 = anInt1268 + (k >> 4 & 7);
            int i6 = anInt1269 + (k & 7);
            int l8 = buffer0.getShort();
            int k11 = buffer0.getShort();
            int l13 = buffer0.getShort();
            if(j3 >= 0 && i6 >= 0 && j3 < 104 && i6 < 104)
            {
                Deque class19_1 = grounditems[cheight][j3][i6];
                if(class19_1 != null)
                {
                    for(GroundItem class30_sub2_sub4_sub2_3 = (GroundItem)class19_1.getFirst(); class30_sub2_sub4_sub2_3 != null; class30_sub2_sub4_sub2_3 = (GroundItem)class19_1.getNextForwards(false))
                    {
                        if(class30_sub2_sub4_sub2_3.itemid != (l8 & 0x7fff) || class30_sub2_sub4_sub2_3.amount != k11)
                            continue;
                        class30_sub2_sub4_sub2_3.amount = l13;
                        break;
                    }
                    method25(j3, i6);
                }
            }
            return;
        }
		/* Something Sound */
        if(j == 105)
        {
            int l = buffer0.getUByte();
            int k3 = anInt1268 + (l >> 4 & 7);
            int j6 = anInt1269 + (l & 7);
            int i9 = buffer0.getShort();
            int l11 = buffer0.getUByte();
            int i14 = l11 >> 4 & 0xf;
            int i16 = l11 & 7;
            if(((Mob) (localplayer)).palettex_stack[0] >= k3 - i14 && ((Mob) (localplayer)).palettex_stack[0] <= k3 + i14 && ((Mob) (localplayer)).palettey_stack[0] >= j6 - i14 && ((Mob) (localplayer)).palettey_stack[0] <= j6 + i14 && aBoolean848 && !lowmemory && anInt1062 < 50)
            {
                anIntArray1207[anInt1062] = i9;
                anIntArray1241[anInt1062] = i16;
                anIntArray1250[anInt1062] = Sound.anIntArray326[i9];
                anInt1062++;
            }
        }
		/* Spawn ground item */
        if(j == 215)
        {
            int i1 = buffer0.getShort128(true);
            int l3 = buffer0.getUSpecialB(2);
            int k6 = anInt1268 + (l3 >> 4 & 7);
            int j9 = anInt1269 + (l3 & 7);
            int i12 = buffer0.getShort128(true);
            int j14 = buffer0.getShort();
            if(k6 >= 0 && j9 >= 0 && k6 < 104 && j9 < 104 && i12 != anInt884)
            {
                GroundItem class30_sub2_sub4_sub2_2 = new GroundItem();
                class30_sub2_sub4_sub2_2.itemid = i1;
                class30_sub2_sub4_sub2_2.amount = j14;
                if(grounditems[cheight][k6][j9] == null)
                    grounditems[cheight][k6][j9] = new Deque(169);
                grounditems[cheight][k6][j9].addLast(class30_sub2_sub4_sub2_2);
                method25(k6, j9);
            }
            return;
        }
        if(j == 156)
        {
            int j1 = buffer0.getUByte128(0);
            int i4 = anInt1268 + (j1 >> 4 & 7);
            int l6 = anInt1269 + (j1 & 7);
            int k9 = buffer0.getShort();
            if(i4 >= 0 && l6 >= 0 && i4 < 104 && l6 < 104)
            {
                Deque class19 = grounditems[cheight][i4][l6];
                if(class19 != null)
                {
                    for(GroundItem class30_sub2_sub4_sub2 = (GroundItem) class19.getFirst(); class30_sub2_sub4_sub2 != null; class30_sub2_sub4_sub2 = (GroundItem)class19.getNextForwards(false)) {
                        if(class30_sub2_sub4_sub2.itemid != (k9 & 0x7fff))
                            continue;
                        class30_sub2_sub4_sub2.removeDeque();
                        break;
                    }
                    if(class19.getFirst() == null)
                        grounditems[cheight][i4][l6] = null;
                    method25(i4, l6);
                }
            }
            return;
        }
        if(j == 160)
        {
            int k1 = buffer0.getUSpecialB(2);
            int j4 = anInt1268 + (k1 >> 4 & 7);
            int i7 = anInt1269 + (k1 & 7);
            int l9 = buffer0.getUSpecialB(2);
            int j12 = l9 >> 2;
            int k14 = l9 & 3;
            int j16 = object_types[j12];
            int j17 = buffer0.getShort128(true);
            if(j4 >= 0 && i7 >= 0 && j4 < 103 && i7 < 103)
            {
                int j18 = main_heightmap[cheight][j4][i7];
                int i19 = main_heightmap[cheight][j4 + 1][i7];
                int l19 = main_heightmap[cheight][j4 + 1][i7 + 1];
                int k20 = main_heightmap[cheight][j4][i7 + 1];
                if(j16 == 0)
                {
                    Wall class10 = pallet.getWall(cheight, j4, i7, false);
                    if(class10 != null)
                    {
                        int k21 = class10.anInt280 >> 14 & 0x7fff;
						/* Object type 2: diagnol wall */
                        if(j12 == 2)
                        {
                            class10.aActor_278 = new RSObject(k21, 4 + k14, 2, i19, (byte)7, l19, j18, k20, j17, false);
                            class10.aActor_279 = new RSObject(k21, k14 + 1 & 3, 2, i19, (byte)7, l19, j18, k20, j17, false);
                        } else
                        {
                            class10.aActor_278 = new RSObject(k21, k14, j12, i19, (byte)7, l19, j18, k20, j17, false);
                        }
                    }
                }
                if(j16 == 1)
                {
                    WallDecoration class26 = pallet.getWallDecoration(j4, 866, i7, cheight);
                    if(class26 != null)
                        class26.wd_entity = new RSObject(class26.wd_objhash >> 14 & 0x7fff, 0, 4, i19, (byte)7, l19, j18, k20, j17, false);
                }
                if(j16 == 2)
                {
                    GeneralObject class28 = pallet.method298(j4, i7, (byte)4, cheight);
                    if(j12 == 11)
                        j12 = 10;
                    if(class28 != null)
                        class28.aActor_521 = new RSObject(class28.anInt529 >> 14 & 0x7fff, k14, j12, i19, (byte)7, l19, j18, k20, j17, false);
                }
                if(j16 == 3)
                {
                    FloorDecoration class49 = pallet.getFloorDecoration(i7, j4, cheight, 0);
                    if(class49 != null)
                        class49.aActor_814 = new RSObject(class49.anInt815 >> 14 & 0x7fff, k14, 22, i19, (byte)7, l19, j18, k20, j17, false);
                }
            }
            return;
        }
        if(j == 147) {
            int l1 = buffer0.getUSpecialB(2);
            int k4 = anInt1268 + (l1 >> 4 & 7);
            int j7 = anInt1269 + (l1 & 7);
            int i10 = buffer0.getShort();
            byte byte0 = buffer0.getSpecialB(0);
            int l14 = buffer0.getShortLE((byte)108);
            byte byte1 = buffer0.getSpecialA((byte)-57);
            int k17 = buffer0.getShort();
            int k18 = buffer0.getUSpecialB(2);
            int j19 = k18 >> 2;
            int i20 = k18 & 3;
            int l20 = object_types[j19];
            byte byte2 = buffer0.getByte();
            int l21 = buffer0.getShort();
            byte byte3 = buffer0.getSpecialA((byte)-57);
            Player class30_sub2_sub4_sub1_sub2;
            if(i10 == anInt884)
                class30_sub2_sub4_sub1_sub2 = localplayer;
            else
                class30_sub2_sub4_sub1_sub2 = players[i10];
            if(class30_sub2_sub4_sub1_sub2 != null)
            {
                ObjectDefinition class46 = ObjectDefinition.getObjectDefinition(l21);
                int i22 = main_heightmap[cheight][k4][j7];
                int j22 = main_heightmap[cheight][k4 + 1][j7];
                int k22 = main_heightmap[cheight][k4 + 1][j7 + 1];
                int l22 = main_heightmap[cheight][k4][j7 + 1];
                Model class30_sub2_sub4_sub6 = class46.method578(j19, i20, i22, j22, k22, l22, -1);
                if(class30_sub2_sub4_sub6 != null)
                {
                    addSpawnObject(404, k17 + 1, -1, 0, l20, j7, 0, cheight, k4, l14 + 1);
                    class30_sub2_sub4_sub1_sub2.anInt1707 = l14 + loopcycle;
                    class30_sub2_sub4_sub1_sub2.anInt1708 = k17 + loopcycle;
                    class30_sub2_sub4_sub1_sub2.aActor_Sub6_1714 = class30_sub2_sub4_sub6;
                    int i23 = class46.anInt744;
                    int j23 = class46.objsize;
                    if(i20 == 1 || i20 == 3)
                    {
                        i23 = class46.objsize;
                        j23 = class46.anInt744;
                    }
                    class30_sub2_sub4_sub1_sub2.anInt1711 = k4 * 128 + i23 * 64;
                    class30_sub2_sub4_sub1_sub2.anInt1713 = j7 * 128 + j23 * 64;
                    class30_sub2_sub4_sub1_sub2.anInt1712 = calculateTileHeight( class30_sub2_sub4_sub1_sub2.anInt1711, class30_sub2_sub4_sub1_sub2.anInt1713, cheight);
                    if(byte2 > byte0)
                    {
                        byte byte4 = byte2;
                        byte2 = byte0;
                        byte0 = byte4;
                    }
                    if(byte3 > byte1)
                    {
                        byte byte5 = byte3;
                        byte3 = byte1;
                        byte1 = byte5;
                    }
                    class30_sub2_sub4_sub1_sub2.anInt1719 = k4 + byte2;
                    class30_sub2_sub4_sub1_sub2.anInt1721 = k4 + byte0;
                    class30_sub2_sub4_sub1_sub2.anInt1720 = j7 + byte3;
                    class30_sub2_sub4_sub1_sub2.anInt1722 = j7 + byte1;
                }
            }
        }
		/* Spawn Object Packet */
        if(j == 151)
        {
            int cxy = buffer0.getUByte128(0);
            int px = anInt1268 + (cxy >> 4 & 7);
            int py = anInt1269 + (cxy & 7);
            int oid = buffer0.getShortLE((byte)108);
            int rt = buffer0.getUSpecialB(2);
            int type = rt >> 2;
            int rota = rt & 3;
            int l17 = object_types[type];
            if(px >= 0 && py >= 0 && px < 104 && py < 104)
                addSpawnObject(404, -1, oid, rota, l17, py, type, cheight, px, 0);
            return;
        }
        if(j == 4)
        {
            int j2 = buffer0.getUByte();
            int i5 = anInt1268 + (j2 >> 4 & 7);
            int l7 = anInt1269 + (j2 & 7);
            int k10 = buffer0.getShort();
            int l12 = buffer0.getUByte();
            int j15 = buffer0.getShort();
            if(i5 >= 0 && l7 >= 0 && i5 < 104 && l7 < 104)
            {
                i5 = i5 * 128 + 64;
                l7 = l7 * 128 + 64;
                GFX class30_sub2_sub4_sub3 = new GFX(cheight, loopcycle, 6, j15, k10, calculateTileHeight(i5, l7, cheight) - l12, l7, i5);
                gfxs_storage.addLast(class30_sub2_sub4_sub3);
            }
            return;
        }
        if(j == 44)
        {
            int k2 = buffer0.getShortLE128((byte)-74);
            int j5 = buffer0.getShort();
            int i8 = buffer0.getUByte();
            int l10 = anInt1268 + (i8 >> 4 & 7);
            int i13 = anInt1269 + (i8 & 7);
            if(l10 >= 0 && i13 >= 0 && l10 < 104 && i13 < 104)
            {
                GroundItem class30_sub2_sub4_sub2_1 = new GroundItem();
                class30_sub2_sub4_sub2_1.itemid = k2;
                class30_sub2_sub4_sub2_1.amount = j5;
                if(grounditems[cheight][l10][i13] == null)
                    grounditems[cheight][l10][i13] = new Deque(169);
                grounditems[cheight][l10][i13].addLast(class30_sub2_sub4_sub2_1);
                method25(l10, i13);
            }
            return;
        }
        if(j == 101)
        {
            int l2 = buffer0.getUSpecialA(false);
            int k5 = l2 >> 2;
            int j8 = l2 & 3;
            int i11 = object_types[k5];
            int j13 = buffer0.getUByte();
            int k15 = anInt1268 + (j13 >> 4 & 7);
            int l16 = anInt1269 + (j13 & 7);
            if(k15 >= 0 && l16 >= 0 && k15 < 104 && l16 < 104)
                addSpawnObject(404, -1, -1, j8, i11, l16, k5, cheight, k15, 0);
            return;
        }
        if(j == 117)
        {
            int i3 = buffer0.getUByte();
            int l5 = anInt1268 + (i3 >> 4 & 7);
            int k8 = anInt1269 + (i3 & 7);
            int j11 = l5 + buffer0.getByte();
            int k13 = k8 + buffer0.getByte();
            int l15 = buffer0.putShortB();
            int i17 = buffer0.getShort();
            int i18 = buffer0.getUByte() * 4;
            int l18 = buffer0.getUByte() * 4;
            int k19 = buffer0.getShort();
            int j20 = buffer0.getShort();
            int i21 = buffer0.getUByte();
            int j21 = buffer0.getUByte();
            if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104 && j11 >= 0 && k13 >= 0 && j11 < 104 && k13 < 104 && i17 != 65535)
            {
                l5 = l5 * 128 + 64;
                k8 = k8 * 128 + 64;
                j11 = j11 * 128 + 64;
                k13 = k13 * 128 + 64;
                Projectile class30_sub2_sub4_sub4 = new Projectile(i21, l18, 46883, k19 + loopcycle, j20 + loopcycle, j21, cheight, calculateTileHeight(l5, k8, cheight) - i18, k8, l5, l15, i17);
                class30_sub2_sub4_sub4.method455(k19 + loopcycle, k13, calculateTileHeight(j11, k13, cheight) - l18, j11, (byte)-83);
                aClass19_1013.addLast(class30_sub2_sub4_sub4);
            }
        }
    }

    public static void setLowMem(byte junk) {
        Palette.lowmemory = true;
        TriangleRasterizer.lowmemory = true;
        lowmemory = true;
        MapLoader.lowmemory = true;
        ObjectDefinition.lowmemory = true;
    }

    public void method139(Buffer buffer0, int i, int j)
    {
        if(i >= 0)
            anInt1118 = -7;
        buffer0.initBitAccess(anInt1118);
        int k = buffer0.getBits(8, 0);
        if(k < anInt836)
        {
            for(int l = k; l < anInt836; l++)
                playerremove_stack[amtplayerremovestack++] = updatenpcs[l];

        }
        if(k > anInt836)
        {
            signlink.reporterror(username + " Too many npcs");
            throw new RuntimeException("eek");
        }
        anInt836 = 0;
        for(int i1 = 0; i1 < k; i1++)
        {
            int j1 = updatenpcs[i1];
            NPC class30_sub2_sub4_sub1_sub1 = npcs[j1];
            int k1 = buffer0.getBits(1, 0);
            if(k1 == 0)
            {
                updatenpcs[anInt836++] = j1;
                class30_sub2_sub4_sub1_sub1.anInt1537 = loopcycle;
            } else
            {
                int l1 = buffer0.getBits(2, 0);
                if(l1 == 0)
                {
                    updatenpcs[anInt836++] = j1;
                    class30_sub2_sub4_sub1_sub1.anInt1537 = loopcycle;
                    playerupdate_stack[amtplayerupdatestack++] = j1;
                } else
                if(l1 == 1)
                {
                    updatenpcs[anInt836++] = j1;
                    class30_sub2_sub4_sub1_sub1.anInt1537 = loopcycle;
                    int i2 = buffer0.getBits(3, 0);
                    class30_sub2_sub4_sub1_sub1.handleMobMovment(false, (byte)20, i2);
                    int k2 = buffer0.getBits(1, 0);
                    if(k2 == 1)
                        playerupdate_stack[amtplayerupdatestack++] = j1;
                } else
                if(l1 == 2)
                {
                    updatenpcs[anInt836++] = j1;
                    class30_sub2_sub4_sub1_sub1.anInt1537 = loopcycle;
                    int j2 = buffer0.getBits(3, 0);
                    class30_sub2_sub4_sub1_sub1.handleMobMovment(true, (byte)20, j2);
                    int l2 = buffer0.getBits(3, 0);
                    class30_sub2_sub4_sub1_sub1.handleMobMovment(true, (byte)20, l2);
                    int i3 = buffer0.getBits(1, 0);
                    if(i3 == 1)
                        playerupdate_stack[amtplayerupdatestack++] = j1;
                } else
                if(l1 == 3)
                    playerremove_stack[amtplayerremovestack++] = j1;
            }
        }

    }

    public void loopCycleTitle(boolean flag)
    {
        if(!flag)
            grounditems = null;
        if(titlescreen_tab == 0)
        {
            int i = super.applet_width / 2 - 80;
            int l = super.applet_height / 2 + 20;
            l += 20;
            if(super.anInt26 == 1 && super.curpressed_x >= i - 75 && super.curpressed_x <= i + 75 && super.curpressed_y >= l - 20 && super.curpressed_y <= l + 20)
            {
                titlescreen_tab = 3;
                userpass_swtch = 0;
            }
            i = super.applet_width / 2 + 80;
            if(super.anInt26 == 1 && super.curpressed_x >= i - 75 && super.curpressed_x <= i + 75 && super.curpressed_y >= l - 20 && super.curpressed_y <= l + 20)
            {
                aString1266 = "";
                aString1267 = "Enter your username & password.";
                titlescreen_tab = 2;
                userpass_swtch = 0;
                return;
            }
        } else
        {
            if(titlescreen_tab == 2)
            {
                int j = super.applet_height / 2 - 40;
                j += 30;
                j += 25;
                if(super.anInt26 == 1 && super.curpressed_y >= j - 15 && super.curpressed_y < j)
                    userpass_swtch = 0;
                j += 15;
                if(super.anInt26 == 1 && super.curpressed_y >= j - 15 && super.curpressed_y < j)
                    userpass_swtch = 1;
                j += 15;
                int i1 = super.applet_width / 2 - 80;
                int k1 = super.applet_height / 2 + 50;
                k1 += 20;
				/* Login button */
                if(super.anInt26 == 1 && super.curpressed_x >= i1 - 75 && super.curpressed_x <= i1 + 75 && super.curpressed_y >= k1 - 20 && super.curpressed_y <= k1 + 20)
                {
                    anInt1038 = 0;
                    login(username, password, false);
                    if(aBoolean1157)
                        return;
                }
                i1 = super.applet_width / 2 + 80;
                if(super.anInt26 == 1 && super.curpressed_x >= i1 - 75 && super.curpressed_x <= i1 + 75 && super.curpressed_y >= k1 - 20 && super.curpressed_y <= k1 + 20)
                {
                    titlescreen_tab = 0;
                    username = "";
                    password = "";
                }
                do
                {
                    int l1 = getKey(-796);
                    if(l1 == -1)
                        break;
                    boolean flag1 = false;
                    for(int i2 = 0; i2 < passchars.length(); i2++)
                    {
                        if(l1 != passchars.charAt(i2))
                            continue;
                        flag1 = true;
                        break;
                    }

                    if(userpass_swtch == 0)
                    {
						/* Backspace */
                        if(l1 == 8 && username.length() > 0)
                            username = username.substring(0, username.length() - 1);
						/* Tab, Line Feed and Carrage Return */
                        if(l1 == 9 || l1 == 10 || l1 == 13)
                            userpass_swtch = 1;
                        if(flag1)
                            username += (char)l1;
                        if(username.length() > 12)
                            username = username.substring(0, 12);
                    } else
                    if(userpass_swtch == 1)
                    {
                        if(l1 == 8 && password.length() > 0)
                            password = password.substring(0, password.length() - 1);
                        if(l1 == 9 || l1 == 10 || l1 == 13)
                            userpass_swtch = 0;
                        if(flag1)
                            password += (char)l1;
                        if(password.length() > 20)
                            password = password.substring(0, 20);
                    }
                } while(true);
                return;
            }
            if(titlescreen_tab == 3)
            {
                int k = super.applet_width / 2;
                int j1 = super.applet_height / 2 + 50;
                j1 += 20;
                if(super.anInt26 == 1 && super.curpressed_x >= k - 75 && super.curpressed_x <= k + 75 && super.curpressed_y >= j1 - 20 && super.curpressed_y <= j1 + 20)
                    titlescreen_tab = 0;
            }
        }
    }

    public void drawOnMinimap(DirectColorSprite sprite, int x, int y, boolean flag)
    {
        int yaw = camerayaw + anInt1209 & 0x7ff;
        int l = x * x + y * y;
        if(l > 6400)
            return;
        int sine = Model.sinetable[yaw];
        int cosine = Model.cosinetable[yaw];
        sine = (sine * 256) / (anInt1170 + 256);
        cosine = (cosine * 256) / (anInt1170 + 256);
        int posx = y * sine + x * cosine >> 16;
        int posy = y * cosine - x * sine >> 16;
        if(l > 2500)
        {
            sprite.renderImage(mapback, false, 83 - posy - sprite.height$ / 2 - 4, ((94 + posx) - sprite.width$ / 2) + 4);
            return;
        } else
        {
            sprite.drawOverlay(((94 + posx) - sprite.width$ / 2) + 4, 16083, 83 - posy - sprite.height$ / 2 - 4);
            return;
        }
    }

    public void method142(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        if(l1 < 4 || l1 > 4)
            packetnum = inbuffer.getUByte();
        if(i1 >= 1 && i >= 1 && i1 <= 102 && i <= 102)
        {
            if(lowmemory && j != cheight)
                return;
            int i2 = 0;
            byte byte0 = -1;
            boolean flag = false;
            boolean flag1 = false;
            if(j1 == 0)
                i2 = pallet.method300(j, i1, i);
            if(j1 == 1)
                i2 = pallet.method301(j, i1, 0, i);
            if(j1 == 2)
                i2 = pallet.method302(j, i1, i);
            if(j1 == 3)
                i2 = pallet.method303(j, i1, i);
            if(i2 != 0)
            {
                int i3 = pallet.method304(j, i1, i, i2);
                int j2 = i2 >> 14 & 0x7fff;
                int k2 = i3 & 0x1f;
                int l2 = i3 >> 6;
                if(j1 == 0)
                {
                    pallet.method291(i1, j, i, (byte)-119);
                    ObjectDefinition class46 = ObjectDefinition.getObjectDefinition(j2);
                    if(class46.aBoolean767)
                        collisionmaps[j].method215(l2, k2, class46.aBoolean757, true, i1, i);
                }
                if(j1 == 1)
                    pallet.method292(i1, i, j);
                if(j1 == 2)
                {
                    pallet.method293(i1, i, j);
                    ObjectDefinition class46_1 = ObjectDefinition.getObjectDefinition(j2);
                    if(i1 + class46_1.anInt744 > 103 || i + class46_1.anInt744 > 103 || i1 + class46_1.objsize > 103 || i + class46_1.objsize > 103)
                        return;
                    if(class46_1.aBoolean767)
                        collisionmaps[j].method216(l2, class46_1.anInt744, i1, i, (byte)6, class46_1.objsize, class46_1.aBoolean757);
                }
                if(j1 == 3)
                {
                    pallet.method294((byte)9, j, i, i1);
                    ObjectDefinition class46_2 = ObjectDefinition.getObjectDefinition(j2);
                    if(class46_2.aBoolean767 && class46_2.aBoolean778)
                        collisionmaps[j].method218(360, i, i1);
                }
            }
            if(k1 >= 0)
            {
                int j3 = j;
                if(j3 < 3 && (main_tilesettings[1][i1][i] & 2) == 2)
                    j3++;
                MapLoader.method188(pallet, k, i, l, j3, collisionmaps[j], main_heightmap, i1, k1, j, (byte)93);
            }
        }
    }

    public void method143(int i, Buffer buffer0, int junk)
    {
        amtplayerremovestack = 0;
        amtplayerupdatestack = 0;
        method117(buffer0, i, (byte)5);
        method134((byte)2, i, buffer0);
        method91(buffer0, i, (byte)8);
        doPlayerUpdateMasks(i, (byte)2, buffer0);
        for(int k = 0; k < amtplayerremovestack; k++)
        {
            int l = playerremove_stack[k];
            if(((Mob) (players[l])).anInt1537 != loopcycle)
                players[l] = null;
        }

        if(buffer0.position != i)
        {
            signlink.reporterror("Error packet size mismatch in getplayer pos:" + buffer0.position + " psize:" + i);
            throw new RuntimeException("eek");
        }
        for(int i1 = 0; i1 < anInt891; i1++)
            if(players[anIntArray892[i1]] == null)
            {
                signlink.reporterror(username + " null entry in pl list - pos:" + i1 + " size:" + anInt891);
                throw new RuntimeException("eek");
            }

    }

    public void setCurrentCameraVars(int pitch, int yaw, int y, int x0, int z0, int y0)
    {
        int pitchexemp = 2048 - pitch & 0x7ff;
        int yawexemp = 2048 - yaw & 0x7ff;
        int x1 = 0;
        int z1 = 0;
        int y1 = y;
        /* X axis rotation */
        if(pitchexemp != 0)
        {
            int sine = Model.sinetable[pitchexemp];
            int cosine = Model.cosinetable[pitchexemp];
            int zcalc = z1 * cosine - y1 * sine >> 16;
            y1 = z1 * sine + y1 * cosine >> 16;
            z1 = zcalc;
        }
        /* Z axis rotation *Counter* */
        if(yawexemp != 0)
        {
            int sine = Model.sinetable[yawexemp];
            int cosine = Model.cosinetable[yawexemp];
            int xcalc = y1 * sine + x1 * cosine >> 16;
            y1 = y1 * cosine - x1 * sine >> 16;
            x1 = xcalc;
        }
        camerax = x0 - x1;
        cameraz = z0 - z1;
        cameray = y0 - y1;
        camerapitch$ = pitch;
        camerayaw$ = yaw;
    }

    public boolean parsePackets(boolean flag) {
        if(!flag)
            grounditems = null;
        if(gameserver_sockethandler == null)
            return false;
        try {
            int i = gameserver_sockethandler.avail();
            if(i == 0)
                return false;
            if(packetnum == -1) {
                gameserver_sockethandler.readBytes(inbuffer.payload, 0, 1);
                packetnum = inbuffer.payload[0] & 0xff;
                if(packetencryption != null)
                    packetnum = packetnum /*- packetencryption.poll() & 0xff*/;
                packetsize = PacketConsts.incoming_sizes[packetnum];
                i--;
            }
			/* Var byte */
            if(packetsize == -1)
                if(i > 0) {
                    gameserver_sockethandler.readBytes(inbuffer.payload, 0, 1);
                    packetsize = inbuffer.payload[0] & 0xff;
                    i--;
                } else {
                    return false;
                }
			/* Var short */
            if(packetsize == -2)
                if(i > 1) {
                    gameserver_sockethandler.readBytes(inbuffer.payload, 0, 2);
                    inbuffer.position = 0;
                    packetsize = inbuffer.getShort();
                    i -= 2;
                } else {
                    return false;
                }
            if(i < packetsize)
                return false;
            inbuffer.position = 0;
            gameserver_sockethandler.readBytes(inbuffer.payload, 0, packetsize);
            anInt1009 = 0;
            anInt843 = anInt842;
            anInt842 = anInt841;
            anInt841 = packetnum;
            if(packetnum == 81) {
                method143(packetsize, inbuffer, 9759);
                aBoolean1080 = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 176) {
                anInt1167 = inbuffer.getUSpecialA(false);
                anInt1154 = inbuffer.getShort128(true);
                anInt1120 = inbuffer.getUByte();
                anInt1193 = inbuffer.getIntC(true);
                pastlaginamountdays = inbuffer.getShort();
                if(anInt1193 != 0 && anInt857 == -1) {
                    signlink.dnslookup(TextUtils.getHostAddress(anInt1193, true));
                    method147(537);
                    char c = '\u028A';
                    if(anInt1167 != 201 || anInt1120 == 1)
                        c = '\u028F';
                    aString881 = "";
                    aBoolean1158 = false;
                    for(int k9 = 0; k9 < Widget.widgets.length; k9++) {
                        if(Widget.widgets[k9] == null || Widget.widgets[k9].actioncode != c)
                            continue;
                        anInt857 = Widget.widgets[k9].parentid;
                        break;
                    }
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 64) {
                anInt1268 = inbuffer.getUSpecialA(false);
                anInt1269 = inbuffer.getUSpecialB(2);
                for(int j = anInt1268; j < anInt1268 + 8; j++) {
                    for(int l9 = anInt1269; l9 < anInt1269 + 8; l9++)
                        if(grounditems[cheight][j][l9] != null) {
                            grounditems[cheight][j][l9] = null;
                            method25(j, l9);
                        }
                }
                for(SpawnedObject class30_sub1 = (SpawnedObject)aClass19_1179.getFirst(); class30_sub1 != null; class30_sub1 = (SpawnedObject)aClass19_1179.getNextForwards(false))
                    if(class30_sub1.pallete_x >= anInt1268 && class30_sub1.pallete_x < anInt1268 + 8 && class30_sub1.pallete_y >= anInt1269 && class30_sub1.pallete_y < anInt1269 + 8 && class30_sub1.cheight == cheight)
                        class30_sub1.anInt1294 = 0;
                packetnum = -1;
                return true;
            }
			/* Mob on interface */
            if(packetnum == 185) {
                int k = inbuffer.getShortLE128((byte)-74);
                Widget.widgets[k].anInt233 = 3;
                if(localplayer.pnpc == null)
                    Widget.widgets[k].anInt234 = (localplayer.anIntArray1700[0] << 25) + (localplayer.anIntArray1700[4] << 20) + (localplayer.appearances[0] << 15) + (localplayer.appearances[8] << 10) + (localplayer.appearances[11] << 5) + localplayer.appearances[1];
                else
                    Widget.widgets[k].anInt234 = (int)(0x12345678L + localplayer.pnpc.id);
                packetnum = -1;
                return true;
            }
			/* Stops the camera */
            if(packetnum == 107)
            {
                aBoolean1160 = false;
                for(int l = 0; l < 5; l++)
                    cameramovements[l] = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 72)
            {
                int i1 = inbuffer.getShortLE((byte)108);
                Widget class9 = Widget.widgets[i1];
                for(int k15 = 0; k15 < class9.itemarray.length; k15++)
                {
                    class9.itemarray[k15] = -1;
                    class9.itemarray[k15] = 0;
                }

                packetnum = -1;
                return true;
            }
			/* Update ignores */
            if(packetnum == 214) {
                amt_ignorehashes = packetsize / 8;
                for(int j1 = 0; j1 < amt_ignorehashes; j1++)
                    ignore_hashes[j1] = inbuffer.getLong(-35089);

                packetnum = -1;
                return true;
            }
            if(packetnum == 166)
            {
                aBoolean1160 = true;
                spincam_x = inbuffer.getUByte();
                spincam_y = inbuffer.getUByte();
                spincam_z = inbuffer.getShort();
                spincam_speed = inbuffer.getUByte();
                spincam_angle = inbuffer.getUByte();
                if(spincam_angle >= 100) {
                    camerax = spincam_x * 128 + 64;
                    cameray = spincam_y * 128 + 64;
                    cameraz = calculateTileHeight(camerax, cameray, cheight) - spincam_z;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 134)
            {
                aBoolean1153 = true;
                int k1 = inbuffer.getUByte();
                int i10 = inbuffer.getIntB((byte)41);
                int l15 = inbuffer.getUByte();
                skillxp[k1] = i10;
                skilllevels[k1] = l15;
                anIntArray1044[k1] = 1;
                for(int k20 = 0; k20 < 98; k20++)
                    if(i10 >= levelforxp[k20])
                        anIntArray1044[k1] = k20 + 2;
                packetnum = -1;
                return true;
            }
            if(packetnum == 71)
            {
                int inter = inbuffer.getShort();
                int tab = inbuffer.getUByte128(0);
                if(inter == 65535)
                    inter = -1;
                tab_interfaces[tab] = inter;
                aBoolean1153 = true;
                update_tabs = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 74)
            {
                int i2 = inbuffer.getShortLE((byte)108);
                if(i2 == 65535)
                    i2 = -1;
                if(i2 != anInt956 && aBoolean1151 && !lowmemory && anInt1259 == 0)
                {
                    anInt1227 = i2;
                    aBoolean1228 = true;
                    ondemandhandler.requestUrgentArchive(2, anInt1227);
                }
                anInt956 = i2;
                packetnum = -1;
                return true;
            }
            if(packetnum == 121)
            {
                int j2 = inbuffer.getShortLE128((byte)-74);
                int k10 = inbuffer.getShort128(true);
                if(aBoolean1151 && !lowmemory)
                {
                    anInt1227 = j2;
                    aBoolean1228 = false;
                    ondemandhandler.requestUrgentArchive(2, anInt1227);
                    anInt1259 = k10;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 109)
            {
                killToMainscreen(true);
                packetnum = -1;
                return false;
            }
            if(packetnum == 70)
            {
                int k2 = inbuffer.putShortB();
                int l10 = inbuffer.getShortBLE(-665);
                int i16 = inbuffer.getShortLE((byte)108);
                Widget class9_5 = Widget.widgets[i16];
                class9_5.anInt263 = k2;
                class9_5.anInt265 = l10;
                packetnum = -1;
                return true;
            }
			/* Update pallete packets */
            if(packetnum == 73 || packetnum == 241) {
                int l2 = chunkx_;
                int i11 = chunky_;
                if(packetnum == 73) {
                    l2 = inbuffer.getShort128(true);
                    i11 = inbuffer.getShort();
                    aBoolean1159 = false;
                }
                if(packetnum == 241) {
                    i11 = inbuffer.getShort128(true);
                    inbuffer.initBitAccess(anInt1118);
                    for(int j16 = 0; j16 < 4; j16++) {
                        for(int l20 = 0; l20 < 13; l20++) {
                            for(int j23 = 0; j23 < 13; j23++) {
                                int i26 = inbuffer.getBits(1, 0);
                                if(i26 == 1)
                                    custompalette[j16][l20][j23] = inbuffer.getBits(26, 0);
                                else
                                    custompalette[j16][l20][j23] = -1;
                            }
                        }
                    }
                    inbuffer.endBitAccess(true);
                    l2 = inbuffer.getShort();
                    aBoolean1159 = true;
                }
                if(chunkx_ == l2 && chunky_ == i11 && landscape_stage == 2)
                {
                    packetnum = -1;
                    return true;
                }
                chunkx_ = l2;
                chunky_ = i11;
                palettex = (chunkx_ - 6) * 8;
                palettey = (chunky_ - 6) * 8;
                isLoadedLandscapes = false;
				/* Already loaded */
                if((chunkx_ / 8 == 48 || chunkx_ / 8 == 49) && chunky_ / 8 == 48)
                    isLoadedLandscapes = true;
				/* Already laoded */
                if(chunkx_ / 8 == 48 && chunky_ / 8 == 148)
                    isLoadedLandscapes = true;
                landscape_stage = 1;
                aLong824 = System.currentTimeMillis();
                toplefttext_imagefetcher.initialize(0);
                p12_font.drawCenteredYText(0, "Loading - please wait.", 23693, 151, 257);
                p12_font.drawCenteredYText(0xffffff, "Loading - please wait.", 23693, 150, 256);
                toplefttext_imagefetcher.updateGraphics(4, 23680, super.graphics, 4);
                if(packetnum == 73)
                {
                    int k16 = 0;
                    for(int i21 = (chunkx_ - 6) / 8; i21 <= (chunkx_ + 6) / 8; i21++) {
                        for(int k23 = (chunky_ - 6) / 8; k23 <= (chunky_ + 6) / 8; k23++)
                            k16++;
                    }
                    tilebytes = new byte[k16][];
                    regionbytes = new byte[k16][];
                    regionhashes = new int[k16];
                    anIntArray1235 = new int[k16];
                    anIntArray1236 = new int[k16];
                    k16 = 0;
                    for(int l23 = (chunkx_ - 6) / 8; l23 <= (chunkx_ + 6) / 8; l23++)
                    {
                        for(int j26 = (chunky_ - 6) / 8; j26 <= (chunky_ + 6) / 8; j26++)
                        {
                            regionhashes[k16] = (l23 << 8) + j26;
                            if(isLoadedLandscapes && (j26 == 49 || j26 == 149 || j26 == 147 || l23 == 50 || l23 == 49 && j26 == 47))
                            {
                                anIntArray1235[k16] = -1;
                                anIntArray1236[k16] = -1;
                                k16++;
                            } else
                            {
                                int k28 = anIntArray1235[k16] = ondemandhandler.method562(0, 0, j26, l23);
                                if(k28 != -1)
                                    ondemandhandler.requestUrgentArchive(3, k28);
                                int j30 = anIntArray1236[k16] = ondemandhandler.method562(1, 0, j26, l23);
                                if(j30 != -1)
                                    ondemandhandler.requestUrgentArchive(3, j30);
                                k16++;
                            }
                        }

                    }

                }
                if(packetnum == 241)
                {
                    int l16 = 0;
                    int ai[] = new int[676];
                    for(int i24 = 0; i24 < 4; i24++)
                    {
                        for(int k26 = 0; k26 < 13; k26++)
                        {
                            for(int l28 = 0; l28 < 13; l28++)
                            {
                                int k30 = custompalette[i24][k26][l28];
                                if(k30 != -1)
                                {
                                    int k31 = k30 >> 14 & 0x3ff;
                                    int i32 = k30 >> 3 & 0x7ff;
                                    int k32 = (k31 / 8 << 8) + i32 / 8;
                                    for(int j33 = 0; j33 < l16; j33++)
                                    {
                                        if(ai[j33] != k32)
                                            continue;
                                        k32 = -1;
                                        break;
                                    }

                                    if(k32 != -1)
                                        ai[l16++] = k32;
                                }
                            }

                        }

                    }

                    tilebytes = new byte[l16][];
                    regionbytes = new byte[l16][];
                    regionhashes = new int[l16];
                    anIntArray1235 = new int[l16];
                    anIntArray1236 = new int[l16];
                    for(int l26 = 0; l26 < l16; l26++)
                    {
                        int i29 = regionhashes[l26] = ai[l26];
                        int l30 = i29 >> 8 & 0xff;
                        int l31 = i29 & 0xff;
                        int j32 = anIntArray1235[l26] = ondemandhandler.method562(0, 0, l31, l30);
                        if(j32 != -1)
                            ondemandhandler.requestUrgentArchive(3, j32);
                        int i33 = anIntArray1236[l26] = ondemandhandler.method562(1, 0, l31, l30);
                        if(i33 != -1)
                            ondemandhandler.requestUrgentArchive(3, i33);
                    }

                }
                int i17 = palettex - anInt1036;
                int j21 = palettey - anInt1037;
                anInt1036 = palettex;
                anInt1037 = palettey;
                for(int i10 = 0; i10 < 16384; i10++)
                {
                    NPC class30_sub2_sub4_sub1_sub1 = npcs[i10];
                    if(class30_sub2_sub4_sub1_sub1 != null) {
                        for(int j29 = 0; j29 < 10; j29++)  {
                            ((Mob) (class30_sub2_sub4_sub1_sub1)).palettex_stack[j29] -= i17;
                            ((Mob) (class30_sub2_sub4_sub1_sub1)).palettey_stack[j29] -= j21;
                        }
                        class30_sub2_sub4_sub1_sub1.fineposx -= i17 * 128;
                        class30_sub2_sub4_sub1_sub1.fineposy -= j21 * 128;
                    }
                }

                for(int i27 = 0; i27 < maxplayers; i27++)
                {
                    Player class30_sub2_sub4_sub1_sub2 = players[i27];
                    if(class30_sub2_sub4_sub1_sub2 != null)
                    {
                        for(int i31 = 0; i31 < 10; i31++)
                        {
                            ((Mob) (class30_sub2_sub4_sub1_sub2)).palettex_stack[i31] -= i17;
                            ((Mob) (class30_sub2_sub4_sub1_sub2)).palettey_stack[i31] -= j21;
                        }

                        class30_sub2_sub4_sub1_sub2.fineposx -= i17 * 128;
                        class30_sub2_sub4_sub1_sub2.fineposy -= j21 * 128;
                    }
                }

                aBoolean1080 = true;
                byte byte1 = 0;
                byte byte2 = 104;
                byte byte3 = 1;
                if(i17 < 0)
                {
                    byte1 = 103;
                    byte2 = -1;
                    byte3 = -1;
                }
                byte byte4 = 0;
                byte byte5 = 104;
                byte byte6 = 1;
                if(j21 < 0)
                {
                    byte4 = 103;
                    byte5 = -1;
                    byte6 = -1;
                }
                for(int k33 = byte1; k33 != byte2; k33 += byte3)
                {
                    for(int l33 = byte4; l33 != byte5; l33 += byte6)
                    {
                        int i34 = k33 + i17;
                        int j34 = l33 + j21;
                        for(int k34 = 0; k34 < 4; k34++)
                            if(i34 >= 0 && j34 >= 0 && i34 < 104 && j34 < 104)
                                grounditems[k34][k33][l33] = grounditems[k34][i34][j34];
                            else
                                grounditems[k34][k33][l33] = null;

                    }

                }

                for(SpawnedObject class30_sub1_1 = (SpawnedObject)aClass19_1179.getFirst(); class30_sub1_1 != null; class30_sub1_1 = (SpawnedObject)aClass19_1179.getNextForwards(false))
                {
                    class30_sub1_1.pallete_x -= i17;
                    class30_sub1_1.pallete_y -= j21;
                    if(class30_sub1_1.pallete_x < 0 || class30_sub1_1.pallete_y < 0 || class30_sub1_1.pallete_x >= 104 || class30_sub1_1.pallete_y >= 104)
                        class30_sub1_1.removeDeque();
                }

                if(anInt1261 != 0)
                {
                    anInt1261 -= i17;
                    anInt1262 -= j21;
                }
                aBoolean1160 = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 208)
            {
                int i3 = inbuffer.getShortBLE(-665);
                if(i3 >= 0)
                    method60(i3, (byte)6);
                anInt1018 = i3;
                packetnum = -1;
                return true;
            }
			/* ? Something with rendering */
            if(packetnum == 99)
            {
                anInt1021 = inbuffer.getUByte();
                packetnum = -1;
                return true;
            }
            if(packetnum == 75)
            {
                int j3 = inbuffer.getShortLE128((byte)-74);
                int j11 = inbuffer.getShortLE128((byte)-74);
                Widget.widgets[j11].anInt233 = 2;
                Widget.widgets[j11].anInt234 = j3;
                packetnum = -1;
                return true;
            }
            if(packetnum == 114)
            {
                anInt1104 = inbuffer.getShortLE((byte)108) * 30;
                packetnum = -1;
                return true;
            }
			/* Special packet? */
            if(packetnum == 60)
            {
                anInt1269 = inbuffer.getUByte();
                anInt1268 = inbuffer.getUSpecialA(false);
                while(inbuffer.position < packetsize) 
                {
                    int k3 = inbuffer.getUByte();
                    parseExtraFiles(anInt1119, inbuffer, k3);
                }
                packetnum = -1;
                return true;
            }
			/* Random Camera Movement */
            if(packetnum == 35)
            {
                int l3 = inbuffer.getUByte();
                int k11 = inbuffer.getUByte();
                int j17 = inbuffer.getUByte();
                int k21 = inbuffer.getUByte();
                cameramovements[l3] = true;
                cameratransvars[l3] = k11;
                cameratransvars4[l3] = j17;
                cameratransvars3[l3] = k21;
                cameratransvars2[l3] = 0;
                packetnum = -1;
                return true;
            }
			/* Sound packet */
            if(packetnum == 174)
            {
                int i4 = inbuffer.getShort();
                int l11 = inbuffer.getUByte();
                int k17 = inbuffer.getShort();
                if(aBoolean848 && !lowmemory && anInt1062 < 50)
                {
                    anIntArray1207[anInt1062] = i4;
                    anIntArray1241[anInt1062] = l11;
                    anIntArray1250[anInt1062] = k17 + Sound.anIntArray326[i4];
                    anInt1062++;
                }
                packetnum = -1;
                return true;
            }
			/* Player option */
            if(packetnum == 104)
            {
                int j4 = inbuffer.getUSpecialA(false);
                int i12 = inbuffer.getUByte128(0);
                String s6 = inbuffer.getCStr();
                if(j4 >= 1 && j4 <= 5)
                {
                    if(s6.equalsIgnoreCase("null"))
                        s6 = null;
                    aStringArray1127[j4 - 1] = s6;
                    aBooleanArray1128[j4 - 1] = i12 == 0;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 78)
            {
                anInt1261 = 0;
                packetnum = -1;
                return true;
            }
            if(packetnum == 253)
            {
                String s = inbuffer.getCStr();
                if(s.endsWith(":tradereq:"))
                {
                    String s3 = s.substring(0, s.indexOf(":"));
                    long l17 = TextUtils.stringToLong(s3);
                    boolean flag2 = false;
                    for(int j27 = 0; j27 < amt_ignorehashes; j27++)
                    {
                        if(ignore_hashes[j27] != l17)
                            continue;
                        flag2 = true;
                        break;
                    }

                    if(!flag2 && ontutorial_island == 0)
                        pushMessage("wishes to trade with you.", 4, s3, aBoolean991);
                } else
                if(s.endsWith(":duelreq:"))
                {
                    String s4 = s.substring(0, s.indexOf(":"));
                    long l18 = TextUtils.stringToLong(s4);
                    boolean flag3 = false;
                    for(int k27 = 0; k27 < amt_ignorehashes; k27++)
                    {
                        if(ignore_hashes[k27] != l18)
                            continue;
                        flag3 = true;
                        break;
                    }

                    if(!flag3 && ontutorial_island == 0)
                        pushMessage("wishes to duel with you.", 8, s4, aBoolean991);
                } else
                if(s.endsWith(":chalreq:"))
                {
                    String s5 = s.substring(0, s.indexOf(":"));
                    long l19 = TextUtils.stringToLong(s5);
                    boolean flag4 = false;
                    for(int l27 = 0; l27 < amt_ignorehashes; l27++)
                    {
                        if(ignore_hashes[l27] != l19)
                            continue;
                        flag4 = true;
                        break;
                    }

                    if(!flag4 && ontutorial_island == 0)
                    {
                        String s8 = s.substring(s.indexOf(":") + 1, s.length() - 9);
                        pushMessage(s8, 8, s5, aBoolean991);
                    }
                } else
                {
                    pushMessage(s, 0, "", aBoolean991);
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 1)
            {
                for(int k4 = 0; k4 < players.length; k4++)
                    if(players[k4] != null)
                        players[k4].animid_request = -1;

                for(int j12 = 0; j12 < npcs.length; j12++)
                    if(npcs[j12] != null)
                        npcs[j12].animid_request = -1;

                packetnum = -1;
                return true;
            }
			/* Friend packet */
            if(packetnum == 50)
            {
                long l4 = inbuffer.getLong(-35089);
                int i18 = inbuffer.getUByte();
                String s7 = TextUtils.formatUsername(-45804, TextUtils.longToString(l4, (byte)-99));
                for(int k24 = 0; k24 < amt_friendhashes; k24++)
                {
                    if(l4 != friend_hashes[k24])
                        continue;
                    if(anIntArray826[k24] != i18)
                    {
                        anIntArray826[k24] = i18;
                        aBoolean1153 = true;
                        if(i18 > 0)
                            pushMessage(s7 + " has logged in.", 5, "", aBoolean991);
                        if(i18 == 0)
                            pushMessage(s7 + " has logged out.", 5, "", aBoolean991);
                    }
                    s7 = null;
                    break;
                }

                if(s7 != null && amt_friendhashes < 200)
                {
                    friend_hashes[amt_friendhashes] = l4;
                    friendusernames[amt_friendhashes] = s7;
                    anIntArray826[amt_friendhashes] = i18;
                    amt_friendhashes++;
                    aBoolean1153 = true;
                }
                for(boolean flag6 = false; !flag6;)
                {
                    flag6 = true;
                    for(int k29 = 0; k29 < amt_friendhashes - 1; k29++)
                        if(anIntArray826[k29] != nodeid && anIntArray826[k29 + 1] == nodeid || anIntArray826[k29] == 0 && anIntArray826[k29 + 1] != 0)
                        {
                            int j31 = anIntArray826[k29];
                            anIntArray826[k29] = anIntArray826[k29 + 1];
                            anIntArray826[k29 + 1] = j31;
                            String s10 = friendusernames[k29];
                            friendusernames[k29] = friendusernames[k29 + 1];
                            friendusernames[k29 + 1] = s10;
                            long l32 = friend_hashes[k29];
                            friend_hashes[k29] = friend_hashes[k29 + 1];
                            friend_hashes[k29 + 1] = l32;
                            aBoolean1153 = true;
                            flag6 = false;
                        }

                }

                packetnum = -1;
                return true;
            }
            if(packetnum == 110)
            {
                if(current_tab == 12)
                    aBoolean1153 = true;
                anInt1148 = inbuffer.getUByte();
                packetnum = -1;
                return true;
            }
            if(packetnum == 254)
            {
                markertype = inbuffer.getUByte();
                if(markertype == 1)
                    nmarker_id = inbuffer.getShort();
                if(markertype >= 2 && markertype <= 6)
                {
                    if(markertype == 2)
                    {
                        markeroffset_x = 64;
                        markeroffset_y = 64;
                    }
                    if(markertype == 3)
                    {
                        markeroffset_x = 0;
                        markeroffset_y = 64;
                    }
                    if(markertype == 4)
                    {
                        markeroffset_x = 128;
                        markeroffset_y = 64;
                    }
                    if(markertype == 5)
                    {
                        markeroffset_x = 64;
                        markeroffset_y = 0;
                    }
                    if(markertype == 6)
                    {
                        markeroffset_x = 64;
                        markeroffset_y = 128;
                    }
                    markertype = 2;
                    markerloc_x = inbuffer.getShort();
                    markerloc_y = inbuffer.getShort();
                    markerheight = inbuffer.getUByte();
                }
                if(markertype == 10)
                    pmarker_id = inbuffer.getShort();
                packetnum = -1;
                return true;
            }
            if(packetnum == 248)
            {
                int i5 = inbuffer.getShort128(true);
                int k12 = inbuffer.getShort();
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt857 = i5;
                anInt1189 = k12;
                aBoolean1153 = true;
                update_tabs = true;
                aBoolean1149 = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 79)
            {
                int j5 = inbuffer.getShortLE((byte)108);
                int l12 = inbuffer.getShort128(true);
                Widget class9_3 = Widget.widgets[j5];
                if(class9_3 != null && class9_3.widgettype == 0)
                {
                    if(l12 < 0)
                        l12 = 0;
                    if(l12 > class9_3.anInt261 - class9_3.height)
                        l12 = class9_3.anInt261 - class9_3.height;
                    class9_3.anInt224 = l12;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 68)
            {
                for(int k5 = 0; k5 < configstates.length; k5++)
                    if(configstates[k5] != configqueue[k5])
                    {
                        configstates[k5] = configqueue[k5];
                        parseClientVarps(false, k5);
                        aBoolean1153 = true;
                    }

                packetnum = -1;
                return true;
            }
            if(packetnum == 196)
            {
                long l5 = inbuffer.getLong(-35089);
                int j18 = inbuffer.getInt();
                int l21 = inbuffer.getUByte();
                boolean flag5 = false;
                for(int i28 = 0; i28 < 100; i28++)
                {
                    if(anIntArray1240[i28] != j18)
                        continue;
                    flag5 = true;
                    break;
                }

                if(l21 <= 1)
                {
                    for(int l29 = 0; l29 < amt_ignorehashes; l29++)
                    {
                        if(ignore_hashes[l29] != l5)
                            continue;
                        flag5 = true;
                        break;
                    }

                }
                if(!flag5 && ontutorial_island == 0)
                    try
                    {
                        anIntArray1240[anInt1169] = j18;
                        anInt1169 = (anInt1169 + 1) % 100;
                        String s9 = ChatUtils.method525(packetsize - 13, true, inbuffer);
                        if(l21 != 3)
                            s9 = Censor.censor(s9, 0);
                        if(l21 == 2 || l21 == 3)
                            pushMessage(s9, 7, "@cr2@" + TextUtils.formatUsername(-45804, TextUtils.longToString(l5, (byte)-99)), aBoolean991);
                        else
                        if(l21 == 1)
                            pushMessage(s9, 7, "@cr1@" + TextUtils.formatUsername(-45804, TextUtils.longToString(l5, (byte)-99)), aBoolean991);
                        else
                            pushMessage(s9, 3, TextUtils.formatUsername(-45804, TextUtils.longToString(l5, (byte)-99)), aBoolean991);
                    }
                    catch(Exception exception1)
                    {
                        signlink.reporterror("cde1");
                    }
                packetnum = -1;
                return true;
            }
            if(packetnum == 85)
            {
                anInt1269 = inbuffer.getUSpecialA(false);
                anInt1268 = inbuffer.getUSpecialA(false);
                packetnum = -1;
                return true;
            }
            if(packetnum == 24)
            {
                anInt1054 = inbuffer.getUSpecialB(2);
                if(anInt1054 == current_tab)
                {
                    if(anInt1054 == 3)
                        current_tab = 1;
                    else
                        current_tab = 3;
                    aBoolean1153 = true;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 246)
            {
                int i6 = inbuffer.getShortLE((byte)108);
                int i13 = inbuffer.getShort();
                int k18 = inbuffer.getShort();
                if(k18 == 65535)
                {
                    Widget.widgets[i6].anInt233 = 0;
                    packetnum = -1;
                    return true;
                } else
                {
                    ItemDefinition class8 = ItemDefinition.getItemDefinition(k18);
                    Widget.widgets[i6].anInt233 = 4;
                    Widget.widgets[i6].anInt234 = k18;
                    Widget.widgets[i6].anInt270 = class8.rotation;
                    Widget.widgets[i6].anInt271 = class8.anInt198;
                    Widget.widgets[i6].anInt269 = (class8.zoom * 100) / i13;
                    packetnum = -1;
                    return true;
                }
            }
            if(packetnum == 171)
            {
                boolean flag1 = inbuffer.getUByte() == 1;
                int j13 = inbuffer.getShort();
                Widget.widgets[j13].aBoolean266 = flag1;
                packetnum = -1;
                return true;
            }
            if(packetnum == 142)
            {
                int j6 = inbuffer.getShortLE((byte)108);
                method60(j6, (byte)6);
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt1189 = j6;
                aBoolean1153 = true;
                update_tabs = true;
                anInt857 = -1;
                aBoolean1149 = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 126)
            {
                String s1 = inbuffer.getCStr();
                int k13 = inbuffer.getShort128(true);
                Widget.widgets[k13].aString248 = s1;
                if(Widget.widgets[k13].parentid == tab_interfaces[current_tab])
                    aBoolean1153 = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 206)
            {
                anInt1287 = inbuffer.getUByte();
                anInt845 = inbuffer.getUByte();
                anInt1248 = inbuffer.getUByte();
                updatetoolbar = true;
                aBoolean1223 = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 240)
            {
                if(current_tab == 12)
                    aBoolean1153 = true;
                anInt878 = inbuffer.putShortB();
                packetnum = -1;
                return true;
            }
            if(packetnum == 8)
            {
                int k6 = inbuffer.getShortLE128((byte)-74);
                int l13 = inbuffer.getShort();
                Widget.widgets[k6].anInt233 = 1;
                Widget.widgets[k6].anInt234 = l13;
                packetnum = -1;
                return true;
            }
            if(packetnum == 122)
            {
                int l6 = inbuffer.getShortLE128((byte)-74);
                int i14 = inbuffer.getShortLE128((byte)-74);
                int i19 = i14 >> 10 & 0x1f;
                int i22 = i14 >> 5 & 0x1f;
                int l24 = i14 & 0x1f;
                Widget.widgets[l6].anInt232 = (i19 << 19) + (i22 << 11) + (l24 << 3);
                packetnum = -1;
                return true;
            }
            if(packetnum == 53)
            {
                aBoolean1153 = true;
                int i7 = inbuffer.getShort();
                Widget class9_1 = Widget.widgets[i7];
                int j19 = inbuffer.getShort();
                for(int j22 = 0; j22 < j19; j22++)
                {
                    int i25 = inbuffer.getUByte();
                    if(i25 == 255)
                        i25 = inbuffer.getIntC(true);
                    class9_1.itemarray[j22] = inbuffer.getShortLE128((byte)-74);
                    class9_1.itemamounts[j22] = i25;
                }

                for(int j25 = j19; j25 < class9_1.itemarray.length; j25++)
                {
                    class9_1.itemarray[j25] = 0;
                    class9_1.itemamounts[j25] = 0;
                }

                packetnum = -1;
                return true;
            }
            if(packetnum == 230)
            {
                int j7 = inbuffer.getShort128(true);
                int j14 = inbuffer.getShort();
                int k19 = inbuffer.getShort();
                int k22 = inbuffer.getShortLE128((byte)-74);
                Widget.widgets[j14].anInt270 = k19;
                Widget.widgets[j14].anInt271 = k22;
                Widget.widgets[j14].anInt269 = j7;
                packetnum = -1;
                return true;
            }
            if(packetnum == 221)
            {
                anInt900 = inbuffer.getUByte();
                aBoolean1153 = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 177)
            {
                aBoolean1160 = true;
                normalcam_x = inbuffer.getUByte();
                normalcam_y = inbuffer.getUByte();
                normalcam_z = inbuffer.getShort();
                normalcam_speed = inbuffer.getUByte();
                normalcam_angle = inbuffer.getUByte();
                if(normalcam_angle >= 100)
                {
                    int k7 = normalcam_x * 128 + 64;
                    int k14 = normalcam_y * 128 + 64;
                    int i20 = calculateTileHeight(k7, k14, cheight) - normalcam_z;
                    int dy = k7 - camerax;
                    int dy2 = i20 - cameraz;
                    int dx = k14 - cameray;
					/* Distance formula */
                    int d = (int)Math.sqrt(dy * dy + dx * dx);
                    camerapitch$ = (int)(Math.atan2(dy2, d) * 325.94900000000001D) & 0x7ff;
                    camerayaw$ = (int)(Math.atan2(dy, dx) * -325.94900000000001D) & 0x7ff;
                    if(camerapitch$ < 128)
                        camerapitch$ = 128;
                    if(camerapitch$ > 383)
                        camerapitch$ = 383;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 249)
            {
                anInt1046 = inbuffer.getUByte128(0);
                anInt884 = inbuffer.getShortLE128((byte)-74);
                packetnum = -1;
                return true;
            }
            if(packetnum == 65)
            {
                parseNpcUpdate(inbuffer, packetsize, 973);
                packetnum = -1;
                return true;
            }
            if(packetnum == 27)
            {
                aBoolean1256 = false;
                anInt1225 = 1;
                aString1004 = "";
                aBoolean1223 = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 187)
            {
                aBoolean1256 = false;
                anInt1225 = 2;
                aString1004 = "";
                aBoolean1223 = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 97)
            {
                int l7 = inbuffer.getShort();
                method60(l7, (byte)6);
                if(anInt1189 != -1)
                {
                    anInt1189 = -1;
                    aBoolean1153 = true;
                    update_tabs = true;
                }
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt857 = l7;
                aBoolean1149 = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 218)
            {
                int i8 = inbuffer.getShortB128LE(false);
                anInt1042 = i8;
                aBoolean1223 = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 87)
            {
                int j8 = inbuffer.getShortLE((byte)108);
                int l14 = inbuffer.getIntB((byte)41);
                configqueue[j8] = l14;
                if(configstates[j8] != l14)
                {
                    configstates[j8] = l14;
                    parseClientVarps(false, j8);
                    aBoolean1153 = true;
                    if(anInt1042 != -1)
                        aBoolean1223 = true;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 36)
            {
                int k8 = inbuffer.getShortLE((byte)108);
                byte byte0 = inbuffer.getByte();
                configqueue[k8] = byte0;
                if(configstates[k8] != byte0)
                {
                    configstates[k8] = byte0;
                    parseClientVarps(false, k8);
                    aBoolean1153 = true;
                    if(anInt1042 != -1)
                        aBoolean1223 = true;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 61)
            {
                anInt1055 = inbuffer.getUByte();
                packetnum = -1;
                return true;
            }
            if(packetnum == 200)
            {
                int l8 = inbuffer.getShort();
                int i15 = inbuffer.putShortB();
                Widget class9_4 = Widget.widgets[l8];
                class9_4.anInt257 = i15;
                if(i15 == -1)
                {
                    class9_4.anInt246 = 0;
                    class9_4.anInt208 = 0;
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 219)
            {
                if(anInt1189 != -1)
                {
                    anInt1189 = -1;
                    aBoolean1153 = true;
                    update_tabs = true;
                }
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt857 = -1;
                aBoolean1149 = false;
                packetnum = -1;
                return true;
            }
            if(packetnum == 34)
            {
                aBoolean1153 = true;
                int i9 = inbuffer.getShort();
                Widget class9_2 = Widget.widgets[i9];
                while(inbuffer.position < packetsize) 
                {
                    int j20 = inbuffer.getSmartB();
                    int i23 = inbuffer.getShort();
                    int l25 = inbuffer.getUByte();
                    if(l25 == 255)
                        l25 = inbuffer.getInt();
                    if(j20 >= 0 && j20 < class9_2.itemarray.length)
                    {
                        class9_2.itemarray[j20] = i23;
                        class9_2.itemamounts[j20] = l25;
                    }
                }
                packetnum = -1;
                return true;
            }
            if(packetnum == 105 || packetnum == 84 || packetnum == 147 || packetnum == 215 || packetnum == 4 || packetnum == 117 || packetnum == 156 || packetnum == 44 || packetnum == 160 || packetnum == 101 || packetnum == 151)
            {
                parseExtraFiles(anInt1119, inbuffer, packetnum);
                packetnum = -1;
                return true;
            }
            if(packetnum == 106)
            {
                current_tab = inbuffer.getUSpecialA(false);
                aBoolean1153 = true;
                update_tabs = true;
                packetnum = -1;
                return true;
            }
            if(packetnum == 164)
            {
                int j9 = inbuffer.getShortLE((byte)108);
                method60(j9, (byte)6);
                if(anInt1189 != -1)
                {
                    anInt1189 = -1;
                    aBoolean1153 = true;
                    update_tabs = true;
                }
                anInt1276 = j9;
                aBoolean1223 = true;
                anInt857 = -1;
                aBoolean1149 = false;
                packetnum = -1;
                return true;
            }
			packetnum = -1;
            return true;
            //signlink.reporterror("T1 - " + packetnum + "," + packetsize + " - " + anInt842 + "," + anInt843);
            //killToMainscreen(true);
        }
        catch(IOException _ex)
        {
            connectionLost(-670);
        }
        catch(Exception exception)
        {
            String s2 = "T2 - " + packetnum + "," + anInt842 + "," + anInt843 + " - " + packetsize + "," + (palettex + ((Mob) (localplayer)).palettex_stack[0]) + "," + (palettey + ((Mob) (localplayer)).palettey_stack[0]) + " - ";
            for(int j15 = 0; j15 < packetsize && j15 < 50; j15++)
                s2 = s2 + inbuffer.payload[j15] + ",";

            signlink.reporterror(s2);
            killToMainscreen(true);
        }
        return true;
    }

    public void method146(byte byte0)
    {
        anInt1265++;
        processPlayers(0, true);
        processNPCs(true, anInt882);
        processPlayers(0, false);
        processNPCs(false, anInt882);
        processProjectiles(-948);
        processGFXs(true);
        if(!aBoolean1160)
        {
            int pitch = camerapitch;
            if(anInt984 / 256 > pitch)
                pitch = anInt984 / 256;
            if(cameramovements[4] && cameratransvars4[4] + 128 > pitch)
                pitch = cameratransvars4[4] + 128;
            int yaw = camerayaw + anInt896 & 0x7ff;
            setCurrentCameraVars(pitch, yaw, 600 + pitch * 3, anInt1014, calculateTileHeight( ((Mob) (localplayer)).fineposx, ((Mob) (localplayer)).fineposy, cheight) - 50, anInt1015);
        }
        int j;
        if(!aBoolean1160)
            j = calculateCameraHeight1();
        else
            j = calculateCameraHeight2();
        int l = camerax;
        int i1 = cameraz;
        int j1 = cameray;
        int k1 = camerapitch$;
        int l1 = camerayaw$;
        for(int i2 = 0; i2 < 5; i2++)
            if(cameramovements[i2])
            {
                int j2 = (int)((Math.random() * (double)(cameratransvars[i2] * 2 + 1) - (double)cameratransvars[i2]) + Math.sin((double)cameratransvars2[i2] * ((double)cameratransvars3[i2] / 100D)) * (double)cameratransvars4[i2]);
                if(i2 == 0)
                    camerax += j2;
                if(i2 == 1)
                    cameraz += j2;
                if(i2 == 2)
                    cameray += j2;
                if(i2 == 3)
                    camerayaw$ = camerayaw$ + j2 & 0x7ff;
                if(i2 == 4)
                {
                    camerapitch$ += j2;
                    if(camerapitch$ < 128)
                        camerapitch$ = 128;
                    if(camerapitch$ > 383)
                        camerapitch$ = 383;
                }
            }

        int k2 = TriangleRasterizer.unpackcounter;
        Model.aBoolean1684 = true;
        if(byte0 != 1)
        {
            return;
        } else
        {
            Model.anInt1687 = 0;
            Model.anInt1685 = super.mouse_x - 4;
            Model.anInt1686 = super.mouse_y - 4;
            Raster.resetOutput();
            pallet.setDimensions(camerax, cameray, camerayaw$, cameraz, j, camerapitch$, false);
            pallet.method288((byte)104);
            updateMobGraphics(anInt898);
            drawMarkerOnLocation(-252);
            method37(854, k2);
            method112(8);
            toplefttext_imagefetcher.updateGraphics(4, 23680, super.graphics, 4);
            camerax = l;
            cameraz = i1;
            cameray = j1;
            camerapitch$ = k1;
            camerayaw$ = l1;
            return;
        }
    }

    public void method147(int i)
    {
        packetbuffer.putPacket(130);
        if(anInt1189 != -1)
        {
            anInt1189 = -1;
            aBoolean1153 = true;
            aBoolean1149 = false;
            update_tabs = true;
        }
        if(anInt1276 != -1)
        {
            anInt1276 = -1;
            aBoolean1223 = true;
            aBoolean1149 = false;
        }
        anInt857 = -1;
        if(i <= 0)
            packetbuffer.put(13);
    }

    public Main()
    {
        distancestrength = new int[104][104];
        anIntArray826 = new int[200];
        grounditems = new Deque[4][104][104];
        aBoolean830 = true;
        runflamecycle = false;
        aClass30_Sub2_Sub2_834 = new Buffer(new byte[5000]);
        npcs = new NPC[16384];
        updatenpcs = new int[16384];
        anInt838 = 9;
        playerremove_stack = new int[1000];
        loginbuffer = Buffer.create(1);
        aBoolean848 = true;
        anInt857 = -1;
        skillxp = new int[SkillConsts.amt_skills];
        aBoolean872 = false;
        cameratransvars = new int[5];
        anInt874 = -1;
        anInt875 = -680;
        cameramovements = new boolean[5];
        anInt877 = 1834;
        runclient = false;
        aString881 = "";
        anInt882 = -30815;
        anInt883 = 533;
        anInt884 = -1;
        aBoolean885 = false;
        aString887 = "";
        maxplayers = 2048;
        localindex = 2047;
        players = new Player[maxplayers];
        anIntArray892 = new int[maxplayers];
        playerupdate_stack = new int[maxplayers];
        appearancebuffers = new Buffer[maxplayers];
        anInt897 = 1;
        anIntArrayArray901 = new int[104][104];
        anInt902 = 0x766654;
        aByteArray912 = new byte[16384];
        aByte920 = 14;
        anInt921 = 732;
        skilllevels = new int[SkillConsts.amt_skills];
        aByte923 = 25;
        ignore_hashes = new long[100];
        aBoolean926 = false;
        anInt927 = 0x332d25;
        cameratransvars3 = new int[5];
        anIntArrayArray929 = new int[104][104];
        aCRC32_930 = new CRC32();
        anInt939 = 748;
        msgtype_stack = new int[100];
        msgprefix_stack = new String[100];
        msgbody_stack = new String[100];
        sideicons = new IndexedColorSprite[13];
        aBoolean954 = true;
        friend_hashes = new long[200];
        anInt956 = -1;
        aBoolean962 = false;
        spriteX = -1;
        spriteY = -1;
        anIntArray968 = new int[33];
        anIntArray969 = new int[256];
        cacheindexes = new CacheIndex[5];
        configstates = new int[2000];
        aBoolean972 = false;
        aByte973 = -74;
        anInt975 = 50;
        anIntArray976 = new int[anInt975];
        anIntArray977 = new int[anInt975];
        anIntArray978 = new int[anInt975];
        anIntArray979 = new int[anInt975];
        anIntArray980 = new int[anInt975];
        anIntArray981 = new int[anInt975];
        anIntArray982 = new int[anInt975];
        aStringArray983 = new String[anInt975];
        anInt985 = -1;
        hitmarks = new DirectColorSprite[20];
        anIntArray990 = new int[5];
        aBoolean991 = false;
        aBoolean994 = false;
        anInt1002 = 0x23201b;
        aString1004 = "";
        aByte1012 = 24;
        aClass19_1013 = new Deque(169);
        camerapacket_write = false;
        anInt1018 = -1;
        cameratransvars2 = new int[5];
        aBoolean1031 = false;
        mapfunction = new DirectColorSprite[100];
        anInt1042 = -1;
        aBoolean1043 = false;
        anIntArray1044 = new int[SkillConsts.amt_skills];
        configqueue = new int[2000];
        aBoolean1047 = true;
        anInt1050 = 111;
        anIntArray1052 = new int[151];
        anInt1054 = -1;
        gfxs_storage = new Deque(169);
        anIntArray1057 = new int[33];
        anInt1058 = 24869;
        aClass9_1059 = new Widget();
        mapscene = new IndexedColorSprite[100];
        anInt1063 = 0x4d4233;
        anIntArray1065 = new int[7];
        anIntArray1072 = new int[1000];
        anIntArray1073 = new int[1000];
        aBoolean1080 = false;
        anInt1081 = -733;
        friendusernames = new String[200];
        inbuffer = Buffer.create(1);
        cacheidx_crcs = new int[9];
        interfacestack_a = new int[500];
        interfacestack_b = new int[500];
        interfaceopcodestack = new int[500];
        interfacestack_c = new int[500];
        headicons = new DirectColorSprite[20];
        update_tabs = false;
        anInt1105 = 519;
        aBoolean1106 = false;
        anInt1116 = 445;
        anInt1118 = -29508;
        anInt1119 = -77;
        aString1121 = "";
        aStringArray1127 = new String[5];
        aBooleanArray1128 = new boolean[5];
        custompalette = new int[4][13][13];
        anInt1132 = 2;
        anInt1135 = -12499;
        mapfunctionstack = new DirectColorSprite[1000];
        isLoadedLandscapes = false;
        aBoolean1149 = false;
        cross_sprites = new DirectColorSprite[8];
        aBoolean1151 = true;
        aBoolean1153 = false;
        aBoolean1157 = false;
        aBoolean1158 = false;
        aBoolean1159 = false;
        aBoolean1160 = false;
        anInt1171 = 1;
        username = "";
        password = "";
        aBoolean1176 = false;
        anInt1178 = -1;
        aClass19_1179 = new Deque(169);
        camerapitch = 128;
        anInt1189 = -1;
        packetbuffer = Buffer.create(1);
        aByte1194 = 5;
        interfacestringstack = new String[500];
        cameratransvars4 = new int[5];
        aBoolean1206 = true;
        anIntArray1207 = new int[50];
        anInt1210 = 2;
        anInt1211 = 78;
        aString1212 = "";
        aByte1217 = 6;
        anInt1218 = -589;
        mod_icons = new IndexedColorSprite[2];
        current_tab = 3;
        aBoolean1223 = false;
        aBoolean1228 = true;
        anIntArray1229 = new int[151];
        collisionmaps = new CollisionMap[4];
        updatetoolbar = false;
        anIntArray1240 = new int[100];
        anIntArray1241 = new int[50];
        aBoolean1242 = false;
        anIntArray1250 = new int[50];
        aBoolean1252 = false;
        aBoolean1255 = false;
        aBoolean1256 = false;
        aString1266 = "";
        aString1267 = "";
        aByte1274 = -13;
        anInt1276 = -1;
        aBoolean1277 = true;
        anInt1279 = 2;
        walkingstepsx = new int[4000];
        walkingstepsy = new int[4000];
        anInt1289 = -1;
    }

    public int amt_ignorehashes;
    public static byte aByte823 = 77;
    public long aLong824;
    public int distancestrength[][];
    public int anIntArray826[];
    public Deque grounditems[][][];
    public int anIntArray828[];
    public int anIntArray829[];
    public boolean aBoolean830;
    public volatile boolean runflamecycle;
    public Socket jaggrab_socket;
    public int titlescreen_tab;
    public Buffer aClass30_Sub2_Sub2_834;
    public NPC npcs[];
    public int anInt836;
    public int updatenpcs[];
    public int anInt838;
    public int amtplayerremovestack;
    public int playerremove_stack[];
    public int anInt841;
    public int anInt842;
    public int anInt843;
    public String aString844;
    public int anInt845;
    public static int anInt846;
    public Buffer loginbuffer;
    public boolean aBoolean848;
    public static int anInt849;
    public int anIntArray850[];
    public int anIntArray851[];
    public int anIntArray852[];
    public int anIntArray853[];
    public static int anInt854;
    public int markertype;
    public static BigInteger aBigInteger856 = new BigInteger("981012326571499187065184668975404420604104746115327143"
                       + "425398364023255266034839499203283523268032241887665517"
                       + "949046293012131920368658499115639817773794790080727109"
                       + "055979471703170973700925588352736539966824288380022294"
                       + "088721610229958537960939017309260626929024154250671410"
                       + "78879053996044981697505716670498887731");
    public int anInt857;
    public int camerax;
    public int cameraz;
    public int cameray;
    public int camerapitch$;
    public int camerayaw$;
    public int rights;
    public int skillxp[];
    public IndexedColorSprite redstone1_3;
    public IndexedColorSprite redstone2_3;
    public IndexedColorSprite redstone3_2;
    public IndexedColorSprite redstone1_4;
    public IndexedColorSprite redstone2_4;
    public DirectColorSprite mapmarker0;
    public DirectColorSprite mapmarker1;
    public boolean aBoolean872;
    public int cameratransvars[];
    public int anInt874;
    public int anInt875;
    public boolean cameramovements[];
    public int anInt877;
    public int anInt878;
    public WatchDog watchdog;
    public volatile boolean runclient;
    public String aString881;
    public int anInt882;
    public int anInt883;
    public int anInt884;
    public boolean aBoolean885;
    public int anInt886;
    public String aString887;
    public int maxplayers;
    public int localindex;
    public Player players[];
    public int anInt891;
    public int anIntArray892[];
    public int amtplayerupdatestack;
    public int playerupdate_stack[];
    public Buffer appearancebuffers[];
    public int anInt896;
    public int anInt897;
    public int anInt898;
    public int amt_friendhashes;
    public int anInt900;
    public int anIntArrayArray901[][];
    public int anInt902;
    public ImageFetcher backleft1_imagefetcher;
    public ImageFetcher backleft2_imagefetcher;
    public ImageFetcher backright1_imagefetcher;
    public ImageFetcher backright2_imagefetcher;
    public ImageFetcher backtop1_imagefetcher;
    public ImageFetcher backvmid1_imagefetcher;
    public ImageFetcher backvmid2_imagefetcher;
    public ImageFetcher backvmid3_imagefetcher;
    public ImageFetcher backhmid2_imagefetcher;
    public byte aByteArray912[];
    public int anInt913;
    public int anInt914;
    public int anInt915;
    public int anInt916;
    public int anInt917;
    public int cheight;
    public static boolean aBoolean919 = true;
    public byte aByte920;
    public int anInt921;
    public int skilllevels[];
    public byte aByte923;
    public static int anInt924;
    public long ignore_hashes[];
    public boolean aBoolean926;
    public int anInt927;
    public int cameratransvars3[];
    public int anIntArrayArray929[][];
    public CRC32 aCRC32_930;
    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_931;
    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_932;
    public int pmarker_id;
    public int markerloc_x;
    public int markerloc_y;
    public int markerheight;
    public int markeroffset_x;
    public int markeroffset_y;
    public int anInt939;
    public static int anInt940;
    public static int anInt941;
    public int msgtype_stack[];
    public String msgprefix_stack[];
    public String msgbody_stack[];
    public int anInt945;
    public Palette pallet;
    public IndexedColorSprite sideicons[];
    public int clickarea;
    public int anInt949;
    public int anInt950;
    public int anInt951;
    public int anInt952;
    public long aLong953;
    public boolean aBoolean954;
    public long friend_hashes[];
    public int anInt956;
    public static int nodeid = 10;
    public static int portoff;
    public static boolean members = true;
    public static boolean lowmemory;
    public int anInt961;
    public volatile boolean aBoolean962;
    public int spriteX;
    public int spriteY;
    public int anIntArray965[] = {
        0xffff00, 0xff0000, 65280, 65535, 0xff00ff, 0xffffff
    };
    public IndexedColorSprite aClass30_Sub2_Sub1_Sub2_966;
    public IndexedColorSprite aClass30_Sub2_Sub1_Sub2_967;
    public int anIntArray968[];
    public int anIntArray969[];
    public CacheIndex cacheindexes[];
    public int configstates[];
    public boolean aBoolean972;
    public byte aByte973;
    public int anInt974;
    public int anInt975;
    public int anIntArray976[];
    public int anIntArray977[];
    public int anIntArray978[];
    public int anIntArray979[];
    public int anIntArray980[];
    public int anIntArray981[];
    public int anIntArray982[];
    public String aStringArray983[];
    public int anInt984;
    public int anInt985;
    public static int anInt986;
    public DirectColorSprite hitmarks[];
    public int anInt988;
    public int anInt989;
    public int anIntArray990[];
    public boolean aBoolean991;
    public int anInt992;
    public static boolean aBoolean993;
    public boolean aBoolean994;
    public int normalcam_x;
    public int normalcam_y;
    public int normalcam_z;
    public int normalcam_speed;
    public int normalcam_angle;
    public ISAAC packetencryption;
    public DirectColorSprite mapedge;
    public int anInt1002;
    public static final int anIntArrayArray1003[][] = {
        {
            6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 
            2983, 54193
        }, {
            8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 
            56621, 4783, 1341, 16578, 35003, 25239
        }, {
            25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 
            10153, 56621, 4783, 1341, 16578, 35003
        }, {
            4626, 11146, 6439, 12, 4758, 10270
        }, {
            4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574
        }
    };
    public String aString1004;
    public static int anInt1005;
    public int pastlaginamountdays;
    public int packetsize;
    public int packetnum;
    public int anInt1009;
    public int anInt1010;
    public int anInt1011;
    public byte aByte1012;
    public Deque aClass19_1013;
    public int anInt1014;
    public int anInt1015;
    public int camerapacket_delay;
    public boolean camerapacket_write;
    public int anInt1018;
    public static int levelforxp[];
    public int anInt1020;
    public int anInt1021;
    public int anInt1022;
    public int landscape_stage;
    public IndexedColorSprite scrollbar0;
    public IndexedColorSprite scrollbar1;
    public int anInt1026;
    public IndexedColorSprite backbase1;
    public IndexedColorSprite backbase2;
    public IndexedColorSprite backmid1;
    public int cameratransvars2[];
    public boolean aBoolean1031;
    public static BigInteger aBigInteger1032 = new BigInteger("65537");
    public DirectColorSprite mapfunction[];
    public int palettex;
    public int palettey;
    public int anInt1036;
    public int anInt1037;
    public int anInt1038;
    public int anInt1039;
    public int anInt1040;
    public int anInt1041;
    public int anInt1042;
    public boolean aBoolean1043;
    public int anIntArray1044[];
    public int configqueue[];
    public int anInt1046;
    public boolean aBoolean1047;
    public int anInt1048;
    public String aString1049;
    public int anInt1050;
    public static int anInt1051;
    public int anIntArray1052[];
    public ContainerArchive titlescreen_archive;
    public int anInt1054;
    public int anInt1055;
    public Deque gfxs_storage;
    public int anIntArray1057[];
    public int anInt1058;
    public Widget aClass9_1059;
    public IndexedColorSprite mapscene[];
    public static int draw_cycle;
    public int anInt1062;
    public int anInt1063;
    public int anInt1064;
    public int anIntArray1065[];
    public int moveitem_endslot;
    public int anInt1067;
    public OndemandHandler ondemandhandler;
    public int chunkx_;
    public int chunky_;
    public int mapfunctionstackpos;
    public int anIntArray1072[];
    public int anIntArray1073[];
    public DirectColorSprite grounditem_mapdotsprite;
    public DirectColorSprite mapdots1;
    public DirectColorSprite mapdots2;
    public DirectColorSprite mapdots3;
    public DirectColorSprite mapdots4;
    public int anInt1079;
    public boolean aBoolean1080;
    public int anInt1081;
    public String friendusernames[];
    public Buffer inbuffer;
    public int moveitem_frameid;
    public int moveitem_startslot;
    public int anInt1086;
    public int anInt1087;
    public int anInt1088;
    public int anInt1089;
    public int cacheidx_crcs[];
    public int interfacestack_a[];
    public int interfacestack_b[];
    public int interfaceopcodestack[];
    public int interfacestack_c[];
    public DirectColorSprite headicons[];
    public static int anInt1096 = -192;
    public static int anInt1097;
    public int spincam_x;
    public int spincam_y;
    public int spincam_z;
    public int spincam_speed;
    public int spincam_angle;
    public boolean update_tabs;
    public int anInt1104;
    public int anInt1105;
    public boolean aBoolean1106;
    public ImageFetcher logo_imagefetcher;
    public ImageFetcher bottomleftmid_imagefetcher;
    public ImageFetcher aClass15_1109;
    public ImageFetcher titletopleft_imagefetcher;
    public ImageFetcher titletopright_imagefetcher;
    public ImageFetcher aClass15_1112;
    public ImageFetcher aClass15_1113;
    public ImageFetcher aClass15_1114;
    public ImageFetcher aClass15_1115;
    public int anInt1116;
    public static int anInt1117;
    public int anInt1118;
    public int anInt1119;
    public int anInt1120;
    public String aString1121;
    public DirectColorSprite compass;
    public ImageFetcher toolbartext_imagefetcher;
    public ImageFetcher aClass15_1124;
    public ImageFetcher aClass15_1125;
    public static Player localplayer;
    public String aStringArray1127[];
    public boolean aBooleanArray1128[];
    public int custompalette[][][];
    public int tab_interfaces[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1
    };
    public int anInt1131;
    public int anInt1132;
    public int anInt1133;
    public static int anInt1134;
    public int anInt1135;
    public int anInt1136;
    public int anInt1137;
    public int anInt1138;
    public String aString1139;
    public DirectColorSprite mapfunctionstack[];
    public boolean isLoadedLandscapes;
    public static int anInt1142;
    public IndexedColorSprite redstone1;
    public IndexedColorSprite redstone2;
    public IndexedColorSprite redstone3;
    public IndexedColorSprite redstone1_2;
    public IndexedColorSprite redstone2_2;
    public int anInt1148;
    public boolean aBoolean1149;
    public DirectColorSprite cross_sprites[];
    public boolean aBoolean1151;
    public IndexedColorSprite titlescreen_sprites[];
    public boolean aBoolean1153;
    public int anInt1154;
    public static int anInt1155;
    public static boolean drawfps;
    public boolean aBoolean1157;
    public boolean aBoolean1158;
    public boolean aBoolean1159;
    public boolean aBoolean1160;
    public static int loopcycle;
    public static String passchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public ImageFetcher aClass15_1163;
    public ImageFetcher aClass15_1164;
    public ImageFetcher toplefttext_imagefetcher;
    public ImageFetcher chat_imagefetcher;
    public int anInt1167;
    public SocketHandler gameserver_sockethandler;
    public int anInt1169;
    public int anInt1170;
    public int anInt1171;
    public long aLong1172;
    public String username;
    public String password;
    public static int anInt1175;
    public boolean aBoolean1176;
    public final int object_types[] = {
        0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
        2, 2, 3
    };
    public int anInt1178;
    public Deque aClass19_1179;
    public int anIntArray1180[];
    public int anIntArray1181[];
    public int anIntArray1182[];
    public byte tilebytes[][];
    public int camerapitch;
    public int camerayaw;
    public int camerayawrate;
    public int camerayrate;
    public static int anInt1188;
    public int anInt1189;
    public int anIntArray1190[];
    public int anIntArray1191[];
    public Buffer packetbuffer;
    public int anInt1193;
    public byte aByte1194;
    public int anInt1195;
    public IndexedColorSprite invback;
    public IndexedColorSprite mapback;
    public IndexedColorSprite chatback;
    public String interfacestringstack[];
    public static byte aByte1200 = 9;
    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_1201;
    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_1202;
    public int cameratransvars4[];
    public static final int anIntArray1204[] = {
        9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 
        58654, 5027, 1457, 16565, 34991, 25486
    };
    public static boolean flagged;
    public boolean aBoolean1206;
    public int anIntArray1207[];
    public int flame_cycle;
    public int anInt1209;
    public int anInt1210;
    public int anInt1211;
    public String aString1212;
    public int anInt1213;
    public int main_heightmap[][][];
    public long ssk;
    public int userpass_swtch;
    public byte aByte1217;
    public int anInt1218;
    public IndexedColorSprite mod_icons[];
    public long lastpressed_t;
    public int current_tab;
    public int nmarker_id;
    public boolean aBoolean1223;
    public static boolean aBoolean1224 = true;
    public int anInt1225;
    public static int anInt1226;
    public int anInt1227;
    public boolean aBoolean1228;
    public int anIntArray1229[];
    public CollisionMap collisionmaps[];
    public static boolean aBoolean1231;
    public static int varbit_masks[];
    public boolean updatetoolbar;
    public int regionhashes[];
    public int anIntArray1235[];
    public int anIntArray1236[];
    public int anInt1237;
    public int anInt1238;
    public final int anInt1239 = 100;
    public int anIntArray1240[];
    public int anIntArray1241[];
    public boolean aBoolean1242;
    public int anInt1243;
    public int anInt1244;
    public int anInt1245;
    public int anInt1246;
    public byte regionbytes[][];
    public int anInt1248;
    public int anInt1249;
    public int anIntArray1250[];
    public int ontutorial_island;
    public boolean aBoolean1252;
    public int anInt1253;
    public int anInt1254;
    public boolean aBoolean1255;
    public boolean aBoolean1256;
    public int anInt1257;
    public byte main_tilesettings[][][];
    public int anInt1259;
    public static int anInt1260;
    public int anInt1261;
    public int anInt1262;
    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_1263;
    public int anInt1264;
    public int anInt1265;
    public String aString1266;
    public String aString1267;
    public int anInt1268;
    public int anInt1269;
    public RSFont p11_font;
    public RSFont p12_font;
    public RSFont b12_font;
    public RSFont q8_font;
    public byte aByte1274;
    public int anInt1275;
    public int anInt1276;
    public boolean aBoolean1277;
    public int anInt1278;
    public int anInt1279;
    public int walkingstepsx[];
    public int walkingstepsy[];
    public int anInt1282;
    public int anInt1283;
    public int anInt1284;
    public int anInt1285;
    public String aString1286;
    public int anInt1287;
    public static int stepcounters;
    public int anInt1289;
    public static int anInt1290;

    static {
        levelforxp = new int[99];
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int l = j + 1;
            int i1 = (int)((double)l + 300D * Math.pow(2D, (double)l / 7D));
            i += i1;
            levelforxp[j] = i / 4;
        }
        varbit_masks = new int[32];
        i = 2;
        for(int k = 0; k < 32; k++)
        {
            varbit_masks[k] = i - 1;
            i += i;
        }
    }
}
