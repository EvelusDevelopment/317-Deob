// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.*;
import java.net.Socket;
import sign.signlink;

public class SocketWorker implements Runnable {

    public SocketWorker(ApplicationApplet applet_sub1, int i, Socket s) throws IOException {
        applet = applet_sub1;
        socket = s;
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        inputstream = socket.getInputStream();
        outputstream = socket.getOutputStream();
    }

    public void method267()
    {
        aBoolean422 = true;
        try
        {
            if(inputstream != null)
                inputstream.close();
            if(outputstream != null)
                outputstream.close();
            if(socket != null)
                socket.close();
        }
        catch(IOException _ex)
        {
            System.out.println("Error closing stream");
        }
        running = false;
        synchronized(this)
        {
            notify();
        }
        payload = null;
    }

    public int method268()
        throws IOException
    {
        if(aBoolean422)
            return 0;
        else
            return inputstream.read();
    }

    public int avail()
        throws IOException
    {
        if(aBoolean422)
            return 0;
        else
            return inputstream.available();
    }

    public void readBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        if(aBoolean422)
            return;
        int k;
        for(; j > 0; j -= k)
        {
            k = inputstream.read(abyte0, i, j);
            if(k <= 0)
                throw new IOException("EOF");
            i += k;
        }

    }

    public void writeBytes(int i, int j, byte abyte0[], int k)
        throws IOException
    {
        if(aBoolean422)
            return;
        if(aBoolean428)
        {
            aBoolean428 = false;
            throw new IOException("Error in writer thread");
        }
        if(payload == null)
            payload = new byte[5000];
        synchronized(this)
        {
            for(int l = 0; l < i; l++)
            {
                payload[offset] = abyte0[l + k];
                offset = (offset + 1) % 5000;
                if(offset == (length + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            if(!running)
            {
                running = true;
                applet.spawnThread(this, 3);
            }
            notify();
        }
        if(j != 0)
            anInt418 = 255;
    }

    public void run()
    {
        while(running)
        {
            int i;
            int j;
            synchronized(this)
            {
                if(offset == length)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(!running)
                    return;
                j = length;
                if(offset >= length)
                    i = offset - length;
                else
                    i = 5000 - length;
            }
            if(i > 0)
            {
                try
                {
                    outputstream.write(payload, j, i);
                }
                catch(IOException _ex)
                {
                    aBoolean428 = true;
                }
                length = (length + i) % 5000;
                try
                {
                    if(offset == length)
                        outputstream.flush();
                }
                catch(IOException _ex)
                {
                    aBoolean428 = true;
                }
            }
        }
    }

    public void method272(byte byte0)
    {
        if(byte0 != 1)
            anInt416 = 457;
        System.out.println("dummy:" + aBoolean422);
        System.out.println("tcycl:" + length);
        System.out.println("tnum:" + offset);
        System.out.println("writer:" + running);
        System.out.println("ioerror:" + aBoolean428);
        try
        {
            System.out.println("available:" + avail());
            return;
        }
        catch(IOException _ex)
        {
            return;
        }
    }

    public int anInt416;
    public boolean aBoolean417;
    public int anInt418;
    public InputStream inputstream;
    public OutputStream outputstream;
    public Socket socket;
    public boolean aBoolean422;
    public ApplicationApplet applet;
    public byte payload[];
    public int length;
    public int offset;
    public boolean running;
    public boolean aBoolean428;
}
