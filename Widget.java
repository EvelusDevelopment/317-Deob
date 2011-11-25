// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class Widget {

    public void initializeWidgets(int i, byte byte0, int j) {
        int k = itemarray[i];
        itemarray[i] = itemarray[j];
        itemarray[j] = k;
        k = itemamounts[i];
        itemamounts[i] = itemamounts[j];
        itemamounts[j] = k;
    }

    public static void unpackWidgets(ContainerArchive widgetarchive, RSFont fonts[], ContainerArchive spritearchive)
    {
        aClass12_238 = new Cache(false, 50000);
        Buffer buffer0 = new Buffer(widgetarchive.getEntry("data", null));
        int i = -1;
        int j = buffer0.getShort();
        widgets = new Widget[j];	
        while(buffer0.position < buffer0.payload.length) 
        {
            int k = buffer0.getShort();
            if(k == 65535)
            {
                i = buffer0.getShort();
                k = buffer0.getShort();
            }
            Widget widget = widgets[k] = new Widget();
            widget.widgetid = k;
            widget.parentid = i;
            widget.widgettype = buffer0.getUByte();
            widget.textfieldtype = buffer0.getUByte();
            widget.actioncode = buffer0.getShort();
            widget.width = buffer0.getShort();
            widget.height = buffer0.getShort();
            widget.oalpha = (byte)buffer0.getUByte();
            widget.anInt230 = buffer0.getUByte();
            if(widget.anInt230 != 0)
                widget.anInt230 = (widget.anInt230 - 1 << 8) + buffer0.getUByte();
            else
                widget.anInt230 = -1;
            int i1 = buffer0.getUByte();
            if(i1 > 0)
            {
                widget.updateconditions = new int[i1];
                widget.updatestates = new int[i1];
                for(int j1 = 0; j1 < i1; j1++)
                {
                    widget.updateconditions[j1] = buffer0.getUByte();
                    widget.updatestates[j1] = buffer0.getShort();
                }

            }
            int k1 = buffer0.getUByte();
            if(k1 > 0)
            {
                widget.anIntArrayArray226 = new int[k1][];
                for(int l1 = 0; l1 < k1; l1++)
                {
                    int i3 = buffer0.getShort();
                    widget.anIntArrayArray226[l1] = new int[i3];
                    for(int l4 = 0; l4 < i3; l4++)
                        widget.anIntArrayArray226[l1][l4] = buffer0.getShort();

                }

            }
            if(widget.widgettype == 0)
            {
                widget.anInt261 = buffer0.getShort();
                widget.aBoolean266 = buffer0.getUByte() == 1;
                int amountchildren = buffer0.getShort();
                widget.childrenwidgets = new int[amountchildren];
                widget.positionx = new int[amountchildren];
                widget.positiony = new int[amountchildren];
                for(int g = 0; g < amountchildren; g++)
                {
                    widget.childrenwidgets[g] = buffer0.getShort();
                    widget.positionx[g] = buffer0.putShortB();
                    widget.positiony[g] = buffer0.putShortB();
                }

            }
            /* Dummy widget */
            if(widget.widgettype == 1)
            {
                widget.anInt211 = buffer0.getShort();
                widget.aBoolean251 = buffer0.getUByte() == 1;
            }
            if(widget.widgettype == 2)
            {
                widget.itemarray = new int[widget.width * widget.height];
                widget.itemamounts = new int[widget.width * widget.height];
                widget.aBoolean259 = buffer0.getUByte() == 1;
                widget.aBoolean249 = buffer0.getUByte() == 1;
                widget.aBoolean242 = buffer0.getUByte() == 1;
                widget.aBoolean235 = buffer0.getUByte() == 1;
                widget.anInt231 = buffer0.getUByte();
                widget.anInt244 = buffer0.getUByte();
                widget.anIntArray215 = new int[20];
                widget.anIntArray247 = new int[20];
                widget.sprites = new DirectColorSprite[20];
                for(int j2 = 0; j2 < 20; j2++)
                {
                    int k3 = buffer0.getUByte();
                    if(k3 == 1)
                    {
                        widget.anIntArray215[j2] = buffer0.putShortB();
                        widget.anIntArray247[j2] = buffer0.putShortB();
                        String s1 = buffer0.getCStr();
                        if(spritearchive != null && s1.length() > 0)
                        {
                            int i5 = s1.lastIndexOf(",");
                            widget.sprites[j2] = getInterfaceSprite(Integer.parseInt(s1.substring(i5 + 1)), spritearchive, s1.substring(0, i5));
                        }
                    }
                }

                widget.itemoptions = new String[5];
                for(int l3 = 0; l3 < 5; l3++)
                {
                    widget.itemoptions[l3] = buffer0.getCStr();
                    if(widget.itemoptions[l3].length() == 0)
                        widget.itemoptions[l3] = null;
                }

            }
            if(widget.widgettype == 3)
                widget.aBoolean227 = buffer0.getUByte() == 1;
            if(widget.widgettype == 4 || widget.widgettype == 1)
            {
                widget.centerx = buffer0.getUByte() == 1;
                int k2 = buffer0.getUByte();
                if(fonts != null)
                    widget.itemfont = fonts[k2];
                widget.shadowtext = buffer0.getUByte() == 1;
            }
            if(widget.widgettype == 4)
            {
                widget.aString248 = buffer0.getCStr();
                widget.hiddentext = buffer0.getCStr();
            }
            if(widget.widgettype == 1 || widget.widgettype == 3 || widget.widgettype == 4)
                widget.anInt232 = buffer0.getInt();
            if(widget.widgettype == 3 || widget.widgettype == 4)
            {
                widget.anInt219 = buffer0.getInt();
                widget.anInt216 = buffer0.getInt();
                widget.anInt239 = buffer0.getInt();
            }
            if(widget.widgettype == 5)
            {
                String s = buffer0.getCStr();
                if(spritearchive != null && s.length() > 0)
                {
                    int i4 = s.lastIndexOf(",");
                    widget.aClass30_Sub2_Sub1_Sub1_207 = getInterfaceSprite(Integer.parseInt(s.substring(i4 + 1)), spritearchive, s.substring(0, i4));
                }
                s = buffer0.getCStr();
                if(spritearchive != null && s.length() > 0)
                {
                    int j4 = s.lastIndexOf(",");
                    widget.aClass30_Sub2_Sub1_Sub1_260 = getInterfaceSprite(Integer.parseInt(s.substring(j4 + 1)), spritearchive, s.substring(0, j4));
                }
            }
            if(widget.widgettype == 6)
            {
                int l = buffer0.getUByte();
                if(l != 0)
                {
                    widget.anInt233 = 1;
                    widget.anInt234 = (l - 1 << 8) + buffer0.getUByte();
                }
                l = buffer0.getUByte();
                if(l != 0)
                {
                    widget.anInt255 = 1;
                    widget.anInt256 = (l - 1 << 8) + buffer0.getUByte();
                }
                l = buffer0.getUByte();
                if(l != 0)
                    widget.anInt257 = (l - 1 << 8) + buffer0.getUByte();
                else
                    widget.anInt257 = -1;
                l = buffer0.getUByte();
                if(l != 0)
                    widget.anInt258 = (l - 1 << 8) + buffer0.getUByte();
                else
                    widget.anInt258 = -1;
                widget.anInt269 = buffer0.getShort();
                widget.anInt270 = buffer0.getShort();
                widget.anInt271 = buffer0.getShort();
            }
            if(widget.widgettype == 7)
            {
                widget.itemarray = new int[widget.width * widget.height];
                widget.itemamounts = new int[widget.width * widget.height];
                widget.centerx = buffer0.getUByte() == 1;
                int fontid = buffer0.getUByte();
                if(fonts != null)
                    widget.itemfont = fonts[fontid];
                widget.shadowtext = buffer0.getUByte() == 1;
                widget.anInt232 = buffer0.getInt();
                widget.anInt231 = buffer0.putShortB();
                widget.anInt244 = buffer0.putShortB();
                widget.aBoolean249 = buffer0.getUByte() == 1;
                widget.itemoptions = new String[5];
                for(int k4 = 0; k4 < 5; k4++)
                {
                    widget.itemoptions[k4] = buffer0.getCStr();
                    if(widget.itemoptions[k4].length() == 0)
                        widget.itemoptions[k4] = null;
                }
            }
            if(widget.textfieldtype == 2 || widget.widgettype == 2)
            {
                widget.aString222 = buffer0.getCStr();
                widget.aString218 = buffer0.getCStr();
                widget.anInt237 = buffer0.getShort();
            }
            if(widget.textfieldtype == 1 || widget.textfieldtype == 4 || widget.textfieldtype == 5 || widget.textfieldtype == 6)
            {
                widget.aString221 = buffer0.getCStr();
                if(widget.aString221.length() == 0)
                {
                    if(widget.textfieldtype == 1)
                        widget.aString221 = "Ok";
                    if(widget.textfieldtype == 4)
                        widget.aString221 = "Select";
                    if(widget.textfieldtype == 5)
                        widget.aString221 = "Select";
                    if(widget.textfieldtype == 6)
                        widget.aString221 = "Continue";
                }
            }
        }
        aClass12_238 = null;
    }

    public Model getEntityOnChild(int i, int j)
    {
        Model class30_sub2_sub4_sub6 = (Model)aClass12_264.method222((i << 16) + j);
        if(class30_sub2_sub4_sub6 != null)
            return class30_sub2_sub4_sub6;
        if(i == 1)
            class30_sub2_sub4_sub6 = Model.getModel(anInt213, j);
        if(i == 2)
            class30_sub2_sub4_sub6 = NPCDefinition.getNPCDefinition(j).method160(true);
        if(i == 3)
            class30_sub2_sub4_sub6 = Main.localplayer.method453((byte)-41);
        if(i == 4)
            class30_sub2_sub4_sub6 = ItemDefinition.getItemDefinition(j).method202(50, true);
        if(i == 5)
            class30_sub2_sub4_sub6 = null;
        if(class30_sub2_sub4_sub6 != null)
            aClass12_264.method223(class30_sub2_sub4_sub6, (i << 16) + j, (byte)2);
        return class30_sub2_sub4_sub6;
    }

    public static DirectColorSprite getInterfaceSprite(int id, ContainerArchive archive, String name)
    {
        long hash = (TextUtils.hashString((byte)1, name) << 8) + (long) id;
        DirectColorSprite sprite = (DirectColorSprite) aClass12_238.method222(hash);
        if(sprite != null)
            return sprite;
        try
        {
            sprite = new DirectColorSprite(archive, name, id);
            aClass12_238.method223(sprite, hash, (byte) 2);
        }
        catch(Exception _ex)
        {
            return null;
        }
        return sprite;
    }

    public static void method208(int c, boolean flag, int a, Model model)
    {
        if(flag)
            return;
        aClass12_264.clear();
        if(model != null && a != 4)
            aClass12_264.method223(model, (a << 16) + c, (byte)2);
    }

    public Model method209(int i, int j, int k, boolean flag)
    {
        Model model0;
        if(flag)
            model0 = getEntityOnChild(anInt255, anInt256);
        else
            model0 = getEntityOnChild(anInt233, anInt234);
        if(model0 == null)
            return null;
        if(k == -1 && j == -1 && model0.trianglecolors == null)
            return model0;
        Model model1 = new Model(model0,true, AnimFrame.method532(k, false) & AnimFrame.method532(j, false), false);
        if(k != -1 || j != -1)
            model1.setVertexTriangleGroups();
        if(k != -1)
            model1.applyAnimationFrame(k);
        if(j != -1)
            model1.applyAnimationFrame(j);
        model1.setLightingVectors(64, 768, -50, -10, -50, true);
        if(i != 0)
            throw new NullPointerException();
        else
            return model1;
    }

    public Widget()
    {
        anInt213 = 9;
        anInt229 = 891;
    }

    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_207;
    public int anInt208;
    public DirectColorSprite sprites[];
    public static Widget widgets[];
    public int anInt211;
    public int updatestates[];
    public int anInt213;
    public int actioncode;
    public int anIntArray215[];
    public int anInt216;
    public int textfieldtype;
    public String aString218;
    public int anInt219;
    public int width;
    public String aString221;
    public String aString222;
    public boolean centerx;
    public int anInt224;
    public String itemoptions[];
    public int anIntArrayArray226[][];
    public boolean aBoolean227;
    public String hiddentext;
    public int anInt229;
    public int anInt230;
    public int anInt231;
    public int anInt232;
    public int anInt233;
    public int anInt234;
    public boolean aBoolean235;
    public int parentid;
    public int anInt237;
    public static Cache aClass12_238;
    public int anInt239;
    public int childrenwidgets[];
    public int positionx[];
    public boolean aBoolean242;
    public RSFont itemfont;
    public int anInt244;
    public int updateconditions[];
    public int anInt246;
    public int anIntArray247[];
    public String aString248;
    public boolean aBoolean249;
    public int widgetid;
    public boolean aBoolean251;
    public int itemamounts[];
    public int itemarray[];
    public byte oalpha;
    public int anInt255;
    public int anInt256;
    public int anInt257;
    public int anInt258;
    public boolean aBoolean259;
    public DirectColorSprite aClass30_Sub2_Sub1_Sub1_260;
    public int anInt261;
    public int widgettype;
    public int anInt263;
    public static Cache aClass12_264 = new Cache(false, 30);
    public int anInt265;
    public boolean aBoolean266;
    public int height;
    public boolean shadowtext;
    public int anInt269;
    public int anInt270;
    public int anInt271;
    public int positiony[];

}
