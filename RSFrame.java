// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import sign.signlink;

public class RSFrame extends Frame {

    public RSFrame(RSApplet applet_sub1, int cwidth, byte junk, int cheight) {
        rs_applet = applet_sub1;
        setTitle("SiniSoul's 317 Rewrite");
        setResizable(false);
        show();
        toFront();
        resize(cwidth + 8, cheight + 28);
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        g.translate(4, 24);
        return g;
    }

    public void update(Graphics g) {
        rs_applet.update(g);
    }

    public void paint(Graphics g) {
        rs_applet.paint(g);
    }

    public RSApplet rs_applet;
}
