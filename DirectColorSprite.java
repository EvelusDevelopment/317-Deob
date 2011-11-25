// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.PrintStream;
import sign.signlink;

public class DirectColorSprite extends Raster {

    public DirectColorSprite(int i, int j)
    {
        pixels = new int[i * j];
        indexwidth = width$ = i;
        indexheight = height$ = j;
        offsetx = offsety = 0;
    }

    public DirectColorSprite(Component component, byte[] abyte0) {
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            indexwidth = image.getWidth(component);
            indexheight = image.getHeight(component);
            width$ = indexwidth;
            height$ = indexheight;
            offsetx = 0;
            offsety = 0;
            pixels = new int[indexwidth * indexheight];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, indexwidth, indexheight, pixels, 0, indexwidth);
            pixelgrabber.grabPixels();
            return;
        } catch(Exception _ex) {
            System.out.println("Error converting jpg");
        }
    }

    public DirectColorSprite(ContainerArchive class44, String s, int i)
    {
        System.out.println(s);
        aBoolean1428 = false;
        anInt1429 = 24869;
        anInt1431 = -32357;
        aByte1432 = 3;
        aBoolean1433 = false;
        anInt1434 = -388;
        aBoolean1435 = false;
        aBoolean1436 = true;
        aBoolean1437 = true;
        aBoolean1438 = false;
        Buffer main = new Buffer(class44.getEntry(s + ".dat", null));
        Buffer index = new Buffer(class44.getEntry("index.dat", null));
        index.position = main.getShort();
        width$ = index.getShort();
        height$ = index.getShort();
        int j = index.getUByte();
        int colors[] = new int[j];
        for(int k = 0; k < j - 1; k++)
        {
            colors[k + 1] = (index.getTri() & 0xFFFFFF);
            if(colors[k + 1] == 0)
                colors[k + 1] = 1;
        }

        for(int l = 0; l < i; l++)
        {
            index.position += 2;
            main.position += index.getShort() * index.getShort();
            index.position++;
        }

        offsetx = index.getUByte();
        offsety = index.getUByte();
        indexwidth = index.getShort();
        indexheight = index.getShort();
        int type = index.getUByte();
        int size = indexwidth * indexheight;
        pixels = new int[size];
	/* Horizontal */
        if(type == 0)
        {
            for(int k1 = 0; k1 < size; k1++)
                pixels[k1] = colors[main.getUByte()];
            return;
        }
	/* Vertical */
        if(type == 1)
        {
            for(int w = 0; w < indexwidth; w++)
            {
                for(int h = 0; h < indexheight; h++) {
                    int test = colors[main.getUByte()];
                    pixels[w + (h * indexwidth)] = test;
                }
            }
        }
    }

    public void setOutput()
    {
        Raster.setOutput(indexheight, indexwidth, pixels);
    }

    public void intensifyPixels(int r, int g, int b)
    {
        for(int i = 0; i < pixels.length; i++)
        {
            int color = pixels[i];
            if(color != 0)
            {
                int k1 = color >> 16 & 0xff;
                k1 += r;
                if(k1 < 1)
                    k1 = 1;
                else
                if(k1 > 255)
                    k1 = 255;
                int l1 = color >> 8 & 0xff;
                l1 += g;
                if(l1 < 1)
                    l1 = 1;
                else
                if(l1 > 255)
                    l1 = 255;
                int i2 = color & 0xff;
                i2 += b;
                if(i2 < 1)
                    i2 = 1;
                else
                if(i2 > 255)
                    i2 = 255;
                pixels[i] = (k1 << 16) + (l1 << 8) + i2;
            }
        }

    }

    public void finalizeImage()
    {
        int pixarray[] = new int[width$ * height$];
        for(int y = 0; y < indexheight; y++)
        {
            for(int x = 0; x < indexwidth; x++)
                pixarray[(y + offsety) * width$ + (x + offsetx)] = pixarray[y * indexwidth + x];

        }
        pixels = pixarray;
        indexwidth = width$;
        indexheight = height$;
        offsetx = 0;
        offsety = 0;
    }

    public void draw(int x, int y)
    {
        x += offsetx;
        y += offsety;
        int outoffset = x + y * Raster.outputwidth;
        int srcoffset = 0;
        int h = indexheight;
        int w = indexwidth;
        int srcinc = Raster.outputwidth - w;
        int outinc = 0;
        if(y < Raster.heightoffset)
        {
            int j2 = Raster.heightoffset - y;
            h -= j2;
            y = Raster.heightoffset;
            srcoffset += j2 * w;
            outoffset += j2 * Raster.outputwidth;
        }
        if(y + h > Raster.height)
            h -= (y + h) - Raster.height;
        if(x < Raster.widthoffset)
        {
            int k2 = Raster.widthoffset - x;
            w -= k2;
            x = Raster.widthoffset;
            srcoffset += k2;
            outoffset += k2;
            outinc += k2;
            srcinc += k2;
        }
        if(x + w > Raster.width)
        {
            int l2 = (x + w) - Raster.width;
            w -= l2;
            outinc += l2;
            srcinc += l2;
        }
        if(w <= 0 || h <= 0)
        {
            return;
        } else
        {
            draw(Raster.output,pixels, outoffset, srcoffset, srcinc, outinc, w, h);
            return;
        }
    }

    public void draw(int[] out, int[] src, int outoffset, int srcoffset, int outheight, int srcheight, int width, int height) {
        int widthoffset0 = -(width >> 2);
        width = -(width & 3);
        for(int i = -height; i < 0; i++) {
            for(int j = widthoffset0; j < 0; j++) {
                out[outoffset++] = src[srcoffset++];
                out[outoffset++] = src[srcoffset++];
                out[outoffset++] = src[srcoffset++];
                out[outoffset++] = src[srcoffset++];
            }
            for(int k = width; k < 0; k++)
                out[outoffset++] = src[srcoffset++];
            outoffset += outheight;
            srcoffset += srcheight;
        }
    }

    public void drawOverlay(int i, int j, int k)
    {
        i += offsetx;
        k += offsety;
        if(j != 16083)
            return;
        int l = i + k * Raster.outputwidth;
        int i1 = 0;
        int j1 = indexheight;
        int k1 = indexwidth;
        int l1 = Raster.outputwidth - k1;
        int i2 = 0;
        if(k < Raster.heightoffset)
        {
            int j2 = Raster.heightoffset - k;
            j1 -= j2;
            k = Raster.heightoffset;
            i1 += j2 * k1;
            l += j2 * Raster.outputwidth;
        }
        if(k + j1 > Raster.height)
            j1 -= (k + j1) - Raster.height;
        if(i < Raster.widthoffset)
        {
            int k2 = Raster.widthoffset - i;
            k1 -= k2;
            i = Raster.widthoffset;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 > Raster.width)
        {
            int l2 = (i + k1) - Raster.width;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(k1 <= 0 || j1 <= 0)
        {
            return;
        } else
        {
            drawOverlay(Raster.output, pixels, 0, i1, l, k1, j1, l1, i2);
            return;
        }
    }

    public void drawOverlay(int out[], int src[], int color, int srcoffset, int outoffset, int width, int i1, int outheight, int srcheight) {
        int widthoffset0 = -(width >> 2);
        width = -(width & 3);
        for(int i2 = -i1; i2 < 0; i2++)
        {
            for(int j2 = widthoffset0; j2 < 0; j2++)
            {
                color = src[srcoffset++];
                if(color != 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
                color = src[srcoffset++];
                if(color != 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
                color = src[srcoffset++];
                if(color != 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
                color = src[srcoffset++];
                if(color != 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
            }

            for(int k2 = width; k2 < 0; k2++)
            {
                color = src[srcoffset++];
                if(color != 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
            }

            outoffset += outheight;
            srcoffset += srcheight;
        }

    }

    public void drawBlended(int x, int y, int k, boolean flag)
    {
        x += offsetx;
        y += offsety;
        int i1 = x + y * Raster.outputwidth;
        int j1 = 0;
        int indexh = indexheight;
        int indexw = indexwidth;
        int i2 = Raster.outputwidth - indexw;
        int j2 = 0;
        if(y < Raster.heightoffset)
        {
            int k2 = Raster.heightoffset - y;
            indexh -= k2;
            y = Raster.heightoffset;
            j1 += k2 * indexw;
            i1 += k2 * Raster.outputwidth;
        }
        if(y + indexh > Raster.height)
            indexh -= (y + indexh) - Raster.height;
        if(x < Raster.widthoffset)
        {
            int l2 = Raster.widthoffset - x;
            indexw -= l2;
            x = Raster.widthoffset;
            j1 += l2;
            i1 += l2;
            j2 += l2;
            i2 += l2;
        }
        if(x + indexw > Raster.width)
        {
            int i3 = (x + indexw) - Raster.width;
            indexw -= i3;
            j2 += i3;
            i2 += i3;
        }
        if(indexw <= 0 || indexh <= 0)
        {
            return;
        } else
        {
            drawBlended(j1, indexw, Raster.output, 0, pixels, j2, indexh, i2, k, i1, 8);
            return;
        }
    }

    public void drawBlended(int srcoffset, int width, int out[], int srccolor, int src[], int srcheight, int height, int outheight, int alpha, int outoffset, int i2)
    {
        int outalpha = 256 - alpha;
        for(int k2 = -height; k2 < 0; k2++)
        {
            for(int l2 = -width; l2 < 0; l2++)
            {
                srccolor = src[srcoffset++];
                if(srccolor != 0)
                {
                    int outcolor = out[outoffset];
                    out[outoffset++] = ((srccolor & 0xff00ff) * alpha + (outcolor & 0xff00ff) * outalpha & 0xff00ff00) + ((srccolor & 0xff00) * alpha + (outcolor & 0xff00) * outalpha & 0xff0000) >> 8;
                } else
                {
                    outoffset++;
                }
            }

            outoffset += outheight;
            srcoffset += srcheight;
        }
    }

    public void drawRotatedDegrees(int i, int j, int ai[], int k, int ai1[], int l, int i1,
            int y, int x, int l1, int i2)
    {
        while(l >= 0) 
            anInt1434 = 362;
        try
        {
            int j2 = -l1 / 2;
            int k2 = -i / 2;
            int sine = (int)(Math.sin((double)j / 326.11000000000001D) * 65536D);
            int cosine = (int)(Math.cos((double)j / 326.11000000000001D) * 65536D);
            sine = sine * k >> 8;
            cosine = cosine * k >> 8;
            int j3 = (i2 << 16) + (k2 * sine + j2 * cosine);
            int k3 = (i1 << 16) + (k2 * cosine - j2 * sine);
            int offset = x + y * Raster.outputwidth;
            for(y = 0; y < i; y++)
            {
                int i4 = ai1[y];
                int j4 = offset + i4;
                int ox = j3 + cosine * i4;
                int oy = k3 - sine * i4;
                for(x = -ai[y]; x < 0; x++)
                {
                    Raster.output[j4++] = pixels[(ox >> 16) + (oy >> 16) * indexwidth];
                    ox += cosine;
                    oy -= sine;
                }
                j3 += sine;
                k3 += cosine;
                offset += Raster.outputwidth;
            }

            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public void drawRotatedRadians(int y, int j, int k, int l, int i1, int j1, int k1, double rotation, int x) {
        try
        {
            int i2 = -k / 2;
            int j2 = -k1 / 2;
            int k2 = (int)(Math.sin(rotation) * 65536D);
            int l2 = (int)(Math.cos(rotation) * 65536D);
            k2 = k2 * j1 >> 8;
            l2 = l2 * j1 >> 8;
            int i3 = (l << 16) + (j2 * k2 + i2 * l2);
            int j3 = (j << 16) + (j2 * l2 - i2 * k2);
            int offset = x + y * Raster.outputwidth;
            for(y = 0; y < k1; y++)
            {
                int o = offset;
                int ox = i3;
                int oy = j3;
                for(x = -k; x < 0; x++)
                {
                    int k4 = pixels[(ox >> 16) + (oy >> 16) * indexwidth];
                    if(k4 != 0)
                        Raster.output[o++] = k4;
                    else
                        o++;
                    ox += l2;
                    oy -= k2;
                }

                i3 += k2;
                j3 += l2;
                offset += Raster.outputwidth;
            }

            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public void renderImage(IndexedColorSprite class30_sub2_sub1_sub2, boolean flag, int i, int j)
    {
        j += offsetx;
        i += offsety;
        int k = j + i * Raster.outputwidth;
        int l = 0;
        if(flag)
            anInt1429 = -364;
        int i1 = indexheight;
        int j1 = indexwidth;
        int k1 = Raster.outputwidth - j1;
        int l1 = 0;
        if(i < Raster.heightoffset)
        {
            int i2 = Raster.heightoffset - i;
            i1 -= i2;
            i = Raster.heightoffset;
            l += i2 * j1;
            k += i2 * Raster.outputwidth;
        }
        if(i + i1 > Raster.height)
            i1 -= (i + i1) - Raster.height;
        if(j < Raster.widthoffset)
        {
            int j2 = Raster.widthoffset - j;
            j1 -= j2;
            j = Raster.widthoffset;
            l += j2;
            k += j2;
            l1 += j2;
            k1 += j2;
        }
        if(j + j1 > Raster.width)
        {
            int k2 = (j + j1) - Raster.width;
            j1 -= k2;
            l1 += k2;
            k1 += k2;
        }
        if(j1 <= 0 || i1 <= 0)
        {
            return;
        } else
        {
            drawIndexedOverlay(pixels, j1, class30_sub2_sub1_sub2.colorindex, i1, Raster.output, 0, k1, k, l1, l);
            return;
        }
    }

    public void drawIndexedOverlay(int src[], int width, byte index[], int height, int out[], int color, int outheight, int outoffset, int srcheight, int srcoffset)
    {
        int widthoffset0 = -(width >> 2);
        width = -(width & 3);
        for(int j2 = -height; j2 < 0; j2++)
        {
            for(int k2 = widthoffset0; k2 < 0; k2++)
            {
                color = src[srcoffset++];
                if(color != 0 && index[outoffset] == 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
                color = src[srcoffset++];
                if(color != 0 && index[outoffset] == 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
                color = src[srcoffset++];
                if(color != 0 && index[outoffset] == 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
                color = src[srcoffset++];
                if(color != 0 && index[outoffset] == 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
            }

            for(int l2 = width; l2 < 0; l2++)
            {
                color = src[srcoffset++];
                if(color != 0 && index[outoffset] == 0)
                    out[outoffset++] = color;
                else
                    outoffset++;
            }

            outoffset += outheight;
            srcoffset += srcheight;
        }

    }

    public boolean aBoolean1428;
    public int anInt1429;
    public int anInt1430;
    public int anInt1431;
    public byte aByte1432;
    public boolean aBoolean1433;
    public int anInt1434;
    public boolean aBoolean1435;
    public boolean aBoolean1436;
    public boolean aBoolean1437;
    public boolean aBoolean1438;
    public int pixels[];
    public int indexwidth;
    public int indexheight;
    public int offsetx;
    public int offsety;
    public int width$;
    public int height$;
}
