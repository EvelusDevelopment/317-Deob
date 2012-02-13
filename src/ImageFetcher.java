// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.*;
import java.io.PrintStream;
import sign.signlink;

public class ImageFetcher implements ImageProducer, ImageObserver {

    public ImageFetcher(int i, int j, Component component, int junk) {
        width = i;
        height = j;
        pixels = new int[i * j];
        rgbmodel = new DirectColorModel(32, 0xff0000, 0x00ff00, 0x0000ff);
        image = component.createImage(this);
        finalizeImage();
        component.prepareImage(image, this);
        finalizeImage();
        component.prepareImage(image, this);
        finalizeImage();
        component.prepareImage(image, this);
        initialize(0);
    }

    public void initialize(int i) {
        BasicRasterizer.setOutput(height, width, pixels);
    }

    public void updateGraphics(int y, int junk, Graphics graphics, int x)
    {
        finalizeImage();
        graphics.drawImage(image, x, y, this);
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer)
    {
        consumer = imageconsumer;
        imageconsumer.setDimensions(width, height);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(rgbmodel);
        imageconsumer.setHints(14);
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer)
    {
        return consumer == imageconsumer;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer)
    {
        if(consumer == imageconsumer)
            consumer = null;
    }

    public void startProduction(ImageConsumer imageconsumer)
    {
        addConsumer(imageconsumer);
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer)
    {
        System.out.println("TDLR");
    }

    public synchronized void finalizeImage()
    {
        if(consumer == null)
        {
            return;
        } else
        {
            consumer.setPixels(0, 0, width, height, rgbmodel, pixels, 0, width);
            consumer.imageComplete(2);
            return;
        }
    }

    public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1)
    {
        return true;
    }

    public int pixels[];
    public int width;
    public int height;
    public ColorModel rgbmodel;
    public ImageConsumer consumer;
    public Image image;
}
